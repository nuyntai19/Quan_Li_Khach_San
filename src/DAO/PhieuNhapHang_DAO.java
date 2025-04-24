package DAO;

import DTO.PhieuNhapHang_DTO;
import sql.DatabaseQLKS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapHang_DAO {
    
    // Thêm phiếu nhập hàng mới vào database
    public boolean themPhieuNhapHang(PhieuNhapHang_DTO phieuNhap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean result = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "INSERT INTO PhieuNhapHang (MaPhieuNhapHang, MaNhanVienXacNhan, MaNhaCungCap, NgayNhap, TongTien) " +
                         "VALUES (?, ?, ?, ?, ?)";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(phieuNhap.getMaPhieuNhap()));
            stmt.setInt(2, Integer.parseInt(phieuNhap.getMaNhanVien()));
            stmt.setInt(3, Integer.parseInt(phieuNhap.getMaNhaCungCap()));
            stmt.setDate(4, Date.valueOf(phieuNhap.getNgayNhap()));
            stmt.setBigDecimal(5, java.math.BigDecimal.valueOf(phieuNhap.getTongTien()));
            
            int rowsAffected = stmt.executeUpdate();
            result = rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
        
        return result;
    }
    
    // Cập nhật thông tin phiếu nhập hàng
    public boolean capNhatPhieuNhapHang(PhieuNhapHang_DTO phieuNhap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean result = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "UPDATE PhieuNhapHang SET MaNhanVienXacNhan = ?, MaNhaCungCap = ?, NgayNhap = ?, TongTien = ? " +
                         "WHERE MaPhieuNhapHang = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(phieuNhap.getMaNhanVien()));
            stmt.setInt(2, Integer.parseInt(phieuNhap.getMaNhaCungCap()));
            stmt.setDate(3, Date.valueOf(phieuNhap.getNgayNhap()));
            stmt.setBigDecimal(4, java.math.BigDecimal.valueOf(phieuNhap.getTongTien()));
            stmt.setInt(5, Integer.parseInt(phieuNhap.getMaPhieuNhap()));
            
            int rowsAffected = stmt.executeUpdate();
            result = rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
        
        return result;
    }
    
    // Xóa phiếu nhập hàng
    public boolean xoaPhieuNhapHang(String maPhieuNhap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean result = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            
            // Trước tiên phải xóa các chi tiết phiếu nhập hàng
            String sqlDeleteDetails = "DELETE FROM ChiTietPhieuNhapHang WHERE MaPhieuNhapHang = ?";
            stmt = conn.prepareStatement(sqlDeleteDetails);
            stmt.setInt(1, Integer.parseInt(maPhieuNhap));
            stmt.executeUpdate();
            
            // Sau đó xóa phiếu nhập hàng
            String sqlDeleteInvoice = "DELETE FROM PhieuNhapHang WHERE MaPhieuNhapHang = ?";
            stmt = conn.prepareStatement(sqlDeleteInvoice);
            stmt.setInt(1, Integer.parseInt(maPhieuNhap));
            
            int rowsAffected = stmt.executeUpdate();
            result = rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
        
        return result;
    }
    
    // Lấy thông tin một phiếu nhập hàng theo mã
    public PhieuNhapHang_DTO getPhieuNhapHang(String maPhieuNhap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PhieuNhapHang_DTO phieuNhap = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM PhieuNhapHang WHERE MaPhieuNhapHang = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(maPhieuNhap));
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                String maNhanVien = String.valueOf(rs.getInt("MaNhanVienXacNhan"));
                String maNhaCungCap = String.valueOf(rs.getInt("MaNhaCungCap"));
                LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
                double tongTien = rs.getBigDecimal("TongTien").doubleValue();
                
                phieuNhap = new PhieuNhapHang_DTO(maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return phieuNhap;
    }
    
    // Lấy danh sách tất cả phiếu nhập hàng
    public List<PhieuNhapHang_DTO> getAllPhieuNhapHang() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PhieuNhapHang_DTO> danhSachPhieuNhap = new ArrayList<>();
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM PhieuNhapHang ORDER BY MaPhieuNhapHang";
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String maPhieuNhap = String.valueOf(rs.getInt("MaPhieuNhapHang"));
                String maNhanVien = String.valueOf(rs.getInt("MaNhanVienXacNhan"));
                String maNhaCungCap = String.valueOf(rs.getInt("MaNhaCungCap"));
                LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
                double tongTien = rs.getBigDecimal("TongTien").doubleValue();
                
                PhieuNhapHang_DTO phieuNhap = new PhieuNhapHang_DTO(maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien);
                danhSachPhieuNhap.add(phieuNhap);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return danhSachPhieuNhap;
    }
    
    // Kiểm tra mã phiếu nhập hàng đã tồn tại hay chưa
    public boolean kiemTraMaTonTai(String maPhieuNhap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exists = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT COUNT(*) FROM PhieuNhapHang WHERE MaPhieuNhapHang = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(maPhieuNhap));
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return exists;
    }
    
    // Tạo mã phiếu nhập hàng tiếp theo
    public String taoMaPhieuNhapHangTiepTheo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int maxMa = 0;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT MAX(MaPhieuNhapHang) FROM PhieuNhapHang";
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                maxMa = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return String.valueOf(maxMa + 1);
    }
    
    // Tìm kiếm phiếu nhập hàng theo mã nhà cung cấp
    public List<PhieuNhapHang_DTO> timKiemTheoNhaCungCap(String maNhaCungCap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PhieuNhapHang_DTO> danhSachPhieuNhap = new ArrayList<>();
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM PhieuNhapHang WHERE MaNhaCungCap = ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(maNhaCungCap));
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String maPhieuNhap = String.valueOf(rs.getInt("MaPhieuNhapHang"));
                String maNhanVien = String.valueOf(rs.getInt("MaNhanVienXacNhan"));
                LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
                double tongTien = rs.getBigDecimal("TongTien").doubleValue();
                
                PhieuNhapHang_DTO phieuNhap = new PhieuNhapHang_DTO(maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien);
                danhSachPhieuNhap.add(phieuNhap);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return danhSachPhieuNhap;
    }
    
    // Tìm kiếm phiếu nhập hàng theo khoảng thời gian
    public List<PhieuNhapHang_DTO> timKiemTheoKhoangThoiGian(LocalDate tuNgay, LocalDate denNgay) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<PhieuNhapHang_DTO> danhSachPhieuNhap = new ArrayList<>();
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM PhieuNhapHang WHERE NgayNhap BETWEEN ? AND ?";
            
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, Date.valueOf(tuNgay));
            stmt.setDate(2, Date.valueOf(denNgay));
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String maPhieuNhap = String.valueOf(rs.getInt("MaPhieuNhapHang"));
                String maNhanVien = String.valueOf(rs.getInt("MaNhanVienXacNhan"));
                String maNhaCungCap = String.valueOf(rs.getInt("MaNhaCungCap"));
                LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
                double tongTien = rs.getBigDecimal("TongTien").doubleValue();
                
                PhieuNhapHang_DTO phieuNhap = new PhieuNhapHang_DTO(maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien);
                danhSachPhieuNhap.add(phieuNhap);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return danhSachPhieuNhap;
    }
}
