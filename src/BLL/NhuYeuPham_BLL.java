package BLL;

import DAO.NhuYeuPham_DAO;
import DTO.NhuYeuPham_DTO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NhuYeuPham_BLL {
    private final NhuYeuPham_DAO nypDAO;
    private ArrayList<NhuYeuPham_DTO> nypList;
    
    public NhuYeuPham_BLL() {
        nypDAO = new NhuYeuPham_DAO();
        refreshData();
    }
    
    // Làm mới dữ liệu từ database
    public void refreshData() {
        this.nypList = new ArrayList<>(nypDAO.getAll());
    }
    
    // Thêm mới với đầy đủ validation
    public synchronized boolean insert(NhuYeuPham_DTO nyp) {
        if (!validateNYP(nyp)) {
            throw new IllegalArgumentException("Dữ liệu không hợp lệ");
        }
        
        if (isExpired(nyp.getHanSuDung())) {
            throw new IllegalStateException("Không thể thêm hàng hết hạn");
        }
        
        if (isMaNYPExist(nyp.getMaNhuYeuPham())) {
            throw new IllegalArgumentException("Mã " + nyp.getMaNhuYeuPham() + " đã tồn tại");
        }
        
        boolean result = nypDAO.insert(nyp);
        if (result) {
            nypList.add(nyp);
            Collections.sort(nypList, Comparator.comparing(NhuYeuPham_DTO::getMaNhuYeuPham));
        }
        return result;
    }
    
    // Cập nhật với transaction
    public synchronized boolean update(NhuYeuPham_DTO nyp) {
        if (!validateNYP(nyp)) {
            return false;
        }
        
        boolean result = nypDAO.update(nyp);
        if (result) {
            int index = findIndexById(nyp.getMaNhuYeuPham());
            if (index != -1) {
                nypList.set(index, nyp);
            } else {
                refreshData();
            }
        }
        return result;
    }
    
    // Xóa với kiểm tra ràng buộc
    public synchronized boolean delete(String maNYP) {
        if (maNYP == null || maNYP.trim().isEmpty()) {
            return false;
        }
        
        boolean result = nypDAO.delete(maNYP);
        if (result) {
            nypList.removeIf(item -> item.getMaNhuYeuPham().equals(maNYP));
        }
        return result;
    }
    
    // Tìm kiếm theo nhiều tiêu chí
    public ArrayList<NhuYeuPham_DTO> search(String keyword, String searchType) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>(nypList);
        }
        
        String lowerKeyword = keyword.toLowerCase();
        return nypList.stream()
            .filter(item -> {
                switch (searchType) {
                    case "MA":
                        return item.getMaNhuYeuPham().toLowerCase().contains(lowerKeyword);
                    case "TEN":
                        return item.getTenNhuYeuPham().toLowerCase().contains(lowerKeyword);
                    case "NCC":
                        return item.getNhaCungCap().toLowerCase().contains(lowerKeyword);
                    default:
                        return item.getMaNhuYeuPham().toLowerCase().contains(lowerKeyword) ||
                               item.getTenNhuYeuPham().toLowerCase().contains(lowerKeyword);
                }
            })
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Lấy hàng sắp hết hạn (sắp xếp theo ngày)
    public ArrayList<NhuYeuPham_DTO> getSapHetHan(int daysBefore) {
        LocalDate today = LocalDate.now();
        LocalDate warningDate = today.plusDays(daysBefore);
        
        return nypList.stream()
            .filter(item -> item.getHanSuDung() != null)
            .filter(item -> {
                LocalDate expiryDate = item.getHanSuDung().toLocalDate();
                return expiryDate.isAfter(today) && expiryDate.isBefore(warningDate);
            })
            .sorted(Comparator.comparing(NhuYeuPham_DTO::getHanSuDung))
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Các phương thức hỗ trợ
    private int findIndexById(String maNYP) {
        for (int i = 0; i < nypList.size(); i++) {
            if (nypList.get(i).getMaNhuYeuPham().equals(maNYP)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isMaNYPExist(String maNYP) {
        return nypList.stream().anyMatch(item -> item.getMaNhuYeuPham().equals(maNYP));
    }
    
    private boolean validateNYP(NhuYeuPham_DTO nyp) {
        return nyp != null &&
               nyp.getMaNhuYeuPham() != null &&
               !nyp.getMaNhuYeuPham().trim().isEmpty() &&
               nyp.getTenNhuYeuPham() != null &&
               !nyp.getTenNhuYeuPham().trim().isEmpty() &&
               nyp.getGiaNhap() > 0 &&
               nyp.getNhaCungCap() != null &&
               !nyp.getNhaCungCap().trim().isEmpty();
    }
    
    private boolean isExpired(Date expiryDate) {
        if (expiryDate == null) return false;
        return expiryDate.before(new Date(System.currentTimeMillis()));
    }
}
