package DAO;

import DTO.NhuYeuPham_DTO;
import sql.DatabaseQLKS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhuYeuPham_DAO {

    // Kiểm tra xem mã hàng đã tồn tại chưa
    public boolean isMaNhuYeuPhamExist(String maNhuYeuPham) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT 1 FROM NhuYeuPham WHERE MaNhuYeuPham = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maNhuYeuPham);
            rs = stmt.executeQuery();

            return rs.next(); // Nếu có bản ghi, tức là mã hàng đã tồn tại
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
    }

    // Thêm mặt hàng NhuYeuPham mới
    public boolean insert(NhuYeuPham_DTO nhuYeuPham) {
        if (isMaNhuYeuPhamExist(nhuYeuPham.getMaNhuYeuPham())) {
            System.out.println("Mã hàng đã tồn tại.");
            return false;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "INSERT INTO NhuYeuPham (MaNhuYeuPham, TenNhuYeuPham, DonViTinh, GiaNhap) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, nhuYeuPham.getMaNhuYeuPham());
            stmt.setString(2, nhuYeuPham.getTenNhuYeuPham());
            stmt.setString(3, nhuYeuPham.getDonViTinh());
            stmt.setDouble(4, nhuYeuPham.getGiaNhap());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }

    // Cập nhật thông tin mặt hàng NhuYeuPham
    public boolean update(NhuYeuPham_DTO nhuYeuPham) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "UPDATE NhuYeuPham SET TenNhuYeuPham = ?, DonViTinh = ?, GiaNhap = ? WHERE MaNhuYeuPham = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, nhuYeuPham.getTenNhuYeuPham());
            stmt.setString(2, nhuYeuPham.getDonViTinh());
            stmt.setDouble(3, nhuYeuPham.getGiaNhap());
            stmt.setString(4, nhuYeuPham.getMaNhuYeuPham());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }

    // Xóa mặt hàng NhuYeuPham theo mã
    public boolean delete(String maNhuYeuPham) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "DELETE FROM NhuYeuPham WHERE MaNhuYeuPham = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maNhuYeuPham);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
    }

    // Lấy thông tin mặt hàng NhuYeuPham theo mã
    public NhuYeuPham_DTO getById(String maNhuYeuPham) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM NhuYeuPham WHERE MaNhuYeuPham = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, maNhuYeuPham);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new NhuYeuPham_DTO(
                        rs.getString("MaNhuYeuPham"),
                        rs.getString("TenNhuYeuPham"),
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

    // Lấy danh sách tất cả mặt hàng NhuYeuPham
    public List<NhuYeuPham_DTO> getAll() {
        List<NhuYeuPham_DTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM NhuYeuPham";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new NhuYeuPham_DTO(
                        rs.getString("MaNhuYeuPham"),
                        rs.getString("TenNhuYeuPham"),
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

    // Tìm kiếm mặt hàng NhuYeuPham theo tên
    public List<NhuYeuPham_DTO> searchByName(String tenNhuY
