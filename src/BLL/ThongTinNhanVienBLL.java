
package BLL;

import DTO.ThongTinNhanVienDTO;
import DAO.ThongTinNhanVienDAO;

public class ThongTinNhanVienBLL {
    private ThongTinNhanVienDAO dao = new ThongTinNhanVienDAO();

    public boolean laAdminDangNhap() {
        ThongTinNhanVienDTO dto = dao.layTaiKhoanDangNhapGanNhat();
        if (dto != null && dto.getVaiTro().equalsIgnoreCase("admin")) {
            return true;
        }
        return false;
    }
}
