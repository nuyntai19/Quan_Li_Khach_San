package DAO;

import DTO.PhieuNhapHang_DTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapHang_DAO {
    private Connection conn;
    
    public PhieuNhapHang_DAO(Connection conn) {
        this.conn = conn;
    }
    
    // Thêm phiếu nhập hàng mới
    public boolean themPhieuNhap(PhieuNhapHang_DTO phieuNhap) throws SQLException {
        String sql = "INSERT INTO PhieuNhapHang (MaPhieuNhap, NgayNhap, TongTien, MaNhanVien) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, phieuNhap.getMaPhieuNhap());
            stmt.setDate(2, new java.sql.Date(phieuNhap.getNgayNhap().getTime()));
            stmt.setDouble(3, phieuNhap.getTongTien());
            stmt.setString(4, phieuNhap.getMaNhanVien());
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Cập nhật phiếu nhập hàng
    public boolean capNhatPhieuNhap(PhieuNhapHang_DTO phieuNhap) throws SQLException {
        String sql = "UPDATE PhieuNhapHang SET NgayNhap = ?, TongTien = ?, MaNhanVien = ? WHERE MaPhieuNhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(phieuNhap.getNgayNhap().getTime()));
            stmt.setDouble(2, phieuNhap.getTongTien());
            stmt.setString(3, phieuNhap.getMaNhanVien());
            stmt.setString(4, phieuNhap.getMaPhieuNhap());
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Xóa phiếu nhập hàng
    public boolean xoaPhieuNhap(String maPhieuNhap) throws SQLException {
        String sql = "DELETE FROM PhieuNhapHang WHERE MaPhieuNhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Lấy thông tin phiếu nhập hàng theo mã
    public PhieuNhapHang_DTO layPhieuNhapTheoMa(String maPhieuNhap) throws SQLException {
        String sql = "SELECT * FROM PhieuNhapHang WHERE MaPhieuNhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PhieuNhapHang_DTO(
                    rs.getString("MaPhieuNhap"),
                    rs.getDate("NgayNhap"),
                    rs.getDouble("TongTien"),
                    rs.getString("MaNhanVien")
                );
            }
        }
        return null;
    }
    
    // Lấy danh sách tất cả phiếu nhập hàng
    public List<PhieuNhapHang_DTO> layDanhSachPhieuNhap() throws SQLException {
        List<PhieuNhapHang_DTO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PhieuNhapHang";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                danhSach.add(new PhieuNhapHang_DTO(
                    rs.getString("MaPhieuNhap"),
                    rs.getDate("NgayNhap"),
                    rs.getDouble("TongTien"),
                    rs.getString("MaNhanVien")
                ));
            }
        }
        return danhSach;
    }
    
    // Lấy danh sách phiếu nhập hàng theo ngày
    public List<PhieuNhapHang_DTO> layPhieuNhapTheoNgay(Date ngayNhap) throws SQLException {
        List<PhieuNhapHang_DTO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PhieuNhapHang WHERE NgayNhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(ngayNhap.getTime()));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSach.add(new PhieuNhapHang_DTO(
                    rs.getString("MaPhieuNhap"),
                    rs.getDate("NgayNhap"),
                    rs.getDouble("TongTien"),
                    rs.getString("MaNhanVien")
                ));
            }
        }
        return danhSach;
    }
    
    // Lấy danh sách phiếu nhập hàng theo nhân viên
    public List<PhieuNhapHang_DTO> layPhieuNhapTheoNhanVien(String maNhanVien) throws SQLException {
        List<PhieuNhapHang_DTO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM PhieuNhapHang WHERE MaNhanVien = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maNhanVien);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSach.add(new PhieuNhapHang_DTO(
                    rs.getString("MaPhieuNhap"),
                    rs.getDate("NgayNhap"),
                    rs.getDouble("TongTien"),
                    rs.getString("MaNhanVien")
                ));
            }
        }
        return danhSach;
    }
}
