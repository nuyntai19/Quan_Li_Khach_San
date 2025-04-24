package DAO;

import DTO.NhaCungCap_DTO;
import sql.DatabaseQLKS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhaCungCap_DAO {
    // Phương thức lấy tất cả nhà cung cấp
    public ArrayList<NhaCungCap_DTO> layDanhSachNhaCungCap() {
        ArrayList<NhaCungCap_DTO> danhSachNCC = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM NhaCungCap";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                NhaCungCap_DTO ncc = new NhaCungCap_DTO();
                ncc.setMaNhaCungCap(String.valueOf(rs.getInt("MaNhaCungCap")));
                ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setSoDienThoai(rs.getString("SoDienThoai"));
                
                danhSachNCC.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return danhSachNCC;
    }
    
    // Phương thức thêm nhà cung cấp mới
    public boolean themNhaCungCap(NhaCungCap_DTO ncc) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean ketQua = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "INSERT INTO NhaCungCap(MaNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai) VALUES(?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, Integer.parseInt(ncc.getMaNhaCungCap()));
            stmt.setString(2, ncc.getTenNhaCungCap());
            stmt.setString(3, ncc.getDiaChi());
            stmt.setString(4, ncc.getSoDienThoai());
            
            int hang = stmt.executeUpdate();
            if (hang > 0) {
                ketQua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
        
        return ketQua;
    }
    
    // Phương thức cập nhật thông tin nhà cung cấp
    public boolean capNhatNhaCungCap(NhaCungCap_DTO ncc) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean ketQua = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "UPDATE NhaCungCap SET TenNhaCungCap = ?, DiaChi = ?, SoDienThoai = ? WHERE MaNhaCungCap = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, ncc.getTenNhaCungCap());
            stmt.setString(2, ncc.getDiaChi());
            stmt.setString(3, ncc.getSoDienThoai());
            stmt.setInt(4, Integer.parseInt(ncc.getMaNhaCungCap()));
            
            int hang = stmt.executeUpdate();
            if (hang > 0) {
                ketQua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
        
        return ketQua;
    }
    
    // Phương thức xóa nhà cung cấp
    public boolean xoaNhaCungCap(String maNhaCungCap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean ketQua = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            
            // Trước khi xóa NhaCungCap, kiểm tra xem có tồn tại trong PhieuNhapHang không
            String checkSql = "SELECT COUNT(*) FROM PhieuNhapHang WHERE MaNhaCungCap = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setInt(1, Integer.parseInt(maNhaCungCap));
            ResultSet checkRs = checkStmt.executeQuery();
            checkRs.next();
            int count = checkRs.getInt(1);
            
            if (count > 0) {
                // Nếu có liên kết, không thể xóa
                return false;
            }
            
            // Nếu không có liên kết, thực hiện xóa
            String sql = "DELETE FROM NhaCungCap WHERE MaNhaCungCap = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(maNhaCungCap));
            
            int hang = stmt.executeUpdate();
            if (hang > 0) {
                ketQua = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, null);
        }
        
        return ketQua;
    }
    
    // Phương thức tìm kiếm nhà cung cấp theo mã
    public NhaCungCap_DTO timNhaCungCapTheoMa(String maNhaCungCap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        NhaCungCap_DTO ncc = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM NhaCungCap WHERE MaNhaCungCap = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(maNhaCungCap));
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                ncc = new NhaCungCap_DTO();
                ncc.setMaNhaCungCap(String.valueOf(rs.getInt("MaNhaCungCap")));
                ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setSoDienThoai(rs.getString("SoDienThoai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return ncc;
    }
    
    // Phương thức tìm kiếm nhà cung cấp theo tên
    public ArrayList<NhaCungCap_DTO> timNhaCungCapTheoTen(String tenNhaCungCap) {
        ArrayList<NhaCungCap_DTO> danhSachNCC = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM NhaCungCap WHERE TenNhaCungCap LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + tenNhaCungCap + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                NhaCungCap_DTO ncc = new NhaCungCap_DTO();
                ncc.setMaNhaCungCap(String.valueOf(rs.getInt("MaNhaCungCap")));
                ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setSoDienThoai(rs.getString("SoDienThoai"));
                
                danhSachNCC.add(ncc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return danhSachNCC;
    }
    
    // Phương thức kiểm tra mã nhà cung cấp đã tồn tại chưa
    public boolean kiemTraMaNhaCungCapTonTai(String maNhaCungCap) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean tonTai = false;
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT COUNT(*) FROM NhaCungCap WHERE MaNhaCungCap = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(maNhaCungCap));
            rs = stmt.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                tonTai = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return tonTai;
    }
    
    // Phương thức lấy mã nhà cung cấp mới
    public String layMaNhaCungCapMoiNhat() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String maNCC = "1"; // Mặc định nếu chưa có dữ liệu
        
        try {
            conn = DatabaseQLKS.getConnection();
            String sql = "SELECT MAX(MaNhaCungCap) FROM NhaCungCap";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            if (rs.next() && rs.getObject(1) != null) {
                int maMax = rs.getInt(1);
                maNCC = String.valueOf(maMax + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseQLKS.close(conn, stmt, rs);
        }
        
        return maNCC;
    }
}
