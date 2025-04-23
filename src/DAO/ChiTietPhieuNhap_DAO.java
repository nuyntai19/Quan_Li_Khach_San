package DAO;

import DTO.ChiTietPhieuNhap_DTO;
import java.sql.*;
import java.util.ArrayList;
import sql.DatabaseQLKS; // lớp kết nối DB
import java.time.LocalDate;

public class ChiTietPhieuNhap_DAO {

    public ArrayList<ChiTietPhieuNhap_DTO> getAllChiTietPhieuNhap() {
        ArrayList<ChiTietPhieuNhap_DTO> list = new ArrayList<>();
        try (Connection conn = DatabaseQLKS.getConnection()) {
            String sql = "SELECT * FROM ChiTietPhieuNhap";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ChiTietPhieuNhap_DTO ct = new ChiTietPhieuNhap_DTO(
                    rs.getString("maPhieuNhap"),
                    rs.getString("maNhanVien"),
                    rs.getString("maNhaCungCap"),
                    rs.getDate("ngayNhap").toLocalDate(),
                    rs.getDouble("tongTien"),
                    rs.getString("maHang"),
                    rs.getDouble("soLuong"),
                    rs.getDouble("donGia"),
                    rs.getString("ghiChu")
                );
                list.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertChiTietPhieuNhap(ChiTietPhieuNhap_DTO ct) {
        String sql = "INSERT INTO ChiTietPhieuNhap VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ct.getMaPhieuNhap());
            stmt.setString(2, ct.getMaNhanVien());
            stmt.setString(3, ct.getMaNhaCungCap());
            stmt.setDate(4, Date.valueOf(ct.getNgayNhap()));
            stmt.setDouble(5, ct.getTongTien());
            stmt.setString(6, ct.getMaHang());
            stmt.setDouble(7, ct.getSoLuong());
            stmt.setDouble(8, ct.getDonGia());
            stmt.setString(9, ct.getGhiChu());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateChiTietPhieuNhap(ChiTietPhieuNhap_DTO ct) {
        String sql = "UPDATE ChiTietPhieuNhap SET maNhanVien=?, maNhaCungCap=?, ngayNhap=?, tongTien=?, soLuong=?, donGia=?, ghiChu=? WHERE maPhieuNhap=? AND maHang=?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ct.getMaNhanVien());
            stmt.setString(2, ct.getMaNhaCungCap());
            stmt.setDate(3, Date.valueOf(ct.getNgayNhap()));
            stmt.setDouble(4, ct.getTongTien());
            stmt.setDouble(5, ct.getSoLuong());
            stmt.setDouble(6, ct.getDonGia());
            stmt.setString(7, ct.getGhiChu());
            stmt.setString(8, ct.getMaPhieuNhap());
            stmt.setString(9, ct.getMaHang());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteChiTietPhieuNhap(String maPhieuNhap, String maHang) {
        String sql = "DELETE FROM ChiTietPhieuNhap WHERE maPhieuNhap=? AND maHang=?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maPhieuNhap);
            stmt.setString(2, maHang);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
