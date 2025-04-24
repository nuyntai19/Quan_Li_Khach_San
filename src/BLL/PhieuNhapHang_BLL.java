package BLL;

import DAO.PhieuNhapHang_DAO;
import DTO.PhieuNhapHang_DTO;

import java.time.LocalDate;
import java.util.List;

public class PhieuNhapHang_BLL {
    
    private PhieuNhapHang_DAO phieuNhapHangDAO;
    
    public PhieuNhapHang_BLL() {
        phieuNhapHangDAO = new PhieuNhapHang_DAO();
    }
    
    // Thêm phiếu nhập hàng mới
    public boolean themPhieuNhapHang(PhieuNhapHang_DTO phieuNhap) {
        // Kiểm tra dữ liệu đầu vào
        if (phieuNhap == null) {
            return false;
        }
        
        // Kiểm tra mã nhân viên
        if (phieuNhap.getMaNhanVien() == null || phieuNhap.getMaNhanVien().trim().isEmpty()) {
            return false;
        }
        
        // Kiểm tra mã nhà cung cấp
        if (phieuNhap.getMaNhaCungCap() == null || phieuNhap.getMaNhaCungCap().trim().isEmpty()) {
            return false;
        }
        
        // Kiểm tra ngày nhập không được null và không được trong tương lai
        if (phieuNhap.getNgayNhap() == null || phieuNhap.getNgayNhap().isAfter(LocalDate.now())) {
            return false;
        }
        
        // Kiểm tra tổng tiền phải >= 0
        if (phieuNhap.getTongTien() < 0) {
            return false;
        }
        
        // Kiểm tra mã phiếu nhập đã tồn tại chưa
        if (kiemTraMaTonTai(phieuNhap.getMaPhieuNhap())) {
            return false; // Mã đã tồn tại, không thể thêm mới
        }
        
        // Nếu mọi kiểm tra đều pass, thực hiện thêm phiếu nhập hàng
        return phieuNhapHangDAO.themPhieuNhapHang(phieuNhap);
    }
    
    // Cập nhật thông tin phiếu nhập hàng
    public boolean capNhatPhieuNhapHang(PhieuNhapHang_DTO phieuNhap) {
        // Kiểm tra dữ liệu đầu vào
        if (phieuNhap == null) {
            return false;
        }
        
        // Kiểm tra mã phiếu nhập tồn tại
        if (!kiemTraMaTonTai(phieuNhap.getMaPhieuNhap())) {
            return false; // Mã không tồn tại, không thể cập nhật
        }
        
        // Kiểm tra mã nhân viên
        if (phieuNhap.getMaNhanVien() == null || phieuNhap.getMaNhanVien().trim().isEmpty()) {
            return false;
        }
        
        // Kiểm tra mã nhà cung cấp
        if (phieuNhap.getMaNhaCungCap() == null || phieuNhap.getMaNhaCungCap().trim().isEmpty()) {
            return false;
        }
        
        // Kiểm tra ngày nhập không được null và không được trong tương lai
        if (phieuNhap.getNgayNhap() == null || phieuNhap.getNgayNhap().isAfter(LocalDate.now())) {
            return false;
        }
        
        // Kiểm tra tổng tiền phải >= 0
        if (phieuNhap.getTongTien() < 0) {
            return false;
        }
        
        // Nếu mọi kiểm tra đều pass, thực hiện cập nhật phiếu nhập hàng
        return phieuNhapHangDAO.capNhatPhieuNhapHang(phieuNhap);
    }
    
    // Xóa phiếu nhập hàng
    public boolean xoaPhieuNhapHang(String maPhieuNhap) {
        // Kiểm tra mã phiếu nhập có tồn tại không
        if (!kiemTraMaTonTai(maPhieuNhap)) {
            return false; // Mã không tồn tại, không thể xóa
        }
        
        // Thực hiện xóa phiếu nhập hàng
        return phieuNhapHangDAO.xoaPhieuNhapHang(maPhieuNhap);
    }
    
    // Lấy thông tin một phiếu nhập hàng theo mã
    public PhieuNhapHang_DTO getPhieuNhapHang(String maPhieuNhap) {
        if (maPhieuNhap == null || maPhieuNhap.trim().isEmpty()) {
            return null;
        }
        
        return phieuNhapHangDAO.getPhieuNhapHang(maPhieuNhap);
    }
    
    // Lấy danh sách tất cả phiếu nhập hàng
    public List<PhieuNhapHang_DTO> getAllPhieuNhapHang() {
        return phieuNhapHangDAO.getAllPhieuNhapHang();
    }
    
    // Kiểm tra mã phiếu nhập hàng đã tồn tại hay chưa
    public boolean kiemTraMaTonTai(String maPhieuNhap) {
        if (maPhieuNhap == null || maPhieuNhap.trim().isEmpty()) {
            return false;
        }
        
        try {
            Integer.parseInt(maPhieuNhap); // Kiểm tra mã có phải là số nguyên
        } catch (NumberFormatException e) {
            return false;
        }
        
        return phieuNhapHangDAO.kiemTraMaTonTai(maPhieuNhap);
    }
    
    // Tạo mã phiếu nhập hàng tiếp theo
    public String taoMaPhieuNhapHangTiepTheo() {
        return phieuNhapHangDAO.taoMaPhieuNhapHangTiepTheo();
    }
    
    // Tìm kiếm phiếu nhập hàng theo mã nhà cung cấp
    public List<PhieuNhapHang_DTO> timKiemTheoNhaCungCap(String maNhaCungCap) {
        if (maNhaCungCap == null || maNhaCungCap.trim().isEmpty()) {
            return null;
        }
        
        try {
            Integer.parseInt(maNhaCungCap); // Kiểm tra mã có phải là số nguyên
        } catch (NumberFormatException e) {
            return null;
        }
        
        return phieuNhapHangDAO.timKiemTheoNhaCungCap(maNhaCungCap);
    }
    
    // Tìm kiếm phiếu nhập hàng theo khoảng thời gian
    public List<PhieuNhapHang_DTO> timKiemTheoKhoangThoiGian(LocalDate tuNgay, LocalDate denNgay) {
        // Kiểm tra ngày không được null
        if (tuNgay == null || denNgay == null) {
            return null;
        }
        
        // Kiểm tra ngày bắt đầu không được sau ngày kết thúc
        if (tuNgay.isAfter(denNgay)) {
            LocalDate temp = tuNgay;
            tuNgay = denNgay;
            denNgay = temp;
            // Hoặc có thể return null nếu muốn báo lỗi
        }
        
        return phieuNhapHangDAO.timKiemTheoKhoangThoiGian(tuNgay, denNgay);
    }
    
    // Tính tổng giá trị nhập hàng trong khoảng thời gian
    public double tinhTongGiaTriNhapHangTrongKhoangThoiGian(LocalDate tuNgay, LocalDate denNgay) {
        List<PhieuNhapHang_DTO> danhSachPhieuNhap = timKiemTheoKhoangThoiGian(tuNgay, denNgay);
        
        if (danhSachPhieuNhap == null || danhSachPhieuNhap.isEmpty()) {
            return 0;
        }
        
        double tongGiaTri = 0;
        for (PhieuNhapHang_DTO phieuNhap : danhSachPhieuNhap) {
            tongGiaTri += phieuNhap.getTongTien();
        }
        
        return tongGiaTri;
    }
}
