package UI;

import BLL.QuanLyNhapHangBLL;
import DTO.PhieuNhapHang_DTO;
import DTO.ChiTietPhieuNhap_DTO;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import javax.swing.event.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.print.*;
import java.text.MessageFormat;

public class QuanLyNhapHang extends javax.swing.JFrame {
    // Constants
    private static final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private static final Color SECONDARY_COLOR = new Color(52, 152, 219);
    private static final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private static final Color TEXT_COLOR = new Color(44, 62, 80);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color ERROR_COLOR = new Color(231, 76, 60);
    
    private static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    private static final Font HEADER_FONT = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font NORMAL_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font SMALL_FONT = new Font("Segoe UI", Font.PLAIN, 12);
    
    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#,##0.00");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    // Main panels
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JPanel footerPanel;
    private JPanel sidebarPanel;
    
    // Input panels
    private JPanel phieuNhapPanel;
    private JPanel chiTietPanel;
    private JPanel buttonPanel;
    private JPanel searchPanel;
    private JPanel filterPanel;
    private JPanel reportPanel;
    
    // Table panels
    private JPanel tableContainerPanel;
    private JPanel phieuNhapTablePanel;
    private JPanel chiTietTablePanel;
    private JPanel statisticsPanel;
    
    // Components for PhieuNhap input
    private JTextField txtMaPhieuNhap;
    private JTextField txtNgayNhap;
    private JTextField txtMaNhanVien;
    private JTextField txtTongTien;
    private JComboBox<String> cboNhaCungCap;
    private JTextArea txtGhiChu;
    
    // Components for ChiTietPhieuNhap input
    private JTextField txtMaHang;
    private JTextField txtSoLuong;
    private JTextField txtDonGia;
    private JTextField txtThanhTien;
    private JComboBox<String> cboLoaiHang;
    private JTextField txtTenHang;
    
    // Buttons
    private JButton btnThem;
    private JButton btnSua;
    private JButton btnXoa;
    private JButton btnClear;
    private JButton btnThemChiTiet;
    private JButton btnXoaChiTiet;
    private JButton btnTimKiem;
    private JButton btnXuatExcel;
    private JButton btnInPhieu;
    private JButton btnThongKe;
    private JButton btnBaoCao;
    private JButton btnRefresh;
    private JButton btnHelp;
    private JButton btnThoat;
    
    // Tables
    private JTable tblPhieuNhap;
    private JTable tblChiTiet;
    private DefaultTableModel modelPhieuNhap;
    private DefaultTableModel modelChiTiet;
    
    // Search components
    private JTextField txtTimKiem;
    private JComboBox<String> cboTimKiem;
    private JComboBox<String> cboLocTheoNgay;
    private JTextField txtTuNgay;
    private JTextField txtDenNgay;
    
    // Statistics components
    private JLabel lblTongSoPhieu;
    private JLabel lblTongTienNhap;
    private JLabel lblSoMatHang;
    private JLabel lblPhieuCaoNhat;
    
    // Business Logic
    private QuanLyNhapHangBLL quanLyNhapHangBLL;
    private List<ChiTietPhieuNhap_DTO> danhSachChiTiet;
    private Map<String, String> danhSachNhaCungCap;
    private Map<String, String> danhSachLoaiHang;
    
    // Status bar
    private JLabel lblStatus;
    private JProgressBar progressBar;
    
    private Connection conn;
    
    public QuanLyNhapHang(Connection conn) {
        this.conn = conn;
        quanLyNhapHangBLL = new QuanLyNhapHangBLL(conn);
        danhSachChiTiet = new ArrayList<>();
        danhSachNhaCungCap = new HashMap<>();
        danhSachLoaiHang = new HashMap<>();
        
        setTitle("Quản Lý Phiếu Nhập Hàng");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        customizeComponents();
        addEventListeners();
        loadData();
        loadComboBoxData();
    }
    
    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        
        // Header Panel
        headerPanel = createHeaderPanel();
        
