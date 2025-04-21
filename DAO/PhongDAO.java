package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Phong;
import sql.DatabaseQLKS;

public class PhongDAO {
    public ArrayList<Phong> getListPhong() throws SQLException{
        ArrayList<Phong> listPhong = new ArrayList<>();
        String sql = "SELECT * FROM Phong";
        
        try (   Connection con = DatabaseQLKS.getConnection();
                PreparedStatement pre = con.prepareStatement(sql);
                ResultSet rs = pre.executeQuery();  ) 
                {
                    while (rs.next()) {
                        listPhong.add(new Phong(
                            rs.getString("MaPhong"),
                            rs.getString("MaLoaiPhong"),
                            rs.getInt("SoGiuong"),
                            rs.getBigDecimal("DonGia"),
                            rs.getString("TrangThai")
                            ));
                    }
                }
        return listPhong;
    }

}
