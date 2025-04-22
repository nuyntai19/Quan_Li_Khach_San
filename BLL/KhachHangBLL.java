package BLL;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhachHangBLL {
    private KhachHangDAO khachHangDAO;

    public KhachHangBLL() {
        khachHangDAO = new KhachHangDAO();
    }

    public boolean kiemTraTonTai(int maKhachHang) throws SQLException {
        return khachHangDAO.kiemTraTonTai(maKhachHang);
    }

    public void themKhachHang(KhachHangDTO kh) throws SQLException, Exception {
        if (kiemTraTonTai(kh.getMaKhachHang())) {
            throw new Exception("Khách hàng với mã " + kh.getMaKhachHang() + " đã tồn tại!");
        }
        khachHangDAO.themKhachHang(kh);
    }

    public void capNhatKhachHang(KhachHangDTO kh) throws SQLException {
        if (!kiemTraTonTai(kh.getMaKhachHang())) {
            throw new SQLException("Không tìm thấy khách hàng với mã: " + kh.getMaKhachHang());
        }
        khachHangDAO.capNhatKhachHang(kh);
    }

    public void xoaKhachHang(int maKhachHang) throws SQLException {
        khachHangDAO.xoaKhachHang(maKhachHang);
    }

    public ArrayList<KhachHangDTO> layDanhSachKhachHang() throws SQLException {
        return khachHangDAO.layDanhSachKhachHang();
    }
}
