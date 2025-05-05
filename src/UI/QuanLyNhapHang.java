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

public class QuanLyNhapHang extends JFrame {
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
    
    public QuanLyNhapHang(Connection conn) {
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
        btnInPhieu.addActionListener(e -> inPhieuNhap());
        btnThongKe.addActionListener(e -> hienThiThongKe());
        btnBaoCao.addActionListener(e -> taoBaoCao());
        btnRefresh.addActionListener(e -> refreshData());
        btnHelp.addActionListener(e -> hienThiTroGiup());
        
        tblPhieuNhap.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                hienThiChiTietPhieuNhap();
                capNhatThongKe();
            }
        });
        
        txtSoLuong.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { tinhThanhTien(); }
            public void removeUpdate(DocumentEvent e) { tinhThanhTien(); }
            public void insertUpdate(DocumentEvent e) { tinhThanhTien(); }
        });
        
        txtDonGia.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { tinhThanhTien(); }
            public void removeUpdate(DocumentEvent e) { tinhThanhTien(); }
            public void insertUpdate(DocumentEvent e) { tinhThanhTien(); }
        });
        
        cboLocTheoNgay.addActionListener(e -> locTheoNgay());
        txtTuNgay.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { locTheoNgay(); }
            public void removeUpdate(DocumentEvent e) { locTheoNgay(); }
            public void insertUpdate(DocumentEvent e) { locTheoNgay(); }
        });
        
        txtDenNgay.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { locTheoNgay(); }
            public void removeUpdate(DocumentEvent e) { locTheoNgay(); }
            public void insertUpdate(DocumentEvent e) { locTheoNgay(); }
        });
        
        cboNhaCungCap.addActionListener(e -> capNhatThongTinNhaCungCap());
        cboLoaiHang.addActionListener(e -> capNhatThongTinHang());
    }
    
    private void tinhThanhTien() {
        try {
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            double donGia = Double.parseDouble(txtDonGia.getText());
            double thanhTien = soLuong * donGia;
            txtThanhTien.setText(CURRENCY_FORMAT.format(thanhTien));
        } catch (NumberFormatException ex) {
            txtThanhTien.setText("0");
        }
    }
    
    private void themChiTiet() {
        try {
            if (validateChiTietInput()) {
                String maHang = txtMaHang.getText();
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                double donGia = Double.parseDouble(txtDonGia.getText());
                double thanhTien = Double.parseDouble(txtThanhTien.getText().replace(",", ""));
                
                ChiTietPhieuNhap_DTO chiTiet = new ChiTietPhieuNhap_DTO(
                    txtMaPhieuNhap.getText(),
                    maHang,
                    soLuong,
                    donGia,
                    thanhTien
                );
                
                danhSachChiTiet.add(chiTiet);
                updateChiTietTable();
                tinhTongTien();
                
                clearChiTietInput();
                showMessage("Thêm chi tiết thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            showMessage("Vui lòng nhập đúng định dạng số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void xoaChiTiet() {
        int selectedRow = tblChiTiet.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa chi tiết này?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
                
            if (confirm == JOptionPane.YES_OPTION) {
                danhSachChiTiet.remove(selectedRow);
                updateChiTietTable();
                tinhTongTien();
                showMessage("Xóa chi tiết thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            showMessage("Vui lòng chọn chi tiết cần xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void tinhTongTien() {
        double tongTien = 0;
        for (ChiTietPhieuNhap_DTO chiTiet : danhSachChiTiet) {
            tongTien += chiTiet.getThanhTien();
        }
        txtTongTien.setText(CURRENCY_FORMAT.format(tongTien));
    }
    
    private void themPhieuNhap() {
        try {
            if (validateInput()) {
                PhieuNhapHang_DTO phieuNhap = new PhieuNhapHang_DTO(
                    txtMaPhieuNhap.getText(),
                    new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayNhap.getText()),
                    Double.parseDouble(txtTongTien.getText().replace(",", "")),
                    txtMaNhanVien.getText()
                );
                
                if (quanLyNhapHangBLL.themPhieuNhap(phieuNhap, danhSachChiTiet)) {
                    showMessage("Thêm phiếu nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                    clearForm();
                } else {
                    showMessage("Thêm phiếu nhập thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            showMessage("Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void suaPhieuNhap() {
        try {
            if (validateInput()) {
                PhieuNhapHang_DTO phieuNhap = new PhieuNhapHang_DTO(
                    txtMaPhieuNhap.getText(),
                    new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayNhap.getText()),
                    Double.parseDouble(txtTongTien.getText().replace(",", "")),
                    txtMaNhanVien.getText()
                );
                
                if (quanLyNhapHangBLL.capNhatPhieuNhap(phieuNhap, danhSachChiTiet)) {
                    showMessage("Cập nhật phiếu nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                    clearForm();
                } else {
                    showMessage("Cập nhật phiếu nhập thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            showMessage("Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void xoaPhieuNhap() {
        try {
            String maPhieuNhap = txtMaPhieuNhap.getText();
            if (maPhieuNhap.isEmpty()) {
                showMessage("Vui lòng chọn phiếu nhập cần xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa phiếu nhập này?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
                
            if (confirm == JOptionPane.YES_OPTION) {
                if (quanLyNhapHangBLL.xoaPhieuNhap(maPhieuNhap)) {
                    showMessage("Xóa phiếu nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                    clearForm();
                } else {
                    showMessage("Xóa phiếu nhập thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            showMessage("Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInput() {
        if (txtMaPhieuNhap.getText().isEmpty()) {
            showMessage("Vui lòng nhập mã phiếu nhập!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (txtNgayNhap.getText().isEmpty()) {
            showMessage("Vui lòng nhập ngày nhập!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (txtMaNhanVien.getText().isEmpty()) {
            showMessage("Vui lòng nhập mã nhân viên!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (danhSachChiTiet.isEmpty()) {
            showMessage("Vui lòng thêm ít nhất một chi tiết phiếu nhập!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validateChiTietInput() {
        if (txtMaHang.getText().isEmpty()) {
            showMessage("Vui lòng nhập mã hàng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (txtSoLuong.getText().isEmpty()) {
            showMessage("Vui lòng nhập số lượng!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (txtDonGia.getText().isEmpty()) {
            showMessage("Vui lòng nhập đơn giá!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void clearForm() {
        txtMaPhieuNhap.setText("");
        txtNgayNhap.setText("");
        txtMaNhanVien.setText("");
        txtTongTien.setText("");
        clearChiTietInput();
        danhSachChiTiet.clear();
        updateChiTietTable();
    }
    
    private void clearChiTietInput() {
        txtMaHang.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtThanhTien.setText("");
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
    
    private void timKiem() {
        String tuKhoa = txtTimKiem.getText().trim();
        String loaiTimKiem = (String) cboTimKiem.getSelectedItem();
        
        if (tuKhoa.isEmpty()) {
            showMessage("Vui lòng nhập từ khóa tìm kiếm!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            List<PhieuNhapHang_DTO> ketQua = quanLyNhapHangBLL.timKiemPhieuNhap(tuKhoa, loaiTimKiem);
            if (ketQua.isEmpty()) {
                showMessage("Không tìm thấy kết quả phù hợp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                hienThiDanhSachPhieuNhap(ketQua);
            }
        } catch (SQLException ex) {
            showMessage("Lỗi khi tìm kiếm: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void xuatExcel() {
        // Implement export to Excel functionality
    }
    
    private void inPhieuNhap() {
        // Implement print functionality
    }
    
    private void hienThiThongKe() {
        JDialog dialog = new JDialog(this, "Thống kê chi tiết", true);
        dialog.setSize(600, 400);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create chart panel
        JPanel chartPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        // Add charts here using JFreeChart or other charting library
        
        // Create statistics panel
        JPanel statsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        statsPanel.add(createStatisticLabel("Tổng số phiếu: " + quanLyNhapHangBLL.demTongSoPhieuNhap()));
        statsPanel.add(createStatisticLabel("Tổng tiền nhập: " + CURRENCY_FORMAT.format(quanLyNhapHangBLL.tinhTongTienNhap()) + " VNĐ"));
        statsPanel.add(createStatisticLabel("Số mặt hàng: " + quanLyNhapHangBLL.demSoMatHang()));
        statsPanel.add(createStatisticLabel("Phiếu cao nhất: " + CURRENCY_FORMAT.format(quanLyNhapHangBLL.timPhieuNhapCaoNhat()) + " VNĐ"));
        
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.add(statsPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void taoBaoCao() {
        JDialog dialog = new JDialog(this, "Tạo báo cáo", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add report options
        JCheckBox chkPhieuNhap = new JCheckBox("Báo cáo phiếu nhập");
        JCheckBox chkChiTiet = new JCheckBox("Báo cáo chi tiết");
        JCheckBox chkThongKe = new JCheckBox("Báo cáo thống kê");
        
        JButton btnTaoBaoCao = new JButton("Tạo báo cáo");
        btnTaoBaoCao.addActionListener(e -> {
            // Implement report generation
            dialog.dispose();
        });
        
        panel.add(chkPhieuNhap);
        panel.add(chkChiTiet);
        panel.add(chkThongKe);
        panel.add(btnTaoBaoCao);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void hienThiTroGiup() {
        JDialog dialog = new JDialog(this, "Trợ giúp", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JTextArea helpText = new JTextArea();
        helpText.setEditable(false);
        helpText.setFont(NORMAL_FONT);
        helpText.setText(
            "Hướng dẫn sử dụng:\n\n" +
            "1. Thêm phiếu nhập:\n" +
            "   - Nhập thông tin phiếu nhập\n" +
            "   - Thêm chi tiết phiếu nhập\n" +
            "   - Nhấn nút 'Thêm'\n\n" +
            "2. Sửa phiếu nhập:\n" +
            "   - Chọn phiếu nhập cần sửa\n" +
            "   - Sửa thông tin\n" +
            "   - Nhấn nút 'Sửa'\n\n" +
            "3. Xóa phiếu nhập:\n" +
            "   - Chọn phiếu nhập cần xóa\n" +
            "   - Nhấn nút 'Xóa'\n\n" +
            "4. Tìm kiếm:\n" +
            "   - Nhập từ khóa\n" +
            "   - Chọn loại tìm kiếm\n" +
            "   - Nhấn nút 'Tìm kiếm'\n\n" +
            "5. Xuất Excel:\n" +
            "   - Nhấn nút 'Xuất Excel'\n" +
            "   - Chọn nơi lưu file\n\n" +
            "6. In phiếu:\n" +
            "   - Chọn phiếu cần in\n" +
            "   - Nhấn nút 'In phiếu'"
        );
        
        JScrollPane scrollPane = new JScrollPane(helpText);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void locTheoNgay() {
        try {
            String selectedOption = (String) cboLocTheoNgay.getSelectedItem();
            Date tuNgay = null;
            Date denNgay = null;
            
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            
            switch (selectedOption) {
                case "Hôm nay":
                    tuNgay = cal.getTime();
                    denNgay = cal.getTime();
                    break;
                    
                case "Tuần này":
                    cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
                    tuNgay = cal.getTime();
                    cal.add(Calendar.DAY_OF_WEEK, 6);
                    denNgay = cal.getTime();
                    break;
                    
                case "Tháng này":
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    tuNgay = cal.getTime();
                    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                    denNgay = cal.getTime();
                    break;
                    
                case "Tùy chọn":
                    if (!txtTuNgay.getText().isEmpty() && !txtDenNgay.getText().isEmpty()) {
                        tuNgay = DATE_FORMAT.parse(txtTuNgay.getText());
                        denNgay = DATE_FORMAT.parse(txtDenNgay.getText());
                    }
                    break;
            }
            
            if (tuNgay != null && denNgay != null) {
                List<PhieuNhapHang_DTO> danhSachLoc = quanLyNhapHangBLL.locPhieuNhapTheoNgay(tuNgay, denNgay);
                hienThiDanhSachPhieuNhap(danhSachLoc);
            }
            
        } catch (Exception ex) {
            showMessage("Lỗi khi lọc dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void capNhatThongKe() {
        try {
            int tongSoPhieu = quanLyNhapHangBLL.demTongSoPhieuNhap();
            double tongTienNhap = quanLyNhapHangBLL.tinhTongTienNhap();
            int soMatHang = quanLyNhapHangBLL.demSoMatHang();
            double phieuCaoNhat = quanLyNhapHangBLL.timPhieuNhapCaoNhat();
            
            lblTongSoPhieu.setText("Tổng số phiếu: " + tongSoPhieu);
            lblTongTienNhap.setText("Tổng tiền nhập: " + CURRENCY_FORMAT.format(tongTienNhap) + " VNĐ");
            lblSoMatHang.setText("Số mặt hàng: " + soMatHang);
            lblPhieuCaoNhat.setText("Phiếu cao nhất: " + CURRENCY_FORMAT.format(phieuCaoNhat) + " VNĐ");
            
        } catch (SQLException ex) {
            showMessage("Lỗi khi cập nhật thống kê: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void refreshData() {
        loadData();
        capNhatThongKe();
        clearForm();
        showMessage("Đã làm mới dữ liệu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }
    
    private void loadComboBoxData() {
        try {
            // Load NhaCungCap data
            danhSachNhaCungCap = quanLyNhapHangBLL.layDanhSachNhaCungCap();
            cboNhaCungCap.removeAllItems();
            for (Map.Entry<String, String> entry : danhSachNhaCungCap.entrySet()) {
                cboNhaCungCap.addItem(entry.getValue());
            }
            
            // Load LoaiHang data
            danhSachLoaiHang = quanLyNhapHangBLL.layDanhSachLoaiHang();
            cboLoaiHang.removeAllItems();
            for (Map.Entry<String, String> entry : danhSachLoaiHang.entrySet()) {
                cboLoaiHang.addItem(entry.getValue());
            }
            
        } catch (SQLException ex) {
            showMessage("Lỗi khi tải dữ liệu combobox: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void capNhatThongTinNhaCungCap() {
        String selectedNhaCungCap = (String) cboNhaCungCap.getSelectedItem();
        if (selectedNhaCungCap != null) {
            // Update supplier information
            try {
                Map<String, String> thongTinNhaCungCap = quanLyNhapHangBLL.layThongTinNhaCungCap(selectedNhaCungCap);
                if (thongTinNhaCungCap != null) {
                    // Update UI with supplier information
                    // Add code here to update supplier details
                }
            } catch (SQLException ex) {
                showMessage("Lỗi khi cập nhật thông tin nhà cung cấp: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void capNhatThongTinHang() {
        String selectedLoaiHang = (String) cboLoaiHang.getSelectedItem();
        if (selectedLoaiHang != null) {
            // Update product information
            try {
                Map<String, String> thongTinHang = quanLyNhapHangBLL.layThongTinHang(selectedLoaiHang);
                if (thongTinHang != null) {
                    txtMaHang.setText(thongTinHang.get("maHang"));
                    txtTenHang.setText(thongTinHang.get("tenHang"));
                    txtDonGia.setText(thongTinHang.get("donGia"));
                }
            } catch (SQLException ex) {
                showMessage("Lỗi khi cập nhật thông tin hàng: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private boolean isValidDate(String dateStr) {
        try {
            Date date = DATE_FORMAT.parse(dateStr);
            return date != null;
        } catch (Exception ex) {
            return false;
        }
    }
    
    private boolean isValidNumber(String numberStr) {
        try {
            double number = Double.parseDouble(numberStr);
            return number > 0;
        } catch (NumberFormatException ex) {
            return false;
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
