package UI;

import BLL.DichVuBLL;
import DTO.DichVuDTO;
import BLL.DatDichVuBLL;
import BLL.ThongTinNhanVienBLL;
import DTO.DatDichVuDTO;
import DTO.DichVuDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhSachDatDichVu extends javax.swing.JFrame {

    private DefaultTableModel model;
    private DatDichVuBLL datDichVuBLL;

    public DanhSachDatDichVu() {
        initComponents();
        datDichVuBLL = new DatDichVuBLL();
        model = (DefaultTableModel) tblDSDATDICHVU.getModel();
        tblDSDATDICHVU.setRowHeight(24);
        loadData();

        ButtonTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ButtonTimActionPerformed(evt);
            }
        });

        jButtonResert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });
    }

    private void loadData() {
        try {
            ArrayList<DatDichVuDTO> danhSach = datDichVuBLL.layDanhSachDatDichVu();
            model.setRowCount(0);
            for (DatDichVuDTO dv : danhSach) {
                model.addRow(new Object[]{
                        dv.getIdChiTietPhieuThue(),
                        dv.getMaDichVu(),
                        dv.getSoLuong(),
                        dv.getDonGia(),
                        dv.getThanhTien()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
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
        LBDSDV = new javax.swing.JLabel();
        LBDichVu = new javax.swing.JLabel();
        ButtonTim = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSDATDICHVU = new javax.swing.JTable();
        TXDichVu = new javax.swing.JTextField();
        jButtonResert = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        KhachSan = new javax.swing.JButton();
        QuanLi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        DatPhong2 = new javax.swing.JButton();
        CheckIn2 = new javax.swing.JButton();
        CheckOut2 = new javax.swing.JButton();
        HoaDonDatPhong2 = new javax.swing.JButton();
        DSKhachHang2 = new javax.swing.JButton();
        DatDichVu3 = new javax.swing.JButton();
        DSDatPhong2 = new javax.swing.JButton();
        DatDichVu4 = new javax.swing.JButton();
        DatDichVu5 = new javax.swing.JButton();

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
        jLabel1.setText("DANH SÁCH DỊCH VỤ");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        LBDSDV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBDSDV.setText("Danh sách dịch vụ:");

        LBDichVu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        LBDichVu.setText("Tìm danh sách đặt dịch vụ:");

        ButtonTim.setBackground(new java.awt.Color(52, 152, 219));
        ButtonTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTim.setForeground(new java.awt.Color(255, 255, 255));
        ButtonTim.setText("Tìm");
        ButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTimActionPerformed(evt);
            }
        });

        tblDSDATDICHVU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IDChiTietPhieuThue", "Mã dịch vụ", "Số lượng", "Đơn giá ", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDSDATDICHVU);

        TXDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXDichVuActionPerformed(evt);
            }
        });

        jButtonResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        jButtonResert.setBorderPainted(false);
        jButtonResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_", "Mã IDChiTietPhieuThue", "Mã dịch vụ" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBDSDV)
                                    .addComponent(LBDichVu))
                                .addGap(550, 550, 550)
                                .addComponent(jButtonResert)
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(TXDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 166, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonResert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonTim)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(LBDSDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
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

        DatPhong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/review.png"))); // NOI18N
        DatPhong2.setText("Đặt Phòng");
        DatPhong2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatPhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatPhong2ActionPerformed(evt);
            }
        });

        CheckIn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckIn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/check-in.png"))); // NOI18N
        CheckIn2.setText("Check In");
        CheckIn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CheckIn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckIn2ActionPerformed(evt);
            }
        });

        CheckOut2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckOut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/check-out.png"))); // NOI18N
        CheckOut2.setText("Check Out");
        CheckOut2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CheckOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOut2ActionPerformed(evt);
            }
        });

        HoaDonDatPhong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HoaDonDatPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/bill.png"))); // NOI18N
        HoaDonDatPhong2.setText("Hóa Đơn ");
        HoaDonDatPhong2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HoaDonDatPhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonDatPhong2ActionPerformed(evt);
            }
        });

        DSKhachHang2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSKhachHang2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/registration-form.png"))); // NOI18N
        DSKhachHang2.setText("Danh Sách Khách Hàng");
        DSKhachHang2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DSKhachHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSKhachHang2ActionPerformed(evt);
            }
        });

        DatDichVu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/desk-bell.png"))); // NOI18N
        DatDichVu3.setText("Đặt Dịch Vụ");
        DatDichVu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatDichVu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDichVu3ActionPerformed(evt);
            }
        });

        DSDatPhong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSDatPhong2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/list.png"))); // NOI18N
        DSDatPhong2.setText("Danh Sách Đặt Phòng");
        DSDatPhong2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DSDatPhong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSDatPhong2ActionPerformed(evt);
            }
        });

        DatDichVu4.setBackground(new java.awt.Color(238, 255, 255));
        DatDichVu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reception.png"))); // NOI18N
        DatDichVu4.setText("Danh Sách Đặt Dịch Vụ");
        DatDichVu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatDichVu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDichVu4ActionPerformed(evt);
            }
        });

        DatDichVu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/checkTinhTrang.png"))); // NOI18N
        DatDichVu5.setText("Kiểm tra tình trạng");
        DatDichVu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DatDichVu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatPhong2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckIn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonDatPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckOut2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSKhachHang2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(DatDichVu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSDatPhong2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DatPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckIn2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSDatPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDonDatPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSKhachHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        loadData();
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        loadData();
        new PhieuThuePhong().setVisible(true); 
    }//GEN-LAST:event_KhachSanActionPerformed

    private void TXTenLP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLP1ActionPerformed

    private void ButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimActionPerformed
        try {
        String selectedColumn = (String) jComboBox2.getSelectedItem(); // Giá trị từ combo box
        String searchValue = TXDichVu.getText().trim(); // Giá trị tìm kiếm nhập vào

        if (searchValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị cần tìm.");
            return;
        }

        List<DatDichVuDTO> danhSach = new ArrayList<>();
        DatDichVuBLL datDichVuBLL = new DatDichVuBLL(); // Sử dụng đúng BLL

        // Kiểm tra giá trị từ combo box để thực hiện tìm kiếm theo từng trường
        switch (selectedColumn) {
            case "Mã IDChiTietPhieuThue":
                try {
                    int idChiTiet = Integer.parseInt(searchValue);
                    danhSach = datDichVuBLL.getByIDChiTietPhieuThue(idChiTiet);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID chi tiết phiếu thuê phải là số nguyên.");
                    return;
                }
                break;
            case "Mã dịch vụ":
                try {
                    int maDV = Integer.parseInt(searchValue);
                    // Lọc toàn bộ danh sách theo mã dịch vụ
                    for (DatDichVuDTO dv : datDichVuBLL.layDanhSachDatDichVu()) {
                        if (dv.getMaDichVu() == maDV) {
                            danhSach.add(dv);
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Mã dịch vụ phải là số nguyên.");
                    return;
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Vui lòng chọn trường hợp tìm kiếm hợp lệ.");
                return;
        }

        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
        if (danhSach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy đặt dịch vụ.");
            return;
        }

        for (DatDichVuDTO dv : danhSach) {
            model.addRow(new Object[]{
                dv.getIdChiTietPhieuThue(),
                dv.getMaDichVu(),
                dv.getSoLuong(),
                dv.getDonGia(),
                dv.getThanhTien()
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + e.getMessage());
    }
    }//GEN-LAST:event_ButtonTimActionPerformed

    private void TXDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXDichVuActionPerformed

    private void QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        ThongTinNhanVienBLL bll = new ThongTinNhanVienBLL();
        if (bll.laAdminDangNhap()) {
            // Mở giao diện quản lý
            new QuanLiPhong().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_QuanLiActionPerformed

    private void jButtonResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResertActionPerformed
        
    TXDichVu.setText("");
    loadData(); // Tải lại toàn bộ dữ liệu
    }//GEN-LAST:event_jButtonResertActionPerformed

    private void DatPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatPhong2ActionPerformed
        dispose();
        new PhieuThuePhong().setVisible(true);
    }//GEN-LAST:event_DatPhong2ActionPerformed

    private void HoaDonDatPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDatPhong2ActionPerformed
        dispose();
        
        try {
            new DanhSachHoaDon().setVisible(true);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DanhSachDatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_HoaDonDatPhong2ActionPerformed

    private void DSKhachHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSKhachHang2ActionPerformed
        dispose();
        new DanhSachKhachHang().setVisible(true);
    }//GEN-LAST:event_DSKhachHang2ActionPerformed

    private void DatDichVu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVu3ActionPerformed
        dispose();
        new DatDichVu().setVisible(true);
    }//GEN-LAST:event_DatDichVu3ActionPerformed

    private void DatDichVu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVu4ActionPerformed

    }//GEN-LAST:event_DatDichVu4ActionPerformed

    private void CheckIn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckIn2ActionPerformed
        dispose();
        new DSCheckInGUI().setVisible(true);
    }//GEN-LAST:event_CheckIn2ActionPerformed

    private void CheckOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOut2ActionPerformed
        dispose();
        new DSCheckOutGUI().setVisible(true);
    }//GEN-LAST:event_CheckOut2ActionPerformed

    private void DSDatPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSDatPhong2ActionPerformed
        dispose();
        new DanhSachDatPhongGUI().setVisible(true);
    }//GEN-LAST:event_DSDatPhong2ActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachDatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachDatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachDatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachDatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            DanhSachDatDichVu danhsachDichVu = new DanhSachDatDichVu(); // Tạo đối tượng QuanLiPhong
            danhsachDichVu.setVisible(true); // Hiển thị giao diện
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonTim;
    private javax.swing.JButton CheckIn2;
    private javax.swing.JButton CheckOut2;
    private javax.swing.JButton DSDatPhong2;
    private javax.swing.JButton DSKhachHang2;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton DatDichVu3;
    private javax.swing.JButton DatDichVu4;
    private javax.swing.JButton DatDichVu5;
    private javax.swing.JButton DatPhong2;
    private javax.swing.JButton HoaDonDatPhong2;
    private javax.swing.JButton KhachSan;
    private javax.swing.JLabel LBDSDV;
    private javax.swing.JLabel LBDichVu;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXDichVu;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.JLabel Tittle;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonResert;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel lbDangNhap;
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
    private javax.swing.JTable tblDSDATDICHVU;
    // End of variables declaration//GEN-END:variables

}

