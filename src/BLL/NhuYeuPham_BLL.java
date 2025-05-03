package BLL;

import DAO.NhuYeuPhamDAO;
import DTO.NhuYeuPham_DTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class NhuYeuPham_BLL {
    private final NhuYeuPhamDAO nypDAO;
    
    public NhuYeuPham_BLL() {
        nypDAO = new NhuYeuPhamDAO();
    }
    
    public boolean themNhuYeuPham(NhuYeuPham_DTO nyp) throws SQLException {
        if (nypDAO.kiemTraTonTai(nyp.getMaHang())) {
            return false;
        }
        return nypDAO.themNhuYeuPham(nyp);
    }
    
    public boolean suaNhuYeuPham(NhuYeuPham_DTO nyp) throws SQLException {
        if (!nypDAO.kiemTraTonTai(nyp.getMaHang())) {
            return false;
        }
        return nypDAO.suaNhuYeuPham(nyp);
    }
    
    public boolean xoaNhuYeuPham(String maHang) throws SQLException {
        if (!nypDAO.kiemTraTonTai(maHang)) {
            return false;
        }
        return nypDAO.xoaNhuYeuPham(maHang);
    }
    
    public NhuYeuPham_DTO timNhuYeuPham(String maHang) throws SQLException {
        return nypDAO.timNhuYeuPham(maHang);
    }
    
    public ArrayList<NhuYeuPham_DTO> layDanhSachNhuYeuPham() throws SQLException {
        return nypDAO.layDanhSachNhuYeuPham();
    }
    
    public ArrayList<NhuYeuPham_DTO> timNhuYeuPhamTheoTen(String tenHang) throws SQLException {
        return nypDAO.timNhuYeuPhamTheoTen(tenHang);
    }
    
    public boolean capNhatSoLuongTon(String maHang, int soLuong) throws SQLException {
        return nypDAO.capNhatSoLuongTon(maHang, soLuong);
    }
    
    public ArrayList<NhuYeuPham_DTO> timNhuYeuPhamTheoNhaCungCap(String nhaCungCap) throws SQLException {
        ArrayList<NhuYeuPham_DTO> danhSach = layDanhSachNhuYeuPham();
        ArrayList<NhuYeuPham_DTO> ketQua = new ArrayList<>();
        
        for (NhuYeuPham_DTO nyp : danhSach) {
            if (nyp.getNhaCungCap().equalsIgnoreCase(nhaCungCap)) {
                ketQua.add(nyp);
            }
        }
        return ketQua;
    }
    
    public ArrayList<NhuYeuPham_DTO> timNhuYeuPhamSapHetHan(Date ngayHienTai) throws SQLException {
        ArrayList<NhuYeuPham_DTO> danhSach = layDanhSachNhuYeuPham();
        ArrayList<NhuYeuPham_DTO> ketQua = new ArrayList<>();
        
        for (NhuYeuPham_DTO nyp : danhSach) {
            if (nyp.getHanSuDung().before(ngayHienTai)) {
                ketQua.add(nyp);
            }
        }
        return ketQua;
    }
    
    public ArrayList<NhuYeuPham_DTO> sapXepTheoGiaTangDan() throws SQLException {
        ArrayList<NhuYeuPham_DTO> danhSach = layDanhSachNhuYeuPham();
        danhSach.sort((n1, n2) -> Double.compare(n1.getGiaNhap(), n2.getGiaNhap()));
        return danhSach;
    }
    
    public ArrayList<NhuYeuPham_DTO> sapXepTheoGiaGiamDan() throws SQLException {
        ArrayList<NhuYeuPham_DTO> danhSach = layDanhSachNhuYeuPham();
        danhSach.sort((n1, n2) -> Double.compare(n2.getGiaNhap(), n1.getGiaNhap()));
        return danhSach;
    }
    
    public ArrayList<NhuYeuPham_DTO> sapXepTheoHanSuDungTangDan() throws SQLException {
        ArrayList<NhuYeuPham_DTO> danhSach = layDanhSachNhuYeuPham();
        danhSach.sort((n1, n2) -> n1.getHanSuDung().compareTo(n2.getHanSuDung()));
        return danhSach;
    }
    
    public ArrayList<NhuYeuPham_DTO> sapXepTheoHanSuDungGiamDan() throws SQLException {
        ArrayList<NhuYeuPham_DTO> danhSach = layDanhSachNhuYeuPham();
        danhSach.sort((n1, n2) -> n2.getHanSuDung().compareTo(n1.getHanSuDung()));
        return danhSach;
    }
} 
