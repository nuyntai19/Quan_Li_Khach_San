package DTO;

import java.util.Date;

public class NhanVienDTO {
    private int maNhanVien;
    private String ten;
    private String ho;
    private Date ngaySinh;
    private String gioiTinh;
    private String email;
    private String sdt;
    private String chucVu;
    private double luong;

    public NhanVienDTO() {}

    public NhanVienDTO(int maNhanVien, String ten, String ho, Date ngaySinh, String gioiTinh, String email, String sdt, String chucVu, double luong) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.sdt = sdt;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public int getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(int maNhanVien) { this.maNhanVien = maNhanVien; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public Date getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(Date ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String getChucVu() { return chucVu; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }

    public double getLuong() { return luong; }
    public void setLuong(double luong) { this.luong = luong; }
}
