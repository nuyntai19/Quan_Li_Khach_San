package DTO;

public class DichVuDTO {
    private int maDatDichVu;
    private String maDichVu;
    private int soLuong;
    private double donGia;

    public DichVuDTO() {}

    public DichVuDTO(int maDatDichVu, String maDichVu, int soLuong, double donGia) {
        this.maDatDichVu = maDatDichVu;
        this.maDichVu = maDichVu;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaDatDichVu() {
        return maDatDichVu;
    }

    public void setMaDatDichVu(int maDatDichVu) {
        this.maDatDichVu = maDatDichVu;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
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
        return this.soLuong * this.donGia;
    }
}