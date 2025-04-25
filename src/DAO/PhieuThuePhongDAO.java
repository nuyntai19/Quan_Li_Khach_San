package DAO;


import DTO.PhieuThuePhongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;


public class PhieuThuePhongDAO {
    public boolean kiemTraTonTai(int maDatPhong) throws SQLException {
        String sql = "SELECT COUNT(*) FROM PhieuThuePhong WHERE MaThuePhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDatPhong);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu tìm thấy mã thuê phòng
            }
        }
        return false; // Trả về false nếu không tìm thấy
    }
    
    public ArrayList<PhieuThuePhongDTO> layDanhSachPhieuThue() throws SQLException {
        ArrayList<PhieuThuePhongDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM PhieuThuePhong";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ds.add(new PhieuThuePhongDTO(
                    rs.getInt("MaThuePhong"),
                    rs.getInt("MaKhachHang"),
                    rs.getInt("MaNhanVien"),
                    rs.getDate("NgayLapPhieu"),
                    rs.getDouble("TongTien"),
                    rs.getString("TrangThai")
                ));
            }
        }
        return ds;
    }

    public void themPhieuThue(PhieuThuePhongDTO p) throws SQLException {
        String sql = "INSERT INTO PhieuThuePhong (MaThuePhong, MaKhachHang, MaNhanVien, NgayLapPhieu, TongTien, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false); // Bắt đầu giao dịch
            stmt.setInt(1, p.getMaThuePhong());
            stmt.setInt(2, p.getMaKhachHang());
            stmt.setInt(3, p.getMaNhanVien());
            stmt.setDate(4, new java.sql.Date(p.getNgayLapPhieu().getTime()));
            stmt.setDouble(5, p.getTongTien());
            stmt.setString(6, p.getTrangThai());
            stmt.executeUpdate();
            conn.commit(); // Commit giao dịch
        } catch (SQLException e) {
            throw e;
        }
    }

    public void xoaPhieuThue(int maThuePhong) throws SQLException {
        String sql = "DELETE FROM PhieuThuePhong WHERE MaThuePhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maThuePhong);
            stmt.executeUpdate();
        }
    }

    public void capNhatPhieuThue(PhieuThuePhongDTO p) throws SQLException {
        String sql = "UPDATE PhieuThuePhong SET MaKhachHang = ?, MaNhanVien = ?, NgayLapPhieu = ?, TongTien = ?, TrangThai = ? WHERE MaThuePhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getMaKhachHang());
            stmt.setInt(2, p.getMaNhanVien());
            stmt.setDate(4, new java.sql.Date(p.getNgayLapPhieu().getTime()));
            stmt.setDouble(5, p.getTongTien());
            stmt.setString(5, p.getTrangThai());
            stmt.setInt(6, p.getMaThuePhong());
            stmt.executeUpdate();
        }
    }

}
