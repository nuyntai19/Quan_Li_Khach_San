package BLL;

import DAO.NhuYeuPham_DAO;
import DTO.NhuYeuPham_DTO;
import java.util.ArrayList;
import java.util.Date;

public class NhuYeuPham_BLL {
    private NhuYeuPham_DAO nhuYeuPhamDAO;
    
    public NhuYeuPham_BLL() {
        nhuYeuPhamDAO = new NhuYeuPham_DAO();
    }
    
    // Thêm nhu yếu phẩm mới
    public boolean themNhuYeuPham(NhuYeuPham_DTO nhuYeuPham) {
        // Kiểm tra dữ liệu đầu vào
        if (nhuYeuPham == null) return false;
        if (nhuYeuPham.getTenNhuYeuPham() == null || nhuYeuPham.getTenNhuYeuPham().trim().isEmpty()) return false;
        if (nhuYeuPham.getDonViTinh() == null || nhuYeuPham.getDonViTinh().trim().isEmpty()) return false;
        if (nhuYeuPham.getGiaNhap() <= 0) return false;
        if (nhuYeuPham.getHanSuDung() == null) return false;
        if (nhuYeuPham.getNhaCungCap() == null || nhuYeuPham.getNhaCungCap().trim().isEmpty()) return false;
        
        return nhuYeuPhamDAO.insert(nhuYeuPham);
    }
    
    // Cập nhật thông tin nhu yếu phẩm
    public boolean capNhatNhuYeuPham(NhuYeuPham_DTO nhuYeuPham) {
        // Kiểm tra dữ liệu đầu vào
        if (nhuYeuPham == null) return false;
        if (nhuYeuPham.getTenNhuYeuPham() == null || nhuYeuPham.getTenNhuYeuPham().trim().isEmpty()) return false;
        if (nhuYeuPham.getDonViTinh() == null || nhuYeuPham.getDonViTinh().trim().isEmpty()) return false;
        if (nhuYeuPham.getGiaNhap() <= 0) return false;
        if (nhuYeuPham.getHanSuDung() == null) return false;
        if (nhuYeuPham.getNhaCungCap() == null || nhuYeuPham.getNhaCungCap().trim().isEmpty()) return false;
        
        return nhuYeuPhamDAO.update(nhuYeuPham);
    }
    
    // Xóa nhu yếu phẩm
    public boolean xoaNhuYeuPham(int maNhuYeuPham) {
        return nhuYeuPhamDAO.delete(maNhuYeuPham);
    }
    
    // Lấy thông tin nhu yếu phẩm theo mã
    public NhuYeuPham_DTO layNhuYeuPhamTheoMa(int maNhuYeuPham) {
        return nhuYeuPhamDAO.getById(maNhuYeuPham);
    }
    
    // Lấy danh sách tất cả nhu yếu phẩm
    public ArrayList<NhuYeuPham_DTO> layTatCaNhuYeuPham() {
        return nhuYeuPhamDAO.getAll();
    }
    
    // Tìm kiếm nhu yếu phẩm theo tên
    public ArrayList<NhuYeuPham_DTO> timKiemTheoTen(String tenNhuYeuPham) {
        if (tenNhuYeuPham == null || tenNhuYeuPham.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return nhuYeuPhamDAO.searchByName(tenNhuYeuPham);
    }
    
    // Tìm kiếm nhu yếu phẩm theo mã
    public ArrayList<NhuYeuPham_DTO> timKiemTheoMa(int maNhuYeuPham) {
        return nhuYeuPhamDAO.searchByCode(maNhuYeuPham);
    }
    
    // Tìm kiếm nhu yếu phẩm theo nhà cung cấp
    public ArrayList<NhuYeuPham_DTO> timKiemTheoNhaCungCap(String nhaCungCap) {
        if (nhaCungCap == null || nhaCungCap.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return nhuYeuPhamDAO.searchBySupplier(nhaCungCap);
    }
    
    // Lấy danh sách nhu yếu phẩm sắp hết hạn
    public ArrayList<NhuYeuPham_DTO> layDanhSachSapHetHan(Date ngayHetHan) {
        if (ngayHetHan == null) {
            return new ArrayList<>();
        }
        return nhuYeuPhamDAO.getExpiringItems(ngayHetHan);
    }
    
    // Kiểm tra mã nhu yếu phẩm đã tồn tại chưa
    public boolean kiemTraMaTonTai(int maNhuYeuPham) {
        return nhuYeuPhamDAO.isMaNhuYeuPhamExists(maNhuYeuPham);
    }
    
    // Sắp xếp nhu yếu phẩm theo giá tăng dần
    public ArrayList<NhuYeuPham_DTO> sapXepTheoGiaTangDan() {
        ArrayList<NhuYeuPham_DTO> danhSach = nhuYeuPhamDAO.getAll();
        danhSach.sort((n1, n2) -> Double.compare(n1.getGiaNhap(), n2.getGiaNhap()));
        return danhSach;
    }
    
    // Sắp xếp nhu yếu phẩm theo giá giảm dần
    public ArrayList<NhuYeuPham_DTO> sapXepTheoGiaGiamDan() {
        ArrayList<NhuYeuPham_DTO> danhSach = nhuYeuPhamDAO.getAll();
        danhSach.sort((n1, n2) -> Double.compare(n2.getGiaNhap(), n1.getGiaNhap()));
        return danhSach;
    }
    
    // Sắp xếp nhu yếu phẩm theo hạn sử dụng tăng dần
    public ArrayList<NhuYeuPham_DTO> sapXepTheoHanSuDungTangDan() {
        ArrayList<NhuYeuPham_DTO> danhSach = nhuYeuPhamDAO.getAll();
        danhSach.sort((n1, n2) -> n1.getHanSuDung().compareTo(n2.getHanSuDung()));
        return danhSach;
    }
    
    // Sắp xếp nhu yếu phẩm theo hạn sử dụng giảm dần
    public ArrayList<NhuYeuPham_DTO> sapXepTheoHanSuDungGiamDan() {
        ArrayList<NhuYeuPham_DTO> danhSach = nhuYeuPhamDAO.getAll();
        danhSach.sort((n1, n2) -> n2.getHanSuDung().compareTo(n1.getHanSuDung()));
        return danhSach;
    }
}
