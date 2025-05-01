package BLL;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaiKhoanBLL {
    private final TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanBLL() {
        taiKhoanDAO = new TaiKhoanDAO();
    }

    // Đăng nhập
    public TaiKhoanDTO dangNhap(String tenDangNhap, String matKhau) throws Exception {
        return taiKhoanDAO.dangNhap(tenDangNhap, matKhau);
    }

    // Lấy tài khoản đang đăng nhập từ bảng tạm
    public TaiKhoanDTO layTaiKhoanDangNhapTuBangNhanVienDangNhap() throws Exception {
        return taiKhoanDAO.layTaiKhoanDangNhapTuBangNhanVienDangNhap();
    }

    // Thêm đăng nhập vào bảng tạm
    public void themDangNhapVaoBangTam(TaiKhoanDTO tk) throws Exception {
        taiKhoanDAO.themDangNhapVaoBangTam(tk);
    }

    // Xóa toàn bộ bảng đăng nhập tạm
    public void xoaTatCaDangNhapBangTam() throws Exception {
        taiKhoanDAO.xoaTatCaDangNhapBangTam();
    }

    // Kiểm tra tài khoản có tồn tại
    public boolean kiemTraTonTai(String tenDangNhap) throws SQLException {
        return taiKhoanDAO.kiemTraTonTai(tenDangNhap);
    }

    // Thêm tài khoản mới
    public void themTaiKhoan(TaiKhoanDTO tk) throws SQLException {
        taiKhoanDAO.themTaiKhoan(tk);
    }

    // Sửa thông tin tài khoản
    public void suaTaiKhoan(TaiKhoanDTO tk) throws SQLException {
        taiKhoanDAO.suaTaiKhoan(tk);
    }

    // Xóa tài khoản
    public void xoaTaiKhoan(int maTaiKhoan) throws SQLException {
        taiKhoanDAO.xoaTaiKhoan(maTaiKhoan);
    }

    // Lấy danh sách tất cả tài khoản
    public ArrayList<TaiKhoanDTO> layDanhSachTaiKhoan() throws SQLException {
        return taiKhoanDAO.layDanhSachTaiKhoan();
    }

    // Cập nhật trạng thái tài khoản
    public void capNhatTrangThaiTaiKhoan(int maTaiKhoan, String trangThaiMoi) throws SQLException {
        taiKhoanDAO.capNhatTrangThaiTaiKhoan(maTaiKhoan, trangThaiMoi);
    }
    
    //Tìm Kiếm
    public ArrayList<TaiKhoanDTO> timChiTiet(String loaiTimKiem, String tuKhoa) throws SQLException {
        ArrayList<TaiKhoanDTO> ketQua = new ArrayList<>();
        ArrayList<TaiKhoanDTO> danhSach = layDanhSachTaiKhoan();

        for (TaiKhoanDTO ct : danhSach) {
            switch (loaiTimKiem) {
                case "Tên đăng nhập":
                    if (String.valueOf(ct.getTenDangNhap()).contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Mã nhân viên":
                    if (String.valueOf(ct.getMaNhanVien()).contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Vai trò":
                    if (ct.getVaiTro().contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
                case "Trạng thái":
                    if (ct.getTrangThai().contains(tuKhoa)) {
                        ketQua.add(ct);
                    }
                    break;
            }
        }
        return ketQua;
    }

}
