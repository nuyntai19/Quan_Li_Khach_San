
package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.QuanLiDichVuDAO;
import DTO.QuanLiDichVuDTO;

public class QuanLiDichVuBLL {
    private final QuanLiDichVuDAO dichVuDAO;

    public QuanLiDichVuBLL() {
        dichVuDAO = new QuanLiDichVuDAO();
    }

    public void themDichVu(QuanLiDichVuDTO dv) throws Exception {
        if (dichVuDAO.kiemTraTonTai(dv.getMaDichVu())) {
            throw new Exception("Mã dịch vụ đã tồn tại!");
        }
        dichVuDAO.themDichVu(dv);
    }

    
    public void suaDichVu(QuanLiDichVuDTO dv) throws SQLException {
        if (!dichVuDAO.kiemTraTonTai(dv.getMaDichVu())) {
            throw new SQLException("Không tìm thấy dịch vụ với mã: " + dv.getMaDichVu());
        }
        dichVuDAO.suaDichVu(dv); // Gọi phương thức sửa trong DAO
    }

    public ArrayList<QuanLiDichVuDTO> layDanhSachDichVu() throws SQLException {
        return dichVuDAO.layDanhSachDichVu();
    }

    public void xoaDichVu(int maDichVu) throws SQLException {
        dichVuDAO.xoaDichVu(maDichVu);
    }
    
    public void giamSoLuongDichVu(int maDichVu, int soLuongGiam) throws SQLException {
        if (soLuongGiam <= 0) {
            throw new IllegalArgumentException("Số lượng đặt phải lớn hơn 0.");
        }
        dichVuDAO.giamSoLuongDichVu(maDichVu, soLuongGiam);
    }
}

