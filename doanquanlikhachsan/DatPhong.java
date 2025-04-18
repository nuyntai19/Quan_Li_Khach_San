package doanquanlikhachsan;


import java.util.logging.Logger;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class DatPhong extends javax.swing.JFrame {

    
    public DatPhong() {
        initComponents();
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
        home = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        DatPhong = new javax.swing.JButton();
        CheckIn = new javax.swing.JButton();
        CheckOut = new javax.swing.JButton();
        HoaDonDatPhong = new javax.swing.JButton();
        DSDatPhong = new javax.swing.JButton();
        DSKhachHang = new javax.swing.JButton();
        DSDatDichVu = new javax.swing.JButton();
        DatDichVu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbKH = new javax.swing.JLabel();
        TXDP = new javax.swing.JTextField();
        lbMaDP = new javax.swing.JLabel();
        TXKhachHang = new javax.swing.JTextField();
        BTKH = new javax.swing.JButton();
        lbMaPhong = new javax.swing.JLabel();
        TXMaPhong = new javax.swing.JTextField();
        lbMaLoaiPhong = new javax.swing.JLabel();
        TXMaLoaiPhong = new javax.swing.JTextField();
        lbSoGiuong = new javax.swing.JLabel();
        TXSoGiuong = new javax.swing.JTextField();
        lbGiaThue = new javax.swing.JLabel();
        TXGiaThue = new javax.swing.JTextField();
        lbTenLP = new javax.swing.JLabel();
        TXTenLP = new javax.swing.JTextField();
        lbMoTa = new javax.swing.JLabel();
        lbHo = new javax.swing.JLabel();
        TXKhachHang1 = new javax.swing.JTextField();
        lbHo1 = new javax.swing.JLabel();
        TXKhachHang2 = new javax.swing.JTextField();
        lbKH1 = new javax.swing.JLabel();
        TXKhachHang3 = new javax.swing.JTextField();
        DCNgaySinh = new com.toedter.calendar.JDateChooser();
        lbNgaySinh = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        TXEmail = new javax.swing.JTextField();
        lbGioiTinh = new javax.swing.JLabel();
        RBNam = new javax.swing.JRadioButton();
        RBNu = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        LBPhongTrong = new javax.swing.JLabel();
        LBPhongTrong1 = new javax.swing.JLabel();
        LBNgayTim = new javax.swing.JLabel();
        DCDau = new com.toedter.calendar.JDateChooser();
        DCCuoi = new com.toedter.calendar.JDateChooser();
        LBMaLoaiPhongTrong = new javax.swing.JLabel();
        CBMaLoaiPhongTrong = new javax.swing.JComboBox<>();
        lbSoGiuongPhongTrong = new javax.swing.JLabel();
        TXSoGiuongPhongTrong = new javax.swing.JTextField();
        ButtonTim = new javax.swing.JButton();
        ButtonChonPhong = new javax.swing.JButton();
        ButtonDatPhong = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDP = new javax.swing.JTable();
        TXMoTa = new javax.swing.JTextField();
        lbNgayDP = new javax.swing.JLabel();
        lbNgayTP = new javax.swing.JLabel();
        DCNgayDP = new com.toedter.calendar.JDateChooser();
        DCNgayTP = new com.toedter.calendar.JDateChooser();
        BTThem = new javax.swing.JButton();
        BTTongCong = new javax.swing.JButton();
        jButtonResert = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        KhachSan = new javax.swing.JButton();
        QuanLi = new javax.swing.JButton();

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

        home.setBackground(new java.awt.Color(52, 152, 219));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/home (1).png"))); // NOI18N
        home.setBorder(null);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(self, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tittle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));

        DatPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/review.png"))); // NOI18N
        DatPhong.setText("Đặt Phòng");
        DatPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatPhongActionPerformed(evt);
            }
        });

        CheckIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/check-in.png"))); // NOI18N
        CheckIn.setText("Check In");
        CheckIn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        CheckOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/check-out.png"))); // NOI18N
        CheckOut.setText("Check Out");
        CheckOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        HoaDonDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HoaDonDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/bill.png"))); // NOI18N
        HoaDonDatPhong.setText("Hóa Đơn ");
        HoaDonDatPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        DSDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/list.png"))); // NOI18N
        DSDatPhong.setText("Danh Sách Đặt Phòng");
        DSDatPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        DSKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/registration-form.png"))); // NOI18N
        DSKhachHang.setText("Danh Sách Khách Hàng");
        DSKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        DSDatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSDatDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reception.png"))); // NOI18N
        DSDatDichVu.setText("Danh Sách Đặt Dịch Vụ");
        DSDatDichVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        DatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/desk-bell.png"))); // NOI18N
        DatDichVu.setText("Đặt Dịch Vụ");
        DatDichVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDichVuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonDatPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(DSDatDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐẶT PHÒNG");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        lbKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbKH.setText("Mã khách hàng:");

        TXDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXDPActionPerformed(evt);
            }
        });

        lbMaDP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaDP.setText("Mã đặt phòng:");

        TXKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHangActionPerformed(evt);
            }
        });

        BTKH.setBackground(new java.awt.Color(52, 152, 219));
        BTKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTKH.setForeground(new java.awt.Color(255, 255, 255));
        BTKH.setText("Chọn khách hàng");
        BTKH.setIconTextGap(5);
        BTKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTKHActionPerformed(evt);
            }
        });

        lbMaPhong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaPhong.setText("Mã phòng:");

        TXMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMaPhongActionPerformed(evt);
            }
        });

        lbMaLoaiPhong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaLoaiPhong.setText("Mã loại phòng:");

        TXMaLoaiPhong.setEditable(false);
        TXMaLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMaLoaiPhongActionPerformed(evt);
            }
        });

        lbSoGiuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuong.setText("Số giường:");

        TXSoGiuong.setEditable(false);
        TXSoGiuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSoGiuongActionPerformed(evt);
            }
        });

        lbGiaThue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbGiaThue.setText("Giá phòng thuê:");

        TXGiaThue.setEditable(false);
        TXGiaThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXGiaThueActionPerformed(evt);
            }
        });

        lbTenLP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTenLP.setText("Tên loại phòng:");

        TXTenLP.setEditable(false);
        TXTenLP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenLPActionPerformed(evt);
            }
        });

        lbMoTa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMoTa.setText("Mô tả phòng:");

        lbHo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo.setText("Họ:");

        TXKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang1ActionPerformed(evt);
            }
        });

        lbHo1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo1.setText("Tên:");

        TXKhachHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang2ActionPerformed(evt);
            }
        });

        lbKH1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbKH1.setText("Số điện thoại:");

        TXKhachHang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang3ActionPerformed(evt);
            }
        });

        lbNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgaySinh.setText("Ngày sinh:");

        lbEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbEmail.setText("Email:");

        TXEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXEmailActionPerformed(evt);
            }
        });

        lbGioiTinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbGioiTinh.setText("Giới tính:");

        bGNam_Nu.add(RBNam);
        RBNam.setText("Nam");
        RBNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBNamActionPerformed(evt);
            }
        });

        bGNam_Nu.add(RBNu);
        RBNu.setText("Nữ");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(52, 152, 219));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField2.setEnabled(false);

        LBPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBPhongTrong.setText("Danh sách phòng trống:");

        LBPhongTrong1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        LBPhongTrong1.setText("TÌM PHÒNG TRỐNG:");

        LBNgayTim.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBNgayTim.setText("Ngày:");

        LBMaLoaiPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBMaLoaiPhongTrong.setText("Mã loại phòng:");

        CBMaLoaiPhongTrong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng đơn", "Phòng đôi", "Phòng VIP", " " }));
        CBMaLoaiPhongTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMaLoaiPhongTrongActionPerformed(evt);
            }
        });

        lbSoGiuongPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuongPhongTrong.setText("Số giường:");

        TXSoGiuongPhongTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSoGiuongPhongTrongActionPerformed(evt);
            }
        });

        ButtonTim.setBackground(new java.awt.Color(52, 152, 219));
        ButtonTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTim.setForeground(new java.awt.Color(255, 255, 255));
        ButtonTim.setText("Tìm");
        ButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTimActionPerformed(evt);
            }
        });

        ButtonChonPhong.setBackground(new java.awt.Color(52, 152, 219));
        ButtonChonPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonChonPhong.setForeground(new java.awt.Color(255, 255, 255));
        ButtonChonPhong.setText("Chọn Phòng");
        ButtonChonPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChonPhongActionPerformed(evt);
            }
        });

        ButtonDatPhong.setBackground(new java.awt.Color(52, 152, 219));
        ButtonDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ButtonDatPhong.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDatPhong.setText("Đặt phòng");

        tableDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Mã loại phòng", "Số giường", "Đơn giá", "Tên loại phòng", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDP);

        TXMoTa.setEditable(false);
        TXMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMoTaActionPerformed(evt);
            }
        });

        lbNgayDP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgayDP.setText("Ngày đặt phòng:");

        lbNgayTP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgayTP.setText("Ngày trả phòng:");

        BTThem.setBackground(new java.awt.Color(52, 152, 219));
        BTThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTThem.setForeground(new java.awt.Color(255, 255, 255));
        BTThem.setText("Thêm");
        BTThem.setIconTextGap(5);
        BTThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTThemActionPerformed(evt);
            }
        });

        BTTongCong.setBackground(new java.awt.Color(52, 152, 219));
        BTTongCong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTTongCong.setForeground(new java.awt.Color(255, 255, 255));
        BTTongCong.setText("Chi Tiết");
        BTTongCong.setIconTextGap(5);
        BTTongCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTTongCongActionPerformed(evt);
            }
        });

        jButtonResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        jButtonResert.setBorderPainted(false);
        jButtonResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTenLP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXDP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTenLP, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTKH)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbHo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXKhachHang2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)))
                        .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXKhachHang3)
                            .addComponent(DCNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(TXEmail)
                            .addComponent(TXMoTa))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbNgayTP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DCNgayTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbNgayDP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DCNgayDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(BTThem)
                                .addGap(18, 18, 18)
                                .addComponent(BTTongCong)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBNam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RBNu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LBPhongTrong1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(LBNgayTim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DCDau, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(DCCuoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(LBMaLoaiPhongTrong))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBMaLoaiPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonChonPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(jButtonResert))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LBPhongTrong)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(505, 505, 505))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BTKH)
                                            .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXKhachHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbHo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXKhachHang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TXMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TXKhachHang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(TXSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(lbNgayDP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DCNgayDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(RBNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RBNu))))
                            .addComponent(DCNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayTP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DCNgayTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenLP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTenLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTThem)
                    .addComponent(BTTongCong))
                .addGap(16, 16, 16)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(LBPhongTrong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LBMaLoaiPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CBMaLoaiPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonTim))
                            .addComponent(DCDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DCCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TXSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonChonPhong))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBNgayTim, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonResert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(KhachSan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(QuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
        dispose();
        new DatPhong().setVisible(true);   
    }//GEN-LAST:event_DatPhongActionPerformed

    private void selfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        new DatPhong().setVisible(true);        
    }//GEN-LAST:event_KhachSanActionPerformed

    private void TXDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXDPActionPerformed

    private void TXKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHangActionPerformed

    private void BTKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTKHActionPerformed
        dispose();
        new ChonKhachHang().setVisible(true);
    }//GEN-LAST:event_BTKHActionPerformed

    private void TXMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMaPhongActionPerformed

    private void TXMaLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMaLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMaLoaiPhongActionPerformed

    private void TXSoGiuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoGiuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoGiuongActionPerformed

    private void TXGiaThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXGiaThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXGiaThueActionPerformed

    private void TXTenLPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLPActionPerformed

    private void TXTenLP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLP1ActionPerformed

    private void TXKhachHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHang1ActionPerformed

    private void TXKhachHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHang2ActionPerformed

    private void TXKhachHang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHang3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHang3ActionPerformed

    private void TXEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXEmailActionPerformed

    private void RBNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBNamActionPerformed

    private void CBMaLoaiPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMaLoaiPhongTrongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBMaLoaiPhongTrongActionPerformed

    private void TXSoGiuongPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoGiuongPhongTrongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoGiuongPhongTrongActionPerformed

    private void ButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonTimActionPerformed

    private void ButtonChonPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChonPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonChonPhongActionPerformed

    private void TXMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMoTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMoTaActionPerformed

    private void BTThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTThemActionPerformed

    private void BTTongCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTTongCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTTongCongActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        dispose();
        new DatPhong().setVisible(true);
    }//GEN-LAST:event_homeActionPerformed

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
        dispose();
        new DatPhong().setVisible(true); 
    }//GEN-LAST:event_jButtonResertActionPerformed

    private void DatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVuActionPerformed
        dispose();
        new DatDichVu().setVisible(true);
    }//GEN-LAST:event_DatDichVuActionPerformed

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
            java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTKH;
    private javax.swing.JButton BTThem;
    private javax.swing.JButton BTTongCong;
    private javax.swing.JButton ButtonChonPhong;
    private javax.swing.JButton ButtonDatPhong;
    private javax.swing.JButton ButtonTim;
    private javax.swing.JComboBox<String> CBMaLoaiPhongTrong;
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton CheckOut;
    private com.toedter.calendar.JDateChooser DCCuoi;
    private com.toedter.calendar.JDateChooser DCDau;
    private com.toedter.calendar.JDateChooser DCNgayDP;
    private com.toedter.calendar.JDateChooser DCNgaySinh;
    private com.toedter.calendar.JDateChooser DCNgayTP;
    private javax.swing.JButton DSDatDichVu;
    private javax.swing.JButton DSDatPhong;
    private javax.swing.JButton DSKhachHang;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton DatDichVu;
    private javax.swing.JButton DatPhong;
    private javax.swing.JButton HoaDonDatPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JLabel LBMaLoaiPhongTrong;
    private javax.swing.JLabel LBNgayTim;
    private javax.swing.JLabel LBPhongTrong;
    private javax.swing.JLabel LBPhongTrong1;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JRadioButton RBNam;
    private javax.swing.JRadioButton RBNu;
    private javax.swing.JTextField TXDP;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXEmail;
    private javax.swing.JTextField TXGiaThue;
    private javax.swing.JTextField TXKhachHang;
    private javax.swing.JTextField TXKhachHang1;
    private javax.swing.JTextField TXKhachHang2;
    private javax.swing.JTextField TXKhachHang3;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXMaLoaiPhong;
    private javax.swing.JTextField TXMaPhong;
    private javax.swing.JTextField TXMoTa;
    private javax.swing.JTextField TXSoGiuong;
    private javax.swing.JTextField TXSoGiuongPhongTrong;
    private javax.swing.JTextField TXTenLP;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.JLabel Tittle;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton home;
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
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGiaThue;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbHo1;
    private javax.swing.JLabel lbKH;
    private javax.swing.JLabel lbKH1;
    private javax.swing.JLabel lbMaDP;
    private javax.swing.JLabel lbMaLoaiPhong;
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lbMoTa;
    private javax.swing.JLabel lbNgayDP;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbNgayTP;
    private javax.swing.JLabel lbSoGiuong;
    private javax.swing.JLabel lbSoGiuongPhongTrong;
    private javax.swing.JLabel lbTenLP;
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
    private javax.swing.JTable tableDP;
    // End of variables declaration//GEN-END:variables
}
