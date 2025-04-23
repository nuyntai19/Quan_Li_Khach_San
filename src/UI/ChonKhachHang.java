package UI;

import DTO.KhachHangDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import BLL.KhachHangBLL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChonKhachHang extends javax.swing.JFrame {
    
    private PhieuThuePhong formPhieuThue;
    private final DefaultTableModel model;
    private final KhachHangBLL khachHangBLL;
    private ArrayList<KhachHangDTO> danhSachKhachHangGoc = new ArrayList<>();

    
    public ChonKhachHang(PhieuThuePhong formPhieuThue) {
        initComponents();
        model = (DefaultTableModel) tblDSKHACHHANG.getModel(); 
        khachHangBLL = new KhachHangBLL();
        this.formPhieuThue = formPhieuThue;
        loadData();
    }
    
    private void loadData() {
        try {
            model.setRowCount(0); // Xóa dữ liệu cũ

            // Đảm bảo rằng bảng đã có các cột cần thiết
            model.setColumnIdentifiers(new String[] {
                "Mã Khách Hàng", "Họ", "Tên", "Ngày Sinh", "Giới Tính","Email","Số Điện Thoại"
            });

            // Lấy lại dữ liệu từ cơ sở dữ liệu
            danhSachKhachHangGoc = khachHangBLL.layDanhSachKhachHang();
            for (KhachHangDTO kh : danhSachKhachHangGoc) {
                model.addRow(new Object[] {
                    kh.getMaKhachHang(),kh.getHo(),kh.getTen(),kh.getNgaySinh(),kh.getGioiTinh(),kh.getEmail(),kh.getSoDienThoai()
                });
            }
        } catch (SQLException e) {
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lbHo1 = new javax.swing.JLabel();
        lbGioiTinh = new javax.swing.JLabel();
        RBNu = new javax.swing.JRadioButton();
        RBNam = new javax.swing.JRadioButton();
        TXKhachHang1 = new javax.swing.JTextField();
        lbHo = new javax.swing.JLabel();
        TXKhachHang2 = new javax.swing.JTextField();
        TXKhachHang3 = new javax.swing.JTextField();
        lbKH1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        lbNgaySinh = new javax.swing.JLabel();
        DCNgaySinh = new com.toedter.calendar.JDateChooser();
        TXEmail = new javax.swing.JTextField();
        TXTenLP1 = new javax.swing.JTextField();
        lbTenLP1 = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbSoGiuong1 = new javax.swing.JLabel();
        TXSoGiuong1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbMaKH = new javax.swing.JLabel();
        lbHoKH = new javax.swing.JLabel();
        TXHoKH = new javax.swing.JTextField();
        lbTenKH = new javax.swing.JLabel();
        TXTenKH = new javax.swing.JTextField();
        lbTimDV = new javax.swing.JLabel();
        TXKH = new javax.swing.JTextField();
        ButtonTim = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDSKHACHHANG = new javax.swing.JTable();
        ButtonChon = new javax.swing.JButton();
        lbSDT = new javax.swing.JLabel();
        lbEmailKH = new javax.swing.JLabel();
        TXSDT = new javax.swing.JTextField();
        TXEmailKH = new javax.swing.JTextField();
        jButtonResert = new javax.swing.JButton();
        ButtonThoat = new javax.swing.JButton();

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        lbHo1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo1.setText("Tên:");

        lbGioiTinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbGioiTinh.setText("Giới tính:");

        bGNam_Nu.add(RBNu);
        RBNu.setText("Nữ");

        bGNam_Nu.add(RBNam);
        RBNam.setText("Nam");
        RBNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBNamActionPerformed(evt);
            }
        });

        TXKhachHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang1ActionPerformed(evt);
            }
        });

        lbHo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo.setText("Họ:");

        TXKhachHang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang2ActionPerformed(evt);
            }
        });

        TXKhachHang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKhachHang3ActionPerformed(evt);
            }
        });

        lbKH1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbKH1.setText("Số điện thoại:");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(52, 152, 219));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField2.setEnabled(false);

        lbNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgaySinh.setText("Ngày sinh:");

        TXEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXEmailActionPerformed(evt);
            }
        });

        TXTenLP1.setEditable(false);
        TXTenLP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenLP1ActionPerformed(evt);
            }
        });

        lbTenLP1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTenLP1.setText("Mô tả phòng:");

        lbEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbEmail.setText("Email:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        lbSoGiuong1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuong1.setText("Giá phòng thuê:");

        TXSoGiuong1.setEditable(false);
        TXSoGiuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSoGiuong1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DatPhong");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHỌN KHÁCH HÀNG");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        lbMaKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaKH.setText("Mã khách hàng: ");

        lbHoKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHoKH.setText("Họ:");

        TXHoKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXHoKHActionPerformed(evt);
            }
        });

        lbTenKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTenKH.setText("Tên:");

        TXTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenKHActionPerformed(evt);
            }
        });

        lbTimDV.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbTimDV.setText("TÌM KHÁCH HÀNG :");

        TXKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXKHActionPerformed(evt);
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

        tblDSKHACHHANG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ", "Tên", "Ngày sinh", "Giới tính", "Email", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDSKHACHHANG);

        ButtonChon.setBackground(new java.awt.Color(52, 152, 219));
        ButtonChon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonChon.setForeground(new java.awt.Color(255, 255, 255));
        ButtonChon.setText("Chọn");
        ButtonChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChonActionPerformed(evt);
            }
        });

        lbSDT.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSDT.setText("Số điện thoại: ");

        lbEmailKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbEmailKH.setText("Email: ");

        TXSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSDTActionPerformed(evt);
            }
        });

        TXEmailKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXEmailKHActionPerformed(evt);
            }
        });

        jButtonResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        jButtonResert.setBorderPainted(false);
        jButtonResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });

        ButtonThoat.setBackground(new java.awt.Color(52, 152, 219));
        ButtonThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonThoat.setForeground(new java.awt.Color(255, 255, 255));
        ButtonThoat.setText("Thoát");
        ButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextField1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbEmailKH)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbSDT)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbHoKH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TXHoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbMaKH))
                        .addGap(708, 708, 708))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(365, 365, 365))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbTimDV)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(208, 208, 208)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(534, 534, 534)
                                            .addComponent(ButtonChon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(TXEmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TXSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(TXKH, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                            .addComponent(lbTenKH)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(TXTenKH)))
                                                    .addGap(79, 79, 79)
                                                    .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButtonResert)
                                            .addGap(20, 20, 20)))))
                            .addComponent(ButtonThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTimDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbHoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXHoKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonResert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXEmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(ButtonChon)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonThoat)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXHoKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXHoKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXHoKHActionPerformed

    private void TXTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenKHActionPerformed

    private void TXSoGiuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoGiuong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoGiuong1ActionPerformed

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

    private void TXKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKHActionPerformed

    private void ButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimActionPerformed
        try {
            // Lấy giá trị từ các TextField
            String maKHStr = TXKH.getText().trim();
            String hoKHStr = TXHoKH.getText().trim();
            String tenKHStr = TXTenKH.getText().trim();
            String sdtKHStr = TXSDT.getText().trim();
            String emailKHStr = TXEmailKH.getText().trim();

            // Chuyển đổi thành kiểu dữ liệu phù hợp (sử dụng null nếu không có giá trị)
            Integer maKH = maKHStr.isEmpty() ? null : Integer.parseInt(maKHStr);
            String hoKH = hoKHStr.isEmpty() ? null : hoKHStr;
            String tenKH = tenKHStr.isEmpty() ? null : tenKHStr;
            String sdtKH = sdtKHStr.isEmpty() ? null : sdtKHStr;
            String emailKH = emailKHStr.isEmpty() ? null : emailKHStr;

            // Xóa dữ liệu cũ trong bảng
            model.setRowCount(0);

            // Lọc khách hàng từ danh sách gốc
            for (KhachHangDTO kh : danhSachKhachHangGoc) {
                boolean match = true;

                // Kiểm tra các điều kiện tìm kiếm
                if (maKH != null && kh.getMaKhachHang() != maKH) match = false;
                if (hoKH != null && !kh.getHo().contains(hoKH)) match = false;
                if (tenKH != null && !kh.getTen().contains(tenKH)) match = false;
                if (sdtKH != null && !kh.getSoDienThoai().contains(sdtKH)) match = false;
                if (emailKH != null && !kh.getEmail().contains(emailKH)) match = false;

                // Nếu tất cả điều kiện đều phù hợp, thêm khách hàng vào bảng
                if (match) {
                    model.addRow(new Object[] {
                        kh.getMaKhachHang(), kh.getHo(), kh.getTen(),
                        kh.getNgaySinh(), kh.getGioiTinh(), kh.getEmail(), kh.getSoDienThoai()
                    });
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm khách hàng: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonTimActionPerformed

    private void ButtonChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChonActionPerformed
        int row = tblDSKHACHHANG.getSelectedRow();
        if (row >= 0) {
            String maKH = tblDSKHACHHANG.getValueAt(row, 0).toString();
            String ho = tblDSKHACHHANG.getValueAt(row, 1).toString();
            String ten = tblDSKHACHHANG.getValueAt(row, 2).toString();

            String ngaySinhStr = tblDSKHACHHANG.getValueAt(row, 3).toString(); 
            String gioiTinh = tblDSKHACHHANG.getValueAt(row, 4).toString(); 


            Date ngaySinh = null;
            try {
                java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhStr);
                ngaySinh = new java.sql.Date(utilDate.getTime());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày sinh: " + e.getMessage());
                return;
            }

            String email = tblDSKHACHHANG.getValueAt(row, 5).toString();
            String sdt = tblDSKHACHHANG.getValueAt(row, 6).toString();

            formPhieuThue.nhanThongTinKhachHang(maKH, ho, ten, gioiTinh, ngaySinh, sdt, email);
            this.dispose(); // Đóng form chọn
        }
    }//GEN-LAST:event_ButtonChonActionPerformed

    private void TXSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSDTActionPerformed

    private void TXEmailKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXEmailKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXEmailKHActionPerformed

    private void jButtonResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResertActionPerformed
        // Xóa nội dung các TextField
        TXKH.setText("");
        TXHoKH.setText("");
        TXTenKH.setText("");
        TXSDT.setText("");
        TXEmailKH.setText("");

        // Load lại toàn bộ danh sách khách hàng
        model.setRowCount(0); // Xóa dữ liệu hiện tại trong bảng

        for (KhachHangDTO kh : danhSachKhachHangGoc) {
            model.addRow(new Object[] {
                kh.getMaKhachHang(), kh.getHo(), kh.getTen(),
                kh.getNgaySinh(), kh.getGioiTinh(), kh.getEmail(), kh.getSoDienThoai()
            });
        }
    }//GEN-LAST:event_jButtonResertActionPerformed

    private void ButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonThoatActionPerformed
       int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoát?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); // Đóng cửa sổ hiện tại
        }
    }//GEN-LAST:event_ButtonThoatActionPerformed

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
            java.util.logging.Logger.getLogger(ChonKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChonKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChonKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChonKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PhieuThuePhong PhieuThue = new PhieuThuePhong();
                new ChonKhachHang(PhieuThue).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonChon;
    private javax.swing.JButton ButtonThoat;
    private javax.swing.JButton ButtonTim;
    private com.toedter.calendar.JDateChooser DCNgaySinh;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JRadioButton RBNam;
    private javax.swing.JRadioButton RBNu;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXEmail;
    private javax.swing.JTextField TXEmailKH;
    private javax.swing.JTextField TXHoKH;
    private javax.swing.JTextField TXKH;
    private javax.swing.JTextField TXKhachHang1;
    private javax.swing.JTextField TXKhachHang2;
    private javax.swing.JTextField TXKhachHang3;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXSDT;
    private javax.swing.JTextField TXSoGiuong1;
    private javax.swing.JTextField TXTenKH;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonResert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEmailKH;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbHo1;
    private javax.swing.JLabel lbHoKH;
    private javax.swing.JLabel lbKH1;
    private javax.swing.JLabel lbMaKH;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbSoGiuong1;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTenLP1;
    private javax.swing.JLabel lbTimDV;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.Menu menu5;
    private java.awt.Menu menu6;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.MenuBar menuBar3;
    private javax.swing.JTable tblDSKHACHHANG;
    // End of variables declaration//GEN-END:variables
}
