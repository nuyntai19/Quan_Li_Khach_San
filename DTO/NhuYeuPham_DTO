package doan.quanlykhachsan.dto;

import java.util.ArrayList;
import java.util.Scanner;

public class NhuYeuPham_DTO extends DoDung_DTO {
    private String hanSuDung;
    private String nhaCungCap;
    private static final String LOAI_HANG = "NhuYeuPham";
    private static int soLuongTon = 0;

    // Constructor máº·c Ä‘á»‹nh
    public NhuYeuPham_DTO() {
        super();
        this.hanSuDung = "";
        this.nhaCungCap = "";
        soLuongTon++;
    }

    // Constructor cÃ³ tham sá»‘
    public NhuYeuPham_DTO(String maHang, String tenHang, String donViTinh, double giaNhap, String ghiChu,
                      String hanSuDung, String nhaCungCap) {
        super(maHang, tenHang, donViTinh, giaNhap, ghiChu);
        this.hanSuDung = hanSuDung;
        this.nhaCungCap = nhaCungCap;
        soLuongTon++;
    }

    // Constructor sao chÃ©p
    public NhuYeuPham_DTO(NhuYeuPham_DTO other) {
        super(other.maHang, other.tenHang, other.donViTinh, other.giaNhap, other.ghiChu);
        this.hanSuDung = other.hanSuDung;
        this.nhaCungCap = other.nhaCungCap;
        soLuongTon++;
    }

    // Getter
    public String getHanSuDung() {
        return hanSuDung;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public static int getSoLuongTon() {
        return soLuongTon;
    }

    // Setter
    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    // PhÆ°Æ¡ng thá»©c nháº­p dá»¯ liá»‡u
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nháº­p mÃ£ hÃ ng: ");
        this.setMaHang(scanner.nextLine());
        System.out.print("Nháº­p tÃªn hÃ ng: ");
        this.setTenHang(scanner.nextLine());
        System.out.print("Nháº­p Ä‘Æ¡n vá»‹ tÃ­nh: ");
        this.setDonViTinh(scanner.nextLine());
        System.out.print("Nháº­p giÃ¡ nháº­p: ");
        this.setGiaNhap(Double.parseDouble(scanner.nextLine()));
        System.out.print("Nháº­p ghi chÃº: ");
        this.setGhiChu(scanner.nextLine());
        System.out.print("Nháº­p háº¡n sá»­ dá»¥ng: ");
        this.setHanSuDung(scanner.nextLine());
        System.out.print("Nháº­p nhÃ  cung cáº¥p: ");
        this.setNhaCungCap(scanner.nextLine());
    }

    // PhÆ°Æ¡ng thá»©c xuáº¥t dá»¯ liá»‡u
    public void xuat() {
        System.out.println("MÃ£ hÃ ng: " + this.getMaHang());
        System.out.println("TÃªn hÃ ng: " + this.getTenHang());
        System.out.println("Loáº¡i hÃ ng: " + LOAI_HANG);
        System.out.println("ÄÆ¡n vá»‹ tÃ­nh: " + this.getDonViTinh());
        System.out.println("GiÃ¡ nháº­p: " + this.getGiaNhap());
        System.out.println("Ghi chÃº: " + this.getGhiChu());
        System.out.println("Háº¡n sá»­ dá»¥ng: " + this.getHanSuDung());
        System.out.println("NhÃ  cung cáº¥p: " + this.getNhaCungCap());
    }

    // PhÆ°Æ¡ng thá»©c sá»­a thÃ´ng tin
    public void sua() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nháº­p tÃªn hÃ ng má»›i: ");
        this.setTenHang(scanner.nextLine());
        System.out.print("Nháº­p Ä‘Æ¡n vá»‹ tÃ­nh má»›i: ");
        this.setDonViTinh(scanner.nextLine());
        System.out.print("Nháº­p giÃ¡ nháº­p má»›i: ");
        this.setGiaNhap(Double.parseDouble(scanner.nextLine()));
        System.out.print("Nháº­p ghi chÃº má»›i: ");
        this.setGhiChu(scanner.nextLine());
        System.out.print("Nháº­p háº¡n sá»­ dá»¥ng má»›i: ");
        this.setHanSuDung(scanner.nextLine());
        System.out.print("Nháº­p nhÃ  cung cáº¥p má»›i: ");
        this.setNhaCungCap(scanner.nextLine());
    }

    // PhÆ°Æ¡ng thá»©c tÃ¬m kiáº¿m sáº£n pháº©m theo tá»« khÃ³a
    public static ArrayList<NhuYeuPham_DTO> timKiem(ArrayList<NhuYeuPham_DTO> danhSach, String tuKhoa) {
        ArrayList<NhuYeuPham_DTO> ketQua = new ArrayList<>();
        for (NhuYeuPham_DTO item : danhSach) {
            if (item.getMaHang().toLowerCase().contains(tuKhoa.toLowerCase()) ||
                item.getTenHang().toLowerCase().contains(tuKhoa.toLowerCase()) ||
                item.getNhaCungCap().toLowerCase().contains(tuKhoa.toLowerCase())) {
                ketQua.add(item);
            }
        }
        return ketQua;
    }

    // PhÆ°Æ¡ng thá»©c xÃ³a sáº£n pháº©m khá»i danh sÃ¡ch
    public static void xoa(ArrayList<NhuYeuPham_DTO> danhSach, String maHang) {
        danhSach.removeIf(item -> item.getMaHang().equals(maHang));
        System.out.println("ÄÃ£ xÃ³a sáº£n pháº©m cÃ³ mÃ£: " + maHang);
    }
}
