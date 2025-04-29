package DTO;

public class ChiTietHoaDonDTO {
    private int maCTHD;
    private String maHD;
    private int maPhong;
    private Integer maDV;
    private String loaiChiTiet; // Quan trọng
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietHoaDonDTO() {}

    public ChiTietHoaDonDTO(int maCTHD, String maHD, int maPhong, Integer maDV, String loaiChiTiet, int soLuong, double donGia, double thanhTien) {
        this.maCTHD = maCTHD;
        this.maHD = maHD;
        this.maPhong = maPhong;
        this.maDV = maDV;
        this.loaiChiTiet = loaiChiTiet;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public int getMaCTHD() {
        return maCTHD;
    }

    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public Integer getMaDV() {
        return maDV;
    }

    public void setMaDV(Integer maDV) {
        this.maDV = maDV;
    }

    public String getLoaiChiTiet() {
        return loaiChiTiet;
    }

    public void setLoaiChiTiet(String loaiChiTiet) {
        this.loaiChiTiet = loaiChiTiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
