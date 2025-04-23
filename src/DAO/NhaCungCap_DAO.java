package doan.quanlykhachsan.dao;

import DTO.NhaCungCap_DTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.DatabaseQLKS;

public class NhaCungCap_DAO {
    private Connection conn;
    
    // Constructor
    public NhaCungCap_DAO(Connection conn) {
        this.conn = conn;
    }
    
    // Lấy danh sách tất cả nhà cung cấp
    public List<NhaCungCap_DTO> getAll() throws SQLException {
        List<NhaCungCap_DTO> danhSach = new ArrayList<>();
        String sql = "SELECT MaNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai FROM NhaCungCap";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String maNCC = String.valueOf(rs.getInt("MaNhaCungCap"));
                String tenNCC = rs.getString("TenNhaCungCap");
                String diaChi = rs.getString("DiaChi");
                String soDienThoai = rs.getString("SoDienThoai");
                
                NhaCungCap_DTO nhaCungCap = new NhaCungCap_DTO(maNCC, tenNCC, diaChi, soDienThoai);
                danhSach.add(nhaCungCap);
            }
        }
        
        return danhSach;
    }
    
    // Tìm nhà cung cấp theo mã
    public NhaCungCap_DTO getById(String maNCC) throws SQLException {
        String sql = "SELECT MaNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai " +
                     "FROM NhaCungCap WHERE MaNhaCungCap = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(maNCC));
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String tenNCC = rs.getString("TenNhaCungCap");
                    String diaChi = rs.getString("DiaChi");
                    String soDienThoai = rs.getString("SoDienThoai");
                    
                    return new NhaCungCap_DTO(maNCC, tenNCC, diaChi, soDienThoai);
                }
            }
        }
        
        return null;
    }
    
    // Kiểm tra mã nhà cung cấp đã tồn tại chưa
    public boolean kiemTraTonTai(String maNCC) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM NhaCungCap WHERE MaNhaCungCap = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(maNCC));
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count") > 0;
                }
            }
        }
        
        return false;
    }
    
    // Thêm nhà cung cấp mới
    public boolean them(NhaCungCap_DTO nhaCungCap) throws SQLException {
        // Kiểm tra xem mã đã tồn tại chưa
        if (kiemTraTonTai(nhaCungCap.getMaNhaCungCap())) {
            throw new SQLException("Mã nhà cung cấp " + nhaCungCap.getMaNhaCungCap() + " đã tồn tại!");
        }
        
        String sql = "INSERT INTO NhaCungCap (MaNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(nhaCungCap.getMaNhaCungCap()));
            stmt.setString(2, nhaCungCap.getTenNhaCungCap());
            stmt.setString(3, nhaCungCap.getDiaChi());
            stmt.setString(4, nhaCungCap.getSoDienThoai());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Cập nhật nhà cung cấp
    public boolean capNhat(NhaCungCap_DTO nhaCungCap) throws SQLException {
        // Kiểm tra xem NCC có tồn tại không
        if (!kiemTraTonTai(nhaCungCap.getMaNhaCungCap())) {
            throw new SQLException("Mã nhà cung cấp " + nhaCungCap.getMaNhaCungCap() + " không tồn tại!");
        }
        
        String sql = "UPDATE NhaCungCap SET TenNhaCungCap = ?, DiaChi = ?, SoDienThoai = ? WHERE MaNhaCungCap = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nhaCungCap.getTenNhaCungCap());
            stmt.setString(2, nhaCungCap.getDiaChi());
            stmt.setString(3, nhaCungCap.getSoDienThoai());
            stmt.setInt(4, Integer.parseInt(nhaCungCap.getMaNhaCungCap()));
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Xóa nhà cung cấp
    public boolean xoa(String maNCC) throws SQLException {
        // Kiểm tra xem NCC đã được sử dụng trong phiếu nhập hàng chưa
        if (daCoPhieuNhapHang(maNCC)) {
            throw new SQLException("Không thể xóa nhà cung cấp có mã " + maNCC + " vì đã có phiếu nhập hàng liên quan!");
        }
        
        String sql = "DELETE FROM NhaCungCap WHERE MaNhaCungCap = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(maNCC));
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    // Kiểm tra xem nhà cung cấp đã có trong phiếu nhập hàng chưa
    private boolean daCoPhieuNhapHang(String maNCC) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM PhieuNhapHang WHERE MaNhaCungCap = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(maNCC));
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count") > 0;
                }
            }
        }
        
        return false;
    }
    
    // Tìm kiếm nhà cung cấp theo tên, địa chỉ hoặc số điện thoại
    public List<NhaCungCap_DTO> timKiem(String keyword) throws SQLException {
        List<NhaCungCap_DTO> danhSach = new ArrayList<>();
        
        String sql = "SELECT MaNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai FROM NhaCungCap " +
                     "WHERE TenNhaCungCap LIKE ? OR DiaChi LIKE ? OR SoDienThoai LIKE ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            String pattern = "%" + keyword + "%";
            stmt.setString(1, pattern);
            stmt.setString(2, pattern);
            stmt.setString(3, pattern);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String maNCC = String.valueOf(rs.getInt("MaNhaCungCap"));
                    String tenNCC = rs.getString("TenNhaCungCap");
                    String diaChi = rs.getString("DiaChi");
                    String soDienThoai = rs.getString("SoDienThoai");
                    
                    NhaCungCap_DTO nhaCungCap = new NhaCungCap_DTO(maNCC, tenNCC, diaChi, soDienThoai);
                    danhSach.add(nhaCungCap);
                }
            }
        }
        
        return danhSach;
    }
}
