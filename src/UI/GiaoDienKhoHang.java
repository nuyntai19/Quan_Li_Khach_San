package doan.quanlykhachsan.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.LineBorder;
import javax.swing.DefaultCellEditor;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

public class KhoHang_GUI extends JFrame {
    // Định nghĩa màu sắc chủ đạo - đã điều chỉnh thành xanh dương đậm hơn
    private final Color PRIMARY_BLUE = new Color(0, 51, 153); // Xanh dương đậm hơn
    private final Color LIGHT_BLUE = Color.BLACK;   // Xanh dương nhạt hơn
    private final Color BLACK = Color.BLACK;
    private final Color WHITE = Color.WHITE;
    private final Color BACKGROUND_COLOR = new Color(240, 245, 255); // Nền trắng xanh nhạt
    private final Color HEADER_COLOR = new Color(0, 51, 102);  // Xanh dương đậm hơn cho header
    
    // Panel
    private JPanel pnlControl;
    private JPanel pnlSearch; 
    private JPanel pnlSub;
    private JPanel pnlButton;
    private JPanel pnlContent;
    private JPanel pnlEdit;
    
    // Button
    private JPopupMenu btnNhapKho_Control;
    private JMenuItem btnNhapKho_Control_HangCoSan;
    private JMenuItem btnNhapKho_Control_HangMoi;
    
    // Popup menu cho loại hàng
    private JPopupMenu loaiHangMenu;
    private JMenuItem doGiaDungMenuItem;
    private JMenuItem nhuYeuPhamMenuItem;
    
    private JButton btnNhapKho;
    private JButton btnXuatKhoa_Control;
    private JButton btnTimKiem_Control;
    private JButton btnXacNhan_Sub;
    private JButton btnThoat_Sub;
    private JButton btnType_Sub; 
    
    // TextField
    private JTextField txtTiemKiemTheoMa_Control;
    private JTextField txtMaHang_Sub;
    private JTextField txtTenHang_Sub;
    private JTextField txtDonViTinh_Sub;
    private JTextField txtGiaNhap_Sub;
    private JTextField txtLoaiHang_Sub; 
    private JTextField txtSoLuong_Sub; 
    
    // Label
    private JLabel lblTiemKiemTheoMa_Control;
    private JLabel lblMaHang_Sub;
    private JLabel lblTenHang_Sub;
    private JLabel lblDonViTinh_Sub;
    private JLabel lblGiaNhap;
    private JLabel lblLoaiHang_Sub;
    private JLabel lblSoLuong_Sub; 
    
    
    public KhoHang_GUI(){
        initComponent();
    }
    
    public void initComponent(){
        setTitle("Quản Lý Kho Hàng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLayout(new BorderLayout());
        getContentPane().setBackground(BACKGROUND_COLOR);
        
        // Thiết lập look and feel hiện đại
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        pnlEdit = new JPanel(new BorderLayout());
        pnlEdit.setBackground(WHITE);
        pnlEdit.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(200, 200, 200)));
        pnlEdit.setPreferredSize(new Dimension(380, 10)); // Tăng chiều rộng panel để tránh cắt nút
        
        pnlControl = new JPanel(new BorderLayout());
        pnlControl.setBackground(WHITE);
        
        JPanel buttonControlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        buttonControlPanel.setBackground(WHITE);
        
        pnlSearch = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlSearch.setBackground(WHITE);
        pnlSearch.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        pnlContent = new JPanel(new BorderLayout());
        pnlContent.setBackground(WHITE);
        pnlContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Thiết lập popup menu
        btnNhapKho_Control = new JPopupMenu();
        btnNhapKho_Control.setBorder(BorderFactory.createLineBorder(PRIMARY_BLUE));
        btnNhapKho_Control_HangCoSan = createStyledMenuItem("Hàng Có Sẵn");
        btnNhapKho_Control_HangMoi = createStyledMenuItem("Hàng Mới");
        
        loaiHangMenu = new JPopupMenu();
        loaiHangMenu.setBorder(BorderFactory.createLineBorder(PRIMARY_BLUE));
        doGiaDungMenuItem = createStyledMenuItem("Đồ Gia Dụng");
        nhuYeuPhamMenuItem = createStyledMenuItem("Nhu Yếu Phẩm");
        loaiHangMenu.add(doGiaDungMenuItem);
        loaiHangMenu.add(nhuYeuPhamMenuItem);
        
