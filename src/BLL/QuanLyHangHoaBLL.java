package BLL;

import DTO.NhuYeuPham_DTO;
import DTO.DoGiaDung_DTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class QuanLyHangHoaBLL {
    private final NhuYeuPham_BLL nypBLL;
    private final DoGiaDung_BLL dgdBLL;
    
    public QuanLyHangHoaBLL() {
        nypBLL = new NhuYeuPham_BLL();
        dgdBLL = new DoGiaDung_BLL();
    }
    
    // Nhu Yeu Pham
    public boolean themNhuYeuPham(NhuYeuPham_DTO nyp) throws SQLException {
        return nypBLL.themNhuYeuPham(nyp);
    }
    
    public boolean suaNhuYeuPham(NhuYeuPham_DTO nyp) throws SQLException {
        return nypBLL.suaNhuYeuPham(nyp);
    }
    
    public boolean xoaNhuYeuPham(String maHang) throws SQLException {
        return nypBLL.xoaNhuYeuPham(maHang);
    }
    
    public NhuYeuPham_DTO timNhuYeuPham(String maHang) throws SQLException {
        return nypBLL.timNhuYeuPham(maHang);
    }
    
    public ArrayList<NhuYeuPham_DTO> layDanhSachNhuYeuPham() throws SQLException {
        return nypBLL.layDanhSachNhuYeuPham();
    }
    
    public ArrayList<NhuYeuPham_DTO> timNhuYeuPhamTheoTen(String tenHang) throws SQLException {
        return nypBLL.timNhuYeuPhamTheoTen(tenHang);
    }
    
    public ArrayList<NhuYeuPham_DTO> timNhuYeuPhamTheoNhaCungCap(String nhaCungCap) throws SQLException {
        return nypBLL.timNhuYeuPhamTheoNhaCungCap(nhaCungCap);
    }
    
    public ArrayList<NhuYeuPham_DTO> timNhuYeuPhamSapHetHan(Date ngayHienTai) throws SQLException {
        return nypBLL.timNhuYeuPhamSapHetHan(ngayHienTai);
    }
    
    // Do Gia Dung
    public boolean themDoGiaDung(DoGiaDung_DTO dgd) throws SQLException {
        return dgdBLL.themDoGiaDung(dgd);
    }
    
    public boolean suaDoGiaDung(DoGiaDung_DTO dgd) throws SQLException {
        return dgdBLL.suaDoGiaDung(dgd);
    }
    
    public boolean xoaDoGiaDung(String maHang) throws SQLException {
        return dgdBLL.xoaDoGiaDung(maHang);
    }
    
    public DoGiaDung_DTO timDoGiaDung(String maHang) throws SQLException {
        return dgdBLL.timDoGiaDung(maHang);
    }
    
    public ArrayList<DoGiaDung_DTO> layDanhSachDoGiaDung() throws SQLException {
        return dgdBLL.layDanhSachDoGiaDung();
    }
    
    public ArrayList<DoGiaDung_DTO> timDoGiaDungTheoTen(String tenHang) throws SQLException {
        return dgdBLL.timDoGiaDungTheoTen(tenHang);
    }
    
    public ArrayList<DoGiaDung_DTO> timDoGiaDungTheoNhaCungCap(String nhaCungCap) throws SQLException {
        return dgdBLL.timDoGiaDungTheoNhaCungCap(nhaCungCap);
    }
    
    public ArrayList<DoGiaDung_DTO> timDoGiaDungTheoTinhTrang(String tinhTrang) throws SQLException {
        return dgdBLL.timDoGiaDungTheoTinhTrang(tinhTrang);
    }
    
    // Cap Nhat So Luong
    public boolean capNhatSoLuongNhuYeuPham(String maHang, int soLuong) throws SQLException {
        return nypBLL.capNhatSoLuongTon(maHang, soLuong);
    }
    
    public boolean capNhatSoLuongDoGiaDung(String maHang, int soLuong) throws SQLException {
        return dgdBLL.capNhatSoLuongTon(maHang, soLuong);
    }
    
    // Sap Xep
    public ArrayList<NhuYeuPham_DTO> sapXepNhuYeuPhamTheoGiaTangDan() throws SQLException {
        return nypBLL.sapXepTheoGiaTangDan();
    }
    
    public ArrayList<NhuYeuPham_DTO> sapXepNhuYeuPhamTheoGiaGiamDan() throws SQLException {
        return nypBLL.sapXepTheoGiaGiamDan();
    }
    
    public ArrayList<NhuYeuPham_DTO> sapXepNhuYeuPhamTheoHanSuDungTangDan() throws SQLException {
        return nypBLL.sapXepTheoHanSuDungTangDan();
    }
    
    public ArrayList<NhuYeuPham_DTO> sapXepNhuYeuPhamTheoHanSuDungGiamDan() throws SQLException {
        return nypBLL.sapXepTheoHanSuDungGiamDan();
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepDoGiaDungTheoGiaTangDan() throws SQLException {
        return dgdBLL.sapXepTheoGiaTangDan();
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepDoGiaDungTheoGiaGiamDan() throws SQLException {
        return dgdBLL.sapXepTheoGiaGiamDan();
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepDoGiaDungTheoSoLuongTangDan() throws SQLException {
        return dgdBLL.sapXepTheoSoLuongTangDan();
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepDoGiaDungTheoSoLuongGiamDan() throws SQLException {
        return dgdBLL.sapXepTheoSoLuongGiamDan();
    }
} 
