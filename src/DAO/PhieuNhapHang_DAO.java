package DAO;

import DTO.PhieuNhapHang_DTO;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapHang_DAO {
    private Connection conn;
    
    // Constructor
    public PhieuNhapHang_DAO(Connection conn) {
        this.conn = conn;
    }
    
    // Lấy danh sách phiếu nhập hàng
    public List<PhieuNhapHang_DTO> getAll() throws SQLException {
        List<PhieuNhapHang_DTO> danhSach = new ArrayList<>();
        String sql = "SELECT MaPhieuNhapHang, MaNhanVienXacNhan, MaNhaCungCap, NgayNhap, TongTien FROM PhieuNhapHang";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int maPhieuNhap = rs.getInt("MaPhieuNhapHang");
                int maNhanVien = rs.getInt("MaNhanVienXacNhan");
                int maNhaCungCap = rs.getInt("MaNhaCungCap");
                LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
                double tongTien = rs.getDouble("TongTien");
                
                PhieuNhapHang_DTO phieu = new PhieuNhapHang_DTO(
                    String.valueOf(maPhieuNhap),
                    String.valueOf(maNhanVien),
                    String.valueOf(maNhaCungCap),
                    ngayNhap,
                    tongTien
                );
                danhSach.add(phieu);
            }
        }
        
        return danhSach;
    }
    
    // Tìm phiếu nhập hàng theo mã
    public PhieuNhapHang_DTO getByMa(String maPhieuNhap) throws SQLException {
        String sql = "SELECT MaPhieuNhapHang, MaNhanVienXacNhan, MaNhaCungCap, NgayNhap, TongTien " +
                     "FROM PhieuNhapHang WHERE MaPhieuNhapHang = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(maPhieuNhap));
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int maNhanVien = rs.getInt("MaNhanVienXacNhan");
                    int maNhaCungCap = rs.getInt("MaNhaCungCap");
                    LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
                    double tongTien = rs.getDouble("TongTien");
                    
                    return new PhieuNhapHang_DTO(
                        maPhieuNhap,
                        String.valueOf(maNhanVien),
                        String.valueOf(maNhaCungCap),
                        ngayNhap,
                        tongTien
                    );
                }
            }
        }
        
        return null;
    }
    
    // Thêm phiếu nhập hàng mới
    public boolean them(PhieuNhapHang_DTO phieu) throws SQLException {
        String sql = "INSERT INTO PhieuNhapHang (MaPhieuNhapHang, MaNhanVienXacNhan, MaNhaCungCap, NgayNhap, TongTien) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Nếu mã phiếu nhập trống, tạo mã mới
            int maPhieuNhap = phieu.getMaPhieuNhap().isEmpty() ? 
                              taoMaPhieuTuDong() : 
                              Integer.parseInt(phieu.getMaPhieuNhap());
            
            stmt.setInt(1, maPhieuNhap);
            stmt.setInt(2, Integer.parseInt(phieu.getMaNhanVien()));
            stmt.setInt(3, Integer.parseInt(phieu.getMaNhaCungCap()));
            stmt.setDate(4, java.sql.Date.valueOf(phieu.getNgayNhap()));
            stmt.setDouble(5, phieu.getTongTien());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Cập nhật phiếu nhập hàng
    public boolean capNhat(PhieuNhapHang_DTO phieu) throws SQLException {
        String sql = "UPDATE PhieuNhapHang SET MaNhanVienXacNhan = ?, MaNhaCungCap = ?, " +
                     "NgayNhap = ?, TongTien = ? WHERE MaPhieuNhapHang = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(phieu.getMaNhanVien()));
            stmt.setInt(2, Integer.parseInt(phieu.getMaNhaCungCap()));
            stmt.setDate(3, java.sql.Date.valueOf(phieu.getNgayNhap()));
            stmt.setDouble(4, phieu.getTongTien());
            stmt.setInt(5, Integer.parseInt(phieu.getMaPhieuNhap()));
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Xóa phiếu nhập hàng
    public boolean xoa(String maPhieuNhap) throws SQLException {
        // Trước tiên, phải xóa các chi tiết phiếu nhập liên quan vì có ràng buộc khóa ngoại
        xoaChiTietPhieu(maPhieuNhap);
        
        // Sau đó xóa phiếu nhập
        String sql = "DELETE FROM PhieuNhapHang WHERE MaPhieuNhapHang = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(maPhieuNhap));
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Xóa chi tiết phiếu nhập hàng
    private void xoaChiTietPhieu(String maPhieuNhap) throws SQLException {
        String sql = "DELETE FROM ChiTietPhieuNhapHang WHERE MaPhieuNhapHang = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(maPhieuNhap));
            stmt.executeUpdate();
        }
    }
    
    // Tạo mã phiếu nhập tự động (đảm bảo mã duy nhất)
    private int taoMaPhieuTuDong() throws SQLException {
        String sql = "SELECT MAX(MaPhieuNhapHang) AS MaxMa FROM PhieuNhapHang";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                int maxMa = rs.getInt("MaxMa");
                return maxMa + 1;
            } else {
                return 1; // Trường hợp bảng chưa có dữ liệu
            }
        }
    }
    
    // Tìm kiếm phiếu nhập theo nhiều tiêu chí
    public List<PhieuNhapHang_DTO> timKiem(String maNCC, LocalDate tuNgay, LocalDate denNgay) throws SQLException {
        List<PhieuNhapHang_DTO> danhSach = new ArrayList<>();
        
        StringBuilder sqlBuilder = new StringBuilder(
            "SELECT MaPhieuNhapHang, MaNhanVienXacNhan, MaNhaCungCap, NgayNhap, TongTien " +
            "FROM PhieuNhapHang WHERE 1=1");
        
        if (maNCC != null && !maNCC.isEmpty()) {
            sqlBuilder.append(" AND MaNhaCungCap = ?");
        }
        
        if (tuNgay != null) {
            sqlBuilder.append(" AND NgayNhap >= ?");
        }
        
        if (denNgay != null) {
            sqlBuilder.append(" AND NgayNhap <= ?");
        }
        
        try (PreparedStatement stmt = conn.prepareStatement(sqlBuilder.toString())) {
            int paramIndex = 1;
            
            if (maNCC != null && !maNCC.isEmpty()) {
                stmt.setInt(paramIndex++, Integer.parseInt(maNCC));
            }
            
            if (tuNgay != null) {
                stmt.setDate(paramIndex++, java.sql.Date.valueOf(tuNgay));
            }
            
            if (denNgay != null) {
                stmt.setDate(paramIndex++, java.sql.Date.valueOf(denNgay));
            }
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int maPhieuNhap = rs.getInt("MaPhieuNhapHang");
                    int maNhanVien = rs.getInt("MaNhanVienXacNhan");
                    int maNhaCungCap = rs.getInt("MaNhaCungCap");
                    LocalDate ngayNhap = rs.getDate("NgayNhap").toLocalDate();
                    double tongTien = rs.getDouble("TongTien");
                    
                    PhieuNhapHang_DTO phieu = new PhieuNhapHang_DTO(
                        String.valueOf(maPhieuNhap),
                        String.valueOf(maNhanVien),
                        String.valueOf(maNhaCungCap),
                        ngayNhap,
                        tongTien
                    );
                    danhSach.add(phieu);
                }
            }
        }
        
        return danhSach;
    }
    
    // Tính tổng giá trị nhập hàng trong khoảng thời gian
    public double tinhTongNhapHang(LocalDate tuNgay, LocalDate denNgay) throws SQLException {
        String sql = "SELECT SUM(TongTien) AS TongNhapHang FROM PhieuNhapHang " +
                     "WHERE NgayNhap BETWEEN ? AND ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(tuNgay));
            stmt.setDate(2, java.sql.Date.valueOf(denNgay));
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("TongNhapHang");
                }
            }
        }
        
        return 0;
    }
}
