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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import BLL.ThongKeBLL;
import DTO.*;
import BLL.*;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ThongKe extends javax.swing.JFrame {
    private final ThongKeBLL thongKeBLL;
    private final DefaultTableModel model;
    private final KhachHangBLL khachHangBLL;
    private final QuanLiPhongBLL quanLiPhongBLL;
    private final QuanLiDichVuBLL quanLiDichVuBLL;
    private final NhanVienBLL nhanVienBLL;
    private final PhieuThuePhongBLL phieuThuePhongBLL;
    private final ChiTietPhieuThuePhongBLL chiTietPhieuThuePhongBLL;
    private final DatDichVuBLL datDichVuBLL;
    private final HoaDonBLL hoaDonBLL;
    private final ChiTietHoaDonBLL chiTietHoaDonBLL;
    private final LoaiPhongBLL loaiPhongBLL;
    
    
    
    
    public ThongKe() throws SQLException {
        initComponents();
        addEvents();
        dcNgayBatDau.setVisible(false);
        lbNgayBatDau.setVisible(false);
        lbNgayKetThuc.setVisible(false);
        dcNgayKetThuc.setVisible(false);
        txtThang.setVisible(false);
        lbThang.setVisible(false);
        txtNam.setVisible(false);
        lbNam.setVisible(false);
        
        thongKeBLL = new ThongKeBLL();
        khachHangBLL = new KhachHangBLL();
        quanLiPhongBLL = new QuanLiPhongBLL();
        quanLiDichVuBLL = new QuanLiDichVuBLL();
        nhanVienBLL = new NhanVienBLL();
        phieuThuePhongBLL = new PhieuThuePhongBLL();
        chiTietPhieuThuePhongBLL = new ChiTietPhieuThuePhongBLL();
        datDichVuBLL = new DatDichVuBLL();
        hoaDonBLL = new HoaDonBLL();
        chiTietHoaDonBLL = new ChiTietHoaDonBLL();
        loaiPhongBLL = new LoaiPhongBLL();
        model = (DefaultTableModel) tblDSTHONGKE.getModel();
        
        
        
        
    } 
    
    private void addEvents() {
        cbChonThongKe.addActionListener(e -> {
            String luaChon = cbChonThongKe.getSelectedItem().toString();
            boolean laNgay = luaChon.equals("Theo Ngày");
            boolean laThang = luaChon.equals("Theo Tháng");
            boolean laNam = luaChon.equals("Theo Năm");

            dcNgayBatDau.setVisible(laNgay);
            lbNgayBatDau.setVisible(laNgay);
            lbNgayKetThuc.setVisible(laNgay);
            dcNgayKetThuc.setVisible(laNgay);
            txtThang.setVisible(laThang);
            lbThang.setVisible(laThang);
            txtNam.setVisible(laThang || laNam);
            lbNam.setVisible(laThang || laNam);
        });
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
        lbNgayBatDau = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSTHONGKE = new javax.swing.JTable();
        btnThongKe = new javax.swing.JButton();
        lbNgayKetThuc = new javax.swing.JLabel();
        dcNgayBatDau = new com.toedter.calendar.JDateChooser();
        dcNgayKetThuc = new com.toedter.calendar.JDateChooser();
        cbChonThongKe = new javax.swing.JComboBox<>();
        lbMaPhong2 = new javax.swing.JLabel();
        lbThang = new javax.swing.JLabel();
        lbNam = new javax.swing.JLabel();
        txtThang = new javax.swing.JTextField();
        txtNam = new javax.swing.JTextField();
        lbNam1 = new javax.swing.JLabel();
        cbChonXuat = new javax.swing.JComboBox<>();
        btnXuatExcel = new javax.swing.JButton();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1125, Short.MAX_VALUE)
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
        jLabel1.setText("THỐNG KÊ DOANH THU");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        lbNgayBatDau.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgayBatDau.setText("Ngày bắt đầu :");

        tblDSTHONGKE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Loại Chi Tiết", "Số lượng", "Tổng Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDSTHONGKE);

        btnThongKe.setBackground(new java.awt.Color(52, 152, 219));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống Kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        lbNgayKetThuc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgayKetThuc.setText("Ngày kết thúc :");

        cbChonThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_", "Theo Ngày", "Theo Tháng", "Theo Năm" }));

        lbMaPhong2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaPhong2.setText("Chọn loại thống kê :");

        lbThang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbThang.setText("Nhập tháng :");

        lbNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNam.setText("Nhập năm :");

        lbNam1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbNam1.setText("Xuất file Excel :");

        cbChonXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_", "Danh sách phiếu thuê phòng", "Danh sách đặt dịch vụ", "Danh sách hóa đơn", "Danh sách nhân viên", "Danh sách khách hàng", "Danh sách dịch vụ", "Danh sách phòng", "Danh sách loại phòng" }));

        btnXuatExcel.setBackground(new java.awt.Color(52, 152, 219));
        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(466, 466, 466)
                                .addComponent(jLabel1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(lbNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(dcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbMaPhong2)
                                        .addGap(38, 38, 38)
                                        .addComponent(cbChonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lbNam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbThang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtThang)
                                            .addComponent(txtNam))
                                        .addGap(707, 707, 707))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbNam1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbChonXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbChonThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThongKe)
                            .addComponent(dcNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNam1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbChonXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatExcel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(37, 37, 37))
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
        ButtonQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQLNVActionPerformed(evt);
            }
        });

        ButtonQLNhaCUngCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonQLNhaCUngCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/QLNHACUNGCAP.png"))); // NOI18N
        ButtonQLNhaCUngCap.setText("Quản lí Nhà Cung Cấp");
        ButtonQLNhaCUngCap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ButtonQLNhaCUngCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQLNhaCUngCapActionPerformed(evt);
            }
        });

        ButtonThongKe.setBackground(new java.awt.Color(238, 255, 255));
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
        ButtonTaoTaiKhoan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTaoTaiKhoan1ActionPerformed(evt);
            }
        });

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
                .addGap(204, 204, 204))
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
       
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
      
        new PhieuThuePhong().setVisible(true); 
    }//GEN-LAST:event_KhachSanActionPerformed

    private void TXTenLP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLP1ActionPerformed

    private void ButtonQLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLPhongActionPerformed
        dispose();
        new QuanLiPhong().setVisible(true);        
    }//GEN-LAST:event_ButtonQLPhongActionPerformed

    private void QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        dispose();
        new QuanLiPhong().setVisible(true);
    }//GEN-LAST:event_QuanLiActionPerformed

    private void ButtonQLDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLDVActionPerformed
        dispose();
     
        new QuanLiDichVu().setVisible(true);
    }//GEN-LAST:event_ButtonQLDVActionPerformed

    private void ButtonTaoTaiKhoan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTaoTaiKhoan1ActionPerformed
        dispose();
        new TaiKhoan().setVisible(true);
    }//GEN-LAST:event_ButtonTaoTaiKhoan1ActionPerformed

    private void ButtonQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLNVActionPerformed
        dispose();
        try {
            new QuanLiNhanVien().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonQLNVActionPerformed

    private void ButtonKhoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonKhoHangActionPerformed
        new GiaoDienKhoHang().setVisible(true);
    }//GEN-LAST:event_ButtonKhoHangActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
         String loaiThongKe = cbChonThongKe.getSelectedItem() != null ? cbChonThongKe.getSelectedItem().toString() : "";
     
     Map<String, Double> ketQua = null;

     if (loaiThongKe.equals("Theo Ngày")) {
         java.util.Date utilTuNgay = dcNgayBatDau.getDate();
         java.util.Date utilDenNgay = dcNgayKetThuc.getDate();
         if (utilTuNgay == null || utilDenNgay == null) {
             JOptionPane.showMessageDialog(this, "Vui lòng chọn khoảng thời gian!");
             return;
         }

         // Ép kiểu sang java.sql.Date
         java.sql.Date sqlTuNgay = new java.sql.Date(utilTuNgay.getTime());
         java.sql.Date sqlDenNgay = new java.sql.Date(utilDenNgay.getTime());

         ketQua = thongKeBLL.layDoanhThuTheoLoai(sqlTuNgay, sqlDenNgay);
     } else if (loaiThongKe.equals("Theo Tháng")) {
         String thangStr = txtThang.getText().trim();
         String namStr = txtNam.getText().trim();
         if (thangStr.isEmpty() || namStr.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập tháng và năm!");
             return;
         }
         int thang = Integer.parseInt(thangStr);
         int nam = Integer.parseInt(namStr);
         ketQua = thongKeBLL.thongKeTheoThang(thang, nam);
     } else if (loaiThongKe.equals("Theo Năm")) {
         String namStr = txtNam.getText().trim();
         if (namStr.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập năm!");
             return;
         }
         int nam = Integer.parseInt(namStr);
         ketQua = thongKeBLL.thongKeTheoNam(nam);
     }
     
     model.setRowCount(0); // Xóa dữ liệu cũ
     
     model.setColumnIdentifiers(new String[] {
         "Loại Chi Tiết", "Số Lượng", "Tổng Doanh Thu"
     });
     
     if (ketQua != null) {
         for (Map.Entry<String, Double> entry : ketQua.entrySet()) {
            String loai = entry.getKey();
            Double tongTien = entry.getValue();
            int soLuong = 0;
              
            if (loaiThongKe.equals("Theo Ngày")) {
                soLuong = thongKeBLL.getSoLuongForLoaiTheoNgay(loai, dcNgayBatDau.getDate(), dcNgayKetThuc.getDate());
            } else if (loaiThongKe.equals("Theo Tháng")) {
                int thang = Integer.parseInt(txtThang.getText().trim());
                int nam = Integer.parseInt(txtNam.getText().trim());
                soLuong = thongKeBLL.getSoLuongForLoaiTheoThang(loai, thang, nam);
            } else if (loaiThongKe.equals("Theo Năm")) {
                int nam = Integer.parseInt(txtNam.getText().trim());
                soLuong = thongKeBLL.getSoLuongForLoaiTheoNam(loai, nam);
            } // Gọi hàm để lấy số lượng
             model.addRow(new Object[]{loai, soLuong, tongTien});
         }
     } else {
         JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê!");
     }
 
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void ButtonQLNhaCUngCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLNhaCUngCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQLNhaCUngCapActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        String luaChon = cbChonXuat.getSelectedItem().toString();

    ArrayList<?> duLieu = null;
    String[] tieuDe = null;

    switch (luaChon) {
        case "Danh sách khách hàng":
            try {
                duLieu = khachHangBLL.layDanhSachKhachHang();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            tieuDe = new String[] {"Mã KH", "Họ", "Tên", "Ngày sinh", "Giới tính", "Email", "SĐT"};
            break;

        case "Danh sách phòng":
            try {
                duLieu = quanLiPhongBLL.layDanhSachPhong();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            tieuDe = new String[] {"Mã phòng", "Mã loại phòng", "Số giường", "Đơn giá", "Trạng thái"};
            break;

        case "Danh sách dịch vụ":
            try {
                duLieu = quanLiDichVuBLL.layDanhSachDichVu();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            tieuDe = new String[] {"Mã DV", "Tên dịch vụ", "Mô tả", "Đơn giá", "Số lượng"};
            break;

        case "Danh sách nhân viên":
            try {
                duLieu = nhanVienBLL.layDanhSachNhanVien();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            tieuDe = new String[] {"Mã NV", "Họ", "Tên", "Ngày sinh", "Giới tính", "Email", "SĐT", "Chức vụ", "Lương"};
            break;
            
        case "Danh sách đặt dịch vụ":
            try {
                duLieu = datDichVuBLL.layDanhSachDatDichVu();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            tieuDe = new String[] {"ID Chi tiết thuê", "Mã dịch vụ", "Số lượng", "Đơn giá", "Thành tiền"};
            break;
            
        case "Danh sách loại phòng":
            try {
                duLieu = loaiPhongBLL.layDanhSachLoaiPhong();
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            tieuDe = new String[] {"Mã loại phòng", "Tên loại phòng", "Mô tả"};
            break;    
        
        case "Danh sách hóa đơn":
            try {
                ArrayList<HoaDonDTO> dsHoaDon = (ArrayList<HoaDonDTO>) hoaDonBLL.layDanhSachHoaDon();
                ArrayList<ChiTietHoaDonDTO> dsChiTietHD = (ArrayList<ChiTietHoaDonDTO>) chiTietHoaDonBLL.layDanhSachChiTietHoaDon();
                xuatHoaDonVaChiTiet(dsHoaDon, dsChiTietHD);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Lỗi khi lấy dữ liệu hóa đơn: " + ex.getMessage());
            }
            return;
            
        case "Danh sách phiếu thuê phòng":
            try {
                ArrayList<PhieuThuePhongDTO> dsPhieu =
                    phieuThuePhongBLL.layDanhSachPhieuThue();
                ArrayList<ChiTietPhieuThuePhongDTO> dsChiTiet =
                    chiTietPhieuThuePhongBLL.layDanhSachChiTiet();
                xuatPhieuVaChiTiet(dsPhieu, dsChiTiet);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName())
                      .log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,
                    "Lỗi khi lấy dữ liệu phiếu thuê: " + ex.getMessage());
            }
            return; 

        default:
            JOptionPane.showMessageDialog(null, "Chọn danh mục cần xuất.");
            return;
    }

    xuatExcel(luaChon, duLieu, tieuDe);
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    
    private void xuatExcel(String tenFile, ArrayList<?> duLieu, String[] tieuDe) {
    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
        XSSFSheet sheet = workbook.createSheet(tenFile);

        // Ghi dòng tiêu đề
        Row header = sheet.createRow(0);
        for (int i = 0; i < tieuDe.length; i++) {
            header.createCell(i).setCellValue(tieuDe[i]);
        }

        // Ghi dữ liệu
        for (int i = 0; i < duLieu.size(); i++) {
            Object obj = duLieu.get(i);
            Row row = sheet.createRow(i + 1);

            if (obj instanceof KhachHangDTO kh) {
                row.createCell(0).setCellValue(kh.getMaKhachHang());
                row.createCell(1).setCellValue(kh.getHo());
                row.createCell(2).setCellValue(kh.getTen());
                row.createCell(3).setCellValue(kh.getNgaySinh().toString());
                row.createCell(4).setCellValue(kh.getGioiTinh());
                row.createCell(5).setCellValue(kh.getEmail());
                row.createCell(6).setCellValue(kh.getSoDienThoai());
            }
            else if (obj instanceof QuanLiPhongDTO p) {
                row.createCell(0).setCellValue(p.getMaPhong());
                row.createCell(1).setCellValue(p.getMaLoaiPhong());
                row.createCell(2).setCellValue(p.getSoGiuong());
                row.createCell(3).setCellValue(p.getDonGia());
                row.createCell(4).setCellValue(p.getTrangThai());
            }
            else if (obj instanceof QuanLiDichVuDTO dv) {
                row.createCell(0).setCellValue(dv.getMaDichVu());
                row.createCell(1).setCellValue(dv.getTenDichVu());
                row.createCell(2).setCellValue(dv.getMoTa());
                row.createCell(3).setCellValue(dv.getDonGia());
                row.createCell(4).setCellValue(dv.getSoLuong());
            }
            else if (obj instanceof NhanVienDTO nv) {
                row.createCell(0).setCellValue(nv.getMaNhanVien());
                row.createCell(1).setCellValue(nv.getHo());
                row.createCell(2).setCellValue(nv.getTen());
                row.createCell(3).setCellValue(nv.getNgaySinh().toString());
                row.createCell(4).setCellValue(nv.getGioiTinh());
                row.createCell(5).setCellValue(nv.getEmail());
                row.createCell(6).setCellValue(nv.getSdt());
                row.createCell(7).setCellValue(nv.getChucVu());
                row.createCell(8).setCellValue(nv.getLuong());
            }
            else if (obj instanceof DatDichVuDTO dvThue) {
                row.createCell(0).setCellValue(dvThue.getIdChiTietPhieuThue());
                row.createCell(1).setCellValue(dvThue.getMaDichVu());
                row.createCell(2).setCellValue(dvThue.getSoLuong());
                row.createCell(3).setCellValue(dvThue.getDonGia());
                row.createCell(4).setCellValue(dvThue.getThanhTien());
            }
            else if (obj instanceof LoaiPhongDTO lp) {
                row.createCell(0).setCellValue(lp.getMaLoaiPhong());
                row.createCell(1).setCellValue(lp.getTenLoaiPhong());
                row.createCell(2).setCellValue(lp.getMoTa());
            }
        }

        // Tự động điều chỉnh độ rộng các cột
        for (int i = 0; i < tieuDe.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Chọn file xuất
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(tenFile + ".xlsx"));
        int chon = fileChooser.showSaveDialog(null);

        if (chon == JFileChooser.APPROVE_OPTION) {
            try (FileOutputStream out = new FileOutputStream(fileChooser.getSelectedFile())) {
                workbook.write(out);
            }
            JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi xuất Excel: " + e.getMessage());
    }
}
    
    private void xuatHoaDonVaChiTiet(
    ArrayList<HoaDonDTO> dsHoaDon,
    ArrayList<ChiTietHoaDonDTO> dsChiTiet
) {
    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
        // Sheet 1: Hóa đơn
        XSSFSheet sheet1 = workbook.createSheet("Hóa đơn");
        String[] headerHD = {"Mã hóa đơn", "Mã phiếu thuê", "Ngày lập", "Tổng tiền"};
        Row h1 = sheet1.createRow(0);
        for (int i = 0; i < headerHD.length; i++) {
            h1.createCell(i).setCellValue(headerHD[i]);
        }
        for (int i = 0; i < dsHoaDon.size(); i++) {
            HoaDonDTO hd = dsHoaDon.get(i);
            Row r = sheet1.createRow(i + 1);
            r.createCell(0).setCellValue(hd.getMaHD());
            r.createCell(1).setCellValue(hd.getMaPTP());
            r.createCell(2).setCellValue(hd.getNgayLap().toString());
            r.createCell(3).setCellValue(hd.getTongTien());
        }

        // Sheet 2: Chi tiết hóa đơn
        XSSFSheet sheet2 = workbook.createSheet("Chi tiết hóa đơn");
        String[] headerCT = {"Mã CTHĐ", "Mã HĐ", "Mã phòng", "Mã dịch vụ", "Loại", "Số lượng", "Đơn giá", "Thành tiền"};
        Row h2 = sheet2.createRow(0);
        for (int i = 0; i < headerCT.length; i++) {
            h2.createCell(i).setCellValue(headerCT[i]);
        }
        for (int i = 0; i < dsChiTiet.size(); i++) {
            ChiTietHoaDonDTO ct = dsChiTiet.get(i);
            Row r = sheet2.createRow(i + 1);
            r.createCell(0).setCellValue(ct.getMaCTHD());
            r.createCell(1).setCellValue(ct.getMaHD());
            r.createCell(2).setCellValue(ct.getMaPhong());
            r.createCell(3).setCellValue(ct.getMaDV());
            r.createCell(4).setCellValue(ct.getLoaiChiTiet());
            r.createCell(5).setCellValue(ct.getSoLuong());
            r.createCell(6).setCellValue(ct.getDonGia());
            r.createCell(7).setCellValue(ct.getThanhTien());
        }

        // Auto-size
        for (int i = 0; i < headerHD.length; i++) sheet1.autoSizeColumn(i);
        for (int i = 0; i < headerCT.length; i++) sheet2.autoSizeColumn(i);

        // Ghi file
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("HoaDon_va_ChiTiet.xlsx"));
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (FileOutputStream out = new FileOutputStream(chooser.getSelectedFile())) {
                workbook.write(out);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi xuất Excel: " + e.getMessage());
    }
}

    
    private void xuatPhieuVaChiTiet(
    ArrayList<PhieuThuePhongDTO> dsPhieu,
    ArrayList<ChiTietPhieuThuePhongDTO> dsChiTiet
) {
    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
        // ---- Sheet 1: Phiếu thuê phòng ----
        XSSFSheet sheet1 = workbook.createSheet("Phiếu thuê phòng");
        String[] headerPhieu = {
            "Mã phiếu thuê", "Mã khách hàng", "Mã nhân viên",
            "Ngày lập phiếu", "Tổng tiền", "Trạng thái"
        };
        Row h1 = sheet1.createRow(0);
        for (int i = 0; i < headerPhieu.length; i++) {
            h1.createCell(i).setCellValue(headerPhieu[i]);
        }
        for (int i = 0; i < dsPhieu.size(); i++) {
            PhieuThuePhongDTO p = dsPhieu.get(i);
            Row r = sheet1.createRow(i + 1);
            r.createCell(0).setCellValue(p.getMaThuePhong());
            r.createCell(1).setCellValue(p.getMaKhachHang());
            r.createCell(2).setCellValue(p.getMaNhanVien());
            r.createCell(3).setCellValue(p.getNgayLapPhieu().toString());
            r.createCell(4).setCellValue(p.getTongTien());
            r.createCell(5).setCellValue(p.getTrangThai());
        }

        // ---- Sheet 2: Chi tiết phiếu thuê ----
        XSSFSheet sheet2 = workbook.createSheet("Chi tiết thuê phòng");
        String[] headerChiTiet = {
            "ID", "Mã phiếu thuê", "Mã phòng",
            "Ngày đặt", "Ngày trả", "Giá phòng", "Thành tiền"
        };
        Row h2 = sheet2.createRow(0);
        for (int i = 0; i < headerChiTiet.length; i++) {
            h2.createCell(i).setCellValue(headerChiTiet[i]);
        }
        for (int i = 0; i < dsChiTiet.size(); i++) {
            ChiTietPhieuThuePhongDTO c = dsChiTiet.get(i);
            Row r = sheet2.createRow(i + 1);
            r.createCell(0).setCellValue(c.getId());
            r.createCell(1).setCellValue(c.getMaThuePhong());
            r.createCell(2).setCellValue(c.getMaPhong());
            r.createCell(3).setCellValue(c.getNgayDatPhong().toString());
            r.createCell(4).setCellValue(c.getNgayTraPhong().toString());
            r.createCell(5).setCellValue(c.getGiaPhong());
            r.createCell(6).setCellValue(c.getThanhTien());
        }

        // Auto-size cả hai sheet
        for (int i = 0; i < headerPhieu.length; i++) sheet1.autoSizeColumn(i);
        for (int i = 0; i < headerChiTiet.length; i++) sheet2.autoSizeColumn(i);

        // Chọn file để lưu
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("PhieuThue_va_ChiTiet.xlsx"));
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (FileOutputStream out = new FileOutputStream(chooser.getSelectedFile())) {
                workbook.write(out);
                JOptionPane.showMessageDialog(null, "Xuất Excel thành công!");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi khi xuất Excel: " + e.getMessage());
    }
}





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
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            ThongKe quanLiPhong = null;
            try {
                quanLiPhong = new ThongKe(); // Tạo đối tượng QuanLiPhong
            } catch (SQLException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private javax.swing.JButton ButtonTaoTaiKhoan1;
    private javax.swing.JButton ButtonThongKe;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.JLabel Tittle;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbChonThongKe;
    private javax.swing.JComboBox<String> cbChonXuat;
    private com.toedter.calendar.JDateChooser dcNgayBatDau;
    private com.toedter.calendar.JDateChooser dcNgayKetThuc;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel lbMaPhong2;
    private javax.swing.JLabel lbNam;
    private javax.swing.JLabel lbNam1;
    private javax.swing.JLabel lbNgayBatDau;
    private javax.swing.JLabel lbNgayKetThuc;
    private javax.swing.JLabel lbThang;
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
    private javax.swing.JTable tblDSTHONGKE;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtThang;
    // End of variables declaration//GEN-END:variables
    


}

