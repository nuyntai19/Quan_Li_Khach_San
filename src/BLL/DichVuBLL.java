package BLL;

import DAO.DichVuDAO;
import DTO.DichVuDTO;

import java.sql.SQLException;
import java.util.List;

public class DichVuBLL {
    private DichVuDAO dao;

    public DichVuBLL() {
        try {
            dao = new DichVuDAO();
        } catch (SQLException e) {
        }
    }

    public List<DichVuDTO> danhsachDichVuGoc() throws SQLException {
        return dao.getAll();
    }

    public List<DichVuDTO> timDichVuTheoMa(String maDV) throws SQLException {
        return dao.findByMaDichVu(maDV);
    }
}
