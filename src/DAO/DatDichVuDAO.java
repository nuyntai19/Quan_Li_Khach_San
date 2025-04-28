package DAO;

import DTO.DatDichVuDTO;
import sql.DatabaseQLKS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatDichVuDAO {
    
    // Kiểm tra xem dịch vụ đã tồn tại hay chưa
    public boolean kiemTraTonTai(int idChiTietPhieuThue, int maDichVu) throws SQLException {
        String sql = "SELECT COUNT(*) FROM DatDichVu WHERE IDChiTietPhieuThue = ? AND MaDichVu = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idChiTietPhieuThue);
            stmt.setInt(2, maDichVu);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Nếu số lượng lớn hơn 0, dữ liệu đã tồn tại
                }
            }
        }
        return false; // Không tồn tại
    }


    // Thêm đặt dịch vụ
    public void themDatDichVu(DatDichVuDTO ddv) throws SQLException {
        String sql = "INSERT INTO DatDichVu (IDChiTietPhieuThue, MaDichVu, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ddv.getIdChiTietPhieuThue());
            stmt.setInt(2, ddv.getMaDichVu());
            stmt.setInt(3, ddv.getSoLuong());
            stmt.setDouble(4, ddv.getDonGia());
            stmt.setDouble(5, ddv.getThanhTien());
            stmt.executeUpdate();
        }
    }

    // Sửa đặt dịch vụ
    public void suaDatDichVu(DatDichVuDTO ddv) throws SQLException {
        String sql = "UPDATE DatDichVu SET SoLuong = ?, DonGia = ?, ThanhTien = ? WHERE IDChiTietPhieuThue = ? AND MaDichVu = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ddv.getSoLuong());
            stmt.setDouble(2, ddv.getDonGia());
            stmt.setDouble(3, ddv.getThanhTien());
            stmt.setInt(4, ddv.getIdChiTietPhieuThue());
            stmt.setInt(5, ddv.getMaDichVu());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Không tìm thấy đặt dịch vụ với IDChiTietPhieuThue: " + ddv.getIdChiTietPhieuThue() + " và MaDichVu: " + ddv.getMaDichVu());
            }
        }
    }

    // Xóa đặt dịch vụ
    public void xoaDatDichVu(int idChiTietPhieuThue, int maDichVu) throws SQLException {
        String sql = "DELETE FROM DatDichVu WHERE IDChiTietPhieuThue = ? AND MaDichVu = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idChiTietPhieuThue);
            stmt.setInt(2, maDichVu);
            stmt.executeUpdate();
        }
    }

    // Lấy danh sách tất cả đặt dịch vụ
    public ArrayList<DatDichVuDTO> layDanhSachDatDichVu() throws SQLException {
        ArrayList<DatDichVuDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM DatDichVu";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DatDichVuDTO ddv = new DatDichVuDTO();
                ddv.setIdChiTietPhieuThue(rs.getInt("IDChiTietPhieuThue"));
                ddv.setMaDichVu(rs.getInt("MaDichVu"));
                ddv.setSoLuong(rs.getInt("SoLuong"));
                ddv.setDonGia(rs.getDouble("DonGia"));
                ddv.setThanhTien(rs.getDouble("ThanhTien"));
                ds.add(ddv);
            }
        }
        return ds;
    }
}
