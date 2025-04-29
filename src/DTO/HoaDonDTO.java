package DTO;

import java.util.Date;

public class HoaDonDTO {
    private String maHD;
    private int maPTP;
    private Date ngayLap;
    private double tongTien;

    public HoaDonDTO() {}

    public HoaDonDTO(String maHD, int maPTP, Date ngayLap, double tongTien) {
        this.maHD = maHD;
        this.maPTP = maPTP;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public int getMaPTP() { return maPTP; }
    public void setMaPTP(int maPTP) { this.maPTP = maPTP; }

    public Date getNgayLap() { return ngayLap; }
    public void setNgayLap(Date ngayLap) { this.ngayLap = ngayLap; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
}
