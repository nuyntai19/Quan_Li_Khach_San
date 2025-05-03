package DAO;

import DTO.ChiTiet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhapHangDAO {
    private Connection conn;

    public ChiTietPhieuNhapHangDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean insert(ChiTietPhieuNhap_DTO ct) throws SQLException {
        String sql = "INSERT INTO ChiTietPhieuNhapHang (MaPhieuNhapHang, MaHang, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ct.getMaPhieuNhapHang());
            stmt.setInt(2, ct.getMaHang());
            stmt.setInt(3, ct.getSoLuong());
            stmt.setDouble(4, ct.getDonGia());
            stmt.setDouble(5, ct.getThanhTien());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean update(ChiTietPhieuNhapHang ct) throws SQLException {
        String sql = "UPDATE ChiTietPhieuNhapHang SET SoLuong = ?, DonGia = ?, ThanhTien = ? WHERE MaPhieuNhapHang = ? AND MaHang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ct.getSoLuong());
            stmt.setDouble(2, ct.getDonGia());
            stmt.setDouble(3, ct.getThanhTien());
            stmt.setInt(4, ct.getMaPhieuNhapHang());
            stmt.setInt(5, ct.getMaHang());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(int maPhieuNhapHang, int maHang) throws SQLException {
        String sql = "DELETE FROM ChiTietPhieuNhapHang WHERE MaPhieuNhapHang = ? AND MaHang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPhieuNhapHang);
            stmt.setInt(2, maHang);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<ChiTietPhieuNhapHang> getByPhieuNhap(int maPhieuNhapHang) throws SQLException {
        List<ChiTietPhieuNhapHang> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietPhieuNhapHang WHERE MaPhieuNhapHang = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPhieuNhapHang);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ChiTietPhieuNhapHang ct = new ChiTietPhieuNhapHang(
                    rs.getInt("MaPhieuNhapHang"),
                    rs.getInt("MaHang"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGia"),
                    rs.getDouble("ThanhTien")
                );
                list.add(ct);
            }
        }
        return list;
    }
}
