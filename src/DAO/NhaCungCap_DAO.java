package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;
import DTO.NhaCungCap_DTO;

public class NhaCungCap_DAO {
    public ArrayList<NhaCungCapDTO> layDanhSachNhaCungCap() throws SQLException {
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        String sql = "SELECT * FROM NhaCungCap";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dsncc.add(new NhaCungCapDTO(
                    rs.getInt("MaNhaCungCap"),
                    rs.getString("TenNhaCungCap"),
                    rs.getString("SoDienThoai"),
                    rs.getString("DiaChi")
                ));
            }
        }
        return dsncc;
    }
    
    public ArrayList<Integer> layDanhSachMaNhaCungCap() throws SQLException {
        ArrayList<Integer> ds = new ArrayList<>();
        String sql = "SELECT MaNhaCungCap FROM NhaCungCap";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ds.add(rs.getInt("MaNhaCungCap"));
            }
        }
        return ds;
    }
    
    public boolean themNhaCungCap(NhaCungCap_DTO nhaCungCap) throws SQLException {
        String sql = "INSERT INTO NhaCungCap (MaNhaCungCap, TenNhaCungCap, SoDienThoai, DiaChi) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nhaCungCap.getMaNhaCungCap());
            stmt.setString(2, nhaCungCap.getTenNhaCungCap());
            stmt.setString(3, nhaCungCap.getSoDienThoai());
            stmt.setString(4, nhaCungCap.getDiaChi());
            
            return stmt.executeUpdate() > 0;
        }
    }
    
    public boolean suaNhaCungCap(NhaCungCap_DTO nhaCungCap) throws SQLException {
        String sql = "UPDATE NhaCungCap SET TenNhaCungCap = ?, SoDienThoai = ?, DiaChi = ? WHERE MaNhaCungCap = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nhaCungCap.getTenNhaCungCap());
            stmt.setString(2, nhaCungCap.getSoDienThoai());
            stmt.setString(3, nhaCungCap.getDiaChi());
            stmt.setInt(4, nhaCungCap.getMaNhaCungCap());
            
            return stmt.executeUpdate() > 0;
        }
    }
    
    public boolean xoaNhaCungCap(int maNhaCungCap) throws SQLException {
        String sql = "DELETE FROM NhaCungCap WHERE MaNhaCungCap = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNhaCungCap);
            
            return stmt.executeUpdate() > 0;
        }
    }
    
    public NhaCungCap_DTO timNhaCungCapTheoMa(int maNhaCungCap) throws SQLException {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNhaCungCap = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNhaCungCap);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NhaCungCapDTO(
                        rs.getInt("MaNhaCungCap"),
                        rs.getString("TenNhaCungCap"),
                        rs.getString("SoDienThoai"),
                        rs.getString("DiaChi")
                    );
                }
            }
        }
        return null;
    }
    
    public boolean kiemTraMaNhaCungCapTonTai(int maNhaCungCap) throws SQLException {
        String sql = "SELECT COUNT(*) FROM NhaCungCap WHERE MaNhaCungCap = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maNhaCungCap);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
