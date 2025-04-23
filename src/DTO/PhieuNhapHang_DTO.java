package doan.quanlykhachsan.dto;

import java.time.LocalDate;
import java.util.Scanner;

public class PhieuNhapHang_DTO {
    private String maPhieuNhap;
    private String maNhanVien;
    private String maNhaCungCap;
    private LocalDate ngayNhap;
    private double tongTien;

    // Constructor mặc định
    public PhieuNhapHang_DTO() {
        this.maPhieuNhap = ""; // Sinh mã tự động
        this.maNhanVien = "";
        this.maNhaCungCap = "";
        this.ngayNhap = LocalDate.now();
        this.tongTien = 0;
    }

    // Constructor có tham số
    public PhieuNhapHang_DTO(String maPhieuNhap, String maNhanVien, String maNhaCungCap, LocalDate ngayNhap, double tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    // Getter & Setter
    public String getMaPhieuNhap() {
        return this.maPhieuNhap;
    }
    
    public String getMaNhanVien(){
        return this.maNhanVien;
    }

    public String getMaNhaCungCap() {
        return this.maNhaCungCap;
    }

    public LocalDate getNgayNhap() {
        return this.ngayNhap;
    }

    public double getTongTien() {
        return this.tongTien;
    }


    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public void setMaNhanVien(String maNhanVien){
        this.maNhanVien = maNhanVien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    // Phương thức nhập thông tin từ bàn phím
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã nhà cung cấp: ");
        this.maNhaCungCap = scanner.nextLine();

        System.out.print("Nhập tổng tiền nhập: ");
        this.tongTien = Double.parseDouble(scanner.nextLine());

        this.ngayNhap = LocalDate.now(); // Mặc định lấy ngày hiện tại
    }

    // Phương thức hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("Mã phiếu nhập: " + this.maPhieuNhap);
        System.out.println("Mã nhà cung cấp: " + this.maNhaCungCap);
        System.out.println("Ngày nhập: " + this.ngayNhap);
        System.out.println("Tổng tiền: " + this.tongTien);
    }
}

