package BLL;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.KiemTraTinhTrangDAO;
import DTO.KiemTraTinhTrang;

public class KiemTraTinhTrangBUS {
    private ArrayList<KiemTraTinhTrang> dsKTTT = null;
    private KiemTraTinhTrangDAO ktttDao = new KiemTraTinhTrangDAO();

    public KiemTraTinhTrangBUS() {
        try {
            getdsKTTT();
        } catch (SQLException e) {
            e.printStackTrace(); // hoặc log ra file
        }
    }

    public void getdsKTTT() throws SQLException{
        dsKTTT = ktttDao.getListKTTT();
    }
    public ArrayList<KiemTraTinhTrang> getDsKTTT() {
        return dsKTTT;
    }

    public boolean themKTTT(KiemTraTinhTrang kt) throws SQLException {
        boolean success = ktttDao.themKTTT(kt);
        if (success) {
            dsKTTT.add(kt);
        }
        return success;
    }

    public boolean suaKTTT(KiemTraTinhTrang kt) throws SQLException {
        boolean success = ktttDao.suaKTTT(kt);
        if (success) {
            for (int i = 0; i < dsKTTT.size(); i++) {
                if (dsKTTT.get(i).getMaKiemTra() == kt.getMaKiemTra()) {
                    dsKTTT.set(i, kt);
                    break;
                }
            }
        }
        return success;
    }

    public boolean xoaKTTT(int maKiemTra) throws SQLException {
        boolean success = ktttDao.xoaKTTT(maKiemTra);
        if (success) {
            dsKTTT.removeIf(k -> k.getMaKiemTra() == maKiemTra);
        }
        return success;
    }

    public KiemTraTinhTrang timKiemKTTT(int maKiemTra) {
        for (KiemTraTinhTrang kt : dsKTTT) {
            if (kt.getMaKiemTra() == maKiemTra) {
                return kt;
            }
        }
        return null;
    }
    public KiemTraTinhTrang timTheoMaPhong(int maPhong) throws SQLException {
        return ktttDao.timTheoMaPhong(maPhong);
    }
    public boolean kiemTraHopLeKTTT(int maPhong, int maThuePhong, Date ngayKiemTra) {
    	return ktttDao.kiemTraHopLeDeTaoKTTT(maPhong, maThuePhong, ngayKiemTra);
    }
    public boolean kiemTraTonTaiPhong(int maPhong) {
        try {
            return ktttDao.kiemTraTonTai(maPhong);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<KiemTraTinhTrang> timChiTietKiemTraTinhTrang(String loaiTimKiem, String tuKhoa) throws SQLException {
        ArrayList<KiemTraTinhTrang> ketQua = new ArrayList<>();
        ArrayList<KiemTraTinhTrang> danhSach = getDsKTTT();  // Bạn cần có hàm này để trả về danh sách
    
        for (KiemTraTinhTrang kt : danhSach) {
            switch (loaiTimKiem) {
                case "Mã kiểm tra":
                    if (String.valueOf(kt.getMaKiemTra()).contains(tuKhoa)) {
                        ketQua.add(kt);
                    }
                    break;
                case "Mã phòng":
                    if (String.valueOf(kt.getMaPhong()).contains(tuKhoa)) {
                        ketQua.add(kt);
                    }
                    break;
                case "Mã nhân viên":
                    if (String.valueOf(kt.getMaNhanVien()).contains(tuKhoa)) {
                        ketQua.add(kt);
                    }
                    break;
                case "Mã thuê phòng":
                    if (String.valueOf(kt.getMaThuePhong()).contains(tuKhoa)) {
                        ketQua.add(kt);
                    }
                    break;
                case "Ngày kiểm tra":
                    if (kt.getNgayKiemTra().toString().contains(tuKhoa)) {
                        ketQua.add(kt);
                    }
                    break;
                case "Mô tả thiệt hại":
                    if (kt.getMoTaThietHai() != null && kt.getMoTaThietHai().toLowerCase().contains(tuKhoa.toLowerCase())) {
                        ketQua.add(kt);
                    }
                    break;
                case "Chi phí đền bù":
                    if (kt.getChiPhiDenBu().toString().contains(tuKhoa)) {
                        ketQua.add(kt);
                    }
                    break;
            }
        }
    
        return ketQua;
    }
    public KiemTraTinhTrang timKTTT(int maPhong, int maThuePhong) throws SQLException {
        return ktttDao.timKTTT(maPhong, maThuePhong);
    }
}
