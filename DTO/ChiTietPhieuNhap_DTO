package doan.quanlykhachsan.dto;
import java.time.LocalDate;

public class ChiTietPhieuNhap_DTO extends PhieuNhapHang_DTO{
    private String maHang;
    private double soLuong;
    private double donGia;
    private String ghiChu;
    
    public ChiTietPhieuNhap_DTO(){
        super();
        this.maHang = "";
        this.soLuong = 0;
        this.donGia = 0;
        this.ghiChu = "";
    }
    
    public ChiTietPhieuNhap_DTO(String maPhieuNhap, String maNhanVien, String maNhaCungCap, LocalDate ngayNhap, double tongTien, String maHang,
            double soLuong, double donGia,String ghiChu){
        super(maPhieuNhap, maNhanVien, maNhaCungCap, ngayNhap, tongTien);
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ghiChu = ghiChu;
    }
    
    //getter
    public String getMaHang(){
        return this.maHang;
    }
    
    public double getSoLuong(){
        return this.soLuong;
    }
    
    public double getDonGia(){
        return this.donGia;
    }
    
    public String getGhiChu(){
        return this.ghiChu;
    }
        
    //setter
    public void setMaHang(String tmp){
        this.maHang = tmp;
    }
    
    public void setSoLuong(double tmp){ 
        this.soLuong = tmp;
    }
    
    public void setDonGia(double tmp){
        this.donGia = tmp;
    }
    
    public void setGhiChu(String tmp){
        this.ghiChu = tmp;
    }
}


