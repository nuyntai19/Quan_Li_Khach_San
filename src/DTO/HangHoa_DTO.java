package DTO;

import java.sql.Date;

public class HangHoa_DTO {
    private int maHang;
    private String tenHang;
    private String donViTinh;
    private double giaNhap;
    private String loaiHang;
    private Date hanSuDung;
    private String nhaCungCap;

    // Constructor mặc định
    public HangHoa_DTO() {
        maHang = 0;
        tenHang = "";
        donViTinh = "";
        giaNhap = 0.0;
        loaiHang = "";
        hanSuDung = null;
        nhaCungCap = "";
    }

    // Constructor đầy đủ thông tin
    public HangHoa_DTO(int maHang, String tenHang, String donViTinh, double giaNhap, String loaiHang, Date hanSuDung, String nhaCungCap) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.loaiHang = loaiHang;
        this.hanSuDung = hanSuDung;
        this.nhaCungCap = nhaCungCap;
    }

    // Constructor sao chép
    public HangHoa_DTO(HangHoa_DTO tmp) {
        this.maHang = tmp.maHang;
        this.tenHang = tmp.tenHang;
        this.donViTinh = tmp.donViTinh;
        this.giaNhap = tmp.giaNhap;
        this.loaiHang = tmp.loaiHang;
        this.hanSuDung = tmp.hanSuDung;
        this.nhaCungCap = tmp.nhaCungCap;
    }

    // Constructor với 5 tham số (dùng cho các lớp con)
    public HangHoa_DTO(int maHang, String tenHang, String donViTinh, double giaNhap, String loaiHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.loaiHang = loaiHang;
        this.hanSuDung = null;
        this.nhaCungCap = "";
    }

    // Setter
    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    // Getter
    public int getMaHang() {
        return this.maHang;
    }

    public String getTenHang() {
        return this.tenHang;
    }

    public String getDonViTinh() {
        return this.donViTinh;
    }

    public double getGiaNhap() {
        return this.giaNhap;
    }

    public String getLoaiHang() {
        return this.loaiHang;
    }

    public Date getHanSuDung() {
        return this.hanSuDung;
    }

    public String getNhaCungCap() {
        return this.nhaCungCap;
    }
}
