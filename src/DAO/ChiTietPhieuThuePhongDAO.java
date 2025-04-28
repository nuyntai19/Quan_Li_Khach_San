package DAO;

import DTO.ChiTietPhieuThuePhongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sql.DatabaseQLKS;


public class ChiTietPhieuThuePhongDAO {

    public ArrayList<ChiTietPhieuThuePhongDTO> layDanhSachChiTiet() throws SQLException {
        ArrayList<ChiTietPhieuThuePhongDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietPhieuThue";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ds.add(new ChiTietPhieuThuePhongDTO(
                    rs.getInt("ID"),
                    rs.getInt("maThuePhong"),
                    rs.getInt("maPhong"),
                    rs.getDate("ngayDatPhong"),
                    rs.getDate("ngayTraPhong"),
                    rs.getDouble("giaPhong"),
                    rs.getDouble("thanhTien")
                ));
            }
        }
        return ds;
    }

    public void themChiTiet(ChiTietPhieuThuePhongDTO c) throws SQLException {
        String sql = "INSERT INTO ChiTietPhieuThue (MaThuePhong, MaPhong, NgayDatPhong, NgayTraPhong, GiaPhong, ThanhTien) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getMaThuePhong());
            stmt.setInt(2, c.getMaPhong());
            stmt.setDate(3, new java.sql.Date(c.getNgayDatPhong().getTime()));
            stmt.setDate(4, new java.sql.Date(c.getNgayTraPhong().getTime()));
            stmt.setDouble(5, c.getGiaPhong());
            stmt.setDouble(6, c.getThanhTien());
            stmt.executeUpdate();
        }
    }

    public void xoaChiTiet(int id) throws SQLException {
        String sql = "DELETE FROM ChiTietPhieuThue WHERE ID = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // Sử dụng ID để xác định bản ghi
            stmt.executeUpdate();
        }
    }

    public void capNhatChiTiet(ChiTietPhieuThuePhongDTO c) throws SQLException {
        String sql = "UPDATE ChiTietPhieuThue SET MaThuePhong = ?, MaPhong = ?, NgayDatPhong = ?, NgayTraPhong = ?, GiaPhong = ?, ThanhTien = ? WHERE ID = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getMaThuePhong());
            stmt.setInt(2, c.getMaPhong());
            stmt.setDate(3, new java.sql.Date(c.getNgayDatPhong().getTime()));
            stmt.setDate(4, new java.sql.Date(c.getNgayTraPhong().getTime()));
            stmt.setDouble(5, c.getGiaPhong());
            stmt.setDouble(6, c.getThanhTien());
            stmt.setInt(7, c.getId()); // Sử dụng ID để xác định bản ghi
            stmt.executeUpdate();
        }
    }

    public boolean kiemTraTonTai(int maThuePhong, int maPhong, java.util.Date ngayDatPhong, java.util.Date ngayTraPhong) throws SQLException {
        String sql = "SELECT * FROM ChiTietPhieuThue WHERE MaThuePhong = ? AND MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maThuePhong);
            stmt.setInt(2, maPhong);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                java.util.Date daDatTuNgay = rs.getDate("NgayDatPhong");
                java.util.Date daDatDenNgay = rs.getDate("NgayTraPhong");
                // Kiểm tra khoảng thời gian bị trùng (giao nhau)
                boolean isOverlapping = !(ngayTraPhong.before(daDatTuNgay) || ngayDatPhong.after(daDatDenNgay));
                if (isOverlapping) {
                    return true; // Trùng lặp
                }
            }
        }
        return false; // Không trùng lặp
    }
    
   public ArrayList<ChiTietPhieuThuePhongDTO> timChiTietPhieuThue(String maDatPhongStr, String maPhongStr, String ngayDatPhong, String ngayTraPhong) throws SQLException {
    ArrayList<ChiTietPhieuThuePhongDTO> ketQua = new ArrayList<>();
    String sql = "SELECT * FROM ChiTietPhieuThue WHERE 1=1";
    
    List<Object> params = new ArrayList<>();
    
    if (maDatPhongStr != null && !maDatPhongStr.trim().isEmpty()) {
        sql += " AND MaThuePhong = ?";
        params.add(Integer.parseInt(maDatPhongStr));  // BỔ SUNG
    }
    if (maPhongStr != null && !maPhongStr.trim().isEmpty()) {
        sql += " AND MaPhong = ?";
        params.add(Integer.parseInt(maPhongStr));     // BỔ SUNG
    }
    if (ngayDatPhong != null && !ngayDatPhong.isEmpty()) {
        sql += " AND NgayDatPhong = ?";
        params.add(java.sql.Date.valueOf(ngayDatPhong));
    }
    if (ngayTraPhong != null && !ngayTraPhong.isEmpty()) {
        sql += " AND NgayTraPhong = ?";
        params.add(java.sql.Date.valueOf(ngayTraPhong));
    }

    System.out.println("SQL query: " + sql);

    try (Connection conn = DatabaseQLKS.getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        int index = 1;
        for (Object param : params) {
            if (param instanceof Integer) {
                stmt.setInt(index++, (Integer) param);
            } else if (param instanceof java.sql.Date) {
                stmt.setDate(index++, (java.sql.Date) param);
            }
        }

        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            ChiTietPhieuThuePhongDTO ct = new ChiTietPhieuThuePhongDTO(
                    rs.getInt("ID"),
                    rs.getInt("MaThuePhong"),
                    rs.getInt("MaPhong"),
                    rs.getDate("NgayDatPhong"),
                    rs.getDate("NgayTraPhong"),
                    rs.getDouble("GiaPhong"),
                    rs.getDouble("ThanhTien")
            );
            ketQua.add(ct);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new SQLException("Lỗi khi truy vấn chi tiết phiếu thuê.", e);
    }
    return ketQua;
}


}

