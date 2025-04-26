package UI;

import BLL.HangHoa_BLL;
import BLL.NhuYeuPham_BLL;
import BLL.DoGiaDung_BLL;
import DTO.HangHoa;
import DTO.NhuYeuPham_DTO;
import DTO.DoGiaDung_DTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuanLyKhoHang_GUI extends JFrame {
    private JPanel pnlControl, pnlContent, pnlDetail;
    private JButton btnThemLoaiHang, btnNhapKho, btnXuatKho, btnChuyenNhuYeuPham, btnChuyenDoGiaDung, btnTimKiem;
    private JTextField txtTimKiem;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtMaHangDetail, txtTenHangDetail, txtLoaiHangDetail, txtSoLuongDetail, txtGiaNhapDetail;
    private HangHoa_BLL hangHoaBLL;
    private NhuYeuPham_BLL nhuYeuPhamBLL;
    private DoGiaDung_BLL doGiaDungBLL;

    public QuanLyKhoHang_GUI() {
        initComponent(); // Khởi tạo giao diện
        loadData();      // Tải dữ liệu ban đầu
    }
    private void initComponent() {
        setTitle("Hệ Thống Quản Lý Kho Hàng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLayout(new BorderLayout());

        // Bảng điều khiển bên trái
        pnlControl = new JPanel(new GridLayout(5, 1, 10, 10));
        pnlControl.setBackground(new Color(240, 245, 255));
        pnlControl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnThemLoaiHang = createStyledButton("Thêm Loại Hàng");
        btnNhapKho = createStyledButton("Nhập Kho");
        btnXuatKho = createStyledButton("Xuất Kho");

        pnlControl.add(btnThemLoaiHang);
        pnlControl.add(btnNhapKho);
        pnlControl.add(btnXuatKho);

        add(pnlControl, BorderLayout.WEST);

        // Bảng nội dung bên phải
        pnlContent = new JPanel(new BorderLayout());
        pnlContent.setBackground(Color.WHITE);
        model = new DefaultTableModel(new String[]{"Mã hàng", "Tên hàng", "Loại hàng", "Đơn vị tính", "Số lượng tồn", "Giá nhập"}, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        pnlContent.add(scrollPane, BorderLayout.CENTER);

        JPanel pnlSwitch = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnChuyenNhuYeuPham = createStyledButton("Hiển thị Nhu Yếu Phẩm");
        btnChuyenDoGiaDung = createStyledButton("Hiển thị Đồ Gia Dụng");
        pnlSwitch.add(btnChuyenNhuYeuPham);
        pnlSwitch.add(btnChuyenDoGiaDung);

        pnlContent.add(pnlSwitch, BorderLayout.NORTH);
        add(pnlContent, BorderLayout.CENTER);
        // Phần tìm kiếm
        JPanel pnlSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        txtTimKiem = new JTextField(20);
        btnTimKiem = createStyledButton("Tìm Kiếm");
        pnlSearch.add(new JLabel("Nhập Mã Hàng:"));
        pnlSearch.add(txtTimKiem);
        pnlSearch.add(btnTimKiem);
        pnlContent.add(pnlSearch, BorderLayout.NORTH);

        // Khu vực hiển thị chi tiết
        pnlDetail = new JPanel(new GridLayout(5, 2, 10, 10));
        pnlDetail.setBorder(BorderFactory.createTitledBorder("Thông Tin Chi Tiết"));
        txtMaHangDetail = createStyledTextField(15);
        txtTenHangDetail = createStyledTextField(15);
        txtLoaiHangDetail = createStyledTextField(15);
        txtSoLuongDetail = createStyledTextField(15);
        txtGiaNhapDetail = createStyledTextField(15);

        pnlDetail.add(new JLabel("Mã Hàng:"));
        pnlDetail.add(txtMaHangDetail);
        pnlDetail.add(new JLabel("Tên Hàng:"));
        pnlDetail.add(txtTenHangDetail);
        pnlDetail.add(new JLabel("Loại Hàng:"));
        pnlDetail.add(txtLoaiHangDetail);
        pnlDetail.add(new JLabel("Số Lượng:"));
        pnlDetail.add(txtSoLuongDetail);
        pnlDetail.add(new JLabel("Giá Nhập:"));
        pnlDetail.add(txtGiaNhapDetail);

        pnlContent.add(pnlDetail, BorderLayout.SOUTH);
    }
    private void loadData() {
        hangHoaBLL = new HangHoa_BLL();
        nhuYeuPhamBLL = new NhuYeuPham_BLL();
        doGiaDungBLL = new DoGiaDung_BLL();

        btnChuyenNhuYeuPham.addActionListener(e -> displayNhuYeuPham());
        btnChuyenDoGiaDung.addActionListener(e -> displayDoGiaDung());
        btnTimKiem.addActionListener(e -> searchHangHoa());

        // Xử lý sự kiện chọn dòng
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                txtMaHangDetail.setText(model.getValueAt(selectedRow, 0).toString());
                txtTenHangDetail.setText(model.getValueAt(selectedRow, 1).toString());
                txtLoaiHangDetail.setText(model.getValueAt(selectedRow, 2).toString());
                txtSoLuongDetail.setText(model.getValueAt(selectedRow, 4).toString());
                txtGiaNhapDetail.setText(model.getValueAt(selectedRow, 5).toString());
            }
        });
    }

    private void displayNhuYeuPham() {
        model.setRowCount(0); // Xóa dữ liệu cũ
        List<NhuYeuPham_DTO> nhuYeuPhamList = nhuYeuPhamBLL.getAll();
        for (NhuYeuPham_DTO item : nhuYeuPhamList) {
            model.addRow(new Object[]{
                    item.getMaNhuYeuPham(), item.getTenNhuYeuPham(),
                    "Nhu Yếu Phẩm", item.getDonViTinh(),
                    item.getSoLuong(), item.getGiaNhap()
            });
        }
    }

    private void displayDoGiaDung() {
        model.setRowCount(0); // Xóa dữ liệu cũ
        List<DoGiaDung_DTO> doGiaDungList = doGiaDungBLL.getAll();
        for (DoGiaDung_DTO item : doGiaDungList) {
            model.addRow(new Object[]{
                    item.getMaDoGiaDung(), item.getTenDoGiaDung(),
                    "Đồ Gia Dụng", item.getDonViTinh(),
                    item.getSoLuong(), item.getGiaNhap()
            });
        }
    }

    private void searchHangHoa() {
        String maHang = txtTimKiem.getText().trim();
        if (maHang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        model.setRowCount(0); // Xóa dữ liệu cũ
        for (HangHoa hang : hangHoaBLL.getAll()) {
            if (hang.getMaHang().equalsIgnoreCase(maHang)) {
                model.addRow(new Object[]{
                        hang.getMaHang(), hang.getTenHang(), hang.getLoaiHang(),
                        hang.getDonViTinh(), hang.getSoLuong(), hang.getGiaNhap()
                });
            }
        }
    }
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hiệu ứng hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(new Color(0, 82, 163)); // Đậm hơn khi hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(new Color(0, 102, 204)); // Màu ban đầu
            }
        });

        return button;
    }

    private JTextField createStyledTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuanLyKhoHang_GUI().setVisible(true);
        });
    }
}
