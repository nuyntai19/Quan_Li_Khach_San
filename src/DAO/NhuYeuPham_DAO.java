package DAO;

import DTO.NhuYeuPham_DTO;
import java.sql.*;
import java.util.ArrayList;
import sql.DatabaseQLKS;

public class NhuYeuPham_DAO {
    private static final String TABLE_NAME = "NhuYeuPham";
    private static final String[] COLUMNS = {"MaNhuYeuPham", "TenNhuYeuPham", "DonViTinh", "GiaNhap", "HanSuDung", "NhaCungCap"};
    
    // Phương thức helper để tạo đối tượng NhuYeuPham_DTO từ ResultSet
    private NhuYeuPham_DTO createFromResultSet(ResultSet rs) throws SQLException {
        return new NhuYeuPham_DTO(
            rs.getInt(COLUMNS[0]),
            rs.getString(COLUMNS[1]),
            rs.getString(COLUMNS[2]),
            rs.getDouble(COLUMNS[3]),
            rs.getDate(COLUMNS[4]),
            rs.getString(COLUMNS[5])
        );
    }
    
    // Phương thức helper để thực thi truy vấn và trả về danh sách
    private ArrayList<NhuYeuPham_DTO> executeQuery(String sql, Object... params) {
        ArrayList<NhuYeuPham_DTO> list = new ArrayList<>();
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Date) {
                    stmt.setDate(i + 1, new java.sql.Date(((Date) params[i]).getTime()));
                } else if (params[i] instanceof Integer) {
                    stmt.setInt(i + 1, (Integer) params[i]);
                } else {
                    stmt.setString(i + 1, String.valueOf(params[i]));
                }
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(createFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Kiểm tra mã nhu yếu phẩm đã tồn tại chưa
    public boolean isMaNhuYeuPhamExists(int maNhuYeuPham) {
        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNhuYeuPham);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Thêm nhu yếu phẩm mới
    public boolean insert(NhuYeuPham_DTO nhuYeuPham) {
        if (isMaNhuYeuPhamExists(nhuYeuPham.getMaHang())) {
            return false;
        }
        
        String sql = "INSERT INTO " + TABLE_NAME + " (" + String.join(", ", COLUMNS) + ") VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nhuYeuPham.getMaHang());
            stmt.setString(2, nhuYeuPham.getTenHang());
            stmt.setString(3, nhuYeuPham.getDonViTinh());
            stmt.setDouble(4, nhuYeuPham.getGiaNhap());
            stmt.setDate(5, new java.sql.Date(nhuYeuPham.getHanSuDung().getTime()));
            stmt.setString(6, nhuYeuPham.getNhaCungCap());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Cập nhật thông tin nhu yếu phẩm
    public boolean update(NhuYeuPham_DTO nhuYeuPham) {
        String sql = "UPDATE " + TABLE_NAME + " SET " + 
                    COLUMNS[1] + " = ?, " + COLUMNS[2] + " = ?, " + 
                    COLUMNS[3] + " = ?, " + COLUMNS[4] + " = ?, " + 
                    COLUMNS[5] + " = ? WHERE " + COLUMNS[0] + " = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nhuYeuPham.getTenHang());
            stmt.setString(2, nhuYeuPham.getDonViTinh());
            stmt.setDouble(3, nhuYeuPham.getGiaNhap());
            stmt.setDate(4, new java.sql.Date(nhuYeuPham.getHanSuDung().getTime()));
            stmt.setString(5, nhuYeuPham.getNhaCungCap());
            stmt.setInt(6, nhuYeuPham.getMaHang());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa nhu yếu phẩm
    public boolean delete(int maNhuYeuPham) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNhuYeuPham);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Lấy thông tin nhu yếu phẩm theo mã
    public NhuYeuPham_DTO getById(int maNhuYeuPham) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " = ?";
        ArrayList<NhuYeuPham_DTO> result = executeQuery(sql, maNhuYeuPham);
        return result.isEmpty() ? null : result.get(0);
    }
    
    // Lấy danh sách tất cả nhu yếu phẩm
    public ArrayList<NhuYeuPham_DTO> getAll() {
        return executeQuery("SELECT * FROM " + TABLE_NAME);
    }
    
    // Tìm kiếm nhu yếu phẩm theo tên
    public ArrayList<NhuYeuPham_DTO> searchByName(String tenNhuYeuPham) {
        return executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[1] + " LIKE ?", "%" + tenNhuYeuPham + "%");
    }
    
    // Tìm kiếm nhu yếu phẩm theo mã
    public ArrayList<NhuYeuPham_DTO> searchByCode(int maNhuYeuPham) {
        return executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " LIKE ?", "%" + maNhuYeuPham + "%");
    }
    
    // Tìm kiếm nhu yếu phẩm theo nhà cung cấp
    public ArrayList<NhuYeuPham_DTO> searchBySupplier(String nhaCungCap) {
        return executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[5] + " LIKE ?", "%" + nhaCungCap + "%");
    }
    
    // Lấy danh sách nhu yếu phẩm sắp hết hạn
    public ArrayList<NhuYeuPham_DTO> getExpiringItems(Date expiryDate) {
        return executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[4] + " <= ? ORDER BY " + COLUMNS[4], expiryDate);
    }
}
