package DTO;


public class NhaCungCap_DTO {
    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String diaChi;
    private String soDienThoai;


    // Constructor mặc định
    public NhaCungCap_DTO() {
        this.maNhaCungCap = "";
        this.tenNhaCungCap = "";
        this.diaChi = "";
        this.soDienThoai = "";
    }

    public NhaCungCap_DTO(String maNhaCungCap, String tenNhaCungCap, String diaChi, String soDienThoai) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
    
    public NhaCungCap_DTO(NhaCungCap_DTO tmp){
        this.maNhaCungCap = tmp.maNhaCungCap;
        this.tenNhaCungCap = tmp.tenNhaCungCap;
        this.soDienThoai = tmp.soDienThoai;
        this.diaChi = tmp.diaChi;
    }

    public String getMaNhaCungCap() {
        return this.maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return this.tenNhaCungCap;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public String getSoDienThoai() {
        return this.soDienThoai;
    }


    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
