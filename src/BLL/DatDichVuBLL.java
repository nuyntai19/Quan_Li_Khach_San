package BLL;

import DAO.DatDichVuDAO;
import DTO.DatDichVuDTO;
import java.sql.SQLException;
import java.util.ArrayList;


public class DatDichVuBLL {
    private final DatDichVuDAO datDichVuDAO;

    public DatDichVuBLL() {
        datDichVuDAO = new DatDichVuDAO();
    }

    // Lấy danh sách
    public ArrayList<DatDichVuDTO> layDanhSachDatDichVu() throws SQLException {
        return datDichVuDAO.layDanhSachDatDichVu();
    }

    // Thêm
    public void themDatDichVu(DatDichVuDTO ddv) throws SQLException {
        // Kiểm tra xem dịch vụ đã tồn tại chưa
        if (datDichVuDAO.kiemTraTonTai(ddv.getIdChiTietPhieuThue(), ddv.getMaDichVu())) {
            throw new SQLException("Dịch vụ đã tồn tại trong phiếu thuê.");
        }
        datDichVuDAO.themDatDichVu(ddv);
    }


    // Sửa
    public void suaDatDichVu(DatDichVuDTO ddv) throws SQLException {
        // Kiểm tra xem dịch vụ có tồn tại không trước khi sửa
        if (!datDichVuDAO.kiemTraTonTai(ddv.getIdChiTietPhieuThue(), ddv.getMaDichVu())) {
            throw new SQLException("Dịch vụ không tồn tại trong phiếu thuê.");
        }
        datDichVuDAO.suaDatDichVu(ddv);
    }


    // Xóa
    public void xoaDatDichVu(int idChiTietPhieuThue, int maDichVu) throws SQLException {
        // Kiểm tra xem dịch vụ có tồn tại không trước khi xóa
        if (!datDichVuDAO.kiemTraTonTai(idChiTietPhieuThue, maDichVu)) {
            throw new SQLException("Dịch vụ không tồn tại trong phiếu thuê.");
        }
        datDichVuDAO.xoaDatDichVu(idChiTietPhieuThue, maDichVu);
    }
    
    public ArrayList<DatDichVuDTO> getByIDChiTietPhieuThue(int id) {
        return datDichVuDAO.getByIDChiTietPhieuThue(id);
    }
    
    

}
