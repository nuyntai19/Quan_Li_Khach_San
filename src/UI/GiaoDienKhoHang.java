package UI;

import BLL.DoGiaDung_BLL;
import BLL.HangHoa_BLL;
import BLL.NhuYeuPham_BLL;
import DTO.DoGiaDung_DTO;
import DTO.HangHoa_DTO;
import DTO.NhuYeuPham_DTO;
import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sql.DatabaseQLKS;

public class GiaoDienKhoHang extends JFrame {
    // Các thành phần giao diện
    private JTabbedPane tabbedPane;
    private JTable tableHangHoa, tableDoGiaDung, tableNhuYeuPham;
    private JTextField txtTimKiem;
    private JComboBox<String> cboLoaiTimKiem;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi, btnXuatBaoCao, btnIn;
    private JPanel pnlThongTin;
    private JTextField txtMa, txtTen, txtDonViTinh, txtGiaNhap;
    private JTextField txtTinhTrang, txtHanSuDung, txtNhaCungCap;
    private JComboBox<String> cboLoaiHang;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private JPanel statusBar;
    private JLabel lblTrangThai;
    private JButton btnTimKiem;
    
    // Các đối tượng BLL
    private HangHoa_BLL hangHoaBLL;
    private DoGiaDung_BLL doGiaDungBLL;
    private NhuYeuPham_BLL nhuYeuPhamBLL;
    
    // Các biến trạng thái
    private boolean isEditing = false;
    private int selectedRow = -1;
    private String currentTab = "HangHoa";
    
