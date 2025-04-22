
package BLL;


import DTO.ChiTietPhieuThuePhongDTO;
import java.util.ArrayList;
import java.util.List;

public class PhieuThuePhongManager {
    private static List<ChiTietPhieuThuePhongDTO> danhSachChiTiet = new ArrayList<>();

    // Thêm chi tiết vào danh sách tạm
    public static void addChiTiet(ChiTietPhieuThuePhongDTO chiTiet) {
        danhSachChiTiet.add(chiTiet);
    }

    // Lấy danh sách chi tiết từ danh sách tạm
    public static List<ChiTietPhieuThuePhongDTO> getDanhSachChiTiet() {
        return danhSachChiTiet;
    }

    // Xóa tất cả dữ liệu trong danh sách tạm (nếu cần)
    public static void clearDanhSach() {
        danhSachChiTiet.clear();
    }
    
}
