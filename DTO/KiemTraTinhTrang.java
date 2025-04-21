package DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KiemTraTinhTrang {
    private int maKiemTra;
    private int maNhanVien;
    private int maThuePhong;
    private LocalDateTime ngayKiemTra;
    private String moTaThietHai;
    private BigDecimal chiPhiDenBu;


    public KiemTraTinhTrang() {
    }

    public KiemTraTinhTrang(int maKiemTra, int maNhanVien, int maThuePhong, LocalDateTime ngayKiemTra, String moTaThietHai, BigDecimal chiPhiDenBu) {
        this.maKiemTra = maKiemTra;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ngayKiemTra.format(formatter);
    }

    public void setNgayKiemTra(LocalDateTime ngayKiemTra) {
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
