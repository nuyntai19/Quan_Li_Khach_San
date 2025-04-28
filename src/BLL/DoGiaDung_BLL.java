package BLL;

import DAO.DoGiaDung_DAO;
import DTO.DoGiaDung_DTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DoGiaDung_BLL {
    private final DoGiaDung_DAO dgdDAO;
    private ArrayList<DoGiaDung_DTO> dgdList;
    
    public DoGiaDung_BLL() {
        dgdDAO = new DoGiaDung_DAO();
        refreshData();
    }
    
    public void refreshData() {
        this.dgdList = new ArrayList<>(dgdDAO.getAll());
    }
    
    public synchronized boolean insert(DoGiaDung_DTO dgd) {
        if (!validateDGD(dgd)) {
            throw new IllegalArgumentException("Dữ liệu không hợp lệ");
        }
        
        if (isMaDGDExist(dgd.getMaHang())) {
            throw new IllegalArgumentException("Mã " + dgd.getMaHang() + " đã tồn tại");
        }
        
        boolean result = dgdDAO.insert(dgd);
        if (result) {
            dgdList.add(dgd);
            Collections.sort(dgdList, Comparator.comparingInt(DoGiaDung_DTO::getMaHang));
        }
        return result;
    }
    
    public synchronized boolean update(DoGiaDung_DTO dgd) {
        if (!validateDGD(dgd)) {
            return false;
        }
        
        boolean result = dgdDAO.update(dgd);
        if (result) {
            int index = findIndexById(dgd.getMaHang());
            if (index != -1) {
                dgdList.set(index, dgd);
            } else {
                refreshData();
            }
        }
        return result;
    }
    
    public synchronized boolean delete(int maDGD) {
        boolean result = dgdDAO.delete(maDGD);
        if (result) {
            dgdList.removeIf(item -> item.getMaHang() == maDGD);
        }
        return result;
    }
    
    public ArrayList<DoGiaDung_DTO> search(String keyword, String searchType) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>(dgdList);
        }
        
        String lowerKeyword = keyword.toLowerCase();
        return dgdList.stream()
            .filter(item -> {
                switch (searchType) {
                    case "MA":
                        return String.valueOf(item.getMaHang()).contains(lowerKeyword);
                    case "TEN":
                        return item.getTenHang().toLowerCase().contains(lowerKeyword);
                    case "TINHTRANG":
                        return item.getTinhTrang().toLowerCase().contains(lowerKeyword);
                    default:
                        return String.valueOf(item.getMaHang()).contains(lowerKeyword) ||
                               item.getTenHang().toLowerCase().contains(lowerKeyword);
                }
            })
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Phân loại theo tình trạng
    public ArrayList<DoGiaDung_DTO> filterByStatus(String status) {
        return dgdList.stream()
            .filter(item -> item.getTinhTrang().equalsIgnoreCase(status))
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Sắp xếp theo giá
    public ArrayList<DoGiaDung_DTO> sortByPrice(boolean ascending) {
        return dgdList.stream()
            .sorted(ascending ? 
                Comparator.comparingDouble(DoGiaDung_DTO::getGiaNhap) :
                Comparator.comparingDouble(DoGiaDung_DTO::getGiaNhap).reversed())
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Các phương thức hỗ trợ
    private int findIndexById(int maDGD) {
        for (int i = 0; i < dgdList.size(); i++) {
            if (dgdList.get(i).getMaHang() == maDGD) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isMaDGDExist(int maDGD) {
        return dgdList.stream().anyMatch(item -> item.getMaHang() == maDGD);
    }
    
    private boolean validateDGD(DoGiaDung_DTO dgd) {
        return dgd != null &&
               dgd.getMaHang() > 0 &&
               dgd.getTenHang() != null &&
               !dgd.getTenHang().trim().isEmpty() &&
               dgd.getGiaNhap() > 0 &&
               dgd.getTinhTrang() != null &&
               !dgd.getTinhTrang().trim().isEmpty();
    }

    // Các phương thức mới thêm
    public DoGiaDung_DTO layDoGiaDungTheoMa(int maDoGiaDung) {
        return dgdDAO.getById(maDoGiaDung);
    }

    public ArrayList<DoGiaDung_DTO> getAll() {
        return dgdDAO.getAll();
    }

    public ArrayList<DoGiaDung_DTO> searchByCode(int maDoGiaDung) {
        return dgdDAO.searchByCode(maDoGiaDung);
    }

    public ArrayList<DoGiaDung_DTO> searchByName(String tenDoGiaDung) {
        return dgdDAO.searchByName(tenDoGiaDung);
    }

    public ArrayList<DoGiaDung_DTO> searchByStatus(String tinhTrang) {
        return dgdDAO.searchByStatus(tinhTrang);
    }
}
