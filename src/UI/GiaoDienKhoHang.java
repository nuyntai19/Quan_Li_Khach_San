package UI;

import BLL.QuanLyHangHoaBLL;
import DTO.DoGiaDung_DTO;
import DTO.NhuYeuPham_DTO;
import java.awt.*;
import java.awt.print.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class GiaoDienKhoHang extends JFrame {
    private QuanLyHangHoaBLL bll;
    private JTabbedPane tabbedPane;
    private JPanel panelNYP, panelDGD;
    private JTable tableNYP, tableDGD;
    private DefaultTableModel modelNYP, modelDGD;
    private TableRowSorter<DefaultTableModel> sorterNYP, sorterDGD;
    private JLabel lblStatus;
    private DecimalFormat currencyFormat;
    private SimpleDateFormat dateFormat;
    
    // Các thành phần cho Nhu Yếu Phẩm
    private JTextField txtMaHangNYP, txtTenHangNYP, txtDonViTinhNYP, txtGiaNhapNYP;
    private JTextField txtNgaySanXuatNYP, txtNgayHetHanNYP, txtLoaiNYP, txtNhaSanXuatNYP;
    private JTextField txtSoLuongTonNYP, txtMoTaNYP;
    private JButton btnThemNYP, btnSuaNYP, btnXoaNYP, btnTimKiemNYP, btnLamMoiNYP;
    
    // Các thành phần cho Đồ Gia Dụng
    private JTextField txtMaHangDGD, txtTenHangDGD, txtDonViTinhDGD, txtGiaNhapDGD;
    private JTextField txtThuongHieuDGD, txtXuatXuDGD, txtChatLieuDGD, txtBaoHanhDGD;
    private JTextField txtSoLuongTonDGD, txtMoTaDGD;
    private JButton btnThemDGD, btnSuaDGD, btnXoaDGD, btnTimKiemDGD, btnLamMoiDGD;
    
    // Các pattern validation
    private static final Pattern MA_HANG_PATTERN = Pattern.compile("^[A-Z0-9]{4,10}$");
    private static final Pattern TEN_HANG_PATTERN = Pattern.compile("^[\\p{L}0-9\\s]{2,50}$");
    private static final Pattern DON_VI_TINH_PATTERN = Pattern.compile("^[\\p{L}0-9\\s]{1,20}$");
    private static final Pattern GIA_PATTERN = Pattern.compile("^\\d+(\\.\\d{1,2})?$");
    private static final Pattern SO_LUONG_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    
    // Thêm các thành phần mới
    private JMenuBar menuBar;
    private JMenu menuFile, menuEdit, menuView, menuTools, menuHelp;
    private JMenuItem miExport, miImport, miPrint, miExit;
    private JMenuItem miStatistics, miInventory, miSupplier;
    private JMenuItem miImportNote, miExportNote;
    private JMenuItem miUserManagement;
    private JMenuItem miAbout;
    
    private JPanel panelStatistics;
    private JPanel panelSupplier;
    private JPanel panelImportNote;
    private JPanel panelExportNote;
    private JPanel panelInventory;
    
    private JTable tableStatistics;
    private JTable tableSupplier;
    private JTable tableImportNote;
    private JTable tableExportNote;
    private JTable tableInventory;
    
    private DefaultTableModel modelStatistics;
    private DefaultTableModel modelSupplier;
    private DefaultTableModel modelImportNote;
    private DefaultTableModel modelExportNote;
    private DefaultTableModel modelInventory;
    
    private JLabel lblTotalProducts;
    private JLabel lblTotalValue;
    private JLabel lblExpiredProducts;
    private JLabel lblLowStockProducts;
    
    private JProgressBar progressBar;
    private JDialog progressDialog;
    
    private Map<String, Integer> productHistory;
    private List<String> alertMessages;
    
    public GiaoDienKhoHang() {
        bll = new QuanLyHangHoaBLL();
        currencyFormat = new DecimalFormat("#,##0.00");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        productHistory = new HashMap<>();
        alertMessages = new ArrayList<>();
        
        initComponents();
        loadData();
        setupValidation();
        createMenuBar();
        setupEventListeners();
        checkAlerts();
    }
    
    private void initComponents() {
        setTitle("Quản Lý Kho Hàng");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Khởi tạo tabbedPane
        tabbedPane = new JTabbedPane();
        
        // Khởi tạo các panel
        panelNYP = new JPanel(new BorderLayout());
        panelDGD = new JPanel(new BorderLayout());
        
        // Thêm các panel vào tabbedPane
        tabbedPane.addTab("Nhu Yếu Phẩm", new ImageIcon("src/ICON/nuoc.png"), panelNYP);
        tabbedPane.addTab("Đồ Gia Dụng", new ImageIcon("src/ICON/do.png"), panelDGD);
        
        // Khởi tạo các bảng
        initTableNYP();
        initTableDGD();
        
        // Khởi tạo các panel nhập liệu
        initInputPanelNYP();
        initInputPanelDGD();
        
        // Khởi tạo status bar
        lblStatus = new JLabel("Sẵn sàng");
        lblStatus.setBorder(BorderFactory.createEtchedBorder());
        add(lblStatus, BorderLayout.SOUTH);
        
        // Thêm tabbedPane vào frame
        add(tabbedPane);
        
        // Thêm menu bar
        createMenuBar();
    }
    
    private void createMenuBar() {
        menuBar = new JMenuBar();
        
        // Menu File
        menuFile = new JMenu("File");
        miExport = new JMenuItem("Xuất dữ liệu");
        miImport = new JMenuItem("Nhập dữ liệu");
        miPrint = new JMenuItem("In báo cáo");
        miExit = new JMenuItem("Thoát");
        
        menuFile.add(miExport);
        menuFile.add(miImport);
        menuFile.addSeparator();
        menuFile.add(miPrint);
        menuFile.addSeparator();
        menuFile.add(miExit);
        
        // Menu Edit
        menuEdit = new JMenu("Chỉnh sửa");
        JMenuItem miClear = new JMenuItem("Xóa trắng");
        JMenuItem miUndo = new JMenuItem("Hoàn tác");
        JMenuItem miRedo = new JMenuItem("Làm lại");
        
        menuEdit.add(miClear);
        menuEdit.addSeparator();
        menuEdit.add(miUndo);
        menuEdit.add(miRedo);
        
        // Menu View
        menuView = new JMenu("Xem");
        JMenuItem miRefresh = new JMenuItem("Làm mới");
        JMenuItem miZoomIn = new JMenuItem("Phóng to");
        JMenuItem miZoomOut = new JMenuItem("Thu nhỏ");
        
        menuView.add(miRefresh);
        menuView.addSeparator();
        menuView.add(miZoomIn);
        menuView.add(miZoomOut);
        
        // Menu Tools
        menuTools = new JMenu("Công cụ");
        miStatistics = new JMenuItem("Thống kê");
        miInventory = new JMenuItem("Kiểm kê kho");
        miSupplier = new JMenuItem("Nhà cung cấp");
        miImportNote = new JMenuItem("Phiếu nhập");
        miExportNote = new JMenuItem("Phiếu xuất");
        miUserManagement = new JMenuItem("Quản lý người dùng");
        
        menuTools.add(miStatistics);
        menuTools.add(miInventory);
        menuTools.add(miSupplier);
        menuTools.addSeparator();
        menuTools.add(miImportNote);
        menuTools.add(miExportNote);
        menuTools.addSeparator();
        menuTools.add(miUserManagement);
        
        // Menu Help
        menuHelp = new JMenu("Trợ giúp");
        miAbout = new JMenuItem("Giới thiệu");
        menuHelp.add(miAbout);
        
        // Thêm các menu vào menu bar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuView);
        menuBar.add(menuTools);
        menuBar.add(menuHelp);
        
        setJMenuBar(menuBar);
    }
    
    private void setupEventListeners() {
        // File menu events
        miExport.addActionListener(e -> exportData());
        miImport.addActionListener(e -> importData());
        miPrint.addActionListener(e -> printReport());
        miExit.addActionListener(e -> System.exit(0));
        
        // Tools menu events
        miStatistics.addActionListener(e -> showStatistics());
        miInventory.addActionListener(e -> showInventory());
        miSupplier.addActionListener(e -> showSupplier());
        miImportNote.addActionListener(e -> showImportNote());
        miExportNote.addActionListener(e -> showExportNote());
        miUserManagement.addActionListener(e -> showUserManagement());
        
        // Help menu events
        miAbout.addActionListener(e -> showAboutDialog());
        
        // Nhu Yeu Pham buttons
        btnThemNYP.addActionListener(e -> themNYP());
        btnSuaNYP.addActionListener(e -> suaNYP());
        btnXoaNYP.addActionListener(e -> xoaNYP());
        btnTimKiemNYP.addActionListener(e -> timKiemNYP());
        btnLamMoiNYP.addActionListener(e -> clearNYPFields());
        
        // Do Gia Dung buttons
        btnThemDGD.addActionListener(e -> themDGD());
        btnSuaDGD.addActionListener(e -> suaDGD());
        btnXoaDGD.addActionListener(e -> xoaDGD());
        btnTimKiemDGD.addActionListener(e -> timKiemDGD());
        btnLamMoiDGD.addActionListener(e -> clearDGDFields());
        
        // Table selection events
        tableNYP.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableNYP.getSelectedRow();
                if (row != -1) {
                    fillNYPFields(row);
                }
            }
        });
        
        tableDGD.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableDGD.getSelectedRow();
                if (row != -1) {
                    fillDGDFields(row);
                }
            }
        });
    }
    
    private void exportData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".xlsx")) {
                file = new File(file.getAbsolutePath() + ".xlsx");
            }
            
            try {
                showProgressDialog("Đang xuất dữ liệu...");
                // TODO: Implement export to Excel
                hideProgressDialog();
                JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công!");
            } catch (Exception e) {
                hideProgressDialog();
                JOptionPane.showMessageDialog(this, "Lỗi khi xuất dữ liệu: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void importData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn file cần nhập");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".xlsx")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn file Excel (.xlsx)!",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                showProgressDialog("Đang nhập dữ liệu...");
                // TODO: Implement import from Excel
                hideProgressDialog();
                JOptionPane.showMessageDialog(this, "Nhập dữ liệu thành công!");
                loadData();
            } catch (Exception e) {
                hideProgressDialog();
                JOptionPane.showMessageDialog(this, "Lỗi khi nhập dữ liệu: " + e.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void printReport() {
        try {
            boolean complete = tableNYP.print();
            if (complete) {
                JOptionPane.showMessageDialog(this, "In báo cáo thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "In báo cáo bị hủy!");
            }
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi in báo cáo: " + e.getMessage(),
                "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showStatistics() {
        JDialog dialog = new JDialog(this, "Thống kê", true);
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Thống kê tổng quan
        JPanel summaryPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        lblTotalProducts = new JLabel("Tổng số sản phẩm: 0");
        lblTotalValue = new JLabel("Tổng giá trị: 0 VNĐ");
        lblExpiredProducts = new JLabel("Sản phẩm hết hạn: 0");
        lblLowStockProducts = new JLabel("Sản phẩm sắp hết: 0");
        
        summaryPanel.add(lblTotalProducts);
        summaryPanel.add(lblTotalValue);
        summaryPanel.add(lblExpiredProducts);
        summaryPanel.add(lblLowStockProducts);
        
        // Bảng thống kê chi tiết
        String[] columns = {"Loại", "Số lượng", "Giá trị", "Tỷ lệ"};
        modelStatistics = new DefaultTableModel(columns, 0);
        tableStatistics = new JTable(modelStatistics);
        JScrollPane scrollPane = new JScrollPane(tableStatistics);
        
        panel.add(summaryPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        dialog.add(panel);
        dialog.setVisible(true);
        
        // Cập nhật dữ liệu thống kê
        updateStatistics();
    }
    
    private void updateStatistics() {
        // TODO: Implement statistics calculation
        lblTotalProducts.setText("Tổng số sản phẩm: " + (modelNYP.getRowCount() + modelDGD.getRowCount()));
        lblTotalValue.setText("Tổng giá trị: " + calculateTotalValue() + " VNĐ");
        lblExpiredProducts.setText("Sản phẩm hết hạn: " + countExpiredProducts());
        lblLowStockProducts.setText("Sản phẩm sắp hết: " + countLowStockProducts());
        
        // Cập nhật bảng thống kê
        modelStatistics.setRowCount(0);
        // TODO: Add detailed statistics
    }
    
    private String calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < modelNYP.getRowCount(); i++) {
            total += Double.parseDouble(modelNYP.getValueAt(i, 3).toString().replace(",", ""));
        }
        for (int i = 0; i < modelDGD.getRowCount(); i++) {
            total += Double.parseDouble(modelDGD.getValueAt(i, 3).toString().replace(",", ""));
        }
        return currencyFormat.format(total);
    }
    
    private int countExpiredProducts() {
        int count = 0;
        Date today = new Date();
        for (int i = 0; i < modelNYP.getRowCount(); i++) {
            try {
                Date expiryDate = dateFormat.parse(modelNYP.getValueAt(i, 5).toString());
                if (expiryDate.before(today)) {
                    count++;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
    
    private int countLowStockProducts() {
        int count = 0;
        for (int i = 0; i < modelNYP.getRowCount(); i++) {
            int quantity = Integer.parseInt(modelNYP.getValueAt(i, 8).toString());
            if (quantity < 10) {
                count++;
            }
        }
        for (int i = 0; i < modelDGD.getRowCount(); i++) {
            int quantity = Integer.parseInt(modelDGD.getValueAt(i, 8).toString());
            if (quantity < 5) {
                count++;
            }
        }
        return count;
    }
    
    private void showInventory() {
        JDialog dialog = new JDialog(this, "Kiểm kê kho", true);
        dialog.setSize(1000, 600);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Bảng kiểm kê
        String[] columns = {"Mã hàng", "Tên hàng", "Số lượng hệ thống", "Số lượng thực tế", "Chênh lệch"};
        modelInventory = new DefaultTableModel(columns, 0);
        tableInventory = new JTable(modelInventory);
        JScrollPane scrollPane = new JScrollPane(tableInventory);
        
        // Panel điều khiển
        JPanel controlPanel = new JPanel();
        JButton btnStart = new JButton("Bắt đầu kiểm kê");
        JButton btnSave = new JButton("Lưu kết quả");
        JButton btnPrint = new JButton("In báo cáo");
        
        controlPanel.add(btnStart);
        controlPanel.add(btnSave);
        controlPanel.add(btnPrint);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showSupplier() {
        JDialog dialog = new JDialog(this, "Quản lý nhà cung cấp", true);
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Bảng nhà cung cấp
        String[] columns = {"Mã NCC", "Tên NCC", "Địa chỉ", "SĐT", "Email", "Ghi chú"};
        modelSupplier = new DefaultTableModel(columns, 0);
        tableSupplier = new JTable(modelSupplier);
        JScrollPane scrollPane = new JScrollPane(tableSupplier);
        
        // Panel điều khiển
        JPanel controlPanel = new JPanel();
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnRefresh = new JButton("Làm mới");
        
        controlPanel.add(btnAdd);
        controlPanel.add(btnEdit);
        controlPanel.add(btnDelete);
        controlPanel.add(btnRefresh);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showImportNote() {
        JDialog dialog = new JDialog(this, "Quản lý phiếu nhập", true);
        dialog.setSize(1000, 600);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Bảng phiếu nhập
        String[] columns = {"Mã phiếu", "Ngày nhập", "Nhà cung cấp", "Tổng tiền", "Trạng thái"};
        modelImportNote = new DefaultTableModel(columns, 0);
        tableImportNote = new JTable(modelImportNote);
        JScrollPane scrollPane = new JScrollPane(tableImportNote);
        
        // Panel điều khiển
        JPanel controlPanel = new JPanel();
        JButton btnAdd = new JButton("Tạo phiếu mới");
        JButton btnView = new JButton("Xem chi tiết");
        JButton btnPrint = new JButton("In phiếu");
        JButton btnRefresh = new JButton("Làm mới");
        
        controlPanel.add(btnAdd);
        controlPanel.add(btnView);
        controlPanel.add(btnPrint);
        controlPanel.add(btnRefresh);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showExportNote() {
        JDialog dialog = new JDialog(this, "Quản lý phiếu xuất", true);
        dialog.setSize(1000, 600);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Bảng phiếu xuất
        String[] columns = {"Mã phiếu", "Ngày xuất", "Người nhận", "Tổng tiền", "Trạng thái"};
        modelExportNote = new DefaultTableModel(columns, 0);
        tableExportNote = new JTable(modelExportNote);
        JScrollPane scrollPane = new JScrollPane(tableExportNote);
        
        // Panel điều khiển
        JPanel controlPanel = new JPanel();
        JButton btnAdd = new JButton("Tạo phiếu mới");
        JButton btnView = new JButton("Xem chi tiết");
        JButton btnPrint = new JButton("In phiếu");
        JButton btnRefresh = new JButton("Làm mới");
        
        controlPanel.add(btnAdd);
        controlPanel.add(btnView);
        controlPanel.add(btnPrint);
        controlPanel.add(btnRefresh);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showUserManagement() {
        JDialog dialog = new JDialog(this, "Quản lý người dùng", true);
        dialog.setSize(800, 600);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Bảng người dùng
        String[] columns = {"Mã NV", "Họ tên", "Chức vụ", "Quyền truy cập", "Trạng thái"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Panel điều khiển
        JPanel controlPanel = new JPanel();
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnRefresh = new JButton("Làm mới");
        
        controlPanel.add(btnAdd);
        controlPanel.add(btnEdit);
        controlPanel.add(btnDelete);
        controlPanel.add(btnRefresh);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showProgressDialog(String message) {
        progressDialog = new JDialog(this, "Đang xử lý", true);
        progressDialog.setSize(300, 100);
        progressDialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel lblMessage = new JLabel(message);
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        
        panel.add(lblMessage, BorderLayout.NORTH);
        panel.add(progressBar, BorderLayout.CENTER);
        
        progressDialog.add(panel);
        progressDialog.setVisible(true);
    }
    
    private void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dispose();
        }
    }
    
    private void checkAlerts() {
        alertMessages.clear();
        
        // Kiểm tra hàng hết hạn
        Date today = new Date();
        for (int i = 0; i < modelNYP.getRowCount(); i++) {
            try {
                Date expiryDate = dateFormat.parse(modelNYP.getValueAt(i, 5).toString());
                if (expiryDate.before(today)) {
                    alertMessages.add("Hàng " + modelNYP.getValueAt(i, 1) + " đã hết hạn!");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        // Kiểm tra hàng sắp hết
        for (int i = 0; i < modelNYP.getRowCount(); i++) {
            int quantity = Integer.parseInt(modelNYP.getValueAt(i, 8).toString());
            if (quantity < 10) {
                alertMessages.add("Hàng " + modelNYP.getValueAt(i, 1) + " sắp hết (còn " + quantity + ")!");
            }
        }
        
        // Hiển thị cảnh báo nếu có
        if (!alertMessages.isEmpty()) {
            StringBuilder message = new StringBuilder("Các cảnh báo:\n");
            for (String alert : alertMessages) {
                message.append("- ").append(alert).append("\n");
            }
            JOptionPane.showMessageDialog(this, message.toString(), "Cảnh báo",
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void initTableNYP() {
        String[] columns = {"Mã Hàng", "Tên Hàng", "Đơn Vị Tính", "Giá Nhập", 
                          "Ngày SX", "Ngày HH", "Loại", "Nhà SX", "Số Lượng", "Mô Tả"};
        modelNYP = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableNYP = new JTable(modelNYP);
        JScrollPane scrollPane = new JScrollPane(tableNYP);
        panelNYP.add(scrollPane, BorderLayout.CENTER);
        
        // Thêm sự kiện chọn hàng
        tableNYP.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableNYP.getSelectedRow();
                if (row != -1) {
                    fillNYPFields(row);
                }
            }
        });
    }
    
    private void initTableDGD() {
        String[] columns = {"Mã Hàng", "Tên Hàng", "Đơn Vị Tính", "Giá Nhập", 
                          "Thương Hiệu", "Xuất Xứ", "Chất Liệu", "Bảo Hành", "Số Lượng", "Mô Tả"};
        modelDGD = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableDGD = new JTable(modelDGD);
        JScrollPane scrollPane = new JScrollPane(tableDGD);
        panelDGD.add(scrollPane, BorderLayout.CENTER);
        
        // Thêm sự kiện chọn hàng
        tableDGD.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tableDGD.getSelectedRow();
                if (row != -1) {
                    fillDGDFields(row);
                }
            }
        });
    }
    
    private void initInputPanelNYP() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Khởi tạo các text field
        txtMaHangNYP = new JTextField(20);
        txtTenHangNYP = new JTextField(20);
        txtDonViTinhNYP = new JTextField(20);
        txtGiaNhapNYP = new JTextField(20);
        txtNgaySanXuatNYP = new JTextField(20);
        txtNgayHetHanNYP = new JTextField(20);
        txtLoaiNYP = new JTextField(20);
        txtNhaSanXuatNYP = new JTextField(20);
        txtSoLuongTonNYP = new JTextField(20);
        txtMoTaNYP = new JTextField(20);
        
        // Thêm các label và text field
        addInputField(inputPanel, gbc, "Mã Hàng:", txtMaHangNYP, 0);
        addInputField(inputPanel, gbc, "Tên Hàng:", txtTenHangNYP, 1);
        addInputField(inputPanel, gbc, "Đơn Vị Tính:", txtDonViTinhNYP, 2);
        addInputField(inputPanel, gbc, "Giá Nhập:", txtGiaNhapNYP, 3);
        addInputField(inputPanel, gbc, "Ngày Sản Xuất:", txtNgaySanXuatNYP, 4);
        addInputField(inputPanel, gbc, "Ngày Hết Hạn:", txtNgayHetHanNYP, 5);
        addInputField(inputPanel, gbc, "Loại:", txtLoaiNYP, 6);
        addInputField(inputPanel, gbc, "Nhà Sản Xuất:", txtNhaSanXuatNYP, 7);
        addInputField(inputPanel, gbc, "Số Lượng Tồn:", txtSoLuongTonNYP, 8);
        addInputField(inputPanel, gbc, "Mô Tả:", txtMoTaNYP, 9);
        
        // Khởi tạo các button
        JPanel buttonPanel = new JPanel();
        btnThemNYP = new JButton("Thêm");
        btnSuaNYP = new JButton("Sửa");
        btnXoaNYP = new JButton("Xóa");
        btnTimKiemNYP = new JButton("Tìm Kiếm");
        
        buttonPanel.add(btnThemNYP);
        buttonPanel.add(btnSuaNYP);
        buttonPanel.add(btnXoaNYP);
        buttonPanel.add(btnTimKiemNYP);
        
        // Thêm sự kiện cho các button
        btnThemNYP.addActionListener(e -> themNYP());
        btnSuaNYP.addActionListener(e -> suaNYP());
        btnXoaNYP.addActionListener(e -> xoaNYP());
        btnTimKiemNYP.addActionListener(e -> timKiemNYP());
        
        // Thêm các panel vào panel chính
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        panelNYP.add(mainPanel, BorderLayout.SOUTH);
    }
    
    private void initInputPanelDGD() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Khởi tạo các text field
        txtMaHangDGD = new JTextField(20);
        txtTenHangDGD = new JTextField(20);
        txtDonViTinhDGD = new JTextField(20);
        txtGiaNhapDGD = new JTextField(20);
        txtThuongHieuDGD = new JTextField(20);
        txtXuatXuDGD = new JTextField(20);
        txtChatLieuDGD = new JTextField(20);
        txtBaoHanhDGD = new JTextField(20);
        txtSoLuongTonDGD = new JTextField(20);
        txtMoTaDGD = new JTextField(20);
        
        // Thêm các label và text field
        addInputField(inputPanel, gbc, "Mã Hàng:", txtMaHangDGD, 0);
        addInputField(inputPanel, gbc, "Tên Hàng:", txtTenHangDGD, 1);
        addInputField(inputPanel, gbc, "Đơn Vị Tính:", txtDonViTinhDGD, 2);
        addInputField(inputPanel, gbc, "Giá Nhập:", txtGiaNhapDGD, 3);
        addInputField(inputPanel, gbc, "Thương Hiệu:", txtThuongHieuDGD, 4);
        addInputField(inputPanel, gbc, "Xuất Xứ:", txtXuatXuDGD, 5);
        addInputField(inputPanel, gbc, "Chất Liệu:", txtChatLieuDGD, 6);
        addInputField(inputPanel, gbc, "Bảo Hành:", txtBaoHanhDGD, 7);
        addInputField(inputPanel, gbc, "Số Lượng Tồn:", txtSoLuongTonDGD, 8);
        addInputField(inputPanel, gbc, "Mô Tả:", txtMoTaDGD, 9);
        
        // Khởi tạo các button
        JPanel buttonPanel = new JPanel();
        btnThemDGD = new JButton("Thêm");
        btnSuaDGD = new JButton("Sửa");
        btnXoaDGD = new JButton("Xóa");
        btnTimKiemDGD = new JButton("Tìm Kiếm");
        
        buttonPanel.add(btnThemDGD);
        buttonPanel.add(btnSuaDGD);
        buttonPanel.add(btnXoaDGD);
        buttonPanel.add(btnTimKiemDGD);
        
        // Thêm sự kiện cho các button
        btnThemDGD.addActionListener(e -> themDGD());
        btnSuaDGD.addActionListener(e -> suaDGD());
        btnXoaDGD.addActionListener(e -> xoaDGD());
        btnTimKiemDGD.addActionListener(e -> timKiemDGD());
        
        // Thêm các panel vào panel chính
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        panelDGD.add(mainPanel, BorderLayout.SOUTH);
    }
    
    private void addInputField(JPanel panel, GridBagConstraints gbc, String label, JTextField textField, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(label), gbc);
        
        gbc.gridx = 1;
        panel.add(textField, gbc);
    }
    
    private void loadData() {
        loadDataNYP();
        loadDataDGD();
    }
    
    private void loadDataNYP() {
        modelNYP.setRowCount(0);
        List<NhuYeuPham_DTO> list = bll.getAllNhuYeuPham();
        
        for (NhuYeuPham_DTO nyp : list) {
            Object[] row = {
                nyp.getMaHang(),
                nyp.getTenHang(),
                nyp.getDonViTinh(),
                currencyFormat.format(nyp.getGiaNhap()),
                dateFormat.format(nyp.getNgaySanXuat()),
                dateFormat.format(nyp.getNgayHetHan()),
                nyp.getLoaiNhuYeuPham(),
                nyp.getNhaSanXuat(),
                nyp.getSoLuongTon(),
                nyp.getMoTa()
            };
            modelNYP.addRow(row);
        }
        
        lblStatus.setText("Đã tải " + list.size() + " nhu yếu phẩm");
    }
    
    private void loadDataDGD() {
        modelDGD.setRowCount(0);
        List<DoGiaDung_DTO> list = bll.getAllDoGiaDung();
        
        for (DoGiaDung_DTO dgd : list) {
            Object[] row = {
                dgd.getMaHang(),
                dgd.getTenHang(),
                dgd.getDonViTinh(),
                dgd.getGiaNhap(),
                dgd.getThuongHieu(),
                dgd.getXuatXu(),
                dgd.getChatLieu(),
                dgd.getBaoHanh(),
                dgd.getSoLuongTon(),
                dgd.getMoTa()
            };
            modelDGD.addRow(row);
        }
    }
    
    private void fillNYPFields(int row) {
        txtMaHangNYP.setText(modelNYP.getValueAt(row, 0).toString());
        txtTenHangNYP.setText(modelNYP.getValueAt(row, 1).toString());
        txtDonViTinhNYP.setText(modelNYP.getValueAt(row, 2).toString());
        txtGiaNhapNYP.setText(modelNYP.getValueAt(row, 3).toString());
        txtNgaySanXuatNYP.setText(modelNYP.getValueAt(row, 4).toString());
        txtNgayHetHanNYP.setText(modelNYP.getValueAt(row, 5).toString());
        txtLoaiNYP.setText(modelNYP.getValueAt(row, 6).toString());
        txtNhaSanXuatNYP.setText(modelNYP.getValueAt(row, 7).toString());
        txtSoLuongTonNYP.setText(modelNYP.getValueAt(row, 8).toString());
        txtMoTaNYP.setText(modelNYP.getValueAt(row, 9).toString());
    }
    
    private void fillDGDFields(int row) {
        txtMaHangDGD.setText(modelDGD.getValueAt(row, 0).toString());
        txtTenHangDGD.setText(modelDGD.getValueAt(row, 1).toString());
        txtDonViTinhDGD.setText(modelDGD.getValueAt(row, 2).toString());
        txtGiaNhapDGD.setText(modelDGD.getValueAt(row, 3).toString());
        txtThuongHieuDGD.setText(modelDGD.getValueAt(row, 4).toString());
        txtXuatXuDGD.setText(modelDGD.getValueAt(row, 5).toString());
        txtChatLieuDGD.setText(modelDGD.getValueAt(row, 6).toString());
        txtBaoHanhDGD.setText(modelDGD.getValueAt(row, 7).toString());
        txtSoLuongTonDGD.setText(modelDGD.getValueAt(row, 8).toString());
        txtMoTaDGD.setText(modelDGD.getValueAt(row, 9).toString());
    }
    
    private void themNYP() {
        try {
            if (!validateNYPInput()) {
                return;
            }
            
            String maHang = txtMaHangNYP.getText().trim();
            String tenHang = txtTenHangNYP.getText().trim();
            String donViTinh = txtDonViTinhNYP.getText().trim();
            double giaNhap = Double.parseDouble(txtGiaNhapNYP.getText().trim());
            Date ngaySanXuat = dateFormat.parse(txtNgaySanXuatNYP.getText().trim());
            Date ngayHetHan = dateFormat.parse(txtNgayHetHanNYP.getText().trim());
            String loaiNYP = txtLoaiNYP.getText().trim();
            String nhaSanXuat = txtNhaSanXuatNYP.getText().trim();
            int soLuongTon = Integer.parseInt(txtSoLuongTonNYP.getText().trim());
            String moTa = txtMoTaNYP.getText().trim();
            
            if (bll.themNhuYeuPham(maHang, tenHang, donViTinh, giaNhap, ngaySanXuat, 
                                  ngayHetHan, loaiNYP, nhaSanXuat, soLuongTon, moTa)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", 
                    JOptionPane.INFORMATION_MESSAGE);
                loadDataNYP();
                clearNYPFields();
                lblStatus.setText("Đã thêm nhu yếu phẩm mới");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại! Mã hàng có thể đã tồn tại.", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi", 
                JOptionPane.ERROR_MESSAGE);
            lblStatus.setText("Lỗi: " + e.getMessage());
        }
    }
    
    private boolean validateNYPInput() {
        if (txtMaHangNYP.getText().trim().isEmpty() ||
            txtTenHangNYP.getText().trim().isEmpty() ||
            txtDonViTinhNYP.getText().trim().isEmpty() ||
            txtGiaNhapNYP.getText().trim().isEmpty() ||
            txtNgaySanXuatNYP.getText().trim().isEmpty() ||
            txtNgayHetHanNYP.getText().trim().isEmpty() ||
            txtLoaiNYP.getText().trim().isEmpty() ||
            txtNhaSanXuatNYP.getText().trim().isEmpty() ||
            txtSoLuongTonNYP.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            Date ngaySanXuat = dateFormat.parse(txtNgaySanXuatNYP.getText().trim());
            Date ngayHetHan = dateFormat.parse(txtNgayHetHanNYP.getText().trim());
            
            if (ngayHetHan.before(ngaySanXuat)) {
                JOptionPane.showMessageDialog(this, "Ngày hết hạn phải sau ngày sản xuất!", 
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ!", 
                "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private void suaNYP() {
        try {
            String maHang = txtMaHangNYP.getText();
            String tenHang = txtTenHangNYP.getText();
            String donViTinh = txtDonViTinhNYP.getText();
            double giaNhap = Double.parseDouble(txtGiaNhapNYP.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date ngaySanXuat = sdf.parse(txtNgaySanXuatNYP.getText());
            Date ngayHetHan = sdf.parse(txtNgayHetHanNYP.getText());
            String loaiNYP = txtLoaiNYP.getText();
            String nhaSanXuat = txtNhaSanXuatNYP.getText();
            int soLuongTon = Integer.parseInt(txtSoLuongTonNYP.getText());
            String moTa = txtMoTaNYP.getText();
            
            if (bll.capNhatNhuYeuPham(maHang, tenHang, donViTinh, giaNhap, ngaySanXuat, 
                                     ngayHetHan, loaiNYP, nhaSanXuat, soLuongTon, moTa)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadDataNYP();
                clearNYPFields();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    
    private void xoaNYP() {
        String maHang = txtMaHangNYP.getText();
        if (maHang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc chắn muốn xóa hàng này?", "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (bll.xoaNhuYeuPham(maHang)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                loadDataNYP();
                clearNYPFields();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        }
    }
    
    private void timKiemNYP() {
        String tenHang = JOptionPane.showInputDialog(this, "Nhập tên hàng cần tìm:");
        if (tenHang != null && !tenHang.isEmpty()) {
            List<NhuYeuPham_DTO> list = bll.timKiemNhuYeuPham(tenHang);
            modelNYP.setRowCount(0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            for (NhuYeuPham_DTO nyp : list) {
                Object[] row = {
                    nyp.getMaHang(),
                    nyp.getTenHang(),
                    nyp.getDonViTinh(),
                    nyp.getGiaNhap(),
                    sdf.format(nyp.getNgaySanXuat()),
                    sdf.format(nyp.getNgayHetHan()),
                    nyp.getLoaiNhuYeuPham(),
                    nyp.getNhaSanXuat(),
                    nyp.getSoLuongTon(),
                    nyp.getMoTa()
                };
                modelNYP.addRow(row);
            }
        }
    }
    
    private void themDGD() {
        try {
            String maHang = txtMaHangDGD.getText();
            String tenHang = txtTenHangDGD.getText();
            String donViTinh = txtDonViTinhDGD.getText();
            double giaNhap = Double.parseDouble(txtGiaNhapDGD.getText());
            String thuongHieu = txtThuongHieuDGD.getText();
            String xuatXu = txtXuatXuDGD.getText();
            String chatLieu = txtChatLieuDGD.getText();
            int baoHanh = Integer.parseInt(txtBaoHanhDGD.getText());
            int soLuongTon = Integer.parseInt(txtSoLuongTonDGD.getText());
            String moTa = txtMoTaDGD.getText();
            
            if (bll.themDoGiaDung(maHang, tenHang, donViTinh, giaNhap, thuongHieu, 
                                 xuatXu, chatLieu, baoHanh, soLuongTon, moTa)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
                loadDataDGD();
                clearDGDFields();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    
    private void suaDGD() {
        try {
            String maHang = txtMaHangDGD.getText();
            String tenHang = txtTenHangDGD.getText();
            String donViTinh = txtDonViTinhDGD.getText();
            double giaNhap = Double.parseDouble(txtGiaNhapDGD.getText());
            String thuongHieu = txtThuongHieuDGD.getText();
            String xuatXu = txtXuatXuDGD.getText();
            String chatLieu = txtChatLieuDGD.getText();
            int baoHanh = Integer.parseInt(txtBaoHanhDGD.getText());
            int soLuongTon = Integer.parseInt(txtSoLuongTonDGD.getText());
            String moTa = txtMoTaDGD.getText();
            
            if (bll.capNhatDoGiaDung(maHang, tenHang, donViTinh, giaNhap, thuongHieu, 
                                    xuatXu, chatLieu, baoHanh, soLuongTon, moTa)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                loadDataDGD();
                clearDGDFields();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }
    
    private void xoaDGD() {
        String maHang = txtMaHangDGD.getText();
        if (maHang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xóa!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Bạn có chắc chắn muốn xóa hàng này?", "Xác nhận xóa", 
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            if (bll.xoaDoGiaDung(maHang)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                loadDataDGD();
                clearDGDFields();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
        }
    }
    
    private void timKiemDGD() {
        String tenHang = JOptionPane.showInputDialog(this, "Nhập tên hàng cần tìm:");
        if (tenHang != null && !tenHang.isEmpty()) {
            List<DoGiaDung_DTO> list = bll.timKiemDoGiaDung(tenHang);
            modelDGD.setRowCount(0);
            
            for (DoGiaDung_DTO dgd : list) {
                Object[] row = {
                    dgd.getMaHang(),
                    dgd.getTenHang(),
                    dgd.getDonViTinh(),
                    dgd.getGiaNhap(),
                    dgd.getThuongHieu(),
                    dgd.getXuatXu(),
                    dgd.getChatLieu(),
                    dgd.getBaoHanh(),
                    dgd.getSoLuongTon(),
                    dgd.getMoTa()
                };
                modelDGD.addRow(row);
            }
        }
    }
    
    private void clearNYPFields() {
        txtMaHangNYP.setText("");
        txtTenHangNYP.setText("");
        txtDonViTinhNYP.setText("");
        txtGiaNhapNYP.setText("");
        txtNgaySanXuatNYP.setText("");
        txtNgayHetHanNYP.setText("");
        txtLoaiNYP.setText("");
        txtNhaSanXuatNYP.setText("");
        txtSoLuongTonNYP.setText("");
        txtMoTaNYP.setText("");
    }
    
    private void clearDGDFields() {
        txtMaHangDGD.setText("");
        txtTenHangDGD.setText("");
        txtDonViTinhDGD.setText("");
        txtGiaNhapDGD.setText("");
        txtThuongHieuDGD.setText("");
        txtXuatXuDGD.setText("");
        txtChatLieuDGD.setText("");
        txtBaoHanhDGD.setText("");
        txtSoLuongTonDGD.setText("");
        txtMoTaDGD.setText("");
    }
    
    private void setupValidation() {
        // Nhu Yeu Pham validation
        addInputValidation(txtMaHangNYP, MA_HANG_PATTERN, "Mã hàng phải có 4-10 ký tự chữ hoa hoặc số");
        addInputValidation(txtTenHangNYP, TEN_HANG_PATTERN, "Tên hàng phải có 2-50 ký tự");
        addInputValidation(txtDonViTinhNYP, DON_VI_TINH_PATTERN, "Đơn vị tính phải có 1-20 ký tự");
        addInputValidation(txtGiaNhapNYP, GIA_PATTERN, "Giá nhập phải là số dương");
        addInputValidation(txtSoLuongTonNYP, SO_LUONG_PATTERN, "Số lượng tồn phải là số nguyên dương");
        addInputValidation(txtNgaySanXuatNYP, DATE_PATTERN, "Ngày sản xuất phải có định dạng dd/MM/yyyy");
        addInputValidation(txtNgayHetHanNYP, DATE_PATTERN, "Ngày hết hạn phải có định dạng dd/MM/yyyy");
        
        // Do Gia Dung validation
        addInputValidation(txtMaHangDGD, MA_HANG_PATTERN, "Mã hàng phải có 4-10 ký tự chữ hoa hoặc số");
        addInputValidation(txtTenHangDGD, TEN_HANG_PATTERN, "Tên hàng phải có 2-50 ký tự");
        addInputValidation(txtDonViTinhDGD, DON_VI_TINH_PATTERN, "Đơn vị tính phải có 1-20 ký tự");
        addInputValidation(txtGiaNhapDGD, GIA_PATTERN, "Giá nhập phải là số dương");
        addInputValidation(txtSoLuongTonDGD, SO_LUONG_PATTERN, "Số lượng tồn phải là số nguyên dương");
        addInputValidation(txtBaoHanhDGD, SO_LUONG_PATTERN, "Thời gian bảo hành phải là số nguyên dương");
    }
    
    private void addInputValidation(JTextField textField, Pattern pattern, String errorMessage) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateInput();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                validateInput();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                validateInput();
            }
            
            private void validateInput() {
                String text = textField.getText();
                if (!text.isEmpty() && !pattern.matcher(text).matches()) {
                    textField.setBackground(new Color(255, 200, 200));
                    textField.setToolTipText(errorMessage);
                } else {
                    textField.setBackground(Color.WHITE);
                    textField.setToolTipText(null);
                }
            }
        });
    }
    
    private void showAboutDialog() {
        JDialog dialog = new JDialog(this, "Giới thiệu", true);
        dialog.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel lblTitle = new JLabel("Phần mềm Quản lý Kho Hàng");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);
        
        JLabel lblVersion = new JLabel("Phiên bản 1.0");
        gbc.gridy = 1;
        panel.add(lblVersion, gbc);
        
        JLabel lblAuthor = new JLabel("Tác giả: LQHT");
        gbc.gridy = 2;
        panel.add(lblAuthor, gbc);
        
        JButton btnClose = new JButton("Đóng");
        btnClose.addActionListener(e -> dialog.dispose());
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(btnClose, gbc);
        
        dialog.add(panel, BorderLayout.CENTER);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
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
