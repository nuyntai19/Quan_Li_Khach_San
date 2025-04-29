package DAO;

import DTO.HangHoa_DTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HangHoa_DAO {
    private static final String TABLE_NAME = "HangHoa";
    private Connection conn;

    public HangHoa_DAO(Connection conn) {
        this.conn = conn;
    }
    
    // Kiểm tra mã hàng hóa đã tồn tại chưa
    public boolean isMaHangExists(int maHang) throws SQLException {
        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE MaHang = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maHang);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
    
    // Thêm hàng hóa mới
    public boolean insert(HangHoa_DTO hangHoa) throws SQLException {
        if (isMaHangExists(hangHoa.getMaHang())) {
            return false;
        }
        
        String sql = "INSERT INTO " + TABLE_NAME + " (MaHang, TenHang, DonViTinh, GiaNhap, LoaiHang, HanSuDung, NhaCungCap) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, hangHoa.getMaHang());
            pstmt.setString(2, hangHoa.getTenHang());
            pstmt.setString(3, hangHoa.getDonViTinh());
            pstmt.setDouble(4, hangHoa.getGiaNhap());
            pstmt.setString(5, hangHoa.getLoaiHang());
            pstmt.setDate(6, hangHoa.getHanSuDung());
            pstmt.setString(7, hangHoa.getNhaCungCap());
            return pstmt.executeUpdate() > 0;
        }
    }
    // Cập nhật thông tin hàng hóa
    public boolean update(HangHoa_DTO hangHoa) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET TenHang = ?, DonViTinh = ?, GiaNhap = ?, LoaiHang = ?, HanSuDung = ?, NhaCungCap = ? WHERE MaHang = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, hangHoa.getTenHang());
            pstmt.setString(2, hangHoa.getDonViTinh());
            pstmt.setDouble(3, hangHoa.getGiaNhap());
            pstmt.setString(4, hangHoa.getLoaiHang());
            pstmt.setDate(5, hangHoa.getHanSuDung());
            pstmt.setString(6, hangHoa.getNhaCungCap());
            pstmt.setInt(7, hangHoa.getMaHang());
            return pstmt.executeUpdate() > 0;
        }
    }
    
    // Xóa hàng hóa
    public boolean delete(int maHang) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE MaHang = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maHang);
            return pstmt.executeUpdate() > 0;
        }
    }
    
    // Lấy thông tin hàng hóa theo mã
    public HangHoa_DTO getById(int maHang) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaHang = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maHang);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap"),
                    rs.getString("LoaiHang"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap")
                );
            }
        }
        return null;
    }
    
    // Lấy danh sách tất cả hàng hóa
    public List<HangHoa_DTO> getAll() throws SQLException {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap"),
                    rs.getString("LoaiHang"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap")
                ));
            }
        }
        return list;
    }
    
    // Tìm kiếm hàng hóa theo tên
    public List<HangHoa_DTO> searchByName(String tenHang) throws SQLException {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE TenHang LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + tenHang + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap"),
                    rs.getString("LoaiHang"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap")
                ));
            }
        }
        return list;
    }
    
    // Tìm kiếm hàng hóa theo mã
    public List<HangHoa_DTO> searchByCode(int maHang) throws SQLException {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaHang = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, maHang);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap"),
                    rs.getString("LoaiHang"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap")
                ));
            }
        }
        return list;
    }

    public List<HangHoa_DTO> searchBySupplier(String nhaCungCap) throws SQLException {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE NhaCungCap LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nhaCungCap + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap"),
                    rs.getString("LoaiHang"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap")
                ));
            }
        }
        return list;
    }

    public List<HangHoa_DTO> searchByExpiryDate(Date expiryDate) throws SQLException {
        List<HangHoa_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE HanSuDung <= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, expiryDate);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new HangHoa_DTO(
                    rs.getInt("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonViTinh"),
                    rs.getDouble("GiaNhap"),
                    rs.getString("LoaiHang"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap")
                ));
            }
        }
        return list;
    }
}
