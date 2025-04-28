package DTO;

import java.util.Date;

public class HoaDonDTO {
    private int maHD;
    private int maPTP;
    private int maKhachHang; // <- Lấy thêm MaKhachHang từ PhieuThuePhong
    private Date ngayLap;
    private double tongTien;

    public HoaDonDTO() {}

    public HoaDonDTO(int maHD, int maPTP, int maKhachHang, Date ngayLap, double tongTien) {
        this.maHD = maHD;
        this.maPTP = maPTP;
        this.maKhachHang = maKhachHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getMaHD() { return maHD; }
    public void setMaHD(int maHD) { this.maHD = maHD; }

    public int getMaPTP() { return maPTP; }
    public void setMaPTP(int maPTP) { this.maPTP = maPTP; }

    public int getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(int maKhachHang) { this.maKhachHang = maKhachHang; }

    public Date getNgayLap() { return ngayLap; }
    public void setNgayLap(Date ngayLap) { this.ngayLap = ngayLap; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
}
