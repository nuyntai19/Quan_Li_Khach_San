package BLL;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.PhongDAO;
import DTO.Phong;

public class PhongBUS {
    private ArrayList<Phong> dsPhong = null;
    private PhongDAO pDAO = new PhongDAO();

    public PhongBUS() throws SQLException{
        getdsPhong();
    }

    public void getdsPhong() throws SQLException{
        dsPhong = pDAO.getListPhong();
    }
}
