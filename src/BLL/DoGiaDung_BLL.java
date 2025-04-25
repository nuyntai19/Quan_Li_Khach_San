package BLL;

import DAO.DoGiaDung_DAO;
import DTO.DoGiaDung_DTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
        
        if (isMaDGDExist(dgd.getMaDoGiaDung())) {
            throw new IllegalArgumentException("Mã " + dgd.getMaDoGiaDung() + " đã tồn tại");
        }
        
        boolean result = dgdDAO.insert(dgd);
        if (result) {
            dgdList.add(dgd);
            Collections.sort(dgdList, Comparator.comparing(DoGiaDung_DTO::getMaDoGiaDung));
        }
        return result;
    }
    
    public synchronized boolean update(DoGiaDung_DTO dgd) {
        if (!validateDGD(dgd)) {
            return false;
        }
        
        boolean result = dgdDAO.update(dgd);
        if (result) {
            int index = findIndexById(dgd.getMaDoGiaDung());
            if (index != -1) {
                dgdList.set(index, dgd);
            } else {
                refreshData();
            }
        }
        return result;
    }
    
    public synchronized boolean delete(String maDGD) {
        if (maDGD == null || maDGD.trim().isEmpty()) {
            return false;
        }
        
        boolean result = dgdDAO.delete(maDGD);
        if (result) {
            dgdList.removeIf(item -> item.getMaDoGiaDung().equals(maDGD));
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
                        return item.getMaDoGiaDung().toLowerCase().contains(lowerKeyword);
                    case "TEN":
                        return item.getTenDoGiaDung().toLowerCase().contains(lowerKeyword);
                    case "CHATLIEU":
                        return item.getChatLieu().toLowerCase().contains(lowerKeyword);
                    default:
                        return item.getMaDoGiaDung().toLowerCase().contains(lowerKeyword) ||
                               item.getTenDoGiaDung().toLowerCase().contains(lowerKeyword);
                }
            })
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Phân loại theo chất liệu
    public ArrayList<DoGiaDung_DTO> filterByMaterial(String material) {
        return dgdList.stream()
            .filter(item -> item.getChatLieu().equalsIgnoreCase(material))
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
    private int findIndexById(String maDGD) {
        for (int i = 0; i < dgdList.size(); i++) {
            if (dgdList.get(i).getMaDoGiaDung().equals(maDGD)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isMaDGDExist(String maDGD) {
        return dgdList.stream().anyMatch(item -> item.getMaDoGiaDung().equals(maDGD));
    }
    
    private boolean validateDGD(DoGiaDung_DTO dgd) {
        return dgd != null &&
               dgd.getMaDoGiaDung() != null &&
               !dgd.getMaDoGiaDung().trim().isEmpty() &&
               dgd.getTenDoGiaDung() != null &&
               !dgd.getTenDoGiaDung().trim().isEmpty() &&
               dgd.getGiaNhap() > 0 &&
               dgd.getChatLieu() != null &&
               !dgd.getChatLieu().trim().isEmpty();
    }
}
