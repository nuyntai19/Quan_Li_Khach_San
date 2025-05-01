
package DTO;

public class ThongTinNhanVienDTO {
    private int maTaiKhoan;
    private String tenDangNhap;
    private int maNhanVien;
    private String vaiTro;
    private java.sql.Timestamp thoiGianDangNhap;

    // Constructor
    public ThongTinNhanVienDTO() {}

    // Getters & Setters
    public int getMaTaiKhoan() { return maTaiKhoan; }
    public void setMaTaiKhoan(int maTaiKhoan) { this.maTaiKhoan = maTaiKhoan; }

    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }

    public int getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(int maNhanVien) { this.maNhanVien = maNhanVien; }

    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }

    public java.sql.Timestamp getThoiGianDangNhap() { return thoiGianDangNhap; }
    public void setThoiGianDangNhap(java.sql.Timestamp thoiGianDangNhap) { this.thoiGianDangNhap = thoiGianDangNhap; }
}