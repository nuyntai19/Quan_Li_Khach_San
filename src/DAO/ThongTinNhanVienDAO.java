
package DAO;

import DTO.ThongTinNhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongTinNhanVienDAO {
    public ThongTinNhanVienDTO layTaiKhoanDangNhapGanNhat() {
        ThongTinNhanVienDTO dto = null;
        try (Connection conn = sql.DatabaseQLKS.getConnection()) {
            String sql = "SELECT TOP 1 * FROM NhanVienDangNhap ORDER BY ThoiGianDangNhap DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dto = new ThongTinNhanVienDTO();
                dto.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                dto.setTenDangNhap(rs.getString("TenDangNhap"));
                dto.setMaNhanVien(rs.getInt("MaNhanVien"));
                dto.setVaiTro(rs.getString("VaiTro"));
                dto.setThoiGianDangNhap(rs.getTimestamp("ThoiGianDangNhap"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}