package UI;

import BLL.PhieuNhapHang_BLL;
import DTO.PhieuNhapHang_DTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.TitledBorder;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.*;

public class PhieuNhapHangJFrame extends JFrame {
    
    private JPanel panelThongTin, panelChucNang, panelTimKiem, panelBang;
    private JLabel lblMaPhieu, lblMaNhanVien, lblMaNhaCungCap, lblNgayNhap, lblTongTien;
    private JLabel lblTuNgay, lblDenNgay, lblTimNCC;
    private JTextField txtMaPhieu, txtMaNhanVien, txtMaNhaCungCap, txtNgayNhap, txtTongTien;
    private JTextField txtTuNgay, txtDenNgay, txtTimNCC;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi, btnTimKiem, btnXuatExcel;
    private JTable tablePhieuNhap;
    private DefaultTableModel tableModel;
    
    private PhieuNhapHang_BLL phieuNhapHangBLL;
    
    public PhieuNhapHangJFrame() {
        phieuNhapHangBLL = new PhieuNhapHang_BLL();
        initComponents();
        loadData();
    }
    
    private void initComponents() {
        setTitle("Quản Lý Phiếu Nhập Hàng");
        setSize(1500, 1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Panel chứa thông tin phiếu nhập
        panelThongTin = new JPanel();
        panelThongTin.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Thông tin phiếu nhập", 
                TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("Arial", Font.BOLD, 14)));
        panelThongTin.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Dòng 1
        lblMaPhieu = new JLabel("Mã phiếu nhập:");
        lblMaPhieu.setFont(new Font("Arial", Font.PLAIN, 14));
        txtMaPhieu = new JTextField(15);
        txtMaPhieu.setEditable(false); // Mã phiếu tự động
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelThongTin.add(lblMaPhieu, gbc);
        
        gbc.gridx = 1;
        panelThongTin.add(txtMaPhieu, gbc);
        
        lblMaNhanVien = new JLabel("Mã nhân viên:");
        lblMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
        txtMaNhanVien = new JTextField(15);
        
        gbc.gridx = 2;
        panelThongTin.add(lblMaNhanVien, gbc);
        
        gbc.gridx = 3;
        panelThongTin.add(txtMaNhanVien, gbc);
        
        // Dòng 2
        lblMaNhaCungCap = new JLabel("Mã nhà cung cấp:");
        lblMaNhaCungCap.setFont(new Font("Arial", Font.PLAIN, 14));
        txtMaNhaCungCap = new JTextField(15);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelThongTin.add(lblMaNhaCungCap, gbc);
        
        gbc.gridx = 1;
        panelThongTin.add(txtMaNhaCungCap, gbc);
        
        lblNgayNhap = new JLabel("Ngày nhập (yyyy-MM-dd):");
        lblNgayNhap.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNgayNhap = new JTextField(15);
        txtNgayNhap.setText(LocalDate.now().toString()); // Mặc định là ngày hiện tại
        
        gbc.gridx = 2;
        panelThongTin.add(lblNgayNhap, gbc);
        
        gbc.gridx = 3;
        panelThongTin.add(txtNgayNhap, gbc);
        
        // Dòng 3
        lblTongTien = new JLabel("Tổng tiền:");
        lblTongTien.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTongTien = new JTextField(15);
        txtTongTien.setText("0");
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelThongTin.add(lblTongTien, gbc);
        
        gbc.gridx = 1;
        panelThongTin.add(txtTongTien, gbc);
        
        add(panelThongTin, BorderLayout.NORTH);
        
        // Panel chức năng
        panelChucNang = new JPanel();
        panelChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelChucNang.setBorder(BorderFactory.createEtchedBorder());
        
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        
        // Thiết lập icon và font cho các button
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        btnThem.setFont(buttonFont);
        btnSua.setFont(buttonFont);
        btnXoa.setFont(buttonFont);
        btnLamMoi.setFont(buttonFont);
        
        panelChucNang.add(btnThem);
        panelChucNang.add(btnSua);
        panelChucNang.add(btnXoa);
        panelChucNang.add(btnLamMoi);
        
