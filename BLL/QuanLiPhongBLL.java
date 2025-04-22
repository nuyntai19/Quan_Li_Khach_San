
package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.QuanLiPhongDAO;
import DTO.QuanLiPhongDTO;

public class QuanLiPhongBLL {
    private final QuanLiPhongDAO phongDAO;

    public QuanLiPhongBLL() {
        phongDAO = new QuanLiPhongDAO();
    }

    public void themPhong(QuanLiPhongDTO phong) throws Exception {
        if (phongDAO.kiemTraTonTai(phong.getMaPhong())) {
            throw new Exception("Mã phòng đã tồn tại!");
        }
        phongDAO.themPhong(phong);
    }

    
    public void suaPhong(QuanLiPhongDTO phong) throws SQLException {
        if (!phongDAO.kiemTraTonTai(phong.getMaPhong())) {
            throw new SQLException("Không tìm thấy phòng với mã: " + phong.getMaPhong());
        }
        phongDAO.suaPhong(phong);  // Gọi phương thức sửa trong DAO
    }

    public ArrayList<QuanLiPhongDTO> layDanhSachPhong() throws SQLException {
        return phongDAO.layDanhSachPhong();
    }

    public void xoaPhong(int maPhong) throws SQLException {
        phongDAO.xoaPhong(maPhong);
    }
}
