package BLL;

import DAO.NhaCungCap_DAO;
import DTO.NhaCungCap_DTO;

import java.util.ArrayList;
import java.sql.SQLException;

public class NhaCungCapBLL {
    private final NhaCungCapDAO nhaCungCapDAO;
    
    public NhaCungCapBLL() {
        nhaCungCapDAO = new NhaCungCapDAO();
    }
    
    public ArrayList<NhaCungCapDTO> layDanhSachNhaCungCap() throws SQLException {
        return nhaCungCapDAO.layDanhSachNhaCungCap();
    }
    
    public ArrayList<Integer> layDanhSachMaNhaCungCap() throws SQLException {
        return nhaCungCapDAO.layDanhSachMaNhaCungCap();
    }
    
    public boolean themNhaCungCap(NhaCungCapDTO nhaCungCap) throws SQLException {
        String ketQua = kiemTraHopLe(nhaCungCap);
        if (!ketQua.equals("")) {
            throw new IllegalArgumentException(ketQua);
        }
        return nhaCungCapDAO.themNhaCungCap(nhaCungCap);
    }
    
    public boolean suaNhaCungCap(NhaCungCapDTO nhaCungCap) throws SQLException {
        String ketQua = kiemTraHopLe(nhaCungCap);
        if (!ketQua.equals("")) {
            throw new IllegalArgumentException(ketQua);
        }
        return nhaCungCapDAO.suaNhaCungCap(nhaCungCap);
    }
    
    public boolean xoaNhaCungCap(int maNhaCungCap) throws SQLException {
    
        return nhaCungCapDAO.xoaNhaCungCap(maNhaCungCap);
    }
    
    public NhaCungCapDTO timNhaCungCapTheoMa(int maNhaCungCap) throws SQLException {
        return nhaCungCapDAO.timNhaCungCapTheoMa(maNhaCungCap);
    }
    
    public String kiemTraHopLe(NhaCungCapDTO nhaCungCap) {
        if (nhaCungCap.getMaNhaCungCap() <= 0) {
            return "Mã nhà cung cấp phải lớn hơn 0";
        }
        
        if (nhaCungCap.getTenNhaCungCap().trim().equals("")) {
            return "Tên nhà cung cấp không được để trống";
        }
        
        if (nhaCungCap.getSoDienThoai().trim().equals("")) {
            return "Số điện thoại không được để trống";
        } else if (!nhaCungCap.getSoDienThoai().matches("\\d{10,15}")) {
            return "Số điện thoại phải có từ 10 đến 15 chữ số";
        }
        
        if (nhaCungCap.getDiaChi().trim().equals("")) {
            return "Địa chỉ không được để trống";
        }
        
        return "";
    }
}
