package DTO;

public class ChiTietPhieuNhap_DTO {
    private String maPhieuNhap;
    private String maHang;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    
    public ChiTietPhieuNhap_DTO() {
    }
    
    public ChiTietPhieuNhap_DTO(String maPhieuNhap, String maHang, int soLuong, double donGia, double thanhTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
    
    // Getters
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }
    
    public String getMaHang() {
        return maHang;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public double getDonGia() {
        return donGia;
    }
    
    public double getThanhTien() {
        return thanhTien;
    }
    
    // Setters
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
    
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    // Phương thức tính thành tiền
    public void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }
}


