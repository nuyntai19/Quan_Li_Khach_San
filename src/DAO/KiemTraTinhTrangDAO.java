package DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.KiemTraTinhTrang;
import sql.DatabaseQLKS;

public class KiemTraTinhTrangDAO {
    public ArrayList<KiemTraTinhTrang> getListKTTT() throws SQLException{
    ArrayList<KiemTraTinhTrang> listKTTT = new ArrayList<>();
    String sql = "SELECT * FROM KiemTraTinhTrang";
    
    try (Connection con = DatabaseQLKS.getConnection();
         PreparedStatement pre = con.prepareStatement(sql);
         ResultSet rs = pre.executeQuery()) 
    {
        while (rs.next()) {
            // Lấy dữ liệu từ DB và tạo đối tượng KiemTraTinhTrang
            int maKiemTra = rs.getInt("MaKiemTra");
            int maPhong = rs.getInt("MaPhong");
            int maThuePhong = rs.getInt("MaThuePhong");
            int maNhanVien = rs.getInt("MaNhanVien");
            Date ngayKiemTra = rs.getDate("NgayKiemTra");
            String moTaThietHai = rs.getString("MoTaThietHai");
            BigDecimal chiPhiDenBu = rs.getBigDecimal("ChiPhiDenBu");

            // Kiểm tra tính hợp lệ của đối tượng trước khi thêm vào danh sách
            if (kiemTraHopLeDeTaoKTTT(maPhong, maThuePhong, ngayKiemTra)) {
                // Nếu hợp lệ thì thêm vào danh sách
                listKTTT.add(new KiemTraTinhTrang(maKiemTra, maPhong, maThuePhong, maNhanVien, ngayKiemTra, moTaThietHai, chiPhiDenBu));
            } else {
                System.out.println("Lỗi: Kiểm tra tình trạng phòng không hợp lệ, bỏ qua dữ liệu này.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return listKTTT;
}

    public boolean kiemTraHopLeDeTaoKTTT(int maPhong, int maThuePhong, Date ngayKiemTra) {
        String sql = "SELECT COUNT(*) FROM ChiTietPhieuThue " +
                     "WHERE MaPhong = ? AND MaThuePhong = ? " +
                     "AND ? BETWEEN NgayDatPhong AND NgayTraPhong";
    
        try (Connection conn =  DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, maPhong);
            stmt.setInt(2, maThuePhong);
            stmt.setDate(3, new java.sql.Date(ngayKiemTra.getTime()));
    
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return false;
    }

    
    public boolean kiemTraTonTai(int maPhong) throws SQLException {
        String sql = "SELECT COUNT(*) FROM KiemTraTinhTrang WHERE MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, maPhong);
            ResultSet rs = pre.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    } 

    public boolean themKTTT(KiemTraTinhTrang kt) throws SQLException {
        String sql = "INSERT INTO KiemTraTinhTrang (MaKiemTra, MaPhong, MaThuePhong, MaNhanVien, NgayKiemTra, MoTaThietHai, ChiPhiDenBu) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseQLKS.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) 
             {
                pre.setInt(1, kt.getMaKiemTra());
                pre.setInt(2, kt.getMaPhong());
                pre.setInt(3, kt.getMaThuePhong());
                pre.setInt(4, kt.getMaNhanVien());
                pre.setDate(5, new java.sql.Date(kt.getNgayKiemTra().getTime()));
                pre.setString(6, kt.getMoTaThietHai());
                pre.setBigDecimal(7, kt.getChiPhiDenBu());

                return pre.executeUpdate() > 0;
             }
    }

    public boolean suaKTTT(KiemTraTinhTrang kt) throws SQLException {
        String sql = "UPDATE KiemTraTinhTrang " +
                     "SET MaNhanVien = ?, NgayKiemTra = ?, MoTaThietHai = ?, ChiPhiDenBu = ? " +
                     "WHERE MaKiemTra = ?";
        
        try (Connection con = DatabaseQLKS.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) {
            
            pre.setInt(1, kt.getMaNhanVien());
            pre.setDate(2, new java.sql.Date(kt.getNgayKiemTra().getTime()));
            pre.setString(3, kt.getMoTaThietHai());
            pre.setBigDecimal(4, kt.getChiPhiDenBu());
            pre.setInt(5, kt.getMaKiemTra()); // dùng để định danh bản ghi cần sửa
            
            return pre.executeUpdate() > 0;
        }
    }
    

    public boolean xoaKTTT(int maKiemTra) throws SQLException {
        String sql = "DELETE FROM KiemTraTinhTrang WHERE MaKiemTra = ?";
        
        try (Connection con = DatabaseQLKS.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) 
             {
                pre.setInt(1, maKiemTra);

                return pre.executeUpdate() > 0;
             }
    }

    // có hoặc ko
    public KiemTraTinhTrang timkiemKTTT(int maKiemTra) throws SQLException {
        String sql = "SELECT * FROM KiemTraTinhTrang WHERE MaKiemTra = ?";
        
        try (Connection con = DatabaseQLKS.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) 
             {
                pre.setInt(1, maKiemTra);
                try (ResultSet rs = pre.executeQuery()) 
                    {
                        if (rs.next()) {
                            return new KiemTraTinhTrang(
                                    rs.getInt("MaKiemTra"),
                                    rs.getInt("MaPhong"),
                                    rs.getInt("MaThuePhong"),
                                    rs.getInt("MaNhanVien"),
                                    rs.getDate("NgayKiemTra"),
                                    rs.getString("MoTaThietHai"),
                                    rs.getBigDecimal("ChiPhiDenBu")
                            );
                        }
                    }
             }
        return null;
    }
    public KiemTraTinhTrang timTheoMaPhong(int maPhong) throws SQLException {
    String sql = "SELECT * FROM KiemTraTinhTrang WHERE MaPhong = ?";
    
        try (Connection con = DatabaseQLKS.getConnection();
            PreparedStatement pre = con.prepareStatement(sql)) 
        {
            pre.setInt(1, maPhong);
            try (ResultSet rs = pre.executeQuery()) 
            {
                if (rs.next()) {
                    return new KiemTraTinhTrang(
                            rs.getInt("MaKiemTra"),
                            rs.getInt("MaPhong"),
                            rs.getInt("MaThuePhong"),
                            rs.getInt("MaNhanVien"),
                            rs.getDate("NgayKiemTra"),
                            rs.getString("MoTaThietHai"),
                            rs.getBigDecimal("ChiPhiDenBu")
                    );
                }
            }
        }
        return null;
    }

    public KiemTraTinhTrang timKTTT(int maPhong, int maThuePhong) throws SQLException {
        String sql = "SELECT * FROM KiemTraTinhTrang WHERE MaPhong = ? AND MaThuePhong = ?";
        
        try (Connection con = DatabaseQLKS.getConnection();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, maPhong);
            pre.setInt(2, maThuePhong);
            
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    return new KiemTraTinhTrang(
                            rs.getInt("MaKiemTra"),
                            rs.getInt("MaPhong"),
                            rs.getInt("MaThuePhong"),
                            rs.getInt("MaNhanVien"),
                            rs.getDate("NgayKiemTra"),
                            rs.getString("MoTaThietHai"),
                            rs.getBigDecimal("ChiPhiDenBu")
                    );
                }
            }
        }
        return null;
    }

    
}
