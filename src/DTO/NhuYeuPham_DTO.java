package DTO;

import java.util.Date;

public class NhuYeuPham_DTO {
    private String maHang;
    private String tenHang;
    private String donVi;
    private double giaNhap;
    private int soLuongTon;
    private Date ngayNhap;
    private Date hanSuDung;
    private String nhaCungCap;
    private String tinhTrang;

    public NhuYeuPham_DTO() {
    }

    public NhuYeuPham_DTO(String maHang, String tenHang, String donVi, double giaNhap, 
                         int soLuongTon, Date ngayNhap, Date hanSuDung, String nhaCungCap, 
                         String tinhTrang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donVi = donVi;
        this.giaNhap = giaNhap;
        this.soLuongTon = soLuongTon;
        this.ngayNhap = ngayNhap;
        this.hanSuDung = hanSuDung;
        this.nhaCungCap = nhaCungCap;
        this.tinhTrang = tinhTrang;
    }

    // Getters and Setters
    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
