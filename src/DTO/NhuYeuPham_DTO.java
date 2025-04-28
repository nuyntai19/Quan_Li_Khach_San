package DTO;

import java.sql.Date;

public class NhuYeuPham_DTO extends HangHoa_DTO {
    private Date hanSuDung; 
    private String nhaCungCap;
    private static final String LOAI_HANG = "NhuYeuPham"; 

    public NhuYeuPham_DTO() {
        super();
        this.hanSuDung = null;
        this.nhaCungCap = "";
    }

    // Constructor có tham số
    public NhuYeuPham_DTO(int maHang, String tenHang, String donViTinh, double giaNhap, Date hanSuDung, String nhaCungCap) {
        super(maHang, tenHang, donViTinh, giaNhap, LOAI_HANG);
        this.hanSuDung = hanSuDung;
        this.nhaCungCap = nhaCungCap;
    }

    // Constructor sao chép
    public NhuYeuPham_DTO(NhuYeuPham_DTO tmp) {
        super(tmp);
        this.hanSuDung = tmp.hanSuDung;
        this.nhaCungCap = tmp.nhaCungCap;
    }

    // Setter
    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    // Getter
    public Date getHanSuDung() {
        return this.hanSuDung;
    }

    public String getNhaCungCap() {
        return this.nhaCungCap;
    }

    @Override
    public String getLoaiHang() {
        return LOAI_HANG;
    }
}
