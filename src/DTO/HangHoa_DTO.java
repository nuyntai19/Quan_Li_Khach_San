package DTO;


public class HangHoa{
    protected String maHang;
    protected String tenHang;
    protected String donViTinh;
    protected int giaNhap;
    
    public HangHoa(){
        maHang = "";
        tenHang = "";
        donViTinh = "";
        giaNhap = 0;
    }
    
    public HangHoa(String mh, String th, String dvt, int gn){
        maHang = mh;
        tenHang = th;
        donViTinh = dvt;
        giaNhap = gn;
    }
    
    public HangHoa(HangHoa tmp){
        this.maHang = tmp.maHang;
        this.tenHang = tmp.tenHang;
        this.donViTinh = tmp.donViTinh;
        this.giaNhap = tmp.giaNhap;
    }
    
    //setter
    public void setMaHang(String tmp){
        this.maHang = tmp;
    }
    
    public void setTenHang(String tmp){
        this.tenHang = tmp;
    }
    
    public void setDonViTinh(String tmp){
        this.donViTinh = tmp;
    }
    
    public void setGiaNhap(int tmp){
        this.giaNhap = tmp;
    }
     
    //getter
    public String getMaHang(){
        return this.maHang;
    }
    
    public String getTenHang(){
        return this.tenHang;
    }
    
    public String getDonViTinh(){
        return this.donViTinh;
    }
    
    public int getGiaNhap(){
        return this.giaNhap;
    }

}
