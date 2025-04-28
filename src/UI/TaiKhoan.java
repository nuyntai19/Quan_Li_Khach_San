package UI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import sql.DatabaseQLKS;
import java.util.ArrayList;
import DTO.LoaiPhongDTO;
import DTO.QuanLiPhongDTO;
import BLL.LoaiPhongBLL;
import BLL.QuanLiPhongBLL;


public class TaiKhoan extends javax.swing.JFrame {
    
    private ArrayList<QuanLiPhongDTO> danhSachPhongGoc = new ArrayList<>();
    
    public TaiKhoan() {
        initComponents();
        phongBLL = new QuanLiPhongBLL();
        model = (DefaultTableModel) tblDSPHONG.getModel(); 
        modelLoaiPhong = (DefaultTableModel) tblDSLOAIPHONG.getModel(); 
        
        loadData();
        loadDataLoaiPhongToTable();
        loadComboBoxLoaiPhong();
        
        tblDSPHONG.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSPHONG.getSelectedRow();
                if (selectedRow != -1) {
                    String maPhong = getValue(tblDSPHONG, selectedRow, 0);
                    String maLoaiPhong = getValue(tblDSPHONG, selectedRow, 1);
                    String soGiuong = getValue(tblDSPHONG, selectedRow, 2);
                    String donGia = getValue(tblDSPHONG, selectedRow, 3);
                    String trangThai = getValue(tblDSPHONG, selectedRow, 4);

                    // Gán dữ liệu vào các ô nhập
                    txtTenDangNhap.setText(maPhong);
                    TXSoGiuong.setText(soGiuong);
                    txtVaiTro.setText(donGia);
                    TXTrangThai.setText(trangThai);

                    // Chọn loại phòng trong ComboBox
                    for (int i = 0; i < CBMaLoaiPhong.getItemCount(); i++) {
                        String phong = CBMaLoaiPhong.getItemAt(i);
                        if (phong.equals(maLoaiPhong)) {
                            CBMaLoaiPhong.setSelectedIndex(i);
                            break;
                        }
                    }

                    // Đồng bộ chọn dòng trong bảng LoaiPhong
                    for (int i = 0; i < tblDSLOAIPHONG.getRowCount(); i++) {
                        String maLP = getValue(tblDSLOAIPHONG, i, 0); // Giả sử cột 0 là MaLoaiPhong
                        if (maLoaiPhong.equals(maLP)) {
                            tblDSLOAIPHONG.setRowSelectionInterval(i, i);
                            break;
                        }
                    }
                }
            }