    public GiaoDienKhoHang() {
        initComponents();
        initData();
        setupEventHandlers();
        setupMenu();
        setupToolbar();
        setupStatusBar();
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
        btnXuatBaoCao = new JButton("Xuất báo cáo");
        btnIn = new JButton("In");
        
        pnlNut.add(btnThem);
        pnlNut.add(btnSua);
        pnlNut.add(btnXoa);
        pnlNut.add(btnLamMoi);
        pnlNut.add(btnXuatBaoCao);
        pnlNut.add(btnIn);
        
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
        btnXuatBaoCao = new JButton("Xuất báo cáo");
        btnIn = new JButton("In");
        
        pnlNut.add(btnThem);
        pnlNut.add(btnSua);
        pnlNut.add(btnXoa);
        pnlNut.add(btnLamMoi);
        pnlNut.add(btnXuatBaoCao);
        pnlNut.add(btnIn);
        
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
        btnXuatBaoCao = new JButton("Xuất báo cáo");
        btnIn = new JButton("In");
        
        pnlNut.add(btnThem);
        pnlNut.add(btnSua);
        pnlNut.add(btnXoa);
        pnlNut.add(btnLamMoi);
        pnlNut.add(btnXuatBaoCao);
        pnlNut.add(btnIn);
        
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
    
    private void setupMenu() {
        menuBar = new JMenuBar();
        
        // Menu File
        JMenu menuFile = new JMenu("File");
        JMenuItem miNew = new JMenuItem("Mới");
        JMenuItem miOpen = new JMenuItem("Mở");
        JMenuItem miSave = new JMenuItem("Lưu");
        JMenuItem miExit = new JMenuItem("Thoát");
        
        menuFile.add(miNew);
        menuFile.add(miOpen);
        menuFile.add(miSave);
        menuFile.addSeparator();
        menuFile.add(miExit);
        
        // Menu Edit
        JMenu menuEdit = new JMenu("Edit");
        JMenuItem miAdd = new JMenuItem("Thêm");
        JMenuItem miEdit = new JMenuItem("Sửa");
        JMenuItem miDelete = new JMenuItem("Xóa");
        JMenuItem miRefresh = new JMenuItem("Làm mới");
        
        menuEdit.add(miAdd);
        menuEdit.add(miEdit);
        menuEdit.add(miDelete);
        menuEdit.addSeparator();
        menuEdit.add(miRefresh);
        
        // Menu View
        JMenu menuView = new JMenu("View");
        JMenuItem miSort = new JMenuItem("Sắp xếp");
        JMenuItem miFilter = new JMenuItem("Lọc");
        JMenuItem miSearch = new JMenuItem("Tìm kiếm");
        
        menuView.add(miSort);
        menuView.add(miFilter);
        menuView.add(miSearch);
        
        // Menu Report
        JMenu menuReport = new JMenu("Báo cáo");
        JMenuItem miExportPDF = new JMenuItem("Xuất PDF");
        JMenuItem miExportExcel = new JMenuItem("Xuất Excel");
        JMenuItem miPrint = new JMenuItem("In");
        
        menuReport.add(miExportPDF);
        menuReport.add(miExportExcel);
        menuReport.add(miPrint);
        
        // Menu Help
        JMenu menuHelp = new JMenu("Help");
        JMenuItem miAbout = new JMenuItem("About");
        
        menuHelp.add(miAbout);
        
        // Thêm các menu vào menuBar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuView);
        menuBar.add(menuReport);
        menuBar.add(menuHelp);
        
        setJMenuBar(menuBar);
    }
    
    private void setupToolbar() {
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        
        JButton btnNew = new JButton("Mới");
        JButton btnOpen = new JButton("Mở");
        JButton btnSave = new JButton("Lưu");
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnRefresh = new JButton("Làm mới");
        JButton btnExport = new JButton("Xuất");
        JButton btnPrint = new JButton("In");
        
        toolBar.add(btnNew);
        toolBar.add(btnOpen);
        toolBar.add(btnSave);
        toolBar.addSeparator();
        toolBar.add(btnAdd);
        toolBar.add(btnEdit);
        toolBar.add(btnDelete);
        toolBar.add(btnRefresh);
        toolBar.addSeparator();
        toolBar.add(btnExport);
        toolBar.add(btnPrint);
        
        add(toolBar, BorderLayout.NORTH);
    }
    
    private void setupStatusBar() {
        statusBar = new JPanel(new BorderLayout());
        lblTrangThai = new JLabel("Sẵn sàng");
        statusBar.add(lblTrangThai, BorderLayout.WEST);
        add(statusBar, BorderLayout.SOUTH);
    }
    
    private void initData() {
        try {
            Connection conn = DatabaseQLKS.getConnection();
            hangHoaBLL = new HangHoa_BLL(conn);
            doGiaDungBLL = new DoGiaDung_BLL();
            nhuYeuPhamBLL = new NhuYeuPham_BLL();
            
            // Load dữ liệu ban đầu
            loadHangHoa();
            loadDoGiaDung();
            loadNhuYeuPham();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
    }
    
    private void setupEventHandlers() {
        // Xử lý sự kiện chọn tab
        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            switch (selectedIndex) {
                case 0: // Hàng hóa
                    currentTab = "HangHoa";
                    loadHangHoa();
                    break;
                case 1: // Đồ gia dụng
                    currentTab = "DoGiaDung";
                    loadDoGiaDung();
                    break;
                case 2: // Nhu yếu phẩm
                    currentTab = "NhuYeuPham";
                    loadNhuYeuPham();
                    break;
            }
        });
        
        // Xử lý sự kiện chọn dòng trong bảng
        tableHangHoa.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableHangHoa.getSelectedRow();
                if (row != -1) {
                    selectedRow = row;
                    showHangHoaDetails(row);
                }
            }
        });
        
        tableDoGiaDung.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableDoGiaDung.getSelectedRow();
                if (row != -1) {
                    selectedRow = row;
                    showDoGiaDungDetails(row);
                }
            }
        });
        
        tableNhuYeuPham.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableNhuYeuPham.getSelectedRow();
                if (row != -1) {
                    selectedRow = row;
                    showNhuYeuPhamDetails(row);
                }
            }
        });
        
        // Xử lý sự kiện nút
        btnThem.addActionListener(e -> themMoi());
        btnSua.addActionListener(e -> sua());
        btnXoa.addActionListener(e -> xoa());
        btnLamMoi.addActionListener(e -> lamMoi());
        btnTimKiem.addActionListener(e -> timKiem());
        btnXuatBaoCao.addActionListener(e -> xuatBaoCao());
        btnIn.addActionListener(e -> in());
        
        // Xử lý sự kiện nút Lưu và Hủy
        JButton btnLuu = (JButton) pnlThongTin.getComponent(1);
        JButton btnHuy = (JButton) pnlThongTin.getComponent(2);
        
        btnLuu.addActionListener(e -> {
            if (validateInput()) {
                switch (currentTab) {
                    case "HangHoa":
                        saveHangHoa();
                        break;
                    case "DoGiaDung":
                        saveDoGiaDung();
                        break;
                    case "NhuYeuPham":
                        saveNhuYeuPham();
                        break;
                }
            }
        });
        
        btnHuy.addActionListener(e -> {
            clearFields();
            updateStatus("Đã hủy thao tác");
        });
        
        // Xử lý sự kiện menu
        setupMenuEventHandlers();
    }
    
    private void setupMenuEventHandlers() {
        // Menu File
        JMenu menuFile = menuBar.getMenu(0);
        JMenuItem miNew = menuFile.getItem(0);
        JMenuItem miOpen = menuFile.getItem(1);
        JMenuItem miSave = menuFile.getItem(2);
        JMenuItem miExit = menuFile.getItem(4);
        
        miNew.addActionListener(e -> themMoi());
        miOpen.addActionListener(e -> openFile());
        miSave.addActionListener(e -> saveFile());
        miExit.addActionListener(e -> System.exit(0));
        
        // Menu Edit
        JMenu menuEdit = menuBar.getMenu(1);
        JMenuItem miAdd = menuEdit.getItem(0);
        JMenuItem miEdit = menuEdit.getItem(1);
        JMenuItem miDelete = menuEdit.getItem(2);
        JMenuItem miRefresh = menuEdit.getItem(4);
        
        miAdd.addActionListener(e -> themMoi());
        miEdit.addActionListener(e -> sua());
        miDelete.addActionListener(e -> xoa());
        miRefresh.addActionListener(e -> lamMoi());
        
        // Menu View
        JMenu menuView = menuBar.getMenu(2);
        JMenuItem miSort = menuView.getItem(0);
        JMenuItem miFilter = menuView.getItem(1);
        JMenuItem miSearch = menuView.getItem(2);
        
        miSort.addActionListener(e -> showSortDialog());
        miFilter.addActionListener(e -> showFilterDialog());
        miSearch.addActionListener(e -> showSearchDialog());
        
        // Menu Report
        JMenu menuReport = menuBar.getMenu(3);
        JMenuItem miExportPDF = menuReport.getItem(0);
        JMenuItem miExportExcel = menuReport.getItem(1);
        JMenuItem miPrint = menuReport.getItem(2);
        
        miExportPDF.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("PDF files (*.pdf)", "pdf"));
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    exportToPDF(fileChooser.getSelectedFile());
                    JOptionPane.showMessageDialog(this, "Xuất PDF thành công!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi xuất PDF: " + ex.getMessage());
                }
            }
        });
        
        miExportExcel.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel files (*.xlsx)", "xlsx"));
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    exportToExcel(fileChooser.getSelectedFile());
                    JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi xuất Excel: " + ex.getMessage());
                }
            }
        });
        
        miPrint.addActionListener(e -> in());
        
        // Menu Help
        JMenu menuHelp = menuBar.getMenu(4);
        JMenuItem miAbout = menuHelp.getItem(0);
        
        miAbout.addActionListener(e -> showAboutDialog());
    }
    
    private void showDoGiaDungDetails(int row) {
        int maDoGiaDung = (int) tableDoGiaDung.getValueAt(row, 0);
        DoGiaDung_DTO doGiaDung = doGiaDungBLL.layDoGiaDungTheoMa(maDoGiaDung);
        
        if (doGiaDung != null) {
            txtMa.setText(String.valueOf(doGiaDung.getMaHang()));
            txtTen.setText(doGiaDung.getTenHang());
            txtDonViTinh.setText(doGiaDung.getDonViTinh());
            txtGiaNhap.setText(String.valueOf(doGiaDung.getGiaNhap()));
            txtTinhTrang.setText(doGiaDung.getTinhTrang());
            txtHanSuDung.setText("");
            txtNhaCungCap.setText("");
            
            updateStatus("Đang xem thông tin đồ gia dụng: " + doGiaDung.getTenHang());
        }
    }
    
    private void showNhuYeuPhamDetails(int row) {
        int maNhuYeuPham = (int) tableNhuYeuPham.getValueAt(row, 0);
        NhuYeuPham_DTO nhuYeuPham = nhuYeuPhamBLL.layNhuYeuPhamTheoMa(maNhuYeuPham);
        
        if (nhuYeuPham != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            txtMa.setText(String.valueOf(nhuYeuPham.getMaHang()));
            txtTen.setText(nhuYeuPham.getTenHang());
            txtDonViTinh.setText(nhuYeuPham.getDonViTinh());
            txtGiaNhap.setText(String.valueOf(nhuYeuPham.getGiaNhap()));
            txtTinhTrang.setText("");
            txtHanSuDung.setText(sdf.format(nhuYeuPham.getHanSuDung()));
            txtNhaCungCap.setText(nhuYeuPham.getNhaCungCap());
            
            updateStatus("Đang xem thông tin nhu yếu phẩm: " + nhuYeuPham.getTenHang());
        }
    }
    
    private boolean validateInput() {
        if (txtTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên");
            return false;
        }
        if (txtDonViTinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn vị tính");
            return false;
        }
        try {
            double giaNhap = Double.parseDouble(txtGiaNhap.getText().trim());
            if (giaNhap <= 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá nhập không hợp lệ");
            return false;
        }
        
        // Kiểm tra thêm cho từng loại
        switch (currentTab) {
            case "DoGiaDung":
                if (txtTinhTrang.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập tình trạng");
                    return false;
                }
                break;
            case "NhuYeuPham":
                if (txtHanSuDung.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập hạn sử dụng");
                    return false;
                }
                if (txtNhaCungCap.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà cung cấp");
                    return false;
                }
                break;
        }
        
        return true;
    }
    
    private void saveHangHoa() {
        try {
            HangHoa_DTO hangHoa = new HangHoa_DTO();
            hangHoa.setMaHang(Integer.parseInt(txtMa.getText().trim()));
            hangHoa.setTenHang(txtTen.getText().trim());
            hangHoa.setDonViTinh(txtDonViTinh.getText().trim());
            hangHoa.setGiaNhap(Double.parseDouble(txtGiaNhap.getText().trim()));
            
            if (isEditing) {
                if (hangHoaBLL.capNhatHangHoa(hangHoa)) {
                    JOptionPane.showMessageDialog(this, "Sửa hàng hóa thành công!");
                    loadHangHoa();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa hàng hóa thất bại!");
                }
            } else {
                if (hangHoaBLL.themHangHoa(hangHoa)) {
                    JOptionPane.showMessageDialog(this, "Thêm hàng hóa thành công!");
                    loadHangHoa();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm hàng hóa thất bại!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    
    private void saveDoGiaDung() {
        try {
            DoGiaDung_DTO doGiaDung = new DoGiaDung_DTO();
            doGiaDung.setMaHang(Integer.parseInt(txtMa.getText().trim()));
            doGiaDung.setTenHang(txtTen.getText().trim());
            doGiaDung.setDonViTinh(txtDonViTinh.getText().trim());
            doGiaDung.setGiaNhap(Double.parseDouble(txtGiaNhap.getText().trim()));
            doGiaDung.setTinhTrang(txtTinhTrang.getText().trim());
            
            if (isEditing) {
                if (doGiaDungBLL.update(doGiaDung)) {
                    JOptionPane.showMessageDialog(this, "Sửa đồ gia dụng thành công!");
                    loadDoGiaDung();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa đồ gia dụng thất bại!");
                }
            } else {
                if (doGiaDungBLL.insert(doGiaDung)) {
                    JOptionPane.showMessageDialog(this, "Thêm đồ gia dụng thành công!");
                    loadDoGiaDung();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm đồ gia dụng thất bại!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    
    private void saveNhuYeuPham() {
        try {
            NhuYeuPham_DTO nhuYeuPham = new NhuYeuPham_DTO();
            nhuYeuPham.setMaHang(Integer.parseInt(txtMa.getText().trim()));
            nhuYeuPham.setTenHang(txtTen.getText().trim());
            nhuYeuPham.setDonViTinh(txtDonViTinh.getText().trim());
            nhuYeuPham.setGiaNhap(Double.parseDouble(txtGiaNhap.getText().trim()));
            nhuYeuPham.setHanSuDung(new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(txtHanSuDung.getText().trim()).getTime()));
            nhuYeuPham.setNhaCungCap(txtNhaCungCap.getText().trim());
            
            if (isEditing) {
                if (nhuYeuPhamBLL.capNhatNhuYeuPham(nhuYeuPham)) {
                    JOptionPane.showMessageDialog(this, "Sửa nhu yếu phẩm thành công!");
                    loadNhuYeuPham();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa nhu yếu phẩm thất bại!");
                }
            } else {
                if (nhuYeuPhamBLL.themNhuYeuPham(nhuYeuPham)) {
                    JOptionPane.showMessageDialog(this, "Thêm nhu yếu phẩm thành công!");
                    loadNhuYeuPham();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm nhu yếu phẩm thất bại!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    
    private void showSortDialog() {
        String[] options = {"Mã", "Tên", "Giá nhập", "Hạn sử dụng"};
        String selected = (String) JOptionPane.showInputDialog(this,
            "Chọn tiêu chí sắp xếp:",
            "Sắp xếp",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            
        if (selected != null) {
            sortTable(selected);
        }
    }
    
    private void sortTable(String criteria) {
        DefaultTableModel model = getCurrentTableModel();
        if (model == null) return;
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        final int columnIndex;
        
        switch (criteria) {
            case "MA":
                columnIndex = 0;
                break;
            case "TEN":
                columnIndex = 1;
                break;
            case "GIA":
                columnIndex = 3;
                break;
            case "HAN_SU_DUNG":
                columnIndex = 4;
                break;
            default:
                columnIndex = -1;
        }
        
        if (columnIndex != -1) {
            sorter.setSortable(columnIndex, true);
            sorter.setComparator(columnIndex, (o1, o2) -> {
                if (columnIndex == 3) { // Giá
                    return Double.compare(Double.parseDouble(o1.toString()), Double.parseDouble(o2.toString()));
                } else if (columnIndex == 4) { // Hạn sử dụng
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date d1 = sdf.parse(o1.toString());
                        Date d2 = sdf.parse(o2.toString());
                        return d1.compareTo(d2);
                    } catch (Exception e) {
                        return 0;
                    }
                } else {
                    return o1.toString().compareTo(o2.toString());
                }
            });
            getCurrentTable().setRowSorter(sorter);
        }
    }
    
    private void showFilterDialog() {
        String[] options = {"Tất cả", "Còn hàng", "Hết hàng"};
        String selected = (String) JOptionPane.showInputDialog(this,
            "Chọn bộ lọc:",
            "Lọc",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
            
        if (selected != null) {
            filterTable(selected);
        }
    }
    
    private void filterTable(String filter) {
        DefaultTableModel model = getCurrentTableModel();
        if (model == null) return;
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        sorter.setRowFilter(RowFilter.regexFilter(filter));
        getCurrentTable().setRowSorter(sorter);
    }
    
    private DefaultTableModel getCurrentTableModel() {
        switch (currentTab) {
            case "HangHoa":
                return (DefaultTableModel) tableHangHoa.getModel();
            case "DoGiaDung":
                return (DefaultTableModel) tableDoGiaDung.getModel();
            case "NhuYeuPham":
                return (DefaultTableModel) tableNhuYeuPham.getModel();
            default:
                return null;
        }
    }
    
    private JTable getCurrentTable() {
        switch (currentTab) {
            case "HangHoa":
                return tableHangHoa;
            case "DoGiaDung":
                return tableDoGiaDung;
            case "NhuYeuPham":
                return tableNhuYeuPham;
            default:
                return null;
        }
    }
    
    private void showSearchDialog() {
        String keyword = JOptionPane.showInputDialog(this, "Nhập từ khóa tìm kiếm:");
        if (keyword != null && !keyword.trim().isEmpty()) {
            txtTimKiem.setText(keyword);
            timKiem();
        }
    }
    
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this,
            "Phần mềm Quản lý Kho Hàng\n" +
            "Phiên bản 1.0\n" +
            "© 2024 All rights reserved",
            "About",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn file dữ liệu");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Data files (*.dat)", "dat");
        fileChooser.addChoosableFileFilter(filter);
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Xử lý mở file
            updateStatus("Đã mở file: " + file.getName());
        }
    }
    
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu file dữ liệu");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Data files (*.dat)", "dat");
        fileChooser.addChoosableFileFilter(filter);
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".dat")) {
                file = new File(file.getAbsolutePath() + ".dat");
            }
            // Xử lý lưu file
            updateStatus("Đã lưu file: " + file.getName());
        }
    }
    
    private void loadHangHoa() {
        DefaultTableModel model = (DefaultTableModel) tableHangHoa.getModel();
        model.setRowCount(0);
        
        try {
            List<HangHoa_DTO> danhSach = hangHoaBLL.layDanhSachHangHoa();
            for (HangHoa_DTO hh : danhSach) {
                model.addRow(new Object[]{
                    hh.getMaHang(),
                    hh.getTenHang(),
                    hh.getDonViTinh(),
                    hh.getGiaNhap()
                });
            }
            
            updateStatus("Đã tải " + danhSach.size() + " hàng hóa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + e.getMessage());
        }
    }
    
    private void loadDoGiaDung() {
        DefaultTableModel model = (DefaultTableModel) tableDoGiaDung.getModel();
        model.setRowCount(0);
        
        ArrayList<DoGiaDung_DTO> danhSach = doGiaDungBLL.getAll();
        for (DoGiaDung_DTO dgd : danhSach) {
            model.addRow(new Object[]{
                dgd.getMaHang(),
                dgd.getTenHang(),
                dgd.getDonViTinh(),
                dgd.getGiaNhap(),
                dgd.getTinhTrang()
            });
        }
        
        updateStatus("Đã tải " + danhSach.size() + " đồ gia dụng");
    }
    
    private void loadNhuYeuPham() {
        DefaultTableModel model = (DefaultTableModel) tableNhuYeuPham.getModel();
        model.setRowCount(0);
        
        ArrayList<NhuYeuPham_DTO> danhSach = nhuYeuPhamBLL.layTatCaNhuYeuPham();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (NhuYeuPham_DTO nyp : danhSach) {
            model.addRow(new Object[]{
                nyp.getMaHang(),
                nyp.getTenHang(),
                nyp.getDonViTinh(),
                nyp.getGiaNhap(),
                sdf.format(nyp.getHanSuDung()),
                nyp.getNhaCungCap()
            });
        }
        
        updateStatus("Đã tải " + danhSach.size() + " nhu yếu phẩm");
    }
    
    private void showHangHoaDetails(int row) {
        int maHang = (int) tableHangHoa.getValueAt(row, 0);
        try {
            HangHoa_DTO hangHoa = hangHoaBLL.timHangHoaTheoMa(maHang);
            
            if (hangHoa != null) {
                txtMa.setText(String.valueOf(hangHoa.getMaHang()));
                txtTen.setText(hangHoa.getTenHang());
                txtDonViTinh.setText(hangHoa.getDonViTinh());
                txtGiaNhap.setText(String.valueOf(hangHoa.getGiaNhap()));
                txtTinhTrang.setText("");
                txtHanSuDung.setText("");
                txtNhaCungCap.setText("");
                
                updateStatus("Đang xem thông tin hàng hóa: " + hangHoa.getTenHang());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy thông tin: " + e.getMessage());
        }
    }
    
    private void themMoi() {
        isEditing = false;
        clearFields();
        updateStatus("Đang thêm mới");
    }
    
    private void sua() {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa");
            return;
        }
        
        isEditing = true;
        updateStatus("Đang sửa thông tin");
    }
    
    private void xoa() {
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc chắn muốn xóa?", 
            "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            // Xử lý xóa
            updateStatus("Đã xóa thành công");
        }
    }
    
    private void lamMoi() {
        switch (currentTab) {
            case "HangHoa":
                loadHangHoa();
                break;
            case "DoGiaDung":
                loadDoGiaDung();
                break;
            case "NhuYeuPham":
                loadNhuYeuPham();
                break;
        }
        
        updateStatus("Đã làm mới dữ liệu");
    }
    
    private void timKiem() {
        String keyword = txtTimKiem.getText().trim();
        String searchType = (String) cboLoaiTimKiem.getSelectedItem();
        
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm");
            return;
        }
        
        switch (currentTab) {
            case "HangHoa":
                searchHangHoa(keyword, searchType);
                break;
            case "DoGiaDung":
                searchDoGiaDung(keyword, searchType);
                break;
            case "NhuYeuPham":
                searchNhuYeuPham(keyword, searchType);
                break;
        }
        
        updateStatus("Đã tìm kiếm: " + keyword);
    }
    
    private void searchHangHoa(String keyword, String searchType) {
        DefaultTableModel model = (DefaultTableModel) tableHangHoa.getModel();
        model.setRowCount(0);
        
        try {
            List<HangHoa_DTO> danhSach;
            switch (searchType) {
                case "Mã":
                    HangHoa_DTO hangHoa = hangHoaBLL.timKiemTheoMa(String.valueOf(Integer.parseInt(keyword)));
                    danhSach = new ArrayList<>();
                    if (hangHoa != null) {
                        danhSach.add(hangHoa);
                    }
                    break;
                case "Tên":
                    danhSach = hangHoaBLL.timKiemTheoTen(keyword);
                    break;
                default:
                    danhSach = hangHoaBLL.layDanhSachHangHoa();
                    break;
            }
            
            for (HangHoa_DTO hh : danhSach) {
                model.addRow(new Object[]{
                    hh.getMaHang(),
                    hh.getTenHang(),
                    hh.getDonViTinh(),
                    hh.getGiaNhap()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm: " + e.getMessage());
        }
    }
    
    private void searchDoGiaDung(String keyword, String searchType) {
        DefaultTableModel model = (DefaultTableModel) tableDoGiaDung.getModel();
        model.setRowCount(0);
        
        ArrayList<DoGiaDung_DTO> danhSach;
        switch (searchType) {
            case "Mã":
                danhSach = doGiaDungBLL.searchByCode(Integer.parseInt(keyword));
                break;
            case "Tên":
                danhSach = doGiaDungBLL.searchByName(keyword);
                break;
            case "Tình trạng":
                danhSach = doGiaDungBLL.searchByStatus(keyword);
                break;
            default:
                danhSach = doGiaDungBLL.getAll();
                break;
        }
        
        for (DoGiaDung_DTO dgd : danhSach) {
            model.addRow(new Object[]{
                dgd.getMaHang(),
                dgd.getTenHang(),
                dgd.getDonViTinh(),
                dgd.getGiaNhap(),
                dgd.getTinhTrang()
            });
        }
    }
    
    private void searchNhuYeuPham(String keyword, String searchType) {
        DefaultTableModel model = (DefaultTableModel) tableNhuYeuPham.getModel();
        model.setRowCount(0);
        
        ArrayList<NhuYeuPham_DTO> danhSach;
        switch (searchType) {
            case "Mã":
                danhSach = nhuYeuPhamBLL.timKiemTheoMa(Integer.parseInt(keyword));
                break;
            case "Tên":
                danhSach = nhuYeuPhamBLL.timKiemTheoTen(keyword);
                break;
            case "Nhà cung cấp":
                danhSach = nhuYeuPhamBLL.timKiemTheoNhaCungCap(keyword);
                break;
            default:
                danhSach = nhuYeuPhamBLL.layTatCaNhuYeuPham();
                break;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (NhuYeuPham_DTO nyp : danhSach) {
            model.addRow(new Object[]{
                nyp.getMaHang(),
                nyp.getTenHang(),
                nyp.getDonViTinh(),
                nyp.getGiaNhap(),
                sdf.format(nyp.getHanSuDung()),
                nyp.getNhaCungCap()
            });
        }
    }
    
    private void xuatBaoCao() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu báo cáo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF files (*.pdf)", "pdf");
        FileNameExtensionFilter excelFilter = new FileNameExtensionFilter("Excel files (*.xlsx)", "xlsx");
        
        fileChooser.addChoosableFileFilter(pdfFilter);
        fileChooser.addChoosableFileFilter(excelFilter);
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String extension = "";
            
            if (fileChooser.getFileFilter() == pdfFilter) {
                extension = ".pdf";
            } else if (fileChooser.getFileFilter() == excelFilter) {
                extension = ".xlsx";
            }
            
            if (!file.getName().toLowerCase().endsWith(extension)) {
                file = new File(file.getAbsolutePath() + extension);
            }
            
            try {
                if (extension.equals(".pdf")) {
                    exportToPDF(file);
                } else {
                    exportToExcel(file);
                }
                
                JOptionPane.showMessageDialog(this, "Xuất báo cáo thành công!");
                updateStatus("Đã xuất báo cáo: " + file.getName());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xuất báo cáo: " + e.getMessage());
                updateStatus("Lỗi khi xuất báo cáo");
            }
        }
    }
    
    private void exportToPDF(File file) throws Exception {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            // Thêm tiêu đề
            writer.println("BÁO CÁO KHO HÀNG");
            writer.println("=================");
            writer.println();

            // Thêm header
            DefaultTableModel model = (DefaultTableModel) tableHangHoa.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.print(model.getColumnName(i) + "\t");
            }
            writer.println();
            writer.println("--------------------------------------------------");

            // Thêm dữ liệu
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.print(model.getValueAt(i, j) + "\t");
                }
                writer.println();
            }
        }
    }
    
    private void exportToExcel(File file) throws Exception {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            // Thêm header
            DefaultTableModel model = (DefaultTableModel) tableHangHoa.getModel();
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.print(model.getColumnName(i) + ",");
            }
            writer.println();

            // Thêm dữ liệu
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.print(model.getValueAt(i, j) + ",");
                }
                writer.println();
            }
        }
    }
    
    private void in() {
        try {
            tableHangHoa.print();
            updateStatus("Đã in báo cáo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi in: " + e.getMessage());
            updateStatus("Lỗi khi in");
        }
    }
    
    private void clearFields() {
        txtMa.setText("");
        txtTen.setText("");
        txtDonViTinh.setText("");
        txtGiaNhap.setText("");
        txtTinhTrang.setText("");
        txtHanSuDung.setText("");
        txtNhaCungCap.setText("");
    }
    
    private void updateStatus(String message) {
        lblTrangThai.setText(message);
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
