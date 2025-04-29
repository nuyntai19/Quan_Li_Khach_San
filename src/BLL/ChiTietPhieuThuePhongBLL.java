package BLL;

import DAO.ChiTietPhieuThuePhongDAO;
import DTO.ChiTietPhieuThuePhongDTO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChiTietPhieuThuePhongBLL {
    private ChiTietPhieuThuePhongDAO chiTietDAO;

    public ChiTietPhieuThuePhongBLL() {
        chiTietDAO = new ChiTietPhieuThuePhongDAO();
    }

    public ArrayList<ChiTietPhieuThuePhongDTO> layDanhSachChiTiet() throws SQLException {
        return chiTietDAO.layDanhSachChiTiet();
    }

    public void themChiTiet(ChiTietPhieuThuePhongDTO ct) throws Exception {
        if (chiTietDAO.kiemTraTonTai(ct.getMaThuePhong(), ct.getMaPhong(), ct.getNgayDatPhong(), ct.getNgayTraPhong())) {
            throw new Exception("Chi tiết thuê đã tồn tại với mã thuê " + ct.getMaThuePhong() + " và mã phòng " + ct.getMaPhong() + " trong khoảng thời gian này.");
        }
        chiTietDAO.themChiTiet(ct);
    }

    public void capNhatChiTiet(ChiTietPhieuThuePhongDTO ct) throws SQLException {
        if (!chiTietDAO.kiemTraTonTai(ct.getMaThuePhong(), ct.getMaPhong(), ct.getNgayDatPhong(), ct.getNgayTraPhong())) {
            throw new SQLException("Không tìm thấy chi tiết thuê để cập nhật.");
        }
        chiTietDAO.capNhatChiTiet(ct);
    }

    public void xoaChiTiet(int id) throws SQLException {
        chiTietDAO.xoaChiTiet(id);
    }
    
    public ArrayList<ChiTietPhieuThuePhongDTO> timChiTiet(String loaiTimKiem, String tuKhoa) throws SQLException {
        ArrayList<ChiTietPhieuThuePhongDTO> ketQua = new ArrayList<>();
        ArrayList<ChiTietPhieuThuePhongDTO> danhSach = layDanhSachChiTiet();

        for (ChiTietPhieuThuePhongDTO ct : danhSach) {
            switch (loaiTimKiem) {
                case "Mã đặt phòng":
                    if (String.valueOf(ct.getMaThuePhong()).contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Mã phòng":
                    if (String.valueOf(ct.getMaPhong()).contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Ngày Đặt Phòng":
                    if (ct.getNgayDatPhong().toString().contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Ngày Trả Phòng":
                    if (ct.getNgayTraPhong().toString().contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
            }
        }
        return ketQua;
    }


    
}
