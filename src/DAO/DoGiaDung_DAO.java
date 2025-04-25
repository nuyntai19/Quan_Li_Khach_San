package DAO;

import DTO.DoGiaDung_DTO;
import sql.DatabaseQLKS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoGiaDung_DAO {

    // Kiểm tra xem mã hàng đã tồn tại chưa
    public boolean isMaDoGiaDungExist(String maDoGiaDung) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT 1 FROM DoGiaDung WHERE MaDoGiaDung = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maDoGiaDung);
            rs = stmt.executeQuery();

            return rs.next(); // Nếu có bản ghi, tức là mã hàng đã tồn tại
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
    }

    // Thêm mặt hàng DoGiaDung mới
    public boolean insert(DoGiaDung_DTO doGiaDung) {
        if (isMaDoGiaDungExist(doGiaDung.getMaDoGiaDung())) {
            System.out.println("Mã hàng đã tồn tại.");
            return false;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "INSERT INTO DoGiaDung (MaDoGiaDung, TenDoGiaDung, DonViTinh, GiaNhap) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, doGiaDung.getMaDoGiaDung());
            stmt.setString(2, doGiaDung.getTenDoGiaDung());
            stmt.setString(3, doGiaDung.getDonViTinh());
            stmt.setDouble(4, doGiaDung.getGiaNhap());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }

    // Cập nhật thông tin mặt hàng DoGiaDung
    public boolean update(DoGiaDung_DTO doGiaDung) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "UPDATE DoGiaDung SET TenDoGiaDung = ?, DonViTinh = ?, GiaNhap = ? WHERE MaDoGiaDung = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, doGiaDung.getTenDoGiaDung());
            stmt.setString(2, doGiaDung.getDonViTinh());
            stmt.setDouble(3, doGiaDung.getGiaNhap());
            stmt.setString(4, doGiaDung.getMaDoGiaDung());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }

    // Xóa mặt hàng DoGiaDung theo mã
    public boolean delete(String maDoGiaDung) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "DELETE FROM DoGiaDung WHERE MaDoGiaDung = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maDoGiaDung);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }

    // Lấy thông tin mặt hàng DoGiaDung theo mã
    public DoGiaDung_DTO getById(String maDoGiaDung) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM DoGiaDung WHERE MaDoGiaDung = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maDoGiaDung);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new DoGiaDung_DTO(
                        rs.getString("MaDoGiaDung"),
                        rs.getString("TenDoGiaDung"),
                        rs.getString("DonViTinh"),
                        rs.getDouble("GiaNhap")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        return null;
    }

    // Lấy danh sách tất cả mặt hàng DoGiaDung
    public List<DoGiaDung_DTO> getAll() {
        List<DoGiaDung_DTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM DoGiaDung";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new DoGiaDung_DTO(
                        rs.getString("MaDoGiaDung"),
                        rs.getString("TenDoGiaDung"),
                        rs.getString("DonViTinh"),
                        rs.getDouble("GiaNhap")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        return list;
    }

    // Tìm kiếm mặt hàng DoGiaDung theo tên
    public List<DoGiaDung_DTO> searchByName(String tenDoGiaDung) {
        List<DoGiaDung_DTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM DoGiaDung WHERE TenDoGiaDung LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + tenDoGiaDung + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new DoGiaDung_DTO(
                        rs.getString("MaDoGiaDung"),
                        rs.getString("TenDoGiaDung"),
                        rs.getString("DonViTinh"),
                        rs.getDouble("GiaNhap")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        return list;
    }
}
