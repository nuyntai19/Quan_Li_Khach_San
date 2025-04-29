package BLL;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.sql.SQLException;
import java.util.List;

public class ChiTietHoaDonBLL {
    private final ChiTietHoaDonDAO chiTietHoaDonDAO;

    public ChiTietHoaDonBLL() throws SQLException {
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    }

    // Thêm danh sách chi tiết hóa đơn
    public boolean themDanhSachChiTiet(List<ChiTietHoaDonDTO> dsChiTiet) throws SQLException {
        return chiTietHoaDonDAO.themDanhSachChiTiet(dsChiTiet);
    }

    // Xóa chi tiết hóa đơn theo mã hóa đơn
    public boolean xoaChiTietTheoMaHD(String maHD) throws SQLException {
        return chiTietHoaDonDAO.xoaChiTietTheoMaHD(maHD);
    }
    
    public List<ChiTietHoaDonDTO> layDanhSachChiTietHoaDon() throws SQLException {
        return chiTietHoaDonDAO.layDanhSachChiTietHoaDon();
    }
    
    public boolean insertChiTietHoaDon(ChiTietHoaDonDTO cthd) throws SQLException {
        return chiTietHoaDonDAO.insertChiTietHoaDon(cthd);
    }

    public List<ChiTietHoaDonDTO> getByMaHD(String maHD) throws SQLException {
        return chiTietHoaDonDAO.getByMaHD(maHD);
    }

    
}
