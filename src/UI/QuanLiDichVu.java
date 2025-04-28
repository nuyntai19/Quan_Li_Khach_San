package UI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
// Removed unused and unresolved import
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import sql.DatabaseQLKS;
import java.util.ArrayList;
import DTO.QuanLiDichVuDTO;
import BLL.QuanLiDichVuBLL;

public class QuanLiDichVu extends javax.swing.JFrame {

    private ArrayList<QuanLiDichVuDTO> danhSachDichVuGoc = new ArrayList<>();
    private final DefaultTableModel model;
    private final QuanLiDichVuBLL dichVuBLL;

    
    public QuanLiDichVu() {
        initComponents();
        dichVuBLL = new QuanLiDichVuBLL();
        model = (DefaultTableModel) tblDSDICHVU.getModel(); 
        
        loadData();
        
        tblDSDICHVU.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSDICHVU.getSelectedRow();
                if (selectedRow != -1) {
                    String maDichVu = getValue(tblDSDICHVU, selectedRow, 0);
                    String tenDichVu = getValue(tblDSDICHVU, selectedRow, 1);
                    String moTa = getValue(tblDSDICHVU, selectedRow, 2);
                    String donGia = getValue(tblDSDICHVU, selectedRow, 3);
                    String soLuong = getValue(tblDSDICHVU, selectedRow, 4);

                    // Gán dữ liệu vào các ô nhập liệu tương ứng
                    TXMaDV.setText(maDichVu);
                    TXTenDV.setText(tenDichVu);
                    TXMoTa.setText(moTa);
                    TXDG.setText(donGia);
                    TXSoLuong.setText(soLuong);
                }
            }

