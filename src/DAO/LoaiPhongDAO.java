/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.DatabaseQLKS;
import DTO.LoaiPhongDTO;


public class LoaiPhongDAO {
    public ArrayList<LoaiPhongDTO> layDanhSachLoaiPhong() throws SQLException {
        ArrayList<LoaiPhongDTO> dslp = new ArrayList<>();
        String sql = "SELECT * FROM LoaiPhong";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dslp.add(new LoaiPhongDTO(
                    rs.getString("MaLoaiPhong"),
                    rs.getString("TenLoaiPhong"),
                    rs.getString("MoTa")
                ));
            }
        }
        return dslp;
    }
    
    public ArrayList<String> layDanhSachMaLoaiPhong() throws SQLException {
        ArrayList<String> ds = new ArrayList<>();
        String sql = "SELECT MaLoaiPhong FROM LoaiPhong";

        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ds.add(rs.getString("MaLoaiPhong"));
            }
        }

        return ds;
    }

}
