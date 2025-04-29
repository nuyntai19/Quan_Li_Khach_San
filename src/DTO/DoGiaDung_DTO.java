package DTO;
public class DoGiaDung_DTO extends HangHoa_DTO {
    private String tinhTrang;
    private static final String LOAI_HANG = "DoGiaDung";
    
    // Constructor mặc định
    public DoGiaDung_DTO () {
        super();
        this.tinhTrang = "";
    }
    
    // Constructor có tham số
    public DoGiaDung_DTO (int mh, String th, String dvt, double gn, String tt) {
        super(mh, th, dvt, gn, LOAI_HANG);
        this.tinhTrang = tt;
    }
    
    // Constructor sao chép
    public DoGiaDung_DTO(DoGiaDung_DTO tmp) {
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
    
    @Override
    public String getLoaiHang() {
        return LOAI_HANG;
    }
}
