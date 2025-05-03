package BLL;

import DAO.DoGiaDungDAO;
import DTO.DoGiaDung_DTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

public class DoGiaDung_BLL {
    private final DoGiaDungDAO dgdDAO;
    
    public DoGiaDung_BLL() {
        dgdDAO = new DoGiaDungDAO();
    }
    
    public boolean themDoGiaDung(DoGiaDung_DTO dgd) throws SQLException {
        if (dgdDAO.kiemTraTonTai(dgd.getMaHang())) {
            return false;
        }
        return dgdDAO.themDoGiaDung(dgd);
    }
    
    public boolean suaDoGiaDung(DoGiaDung_DTO dgd) throws SQLException {
        if (!dgdDAO.kiemTraTonTai(dgd.getMaHang())) {
            return false;
        }
        return dgdDAO.suaDoGiaDung(dgd);
    }
    
    public boolean xoaDoGiaDung(String maHang) throws SQLException {
        if (!dgdDAO.kiemTraTonTai(maHang)) {
            return false;
        }
        return dgdDAO.xoaDoGiaDung(maHang);
    }
    
    public DoGiaDung_DTO timDoGiaDung(String maHang) throws SQLException {
        return dgdDAO.timDoGiaDung(maHang);
    }
    
    public ArrayList<DoGiaDung_DTO> layDanhSachDoGiaDung() throws SQLException {
        return dgdDAO.layDanhSachDoGiaDung();
    }
    
    public ArrayList<DoGiaDung_DTO> timDoGiaDungTheoTen(String tenHang) throws SQLException {
        return dgdDAO.timDoGiaDungTheoTen(tenHang);
    }
    
    public boolean capNhatSoLuongTon(String maHang, int soLuong) throws SQLException {
        return dgdDAO.capNhatSoLuongTon(maHang, soLuong);
    }
    
    public ArrayList<DoGiaDung_DTO> timDoGiaDungTheoNhaCungCap(String nhaCungCap) throws SQLException {
        ArrayList<DoGiaDung_DTO> danhSach = layDanhSachDoGiaDung();
        ArrayList<DoGiaDung_DTO> ketQua = new ArrayList<>();
        
        for (DoGiaDung_DTO dgd : danhSach) {
            if (dgd.getNhaCungCap().equalsIgnoreCase(nhaCungCap)) {
                ketQua.add(dgd);
            }
        }
        return ketQua;
    }
    
    public ArrayList<DoGiaDung_DTO> timDoGiaDungTheoTinhTrang(String tinhTrang) throws SQLException {
        ArrayList<DoGiaDung_DTO> danhSach = layDanhSachDoGiaDung();
        ArrayList<DoGiaDung_DTO> ketQua = new ArrayList<>();
        
        for (DoGiaDung_DTO dgd : danhSach) {
            if (dgd.getTinhTrang().equalsIgnoreCase(tinhTrang)) {
                ketQua.add(dgd);
            }
        }
        return ketQua;
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepTheoGiaTangDan() throws SQLException {
        ArrayList<DoGiaDung_DTO> danhSach = layDanhSachDoGiaDung();
        danhSach.sort(Comparator.comparingDouble(DoGiaDung_DTO::getGiaNhap));
        return danhSach;
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepTheoGiaGiamDan() throws SQLException {
        ArrayList<DoGiaDung_DTO> danhSach = layDanhSachDoGiaDung();
        danhSach.sort(Comparator.comparingDouble(DoGiaDung_DTO::getGiaNhap).reversed());
        return danhSach;
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepTheoSoLuongTangDan() throws SQLException {
        ArrayList<DoGiaDung_DTO> danhSach = layDanhSachDoGiaDung();
        danhSach.sort(Comparator.comparingInt(DoGiaDung_DTO::getSoLuongTon));
        return danhSach;
    }
    
    public ArrayList<DoGiaDung_DTO> sapXepTheoSoLuongGiamDan() throws SQLException {
        ArrayList<DoGiaDung_DTO> danhSach = layDanhSachDoGiaDung();
        danhSach.sort(Comparator.comparingInt(DoGiaDung_DTO::getSoLuongTon).reversed());
        return danhSach;
    }
} 
