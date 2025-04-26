package DAO;

import DTO.HangHoa_DTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.DatabaseQLKS;

public class HangHoa_DAO {
    private static final String TABLE_NAME = "HangHoa";
    
    // Kiểm tra mã hàng hóa đã tồn tại chưa
    public boolean isMaHangExists(int maHang) {
        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE MaHang = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maHang);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Thêm hàng hóa mới
    public boolean insert(HangHoa_DTO hangHoa) {
        if (isMaHangExists(hangHoa.getMaHang())) {
            return false;
        }
        
        String sql = "INSERT INTO " + TABLE_NAME + " (MaHang, TenHang, DonViTinh, GiaNhap) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, hangHoa.getMaHang());
            stmt.setString(2, hangHoa.getTenHang());
            stmt.setString(3, hangHoa.getDonViTinh());
            stmt.setDouble(4, hangHoa.getGiaNhap());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Cập nhật thông tin hàng hóa
    public boolean update(HangHoa_DTO hangHoa) {
        String sql = "UPDATE " + TABLE_NAME + " SET TenHang = ?, DonViTinh = ?, GiaNhap = ? WHERE MaHang = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hangHoa.getTenHang());
            stmt.setString(2, hangHoa.getDonViTinh());
            stmt.setDouble(3, hangHoa.getGiaNhap());
            stmt.setInt(4, hangHoa.getMaHang());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa hàng hóa
    public boolean delete(int maHang) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE MaHang = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maHang);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Lấy thông tin hàng hóa theo mã
    public HangHoa_DTO getById(int maHang) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaHang = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maHang);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Lấy danh sách tất cả hàng hóa
    public List<HangHoa_DTO> getAll() {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Tìm kiếm hàng hóa theo tên
    public List<HangHoa_DTO> searchByName(String tenHang) {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE TenHang LIKE ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + tenHang + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Tìm kiếm hàng hóa theo mã
    public List<HangHoa_DTO> searchByCode(int maHang) {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaHang LIKE ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + maHang + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
