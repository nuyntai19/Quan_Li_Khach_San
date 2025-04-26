package BLL;

import DAO.HangHoa_DAO;
import DTO.HangHoa_DTO;
import java.util.ArrayList;

public class HangHoa_BLL {
    private HangHoa_DAO hangHoaDAO;
    
    public HangHoa_BLL() {
        hangHoaDAO = new HangHoa_DAO();
    }
    
    // Thêm hàng hóa mới
    public boolean themHangHoa(HangHoa_DTO hangHoa) {
        // Kiểm tra dữ liệu đầu vào
        if (hangHoa == null) return false;
        if (hangHoa.getTenHang() == null || hangHoa.getTenHang().trim().isEmpty()) return false;
        if (hangHoa.getDonViTinh() == null || hangHoa.getDonViTinh().trim().isEmpty()) return false;
        if (hangHoa.getGiaNhap() <= 0) return false;
        
        return hangHoaDAO.insert(hangHoa);
    }
    
    // Cập nhật thông tin hàng hóa
    public boolean capNhatHangHoa(HangHoa_DTO hangHoa) {
        // Kiểm tra dữ liệu đầu vào
        if (hangHoa == null) return false;
        if (hangHoa.getTenHang() == null || hangHoa.getTenHang().trim().isEmpty()) return false;
        if (hangHoa.getDonViTinh() == null || hangHoa.getDonViTinh().trim().isEmpty()) return false;
        if (hangHoa.getGiaNhap() <= 0) return false;
        
        return hangHoaDAO.update(hangHoa);
    }
    
    // Xóa hàng hóa
    public boolean xoaHangHoa(int maHang) {
        return hangHoaDAO.delete(maHang);
    }
    
    // Lấy thông tin hàng hóa theo mã
    public HangHoa_DTO layHangHoaTheoMa(int maHang) {
        return hangHoaDAO.getById(maHang);
    }
    
    // Lấy danh sách tất cả hàng hóa
    public ArrayList<HangHoa_DTO> layTatCaHangHoa() {
        return hangHoaDAO.getAll();
    }
    
    // Tìm kiếm hàng hóa theo tên
    public ArrayList<HangHoa_DTO> timKiemTheoTen(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return hangHoaDAO.searchByName(tenHang);
    }
    
    // Tìm kiếm hàng hóa theo mã
    public ArrayList<HangHoa_DTO> timKiemTheoMa(int maHang) {
        return hangHoaDAO.searchByCode(maHang);
    }
    
    // Kiểm tra mã hàng hóa đã tồn tại chưa
    public boolean kiemTraMaTonTai(int maHang) {
        return hangHoaDAO.isMaHangExists(maHang);
    }
    
    // Sắp xếp hàng hóa theo giá tăng dần
    public ArrayList<HangHoa_DTO> sapXepTheoGiaTangDan() {
        ArrayList<HangHoa_DTO> danhSach = hangHoaDAO.getAll();
        danhSach.sort((h1, h2) -> Double.compare(h1.getGiaNhap(), h2.getGiaNhap()));
        return danhSach;
    }
    
    // Sắp xếp hàng hóa theo giá giảm dần
    public ArrayList<HangHoa_DTO> sapXepTheoGiaGiamDan() {
        ArrayList<HangHoa_DTO> danhSach = hangHoaDAO.getAll();
        danhSach.sort((h1, h2) -> Double.compare(h2.getGiaNhap(), h1.getGiaNhap()));
        return danhSach;
    }
    
    // Sắp xếp hàng hóa theo tên A-Z
    public ArrayList<HangHoa_DTO> sapXepTheoTenAZ() {
        ArrayList<HangHoa_DTO> danhSach = hangHoaDAO.getAll();
        danhSach.sort((h1, h2) -> h1.getTenHang().compareToIgnoreCase(h2.getTenHang()));
        return danhSach;
    }
    
    // Sắp xếp hàng hóa theo tên Z-A
    public ArrayList<HangHoa_DTO> sapXepTheoTenZA() {
        ArrayList<HangHoa_DTO> danhSach = hangHoaDAO.getAll();
        danhSach.sort((h1, h2) -> h2.getTenHang().compareToIgnoreCase(h1.getTenHang()));
        return danhSach;
    }
}
