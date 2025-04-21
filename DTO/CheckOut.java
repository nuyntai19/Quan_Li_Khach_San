package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOut {
    private int maPhong;
    private String maKhachHang;
    private LocalDateTime ngayCheckOut;
    private double soTienThanhToan;


    public CheckOut(){}
    public CheckOut(int maPhong, String maKhachHang, LocalDateTime ngayCheckOut, double soTienThanhToan) {
        this.maPhong = maPhong;
        this.maKhachHang = maKhachHang;
        this.ngayCheckOut = ngayCheckOut;
        this.soTienThanhToan = soTienThanhToan;
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

    public String getNgayCheckOut() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ngayCheckOut.format(formatter);
    }

    public void setNgayCheckOut(LocalDateTime ngayCheckOut) {
        this.ngayCheckOut = ngayCheckOut;
    }

    public double getSoTienThanhToan() {
        return soTienThanhToan;
    }

    public void setSoTienThanhToan(double soTienThanhToan) {
        this.soTienThanhToan = soTienThanhToan;
    }
}
