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
                            rs.getInt("MaNhanVien"),
                            rs.getInt("MaThuePhong"),
                            rs.getTimestamp("NgayKiemTra").toLocalDateTime(),
                            rs.getString("MoTaThietHai"),
                            rs.getBigDecimal("ChiPhiDenBu")
                            ));
                    }
                }
        return listKTTT;
    }
}
