package DAO;

import DTO.NhuYeuPham_DTO;
import sql.DatabaseQLKS;
import java.sql.*;
import java.util.ArrayList;

public class NhuYeuPhamDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public NhuYeuPhamDAO() {
        conn = null;
        ps = null;
        rs = null;
    }

    public boolean kiemTraTonTai(String maHang) throws SQLException {
        String sql = "SELECT COUNT(*) FROM NhuYeuPham WHERE MaHang = ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maHang);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
        return false;
    }

    public boolean themNhuYeuPham(NhuYeuPham_DTO nyp) throws SQLException {
        String sql = "INSERT INTO NhuYeuPham (MaHang, TenHang, DonVi, GiaNhap, SoLuongTon, NgayNhap, HanSuDung, NhaCungCap, TinhTrang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nyp.getMaHang());
            ps.setString(2, nyp.getTenHang());
            ps.setString(3, nyp.getDonVi());
            ps.setDouble(4, nyp.getGiaNhap());
            ps.setInt(5, nyp.getSoLuongTon());
            ps.setDate(6, new java.sql.Date(nyp.getNgayNhap().getTime()));
            ps.setDate(7, new java.sql.Date(nyp.getHanSuDung().getTime()));
            ps.setString(8, nyp.getNhaCungCap());
            ps.setString(9, nyp.getTinhTrang());
            return ps.executeUpdate() > 0;
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
    }

    public boolean suaNhuYeuPham(NhuYeuPham_DTO nyp) throws SQLException {
        String sql = "UPDATE NhuYeuPham SET TenHang=?, DonVi=?, GiaNhap=?, SoLuongTon=?, NgayNhap=?, HanSuDung=?, NhaCungCap=?, TinhTrang=? WHERE MaHang=?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nyp.getTenHang());
            ps.setString(2, nyp.getDonVi());
            ps.setDouble(3, nyp.getGiaNhap());
            ps.setInt(4, nyp.getSoLuongTon());
            ps.setDate(5, new java.sql.Date(nyp.getNgayNhap().getTime()));
            ps.setDate(6, new java.sql.Date(nyp.getHanSuDung().getTime()));
            ps.setString(7, nyp.getNhaCungCap());
            ps.setString(8, nyp.getTinhTrang());
            ps.setString(9, nyp.getMaHang());
            return ps.executeUpdate() > 0;
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
    }

    public boolean xoaNhuYeuPham(String maHang) throws SQLException {
        String sql = "DELETE FROM NhuYeuPham WHERE MaHang = ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maHang);
            return ps.executeUpdate() > 0;
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
    }

    public ArrayList<NhuYeuPham_DTO> layDanhSachNhuYeuPham() throws SQLException {
        ArrayList<NhuYeuPham_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM NhuYeuPham";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhuYeuPham_DTO nyp = new NhuYeuPham_DTO(
                    rs.getString("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonVi"),
                    rs.getDouble("GiaNhap"),
                    rs.getInt("SoLuongTon"),
                    rs.getDate("NgayNhap"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap"),
                    rs.getString("TinhTrang")
                );
                list.add(nyp);
            }
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
        return list;
    }

    public NhuYeuPham_DTO timNhuYeuPham(String maHang) throws SQLException {
        String sql = "SELECT * FROM NhuYeuPham WHERE MaHang = ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maHang);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new NhuYeuPham_DTO(
                    rs.getString("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonVi"),
                    rs.getDouble("GiaNhap"),
                    rs.getInt("SoLuongTon"),
                    rs.getDate("NgayNhap"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap"),
                    rs.getString("TinhTrang")
                );
            }
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
        return null;
    }

    public ArrayList<NhuYeuPham_DTO> timNhuYeuPhamTheoTen(String tenHang) throws SQLException {
        ArrayList<NhuYeuPham_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM NhuYeuPham WHERE TenHang LIKE ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenHang + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhuYeuPham_DTO nyp = new NhuYeuPham_DTO(
                    rs.getString("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonVi"),
                    rs.getDouble("GiaNhap"),
                    rs.getInt("SoLuongTon"),
                    rs.getDate("NgayNhap"),
                    rs.getDate("HanSuDung"),
                    rs.getString("NhaCungCap"),
                    rs.getString("TinhTrang")
                );
                list.add(nyp);
            }
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
        return list;
    }

    public boolean capNhatSoLuongTon(String maHang, int soLuong) throws SQLException {
        String sql = "UPDATE NhuYeuPham SET SoLuongTon = ? WHERE MaHang = ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setString(2, maHang);
            return ps.executeUpdate() > 0;
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
    }
} 
