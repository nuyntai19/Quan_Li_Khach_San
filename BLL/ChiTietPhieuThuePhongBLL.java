package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ChiTietPhieuThuePhongDAO;
import DTO.ChiTietPhieuThuePhongDTO;

public class ChiTietPhieuThuePhongBLL {
    private ChiTietPhieuThuePhongDAO chiTietDAO;

    public ChiTietPhieuThuePhongBLL() {
        chiTietDAO = new ChiTietPhieuThuePhongDAO();
    }

    public ArrayList<ChiTietPhieuThuePhongDTO> layDanhSachChiTiet() throws SQLException {
        return chiTietDAO.layDanhSachChiTiet();
    }

    public void themChiTiet(ChiTietPhieuThuePhongDTO ct) throws Exception {
        if (kiemTraTonTai(ct.getMaThuePhong(), ct.getMaPhong())) {
            throw new Exception("Chi tiết thuê đã tồn tại với mã thuê " + ct.getMaThuePhong() + " và mã phòng " + ct.getMaPhong());
        }
        chiTietDAO.themChiTiet(ct);
    }

    public void capNhatChiTiet(ChiTietPhieuThuePhongDTO ct) throws SQLException {
        if (!kiemTraTonTai(ct.getMaThuePhong(), ct.getMaPhong())) {
            throw new SQLException("Không tìm thấy chi tiết thuê để cập nhật.");
        }
        chiTietDAO.capNhatChiTiet(ct);
    }

    public void xoaChiTiet(int maThuePhong, int maPhong) throws SQLException {
        if (!kiemTraTonTai(maThuePhong, maPhong)) {
            throw new SQLException("Không tìm thấy chi tiết thuê để xóa.");
        }
        chiTietDAO.xoaChiTiet(maThuePhong, maPhong);
    }

    private boolean kiemTraTonTai(int maThuePhong, int maPhong) throws SQLException {
        ArrayList<ChiTietPhieuThuePhongDTO> danhSach = chiTietDAO.layDanhSachChiTiet();
        for (ChiTietPhieuThuePhongDTO ct : danhSach) {
            if (ct.getMaThuePhong() == maThuePhong && ct.getMaPhong() == maPhong) {
                return true;
            }
        }
        return false;
    }
}