        // Tạo các nút với style mới
        btnNhapKho = createStyledButton("NHẬP KHO", PRIMARY_BLUE, BLACK);
        btnXuatKhoa_Control = createStyledButton("XUẤT KHO", PRIMARY_BLUE, BLACK);
        btnTimKiem_Control = createStyledButton("TÌM KIẾM", LIGHT_BLUE, BLACK);
        btnXacNhan_Sub = createStyledButton("XÁC NHẬN", PRIMARY_BLUE, BLACK);
        btnThoat_Sub = createStyledButton("THOÁT", new Color(180, 180, 180), BLACK);
        btnType_Sub = createStyledButton("CHỌN", LIGHT_BLUE, BLACK);
        
        // Tạo và style các text field
        txtTiemKiemTheoMa_Control = createStyledTextField(15);
        txtMaHang_Sub = createStyledTextField(10);
        txtTenHang_Sub = createStyledTextField(10);
        txtDonViTinh_Sub = createStyledTextField(10);
        txtGiaNhap_Sub = createStyledTextField(10);
        txtLoaiHang_Sub = createStyledTextField(10);
        txtLoaiHang_Sub.setEditable(false);
        txtSoLuong_Sub = createStyledTextField(10);
        
        // Tạo và style các label
        lblTiemKiemTheoMa_Control = createStyledLabel("NHẬP MÃ:");
        lblMaHang_Sub = createStyledLabel("MÃ HÀNG");
        lblTenHang_Sub = createStyledLabel("TÊN HÀNG");
        lblDonViTinh_Sub = createStyledLabel("ĐƠN VỊ TÍNH");
        lblGiaNhap = createStyledLabel("GIÁ NHẬP");
        lblLoaiHang_Sub = createStyledLabel("LOẠI HÀNG");
        lblSoLuong_Sub = createStyledLabel("SỐ LƯỢNG");
        
        btnNhapKho_Control.add(btnNhapKho_Control_HangCoSan);
        btnNhapKho_Control.add(btnNhapKho_Control_HangMoi);
        
        btnNhapKho.addActionListener(e -> {
            btnNhapKho_Control.show(btnNhapKho, 0, btnNhapKho.getHeight());
        });
        
        btnType_Sub.addActionListener(e -> {
            loaiHangMenu.show(btnType_Sub, 0, btnType_Sub.getHeight());
        });
        
        doGiaDungMenuItem.addActionListener(e -> {
            txtLoaiHang_Sub.setText("Đồ Gia Dụng");
        });
        
        nhuYeuPhamMenuItem.addActionListener(e -> {
            txtLoaiHang_Sub.setText("Nhu Yếu Phẩm");
        });
        
        // Đảm bảo kích thước nút đủ lớn để hiển thị đầy đủ
        btnNhapKho.setPreferredSize(new Dimension(120, 35));
        btnXuatKhoa_Control.setPreferredSize(new Dimension(120, 35));
        
        buttonControlPanel.add(btnNhapKho);
        buttonControlPanel.add(btnXuatKhoa_Control);
        
        pnlSearch.add(lblTiemKiemTheoMa_Control);
        pnlSearch.add(txtTiemKiemTheoMa_Control);
        pnlSearch.add(btnTimKiem_Control);
        
        pnlControl.add(buttonControlPanel, BorderLayout.NORTH);
        pnlControl.add(pnlSearch, BorderLayout.CENTER);
        
        pnlSearch.setVisible(false);
        
