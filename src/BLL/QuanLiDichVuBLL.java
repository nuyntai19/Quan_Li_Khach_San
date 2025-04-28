
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
    
    // Hàm kiểm tra số lượng còn lại của dịch vụ
    public int laySoLuongDangCo(int maDichVu) throws SQLException {
        ArrayList<QuanLiDichVuDTO> danhSachDichVu = dichVuDAO.layDanhSachDichVu();
        for (QuanLiDichVuDTO dv : danhSachDichVu) {
            if (dv.getMaDichVu() == maDichVu) {
                return dv.getSoLuong();
            }
        }
        return 0; 
    }
    
    // Hàm giảm số lượng dịch vụ và cập nhật lại dịch vụ
    public void giamSoLuong(int maDichVu, int soLuong) throws SQLException {
        // Lấy thông tin dịch vụ
        ArrayList<QuanLiDichVuDTO> danhSachDichVu = dichVuDAO.layDanhSachDichVu();
        for (QuanLiDichVuDTO dv : danhSachDichVu) {
            if (dv.getMaDichVu() == maDichVu) {
                // Cập nhật số lượng mới
                dv.setSoLuong(dv.getSoLuong() - soLuong);
                // Gọi phương thức `suaDichVu` để cập nhật dịch vụ trong cơ sở dữ liệu
                dichVuDAO.suaDichVu(dv);
                break;
            }
        }
    }
    
     // Hàm tìm dịch vụ theo mã hoặc tên
    public ArrayList<QuanLiDichVuDTO> timDichVu(String maDichVu, String tenDichVu) throws SQLException {
        ArrayList<QuanLiDichVuDTO> danhSachDichVu = dichVuDAO.layDanhSachDichVu();
        ArrayList<QuanLiDichVuDTO> ketQua = new ArrayList<>();

        for (QuanLiDichVuDTO dv : danhSachDichVu) {
            if ((maDichVu.isEmpty() || Integer.toString(dv.getMaDichVu()).contains(maDichVu)) && 
                (tenDichVu.isEmpty() || dv.getTenDichVu().toLowerCase().contains(tenDichVu.toLowerCase()))) {
                ketQua.add(dv);
            }
        }

        return ketQua;
    }
}