        // Sidebar Panel
        sidebarPanel = createSidebarPanel();
        
        // Content Panel
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);
        
        // Input Panels
        phieuNhapPanel = createPhieuNhapPanel();
        chiTietPanel = createChiTietPanel();
        buttonPanel = createButtonPanel();
        searchPanel = createSearchPanel();
        filterPanel = createFilterPanel();
        reportPanel = createReportPanel();
        
        // Table Panels
        tableContainerPanel = createTableContainerPanel();
        statisticsPanel = createStatisticsPanel();
        
        // Add panels to content
        JPanel inputContainer = new JPanel(new BorderLayout());
        inputContainer.add(phieuNhapPanel, BorderLayout.NORTH);
        inputContainer.add(chiTietPanel, BorderLayout.CENTER);
        inputContainer.add(buttonPanel, BorderLayout.SOUTH);
        
        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(searchPanel, BorderLayout.NORTH);
        topContainer.add(filterPanel, BorderLayout.CENTER);
        
        contentPanel.add(topContainer, BorderLayout.NORTH);
        contentPanel.add(inputContainer, BorderLayout.CENTER);
        contentPanel.add(tableContainerPanel, BorderLayout.SOUTH);
        
        // Footer Panel
        footerPanel = createFooterPanel();
        
        // Add all panels to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(sidebarPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(PRIMARY_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel lblTitle = new JLabel("QUẢN LÝ PHIẾU NHẬP HÀNG");
        lblTitle.setFont(TITLE_FONT);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel.add(lblTitle, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createSidebarPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(PRIMARY_COLOR);
        panel.setPreferredSize(new Dimension(200, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        
        // Add menu buttons
        JButton btnTrangChu = createSidebarButton("Trang chủ", "home.png");
        JButton btnPhieuNhap = createSidebarButton("Phiếu nhập", "import.png");
        JButton btnNhaCungCap = createSidebarButton("Nhà cung cấp", "supplier.png");
        JButton btnHangHoa = createSidebarButton("Hàng hóa", "product.png");
        JButton btnBaoCao = createSidebarButton("Báo cáo", "report.png");
        JButton btnCaiDat = createSidebarButton("Cài đặt", "settings.png");
        
        panel.add(btnTrangChu);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnPhieuNhap);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnNhaCungCap);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnHangHoa);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnBaoCao);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnCaiDat);
        panel.add(Box.createVerticalGlue());
        
        return panel;
    }
    
    private JButton createSidebarButton(String text, String iconName) {
        JButton button = new JButton(text);
        button.setFont(NORMAL_FONT);
        button.setForeground(Color.WHITE);
        button.setBackground(PRIMARY_COLOR);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(180, 40));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(SECONDARY_COLOR);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(PRIMARY_COLOR);
            }
        });
        
        return button;
    }
    
    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JLabel lblTimKiem = new JLabel("Tìm kiếm:");
        lblTimKiem.setFont(NORMAL_FONT);
        
        txtTimKiem = new JTextField(20);
        txtTimKiem.setFont(NORMAL_FONT);
        
        String[] timKiemOptions = {"Mã phiếu", "Nhân viên", "Nhà cung cấp", "Mã hàng"};
        cboTimKiem = new JComboBox<>(timKiemOptions);
        cboTimKiem.setFont(NORMAL_FONT);
        
        btnTimKiem = createButton("Tìm kiếm", "search.png");
        btnRefresh = createButton("Làm mới", "refresh.png");
        
        panel.add(lblTimKiem);
        panel.add(txtTimKiem);
        panel.add(cboTimKiem);
        panel.add(btnTimKiem);
        panel.add(btnRefresh);
        
        return panel;
    }
    
    private JPanel createFilterPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JLabel lblLocTheoNgay = new JLabel("Lọc theo ngày:");
        lblLocTheoNgay.setFont(NORMAL_FONT);
        
        String[] ngayOptions = {"Hôm nay", "Tuần này", "Tháng này", "Tùy chọn"};
        cboLocTheoNgay = new JComboBox<>(ngayOptions);
        cboLocTheoNgay.setFont(NORMAL_FONT);
        
        JLabel lblTuNgay = new JLabel("Từ ngày:");
        lblTuNgay.setFont(NORMAL_FONT);
        txtTuNgay = new JTextField(10);
        txtTuNgay.setFont(NORMAL_FONT);
        
        JLabel lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setFont(NORMAL_FONT);
        txtDenNgay = new JTextField(10);
        txtDenNgay.setFont(NORMAL_FONT);
        
        panel.add(lblLocTheoNgay);
        panel.add(cboLocTheoNgay);
        panel.add(lblTuNgay);
        panel.add(txtTuNgay);
        panel.add(lblDenNgay);
        panel.add(txtDenNgay);
        
        return panel;
    }
    
    private JPanel createReportPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR),
            "Thống kê",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            HEADER_FONT,
            PRIMARY_COLOR
        ));
        
        // Create statistics labels
        lblTongSoPhieu = createStatisticLabel("Tổng số phiếu: 0");
        lblTongTienNhap = createStatisticLabel("Tổng tiền nhập: 0 VNĐ");
        lblSoMatHang = createStatisticLabel("Số mặt hàng: 0");
        lblPhieuCaoNhat = createStatisticLabel("Phiếu cao nhất: 0 VNĐ");
        
        panel.add(lblTongSoPhieu);
        panel.add(lblTongTienNhap);
        panel.add(lblSoMatHang);
        panel.add(lblPhieuCaoNhat);
        
        return panel;
    }
    
    private JLabel createStatisticLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(HEADER_FONT);
        label.setForeground(TEXT_COLOR);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }
    
    private JPanel createPhieuNhapPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR),
            "Thông tin phiếu nhập",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            HEADER_FONT,
            PRIMARY_COLOR
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Add components
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(createLabel("Mã phiếu nhập:"), gbc);
        gbc.gridx = 1;
        txtMaPhieuNhap = createTextField();
        panel.add(txtMaPhieuNhap, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(createLabel("Ngày nhập:"), gbc);
        gbc.gridx = 1;
        txtNgayNhap = createTextField();
        panel.add(txtNgayNhap, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(createLabel("Mã nhân viên:"), gbc);
        gbc.gridx = 1;
        txtMaNhanVien = createTextField();
        panel.add(txtMaNhanVien, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(createLabel("Tổng tiền:"), gbc);
        gbc.gridx = 1;
        txtTongTien = createTextField();
        txtTongTien.setEditable(false);
        panel.add(txtTongTien, gbc);
        
        return panel;
    }
    
    private JPanel createChiTietPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR),
            "Chi tiết phiếu nhập",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            HEADER_FONT,
            PRIMARY_COLOR
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Add components
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(createLabel("Mã hàng:"), gbc);
        gbc.gridx = 1;
        txtMaHang = createTextField();
        panel.add(txtMaHang, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(createLabel("Số lượng:"), gbc);
        gbc.gridx = 1;
        txtSoLuong = createTextField();
        panel.add(txtSoLuong, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(createLabel("Đơn giá:"), gbc);
        gbc.gridx = 1;
        txtDonGia = createTextField();
        panel.add(txtDonGia, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(createLabel("Thành tiền:"), gbc);
        gbc.gridx = 1;
        txtThanhTien = createTextField();
        txtThanhTien.setEditable(false);
        panel.add(txtThanhTien, gbc);
        
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(BACKGROUND_COLOR);
        
        btnThem = createButton("Thêm", "add.png");
        btnSua = createButton("Sửa", "edit.png");
        btnXoa = createButton("Xóa", "delete.png");
        btnClear = createButton("Clear", "clear.png");
        btnThemChiTiet = createButton("Thêm chi tiết", "add_detail.png");
        btnXoaChiTiet = createButton("Xóa chi tiết", "delete_detail.png");
        btnTimKiem = createButton("Tìm kiếm", "search.png");
        btnXuatExcel = createButton("Xuất Excel", "excel.png");
        btnInPhieu = createButton("In phiếu", "print.png");
        btnThongKe = createButton("Thống kê", "statistics.png");
        btnBaoCao = createButton("Báo cáo", "report.png");
        btnRefresh = createButton("Làm mới", "refresh.png");
        btnHelp = createButton("Trợ giúp", "help.png");
        btnThoat = createButton("Thoát", "exit.png");
        
        panel.add(btnThem);
        panel.add(btnSua);
        panel.add(btnXoa);
        panel.add(btnClear);
        panel.add(btnThemChiTiet);
        panel.add(btnXoaChiTiet);
        panel.add(btnTimKiem);
        panel.add(btnXuatExcel);
        panel.add(btnInPhieu);
        panel.add(btnThongKe);
        panel.add(btnBaoCao);
        panel.add(btnRefresh);
        panel.add(btnHelp);
        panel.add(btnThoat);
        
        return panel;
    }
    
    private JPanel createTableContainerPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBackground(BACKGROUND_COLOR);
        
        // PhieuNhap Table
        String[] phieuNhapColumns = {"Mã phiếu nhập", "Ngày nhập", "Mã nhân viên", "Tổng tiền"};
        modelPhieuNhap = new DefaultTableModel(phieuNhapColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPhieuNhap = createTable(modelPhieuNhap);
        JScrollPane scrollPhieuNhap = new JScrollPane(tblPhieuNhap);
        scrollPhieuNhap.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR),
            "Danh sách phiếu nhập",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            HEADER_FONT,
            PRIMARY_COLOR
        ));
        
        // ChiTiet Table
        String[] chiTietColumns = {"Mã phiếu nhập", "Mã hàng", "Số lượng", "Đơn giá", "Thành tiền"};
        modelChiTiet = new DefaultTableModel(chiTietColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblChiTiet = createTable(modelChiTiet);
        JScrollPane scrollChiTiet = new JScrollPane(tblChiTiet);
        scrollChiTiet.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(PRIMARY_COLOR),
            "Chi tiết phiếu nhập",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            HEADER_FONT,
            PRIMARY_COLOR
        ));
        
        panel.add(scrollPhieuNhap);
        panel.add(scrollChiTiet);
        
        return panel;
    }
    
    private JPanel createFooterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(PRIMARY_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        lblStatus = new JLabel("Sẵn sàng");
        lblStatus.setFont(NORMAL_FONT);
        lblStatus.setForeground(Color.WHITE);
        
        panel.add(lblStatus, BorderLayout.WEST);
        
        return panel;
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(NORMAL_FONT);
        label.setForeground(TEXT_COLOR);
        return label;
    }
    
    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(NORMAL_FONT);
        return textField;
    }
    
    private JButton createButton(String text, String iconName) {
        JButton button = new JButton(text);
        button.setFont(NORMAL_FONT);
        button.setBackground(SECONDARY_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(PRIMARY_COLOR);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(SECONDARY_COLOR);
            }
        });
        
        return button;
    }
    
    private JTable createTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setFont(NORMAL_FONT);
        table.setRowHeight(25);
        table.setSelectionBackground(PRIMARY_COLOR);
        table.setSelectionForeground(Color.WHITE);
        table.setGridColor(SECONDARY_COLOR);
        
        // Customize header
        JTableHeader header = table.getTableHeader();
        header.setFont(HEADER_FONT);
        header.setBackground(PRIMARY_COLOR);
        header.setForeground(Color.WHITE);
        
        return table;
    }
    
    private void customizeComponents() {
        // Add any additional customization here
    }
    
    private void addEventListeners() {
        btnThem.addActionListener(e -> themPhieuNhap());
        btnSua.addActionListener(e -> suaPhieuNhap());
        btnXoa.addActionListener(e -> xoaPhieuNhap());
        btnClear.addActionListener(e -> clearForm());
        btnThemChiTiet.addActionListener(e -> themChiTiet());
        btnXoaChiTiet.addActionListener(e -> xoaChiTiet());
        btnTimKiem.addActionListener(e -> timKiem());
        btnXuatExcel.addActionListener(e -> xuatExcel());
        btnInPhieu.addActionListener(e -> inPhieu());
        btnThongKe.addActionListener(e -> thongKe());
        btnBaoCao.addActionListener(e -> baoCao());
        btnRefresh.addActionListener(e -> refresh());
        btnHelp.addActionListener(e -> hienThiTroGiup());
        btnThoat.addActionListener(e -> {
            dispose();
            new QuanLiPhong(conn).setVisible(true);
        });
        
        tblPhieuNhap.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                hienThiChiTietPhieuNhap();
            }
        });
    }
    
    private void themPhieuNhap() {
        try {
            String maPhieuNhap = txtMaPhieuNhap.getText();
            Date ngayNhap = ((JDateChooser)txtNgayNhap.getDateEditor().getUiComponent()).getDate();
            String maNhanVien = txtMaNhanVien.getText();
            
            if (maPhieuNhap.isEmpty() || ngayNhap == null || maNhanVien.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                return;
            }
            
            PhieuNhapHang_DTO phieuNhap = new PhieuNhapHang_DTO(maPhieuNhap, ngayNhap, 0, maNhanVien);
            quanLyNhapHangBLL.themPhieuNhap(phieuNhap);
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void suaPhieuNhap() {
        try {
            int row = tblPhieuNhap.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập cần sửa!");
                return;
            }
            
            String maPhieuNhap = txtMaPhieuNhap.getText();
            Date ngayNhap = ((JDateChooser)txtNgayNhap.getDateEditor().getUiComponent()).getDate();
            String maNhanVien = txtMaNhanVien.getText();
            
            if (maPhieuNhap.isEmpty() || ngayNhap == null || maNhanVien.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                return;
            }
            
            PhieuNhapHang_DTO phieuNhap = new PhieuNhapHang_DTO(maPhieuNhap, ngayNhap, 0, maNhanVien);
            quanLyNhapHangBLL.suaPhieuNhap(phieuNhap);
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(this, "Sửa phiếu nhập thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void xoaPhieuNhap() {
        try {
            int row = tblPhieuNhap.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập cần xóa!");
                return;
            }
            
            String maPhieuNhap = tblPhieuNhap.getValueAt(row, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa phiếu nhập này?", 
                "Xác nhận xóa", 
                JOptionPane.YES_NO_OPTION);
                
            if (confirm == JOptionPane.YES_OPTION) {
                quanLyNhapHangBLL.xoaPhieuNhap(maPhieuNhap);
                loadData();
                clearForm();
                JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thành công!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void clearForm() {
        txtMaPhieuNhap.setText("");
        txtNgayNhap.setDate(null);
        txtMaNhanVien.setText("");
        txtTongTien.setText("");
        modelChiTiet.setRowCount(0);
    }
    
    private void themChiTiet() {
        try {
            int row = tblPhieuNhap.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập!");
                return;
            }
            
            String maPhieuNhap = txtMaPhieuNhap.getText();
            String maHang = cboMaHang.getSelectedItem().toString();
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            double donGia = Double.parseDouble(txtDonGia.getText());
            
            if (maHang.isEmpty() || soLuong <= 0 || donGia <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin chi tiết!");
                return;
            }
            
            ChiTietPhieuNhap_DTO chiTiet = new ChiTietPhieuNhap_DTO(maPhieuNhap, maHang, soLuong, donGia);
            quanLyNhapHangBLL.themChiTietPhieuNhap(chiTiet);
            hienThiChiTietPhieuNhap();
            JOptionPane.showMessageDialog(this, "Thêm chi tiết thành công!");
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void xoaChiTiet() {
        try {
            int row = tblChiTiet.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết cần xóa!");
                return;
            }
            
            String maPhieuNhap = txtMaPhieuNhap.getText();
            String maHang = tblChiTiet.getValueAt(row, 0).toString();
            
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa chi tiết này?", 
                "Xác nhận xóa", 
                JOptionPane.YES_NO_OPTION);
                
            if (confirm == JOptionPane.YES_OPTION) {
                quanLyNhapHangBLL.xoaChiTietPhieuNhap(maPhieuNhap, maHang);
                hienThiChiTietPhieuNhap();
                JOptionPane.showMessageDialog(this, "Xóa chi tiết thành công!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void timKiem() {
        String tuKhoa = txtTimKiem.getText();
        String loaiTimKiem = cboLoaiTimKiem.getSelectedItem().toString();
        
        try {
            List<PhieuNhapHang_DTO> danhSach = quanLyNhapHangBLL.timKiemPhieuNhap(tuKhoa, loaiTimKiem);
            hienThiDanhSachPhieuNhap(danhSach);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void xuatExcel() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));
            
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }
                
                quanLyNhapHangBLL.xuatExcel(filePath);
                JOptionPane.showMessageDialog(this, "Xuất Excel thành công!");
            }
        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void inPhieu() {
        try {
            int row = tblPhieuNhap.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập cần in!");
                return;
            }
            
            String maPhieuNhap = tblPhieuNhap.getValueAt(row, 0).toString();
            quanLyNhapHangBLL.inPhieuNhap(maPhieuNhap);
        } catch (SQLException | PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void thongKe() {
        try {
            Map<String, Object> thongKe = quanLyNhapHangBLL.thongKe();
            StringBuilder sb = new StringBuilder();
            sb.append("Thống kê phiếu nhập:\n\n");
            sb.append("Tổng số phiếu nhập: ").append(thongKe.get("tongSoPhieuNhap")).append("\n");
            sb.append("Tổng tiền nhập: ").append(String.format("%,.2f", thongKe.get("tongTienNhap"))).append(" VNĐ\n");
            sb.append("Số mặt hàng: ").append(thongKe.get("soMatHang")).append("\n");
            sb.append("Phiếu nhập cao nhất: ").append(thongKe.get("phieuNhapCaoNhat")).append("\n");
            
            JOptionPane.showMessageDialog(this, sb.toString(), "Thống kê", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void baoCao() {
        try {
            Date tuNgay = ((JDateChooser)txtTuNgay.getDateEditor().getUiComponent()).getDate();
            Date denNgay = ((JDateChooser)txtDenNgay.getDateEditor().getUiComponent()).getDate();
            
            if (tuNgay == null || denNgay == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn khoảng thời gian!");
                return;
            }
            
            List<PhieuNhapHang_DTO> danhSach = quanLyNhapHangBLL.locPhieuNhapTheoNgay(tuNgay, denNgay);
            hienThiDanhSachPhieuNhap(danhSach);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
    
    private void refresh() {
        loadData();
        clearForm();
    }
    
    private void hienThiTroGiup() {
        String help = "Hướng dẫn sử dụng:\n\n" +
            "1. Thêm phiếu nhập: Nhập thông tin và nhấn nút Thêm\n" +
            "2. Sửa phiếu nhập: Chọn phiếu cần sửa, sửa thông tin và nhấn nút Sửa\n" +
            "3. Xóa phiếu nhập: Chọn phiếu cần xóa và nhấn nút Xóa\n" +
            "4. Thêm chi tiết: Chọn phiếu nhập, nhập thông tin chi tiết và nhấn nút Thêm chi tiết\n" +
            "5. Xóa chi tiết: Chọn chi tiết cần xóa và nhấn nút Xóa chi tiết\n" +
            "6. Tìm kiếm: Nhập từ khóa và chọn loại tìm kiếm\n" +
            "7. Xuất Excel: Chọn nơi lưu file Excel\n" +
            "8. In phiếu: Chọn phiếu cần in và nhấn nút In phiếu\n" +
            "9. Thống kê: Xem thống kê tổng quan\n" +
            "10. Báo cáo: Chọn khoảng thời gian để xem báo cáo\n" +
            "11. Làm mới: Cập nhật lại dữ liệu\n" +
            "12. Thoát: Quay lại màn hình chính";
            
        JOptionPane.showMessageDialog(this, help, "Trợ giúp", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void loadData() {
        try {
            // Load PhieuNhap table
            modelPhieuNhap.setRowCount(0);
            List<PhieuNhapHang_DTO> danhSachPhieuNhap = quanLyNhapHangBLL.layDanhSachPhieuNhap();
            for (PhieuNhapHang_DTO phieuNhap : danhSachPhieuNhap) {
                modelPhieuNhap.addRow(new Object[]{
                    phieuNhap.getMaPhieuNhap(),
                    new SimpleDateFormat("dd/MM/yyyy").format(phieuNhap.getNgayNhap()),
                    phieuNhap.getMaNhanVien(),
                    CURRENCY_FORMAT.format(phieuNhap.getTongTien())
                });
            }
            
            // Clear ChiTiet table
            modelChiTiet.setRowCount(0);
            
        } catch (SQLException ex) {
            showMessage("Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void hienThiChiTietPhieuNhap() {
        try {
            int selectedRow = tblPhieuNhap.getSelectedRow();
            if (selectedRow >= 0) {
                String maPhieuNhap = (String) tblPhieuNhap.getValueAt(selectedRow, 0);
                
                // Load PhieuNhap details
                PhieuNhapHang_DTO phieuNhap = quanLyNhapHangBLL.layPhieuNhapTheoMa(maPhieuNhap);
                if (phieuNhap != null) {
                    txtMaPhieuNhap.setText(phieuNhap.getMaPhieuNhap());
                    txtNgayNhap.setText(new SimpleDateFormat("dd/MM/yyyy").format(phieuNhap.getNgayNhap()));
                    txtMaNhanVien.setText(phieuNhap.getMaNhanVien());
                    txtTongTien.setText(CURRENCY_FORMAT.format(phieuNhap.getTongTien()));
                }
                
                // Load ChiTiet table
                modelChiTiet.setRowCount(0);
                danhSachChiTiet = quanLyNhapHangBLL.layDanhSachChiTietPhieuNhap(maPhieuNhap);
                for (ChiTietPhieuNhap_DTO chiTiet : danhSachChiTiet) {
                    modelChiTiet.addRow(new Object[]{
                        chiTiet.getMaPhieuNhap(),
                        chiTiet.getMaHang(),
                        chiTiet.getSoLuong(),
                        CURRENCY_FORMAT.format(chiTiet.getDonGia()),
                        CURRENCY_FORMAT.format(chiTiet.getThanhTien())
                    });
                }
            }
        } catch (SQLException ex) {
            showMessage("Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateChiTietTable() {
        modelChiTiet.setRowCount(0);
        for (ChiTietPhieuNhap_DTO chiTiet : danhSachChiTiet) {
            modelChiTiet.addRow(new Object[]{
                chiTiet.getMaPhieuNhap(),
                chiTiet.getMaHang(),
                chiTiet.getSoLuong(),
                CURRENCY_FORMAT.format(chiTiet.getDonGia()),
                CURRENCY_FORMAT.format(chiTiet.getThanhTien())
            });
        }
    }
    
    private void hienThiDanhSachPhieuNhap(List<PhieuNhapHang_DTO> danhSach) {
        modelPhieuNhap.setRowCount(0);
        for (PhieuNhapHang_DTO phieuNhap : danhSach) {
            modelPhieuNhap.addRow(new Object[]{
                phieuNhap.getMaPhieuNhap(),
                DATE_FORMAT.format(phieuNhap.getNgayNhap()),
                phieuNhap.getMaNhanVien(),
                CURRENCY_FORMAT.format(phieuNhap.getTongTien())
            });
        }
    }
} 
