
package DAO;

import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;


public class TaiKhoanDAO {
    public TaiKhoanDTO dangNhap(String tenDangNhap, String matKhau) {
        TaiKhoanDTO tk = null;
        try {
            Connection conn = sql.DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ? AND TrangThai = 'active'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                tk = new TaiKhoanDTO();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setMaNhanVien(rs.getInt("MaNhanVien"));
                tk.setVaiTro(rs.getString("VaiTro"));
                tk.setTrangThai(rs.getString("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
    
    public TaiKhoanDTO layTaiKhoanDangNhapTuBangNhanVienDangNhap() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = sql.DatabaseQLKS.getConnection();
            String sql = "SELECT TOP 1 MaTaiKhoan, TenDangNhap, MaNhanVien, VaiTro FROM NhanVienDangNhap ORDER BY ThoiGianDangNhap DESC";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMaNhanVien(rs.getInt("MaNhanVien"));
                tk.setVaiTro(rs.getString("VaiTro"));
                return tk;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.DatabaseQLKS.close(conn, stmt, rs);
        }
        return null;
    }
    
    // Thêm thông tin đăng nhập vào bảng tạm
    public void themDangNhapVaoBangTam(TaiKhoanDTO tk) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = sql.DatabaseQLKS.getConnection();
            String sql = "INSERT INTO NhanVienDangNhap (MaTaiKhoan, TenDangNhap, MaNhanVien, VaiTro, ThoiGianDangNhap) " +
                         "VALUES (?, ?, ?, ?, GETDATE())";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tk.getMaTaiKhoan());
            ps.setString(2, tk.getTenDangNhap());
            ps.setInt(3, tk.getMaNhanVien());
            ps.setString(4, tk.getVaiTro());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Xóa toàn bộ thông tin trong bảng NhanVienDangNhap
    public void xoaTatCaDangNhapBangTam() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = sql.DatabaseQLKS.getConnection();
            String sql = "DELETE FROM NhanVienDangNhap";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
     // Kiểm tra tài khoản có tồn tại theo tên đăng nhập
    public boolean kiemTraTonTai(String tenDangNhap) throws SQLException {
        String sql = "SELECT COUNT(*) FROM TaiKhoan WHERE TenDangNhap = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tenDangNhap);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    // Thêm tài khoản mới
    public void themTaiKhoan(TaiKhoanDTO tk) throws SQLException {
        String sql = "INSERT INTO TaiKhoan (TenDangNhap, MatKhau, MaNhanVien, VaiTro, TrangThai) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tk.getTenDangNhap());
            stmt.setString(2, tk.getMatKhau());
            stmt.setInt(3, tk.getMaNhanVien());
            stmt.setString(4, tk.getVaiTro());
            stmt.setString(5, tk.getTrangThai());
            stmt.executeUpdate();
        }
    }

    // Sửa thông tin tài khoản
    public void suaTaiKhoan(TaiKhoanDTO tk) throws SQLException {
        String sql = "UPDATE TaiKhoan SET MatKhau = ?, MaNhanVien = ?, VaiTro = ?, TrangThai = ? WHERE TenDangNhap = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tk.getMatKhau());
            stmt.setInt(2, tk.getMaNhanVien());
            stmt.setString(3, tk.getVaiTro());
            stmt.setString(4, tk.getTrangThai());
            stmt.setString(5, tk.getTenDangNhap());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Không tìm thấy tài khoản với tên đăng nhập: " + tk.getTenDangNhap());
            }
        }
    }

    // Xóa tài khoản theo mã tài khoản
    public void xoaTaiKhoan(int maTaiKhoan) throws SQLException {
        String sql = "DELETE FROM TaiKhoan WHERE MaTaiKhoan = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maTaiKhoan);
            stmt.executeUpdate();
        }
    }

    // Lấy danh sách tất cả tài khoản
    public ArrayList<TaiKhoanDTO> layDanhSachTaiKhoan() throws SQLException {
        ArrayList<TaiKhoanDTO> dstk = new ArrayList<>();
        String sql = "SELECT * FROM TaiKhoan";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO(
                    rs.getInt("MaTaiKhoan"),
                    rs.getString("TenDangNhap"),
                    rs.getString("MatKhau"),
                    rs.getInt("MaNhanVien"),
                    rs.getString("VaiTro"),
                    rs.getString("TrangThai")
                );
                dstk.add(tk);
            }
        }
        return dstk;
    }

    // Cập nhật trạng thái tài khoản
    public void capNhatTrangThaiTaiKhoan(int maTaiKhoan, String trangThaiMoi) throws SQLException {
        String sql = "UPDATE TaiKhoan SET TrangThai = ? WHERE MaTaiKhoan = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, trangThaiMoi);
            stmt.setInt(2, maTaiKhoan);
            stmt.executeUpdate();
        }
    }
    
    


}

