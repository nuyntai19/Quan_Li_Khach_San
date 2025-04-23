
package DTO;

public class QuanLiDichVuDTO {
    private int maDichVu;
    private String tenDichVu;
    private String moTa;
    private double donGia;
    private int soLuong;

    // Constructor không tham số
    public QuanLiDichVuDTO() {}

    // Constructor có tham số
    public QuanLiDichVuDTO(int maDichVu, String tenDichVu, String moTa, double donGia, int soLuong) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.moTa = moTa;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    // Getter và Setter cho các thuộc tính
    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
