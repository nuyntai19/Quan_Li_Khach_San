package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.KiemTraTinhTrangDAO;
import DTO.KiemTraTinhTrang;

public class KiemTraTinhTrangBUS {
    private ArrayList<KiemTraTinhTrang> dsKTTT = null;
    private KiemTraTinhTrangDAO ktttDao = new KiemTraTinhTrangDAO();

    public KiemTraTinhTrangBUS() throws SQLException{
        getdsKTTT();
    }

    public void getdsKTTT() throws SQLException{
        dsKTTT = ktttDao.getListKTTT();
    }
}
