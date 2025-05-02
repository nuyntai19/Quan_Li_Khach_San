package DAO;

import DTO.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;
import sql.DatabaseQLKS; // Giữ như project cũ bạn

public class NhanVienDAO {
    private final Connection con;

    public NhanVienDAO() throws SQLException {
        con = DatabaseQLKS.getConnection();
    }

    public ArrayList<NhanVienDTO> layDanhSachNhanVien() throws SQLException {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new NhanVienDTO(
                rs.getInt("MaNhanVien"),
                rs.getString("Ten"),
                rs.getString("Ho"),
                rs.getDate("NgaySinh"),
                rs.getString("GioiTinh"),
                rs.getString("Email"),
                rs.getString("SoDienThoai"),
                rs.getString("ChucVu"),
                rs.getDouble("Luong")
            ));
        }
        return list;
    }

    public void themNhanVien(NhanVienDTO nv) throws SQLException {
        String sql = "INSERT INTO NhanVien VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, nv.getMaNhanVien());
        ps.setString(2, nv.getTen());
        ps.setString(3, nv.getHo());
        ps.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime())); // Tham số thứ 4
        ps.setString(5, nv.getGioiTinh());
        ps.setString(6, nv.getEmail());
        ps.setString(7, nv.getSdt());
        ps.setString(8, nv.getChucVu());
        ps.setDouble(9, nv.getLuong());

        ps.executeUpdate();
    }


    public void suaNhanVien(NhanVienDTO nv) throws SQLException {
        String sql = "UPDATE NhanVien SET Ten=?, Ho=?, NgaySinh=?, GioiTinh=?, Email=?, SoDienThoai=?, ChucVu=?, Luong=? WHERE MaNhanVien=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nv.getTen());
        ps.setString(2, nv.getHo());
        ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
        ps.setString(4, nv.getGioiTinh());
        ps.setString(5, nv.getEmail());
        ps.setString(6, nv.getSdt());
        ps.setString(7, nv.getChucVu());
        ps.setDouble(8, nv.getLuong());
        ps.setInt(9, nv.getMaNhanVien());
        ps.executeUpdate();
    }

    public void xoaNhanVien(int maNhanVien) throws SQLException {
        String sql = "DELETE FROM NhanVien WHERE MaNhanVien=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, maNhanVien);
        ps.executeUpdate();
    }
}
