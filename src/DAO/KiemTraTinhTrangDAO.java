package DAO;

import java.sql.Connection;
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
        
        try (   Connection con = DatabaseQLKS.getConnection();
                PreparedStatement pre = con.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();  ) 
                {
                    while (rs.next()) {
                        listKTTT.add(new KiemTraTinhTrang(
                            rs.getInt("MaKiemTra"),
                            rs.getInt("MaPhong"),
                            rs.getInt("MaNhanVien"),
                            rs.getInt("MaThuePhong"),
                            rs.getDate("NgayKiemTra").toLocalDate(),
                            rs.getString("MoTaThietHai"),
                            rs.getBigDecimal("ChiPhiDenBu")
                            ));
                    }
                }
        return listKTTT;
    }

    public boolean themKTTT(KiemTraTinhTrang kt) throws SQLException {
        String sql = "INSERT INTO KiemTraTinhTrang (MaKiemTra, MaPhong, MaNhanVien, MaThuePhong, NgayKiemTra, MoTaThietHai, ChiPhiDenBu) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseQLKS.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) 
             {
                pre.setInt(1, kt.getMaKiemTra());
                pre.setInt(2, kt.getMaPhong());
                pre.setInt(3, kt.getMaNhanVien());
                pre.setInt(4, kt.getMaThuePhong());
                pre.setDate(5, java.sql.Date.valueOf(kt.getNgayKiemTra()));
                pre.setString(6, kt.getMoTaThietHai());
                pre.setBigDecimal(7, kt.getChiPhiDenBu());

                return pre.executeUpdate() > 0;
             }
    }

    public boolean suaKTTT(KiemTraTinhTrang kt) throws SQLException {
        String sql = "UPDATE KiemTraTinhTrang " +
                     "SET MaNhanVien = ?, MaPhong = ?, MaThuePhong = ?, NgayKiemTra = ?, MoTaThietHai = ?, ChiPhiDenBu = ? " +
                     "WHERE MaKiemTra = ?";
        try (Connection con = DatabaseQLKS.getConnection();
             PreparedStatement pre = con.prepareStatement(sql)) 
             {
                pre.setInt(1, kt.getMaNhanVien());
                pre.setInt(2, kt.getMaPhong());
                pre.setInt(3, kt.getMaThuePhong());
                pre.setDate(4, java.sql.Date.valueOf(kt.getNgayKiemTra()));
                pre.setString(5, kt.getMoTaThietHai());
                pre.setBigDecimal(6, kt.getChiPhiDenBu());
                pre.setInt(7, kt.getMaKiemTra());

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
                                    rs.getInt("MaNhanVien"),
                                    rs.getInt("MaThuePhong"),
                                    rs.getDate("NgayKiemTra").toLocalDate(),
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
                        rs.getDate("NgayKiemTra").toLocalDate(),
                        rs.getString("MoTaThietHai"),
                        rs.getBigDecimal("ChiPhiDenBu")
                );
            }
        }
    }
    return null;
}

    
}
