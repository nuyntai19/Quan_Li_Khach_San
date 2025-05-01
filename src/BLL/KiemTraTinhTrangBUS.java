package BLL;

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
    
    
}