        // Thiết lập panel nhập liệu
        pnlSub = new JPanel(new GridBagLayout());
        pnlSub.setBackground(WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 6); // Tăng khoảng cách giữa các thành phần
        gbc.anchor = GridBagConstraints.WEST;
        pnlSub.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlSub.add(lblMaHang_Sub, gbc);
        gbc.gridx = 1;
        txtMaHang_Sub.setPreferredSize(new Dimension(230, 30)); // Tăng chiều rộng field
        pnlSub.add(txtMaHang_Sub, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        pnlSub.add(lblTenHang_Sub, gbc);
        gbc.gridx = 1;
        txtTenHang_Sub.setPreferredSize(new Dimension(230, 30)); // Tăng chiều rộng field
        pnlSub.add(txtTenHang_Sub, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        pnlSub.add(lblLoaiHang_Sub, gbc);
        gbc.gridx = 1;
        
        JPanel loaiHangPanel = new JPanel(new BorderLayout(5, 0));
        loaiHangPanel.setBackground(WHITE);
        txtLoaiHang_Sub.setPreferredSize(new Dimension(150, 30)); // Điều chỉnh kích thước
        loaiHangPanel.add(txtLoaiHang_Sub, BorderLayout.CENTER);
        btnType_Sub.setPreferredSize(new Dimension(75, 30));
        loaiHangPanel.add(btnType_Sub, BorderLayout.EAST);
        
        pnlSub.add(loaiHangPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        pnlSub.add(lblDonViTinh_Sub, gbc);
        gbc.gridx = 1;
        txtDonViTinh_Sub.setPreferredSize(new Dimension(230, 30)); // Tăng chiều rộng field
        pnlSub.add(txtDonViTinh_Sub, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        pnlSub.add(lblSoLuong_Sub, gbc);
        gbc.gridx = 1;
        txtSoLuong_Sub.setPreferredSize(new Dimension(230, 30)); // Tăng chiều rộng field
        pnlSub.add(txtSoLuong_Sub, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        pnlSub.add(lblGiaNhap, gbc);
        gbc.gridx = 1;
        txtGiaNhap_Sub.setPreferredSize(new Dimension(230, 30)); // Tăng chiều rộng field
        pnlSub.add(txtGiaNhap_Sub, gbc);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(WHITE);
        btnThoat_Sub.setPreferredSize(new Dimension(120, 35));
        btnXacNhan_Sub.setPreferredSize(new Dimension(120, 35));
        buttonPanel.add(btnThoat_Sub);
        buttonPanel.add(btnXacNhan_Sub);
        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(25, 12, 12, 6); // Thêm khoảng cách phía trên cho nút
        pnlSub.add(buttonPanel, gbc);
        
        // Thiết lập table hiển thị dữ liệu
        String[] columnNames = {"Mã hàng", "Tên hàng", "Loại hàng", "Đơn vị tính", "Số lượng tồn", "Giá nhập"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = createStyledTable(model);
        
        // Tạo header cho bảng với màu mới
        JTableHeader header = table.getTableHeader();
        header.setBackground(HEADER_COLOR);
        header.setForeground(BLACK);
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, PRIMARY_BLUE));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        
        // Thêm dữ liệu mẫu để hiển thị
        model.addRow(new Object[]{"MH001", "Nồi cơm điện", "Đồ Gia Dụng", "Cái", "15", "850000"});
        model.addRow(new Object[]{"MH002", "Bếp điện từ", "Đồ Gia Dụng", "Cái", "8", "1200000"});
        model.addRow(new Object[]{"MH003", "Gạo Jasmine", "Nhu Yếu Phẩm", "Kg", "100", "15000"});
        model.addRow(new Object[]{"MH004", "Dầu ăn", "Nhu Yếu Phẩm", "Chai", "50", "45000"});
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        scrollPane.getViewport().setBackground(WHITE);
        
        pnlContent.add(scrollPane, BorderLayout.CENTER);
        
        hideSubPanelElements();
        
        btnNhapKho_Control_HangMoi.addActionListener(e -> {
            pnlSearch.setVisible(false);
            
            showSubPanelElements();
            clearFields();
            txtMaHang_Sub.setEditable(true); 
        });
        
        btnNhapKho_Control_HangCoSan.addActionListener(e -> {
            pnlSearch.setVisible(true);
            
            hideSubPanelElements();
            
            txtTiemKiemTheoMa_Control.setText("");
        });
        
        btnXuatKhoa_Control.addActionListener(e->{
            pnlSearch.setVisible(true);
            
            hideSubPanelElements();
            
            txtTiemKiemTheoMa_Control.setText("");
        });
        
        
        btnTimKiem_Control.addActionListener(e -> {
            // Xử lý tìm kiếm hàng có sẵn
            String maHangTimKiem = txtTiemKiemTheoMa_Control.getText().trim();
            if (!maHangTimKiem.isEmpty()) {
                // Giả lập tìm thấy hàng và hiển thị thông tin
                showSubPanelElements();
                // Đổ dữ liệu giả định vào form
                txtMaHang_Sub.setText(maHangTimKiem);
                txtMaHang_Sub.setEditable(false); // Không cho phép sửa mã hàng
                
                // Tìm trong bảng và điền các thông tin
                boolean found = false;
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(maHangTimKiem)) {
                        txtTenHang_Sub.setText(model.getValueAt(i, 1).toString());
                        txtLoaiHang_Sub.setText(model.getValueAt(i, 2).toString());
                        txtDonViTinh_Sub.setText(model.getValueAt(i, 3).toString());
                        txtSoLuong_Sub.setText(model.getValueAt(i, 4).toString());
                        txtGiaNhap_Sub.setText(model.getValueAt(i, 5).toString());
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy mã hàng: " + maHangTimKiem, "Thông báo", JOptionPane.WARNING_MESSAGE);
                    hideSubPanelElements();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hàng cần tìm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        btnThoat_Sub.addActionListener(e -> {
            hideSubPanelElements();
            pnlSearch.setVisible(false);
            txtTiemKiemTheoMa_Control.setText("");
        });
        
        btnXacNhan_Sub.addActionListener(e -> {
            // Kiểm tra dữ liệu nhập vào
            if (validateInput()) {
                // Xử lý xác nhận
                JOptionPane.showMessageDialog(this, "Lưu thông tin thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                
                // Thêm vào bảng nếu là nhập mới
                if (txtMaHang_Sub.isEditable()) {
                    model.addRow(new Object[]{
                        txtMaHang_Sub.getText(),
                        txtTenHang_Sub.getText(),
                        txtLoaiHang_Sub.getText(),
                        txtDonViTinh_Sub.getText(),
                        txtSoLuong_Sub.getText(),
                        txtGiaNhap_Sub.getText()
                    });
                } else {
                    // Cập nhật dữ liệu hiện có
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (model.getValueAt(i, 0).equals(txtMaHang_Sub.getText())) {
                            model.setValueAt(txtTenHang_Sub.getText(), i, 1);
                            model.setValueAt(txtLoaiHang_Sub.getText(), i, 2);
                            model.setValueAt(txtDonViTinh_Sub.getText(), i, 3);
                            model.setValueAt(txtSoLuong_Sub.getText(), i, 4);
                            model.setValueAt(txtGiaNhap_Sub.getText(), i, 5);
                            break;
                        }
                    }
                }
                
                hideSubPanelElements();
                pnlSearch.setVisible(false);
            }
        });

        // Thêm các panel vào frame
        pnlEdit.add(pnlControl, BorderLayout.NORTH);
        pnlEdit.add(pnlSub, BorderLayout.CENTER);
        
        add(pnlEdit, BorderLayout.WEST);
        add(pnlContent, BorderLayout.CENTER);
        
        // Thêm tiêu đề cho giao diện với màu mới
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(PRIMARY_BLUE);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 50));
        
        JLabel titleLabel = new JLabel("HỆ THỐNG QUẢN LÝ KHO HÀNG", JLabel.CENTER);
        titleLabel.setForeground(WHITE);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        
        add(headerPanel, BorderLayout.NORTH);
        
        setVisible(true);
        setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
    }
    
    // Phương thức kiểm tra dữ liệu nhập vào
    private boolean validateInput() {
        if (txtMaHang_Sub.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaHang_Sub.requestFocus();
            return false;
        }
        
        if (txtTenHang_Sub.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtTenHang_Sub.requestFocus();
            return false;
        }
        
        if (txtLoaiHang_Sub.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại hàng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            btnType_Sub.requestFocus();
            return false;
        }
        
        if (txtDonViTinh_Sub.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn vị tính!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtDonViTinh_Sub.requestFocus();
            return false;
        }
        
        // Kiểm tra số lượng là số hợp lệ
        try {
            int soLuong = Integer.parseInt(txtSoLuong_Sub.getText().trim());
            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtSoLuong_Sub.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSoLuong_Sub.requestFocus();
            return false;
        }
        
        // Kiểm tra giá nhập là số hợp lệ
        try {
            double giaNhap = Double.parseDouble(txtGiaNhap_Sub.getText().trim());
            if (giaNhap < 0) {
                JOptionPane.showMessageDialog(this, "Giá nhập phải là số dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtGiaNhap_Sub.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtGiaNhap_Sub.requestFocus();
            return false;
        }
        
        return true;
    }
    
    // Phương thức tạo nút có style đẹp
    private JButton createStyledButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hiệu ứng hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (button.isEnabled()) {
                    button.setBackground(bgColor.darker());
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (button.isEnabled()) {
                    button.setBackground(bgColor);
                }
            }
        });
        
        return button;
    }
    
    // Phương thức tạo menu item có style đẹp
    private JMenuItem createStyledMenuItem(String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuItem.setBackground(BLACK);
        menuItem.setForeground(PRIMARY_BLUE);
        // Hiệu ứng hover cho menu item
        menuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                menuItem.setBackground(LIGHT_BLUE);
                menuItem.setForeground(WHITE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                menuItem.setBackground(WHITE);
                menuItem.setForeground(PRIMARY_BLUE);
            }
        });
        return menuItem;
    }
    
    // Phương thức tạo text field có style đẹp
    private JTextField createStyledTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        return textField;
    }
    
