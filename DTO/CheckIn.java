package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckIn {
    private int maPhong;
    private String maKhachHang;
    private LocalDateTime ngayCheckIn;
    private LocalDateTime ngayCheckOut;
    private String loaiPhong;

    public CheckIn(){}

    public CheckIn(int maPhong, String maKhachHang, LocalDateTime ngayCheckIn, LocalDateTime ngayCheckOut, String loaiPhong) {
        this.maPhong = maPhong;
        this.maKhachHang = maKhachHang;
        this.ngayCheckIn = ngayCheckIn;
        this.ngayCheckOut = ngayCheckOut;
        this.loaiPhong = loaiPhong;
    }

    
    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public LocalDateTime getNgayCheckIn() {
        return ngayCheckIn;
    }

    public void setNgayCheckIn(LocalDateTime ngayCheckIn) {
        this.ngayCheckIn = ngayCheckIn;
    }

    public String getNgayCheckOut() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ngayCheckOut.format(formatter);
    }

    public void setNgayCheckOut(LocalDateTime ngayCheckOut) {
        this.ngayCheckOut = ngayCheckOut;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }
}
