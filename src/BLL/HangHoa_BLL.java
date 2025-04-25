package BLL;

import DAO.HangHoa_DAO;
import DTO.HangHoa;
import java.util.List;

public class HangHoa_BLL {
    private HangHoa_DAO hangHoaDAO;
    
    public HangHoa_BLL() {
        hangHoaDAO = new HangHoa_DAO();
    }
    
    // Kiểm tra hợp lệ trước khi thêm mới
    public boolean insert(HangHoa hangHoa) {
        if (!validateHangHoa(hangHoa)) {
            return false;
        }
        return hangHoaDAO.insert(hangHoa);
    }
    
    // Kiểm tra hợp lệ trước khi cập nhật
    public boolean update(HangHoa hangHoa) {
        if (!validateHangHoa(hangHoa)) {
            return false;
        }
        return hangHoaDAO.update(hangHoa);
    }
    
    // Xóa hàng hóa
    public boolean delete(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            return false;
        }
        return hangHoaDAO.delete(maHang);
    }
    
    // Lấy hàng hóa theo mã
    public HangHoa getById(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            return null;
        }
        return hangHoaDAO.getById(maHang);
    }
    
    // Lấy tất cả hàng hóa
    public List<HangHoa> getAll() {
        return hangHoaDAO.getAll();
    }
    
    // Tìm kiếm theo tên
    public List<HangHoa> searchByName(String tenHang) {
        if (tenHang == null) {
            tenHang = "";
        }
        return hangHoaDAO.searchByName(tenHang);
    }
    
    // Kiểm tra hàng hóa hợp lệ
    private boolean validateHangHoa(HangHoa hangHoa) {
        if (hangHoa == null) {
            return false;
        }
        
        // Kiểm tra mã hàng
        if (hangHoa.getMaHang() == null || hangHoa.getMaHang().trim().isEmpty()) {
            return false;
        }
        
        // Kiểm tra tên hàng
        if (hangHoa.getTenHang() == null || hangHoa.getTenHang().trim().isEmpty()) {
            return false;
        }
        
        // Kiểm tra đơn vị tính
        if (hangHoa.getDonViTinh() == null || hangHoa.getDonViTinh().trim().isEmpty()) {
            return false;
        }
        
        // Kiểm tra giá nhập không âm
        if (hangHoa.getGiaNhap() < 0) {
            return false;
        }
        
        return true;
    }
}
