package DAO;

import DTO.HangHoa;
import DTO.DoGiaDung_DTO;
import DTO.NhuYeuPham_DTO;
import sql.DatabaseQLKS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HangHoa_DAO {
    
    // Thêm hàng hóa mới vào database
    public boolean insert(HangHoa hangHoa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "INSERT INTO HangHoa (MaHang, TenHang, DonViTinh, GiaNhap) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, Integer.parseInt(hangHoa.getMaHang()));
            stmt.setString(2, hangHoa.getTenHang());
            stmt.setString(3, hangHoa.getDonViTinh());
            stmt.setDouble(4, hangHoa.getGiaNhap());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }
    
    // Cập nhật thông tin hàng hóa
    public boolean update(HangHoa hangHoa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "UPDATE HangHoa SET TenHang = ?, DonViTinh = ?, GiaNhap = ? WHERE MaHang = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, hangHoa.getTenHang());
            stmt.setString(2, hangHoa.getDonViTinh());
            stmt.setDouble(3, hangHoa.getGiaNhap());
            stmt.setInt(4, Integer.parseInt(hangHoa.getMaHang()));
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }
    
    // Xóa hàng hóa theo mã
    public boolean delete(String maHang) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "DELETE FROM HangHoa WHERE MaHang = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, Integer.parseInt(maHang));
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }
    
    // Lấy thông tin hàng hóa theo mã
    public HangHoa getById(String maHang) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM HangHoa WHERE MaHang = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, Integer.parseInt(maHang));
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                HangHoa hangHoa = new HangHoa();
                hangHoa.setMaHang(rs.getString("MaHang"));
                hangHoa.setTenHang(rs.getString("TenHang"));
                hangHoa.setDonViTinh(rs.getString("DonViTinh"));
                hangHoa.setGiaNhap(rs.getInt("GiaNhap"));
                
                return hangHoa;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return null;
    }
    
    // Lấy danh sách tất cả hàng hóa
    public List<HangHoa> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<HangHoa> list = new ArrayList<>();
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM HangHoa";
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                HangHoa hangHoa = new HangHoa();
                hangHoa.setMaHang(rs.getString("MaHang"));
                hangHoa.setTenHang(rs.getString("TenHang"));
                hangHoa.setDonViTinh(rs.getString("DonViTinh"));
                hangHoa.setGiaNhap(rs.getInt("GiaNhap"));
                
                list.add(hangHoa);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return list;
    }
    
    // Tìm kiếm hàng hóa theo tên
    public List<HangHoa> searchByName(String tenHang) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<HangHoa> list = new ArrayList<>();
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM HangHoa WHERE TenHang LIKE ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, "%" + tenHang + "%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                HangHoa hangHoa = new HangHoa();
                hangHoa.setMaHang(rs.getString("MaHang"));
                hangHoa.setTenHang(rs.getString("TenHang"));
                hangHoa.setDonViTinh(rs.getString("DonViTinh"));
                hangHoa.setGiaNhap(rs.getInt("GiaNhap"));
                
                list.add(hangHoa);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return list;
    }
}
