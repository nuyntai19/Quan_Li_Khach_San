package BLL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.ChiTietPhieuThuePhongDAO;
import DAO.PhieuThuePhongDAO;
import DAO.QuanLiPhongDAO;
import DTO.CheckInOutDTO;
import DTO.ChiTietPhieuThuePhongDTO;
import DTO.PhieuThuePhongDTO;

public class CheckInOutBLL {
    private ArrayList<CheckInOutDTO> dsCheckIn;
    private QuanLiPhongDAO phongDAO = new QuanLiPhongDAO();
    private PhieuThuePhongDAO phieuThueDAO = new PhieuThuePhongDAO();
    private ChiTietPhieuThuePhongDAO chiTietDAO = new ChiTietPhieuThuePhongDAO();
    public CheckInOutBLL() {
        try {
        	this.dsCheckIn = layDanhSachCheckInHopLe();
        } catch (SQLException e) {
            e.printStackTrace(); // hoặc log ra file
        }
    }
    
    public ArrayList<CheckInOutDTO> layDanhSachCheckInHopLe() throws SQLException {
        ArrayList<CheckInOutDTO> dsCheckIn = new ArrayList<>();

        ArrayList<PhieuThuePhongDTO> dsPhieu = phieuThueDAO.layDanhSachPhieuThue();
        ArrayList<ChiTietPhieuThuePhongDTO> dsChiTiet = chiTietDAO.layDanhSachChiTiet();
        for (PhieuThuePhongDTO phieu : dsPhieu) {
            if (!"Đang chờ xác nhận".equalsIgnoreCase(phieu.getTrangThai())) 
                continue;
            for (ChiTietPhieuThuePhongDTO ct : dsChiTiet) 
            {
                if(ct.getMaThuePhong() != phieu.getMaThuePhong() )
                    continue;
              
                CheckInOutDTO checkIn = new CheckInOutDTO();
                checkIn.setMaThuePhong(phieu.getMaThuePhong());
                checkIn.setMaKhachHang(phieu.getMaKhachHang());
                checkIn.setMaPhong(ct.getMaPhong());
                checkIn.setNgayDatPhong(ct.getNgayDatPhong());
                checkIn.setNgayTraPhong(ct.getNgayTraPhong());
                checkIn.setTrangThai(phieu.getTrangThai());

                dsCheckIn.add(checkIn);
            }
        }

        return dsCheckIn;
    }
    public void capNhatTrangThaiCheckIn(int maThuePhong) throws SQLException {
        PhieuThuePhongDTO phieu = phieuThueDAO.timPhieuThueTheoMa(maThuePhong);
        if (phieu != null && "Đang chờ xác nhận".equalsIgnoreCase(phieu.getTrangThai())) {
            phieu.setTrangThai("Đang thuê");
            phieuThueDAO.capNhatPhieuThue(phieu);
        }
    }
    public void xoaCheckInDTO(int maThuePhong) {
        for (CheckInOutDTO checkIn : dsCheckIn) {
            if (checkIn.getMaThuePhong() == maThuePhong) {
                dsCheckIn.remove(checkIn);
                break;
            }
        }
    }
    public void capNhatTrangThaiXoaCheckIn(int maThuePhong) throws SQLException {
        String trangThaiHoanThanh = "Hoàn thành";
        phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, trangThaiHoanThanh);
        dsCheckIn.removeIf(checkIn -> checkIn.getMaThuePhong() == maThuePhong);
    }

    public void updTTCheckInOut(int maPhong){
        for (CheckInOutDTO checkIn : dsCheckIn) {
            if (checkIn.getMaPhong() == maPhong) {
                checkIn.setTrangThai("Đã check in");
            }
        }
    }
    public void kiemTraQuaHanCheckIn(ArrayList<CheckInOutDTO> dsCheckIn) {
        Date today = new Date();
    
        for (CheckInOutDTO checkIn : dsCheckIn) 
        {
            try 
            {
                if (checkIn.getNgayDatPhong().before(today) && "Đã đặt".equalsIgnoreCase(checkIn.getTrangThai())) 
                {
                    checkIn.setTrangThai("Quá hạn check-in");
                    phongDAO.capNhatTrangThaiPhong(checkIn.getMaPhong(), "Đang bảo trì");
                    //phieuThueDAO.capNhatTrangThaiPhieu(checkIn.getMaThuePhong(), "Đã huỷ");
                }
            } 
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi cập nhật trạng thái!");
            }
        }
    }

    public void kiemTraQuaHanCheckOut(ArrayList<CheckInOutDTO> dsCheckIn) {
        Date today = new Date();
    
        for (CheckInOutDTO checkIn : dsCheckIn) 
        {
            if (checkIn.getNgayTraPhong().before(today) && "Đang thuê".equalsIgnoreCase(checkIn.getTrangThai())) 
            {
                try
                {
                    checkIn.setTrangThai("Quá hạn check-out");
                    phongDAO.capNhatTrangThaiPhong(checkIn.getMaPhong(), "Đang bảo trì");
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi cập nhật trạng thái!");
                }
            }
        }
    }
    

}

