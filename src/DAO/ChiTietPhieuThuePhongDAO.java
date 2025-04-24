
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;
import DTO.ChiTietPhieuThuePhongDTO;


public class ChiTietPhieuThuePhongDAO {

    public ArrayList<ChiTietPhieuThuePhongDTO> layDanhSachChiTiet() throws SQLException {
        ArrayList<ChiTietPhieuThuePhongDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietPhieuThue";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ds.add(new ChiTietPhieuThuePhongDTO(
                    rs.getInt("maThuePhong"),
                    rs.getInt("maPhong"),
                    rs.getDate("ngayDatPhong"),
                    rs.getDate("ngayTraPhong"),
                    rs.getDouble("giaPhong"),
                    rs.getDouble("thanhTien"),
                    rs.getString("trangThai")
                ));
            }
        }
        return ds;
    }

    public void themChiTiet(ChiTietPhieuThuePhongDTO c) throws SQLException {
        String sql = "INSERT INTO ChiTietPhieuThue (MaThuePhong, MaPhong, NgayDatPhong, NgayTraPhong, GiaPhong, ThanhTien, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getMaThuePhong());
            stmt.setInt(2, c.getMaPhong());
            stmt.setDate(3, new java.sql.Date(c.getNgayDatPhong().getTime()));
            stmt.setDate(4, new java.sql.Date(c.getNgayTraPhong().getTime()));
            stmt.setDouble(5, c.getGiaPhong());
            stmt.setDouble(6, c.getThanhTien());
            stmt.setString(7, c.getTrangThai());
            stmt.executeUpdate();
        }
    }

    public void xoaChiTiet(int maThuePhong, int maPhong) throws SQLException {
        String sql = "DELETE FROM ChiTietPhieuThue WHERE MaThuePhong = ? AND MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maThuePhong);
            stmt.setInt(2, maPhong);
            stmt.executeUpdate();
        }
    }

    public void capNhatChiTiet(ChiTietPhieuThuePhongDTO c) throws SQLException {
        String sql = "UPDATE ChiTietPhieuThue SET NgayDatPhong = ?, NgayTraPhong = ?, GiaPhong = ?, ThanhTien = ?, TrangThai = ? WHERE MaThuePhong = ? AND MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(c.getNgayDatPhong().getTime()));
            stmt.setDate(2, new java.sql.Date(c.getNgayTraPhong().getTime()));
            stmt.setDouble(3, c.getGiaPhong());
            stmt.setDouble(4, c.getThanhTien());
            stmt.setString(5, c.getTrangThai());
            stmt.setInt(6, c.getMaThuePhong());
            stmt.setInt(7, c.getMaPhong());
            stmt.executeUpdate();
        }
    }
}
