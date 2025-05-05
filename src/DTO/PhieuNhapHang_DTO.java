package DTO;

import java.util.Date;

public class PhieuNhapHang_DTO {
    private String maPhieuNhap;
    private Date ngayNhap;
    private double tongTien;
    private String maNhanVien;
    
    public PhieuNhapHang_DTO() {
    }
    
    public PhieuNhapHang_DTO(String maPhieuNhap, Date ngayNhap, double tongTien, String maNhanVien) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.maNhanVien = maNhanVien;
    }
    
    // Getters
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }
    
    public Date getNgayNhap() {
        return ngayNhap;
    }
    
    public double getTongTien() {
        return tongTien;
    }
    
    public String getMaNhanVien() {
        return maNhanVien;
    }
    
    // Setters
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }
    
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}

