package DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KiemTraTinhTrang {
    private int maKiemTra;
    private int maPhong;
    private int maNhanVien;
    private int maThuePhong;
    private LocalDate ngayKiemTra;
    private String moTaThietHai;
    private BigDecimal chiPhiDenBu;


    public KiemTraTinhTrang() {
    }

    public KiemTraTinhTrang(int maKiemTra, int maPhong, int maNhanVien, int maThuePhong, LocalDate ngayKiemTra, String moTaThietHai, BigDecimal chiPhiDenBu) {
        this.maKiemTra = maKiemTra;
        this.maPhong = maPhong;
        this.maNhanVien = maNhanVien;
        this.maThuePhong = maThuePhong;
        this.ngayKiemTra = ngayKiemTra;
        this.moTaThietHai = moTaThietHai;
        this.chiPhiDenBu = chiPhiDenBu;
    }

    public int getMaKiemTra() {
        return maKiemTra;
    }

    public void setMaKiemTra(int maKiemTra) {
        this.maKiemTra = maKiemTra;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaThuePhong() {
        return maThuePhong;
    }

    public void setMaThuePhong(int maThuePhong) {
        this.maThuePhong = maThuePhong;
    }

    public String getNgayKiemTra() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ngayKiemTra.format(formatter);
    }

    public void setNgayKiemTra(LocalDate ngayKiemTra) {
        this.ngayKiemTra = ngayKiemTra;
    }

    public String getMoTaThietHai() {
        return moTaThietHai;
    }

    public void setMoTaThietHai(String moTaThietHai) {
        this.moTaThietHai = moTaThietHai;
    }

    public BigDecimal getChiPhiDenBu() {
        return chiPhiDenBu;
    }

    public void setChiPhiDenBu(BigDecimal chiPhiDenBu) {
        this.chiPhiDenBu = chiPhiDenBu;
    }
}