        // Panel tìm kiếm
        panelTimKiem = new JPanel();
        panelTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelTimKiem.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Tìm kiếm", 
                TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("Arial", Font.BOLD, 14)));
        
        lblTuNgay = new JLabel("Từ ngày:");
        lblTuNgay.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTuNgay = new JTextField(10);
        
        lblDenNgay = new JLabel("Đến ngày:");
        lblDenNgay.setFont(new Font("Arial", Font.PLAIN, 14));
        txtDenNgay = new JTextField(10);
        
        lblTimNCC = new JLabel("Mã NCC:");
        lblTimNCC.setFont(new Font("Arial", Font.PLAIN, 14));
        txtTimNCC = new JTextField(10);
        
        btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setFont(buttonFont);
        
        btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.setFont(buttonFont);
        
        panelTimKiem.add(lblTuNgay);
        panelTimKiem.add(txtTuNgay);
        panelTimKiem.add(lblDenNgay);
        panelTimKiem.add(txtDenNgay);
        panelTimKiem.add(lblTimNCC);
        panelTimKiem.add(txtTimNCC);
        panelTimKiem.add(btnTimKiem);
        panelTimKiem.add(btnXuatExcel);
        
        // Panel kết hợp chức năng và tìm kiếm
        JPanel panelControls = new JPanel(new BorderLayout());
        panelControls.add(panelChucNang, BorderLayout.NORTH);
        panelControls.add(panelTimKiem, BorderLayout.CENTER);
        
        add(panelControls, BorderLayout.CENTER);
        
        // Bảng hiển thị phiếu nhập hàng
        panelBang = new JPanel(new BorderLayout());
        panelBang.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Danh sách phiếu nhập hàng", 
                TitledBorder.LEFT, TitledBorder.TOP, 
                new Font("Arial", Font.BOLD, 14)));
        
        String[] columnNames = {"Mã phiếu", "Mã NV", "Mã NCC", "Ngày nhập", "Tổng tiền"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa trực tiếp trên bảng
            }
        };
        
        tablePhieuNhap = new JTable(tableModel);
        tablePhieuNhap.setRowHeight(25);
        tablePhieuNhap.setFont(new Font("Arial", Font.PLAIN, 14));
        tablePhieuNhap.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        
        JScrollPane scrollPane = new JScrollPane(tablePhieuNhap);
        panelBang.add(scrollPane, BorderLayout.CENTER);
        
        add(panelBang, BorderLayout.SOUTH);
        
        // Thêm listeners
        addEventListeners();
        
        // Cập nhật mã phiếu nhập tự động
        updateMaPhieuNhap();
    }
    
    private void addEventListeners() {
        // Sự kiện click vào bảng
        tablePhieuNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tablePhieuNhap.getSelectedRow();
                if (selectedRow >= 0) {
                    String maPhieu = tableModel.getValueAt(selectedRow, 0).toString();
                    String maNV = tableModel.getValueAt(selectedRow, 1).toString();
                    String maNCC = tableModel.getValueAt(selectedRow, 2).toString();
                    String ngayNhap = tableModel.getValueAt(selectedRow, 3).toString();
                    String tongTien = tableModel.getValueAt(selectedRow, 4).toString();
                    tongTien = tongTien.replaceAll("[^\\d.]", ""); // Xóa các ký tự định dạng
                    
                    txtMaPhieu.setText(maPhieu);
                    txtMaNhanVien.setText(maNV);
                    txtMaNhaCungCap.setText(maNCC);
                    txtNgayNhap.setText(ngayNhap);
                    txtTongTien.setText(tongTien);
                }
            }
        });
        
        // Sự kiện nút Thêm
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themPhieuNhap();
            }
        });
        
        // Sự kiện nút Sửa
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaPhieuNhap();
            }
        });
        
        // Sự kiện nút Xóa
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaPhieuNhap();
            }
        });
        
        // Sự kiện nút Làm mới
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lamMoi();
            }
        });
        
        // Sự kiện nút Tìm kiếm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiem();
            }
        });
        
        // Sự kiện nút Xuất Excel
        btnXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuatExcel();
            }
        });
    }
    
    private void updateMaPhieuNhap() {
        String maPhieuMoi = phieuNhapHangBLL.taoMaPhieuNhapHangTiepTheo();
        txtMaPhieu.setText(maPhieuMoi);
    }
    
    private void loadData() {
        // Xóa dữ liệu cũ
        tableModel.setRowCount(0);
        
        // Lấy danh sách phiếu nhập từ BLL
        List<PhieuNhapHang_DTO> danhSachPhieuNhap = phieuNhapHangBLL.getAllPhieuNhapHang();
        
        if (danhSachPhieuNhap != null) {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            
            for (PhieuNhapHang_DTO phieuNhap : danhSachPhieuNhap) {
                String formattedTongTien = currencyFormat.format(phieuNhap.getTongTien());
                
                Object[] row = {
                    phieuNhap.getMaPhieuNhap(),
                    phieuNhap.getMaNhanVien(),
                    phieuNhap.getMaNhaCungCap(),
                    phieuNhap.getNgayNhap().toString(),
                    formattedTongTien
                };
                tableModel.addRow(row);
            }
        }
    }
    
    private PhieuNhapHang_DTO getPhieuNhapFromForm() {
        try {
            String maPhieu = txtMaPhieu.getText().trim();
            String maNhanVien = txtMaNhanVien.getText().trim();
            String maNhaCungCap = txtMaNhaCungCap.getText().trim();
            String ngayNhapStr = txtNgayNhap.getText().trim();
            String tongTienStr = txtTongTien.getText().trim();
            
            // Kiểm tra dữ liệu
            if (maPhieu.isEmpty() || maNhanVien.isEmpty() || maNhaCungCap.isEmpty() || 
                ngayNhapStr.isEmpty() || tongTienStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            // Parse ngày nhập
            LocalDate ngayNhap;
            try {
                ngayNhap = LocalDate.parse(ngayNhapStr);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ. Vui lòng nhập theo định dạng yyyy-MM-dd", 
                                         "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            // Parse tổng tiền
            double tongTien;
            try {
                tongTien = Double.parseDouble(tongTienStr.replaceAll("[^\\d.]", "")); // Xóa các ký tự định dạng
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Tổng tiền không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            return new PhieuNhapHang_DTO(maPhieu, maNhanVien, maNhaCungCap, ngayNhap, tongTien);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi đọc dữ liệu từ form: " + e.getMessage(), 
                                     "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    private void themPhieuNhap() {
        PhieuNhapHang_DTO phieuNhap = getPhieuNhapFromForm();
        if (phieuNhap != null) {
            boolean result = phieuNhapHangBLL.themPhieuNhapHang(phieuNhap);
            if (result) {
                JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thành công!");
                loadData();
                lamMoi();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thất bại. Vui lòng kiểm tra lại thông tin!", 
                                         "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void suaPhieuNhap() {
        int selectedRow = tablePhieuNhap.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập cần sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        PhieuNhapHang_DTO phieuNhap = getPhieuNhapFromForm();
        if (phieuNhap != null) {
            boolean result = phieuNhapHangBLL.capNhatPhieuNhapHang(phieuNhap);
            if (result) {
                JOptionPane.showMessageDialog(this, "Cập nhật phiếu nhập thành công!");
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật phiếu nhập thất bại. Vui lòng kiểm tra lại thông tin!", 
                                         "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void xoaPhieuNhap() {
        int selectedRow = tablePhieuNhap.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String maPhieu = tableModel.getValueAt(selectedRow, 0).toString();
        
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa phiếu nhập có mã " + maPhieu + "?", 
                "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean result = phieuNhapHangBLL.xoaPhieuNhapHang(maPhieu);
            if (result) {
                JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thành công!");
                loadData();
                lamMoi();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa phiếu nhập thất bại. Có thể phiếu đã được sử dụng ở nơi khác!", 
                                         "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void lamMoi() {
        // Cập nhật mã phiếu nhập tự động
        updateMaPhieuNhap();
        
        txtMaNhanVien.setText("");
        txtMaNhaCungCap.setText("");
        txtNgayNhap.setText(LocalDate.now().toString());
        txtTongTien.setText("0");
        
        txtTuNgay.setText("");
        txtDenNgay.setText("");
        txtTimNCC.setText("");
        
        // Làm mới bảng
        loadData();
        
        // Bỏ chọn dòng trong bảng
        tablePhieuNhap.clearSelection();
    }
    
    private void timKiem() {
        String maNCC = txtTimNCC.getText().trim();
        String tuNgayStr = txtTuNgay.getText().trim();
        String denNgayStr = txtDenNgay.getText().trim();
        
        // Xóa dữ liệu cũ trong bảng
        tableModel.setRowCount(0);
        
        List<PhieuNhapHang_DTO> ketQuaTimKiem = null;
        
        try {
            // Tìm theo nhà cung cấp
            if (!maNCC.isEmpty() && tuNgayStr.isEmpty() && denNgayStr.isEmpty()) {
                ketQuaTimKiem = phieuNhapHangBLL.timKiemTheoNhaCungCap(maNCC);
            } 
            // Tìm theo khoảng thời gian
            else if (maNCC.isEmpty() && !tuNgayStr.isEmpty() && !denNgayStr.isEmpty()) {
                LocalDate tuNgay = LocalDate.parse(tuNgayStr);
                LocalDate denNgay = LocalDate.parse(denNgayStr);
                ketQuaTimKiem = phieuNhapHangBLL.timKiemTheoKhoangThoiGian(tuNgay, denNgay);
            }
            // Không có điều kiện tìm kiếm hoặc có cả hai điều kiện (chưa xử lý case này)
            else {
                // Nếu không có điều kiện tìm kiếm, hiển thị tất cả
                if (maNCC.isEmpty() && tuNgayStr.isEmpty() && denNgayStr.isEmpty()) {
                    loadData();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng tìm kiếm theo một điều kiện (hoặc NCC hoặc khoảng thời gian)!", 
                                             "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            
            // Hiển thị kết quả tìm kiếm
            if (ketQuaTimKiem != null && !ketQuaTimKiem.isEmpty()) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                
                for (PhieuNhapHang_DTO phieuNhap : ketQuaTimKiem) {
                    String formattedTongTien = currencyFormat.format(phieuNhap.getTongTien());
                    
                    Object[] row = {
                        phieuNhap.getMaPhieuNhap(),
                        phieuNhap.getMaNhanVien(),
                        phieuNhap.getMaNhaCungCap(),
                        phieuNhap.getNgayNhap().toString(),
                        formattedTongTien
                    };
                    tableModel.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp!", 
                                         "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày. Vui lòng nhập theo định dạng yyyy-MM-dd", 
                                     "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm: " + e.getMessage(), 
                                     "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void xuatExcel() {
        // Phần này sẽ được triển khai khi có thư viện xuất Excel
        JOptionPane.showMessageDialog(this, "Chức năng xuất Excel sẽ được triển khai sau!", 
                                 "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Main method để test
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuNhapHangJFrame().setVisible(true);
            }
        });
    }
}
