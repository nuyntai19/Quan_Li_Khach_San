package UI;

import BLL.DoGiaDung_BLL;
import BLL.HangHoa_BLL;
import BLL.NhuYeuPham_BLL;
import DTO.DoGiaDung_DTO;
import DTO.HangHoa_DTO;
import DTO.NhuYeuPham_DTO;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaoDienKhoHang extends JFrame {
    private JTabbedPane tabbedPane;
    private JTable tableHangHoa, tableDoGiaDung, tableNhuYeuPham;
    private JTextField txtTimKiem;
    private JComboBox<String> cboLoaiTimKiem;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi;
    private JPanel pnlThongTin;
    private JTextField txtMa, txtTen, txtDonViTinh, txtGiaNhap;
    private JTextField txtTinhTrang, txtHanSuDung, txtNhaCungCap;
    private JComboBox<String> cboLoaiHang;
    
    private HangHoa_BLL hangHoaBLL;
    private DoGiaDung_BLL doGiaDungBLL;
    private NhuYeuPham_BLL nhuYeuPhamBLL;
    
    public GiaoDienKhoHang() {
        initComponents();
        initData();
        setupEventHandlers();
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        setTitle("Quản Lý Kho Hàng");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tạo tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        // Tạo các tab
        tabbedPane.addTab("Hàng Hóa", createHangHoaPanel());
        tabbedPane.addTab("Đồ Gia Dụng", createDoGiaDungPanel());
        tabbedPane.addTab("Nhu Yếu Phẩm", createNhuYeuPhamPanel());
        
        // Thêm tabbed pane vào frame
        add(tabbedPane, BorderLayout.CENTER);
        
        // Tạo panel thông tin chi tiết
        pnlThongTin = createThongTinPanel();
        add(pnlThongTin, BorderLayout.EAST);
    }
    
    private JPanel createHangHoaPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel tìm kiếm
        JPanel pnlTimKiem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlTimKiem.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm"));
        
        txtTimKiem = new JTextField(20);
        cboLoaiTimKiem = new JComboBox<>(new String[]{"Mã", "Tên", "Đơn vị tính"});
        btnTimKiem = new JButton("Tìm");
        
        pnlTimKiem.add(new JLabel("Từ khóa:"));
        pnlTimKiem.add(txtTimKiem);
        pnlTimKiem.add(new JLabel("Tìm theo:"));
        pnlTimKiem.add(cboLoaiTimKiem);
        pnlTimKiem.add(btnTimKiem);
        
        // Panel nút
        JPanel pnlNut = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        
        pnlNut.add(btnThem);
        pnlNut.add(btnSua);
        pnlNut.add(btnXoa);
        pnlNut.add(btnLamMoi);
        
        // Bảng dữ liệu
        String[] columns = {"Mã", "Tên", "Đơn vị tính", "Giá nhập"};
        tableHangHoa = new JTable(new DefaultTableModel(columns, 0));
        JScrollPane scrollPane = new JScrollPane(tableHangHoa);
        
        // Thêm các thành phần vào panel
        panel.add(pnlTimKiem, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(pnlNut, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createDoGiaDungPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel tìm kiếm
        JPanel pnlTimKiem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlTimKiem.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm"));
        
        txtTimKiem = new JTextField(20);
        cboLoaiTimKiem = new JComboBox<>(new String[]{"Mã", "Tên", "Tình trạng"});
        btnTimKiem = new JButton("Tìm");
        
        pnlTimKiem.add(new JLabel("Từ khóa:"));
        pnlTimKiem.add(txtTimKiem);
        pnlTimKiem.add(new JLabel("Tìm theo:"));
        pnlTimKiem.add(cboLoaiTimKiem);
        pnlTimKiem.add(btnTimKiem);
        
        // Panel nút
        JPanel pnlNut = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        
        pnlNut.add(btnThem);
        pnlNut.add(btnSua);
        pnlNut.add(btnXoa);
        pnlNut.add(btnLamMoi);
        
        // Bảng dữ liệu
        String[] columns = {"Mã", "Tên", "Đơn vị tính", "Giá nhập", "Tình trạng"};
        tableDoGiaDung = new JTable(new DefaultTableModel(columns, 0));
        JScrollPane scrollPane = new JScrollPane(tableDoGiaDung);
        
        // Thêm các thành phần vào panel
        panel.add(pnlTimKiem, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(pnlNut, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createNhuYeuPhamPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel tìm kiếm
        JPanel pnlTimKiem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlTimKiem.setBorder(BorderFactory.createTitledBorder("Tìm Kiếm"));
        
        txtTimKiem = new JTextField(20);
        cboLoaiTimKiem = new JComboBox<>(new String[]{"Mã", "Tên", "Nhà cung cấp"});
        btnTimKiem = new JButton("Tìm");
        
        pnlTimKiem.add(new JLabel("Từ khóa:"));
        pnlTimKiem.add(txtTimKiem);
        pnlTimKiem.add(new JLabel("Tìm theo:"));
        pnlTimKiem.add(cboLoaiTimKiem);
        pnlTimKiem.add(btnTimKiem);
        
        // Panel nút
        JPanel pnlNut = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        
        pnlNut.add(btnThem);
        pnlNut.add(btnSua);
        pnlNut.add(btnXoa);
        pnlNut.add(btnLamMoi);
        
        // Bảng dữ liệu
        String[] columns = {"Mã", "Tên", "Đơn vị tính", "Giá nhập", "Hạn sử dụng", "Nhà cung cấp"};
        tableNhuYeuPham = new JTable(new DefaultTableModel(columns, 0));
        JScrollPane scrollPane = new JScrollPane(tableNhuYeuPham);
        
        // Thêm các thành phần vào panel
        panel.add(pnlTimKiem, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(pnlNut, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createThongTinPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Thông Tin Chi Tiết"));
        panel.setPreferredSize(new Dimension(300, 0));
        
        // Panel thông tin
        JPanel pnlInfo = new JPanel(new GridLayout(7, 2, 5, 5));
        pnlInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        txtMa = new JTextField();
        txtTen = new JTextField();
        txtDonViTinh = new JTextField();
        txtGiaNhap = new JTextField();
        txtTinhTrang = new JTextField();
        txtHanSuDung = new JTextField();
        txtNhaCungCap = new JTextField();
        
        pnlInfo.add(new JLabel("Mã:"));
        pnlInfo.add(txtMa);
        pnlInfo.add(new JLabel("Tên:"));
        pnlInfo.add(txtTen);
        pnlInfo.add(new JLabel("Đơn vị tính:"));
        pnlInfo.add(txtDonViTinh);
        pnlInfo.add(new JLabel("Giá nhập:"));
        pnlInfo.add(txtGiaNhap);
        pnlInfo.add(new JLabel("Tình trạng:"));
        pnlInfo.add(txtTinhTrang);
        pnlInfo.add(new JLabel("Hạn sử dụng:"));
        pnlInfo.add(txtHanSuDung);
        pnlInfo.add(new JLabel("Nhà cung cấp:"));
        pnlInfo.add(txtNhaCungCap);
        
        // Panel nút
        JPanel pnlNut = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnLuu = new JButton("Lưu");
        JButton btnHuy = new JButton("Hủy");
        
        pnlNut.add(btnLuu);
        pnlNut.add(btnHuy);
        
        // Thêm các thành phần vào panel
        panel.add(pnlInfo, BorderLayout.CENTER);
        panel.add(pnlNut, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void initData() {
        hangHoaBLL = new HangHoa_BLL();
        doGiaDungBLL = new DoGiaDung_BLL();
        nhuYeuPhamBLL = new NhuYeuPham_BLL();
        
        // Load dữ liệu ban đầu
        loadHangHoa();
        loadDoGiaDung();
        loadNhuYeuPham();
    }
    
    private void setupEventHandlers() {
        // Xử lý sự kiện chọn tab
        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            switch (selectedIndex) {
                case 0: // Hàng hóa
                    loadHangHoa();
                    break;
                case 1: // Đồ gia dụng
                    loadDoGiaDung();
                    break;
                case 2: // Nhu yếu phẩm
                    loadNhuYeuPham();
                    break;
            }
        });
        
        // Xử lý sự kiện chọn dòng trong bảng
        tableHangHoa.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableHangHoa.getSelectedRow();
                if (row != -1) {
                    showHangHoaDetails(row);
                }
            }
        });
        
        // Tương tự cho các bảng khác...
        
        // Xử lý sự kiện nút
        btnThem.addActionListener(e -> themMoi());
        btnSua.addActionListener(e -> sua());
        btnXoa.addActionListener(e -> xoa());
        btnLamMoi.addActionListener(e -> lamMoi());
        btnTimKiem.addActionListener(e -> timKiem());
    }
    
    private void loadHangHoa() {
        DefaultTableModel model = (DefaultTableModel) tableHangHoa.getModel();
        model.setRowCount(0);
        
        ArrayList<HangHoa_DTO> danhSach = hangHoaBLL.layTatCaHangHoa();
        for (HangHoa_DTO hh : danhSach) {
            model.addRow(new Object[]{
                hh.getMaHang(),
                hh.getTenHang(),
                hh.getDonViTinh(),
                hh.getGiaNhap()
            });
        }
    }
    
    private void loadDoGiaDung() {
        DefaultTableModel model = (DefaultTableModel) tableDoGiaDung.getModel();
        model.setRowCount(0);
        
        ArrayList<DoGiaDung_DTO> danhSach = doGiaDungBLL.layTatCaDoGiaDung();
        for (DoGiaDung_DTO dgd : danhSach) {
            model.addRow(new Object[]{
                dgd.getMaDoGiaDung(),
                dgd.getTenDoGiaDung(),
                dgd.getDonViTinh(),
                dgd.getGiaNhap(),
                dgd.getTinhTrang()
            });
        }
    }
    
    private void loadNhuYeuPham() {
        DefaultTableModel model = (DefaultTableModel) tableNhuYeuPham.getModel();
        model.setRowCount(0);
        
        ArrayList<NhuYeuPham_DTO> danhSach = nhuYeuPhamBLL.layTatCaNhuYeuPham();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (NhuYeuPham_DTO nyp : danhSach) {
            model.addRow(new Object[]{
                nyp.getMaNhuYeuPham(),
                nyp.getTenNhuYeuPham(),
                nyp.getDonViTinh(),
                nyp.getGiaNhap(),
                sdf.format(nyp.getHanSuDung()),
                nyp.getNhaCungCap()
            });
        }
    }
    
    private void showHangHoaDetails(int row) {
        int maHang = (int) tableHangHoa.getValueAt(row, 0);
        HangHoa_DTO hangHoa = hangHoaBLL.layHangHoaTheoMa(maHang);
        
        if (hangHoa != null) {
            txtMa.setText(String.valueOf(hangHoa.getMaHang()));
            txtTen.setText(hangHoa.getTenHang());
            txtDonViTinh.setText(hangHoa.getDonViTinh());
            txtGiaNhap.setText(String.valueOf(hangHoa.getGiaNhap()));
            txtTinhTrang.setText("");
            txtHanSuDung.setText("");
            txtNhaCungCap.setText("");
        }
    }
    
    private void themMoi() {
        // Xử lý thêm mới
    }
    
    private void sua() {
        // Xử lý sửa
    }
    
    private void xoa() {
        // Xử lý xóa
    }
    
    private void lamMoi() {
        // Xử lý làm mới
    }
    
    private void timKiem() {
        // Xử lý tìm kiếm
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new GiaoDienKhoHang().setVisible(true);
        });
    }
} 
