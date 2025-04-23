package BLL;

import DAO.NhaCungCap_DAO;
import DTO.NhaCungCap_DTO;

import java.util.ArrayList;
import java.sql.SQLException;

public class NhaCungCap_BLL {
    private final NhaCungCap_DAO nhaCungCap_DAO;
    
    public NhaCungCap_BLL() {
        nhaCungCap_DAO = new NhaCungCap_DAO();
    }
    
    public ArrayList<NhaCungCap_DTO> layDanhSachNhaCungCap() throws SQLException {
        return nhaCungCap_DAO.layDanhSachNhaCungCap();
    }
    
    public ArrayList<Integer> layDanhSachMaNhaCungCap() throws SQLException {
        return nhaCungCap_DAO.layDanhSachMaNhaCungCap();
    }

    public boolean kiemTraMaNhaCungCapTonTai(int maNhaCungCap) throws SQLException {
        return nhaCungCap_DAO.kiemTraMaNhaCungCapTonTai(maNhaCungCap);
    }

    public boolean themNhaCungCap(NhaCungCap_DTO nhaCungCap) throws SQLException, IllegalArgumentException {
        // Kiểm tra tính hợp lệ của dữ liệu
        String ketQua = kiemTraHopLe(nhaCungCap);
        if (!ketQua.equals("")) {
            throw new IllegalArgumentException(ketQua);
        }
        
        if (kiemTraMaNhaCungCapTonTai(nhaCungCap.getMaNhaCungCap())) {
            throw new IllegalArgumentException("Mã nhà cung cấp " + nhaCungCap.getMaNhaCungCap() + " đã tồn tại trong hệ thống");
        }
        
        return nhaCungCapDAO.themNhaCungCap(nhaCungCap);
    }
    
    public boolean suaNhaCungCap(NhaCungCap_DTO nhaCungCap) throws SQLException {
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
    
    public String kiemTraHopLe(NhaCungCap_DTO nhaCungCap) {
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
