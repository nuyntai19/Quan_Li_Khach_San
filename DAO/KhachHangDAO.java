package DAO;

import DTO.KhachHangDTO;
import java.sql.*;
import java.util.ArrayList;
import sql.DatabaseQLKS;

public class KhachHangDAO {

    public boolean kiemTraTonTai(int maKhachHang) throws SQLException {
        String sql = "SELECT COUNT(*) FROM KhachHang WHERE MaKhachHang = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maKhachHang);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    public void themKhachHang(KhachHangDTO kh) throws SQLException {
        String sql = "INSERT INTO KhachHang (MaKhachHang, Ho, Ten, NgaySinh, GioiTinh, Email, SoDienThoai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, kh.getMaKhachHang());
            stmt.setString(2, kh.getHo());
            stmt.setString(3, kh.getTen());
            stmt.setDate(4, new java.sql.Date(kh.getNgaySinh().getTime()));
            stmt.setString(5, kh.getGioiTinh());
            stmt.setString(6, kh.getEmail());
            stmt.setString(7, kh.getSoDienThoai());
            stmt.executeUpdate();
        }
    }

    public ArrayList<KhachHangDTO> layDanhSachKhachHang() throws SQLException {
        ArrayList<KhachHangDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ds.add(new KhachHangDTO(
                        rs.getInt("MaKhachHang"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getDate("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("Email"),
                        rs.getString("SoDienThoai")
                ));
            }
        }
        return ds;
    }

    public void xoaKhachHang(int maKhachHang) throws SQLException {
        String sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maKhachHang);
            stmt.executeUpdate();
        }
    }

    public void capNhatKhachHang(KhachHangDTO kh) throws SQLException {
        String sql = "UPDATE KhachHang SET Ho = ?, Ten = ?, NgaySinh = ?, GioiTinh = ?, Email = ?, SoDienThoai = ? WHERE MaKhachHang = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, kh.getHo());
            stmt.setString(2, kh.getTen());
            stmt.setDate(3, new java.sql.Date(kh.getNgaySinh().getTime()));
            stmt.setString(4, kh.getGioiTinh());
            stmt.setString(5, kh.getEmail());
            stmt.setString(6, kh.getSoDienThoai());
            stmt.setInt(7, kh.getMaKhachHang());
            stmt.executeUpdate();
        }
    }
}
