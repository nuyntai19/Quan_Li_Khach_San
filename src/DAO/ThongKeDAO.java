
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.DatabaseQLKS;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ThongKeDAO {
    public Map<String, Double> thongKeDoanhThuTheoLoai(Date tuNgay, Date denNgay) throws SQLException {
        Map<String, Double> doanhThuTheoLoai = new HashMap<>();
        String query = "SELECT cthd.loaiChiTiet, SUM(cthd.thanhTien) AS tongTien " +
                        "FROM HoaDon hd " +
                        "JOIN ChiTietHoaDon cthd ON hd.maHD = cthd.maHD " +
                        "JOIN PhieuThuePhong ptp ON hd.maPTP = ptp.maThuePhong " +
                        "JOIN ChiTietPhieuThue ctpt ON ptp.maThuePhong = ctpt.maThuePhong " +
                        "WHERE ctpt.NgayDatPhong >= ? AND ctpt.NgayTraPhong <= ? " +
                        "GROUP BY cthd.loaiChiTiet";
        try (Connection conn = DatabaseQLKS.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDate(1, new java.sql.Date(tuNgay.getTime()));
            ps.setDate(2, new java.sql.Date(denNgay.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String loai = rs.getString("loaiChiTiet");
                double tong = rs.getDouble("tongTien");
                doanhThuTheoLoai.put(loai, tong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThuTheoLoai;
    }
    
    public Map<String, Double> thongKeTheoThang(int thang, int nam) throws SQLException {
        Map<String, Double> doanhThuTheoLoai = new HashMap<>();
        String query = "SELECT cthd.loaiChiTiet, SUM(cthd.thanhTien) AS tongTien " +
                       "FROM HoaDon hd " +
                       "JOIN ChiTietHoaDon cthd ON hd.maHD = cthd.maHD " +
                       "JOIN PhieuThuePhong ptp ON hd.maPTP = ptp.maThuePhong " +
                       "WHERE MONTH(hd.ngayLap) = ? AND YEAR(hd.ngayLap) = ? " +
                       "GROUP BY cthd.loaiChiTiet";
        try (Connection conn = DatabaseQLKS.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, thang);
            ps.setInt(2, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String loai = rs.getString("loaiChiTiet");
                double tong = rs.getDouble("tongTien");
                doanhThuTheoLoai.put(loai, tong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThuTheoLoai;
    }
    
    public Map<String, Double> thongKeTheoNam(int nam) throws SQLException {
        Map<String, Double> doanhThuTheoLoai = new HashMap<>();
        String query = "SELECT cthd.loaiChiTiet, SUM(cthd.thanhTien) AS tongTien " +
                       "FROM HoaDon hd " +
                       "JOIN ChiTietHoaDon cthd ON hd.maHD = cthd.maHD " +
                       "JOIN PhieuThuePhong ptp ON hd.maPTP = ptp.maThuePhong " +
                       "WHERE YEAR(hd.ngayLap) = ? " +
                       "GROUP BY cthd.loaiChiTiet";
        try (Connection conn = DatabaseQLKS.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String loai = rs.getString("loaiChiTiet");
                double tong = rs.getDouble("tongTien");
                doanhThuTheoLoai.put(loai, tong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doanhThuTheoLoai;
    }
    
    public int getSoLuongForLoaiTheoNgay(String loai, Date tuNgay, Date denNgay) throws SQLException {
        int soLuong = 0;
        String query = "SELECT COUNT(cthd.MaCTHD) AS soLuong " +
                       "FROM HoaDon hd " +
                       "JOIN ChiTietHoaDon cthd ON hd.maHD = cthd.maHD " +
                       "JOIN PhieuThuePhong ptp ON hd.maPTP = ptp.maThuePhong " +
                       "JOIN ChiTietPhieuThue ctpt ON ptp.maThuePhong = ctpt.maThuePhong " +
                       "WHERE cthd.loaiChiTiet = ? " +
                       "AND ctpt.NgayDatPhong >= ? AND ctpt.NgayTraPhong <= ?";
        try (Connection conn = DatabaseQLKS.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, loai);
            ps.setDate(2, new java.sql.Date(tuNgay.getTime()));
            ps.setDate(3, new java.sql.Date(denNgay.getTime()));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }
    
    public int getSoLuongForLoaiTheoThang(String loai, int thang, int nam) throws SQLException {
        int soLuong = 0;
        String query = "SELECT COUNT(cthd.MaCTHD) AS soLuong " +
                       "FROM HoaDon hd " +
                       "JOIN ChiTietHoaDon cthd ON hd.maHD = cthd.maHD " +
                       "JOIN PhieuThuePhong ptp ON hd.maPTP = ptp.maThuePhong " +
                       "JOIN ChiTietPhieuThue ctpt ON ptp.maThuePhong = ctpt.maThuePhong " +
                       "WHERE cthd.loaiChiTiet = ? " +
                       "AND MONTH(ctpt.NgayDatPhong) = ? AND YEAR(ctpt.NgayDatPhong) = ?";
        try (Connection conn = DatabaseQLKS.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, loai);
            ps.setInt(2, thang);
            ps.setInt(3, nam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }
    
    public int getSoLuongForLoaiTheoNam(String loai, int nam) throws SQLException {
        int soLuong = 0;
        String query = "SELECT COUNT(cthd.MaCTHD) AS soLuong " +
                       "FROM HoaDon hd " +
                       "JOIN ChiTietHoaDon cthd ON hd.maHD = cthd.maHD " +
                       "JOIN PhieuThuePhong ptp ON hd.maPTP = ptp.maThuePhong " +
                       "JOIN ChiTietPhieuThue ctpt ON ptp.maThuePhong = ctpt.maThuePhong " +
                       "WHERE cthd.loaiChiTiet = ? AND YEAR(ctpt.NgayDatPhong) = ?";
        try (Connection conn = DatabaseQLKS.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, loai);
            ps.setInt(2, nam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("soLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }




}
