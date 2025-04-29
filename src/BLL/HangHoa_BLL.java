package BLL;

import DAO.HangHoa_DAO;
import DTO.HangHoa_DTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangHoa_BLL {
    private HangHoa_DAO hangHoaDAO;
    
    public HangHoa_BLL(Connection conn) {
        this.hangHoaDAO = new HangHoa_DAO(conn);
    }
    
    // Thêm hàng hóa mới
    public boolean themHangHoa(HangHoa_DTO hangHoa) throws SQLException {
        if (hangHoa.getMaHang() <= 0 || 
            hangHoa.getTenHang() == null || hangHoa.getTenHang().isEmpty() ||
            hangHoa.getDonViTinh() == null || hangHoa.getDonViTinh().isEmpty() ||
            hangHoa.getGiaNhap() <= 0 ||
            hangHoa.getLoaiHang() == null || hangHoa.getLoaiHang().isEmpty() ||
            hangHoa.getHanSuDung() == null ||
            hangHoa.getNhaCungCap() == null || hangHoa.getNhaCungCap().isEmpty()) {
            return false;
        }
        return hangHoaDAO.insert(hangHoa);
    }
    
    // Cập nhật thông tin hàng hóa
    public boolean capNhatHangHoa(HangHoa_DTO hangHoa) throws SQLException {
        if (hangHoa.getMaHang() <= 0 || 
            hangHoa.getTenHang() == null || hangHoa.getTenHang().isEmpty() ||
            hangHoa.getDonViTinh() == null || hangHoa.getDonViTinh().isEmpty() ||
            hangHoa.getGiaNhap() <= 0 ||
            hangHoa.getLoaiHang() == null || hangHoa.getLoaiHang().isEmpty() ||
            hangHoa.getHanSuDung() == null ||
            hangHoa.getNhaCungCap() == null || hangHoa.getNhaCungCap().isEmpty()) {
            return false;
        }
        return hangHoaDAO.update(hangHoa);
    }
    
    // Xóa hàng hóa
    public boolean xoaHangHoa(int maHang) throws SQLException {
        return hangHoaDAO.delete(maHang);
    }
    
    // Lấy thông tin hàng hóa theo mã
    public HangHoa_DTO timHangHoaTheoMa(int maHang) throws SQLException {
        return hangHoaDAO.getById(maHang);
    }
    
    // Lấy danh sách hàng hóa
    public List<HangHoa_DTO> layDanhSachHangHoa() throws SQLException {
        return hangHoaDAO.getAll();
    }
    
    // Tìm kiếm hàng hóa theo tên
    public List<HangHoa_DTO> timKiemTheoTen(String tenHang) throws SQLException {
        return hangHoaDAO.searchByName(tenHang);
    }
    
    // Tìm kiếm hàng hóa theo mã
    public HangHoa_DTO timKiemTheoMa(String maHangHoa) throws SQLException {
        return hangHoaDAO.getById(Integer.parseInt(maHangHoa));
    }
    
    // Tìm kiếm hàng hóa theo nhà cung cấp
    public List<HangHoa_DTO> timKiemTheoNhaCungCap(String nhaCungCap) throws SQLException {
        return hangHoaDAO.searchBySupplier(nhaCungCap);
    }
    
    // Lấy danh sách hàng hóa sắp hết hạn
    public List<HangHoa_DTO> layDanhSachHangHoaSapHetHan() throws SQLException {
        return hangHoaDAO.searchByExpiryDate(new java.sql.Date(System.currentTimeMillis()));
    }
    
    // Kiểm tra mã hàng hóa đã tồn tại chưa
    public boolean kiemTraMaTonTai(int maHangHoa) {
        try {
            return hangHoaDAO.isMaHangExists(maHangHoa);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Sắp xếp hàng hóa theo giá tăng dần
    public ArrayList<HangHoa_DTO> sapXepTheoGiaTangDan() throws SQLException {
        ArrayList<HangHoa_DTO> danhSach = new ArrayList<>(layDanhSachHangHoa());
        danhSach.sort((h1, h2) -> Double.compare(h1.getGiaNhap(), h2.getGiaNhap()));
        return danhSach;
    }
    
    // Sắp xếp hàng hóa theo giá giảm dần
    public ArrayList<HangHoa_DTO> sapXepTheoGiaGiamDan() throws SQLException {
        ArrayList<HangHoa_DTO> danhSach = new ArrayList<>(layDanhSachHangHoa());
        danhSach.sort((h1, h2) -> Double.compare(h2.getGiaNhap(), h1.getGiaNhap()));
        return danhSach;
    }
    
    // Sắp xếp hàng hóa theo hạn sử dụng tăng dần
    public ArrayList<HangHoa_DTO> sapXepTheoHanSuDungTangDan() throws SQLException {
        ArrayList<HangHoa_DTO> danhSach = new ArrayList<>(layDanhSachHangHoa());
        danhSach.sort((h1, h2) -> h1.getHanSuDung().compareTo(h2.getHanSuDung()));
        return danhSach;
    }
    
    // Sắp xếp hàng hóa theo hạn sử dụng giảm dần
    public ArrayList<HangHoa_DTO> sapXepTheoHanSuDungGiamDan() throws SQLException {
        ArrayList<HangHoa_DTO> danhSach = new ArrayList<>(layDanhSachHangHoa());
        danhSach.sort((h1, h2) -> h2.getHanSuDung().compareTo(h1.getHanSuDung()));
        return danhSach;
    }
}
