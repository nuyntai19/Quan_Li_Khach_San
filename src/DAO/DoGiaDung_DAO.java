package DAO;

import DTO.DoGiaDung_DTO;
import java.sql.*;
import java.util.ArrayList;
import sql.DatabaseQLKS;

public class DoGiaDung_DAO {
    private static final String TABLE_NAME = "DoGiaDung";
    private static final String[] COLUMNS = {"MaDoGiaDung", "TenDoGiaDung", "DonViTinh", "GiaNhap", "TinhTrang"};
    
    // Phương thức helper để tạo đối tượng DoGiaDung_DTO từ ResultSet
    private DoGiaDung_DTO createFromResultSet(ResultSet rs) throws SQLException {
        return new DoGiaDung_DTO(
            rs.getInt(COLUMNS[0]),
            rs.getString(COLUMNS[1]),
            rs.getString(COLUMNS[2]),
            rs.getDouble(COLUMNS[3]),
            rs.getString(COLUMNS[4])
        );
    }
    
    // Phương thức helper để thực thi truy vấn và trả về danh sách
    private ArrayList<DoGiaDung_DTO> executeQuery(String sql, Object... params) {
        ArrayList<DoGiaDung_DTO> list = new ArrayList<>();
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
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
    
    // Kiểm tra mã đồ gia dụng đã tồn tại chưa
    public boolean isMaDoGiaDungExists(int maDoGiaDung) {
        String sql = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDoGiaDung);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Thêm đồ gia dụng mới
    public boolean insert(DoGiaDung_DTO doGiaDung) {
        if (isMaDoGiaDungExists(doGiaDung.getMaHang())) {
            return false;
        }
        
        String sql = "INSERT INTO " + TABLE_NAME + " (" + String.join(", ", COLUMNS) + ") VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, doGiaDung.getMaHang());
            stmt.setString(2, doGiaDung.getTenHang());
            stmt.setString(3, doGiaDung.getDonViTinh());
            stmt.setDouble(4, doGiaDung.getGiaNhap());
            stmt.setString(5, doGiaDung.getTinhTrang());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Cập nhật thông tin đồ gia dụng
    public boolean update(DoGiaDung_DTO doGiaDung) {
        String sql = "UPDATE " + TABLE_NAME + " SET " + 
                    COLUMNS[1] + " = ?, " + COLUMNS[2] + " = ?, " + 
                    COLUMNS[3] + " = ?, " + COLUMNS[4] + " = ? WHERE " + 
                    COLUMNS[0] + " = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, doGiaDung.getTenHang());
            stmt.setString(2, doGiaDung.getDonViTinh());
            stmt.setDouble(3, doGiaDung.getGiaNhap());
            stmt.setString(4, doGiaDung.getTinhTrang());
            stmt.setInt(5, doGiaDung.getMaHang());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa đồ gia dụng
    public boolean delete(int maDoGiaDung) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maDoGiaDung);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Lấy thông tin đồ gia dụng theo mã
    public DoGiaDung_DTO getById(int maDoGiaDung) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " = ?";
        ArrayList<DoGiaDung_DTO> result = executeQuery(sql, maDoGiaDung);
        return result.isEmpty() ? null : result.get(0);
    }
    
    // Lấy danh sách tất cả đồ gia dụng
    public ArrayList<DoGiaDung_DTO> getAll() {
        return executeQuery("SELECT * FROM " + TABLE_NAME);
    }
    
    // Tìm kiếm đồ gia dụng theo tên
    public ArrayList<DoGiaDung_DTO> searchByName(String tenDoGiaDung) {
        return executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[1] + " LIKE ?", "%" + tenDoGiaDung + "%");
    }
    
    // Tìm kiếm đồ gia dụng theo mã
    public ArrayList<DoGiaDung_DTO> searchByCode(int maDoGiaDung) {
        return executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[0] + " LIKE ?", "%" + maDoGiaDung + "%");
    }
    
    // Tìm kiếm đồ gia dụng theo tình trạng
    public ArrayList<DoGiaDung_DTO> searchByStatus(String tinhTrang) {
        return executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMNS[4] + " = ?", tinhTrang);
    }
}
