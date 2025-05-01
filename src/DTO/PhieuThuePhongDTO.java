
package DTO;

import java.util.Date;

public class PhieuThuePhongDTO {
    private int maThuePhong;
    private int maKhachHang;
    private int maNhanVien;
    private Date ngayLapPhieu;
    private double tongTien;
    private String trangThai;

    public PhieuThuePhongDTO(int maThuePhong, int maKhachHang, int maNhanVien, Date ngayLapPhieu, double tongTien, String trangThai) {
        this.maThuePhong = maThuePhong;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.ngayLapPhieu = ngayLapPhieu;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public PhieuThuePhongDTO() {
    }

    public int getMaThuePhong() {
        return maThuePhong;
    }

    public void setMaThuePhong(int maThuePhong) {
        this.maThuePhong = maThuePhong;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(Date ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

