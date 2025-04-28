package BLL;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.sql.SQLException;

public class NhanVienBLL {
    private final NhanVienDAO dao;

    public NhanVienBLL() {
        dao = new NhanVienDAO();
    }

    public ArrayList<NhanVienDTO> layDanhSachNhanVien() throws SQLException {
        return dao.layDanhSachNhanVien();
    }

    public void themNhanVien(NhanVienDTO nv) throws SQLException {
        dao.themNhanVien(nv);
    }

    public void suaNhanVien(NhanVienDTO nv) throws SQLException {
        dao.suaNhanVien(nv);
    }

    public void xoaNhanVien(int maNhanVien) throws SQLException {
        dao.xoaNhanVien(maNhanVien);
    }
}