    // Phương thức tạo label có style đẹp
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(70, 70, 70));
        return label;
    }
    
    // Phương thức tạo bảng có style đẹp
    private JTable createStyledTable(DefaultTableModel model) {
        JTable table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                
                // Tạo hiệu ứng zebra stripes
                if (!isRowSelected(row)) {
                    comp.setBackground(row % 2 == 0 ? Color.WHITE : new Color(240, 240, 250));
                }
                
                // Canh giữa cho cột số lượng và giá nhập
                if (column == 4 || column == 5) {
                    ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
                } else {
                    ((JLabel) comp).setHorizontalAlignment(JLabel.LEFT);
                }
                
                return comp;
            }
        };
        
        table.setRowHeight(35);
        table.setIntercellSpacing(new Dimension(10, 0));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setShowGrid(false);
        table.setSelectionBackground(new Color(210, 230, 255));
        table.setSelectionForeground(PRIMARY_BLUE);
        table.setFocusable(false);
        table.getTableHeader().setReorderingAllowed(false);
        
        // Đảm bảo cột cuối cùng sẽ lấp đầy không gian còn lại
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        return table;
    }
    
    // Phương thức để ẩn các phần tử trong pnlSub
    private void hideSubPanelElements() {
        lblMaHang_Sub.setVisible(false);
        txtMaHang_Sub.setVisible(false);
        lblTenHang_Sub.setVisible(false);
        txtTenHang_Sub.setVisible(false);
        lblLoaiHang_Sub.setVisible(false);
        txtLoaiHang_Sub.setVisible(false);
        btnType_Sub.setVisible(false);
        lblDonViTinh_Sub.setVisible(false);
        txtDonViTinh_Sub.setVisible(false);
        lblGiaNhap.setVisible(false);
        txtGiaNhap_Sub.setVisible(false);
        lblSoLuong_Sub.setVisible(false);
        txtSoLuong_Sub.setVisible(false);
        btnXacNhan_Sub.setVisible(false);
        btnThoat_Sub.setVisible(false);
    }
    
    // Phương thức để hiển thị các phần tử trong pnlSub
    private void showSubPanelElements() {
        lblMaHang_Sub.setVisible(true);
        txtMaHang_Sub.setVisible(true);
        lblTenHang_Sub.setVisible(true);
        txtTenHang_Sub.setVisible(true);
        lblLoaiHang_Sub.setVisible(true);
        txtLoaiHang_Sub.setVisible(true);
        btnType_Sub.setVisible(true);
        lblDonViTinh_Sub.setVisible(true);
        txtDonViTinh_Sub.setVisible(true);
        lblGiaNhap.setVisible(true);
        txtGiaNhap_Sub.setVisible(true);
        lblSoLuong_Sub.setVisible(true);
        txtSoLuong_Sub.setVisible(true);
        btnXacNhan_Sub.setVisible(true);
        btnThoat_Sub.setVisible(true);
    }
    
    // Phương thức để xóa nội dung các trường nhập liệu
    private void clearFields() {
        txtMaHang_Sub.setText("");
        txtTenHang_Sub.setText("");
        txtLoaiHang_Sub.setText("");
        txtDonViTinh_Sub.setText("");
        txtGiaNhap_Sub.setText("");
        txtSoLuong_Sub.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KhoHang_GUI().setVisible(true);
            }
        });
    }
}