            // Hàm tiện ích để lấy giá trị có kiểm null
            private String getValue(JTable table, int row, int col) {
                Object value = table.getValueAt(row, col);
                return value != null ? value.toString() : "";
            }
        });
        
        tblDSLOAIPHONG.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSLOAIPHONG.getSelectedRow();
                if (selectedRow != -1) {
                    String selectedMaLoaiPhong = getValue(tblDSLOAIPHONG, selectedRow, 0);

                    // Tìm và chọn tất cả dòng trong tblDSPHONG có cùng MaLoaiPhong
                    tblDSPHONG.clearSelection();
                    for (int i = 0; i < tblDSPHONG.getRowCount(); i++) {
                        String maLP = getValue(tblDSPHONG, i, 1); // Cột 1 là MaLoaiPhong
                        if (selectedMaLoaiPhong.equals(maLP)) {
                            tblDSPHONG.addRowSelectionInterval(i, i); // Chọn dòng đó
                        }
                    }
                }
            }
        });

    }
    
    private String getValue(JTable table, int row, int col) {
        Object value = table.getValueAt(row, col);
        return value != null ? value.toString() : "";
    }
    
    private void loadData() {
        try {
            model.setRowCount(0); // Xóa dữ liệu cũ

            // Đảm bảo rằng bảng đã có các cột cần thiết
            model.setColumnIdentifiers(new String[] {
                "Mã Phòng", "Mã Loại Phòng", "Số Giường", "Đơn Giá", "Trạng Thái"
            });

            // Lấy lại dữ liệu từ cơ sở dữ liệu
            danhSachPhongGoc = phongBLL.layDanhSachPhong();
            for (QuanLiPhongDTO phong : danhSachPhongGoc) {
                model.addRow(new Object[] {
                    phong.getMaPhong(), phong.getMaLoaiPhong(), phong.getSoGiuong(), phong.getDonGia(), phong.getTrangThai()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
        }
    }
    
    private void loadDataLoaiPhongToTable() {
        try {
            modelLoaiPhong.setRowCount(0);
            modelLoaiPhong.setColumnIdentifiers(new String[] {
                "Mã Loại Phòng", "Tên Loại Phòng", "Mô Tả"
            });

            LoaiPhongBLL loaiPhongBLL = new LoaiPhongBLL();
            ArrayList<LoaiPhongDTO> dsLoaiPhong = loaiPhongBLL.layDanhSachLoaiPhong();
            for (LoaiPhongDTO loai : dsLoaiPhong) {
                modelLoaiPhong.addRow(new Object[] {
                    loai.getMaLoaiPhong(), loai.getTenLoaiPhong(), loai.getMoTa()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải loại phòng: " + e.getMessage());
        }
    }
    
    private void loadComboBoxLoaiPhong() {
        try {
            CBMaLoaiPhong.removeAllItems();
            CBMaLoaiPhong.addItem("_");
            LoaiPhongBLL loaiPhongBLL = new LoaiPhongBLL();
            ArrayList<String> danhSachMaLoaiPhong = loaiPhongBLL.layDanhSachMaLoaiPhong();
            for (String maLoaiPhong : danhSachMaLoaiPhong) {
                CBMaLoaiPhong.addItem(maLoaiPhong);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi load danh sách mã loại phòng!");
        }
    }
    
    


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        menuBar3 = new java.awt.MenuBar();
        menu5 = new java.awt.Menu();
        menu6 = new java.awt.Menu();
        lbDangNhap = new javax.swing.JLabel();
        TXDangNhap = new javax.swing.JTextField();
        TXMK = new javax.swing.JTextField();
        NutDangNhap = new javax.swing.JButton();
        labelMK = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DSPhong = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        bGNam_Nu = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePhongTrong = new javax.swing.JTable();
        TXTenLP1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Tittle = new javax.swing.JLabel();
        self = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbMaPhong = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        lbMaLoaiPhong = new javax.swing.JLabel();
        lbSoGiuong = new javax.swing.JLabel();
        lbGiaThue = new javax.swing.JLabel();
        txtVaiTro = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        ButtonTim = new javax.swing.JButton();
        ButtonThem = new javax.swing.JButton();
        ButtonSua = new javax.swing.JButton();
        ButtonXoa = new javax.swing.JButton();
        lbTrangThai = new javax.swing.JLabel();
        TXTrangThai = new javax.swing.JTextField();
        jButtonResert = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JTextField();
        cbMaNhanVien = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSPHONG = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        KhachSan = new javax.swing.JButton();
        QuanLi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ButtonQLPhong = new javax.swing.JButton();
        ButtonQLDV = new javax.swing.JButton();
        ButtonQLNV = new javax.swing.JButton();
        ButtonQLNhaCUngCap = new javax.swing.JButton();
        ButtonThongKe = new javax.swing.JButton();
        ButtonQLNhapHang = new javax.swing.JButton();
        ButtonKhoHang = new javax.swing.JButton();
        ButtonTaoTaiKhoan1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jButton9.setText("jButton3");

        jLabel2.setBackground(new java.awt.Color(102, 204, 0));
        jLabel2.setText(".ftyghb");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        menu5.setLabel("File");
        menuBar3.add(menu5);

        menu6.setLabel("Edit");
        menuBar3.add(menu6);

        lbDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDangNhap.setText("Tên đăng nhập:");

        NutDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NutDangNhap.setText("Đăng Nhập");

        labelMK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelMK.setText("Mật khẩu: ");
        labelMK.setPreferredSize(new java.awt.Dimension(90, 17));

        jLabel3.setText("jLabel3");

        DSPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/room.png"))); // NOI18N
        DSPhong.setText("Danh Sách Phòng");
        DSPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        TablePhongTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablePhongTrong);

        TXTenLP1.setEditable(false);
        TXTenLP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenLP1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DatPhong");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));
        jPanel1.setPreferredSize(new java.awt.Dimension(1277, 78));

        Tittle.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        Tittle.setForeground(new java.awt.Color(255, 255, 255));
        Tittle.setText("KHÁCH SẠN LQHT");
        Tittle.setIconTextGap(10);

        self.setBackground(new java.awt.Color(52, 152, 219));
        self.setForeground(new java.awt.Color(255, 255, 255));
        self.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/user (1).png"))); // NOI18N
        self.setBorder(null);
        self.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(self, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(self, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tittle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TÀI KHOẢN ");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        lbMaPhong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaPhong.setText("Tên đăng nhập");

        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });

        lbMaLoaiPhong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaLoaiPhong.setText("Mật khẩu");

        lbSoGiuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuong.setText("Mã nhân viên:");

        lbGiaThue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbGiaThue.setText("Vai trò");

        txtVaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaiTroActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(52, 152, 219));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField2.setEnabled(false);

        ButtonTim.setBackground(new java.awt.Color(52, 152, 219));
        ButtonTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTim.setForeground(new java.awt.Color(255, 255, 255));
        ButtonTim.setText("Tìm");
        ButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTimActionPerformed(evt);
            }
        });

        ButtonThem.setBackground(new java.awt.Color(52, 152, 219));
        ButtonThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonThem.setForeground(new java.awt.Color(255, 255, 255));
        ButtonThem.setText("Thêm");
        ButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonThemActionPerformed(evt);
            }
        });

        ButtonSua.setBackground(new java.awt.Color(52, 152, 219));
        ButtonSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonSua.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSua.setText("Sửa");
        ButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSuaActionPerformed(evt);
            }
        });

        ButtonXoa.setBackground(new java.awt.Color(52, 152, 219));
        ButtonXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonXoa.setForeground(new java.awt.Color(255, 255, 255));
        ButtonXoa.setText("Xóa");
        ButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXoaActionPerformed(evt);
            }
        });

        lbTrangThai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTrangThai.setText("Trạng thái: ");

        TXTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTrangThaiActionPerformed(evt);
            }
        });

        jButtonResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        jButtonResert.setBorderPainted(false);
        jButtonResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });

        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        tblDSPHONG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã tài khoản", "Tên đăng nhập", "Mật khẩu", "Mã nhân viên", "Vai trò", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDSPHONG);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(cbMaNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(128, 128, 128)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TXTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(494, 494, 494))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonResert)
                        .addGap(28, 28, 28))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonThem)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMaNhanVien)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonSua)
                        .addComponent(lbSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonXoa)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonResert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(ButtonTim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        KhachSan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        KhachSan.setText("Khách Sạn");
        KhachSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhachSanActionPerformed(evt);
            }
        });

        QuanLi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        QuanLi.setText("Quản Lí");
        QuanLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuanLiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KhachSan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(KhachSan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(QuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(244, 385));

        ButtonQLPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonQLPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/room.png"))); // NOI18N
        ButtonQLPhong.setText("Quản lí Phòng");
        ButtonQLPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonQLPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQLPhongActionPerformed(evt);
            }
        });

        ButtonQLDV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonQLDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/QLDV.png"))); // NOI18N
        ButtonQLDV.setText("Quản lí Dịch Vụ");
        ButtonQLDV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonQLDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQLDVActionPerformed(evt);
            }
        });

        ButtonQLNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/QLNV.png"))); // NOI18N
        ButtonQLNV.setText("Quản lí Nhân Viên");
        ButtonQLNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ButtonQLNhaCUngCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonQLNhaCUngCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/QLNHACUNGCAP.png"))); // NOI18N
        ButtonQLNhaCUngCap.setText("Quản lí Nhà Cung Cấp");
        ButtonQLNhaCUngCap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ButtonThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/THONGKE.png"))); // NOI18N
        ButtonThongKe.setText("Thống Kê");
        ButtonThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ButtonQLNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonQLNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/QLNHAPHANG.png"))); // NOI18N
        ButtonQLNhapHang.setText("Quản lí Nhập Hàng");
        ButtonQLNhapHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ButtonKhoHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonKhoHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/KHOHANG.png"))); // NOI18N
        ButtonKhoHang.setText("Kho Hàng");
        ButtonKhoHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ButtonTaoTaiKhoan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTaoTaiKhoan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/accountant.png"))); // NOI18N
        ButtonTaoTaiKhoan1.setText("Tạo Tài Khoản");
        ButtonTaoTaiKhoan1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonQLPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQLDV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQLNhaCUngCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQLNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonQLNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonTaoTaiKhoan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ButtonQLPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonQLDV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonQLNhaCUngCap, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonQLNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonKhoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonTaoTaiKhoan1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1419, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        loadData();
        loadDataLoaiPhongToTable();
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new PhieuThuePhong().setVisible(true); 
    }//GEN-LAST:event_KhachSanActionPerformed

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void txtVaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaiTroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVaiTroActionPerformed

    private void TXTenLP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLP1ActionPerformed

    private void ButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimActionPerformed
        try {
            String maPhongStr = TXMaPhongTim.getText().trim();
            String soGiuongStr = TXSoGiuongTim.getText().trim();
            String maLoaiPhong = CBMaLoaiPhongTim.getSelectedItem().toString();

            Integer maPhong = maPhongStr.isEmpty() ? null : Integer.parseInt(maPhongStr);
            Integer soGiuong = soGiuongStr.isEmpty() ? null : Integer.parseInt(soGiuongStr);
            String maLoaiPhongFilter = maLoaiPhong.equals("_") ? null : maLoaiPhong;

            model.setRowCount(0); // Xóa bảng

            for (QuanLiPhongDTO phong : danhSachPhongGoc) {
                boolean match = true;

                if (maPhong != null && phong.getMaPhong() != maPhong) match = false;
                if (soGiuong != null && phong.getSoGiuong() != soGiuong) match = false;
                if (maLoaiPhongFilter != null && !phong.getMaLoaiPhong().equals(maLoaiPhongFilter)) match = false;

                if (match) {
                    model.addRow(new Object[] {
                        phong.getMaPhong(), phong.getMaLoaiPhong(), phong.getSoGiuong(),
                        phong.getDonGia(), phong.getTrangThai()
                    });
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonTimActionPerformed

    private void ButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonThemActionPerformed
                try {
                 if (CBMaLoaiPhong.getSelectedItem().toString().equals("_")) {
                     JOptionPane.showMessageDialog(this, "Vui lòng chọn mã loại phòng");
                     return;
                 }
                 if (txtTenDangNhap.getText().isEmpty() || TXSoGiuong.getText().isEmpty() || TXTrangThai.getText().isEmpty() || txtVaiTro.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                     return;
                 }
                 
                 if(!TXTrangThai.getText().equals("Trống")) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập trạng thái là trống khi thêm Phòng.");
                     return;
                 }

                 QuanLiPhongDTO phong = new QuanLiPhongDTO(
                     Integer.parseInt(txtTenDangNhap.getText()),
                     CBMaLoaiPhong.getSelectedItem().toString(),
                     Integer.parseInt(TXSoGiuong.getText()),
                     Double.parseDouble(txtVaiTro.getText()),
                     TXTrangThai.getText()
                 );

                 phongBLL.themPhong(phong);

                 // Sau khi thêm thành công, làm mới bảng
                 loadData();

                 JOptionPane.showMessageDialog(this, "Thêm phòng thành công!");
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
             }        
    }//GEN-LAST:event_ButtonThemActionPerformed

    private void ButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSuaActionPerformed
        try {
            int selectedRow = tblDSPHONG.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần sửa.");
                return;
            }

            // Lấy dữ liệu từ các TextFields và ComboBox
            int maPhong = Integer.parseInt(txtTenDangNhap.getText());
            String maLoaiPhong = CBMaLoaiPhong.getSelectedItem().toString();
            int soGiuong = Integer.parseInt(TXSoGiuong.getText());
            double donGia = Double.parseDouble(txtVaiTro.getText());
            String trangThai = TXTrangThai.getText();  
           


            if (CBMaLoaiPhong.getSelectedItem().toString().equals("_")) {
                     JOptionPane.showMessageDialog(this, "Vui lòng chọn mã loại phòng");
                     return;
            }
            if (TXSoGiuong.getText().isEmpty() || TXTrangThai.getText().isEmpty() || txtVaiTro.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                     return;
            }
                 
            if(!TXTrangThai.getText().equals("Trống")) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập trạng thái là trống khi sửa Phòng.");
                     return;
            }

            QuanLiPhongDTO phong = new QuanLiPhongDTO(maPhong, maLoaiPhong, soGiuong, donGia, trangThai);
            QuanLiPhongBLL qlPhongBLL = new QuanLiPhongBLL();
            qlPhongBLL.suaPhong(phong);  

            // Cập nhật bảng
            model.setValueAt(maPhong, selectedRow, 0);
            model.setValueAt(maLoaiPhong, selectedRow, 1);
            model.setValueAt(soGiuong, selectedRow, 2);
            model.setValueAt(donGia, selectedRow, 3);
            model.setValueAt(trangThai, selectedRow, 4);
            

            JOptionPane.showMessageDialog(this, "Cập nhật phòng thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonSuaActionPerformed

    private void ButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXoaActionPerformed
        try {
            int selectedRow = tblDSPHONG.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần xóa.");
                return;
            }

            int maPhong = (int) model.getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phòng có mã phòng: " + maPhong + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Thực hiện xóa phòng
                QuanLiPhongBLL qlPhongBLL = new QuanLiPhongBLL();
                qlPhongBLL.xoaPhong(maPhong);  
                JOptionPane.showMessageDialog(this, "Xóa phòng thành công!");
                loadData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonXoaActionPerformed

    private void TXTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTrangThaiActionPerformed

    private void ButtonQLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLPhongActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new TaiKhoan().setVisible(true);
    }//GEN-LAST:event_ButtonQLPhongActionPerformed

    private void QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new TaiKhoan().setVisible(true);
    }//GEN-LAST:event_QuanLiActionPerformed

    private void ButtonQLDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLDVActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new QuanLiDichVu().setVisible(true);
    }//GEN-LAST:event_ButtonQLDVActionPerformed

    private void jButtonResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResertActionPerformed
        // Xóa nội dung trong các ô tìm kiếm
        TXMaPhongTim.setText("");
        TXSoGiuongTim.setText("");
        
        CBMaLoaiPhongTim.setSelectedItem("_");

        // Xóa toàn bộ dữ liệu bảng
        model.setRowCount(0);        

        // Đổ lại toàn bộ dữ liệu từ danh sách gốc
        for (QuanLiPhongDTO phong : danhSachPhongGoc) {
            model.addRow(new Object[] {
                phong.getMaPhong(), phong.getMaLoaiPhong(), phong.getSoGiuong(),
                phong.getDonGia(), phong.getTrangThai()
            });
        }
    }//GEN-LAST:event_jButtonResertActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            TaiKhoan quanLiPhong = new TaiKhoan(); // Tạo đối tượng QuanLiPhong
            quanLiPhong.setVisible(true); // Hiển thị giao diện
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonKhoHang;
    private javax.swing.JButton ButtonQLDV;
    private javax.swing.JButton ButtonQLNV;
    private javax.swing.JButton ButtonQLNhaCUngCap;
    private javax.swing.JButton ButtonQLNhapHang;
    private javax.swing.JButton ButtonQLPhong;
    private javax.swing.JButton ButtonSua;
    private javax.swing.JButton ButtonTaoTaiKhoan1;
    private javax.swing.JButton ButtonThem;
    private javax.swing.JButton ButtonThongKe;
    private javax.swing.JButton ButtonTim;
    private javax.swing.JButton ButtonXoa;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTextField TXTrangThai;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.JLabel Tittle;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMaNhanVien;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonResert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbGiaThue;
    private javax.swing.JLabel lbMaLoaiPhong;
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lbSoGiuong;
    private javax.swing.JLabel lbTrangThai;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private javax.swing.JButton self;
    private javax.swing.JTable tblDSPHONG;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtVaiTro;
    // End of variables declaration//GEN-END:variables
    private final DefaultTableModel model;
    private final DefaultTableModel modelLoaiPhong;
    private final QuanLiPhongBLL phongBLL;


}

