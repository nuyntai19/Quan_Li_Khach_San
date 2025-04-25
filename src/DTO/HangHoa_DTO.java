package DTO;

public class HangHoa_DTO {
    protected int maHang; 
    protected String tenHang; 
    protected String donViTinh;
    protected double giaNhap;
    protected String loaiHang; // Loại hàng

    // Constructor mặc định
    public HangHoa_DTO() {
        maHang = 0;
        tenHang = "";
        donViTinh = "";
        giaNhap = 0.0;
        loaiHang = "";
    }

    // Constructor đầy đủ thông tin
    public HangHoa_DTO(int maHang, String tenHang, String donViTinh, double giaNhap, String loaiHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.loaiHang = loaiHang;
    }

    // Constructor sao chép
    public HangHoa_DTO(HangHoa_DTO tmp) {
        this.maHang = tmp.maHang;
        this.tenHang = tmp.tenHang;
        this.donViTinh = tmp.donViTinh;
        this.giaNhap = tmp.giaNhap;
        this.loaiHang = tmp.loaiHang;
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
}
