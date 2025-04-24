package UI;

import BLL.NhaCungCap_BLL;
import DTO.NhaCungCap_DTO;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class QuanLyNhaCungCap_GUI extends JFrame {
    private JTable tableNhaCungCap;
    private DefaultTableModel modelNhaCungCap;
    private JTextField txtMaNCC, txtTenNCC, txtDiaChi, txtSoDienThoai, txtTimKiem;
    private JButton btnThem, btnSua, btnXoa, btnLamMoi, btnTimKiem;
    
    private NhaCungCap_BLL nhaCungCapBLL;
    
    public QuanLyNhaCungCap_GUI() {
        // Thiết lập JFrame
        setTitle("Quản Lý Nhà Cung Cấp");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE để có thể đóng cửa sổ mà không đóng ứng dụng
        setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
        
        // Khởi tạo BLL
        nhaCungCapBLL = new NhaCungCap_BLL();
        
        // Khởi tạo giao diện
        initComponents();
        
        // Tải dữ liệu ban đầu
        loadDanhSachNhaCungCap();
    }
    
    private void initComponents() {
        // Panel chính chứa tất cả các thành phần
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Panel thông tin nhà cung cấp
        JPanel panelThongTin = new JPanel();
        panelThongTin.setLayout(new GridBagLayout());
        panelThongTin.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Thông tin nhà cung cấp", 
                TitledBorder.LEFT, TitledBorder.TOP));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Mã nhà cung cấp
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelThongTin.add(new JLabel("Mã nhà cung cấp:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtMaNCC = new JTextField(20);
        txtMaNCC.setEditable(false); // Mã tự động, không cho phép sửa
        panelThongTin.add(txtMaNCC, gbc);
        
        // Tên nhà cung cấp
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelThongTin.add(new JLabel("Tên nhà cung cấp:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtTenNCC = new JTextField(20);
        panelThongTin.add(txtTenNCC, gbc);
        
        // Địa chỉ
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelThongTin.add(new JLabel("Địa chỉ:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtDiaChi = new JTextField(20);
        panelThongTin.add(txtDiaChi, gbc);
        
        // Số điện thoại
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelThongTin.add(new JLabel("Số điện thoại:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtSoDienThoai = new JTextField(20);
        panelThongTin.add(txtSoDienThoai, gbc);
        
        // Panel chức năng
        JPanel panelChucNang = new JPanel();
        panelChucNang.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnLamMoi = new JButton("Làm mới");
        
        panelChucNang.add(btnThem);
        panelChucNang.add(btnSua);
        panelChucNang.add(btnXoa);
        panelChucNang.add(btnLamMoi);
        
        // Panel tìm kiếm
        JPanel panelTimKiem = new JPanel();
        panelTimKiem.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelTimKiem.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Tìm kiếm", 
                TitledBorder.LEFT, TitledBorder.TOP));
        
        txtTimKiem = new JTextField(25);
        btnTimKiem = new JButton("Tìm kiếm");
        
        panelTimKiem.add(new JLabel("Từ khóa:"));
        panelTimKiem.add(txtTimKiem);
        panelTimKiem.add(btnTimKiem);
        
        // Panel thông tin và chức năng
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BorderLayout());
        panelTop.add(panelThongTin, BorderLayout.CENTER);
        panelTop.add(panelChucNang, BorderLayout.SOUTH);
        
        // Panel bảng dữ liệu
        JPanel panelTable = new JPanel();
        panelTable.setLayout(new BorderLayout());
        panelTable.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Danh sách nhà cung cấp", 
                TitledBorder.LEFT, TitledBorder.TOP));
        
        // Tạo model cho bảng
        modelNhaCungCap = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa trực tiếp trên bảng
            }
        };
        modelNhaCungCap.addColumn("Mã NCC");
        modelNhaCungCap.addColumn("Tên nhà cung cấp");
        modelNhaCungCap.addColumn("Địa chỉ");
        modelNhaCungCap.addColumn("Số điện thoại");
        
        tableNhaCungCap = new JTable(modelNhaCungCap);
        tableNhaCungCap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableNhaCungCap.setRowHeight(25);
        
        JScrollPane scrollPane = new JScrollPane(tableNhaCungCap);
        panelTable.add(scrollPane, BorderLayout.CENTER);
        
        // Thêm các panel vào panel chính
        mainPanel.add(panelTop, BorderLayout.NORTH);
        mainPanel.add(panelTimKiem, BorderLayout.CENTER);
        mainPanel.add(panelTable, BorderLayout.SOUTH);
        
        // Thêm panel chính vào JFrame
        setContentPane(mainPanel);
        
        // Đăng ký sự kiện
        addEvents();
        
        // Thiết lập trạng thái ban đầu
        resetForm();
    }
    
    private void addEvents() {
        // Sự kiện chọn dòng trong bảng
        tableNhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableNhaCungCap.getSelectedRow();
                if (selectedRow >= 0) {
                    txtMaNCC.setText(tableNhaCungCap.getValueAt(selectedRow, 0).toString());
                    txtTenNCC.setText(tableNhaCungCap.getValueAt(selectedRow, 1).toString());
                    txtDiaChi.setText(tableNhaCungCap.getValueAt(selectedRow, 2).toString());
                    txtSoDienThoai.setText(tableNhaCungCap.getValueAt(selectedRow, 3).toString());
                    
                    // Kích hoạt các nút chức năng
                    btnSua.setEnabled(true);
                    btnXoa.setEnabled(true);
                }
            }
        });
        
        // Sự kiện nút Thêm
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themNhaCungCap();
            }
        });
        
        // Sự kiện nút Sửa
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaNhaCungCap();
            }
        });
        
        // Sự kiện nút Xóa
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaNhaCungCap();
            }
        });
        
        // Sự kiện nút Làm mới
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
                loadDanhSachNhaCungCap();
            }
        });
        
        // Sự kiện nút Tìm kiếm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiemNhaCungCap();
            }
        });
        
        // Sự kiện Enter trong ô tìm kiếm
        txtTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiemNhaCungCap();
            }
        });
    }
    
    private void loadDanhSachNhaCungCap() {
        // Xóa dữ liệu cũ
        modelNhaCungCap.setRowCount(0);
        
        // Lấy danh sách nhà cung cấp
        ArrayList<NhaCungCap_DTO> danhSachNCC = nhaCungCapBLL.layDanhSachNhaCungCap();
        
        // Hiển thị lên bảng
        for (NhaCungCap_DTO ncc : danhSachNCC) {
            modelNhaCungCap.addRow(new Object[] {
                ncc.getMaNhaCungCap(),
                ncc.getTenNhaCungCap(),
                ncc.getDiaChi(),
                ncc.getSoDienThoai()
            });
        }
    }
    
    private void themNhaCungCap() {
        // Kiểm tra xem đang ở chế độ thêm mới chưa
        if (!txtMaNCC.getText().isEmpty() && !txtMaNCC.getText().equals(nhaCungCapBLL.layMaNhaCungCapMoiNhat())) {
            int choice = JOptionPane.showConfirmDialog(this, 
                    "Bạn đang chỉnh sửa một nhà cung cấp hiện có. Bạn có muốn chuyển sang thêm mới không?", 
                    "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice != JOptionPane.YES_OPTION) {
                return;
            }
            resetForm();
        }
        
        // Lấy thông tin từ form
        String maNCC = txtMaNCC.getText().trim();
        String tenNCC = txtTenNCC.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String soDienThoai = txtSoDienThoai.getText().trim();
        
        // Tạo đối tượng DTO
        NhaCungCap_DTO ncc = new NhaCungCap_DTO(maNCC, tenNCC, diaChi, soDienThoai);
        
        // Gọi phương thức thêm từ BLL
        String ketQua = nhaCungCapBLL.themNhaCungCap(ncc);
        
        if (ketQua.equals("true")) {
            JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công!");
            resetForm();
            loadDanhSachNhaCungCap();
        } else {
            JOptionPane.showMessageDialog(this, ketQua, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void suaNhaCungCap() {
        // Kiểm tra xem đã chọn nhà cung cấp chưa
        int selectedRow = tableNhaCungCap.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp cần sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Hiển thị dialog xác nhận
        int choice = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn cập nhật thông tin nhà cung cấp này?", 
                "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        
        // Lấy thông tin từ form
        String maNCC = txtMaNCC.getText().trim();
        String tenNCC = txtTenNCC.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String soDienThoai = txtSoDienThoai.getText().trim();
        
        // Tạo đối tượng DTO
        NhaCungCap_DTO ncc = new NhaCungCap_DTO(maNCC, tenNCC, diaChi, soDienThoai);
        
        // Gọi phương thức cập nhật từ BLL
        String ketQua = nhaCungCapBLL.capNhatNhaCungCap(ncc);
        
        if (ketQua.equals("true")) {
            JOptionPane.showMessageDialog(this, "Cập nhật nhà cung cấp thành công!");
            resetForm();
            loadDanhSachNhaCungCap();
        } else {
            JOptionPane.showMessageDialog(this, ketQua, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void xoaNhaCungCap() {
        // Kiểm tra xem đã chọn nhà cung cấp chưa
        int selectedRow = tableNhaCungCap.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Hiển thị dialog xác nhận
        int choice = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc chắn muốn xóa nhà cung cấp này? Hành động này không thể hoàn tác!", 
                "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        
        // Lấy mã nhà cung cấp
        String maNCC = txtMaNCC.getText().trim();
        
        // Gọi phương thức xóa từ BLL
        String ketQua = nhaCungCapBLL.xoaNhaCungCap(maNCC);
        
        if (ketQua.equals("true")) {
            JOptionPane.showMessageDialog(this, "Xóa nhà cung cấp thành công!");
            resetForm();
            loadDanhSachNhaCungCap();
        } else {
            JOptionPane.showMessageDialog(this, ketQua, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void timKiemNhaCungCap() {
        String tuKhoa = txtTimKiem.getText().trim();
        
        ArrayList<NhaCungCap_DTO> ketQua = nhaCungCapBLL.timKiemNhaCungCap(tuKhoa);
        
        // Xóa dữ liệu cũ trên bảng
        modelNhaCungCap.setRowCount(0);
        
        // Hiển thị kết quả tìm kiếm
        for (NhaCungCap_DTO ncc : ketQua) {
            modelNhaCungCap.addRow(new Object[] {
                ncc.getMaNhaCungCap(),
                ncc.getTenNhaCungCap(),
                ncc.getDiaChi(),
                ncc.getSoDienThoai()
            });
        }
        
        // Thông báo nếu không có kết quả
        if (ketQua.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp nào phù hợp!");
        }
    }
    
    private void resetForm() {
        // Lấy mã nhà cung cấp mới
        String maNccMoi = nhaCungCapBLL.layMaNhaCungCapMoiNhat();
        txtMaNCC.setText(maNccMoi);
        
        // Xóa các trường còn lại
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtSoDienThoai.setText("");
        txtTimKiem.setText("");
        
        // Thiết lập trạng thái các nút
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        
        // Bỏ chọn trong bảng
        tableNhaCungCap.clearSelection();
    }
    
    // Phương thức để chạy form riêng lẻ
    public static void main(String[] args) {
        try {
            // Thiết lập look and feel cho đẹp
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Tạo và hiển thị form
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuanLyNhaCungCap_GUI frame = new QuanLyNhaCungCap_GUI();
                frame.setVisible(true);
            }
        });
    }
}
