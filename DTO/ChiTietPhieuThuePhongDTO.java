
package DTO;

import java.util.Date;


public class ChiTietPhieuThuePhongDTO {
     private int maThuePhong;
    private int maPhong;
    private Date ngayDatPhong;
    private Date ngayTraPhong;
    private double giaPhong;
    private double thanhTien;
    private String trangThai;

    public ChiTietPhieuThuePhongDTO(int maThuePhong, int maPhong, Date ngayDatPhong, Date ngayTraPhong, double giaPhong, double thanhTien, String trangThai) {
        this.maThuePhong = maThuePhong;
        this.maPhong = maPhong;
        this.ngayDatPhong = ngayDatPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.giaPhong = giaPhong;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public int getMaThuePhong() {
        return maThuePhong;
    }

    public void setMaThuePhong(int maThuePhong) {
        this.maThuePhong = maThuePhong;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public Date getNgayDatPhong() {
        return ngayDatPhong;
    }

    public void setNgayDatPhong(Date ngayDatPhong) {
        this.ngayDatPhong = ngayDatPhong;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