            // Hàm tiện ích để lấy giá trị có kiểm null
            private String getValue(JTable table, int row, int col) {
                Object value = table.getValueAt(row, col);
                return value != null ? value.toString() : "";
            }
        });

    }
    
    private void loadData() {
        try {
            model.setRowCount(0); // Xóa dữ liệu cũ

            // Đảm bảo rằng bảng đã có các cột cần thiết
            model.setColumnIdentifiers(new String[] {
                "Mã Dịch Vụ", "Tên Dịch Vụ", "Mô Tả", "Đơn Giá", "Số lượng"
            });

            // Lấy lại dữ liệu từ cơ sở dữ liệu
            danhSachDichVuGoc = dichVuBLL.layDanhSachDichVu();
            for (QuanLiDichVuDTO dv : danhSachDichVuGoc) {
                model.addRow(new Object[] {
                    dv.getMaDichVu(), dv.getTenDichVu(), dv.getMoTa(), dv.getDonGia(), dv.getSoLuong()
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
        BTDV = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Tittle = new javax.swing.JLabel();
        self = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        TXTimDV = new javax.swing.JTextField();
        lbMaDV = new javax.swing.JLabel();
        lbTenDV = new javax.swing.JLabel();
        TXTenDV = new javax.swing.JTextField();
        lbMoTa = new javax.swing.JLabel();
        TXMoTa = new javax.swing.JTextField();
        lbDG = new javax.swing.JLabel();
        TXDG = new javax.swing.JTextField();
        lbTimDV = new javax.swing.JLabel();
        lbMaDV1 = new javax.swing.JLabel();
        lbTimTenDV = new javax.swing.JLabel();
        TXMaDV = new javax.swing.JTextField();
        TXTimTenDV = new javax.swing.JTextField();
        ButtonTim = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDSDICHVU = new javax.swing.JTable();
        ButtonThem = new javax.swing.JButton();
        ButtonSua = new javax.swing.JButton();
        ButtonSua1 = new javax.swing.JButton();
        lbSoLuong = new javax.swing.JLabel();
        TXSoLuong = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButtonResert = new javax.swing.JButton();
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
        ButtonTaoTaiKhoan = new javax.swing.JButton();

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

        BTDV.setBackground(new java.awt.Color(52, 152, 219));
        BTDV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTDV.setForeground(new java.awt.Color(255, 255, 255));
        BTDV.setText("Đặt dịch vụ");
        BTDV.setIconTextGap(5);
        BTDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTDVActionPerformed(evt);
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
        jLabel1.setText("DỊCH VỤ");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        TXTimDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTimDVActionPerformed(evt);
            }
        });

        lbMaDV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaDV.setText("Mã dịch vụ");

        lbTenDV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTenDV.setText("Tên dịch vụ:");

        TXTenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenDVActionPerformed(evt);
            }
        });

        lbMoTa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMoTa.setText("Mô tả:");

        TXMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMoTaActionPerformed(evt);
            }
        });

        lbDG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDG.setText("Đơn giá:");

        TXDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXDGActionPerformed(evt);
            }
        });

        lbTimDV.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbTimDV.setText("TÌM DỊCH VỤ: ");

        lbMaDV1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaDV1.setText("Mã dịch vụ");

        lbTimTenDV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTimTenDV.setText("Tên dịch vụ:");

        TXMaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMaDVActionPerformed(evt);
            }
        });

        TXTimTenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTimTenDVActionPerformed(evt);
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

        tblDSDICHVU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Mô tả", "Đơn giá", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblDSDICHVU);

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

        ButtonSua1.setBackground(new java.awt.Color(52, 152, 219));
        ButtonSua1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonSua1.setForeground(new java.awt.Color(255, 255, 255));
        ButtonSua1.setText("Xóa");
        ButtonSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSua1ActionPerformed(evt);
            }
        });

        lbSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoLuong.setText("Số lượng:");

        TXSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSoLuongActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(52, 152, 219));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField3.setEnabled(false);

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
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTimDV)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1075, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbMaDV1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TXTimDV, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TXTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbDG, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TXDG, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(lbMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TXSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbTimTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTimTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jButtonResert)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ButtonSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(117, 117, 117))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(465, 465, 465))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TXMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonThem)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbDG, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ButtonSua1)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonSua)))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lbTimDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaDV1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTimDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTimTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXTimTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonTim)))
                    .addComponent(jButtonResert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
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

        ButtonTaoTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTaoTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/accountant.png"))); // NOI18N
        ButtonTaoTaiKhoan.setText("Tạo Tài Khoản");
        ButtonTaoTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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
                    .addComponent(ButtonQLNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(ButtonKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonTaoTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(ButtonTaoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KhachSan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuanLi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonQLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLPhongActionPerformed
        dispose();
        new QuanLiPhong().setVisible(true);
    }//GEN-LAST:event_ButtonQLPhongActionPerformed

    private void selfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        new PhieuThuePhong().setVisible(true);
    }//GEN-LAST:event_KhachSanActionPerformed

    private void TXTimDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTimDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTimDVActionPerformed

    private void BTDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTDVActionPerformed

    private void TXTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenDVActionPerformed

    private void TXMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMoTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMoTaActionPerformed

    private void TXDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXDGActionPerformed

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

    private void TXMaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMaDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMaDVActionPerformed

    private void TXTimTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTimTenDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTimTenDVActionPerformed

    private void ButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimActionPerformed
        try {
            String maDichVuStr = TXTimDV.getText().trim();
            String tenDichVuStr = TXTimTenDV.getText().trim().toLowerCase();

            Integer maDichVu = maDichVuStr.isEmpty() ? null : Integer.parseInt(maDichVuStr);

            model.setRowCount(0); // Xóa bảng hiện tại

            for (QuanLiDichVuDTO dv : danhSachDichVuGoc) {
                boolean match = true;

                if (maDichVu != null && dv.getMaDichVu() != maDichVu) match = false;
                if (!tenDichVuStr.isEmpty() && !dv.getTenDichVu().toLowerCase().contains(tenDichVuStr)) match = false;

                if (match) {
                    model.addRow(new Object[] {
                        dv.getMaDichVu(), dv.getTenDichVu(), dv.getMoTa(),
                        dv.getDonGia(), dv.getSoLuong()
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonTimActionPerformed

    private void ButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonThemActionPerformed
        try {
                 
                 if (TXMaDV.getText().isEmpty() || TXTenDV.getText().isEmpty() || TXMoTa.getText().isEmpty() || TXDG.getText().isEmpty() || TXSoLuong.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                     return;
                 }
                 
                 

                 QuanLiDichVuDTO dv = new QuanLiDichVuDTO(
                     Integer.parseInt(TXMaDV.getText()),
                     TXTenDV.getText(),
                     TXMoTa.getText(),
                     Double.parseDouble(TXDG.getText()),
                     Integer.parseInt(TXSoLuong.getText())
                 );

                 dichVuBLL.themDichVu(dv);

                 // Sau khi thêm thành công, làm mới bảng
                 loadData();

                 JOptionPane.showMessageDialog(this, "Thêm dịch vụ thành công!");
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
             }        
    }//GEN-LAST:event_ButtonThemActionPerformed

    private void ButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSuaActionPerformed
        try {
            int selectedRow = tblDSDICHVU.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ cần sửa.");
                return;
            }

            // Lấy dữ liệu từ các TextFields và ComboBox
            int maDichVu = Integer.parseInt(TXMaDV.getText());
            String tenDichVu = TXTenDV.getText();
            String moTa =TXMoTa.getText();
            double donGia = Double.parseDouble(TXDG.getText());
            int soLuong = Integer.parseInt(TXSoLuong.getText());
           


            if (TXMaDV.getText().isEmpty() || TXTenDV.getText().isEmpty() || TXMoTa.getText().isEmpty() || TXDG.getText().isEmpty() || TXSoLuong.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                     return;
                 }

            QuanLiDichVuDTO dv = new QuanLiDichVuDTO(maDichVu, tenDichVu, moTa, donGia, soLuong);
            QuanLiDichVuBLL qlDichVuBLL = new QuanLiDichVuBLL();
            qlDichVuBLL.suaDichVu(dv);  

            // Cập nhật bảng
            model.setValueAt(maDichVu, selectedRow, 0);
            model.setValueAt(tenDichVu, selectedRow, 1);
            model.setValueAt(moTa, selectedRow, 2);
            model.setValueAt(donGia, selectedRow, 3);
            model.setValueAt(soLuong, selectedRow, 4);
            

            JOptionPane.showMessageDialog(this, "Cập nhật dịch vụ thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonSuaActionPerformed

    private void ButtonSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSua1ActionPerformed
        try {
            int selectedRow = tblDSDICHVU.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dịch vụ cần xóa.");
                return;
            }

            int maDichVu = (int) model.getValueAt(selectedRow, 0);

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dịch vụ có mã dịch vụ: " + maDichVu + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Thực hiện xóa phòng
                QuanLiDichVuBLL qlDichVuBLL = new QuanLiDichVuBLL();
                qlDichVuBLL.xoaDichVu(maDichVu);  
                JOptionPane.showMessageDialog(this, "Xóa dịch vụ thành công!");
                loadData();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonSua1ActionPerformed

    private void TXSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoLuongActionPerformed

    private void QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        dispose();
        new QuanLiPhong().setVisible(true);
    }//GEN-LAST:event_QuanLiActionPerformed

    private void ButtonQLDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLDVActionPerformed
        dispose();
        new QuanLiDichVu().setVisible(true);
    }//GEN-LAST:event_ButtonQLDVActionPerformed

    private void jButtonResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResertActionPerformed
        // Xóa nội dung trong các ô tìm kiếm
        TXTimDV.setText("");
        TXTimTenDV.setText("");

        // Xóa toàn bộ dữ liệu bảng
        model.setRowCount(0);

        // Đổ lại toàn bộ dữ liệu từ danh sách gốc
        for (QuanLiDichVuDTO dv : danhSachDichVuGoc) {
            model.addRow(new Object[] {
                dv.getMaDichVu(), dv.getTenDichVu(), dv.getMoTa(),
                dv.getDonGia(), dv.getSoLuong()
            });
        }
    }//GEN-LAST:event_jButtonResertActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiDichVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTDV;
    private javax.swing.JButton ButtonKhoHang;
    private javax.swing.JButton ButtonQLDV;
    private javax.swing.JButton ButtonQLNV;
    private javax.swing.JButton ButtonQLNhaCUngCap;
    private javax.swing.JButton ButtonQLNhapHang;
    private javax.swing.JButton ButtonQLPhong;
    private javax.swing.JButton ButtonSua;
    private javax.swing.JButton ButtonSua1;
    private javax.swing.JButton ButtonTaoTaiKhoan;
    private javax.swing.JButton ButtonThem;
    private javax.swing.JButton ButtonThongKe;
    private javax.swing.JButton ButtonTim;
    private com.toedter.calendar.JDateChooser DCNgaySinh;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JRadioButton RBNam;
    private javax.swing.JRadioButton RBNu;
    private javax.swing.JTextField TXDG;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXEmail;
    private javax.swing.JTextField TXKhachHang1;
    private javax.swing.JTextField TXKhachHang2;
    private javax.swing.JTextField TXKhachHang3;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXMaDV;
    private javax.swing.JTextField TXMoTa;
    private javax.swing.JTextField TXSoGiuong1;
    private javax.swing.JTextField TXSoLuong;
    private javax.swing.JTextField TXTenDV;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTextField TXTimDV;
    private javax.swing.JTextField TXTimTenDV;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.JLabel Tittle;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel lbDG;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioiTinh;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbHo1;
    private javax.swing.JLabel lbKH1;
    private javax.swing.JLabel lbMaDV;
    private javax.swing.JLabel lbMaDV1;
    private javax.swing.JLabel lbMoTa;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbSoGiuong1;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenDV;
    private javax.swing.JLabel lbTenLP1;
    private javax.swing.JLabel lbTimDV;
    private javax.swing.JLabel lbTimTenDV;
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
    private javax.swing.JTable tblDSDICHVU;
    // End of variables declaration//GEN-END:variables
}
