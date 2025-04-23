package DTO;

public class NhuYeuPham_DTO extends HangHoa {
    private String hanSuDung;
    private String nhaCungCap;
    private static final String LOAI_HANG = "NhuYeuPham";
    
    // Constructor mặc định
    public NhuYeuPham_DTO() {
        super();
        this.hanSuDung = "";
        this.nhaCungCap = "";
    }
    
    // Constructor có tham số
    public NhuYeuPham_DTO(String mh, String th, String dvt, int gn, String hsd, String ncc) {
        super(mh, th, dvt, gn);
        this.hanSuDung = hsd;
        this.nhaCungCap = ncc;
    }
    
    // Constructor sao chép
    public NhuYeuPham_DTO(NhuYeuPham_DTO tmp) {
        super(tmp);
        this.hanSuDung = tmp.hanSuDung;
        this.nhaCungCap = tmp.nhaCungCap;
    }
    
    // Setter
    public void setHanSuDung(String tmp) {
        this.hanSuDung = tmp;
    }
    
    public void setNhaCungCap(String tmp) {
        this.nhaCungCap = tmp;
    }
    
    // Getter
    public String getHanSuDung() {
        return this.hanSuDung;
    }
    
    public String getNhaCungCap() {
        return this.nhaCungCap;
    }
    
    public static String getLoaiHang() {
        return LOAI_HANG;
    }
}
