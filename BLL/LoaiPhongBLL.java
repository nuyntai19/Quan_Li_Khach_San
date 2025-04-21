package BLL;
import DAO.LoaiPhongDAO;
import DTO.LoaiPhongDTO;
import java.util.ArrayList;
import java.sql.SQLException;

public class LoaiPhongBLL {
    private final LoaiPhongDAO loaiPhongDAO;

    public LoaiPhongBLL() {
        loaiPhongDAO = new LoaiPhongDAO();
    }
    
    public ArrayList<LoaiPhongDTO> layDanhSachLoaiPhong() throws SQLException {
        return loaiPhongDAO.layDanhSachLoaiPhong();
    }
    
    public ArrayList<String> layDanhSachMaLoaiPhong() throws SQLException {
        return loaiPhongDAO.layDanhSachMaLoaiPhong();
    }
    
}