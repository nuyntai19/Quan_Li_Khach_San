package DAO;

import DTO.DichVuDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.DatabaseQLKS;

public class DichVuDAO {
    private final Connection connection;

    public DichVuDAO() throws SQLException {
        // Giả sử bạn đã có class DBConnection để kết nối database
        connection = DatabaseQLKS.getConnection();
    }

    public List<DichVuDTO> getAll() throws SQLException {
        List<DichVuDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM DichVu";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            DichVuDTO dv = new DichVuDTO(
                rs.getInt("maDatDichVu"),
                rs.getString("maDichVu"),
                rs.getInt("soLuong"),
                rs.getDouble("donGia")
            );
            list.add(dv);
        }

        return list;
    }

    public List<DichVuDTO> findByMaDichVu(String maDV) throws SQLException {
        List<DichVuDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM DichVu WHERE maDichVu = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, maDV);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            DichVuDTO dv = new DichVuDTO(
                rs.getInt("maDatDichVu"),
                rs.getString("maDichVu"),
                rs.getInt("soLuong"),
                rs.getDouble("donGia")
            );
            list.add(dv);
        }

        return list;
    }
    public List<DichVuDTO> findByMaDatDichVu(String maDatDichVu) throws SQLException {
        List<DichVuDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM DichVu WHERE maDatDichVu = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, maDatDichVu);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            DichVuDTO dv = new DichVuDTO(
                rs.getInt("maDatDichVu"),
                rs.getString("maDichVu"),
                rs.getInt("soLuong"),
                rs.getDouble("donGia")
            );
            list.add(dv);
        }
        return list;
    }
}
