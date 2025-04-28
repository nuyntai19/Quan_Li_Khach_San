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

    public List<HoaDonDTO> layDanhSachHoaDon() throws SQLException {
        List<HoaDonDTO> list = new ArrayList<>();
        String sql = "SELECT hd.MaHD, hd.MaPTP, ptp.MaKhachHang, hd.NgayLap, hd.TongTien " +
                     "FROM HoaDon hd " +
                     "JOIN PhieuThuePhong ptp ON hd.MaPTP = ptp.MaThuePhong";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            HoaDonDTO hd = new HoaDonDTO(
                rs.getInt("MaHD"),
                rs.getInt("MaPTP"),
                rs.getInt("MaKhachHang"),
                rs.getDate("NgayLap"),
                rs.getDouble("TongTien")
            );
            list.add(hd);
        }
        return list;
    }

    public void xoaHoaDon(int maHD) throws SQLException {
        String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, maHD);
        pstmt.executeUpdate();
    }
    
    public void themHoaDon(HoaDonDTO hd) throws SQLException {
    String sql = "INSERT INTO HoaDon (MaHD, MaPTP, NgayLap, TongTien) VALUES (?, ?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, hd.getMaHD());
    pstmt.setInt(2, hd.getMaPTP());
    pstmt.setDate(3, new java.sql.Date(hd.getNgayLap().getTime()));
    pstmt.setDouble(4, hd.getTongTien());
    pstmt.executeUpdate();
}

}
