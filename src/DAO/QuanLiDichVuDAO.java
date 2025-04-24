
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;
import DTO.QuanLiDichVuDTO;

public class QuanLiDichVuDAO {
    public boolean kiemTraTonTai(int maDichVu) throws SQLException {
        String sql = "SELECT COUNT(*) FROM DichVu WHERE MaDichVu = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDichVu);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }
    
    public void themDichVu(QuanLiDichVuDTO dv) throws SQLException {
        String sql = "INSERT INTO DichVu (MaDichVu, TenDichVu, MoTa, DonGia, SoLuong) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dv.getMaDichVu());
            stmt.setString(2, dv.getTenDichVu());
            stmt.setString(3, dv.getMoTa());
            stmt.setDouble(4, dv.getDonGia());
            stmt.setInt(5, dv.getSoLuong());
            stmt.executeUpdate();
        }
    }
    
    public void suaDichVu(QuanLiDichVuDTO dv) throws SQLException {
        String sql = "UPDATE DichVu SET TenDichVu = ?, MoTa = ?, DonGia = ?, SoLuong = ? WHERE MaDichVu = ?";
        try (Connection connection = DatabaseQLKS.getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, dv.getTenDichVu());   
            stmt.setString(2, dv.getMoTa());       
            stmt.setDouble(3, dv.getDonGia());
            stmt.setInt(4, dv.getSoLuong());        
            stmt.setInt(5, dv.getMaDichVu());      

            int rowsAffected = stmt.executeUpdate(); 
            if (rowsAffected == 0) {
                throw new SQLException("Không tìm thấy dịch vụ với mã: " + dv.getMaDichVu());
            }
        }
    }
    
    public ArrayList<QuanLiDichVuDTO> layDanhSachDichVu() throws SQLException {
        ArrayList<QuanLiDichVuDTO> dsp = new ArrayList<>();
        String sql = "SELECT * FROM DichVu";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dsp.add(new QuanLiDichVuDTO(
                    rs.getInt("MaDichVu"),
                    rs.getString("TenDichVu"),
                    rs.getString("MoTa"),
                    rs.getDouble("DonGia"),
                    rs.getInt("SoLuong")
                ));
            }
        }
        return dsp;
    }
    
    
    // Xóa phòng
    public void xoaDichVu(int maDichVu) throws SQLException {
        String sql = "DELETE FROM DichVu WHERE MaDichVu = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDichVu);
            stmt.executeUpdate();
        }
    }
    
    public void giamSoLuongDichVu(int maDichVu, int soLuongGiam) throws SQLException {
        String sql = "UPDATE DichVu SET SoLuong = SoLuong - ? WHERE MaDichVu = ? AND SoLuong >= ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, soLuongGiam);
            stmt.setInt(2, maDichVu);    
            stmt.setInt(3, soLuongGiam);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Không đủ số lượng dịch vụ hoặc mã dịch vụ không tồn tại.");
            }
        }
    }
}
