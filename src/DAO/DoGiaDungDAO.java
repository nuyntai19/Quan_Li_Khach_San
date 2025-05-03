package DAO;

import DTO.DoGiaDung_DTO;
import sql.DatabaseQLKS;
import java.sql.*;
import java.util.ArrayList;

public class DoGiaDungDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public DoGiaDungDAO() {
        conn = null;
        ps = null;
        rs = null;
    }

    public boolean kiemTraTonTai(String maHang) throws SQLException {
        String sql = "SELECT COUNT(*) FROM DoGiaDung WHERE MaHang = ?";
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

    public boolean themDoGiaDung(DoGiaDung_DTO dgd) throws SQLException {
        String sql = "INSERT INTO DoGiaDung (MaHang, TenHang, DonVi, GiaNhap, SoLuongTon, NgayNhap, NhaCungCap, TinhTrang, MoTa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dgd.getMaHang());
            ps.setString(2, dgd.getTenHang());
            ps.setString(3, dgd.getDonVi());
            ps.setDouble(4, dgd.getGiaNhap());
            ps.setInt(5, dgd.getSoLuongTon());
            ps.setDate(6, new java.sql.Date(dgd.getNgayNhap().getTime()));
            ps.setString(7, dgd.getNhaCungCap());
            ps.setString(8, dgd.getTinhTrang());
            ps.setString(9, dgd.getMoTa());
            return ps.executeUpdate() > 0;
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
    }

    public boolean suaDoGiaDung(DoGiaDung_DTO dgd) throws SQLException {
        String sql = "UPDATE DoGiaDung SET TenHang=?, DonVi=?, GiaNhap=?, SoLuongTon=?, NgayNhap=?, NhaCungCap=?, TinhTrang=?, MoTa=? WHERE MaHang=?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dgd.getTenHang());
            ps.setString(2, dgd.getDonVi());
            ps.setDouble(3, dgd.getGiaNhap());
            ps.setInt(4, dgd.getSoLuongTon());
            ps.setDate(5, new java.sql.Date(dgd.getNgayNhap().getTime()));
            ps.setString(6, dgd.getNhaCungCap());
            ps.setString(7, dgd.getTinhTrang());
            ps.setString(8, dgd.getMoTa());
            ps.setString(9, dgd.getMaHang());
            return ps.executeUpdate() > 0;
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
    }

    public boolean xoaDoGiaDung(String maHang) throws SQLException {
        String sql = "DELETE FROM DoGiaDung WHERE MaHang = ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maHang);
            return ps.executeUpdate() > 0;
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
    }

    public ArrayList<DoGiaDung_DTO> layDanhSachDoGiaDung() throws SQLException {
        ArrayList<DoGiaDung_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM DoGiaDung";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DoGiaDung_DTO dgd = new DoGiaDung_DTO(
                    rs.getString("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonVi"),
                    rs.getDouble("GiaNhap"),
                    rs.getInt("SoLuongTon"),
                    rs.getDate("NgayNhap"),
                    rs.getString("NhaCungCap"),
                    rs.getString("TinhTrang"),
                    rs.getString("MoTa")
                );
                list.add(dgd);
            }
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
        return list;
    }

    public DoGiaDung_DTO timDoGiaDung(String maHang) throws SQLException {
        String sql = "SELECT * FROM DoGiaDung WHERE MaHang = ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, maHang);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new DoGiaDung_DTO(
                    rs.getString("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonVi"),
                    rs.getDouble("GiaNhap"),
                    rs.getInt("SoLuongTon"),
                    rs.getDate("NgayNhap"),
                    rs.getString("NhaCungCap"),
                    rs.getString("TinhTrang"),
                    rs.getString("MoTa")
                );
            }
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
        return null;
    }

    public ArrayList<DoGiaDung_DTO> timDoGiaDungTheoTen(String tenHang) throws SQLException {
        ArrayList<DoGiaDung_DTO> list = new ArrayList<>();
        String sql = "SELECT * FROM DoGiaDung WHERE TenHang LIKE ?";
        try {
            conn = DatabaseQLKS.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + tenHang + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                DoGiaDung_DTO dgd = new DoGiaDung_DTO(
                    rs.getString("MaHang"),
                    rs.getString("TenHang"),
                    rs.getString("DonVi"),
                    rs.getDouble("GiaNhap"),
                    rs.getInt("SoLuongTon"),
                    rs.getDate("NgayNhap"),
                    rs.getString("NhaCungCap"),
                    rs.getString("TinhTrang"),
                    rs.getString("MoTa")
                );
                list.add(dgd);
            }
        } finally {
            DatabaseQLKS.close(conn, ps, rs);
        }
        return list;
    }

    public boolean capNhatSoLuongTon(String maHang, int soLuong) throws SQLException {
        String sql = "UPDATE DoGiaDung SET SoLuongTon = ? WHERE MaHang = ?";
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
