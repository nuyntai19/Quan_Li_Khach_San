package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.QuanLiPhongDAO;
import DTO.CheckInOutDTO;

public class CheckInOutTEMP {
    private static final ArrayList<CheckInOutDTO> tempList = new ArrayList<>();
    private static final QuanLiPhongDAO phongDAO = new QuanLiPhongDAO();

    public static void addCheckInOut(CheckInOutDTO checkInOutDTO) {
        for (CheckInOutDTO item : tempList) {
            if (item.getMaPhong() == checkInOutDTO.getMaPhong()) 
                return;
        }
        tempList.add(checkInOutDTO);
    }

    public static ArrayList<CheckInOutDTO> getTempList() {
        return tempList;
    }

    public static void capNhatCheckInOut(CheckInOutDTO checkInOutDTO) {
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i).getMaPhong() == checkInOutDTO.getMaPhong()) {
                tempList.set(i, checkInOutDTO);
                break;
            }
        }
    }

    public static void xoaCheckInOut(int maPhong) {
        tempList.removeIf(item -> item.getMaPhong() == maPhong);
    }

    public static CheckInOutDTO timCheckInOutTEMP(int maPhong) {
        for (CheckInOutDTO checkInOutDTO : tempList) {
            if (checkInOutDTO.getMaPhong() == maPhong) {
                return checkInOutDTO;
            }
        }
        return null;
    }

    public static void kiemTraQuaHanCheckOut(ArrayList<CheckInOutDTO> dsCheckOut) {
        Date today = new Date();
    
        for (CheckInOutDTO checkOut : dsCheckOut) {
            if (checkOut.getNgayTraPhong().before(today) && "Dang thue".equalsIgnoreCase(checkOut.getTrangThai())) {
                try {
                    checkOut.setTrangThai("Qua han check-out");
                    phongDAO.capNhatTrangThaiPhong(checkOut.getMaPhong(), "Dang bao tri");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi cập nhật trạng thái!");
                }
            }
        }
    }

    public static ArrayList<CheckInOutDTO> timChiTietCheckInOutTrongTemp(String loaiTimKiem, String tuKhoa) {
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
