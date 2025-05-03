
package BLL;
import DAO.ThongKeDAO;
import java.util.Date;
import java.util.Map;
import java.sql.SQLException;
import java.util.HashMap;

public class ThongKeBLL {
    ThongKeDAO dao = new ThongKeDAO();

    public Map<String, Double> layDoanhThuTheoLoai(Date tuNgay, Date denNgay) {
        try {
            return dao.thongKeDoanhThuTheoLoai(tuNgay, denNgay);
        } catch (SQLException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
    
    public Map<String, Double> thongKeTheoThang(int thang, int nam) {
        try {
            return dao.thongKeTheoThang(thang, nam);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Double> thongKeTheoNam(int nam) {
        try {
            return dao.thongKeTheoNam(nam);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int getSoLuongForLoaiTheoNgay(String loai, Date tuNgay, Date denNgay) {
        try {
            return dao.getSoLuongForLoaiTheoNgay(loai, tuNgay, denNgay);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getSoLuongForLoaiTheoThang(String loai, int thang, int nam) {
        try {
            return dao.getSoLuongForLoaiTheoThang(loai, thang, nam);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getSoLuongForLoaiTheoNam(String loai, int nam) {
        try {
            return dao.getSoLuongForLoaiTheoNam(loai, nam);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
