package BLL;

import DAO.PhieuNhapHang_DAO;
import DAO.ChiTietPhieuNhap_DAO;
import DTO.PhieuNhapHang_DTO;
import DTO.ChiTietPhieuNhap_DTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class QuanLyNhapHangBLL {
    private PhieuNhapHang_DAO phieuNhapDAO;
    private ChiTietPhieuNhap_DAO chiTietPhieuNhapDAO;
    private Connection conn;
    
    public QuanLyNhapHangBLL(Connection conn) {
        this.conn = conn;
        this.phieuNhapDAO = new PhieuNhapHang_DAO(conn);
        this.chiTietPhieuNhapDAO = new ChiTietPhieuNhap_DAO(conn);
    }
    
    // Thêm phiếu nhập hàng mới
    public boolean themPhieuNhap(PhieuNhapHang_DTO phieuNhap, List<ChiTietPhieuNhap_DTO> danhSachChiTiet) throws SQLException {
        try {
            // Bắt đầu transaction
            conn.setAutoCommit(false);
            
            // Thêm phiếu nhập
            boolean themPhieuNhap = phieuNhapDAO.themPhieuNhap(phieuNhap);
            if (!themPhieuNhap) {
                conn.rollback();
                return false;
            }
            
            // Thêm chi tiết phiếu nhập
            for (ChiTietPhieuNhap_DTO chiTiet : danhSachChiTiet) {
                boolean themChiTiet = chiTietPhieuNhapDAO.themChiTietPhieuNhap(chiTiet);
                if (!themChiTiet) {
                    conn.rollback();
                    return false;
                }
            }
            
            // Commit transaction
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    // Cập nhật phiếu nhập hàng
    public boolean capNhatPhieuNhap(PhieuNhapHang_DTO phieuNhap, List<ChiTietPhieuNhap_DTO> danhSachChiTiet) throws SQLException {
        try {
            // Bắt đầu transaction
            conn.setAutoCommit(false);
            
            // Cập nhật phiếu nhập
            boolean capNhatPhieuNhap = phieuNhapDAO.capNhatPhieuNhap(phieuNhap);
            if (!capNhatPhieuNhap) {
                conn.rollback();
                return false;
            }
            
            // Xóa chi tiết cũ
            boolean xoaChiTietCu = chiTietPhieuNhapDAO.xoaTatCaChiTietPhieuNhap(phieuNhap.getMaPhieuNhap());
            if (!xoaChiTietCu) {
                conn.rollback();
                return false;
            }
            
            // Thêm chi tiết mới
            for (ChiTietPhieuNhap_DTO chiTiet : danhSachChiTiet) {
                boolean themChiTiet = chiTietPhieuNhapDAO.themChiTietPhieuNhap(chiTiet);
                if (!themChiTiet) {
                    conn.rollback();
                    return false;
                }
            }
            
            // Commit transaction
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    // Xóa phiếu nhập hàng
    public boolean xoaPhieuNhap(String maPhieuNhap) throws SQLException {
        try {
            // Bắt đầu transaction
            conn.setAutoCommit(false);
            
            // Xóa chi tiết phiếu nhập
            boolean xoaChiTiet = chiTietPhieuNhapDAO.xoaTatCaChiTietPhieuNhap(maPhieuNhap);
            if (!xoaChiTiet) {
                conn.rollback();
                return false;
            }
            
            // Xóa phiếu nhập
            boolean xoaPhieuNhap = phieuNhapDAO.xoaPhieuNhap(maPhieuNhap);
            if (!xoaPhieuNhap) {
                conn.rollback();
                return false;
            }
            
            // Commit transaction
            conn.commit();
            return true;
            
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
    
    // Lấy thông tin phiếu nhập hàng theo mã
    public PhieuNhapHang_DTO layPhieuNhapTheoMa(String maPhieuNhap) throws SQLException {
        return phieuNhapDAO.layPhieuNhapTheoMa(maPhieuNhap);
    }
    
    // Lấy danh sách tất cả phiếu nhập hàng
    public List<PhieuNhapHang_DTO> layDanhSachPhieuNhap() throws SQLException {
        return phieuNhapDAO.layDanhSachPhieuNhap();
    }
    
    // Lấy danh sách phiếu nhập hàng theo ngày
    public List<PhieuNhapHang_DTO> layPhieuNhapTheoNgay(Date ngayNhap) throws SQLException {
        return phieuNhapDAO.layPhieuNhapTheoNgay(new java.sql.Date(ngayNhap.getTime()));
    }
    
    // Lấy danh sách phiếu nhập hàng theo nhân viên
    public List<PhieuNhapHang_DTO> layPhieuNhapTheoNhanVien(String maNhanVien) throws SQLException {
        return phieuNhapDAO.layPhieuNhapTheoNhanVien(maNhanVien);
    }
    
    // Lấy danh sách chi tiết của một phiếu nhập
    public List<ChiTietPhieuNhap_DTO> layDanhSachChiTietPhieuNhap(String maPhieuNhap) throws SQLException {
        return chiTietPhieuNhapDAO.layDanhSachChiTietPhieuNhap(maPhieuNhap);
    }
    
    // Tính tổng tiền của một phiếu nhập
    public double tinhTongTienPhieuNhap(String maPhieuNhap) throws SQLException {
        return chiTietPhieuNhapDAO.tinhTongTienPhieuNhap(maPhieuNhap);
    }
    
    // Tạo mã phiếu nhập mới
    public String taoMaPhieuNhapMoi() throws SQLException {
        List<PhieuNhapHang_DTO> danhSach = phieuNhapDAO.layDanhSachPhieuNhap();
        if (danhSach.isEmpty()) {
            return "PN001";
        }
        
        String maCuoi = danhSach.get(danhSach.size() - 1).getMaPhieuNhap();
        int soThuTu = Integer.parseInt(maCuoi.substring(2)) + 1;
        return String.format("PN%03d", soThuTu);
    }
} 
