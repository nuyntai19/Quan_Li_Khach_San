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
            if (!"Dang cho xac nhan".equalsIgnoreCase(phieu.getTrangThai())) 
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

    public void xoaCheckInDTO(int maThuePhong) {
        for (CheckInOutDTO checkIn : dsCheckIn) {
            if (checkIn.getMaThuePhong() == maThuePhong) {
                dsCheckIn.remove(checkIn);
                break;
            }
        }
    }

    public void kiemTraQuaHanCheckIn(ArrayList<CheckInOutDTO> dsCheckIn) {
        Date today = new Date();
    
        for (CheckInOutDTO checkIn : dsCheckIn) 
        {
            try 
            {
                if (checkIn.getNgayDatPhong().before(today) && "Da dat".equalsIgnoreCase(checkIn.getTrangThai())) 
                {
                    checkIn.setTrangThai("Qua han check-in");
                    phongDAO.capNhatTrangThaiPhong(checkIn.getMaPhong(), "Dang bao tri");
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
            if (checkIn.getNgayTraPhong().before(today) && "Dang thue".equalsIgnoreCase(checkIn.getTrangThai())) 
            {
                try
                {
                    checkIn.setTrangThai("Qua han check-out");
                    phongDAO.capNhatTrangThaiPhong(checkIn.getMaPhong(), "Dang bao tri");
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi cập nhật trạng thái!");
                }
            }
        }
    }
    
    public ArrayList<CheckInOutDTO> timChiTietCheckInOut(String loaiTimKiem, String tuKhoa) throws SQLException {
        ArrayList<CheckInOutDTO> ketQua = new ArrayList<>();
        ArrayList<CheckInOutDTO> danhSach = layDanhSachCheckInHopLe();  
    
        for (CheckInOutDTO ct : danhSach) {
            switch (loaiTimKiem) {
                case "Mã thuê phòng":
                    if (String.valueOf(ct.getMaThuePhong()).contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Mã phòng":
                    if (String.valueOf(ct.getMaPhong()).contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Mã khách hàng":
                    if (String.valueOf(ct.getMaKhachHang()).contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Ngày đặt phòng":
                    if (ct.getNgayDatPhong().toString().contains(tuKhoa)) {  // Kiểm tra ngày tháng nếu nhập theo định dạng chuỗi
                        ketQua.add(ct);
                    }
                    break;
                case "Ngày trả phòng":
                    if (ct.getNgayTraPhong().toString().contains(tuKhoa)) {  // Kiểm tra ngày tháng nếu nhập theo định dạng chuỗi
                        ketQua.add(ct);
                    }
                    break;
                case "Trạng thái":
                    if (ct.getTrangThai().contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
            }
        }
        return ketQua;
    }

    public CheckInOutDTO timCheckInOut(int maPhong){
        for (CheckInOutDTO c : dsCheckIn){
            if (c.getMaPhong() == maPhong)
            return c;
        }
        return null;
    }


}

