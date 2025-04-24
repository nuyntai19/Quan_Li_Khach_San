package BLL;

import DAO.NhaCungCap_DAO;
import DTO.NhaCungCap_DTO;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class NhaCungCap_BLL {
    private NhaCungCap_DAO nhaCungCapDAO;
    
    // Constructor
    public NhaCungCap_BLL() {
        nhaCungCapDAO = new NhaCungCap_DAO();
    }
    
    // Phương thức lấy danh sách tất cả nhà cung cấp
    public ArrayList<NhaCungCap_DTO> layDanhSachNhaCungCap() {
        return nhaCungCapDAO.layDanhSachNhaCungCap();
    }
    
    // Phương thức thêm nhà cung cấp mới với kiểm tra dữ liệu
    public String themNhaCungCap(NhaCungCap_DTO ncc) {
        // Kiểm tra dữ liệu đầu vào
        String ketQuaKiemTra = kiemTraDuLieuNhaCungCap(ncc);
        if (!ketQuaKiemTra.equals("true")) {
            return ketQuaKiemTra;
        }
        
        // Kiểm tra mã nhà cung cấp đã tồn tại chưa
        if (nhaCungCapDAO.kiemTraMaNhaCungCapTonTai(ncc.getMaNhaCungCap())) {
            return "Mã nhà cung cấp đã tồn tại!";
        }
        
        // Thực hiện thêm nhà cung cấp
        boolean ketQua = nhaCungCapDAO.themNhaCungCap(ncc);
        return ketQua ? "true" : "Thêm nhà cung cấp thất bại!";
    }
    
    // Phương thức cập nhật thông tin nhà cung cấp với kiểm tra dữ liệu
    public String capNhatNhaCungCap(NhaCungCap_DTO ncc) {
        // Kiểm tra dữ liệu đầu vào
        String ketQuaKiemTra = kiemTraDuLieuNhaCungCap(ncc);
        if (!ketQuaKiemTra.equals("true")) {
            return ketQuaKiemTra;
        }
        
        // Kiểm tra nhà cung cấp có tồn tại không
        if (!nhaCungCapDAO.kiemTraMaNhaCungCapTonTai(ncc.getMaNhaCungCap())) {
            return "Nhà cung cấp không tồn tại!";
        }
        
        // Thực hiện cập nhật nhà cung cấp
        boolean ketQua = nhaCungCapDAO.capNhatNhaCungCap(ncc);
        return ketQua ? "true" : "Cập nhật nhà cung cấp thất bại!";
    }
    
    // Phương thức xóa nhà cung cấp
    public String xoaNhaCungCap(String maNhaCungCap) {
        // Kiểm tra nhà cung cấp có tồn tại không
        if (!nhaCungCapDAO.kiemTraMaNhaCungCapTonTai(maNhaCungCap)) {
            return "Nhà cung cấp không tồn tại!";
        }
        
        // Thực hiện xóa nhà cung cấp
        boolean ketQua = nhaCungCapDAO.xoaNhaCungCap(maNhaCungCap);
        return ketQua ? "true" : "Không thể xóa nhà cung cấp này vì đã có phiếu nhập hàng liên quan!";
    }
    
    // Phương thức tìm kiếm nhà cung cấp theo mã
    public NhaCungCap_DTO timNhaCungCapTheoMa(String maNhaCungCap) {
        return nhaCungCapDAO.timNhaCungCapTheoMa(maNhaCungCap);
    }
    
    // Phương thức tìm kiếm nhà cung cấp theo tên
    public ArrayList<NhaCungCap_DTO> timNhaCungCapTheoTen(String tenNhaCungCap) {
        return nhaCungCapDAO.timNhaCungCapTheoTen(tenNhaCungCap);
    }
    
    // Phương thức lấy mã nhà cung cấp mới nhất
    public String layMaNhaCungCapMoiNhat() {
        return nhaCungCapDAO.layMaNhaCungCapMoiNhat();
    }
    
    // Phương thức kiểm tra dữ liệu nhà cung cấp
    private String kiemTraDuLieuNhaCungCap(NhaCungCap_DTO ncc) {
        // Kiểm tra mã nhà cung cấp
        if (ncc.getMaNhaCungCap().trim().isEmpty()) {
            return "Mã nhà cung cấp không được để trống!";
        }
        
        try {
            int maNCC = Integer.parseInt(ncc.getMaNhaCungCap());
            if (maNCC <= 0) {
                return "Mã nhà cung cấp phải là số nguyên dương!";
            }
        } catch (NumberFormatException e) {
            return "Mã nhà cung cấp phải là số nguyên!";
        }
        
        // Kiểm tra tên nhà cung cấp
        if (ncc.getTenNhaCungCap().trim().isEmpty()) {
            return "Tên nhà cung cấp không được để trống!";
        }
        
        if (ncc.getTenNhaCungCap().length() > 100) {
            return "Tên nhà cung cấp quá dài (tối đa 100 ký tự)!";
        }
        
        // Kiểm tra địa chỉ
        if (ncc.getDiaChi().trim().isEmpty()) {
            return "Địa chỉ không được để trống!";
        }
        
        if (ncc.getDiaChi().length() > 255) {
            return "Địa chỉ quá dài (tối đa 255 ký tự)!";
        }
        
        // Kiểm tra số điện thoại
        if (ncc.getSoDienThoai().trim().isEmpty()) {
            return "Số điện thoại không được để trống!";
        }
        
        // Kiểm tra định dạng số điện thoại (10-11 số)
        String phoneRegex = "^(0[0-9]{9,10})$";
        if (!Pattern.matches(phoneRegex, ncc.getSoDienThoai())) {
            return "Số điện thoại không đúng định dạng (phải bắt đầu bằng 0 và có 10-11 chữ số)!";
        }
        
        return "true";
    }
    
    // Phương thức tìm kiếm nhà cung cấp theo nhiều tiêu chí
    public ArrayList<NhaCungCap_DTO> timKiemNhaCungCap(String tuKhoa) {
        ArrayList<NhaCungCap_DTO> ketQua = new ArrayList<>();
        ArrayList<NhaCungCap_DTO> danhSachNCC = layDanhSachNhaCungCap();
        
        if (tuKhoa == null || tuKhoa.trim().isEmpty()) {
            return danhSachNCC;
        }
        
        String tuKhoaTimKiem = tuKhoa.toLowerCase().trim();
        
        // Tìm theo mã
        try {
            int maTimKiem = Integer.parseInt(tuKhoaTimKiem);
            NhaCungCap_DTO ncc = timNhaCungCapTheoMa(String.valueOf(maTimKiem));
            if (ncc != null) {
                ketQua.add(ncc);
                return ketQua;
            }
        } catch (NumberFormatException e) {
            // Không phải số, tiếp tục tìm theo các trường khác
        }
        
        // Tìm theo tên, địa chỉ, số điện thoại
        for (NhaCungCap_DTO ncc : danhSachNCC) {
            if (ncc.getTenNhaCungCap().toLowerCase().contains(tuKhoaTimKiem) ||
                ncc.getDiaChi().toLowerCase().contains(tuKhoaTimKiem) ||
                ncc.getSoDienThoai().contains(tuKhoaTimKiem)) {
                ketQua.add(ncc);
            }
        }
        
        return ketQua;
    }
}
