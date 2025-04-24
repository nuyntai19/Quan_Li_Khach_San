package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.PhieuThuePhongDAO;
import DTO.PhieuThuePhongDTO;

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
}
