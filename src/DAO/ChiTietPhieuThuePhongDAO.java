package DAO;

import DTO.ChiTietPhieuThuePhongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;


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
                    rs.getDouble("thanhTien")
                ));
            }
        }
        return ds;
    }

    public void themChiTiet(ChiTietPhieuThuePhongDTO c) throws SQLException {
        String sql = "INSERT INTO ChiTietPhieuThue (MaThuePhong, MaPhong, NgayDatPhong, NgayTraPhong, GiaPhong, ThanhTien) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getMaThuePhong());
            stmt.setInt(2, c.getMaPhong());
            stmt.setDate(3, new java.sql.Date(c.getNgayDatPhong().getTime()));
            stmt.setDate(4, new java.sql.Date(c.getNgayTraPhong().getTime()));
            stmt.setDouble(5, c.getGiaPhong());
            stmt.setDouble(6, c.getThanhTien());
            stmt.executeUpdate();
        }
    }

    public void xoaChiTiet(int id) throws SQLException {
        String sql = "DELETE FROM ChiTietPhieuThue WHERE ID = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // Sử dụng ID để xác định bản ghi
            stmt.executeUpdate();
        }
    }

    public void capNhatChiTiet(ChiTietPhieuThuePhongDTO c) throws SQLException {
        String sql = "UPDATE ChiTietPhieuThue SET MaThuePhong = ?, MaPhong = ?, NgayDatPhong = ?, NgayTraPhong = ?, GiaPhong = ?, ThanhTien = ? WHERE ID = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getMaThuePhong());
            stmt.setInt(2, c.getMaPhong());
            stmt.setDate(3, new java.sql.Date(c.getNgayDatPhong().getTime()));
            stmt.setDate(4, new java.sql.Date(c.getNgayTraPhong().getTime()));
            stmt.setDouble(5, c.getGiaPhong());
            stmt.setDouble(6, c.getThanhTien());
            stmt.setInt(7, c.getId()); // Sử dụng ID để xác định bản ghi
            stmt.executeUpdate();
        }
    }

    public boolean kiemTraTonTai(int maThuePhong, int maPhong, java.util.Date ngayDatPhong, java.util.Date ngayTraPhong) throws SQLException {
        String sql = "SELECT * FROM ChiTietPhieuThue WHERE MaThuePhong = ? AND MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maThuePhong);
            stmt.setInt(2, maPhong);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                java.util.Date daDatTuNgay = rs.getDate("NgayDatPhong");
                java.util.Date daDatDenNgay = rs.getDate("NgayTraPhong");
                // Kiểm tra khoảng thời gian bị trùng (giao nhau)
                boolean isOverlapping = !(ngayTraPhong.before(daDatTuNgay) || ngayDatPhong.after(daDatDenNgay));
                if (isOverlapping) {
                    return true; // Trùng lặp
                }
            }
        }
        return false; // Không trùng lặp
    }
}
