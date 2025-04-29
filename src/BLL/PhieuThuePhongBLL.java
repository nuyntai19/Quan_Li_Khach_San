package BLL;

import DAO.PhieuThuePhongDAO;
import DTO.PhieuThuePhongDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sql.DatabaseQLKS;

public class PhieuThuePhongBLL {
    private PhieuThuePhongDAO phieuThuePhongDAO;

    public PhieuThuePhongBLL() {
        phieuThuePhongDAO = new PhieuThuePhongDAO();
    }

    public ArrayList<PhieuThuePhongDTO> layDanhSachPhieuThue() throws SQLException {
        return phieuThuePhongDAO.layDanhSachPhieuThue();
    }

    public void themPhieuThue(PhieuThuePhongDTO phieu) throws Exception {
        if (phieuThuePhongDAO.kiemTraTonTai(phieu.getMaThuePhong())) {
            throw new Exception("Mã phiếu thuê đã tồn tại!");
        }
        phieuThuePhongDAO.themPhieuThue(phieu);
    }

    public void capNhatPhieuThue(PhieuThuePhongDTO phieu) throws SQLException {
        if (!phieuThuePhongDAO.kiemTraTonTai(phieu.getMaThuePhong())) {
            throw new SQLException("Không tìm thấy phiếu thuê với mã: " + phieu.getMaThuePhong());
        }
        phieuThuePhongDAO.capNhatPhieuThue(phieu);
    }

    public void xoaPhieuThue(int maThuePhong) throws SQLException {
        if (!phieuThuePhongDAO.kiemTraTonTai(maThuePhong)) {
            throw new SQLException("Không tìm thấy phiếu thuê với mã: " + maThuePhong);
        }
        phieuThuePhongDAO.xoaPhieuThue(maThuePhong);
    }

    public boolean kiemTraTonTai(int maThuePhong) throws SQLException {
        return phieuThuePhongDAO.kiemTraTonTai(maThuePhong);
    }

    public void kiemTraTonTaiVaThongBao(int maThuePhong) throws SQLException {
        if (kiemTraTonTai(maThuePhong)) {
            JOptionPane.showMessageDialog(null, "Mã thuê phòng đã tồn tại. Vui lòng chọn mã khác.");
        }
    }

    private boolean kiemTraTonTai(int maThuePhong, int maPhong) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ChiTietPhieuThue WHERE MaThuePhong = ? AND MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maThuePhong);
            stmt.setInt(2, maPhong);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0; // Trả về true nếu tìm thấy bản ghi
        }
    }
}
