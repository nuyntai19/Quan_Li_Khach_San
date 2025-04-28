package BLL;

import DTO.HoaDonDTO;
import DAO.HoaDonDAO;
import java.sql.SQLException;
import java.util.List;

public class HoaDonBLL {
    private HoaDonDAO hoaDonDAO;

    public HoaDonBLL() {
        try {
            hoaDonDAO = new HoaDonDAO(); // <<--- PHẢI khởi tạo thế này
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HoaDonDTO> layDanhSachHoaDon() throws SQLException {
        return hoaDonDAO.layDanhSachHoaDon();
    }

    public void xoaHoaDon(int maHD) throws SQLException {
        hoaDonDAO.xoaHoaDon(maHD);
    }

    public void themHoaDon(HoaDonDTO hd) throws SQLException {
        hoaDonDAO.themHoaDon(hd);
    }
}
