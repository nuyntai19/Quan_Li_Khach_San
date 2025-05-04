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

public class CheckInOutTEMP {
    private ArrayList<CheckInOutDTO> tempList;
    private QuanLiPhongDAO phongDAO = new QuanLiPhongDAO();
    private PhieuThuePhongDAO phieuThueDAO = new PhieuThuePhongDAO();
    private ChiTietPhieuThuePhongDAO chiTietDAO = new ChiTietPhieuThuePhongDAO();

    
    public CheckInOutTEMP() {
        try {
            this.tempList = getTempList();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addCheckInOut(CheckInOutDTO checkInOutDTO) {
        for (CheckInOutDTO item : tempList) {
            if (item.getMaPhong() == checkInOutDTO.getMaPhong()) 
                return;
        }
        tempList.add(checkInOutDTO);
    }

    public ArrayList<CheckInOutDTO> getdsTempList() {
        return tempList;
    }
    public ArrayList<CheckInOutDTO> getTempList() throws SQLException {
        ArrayList<CheckInOutDTO> tempList = new ArrayList<>();

        ArrayList<PhieuThuePhongDTO> dsPhieu = phieuThueDAO.layDanhSachPhieuThue();
        ArrayList<ChiTietPhieuThuePhongDTO> dsChiTiet = chiTietDAO.layDanhSachChiTiet();
        for (PhieuThuePhongDTO phieu : dsPhieu) {
            if (!"Dang thue".equalsIgnoreCase(phieu.getTrangThai())) 
                continue;
            for (ChiTietPhieuThuePhongDTO ct : dsChiTiet) 
            {
                if(ct.getMaThuePhong() != phieu.getMaThuePhong() )
                    continue;
              
                CheckInOutDTO checkIn = new CheckInOutDTO();
                checkIn.setMaThuePhong(phieu.getMaThuePhong());
                checkIn.setMaPhong(ct.getMaPhong());
                checkIn.setMaKhachHang(phieu.getMaKhachHang());
                checkIn.setNgayDatPhong(ct.getNgayDatPhong());
                checkIn.setNgayTraPhong(ct.getNgayTraPhong());
                checkIn.setTrangThai(phieu.getTrangThai());

                tempList.add(checkIn);
            }
        }

        return tempList;
    }

    public void capNhatCheckInOut(CheckInOutDTO checkInOutDTO) {
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).getMaPhong() == checkInOutDTO.getMaPhong()) {
                tempList.set(i, checkInOutDTO);
                break;
            }
        }
    }

    public void xoaCheckInOut(int maPhong) {
        tempList.removeIf(item -> item.getMaPhong() == maPhong);
    }

    public CheckInOutDTO timCheckInOutTEMP(int maPhong) {
        for (CheckInOutDTO checkInOutDTO : tempList) {
            if (checkInOutDTO.getMaPhong() == maPhong) {
                return checkInOutDTO;
            }
        }
        return null;
    }


    public void kiemTraQuaHanCheckOut(ArrayList<CheckInOutDTO> dsCheckIn) {
        Date today = new Date();
    
        for (CheckInOutDTO checkIn : dsCheckIn) 
        {
            try
            {
                if (checkIn.getNgayTraPhong().before(today) ) 
                {
                    checkIn.setTrangThai("Qua han check-out");
                    phongDAO.capNhatTrangThaiPhong(checkIn.getMaPhong(), "Dang bao tri");
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Lỗi cập nhật trạng thái!");
            }
            
        }
    }

    public ArrayList<CheckInOutDTO> timChiTietCheckInOutTrongTemp(String loaiTimKiem, String tuKhoa) {
        ArrayList<CheckInOutDTO> ketQua = new ArrayList<>();

        for (CheckInOutDTO ct : tempList) {
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
                    if (ct.getNgayDatPhong().toString().contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Ngày trả phòng":
                    if (ct.getNgayTraPhong().toString().contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Trạng thái":
                    if (ct.getTrangThai().toLowerCase().contains(tuKhoa.toLowerCase())) {
                        ketQua.add(ct);
                    }
                    break;
            }
        }
    
        return ketQua;
    }
}
