package DAO;

import DTO.ChiTietPhieuNhap_DTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhap_DAO {
    private Connection conn;
    
    public ChiTietPhieuNhap_DAO(Connection conn) {
        this.conn = conn;
    }
    
    // Thêm chi tiết phiếu nhập mới
    public boolean themChiTietPhieuNhap(ChiTietPhieuNhap_DTO chiTiet) throws SQLException {
        String sql = "INSERT INTO ChiTietPhieuNhap (MaPhieuNhap, MaHang, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chiTiet.getMaPhieuNhap());
            stmt.setString(2, chiTiet.getMaHang());
            stmt.setInt(3, chiTiet.getSoLuong());
            stmt.setDouble(4, chiTiet.getDonGia());
            stmt.setDouble(5, chiTiet.getThanhTien());
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Cập nhật chi tiết phiếu nhập
    public boolean capNhatChiTietPhieuNhap(ChiTietPhieuNhap_DTO chiTiet) throws SQLException {
        String sql = "UPDATE ChiTietPhieuNhap SET SoLuong = ?, DonGia = ?, ThanhTien = ? WHERE MaPhieuNhap = ? AND MaHang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, chiTiet.getSoLuong());
            stmt.setDouble(2, chiTiet.getDonGia());
            stmt.setDouble(3, chiTiet.getThanhTien());
            stmt.setString(4, chiTiet.getMaPhieuNhap());
            stmt.setString(5, chiTiet.getMaHang());
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Xóa chi tiết phiếu nhập
    public boolean xoaChiTietPhieuNhap(String maPhieuNhap, String maHang) throws SQLException {
        String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaPhieuNhap = ? AND MaHang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            stmt.setString(2, maHang);
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Xóa tất cả chi tiết của một phiếu nhập
    public boolean xoaTatCaChiTietPhieuNhap(String maPhieuNhap) throws SQLException {
        String sql = "DELETE FROM ChiTietPhieuNhap WHERE MaPhieuNhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            return stmt.executeUpdate() > 0;
        }
    }
    
    // Lấy chi tiết phiếu nhập theo mã phiếu và mã hàng
    public ChiTietPhieuNhap_DTO layChiTietPhieuNhap(String maPhieuNhap, String maHang) throws SQLException {
        String sql = "SELECT * FROM ChiTietPhieuNhap WHERE MaPhieuNhap = ? AND MaHang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            stmt.setString(2, maHang);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ChiTietPhieuNhap_DTO(
                    rs.getString("MaPhieuNhap"),
                    rs.getString("MaHang"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGia"),
                    rs.getDouble("ThanhTien")
                );
            }
        }
        return null;
    }
    
    // Lấy danh sách chi tiết của một phiếu nhập
    public List<ChiTietPhieuNhap_DTO> layDanhSachChiTietPhieuNhap(String maPhieuNhap) throws SQLException {
        List<ChiTietPhieuNhap_DTO> danhSach = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietPhieuNhap WHERE MaPhieuNhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                danhSach.add(new ChiTietPhieuNhap_DTO(
                    rs.getString("MaPhieuNhap"),
                    rs.getString("MaHang"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGia"),
                    rs.getDouble("ThanhTien")
                ));
            }
        }
        return danhSach;
    }
    
    // Tính tổng tiền của một phiếu nhập
    public double tinhTongTienPhieuNhap(String maPhieuNhap) throws SQLException {
        String sql = "SELECT SUM(ThanhTien) FROM ChiTietPhieuNhap WHERE MaPhieuNhap = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maPhieuNhap);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }
} 
