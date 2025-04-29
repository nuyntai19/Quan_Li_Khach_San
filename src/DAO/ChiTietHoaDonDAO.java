package DAO;

import DTO.ChiTietHoaDonDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.DatabaseQLKS;

public class ChiTietHoaDonDAO {
    private final Connection conn;

    public ChiTietHoaDonDAO() throws SQLException {
        conn = DatabaseQLKS.getConnection();
    }
    


    public List<ChiTietHoaDonDTO> layDanhSachChiTietHoaDon() throws SQLException {
        List<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ChiTietHoaDonDTO hd = new ChiTietHoaDonDTO(
                rs.getInt("MaCtHD"),
                rs.getString("MaHD"),
                rs.getInt("MaPhong"),
                rs.getInt("MaDV"),
                rs.getString("LoaiChiTiet"),
                rs.getInt("SoLuong"),
                rs.getDouble("DonGia"),
                rs.getDouble("ThanhTien")
            );
            ds.add(hd);
        }
        return ds;
    }

    // Thêm danh sách chi tiết hóa đơn
    public boolean themDanhSachChiTiet(List<ChiTietHoaDonDTO> dsChiTiet) throws SQLException {
        String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaPhong, MaDV, LoaiChiTiet, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        for (ChiTietHoaDonDTO ct : dsChiTiet) {
            ps.setString(1, ct.getMaHD());
            ps.setInt(2, ct.getMaPhong());
            ps.setInt(3, ct.getMaDV());
            ps.setString(4, ct.getLoaiChiTiet());
            ps.setInt(5, ct.getSoLuong());
            ps.setDouble(6, ct.getDonGia());
            ps.setDouble(7, ct.getThanhTien());
            ps.addBatch();
        }

        int[] results = ps.executeBatch();
        for (int r : results) {
            if (r == Statement.EXECUTE_FAILED) {
                return false;
            }
        }
        return true;
    }

    // Xóa tất cả chi tiết hóa đơn theo mã hóa đơn
    public boolean xoaChiTietTheoMaHD(String maHD) throws SQLException {
        String sql = "DELETE FROM ChiTietHoaDon WHERE MaHD = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, maHD);
        ps.executeUpdate();
        return true;
    }
    
//    public List<ChiTietHoaDonDTO> layChiTietTheoMaHoaDon(String maHD) throws SQLException {
//        List<ChiTietHoaDonDTO> ds = new ArrayList<>();
//        String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHD = ?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, maHD);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO(
//                rs.getInt("MaCTHD"),
//                rs.getString("MaHD"),
//                rs.getInt("MaPhong"),
//                rs.getInt("MaDV"),
//                rs.getString("LoaiChiTiet"),
//                rs.getInt("SoLuong"),
//                rs.getDouble("DonGia"),
//                rs.getDouble("ThanhTien")
//            );
//            ds.add(ct);
//        }
//        return ds;
//    }
    
    public boolean insertChiTietHoaDon(ChiTietHoaDonDTO cthd) throws SQLException {
        String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaPhong, MaDV, LoaiChiTiet, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cthd.getMaHD());  // MaHD
            stmt.setInt(2, cthd.getMaPhong()); // MaPhong

            if (cthd.getMaDV() != null) {
                stmt.setInt(3, cthd.getMaDV());  // MaDichVu
            } else {
                stmt.setNull(3, Types.INTEGER);  // Null nếu không có MaDV
            }

            stmt.setString(4, cthd.getLoaiChiTiet());  // LoaiChiTiet
            stmt.setInt(5, cthd.getSoLuong());  // SoLuong
            stmt.setDouble(6, cthd.getDonGia());  // DonGia
            stmt.setDouble(7, cthd.getThanhTien());  // ThanhTien

            return stmt.executeUpdate() > 0;
        }
    }


    public List<ChiTietHoaDonDTO> getByMaHD(String maHD) throws SQLException {
        List<ChiTietHoaDonDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon WHERE MaHD = ?";

        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaCTHD(rs.getInt("MaCTHD"));
                cthd.setMaHD(rs.getString("MaHD"));
                cthd.setMaPhong(rs.getInt("MaPhong"));

                int maDV = rs.getInt("MaDV");
                if (rs.wasNull()) {
                    cthd.setMaDV(null);
                } else {
                    cthd.setMaDV(maDV);
                }

                cthd.setLoaiChiTiet(rs.getString("LoaiChiTiet"));
                cthd.setSoLuong(rs.getInt("SoLuong"));
                cthd.setDonGia(rs.getDouble("DonGia"));
                cthd.setThanhTien(rs.getDouble("ThanhTien"));

                list.add(cthd);
            }
        }

        return list;
    }

   
}
