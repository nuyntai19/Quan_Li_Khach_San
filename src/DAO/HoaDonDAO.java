package DAO;

import DTO.HoaDonDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.DatabaseQLKS;

public class HoaDonDAO {
    private final Connection conn;

    public HoaDonDAO() throws SQLException {
        conn = DatabaseQLKS.getConnection();
    }

    public boolean kiemTraTonTai(int maPTP) throws SQLException {
        String sql = "SELECT * FROM HoaDon WHERE MaPTP = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, maPTP);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    

    public List<HoaDonDTO> layDanhSachHoaDon() throws SQLException {
        List<HoaDonDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            HoaDonDTO hd = new HoaDonDTO(
                rs.getString("MaHD"),
                rs.getInt("MaPTP"),
                rs.getDate("NgayLap"),
                rs.getDouble("TongTien")
            );
            ds.add(hd);
        }
        return ds;
    }

    public boolean xoaHoaDon(String maHoaDon) throws SQLException {
        String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, maHoaDon);
        return ps.executeUpdate() > 0;
    }
    
    public boolean insertHoaDon(String maHD, String maPTP, Date ngayLap, double tongTien) throws SQLException {
        String sql = "INSERT INTO HoaDon (MaHD, MaPTP, NgayLap, TongTien) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, maHD);
        stmt.setString(2, maPTP);
        stmt.setDate(3, new java.sql.Date(ngayLap.getTime()));
        stmt.setDouble(4, tongTien);
        return stmt.executeUpdate() > 0;
    }
    
    public boolean updateTongTien(String maHD, double tongTien) throws SQLException {
        String sql = "UPDATE HoaDon SET TongTien = ? WHERE MaHD = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, tongTien);
        stmt.setString(2, maHD);
        return stmt.executeUpdate() > 0;
    }
    
    public int demSoLuongHoaDon() {
        String sql = "SELECT COUNT(*) AS SoLuong FROM HoaDon";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("SoLuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
