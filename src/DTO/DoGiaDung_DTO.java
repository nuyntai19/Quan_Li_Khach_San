package doan.quanlykhachsan.dto;

public class DoGiaDung_DTO extends HangHoa {
    private String tinhTrang;
    private static final String LOAI_HANG = "DoGiaDung";
    
    // Constructor mặc định
    public DoGiaDung_DTO () {
        super();
        this.tinhTrang = "";
    }
    
    // Constructor có tham số
    public DoGiaDung_DTO (String mh, String th, String dvt, int gn, String tt) {
        super(mh, th, dvt, gn);
        this.tinhTrang = tt;
    }
    
    // Constructor sao chép
    public DoGiaDung_DTO(DoGiaDung tmp) {
        super(tmp);
        this.tinhTrang = tmp.tinhTrang;
    }
    
    // Setter
    public void setTinhTrang(String tmp) {
        this.tinhTrang = tmp;
    }
    
    // Getter
    public String getTinhTrang() {
        return this.tinhTrang;
    }
    
    public static String getLoaiHang() {
        return LOAI_HANG;
    }
}
