package BLL;

import DAO.HoaDonDAO;
import DAO.ChiTietHoaDonDAO;
import DTO.HoaDonDTO;
import DTO.ChiTietHoaDonDTO;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HoaDonBLL {
    private final HoaDonDAO hoaDonDAO;
    private final ChiTietHoaDonDAO chiTietHoaDonDAO;

    public HoaDonBLL() throws SQLException {
        hoaDonDAO = new HoaDonDAO();
        chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    }

    // Kiểm tra hóa đơn có tồn tại không
    public boolean kiemTraHoaDonTonTai(int maPTP) throws SQLException {
        return hoaDonDAO.kiemTraTonTai(maPTP);
    }

    // Xóa hóa đơn và tất cả chi tiết liên quan
    public boolean xoaHoaDon(String maHoaDon) throws SQLException {
        // Xóa chi tiết hóa đơn liên quan
        boolean xoaChiTiet = chiTietHoaDonDAO.xoaChiTietTheoMaHD(maHoaDon);
        // Xóa hóa đơn
        if (xoaChiTiet) {
            return hoaDonDAO.xoaHoaDon(maHoaDon);
        }
        return false;
    }

    // Lấy danh sách hóa đơn
    public List<HoaDonDTO> layDanhSachHoaDon() throws SQLException {
        return hoaDonDAO.layDanhSachHoaDon();
    }
    
     public boolean insertHoaDon(String maHD, String maPTP, Date ngayLap, double tongTien) throws SQLException {
        return hoaDonDAO.insertHoaDon(maHD, maPTP, ngayLap, tongTien);
    }

    public boolean updateTongTien(String maHD, double tongTien) throws SQLException {
        return hoaDonDAO.updateTongTien(maHD, tongTien);
    }
    
    public String generateNextMaHD() {
        int count = hoaDonDAO.demSoLuongHoaDon() + 1;
            return String.format("HD%03d", count); 
    }

    public ArrayList<HoaDonDTO> timHoaDon(String loaiTimKiem, String tuKhoa) throws SQLException {
        ArrayList<HoaDonDTO> ketQua = new ArrayList<>();
        List<HoaDonDTO> danhSach = layDanhSachHoaDon(); 

        for (HoaDonDTO hd : danhSach) {
            switch (loaiTimKiem) {
                case "Mã phiếu thuê phòng":
                    if (String.valueOf(hd.getMaPTP()).contains(tuKhoa)) {
                        ketQua.add(hd);
                    }
                    break;
                case "Mã hóa đơn":
                    if (String.valueOf(hd.getMaHD()).contains(tuKhoa)) {
                        ketQua.add(hd);
                    }
                    break;
                case "Ngày lập":
                    if (hd.getNgayLap().toString().contains(tuKhoa)) {
                        ketQua.add(hd);
                    }
                    break;
            }
        }

        return ketQua;
    }

}
