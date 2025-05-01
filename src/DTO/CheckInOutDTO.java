package DTO;
import java.util.Date;

public class CheckInOutDTO {
    private int maThuePhong;     
    private int maPhong;         
    private int maKhachHang;     
    private Date ngayDatPhong;   
    private Date ngayTraPhong;   
    private String trangThai;  

    public CheckInOutDTO() {
    }

    public CheckInOutDTO(int maThuePhong, int maPhong, int maKhachHang, Date ngayDatPhong, Date ngayTraPhong, String trangThai) {
        this.maThuePhong = maThuePhong;
        this.maPhong = maPhong;
        this.maKhachHang = maKhachHang;
        this.ngayDatPhong = ngayDatPhong;
        this.ngayTraPhong = ngayTraPhong;
        this.trangThai = trangThai;
    }

    public int getMaThuePhong() {
        return maThuePhong;
    }

    public void setMaThuePhong(int maThuePhong) {
        this.maThuePhong = maThuePhong;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Date getNgayDatPhong() {
        return ngayDatPhong;
    }

    public void setNgayDatPhong(Date ngayDatPhong) {
        this.ngayDatPhong = ngayDatPhong;
    }

    public Date getNgayTraPhong() {
        return ngayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        this.ngayTraPhong = ngayTraPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
