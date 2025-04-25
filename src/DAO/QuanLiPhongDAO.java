
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;
import DTO.QuanLiPhongDTO;


public class QuanLiPhongDAO {
    public boolean kiemTraTonTai(int maPhong) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Phong WHERE MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPhong);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }
    
    public void themPhong(QuanLiPhongDTO phong) throws SQLException {
        String sql = "INSERT INTO Phong (MaPhong, MaLoaiPhong, SoGiuong, DonGia, TrangThai) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, phong.getMaPhong());
            stmt.setString(2, phong.getMaLoaiPhong());
            stmt.setInt(3, phong.getSoGiuong());
            stmt.setDouble(4, phong.getDonGia());
            stmt.setString(5, phong.getTrangThai());
            stmt.executeUpdate();
        }
    }
    
    public void suaPhong(QuanLiPhongDTO phong) throws SQLException {
        String sql = "UPDATE Phong SET MaLoaiPhong = ?, SoGiuong = ?, DonGia = ?, TrangThai = ? WHERE MaPhong = ?";
        try (Connection connection = DatabaseQLKS.getConnection(); 
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, phong.getMaLoaiPhong());
            stmt.setInt(2, phong.getSoGiuong());
            stmt.setDouble(3, phong.getDonGia());
            stmt.setString(4, phong.getTrangThai());
            stmt.setInt(5, phong.getMaPhong()); 

            int rowsAffected = stmt.executeUpdate(); 
            if (rowsAffected == 0) {
                throw new SQLException("Không tìm thấy phòng với mã: " + phong.getMaPhong());
            }
        }
    }
    
    public ArrayList<QuanLiPhongDTO> layDanhSachPhong() throws SQLException {
        ArrayList<QuanLiPhongDTO> dsp = new ArrayList<>();
        String sql = "SELECT * FROM Phong";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dsp.add(new QuanLiPhongDTO(
                    rs.getInt("MaPhong"),
                    rs.getString("MaLoaiPhong"),
                    rs.getInt("SoGiuong"),
                    rs.getDouble("DonGia"),
                    rs.getString("TrangThai")
                ));
            }
        }
        return dsp;
    }
    
    // Xóa phòng
    public void xoaPhong(int maPhong) throws SQLException {
        String sql = "DELETE FROM Phong WHERE MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPhong);
            stmt.executeUpdate();
        }
    }
    
    // Cập nhật trạng thái của phòng
    public void capNhatTrangThaiPhong(int maPhong, String trangThaiMoi) throws SQLException {
        String sql = "UPDATE Phong SET TrangThai = ? WHERE MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThaiMoi);
            stmt.setInt(2, maPhong);
            stmt.executeUpdate();
        }
    }
}
