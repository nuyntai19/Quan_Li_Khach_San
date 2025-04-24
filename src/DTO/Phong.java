package DTO;

import java.math.BigDecimal;

public class Phong {
    private String maPhong;
    private String maLoaiPhong;
    private int soGiuong;
    private BigDecimal donGia;
    private String trangThai;

    public Phong() {
    }
    public Phong(String maPhong, String maLoaiPhong, int soGiuong, BigDecimal donGia, String trangThai) {
        this.maPhong = maPhong;
        this.maLoaiPhong = maLoaiPhong;
        this.soGiuong = soGiuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }
    
    public String getMaPhong() {
        return maPhong;
    }
    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }
    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }
    public int getSoGiuong() {
        return soGiuong;
    }
    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }
    public BigDecimal getDonGia() {
        return donGia;
    }
    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
