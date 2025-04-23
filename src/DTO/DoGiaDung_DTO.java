package doan.quanlykhachsan.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DoGiaDung_DTO extends DoDung_DTO {
    private String tinhTrang;
    private static final String LOAI_HANG = "DoGiaDung";
    private static int soLuongTon = 0;

    // Constructor mặc định
    public DoGiaDung_DTO() {
        super();
        this.tinhTrang = "";
        soLuongTon++;
    }

    // Constructor có tham số
    public DoGiaDung_DTO(String maHang, String tenHang, String donViTinh, double giaNhap, String ghiChu, String tinhTrang) {
        super(maHang, tenHang, donViTinh, giaNhap, ghiChu);
        this.tinhTrang = tinhTrang;
        soLuongTon++;
    }

    // Constructor sao chép
    public DoGiaDung_DTO(DoGiaDung_DTO other) {
        super(other.maHang, other.tenHang, other.donViTinh, other.giaNhap, other.ghiChu);
        this.tinhTrang = other.tinhTrang;
    }

    // Getter
    public String getTinhTrang() {
        return this.tinhTrang;
    }

    public static int getSoLuongTon() {
        return soLuongTon;
    }

    // Setter
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
