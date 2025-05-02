package UI;

import BLL.ChiTietHoaDonBLL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DTO.HoaDonDTO;
import BLL.HoaDonBLL;
import DTO.ChiTietHoaDonDTO;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.ChiTietPhieuThuePhongDTO;
import DTO.PhieuThuePhongDTO;
import BLL.ChiTietPhieuThuePhongBLL;
import BLL.ChiTietHoaDonBLL;
import BLL.DatDichVuBLL;
import DTO.DatDichVuDTO;
import BLL.PhieuThuePhongBLL;
import BLL.NhanVienBLL;
import DTO.NhanVienDTO;
import DTO.KhachHangDTO;
import BLL.KhachHangBLL;
import BLL.QuanLiDichVuBLL;
import DTO.QuanLiDichVuDTO;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashSet;
import java.util.Set;

public class DanhSachHoaDon extends javax.swing.JFrame {

    private ArrayList<HoaDonDTO> danhSachHoaDonGoc = new ArrayList<>();
    private ArrayList<ChiTietPhieuThuePhongDTO> danhSachChiTietPhieuThue = new ArrayList<>();
    private DefaultTableModel model;
    private DefaultTableModel modelChiTiet;
    private HoaDonBLL hoaDonBLL;
    private ChiTietHoaDonBLL chiTietHoaDonBLL;
    private ChiTietPhieuThuePhongBLL chiTietPhieuThuePhongBLL;
    private DatDichVuBLL datDichVuBLL;
    private PhieuThuePhongBLL phieuThuePhongBLL;
    private NhanVienBLL nhanVienBLL;
    private KhachHangBLL khachHangBLL;
    private QuanLiDichVuBLL quanLiDichVuBLL;
    


    public DanhSachHoaDon() throws SQLException {
        initComponents();
        hoaDonBLL = new HoaDonBLL();
        chiTietHoaDonBLL = new ChiTietHoaDonBLL();
        chiTietPhieuThuePhongBLL = new ChiTietPhieuThuePhongBLL();
        datDichVuBLL = new DatDichVuBLL();
        phieuThuePhongBLL = new PhieuThuePhongBLL();
        nhanVienBLL = new NhanVienBLL();
        khachHangBLL = new KhachHangBLL();
        quanLiDichVuBLL = new QuanLiDichVuBLL();
                
        model = (DefaultTableModel) tblDSHOADON.getModel();
        modelChiTiet = (DefaultTableModel) tblDSCHITIETHOADON.getModel();
        loadDataHoaDon();
        loadDataChiTietHoaDon();
        loadComboBoxPhieuThuePhong();
        
        tblDSHOADON.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSHOADON.getSelectedRow();
                if (selectedRow != -1) {
                    String maHD = getValue(tblDSHOADON, selectedRow, 0);      // Mã hóa đơn
                    String maPTP = getValue(tblDSHOADON, selectedRow, 1);     // Mã phiếu thuê
                    String ngayLap = getValue(tblDSHOADON, selectedRow, 2);   // Ngày lập
                    String tongTien = getValue(tblDSHOADON, selectedRow, 3);  // Tổng tiền

                    txtMaHoaDon.setText(maHD);
                    cbMaPhieuThuePhong.setSelectedItem(maPTP);
                    txtNgayLap.setText(ngayLap);
                    txtTongTien.setText(tongTien);

                    // Load danh sách chi tiết hóa đơn theo mã HĐ
                    loadDataChiTietHoaDonTheoMa(maHD);
                }
            }
        });

        
        tblDSCHITIETHOADON.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSCHITIETHOADON.getSelectedRow();
                if (selectedRow != -1) {
                    String selectedMaLoaiPhong = getValue(tblDSCHITIETHOADON, selectedRow, 0);

                    // Tìm và chọn tất cả dòng trong tblDSPHONG có cùng MaHoaDon
                    tblDSHOADON.clearSelection();
                    for (int i = 0; i < tblDSHOADON.getRowCount(); i++) {
                        String maLP = getValue(tblDSHOADON, i, 1); 
                        if (selectedMaLoaiPhong.equals(maLP)) {
                            tblDSHOADON.addRowSelectionInterval(i, i); // Chọn dòng đó
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
    
    private void loadDataChiTietHoaDonTheoMa(String maHD) {
        try {
            modelChiTiet.setRowCount(0); // Xóa dữ liệu cũ
            List<ChiTietHoaDonDTO> ds = chiTietHoaDonBLL.getByMaHD(maHD);
            for (ChiTietHoaDonDTO ct : ds) {
                modelChiTiet.addRow(new Object[]{
                    ct.getMaCTHD(), ct.getMaHD(), ct.getMaPhong(), ct.getMaDV(),
                    ct.getLoaiChiTiet(), ct.getSoLuong(), ct.getDonGia(), ct.getThanhTien()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải chi tiết hóa đơn: " + ex.getMessage());
        }
    }


    private void loadDataHoaDon() {
        try {
            model.setRowCount(0);
            model.setColumnIdentifiers(new String[]{
                "Mã hóa đơn", "Mã phiếu thuê phòng", "Ngày lập", "Tổng tiền"
            });
            danhSachHoaDonGoc = (ArrayList<HoaDonDTO>) hoaDonBLL.layDanhSachHoaDon();
            for (HoaDonDTO hd : danhSachHoaDonGoc) {
                model.addRow(new Object[]{
                    hd.getMaHD(), hd.getMaPTP(), hd.getNgayLap(), hd.getTongTien()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu hóa đơn: " + e.getMessage());
        }
    }
    
    private void loadDataChiTietHoaDon() {
        try {
            modelChiTiet.setRowCount(0); // Xóa dữ liệu cũ
            modelChiTiet.setColumnIdentifiers(new String[]{
                "Mã CTHD", "Mã HĐ", "Mã Phòng", "Mã DV", "Loại", "Số lượng", "Đơn giá", "Thành tiền"
            });

            List<ChiTietHoaDonDTO> danhSachCT = chiTietHoaDonBLL.layDanhSachChiTietHoaDon();
            for (ChiTietHoaDonDTO ct : danhSachCT) {
                modelChiTiet.addRow(new Object[]{
                    ct.getMaCTHD(), ct.getMaHD(), ct.getMaPhong(), ct.getMaDV(),
                    ct.getLoaiChiTiet(), ct.getSoLuong(), ct.getDonGia(), ct.getThanhTien()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu chi tiết hóa đơn: " + e.getMessage());
        }
    }
    
    private void loadComboBoxPhieuThuePhong() {
        try {
            cbMaPhieuThuePhong.removeAllItems();
            cbMaPhieuThuePhong.addItem("_");
            PhieuThuePhongBLL phieuThuePhongBLL = new PhieuThuePhongBLL();
            ArrayList<PhieuThuePhongDTO> danhSachPhieuThue = phieuThuePhongBLL.layDanhSachPhieuThue();
            for (PhieuThuePhongDTO ptp : danhSachPhieuThue) {
                cbMaPhieuThuePhong.addItem(ptp.getMaThuePhong() + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi load danh sách mã phiếu thuê!");
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
        jTextField2 = new javax.swing.JTextField();
        LBPhongTrong1 = new javax.swing.JLabel();
        ButtonTim = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSCHITIETHOADON = new javax.swing.JTable();
        ButtonXoaHD = new javax.swing.JButton();
        jButtonResert = new javax.swing.JButton();
        lbMaHD = new javax.swing.JLabel();
        ButtonLapHD = new javax.swing.JButton();
        ButtonInHD = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSHOADON = new javax.swing.JTable();
        lbMaDSHD = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        cbTimKiem = new javax.swing.JComboBox<>();
        lbMaHD1 = new javax.swing.JLabel();
        lbMaHD2 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        lbMaHD3 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        cbMaPhieuThuePhong = new javax.swing.JComboBox<>();
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
        jLabel1.setText("HÓA ĐƠN");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(52, 152, 219));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        LBPhongTrong1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        LBPhongTrong1.setText("Chi tiết hóa đơn:");

        ButtonTim.setBackground(new java.awt.Color(52, 152, 219));
        ButtonTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTim.setForeground(new java.awt.Color(255, 255, 255));
        ButtonTim.setText("Tìm");
        ButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTimActionPerformed(evt);
            }
        });

        tblDSCHITIETHOADON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã chi tiết HD", "Mã hóa đơn", "Mã phòng", "Mã dịch vụ", "Loại chi tiết", "Số lượng", "Đơn giá ", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDSCHITIETHOADON);

        ButtonXoaHD.setBackground(new java.awt.Color(52, 152, 219));
        ButtonXoaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonXoaHD.setForeground(new java.awt.Color(255, 255, 255));
        ButtonXoaHD.setText("Xóa");
        ButtonXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXoaHDActionPerformed(evt);
            }
        });

        jButtonResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        jButtonResert.setBorderPainted(false);
        jButtonResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });

        lbMaHD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaHD.setText("Phiếu Thuê Phòng :");

        ButtonLapHD.setBackground(new java.awt.Color(52, 152, 219));
        ButtonLapHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonLapHD.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLapHD.setText("Lập hóa đơn");
        ButtonLapHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLapHDActionPerformed(evt);
            }
        });

        ButtonInHD.setBackground(new java.awt.Color(52, 152, 219));
        ButtonInHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonInHD.setForeground(new java.awt.Color(255, 255, 255));
        ButtonInHD.setText("In hóa đơn");
        ButtonInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInHDActionPerformed(evt);
            }
        });

        tblDSHOADON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã phiếu thuê phòng", "Ngày lập", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDSHOADON);

        lbMaDSHD.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbMaDSHD.setText("Danh sách hóa đơn:");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        cbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_", "Mã hóa đơn", "Mã phiếu thuê phòng", "Ngày lập" }));

        lbMaHD1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaHD1.setText("Mã Hóa đơn :");

        lbMaHD2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaHD2.setText("Ngày Lập :");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });

        txtNgayLap.setEditable(false);
        txtNgayLap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayLapActionPerformed(evt);
            }
        });

        lbMaHD3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaHD3.setText("Tổng Tiền :");

        txtTongTien.setEditable(false);
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbMaHD)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbMaHD1)
                                    .addGap(41, 41, 41)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbMaHD2)
                                .addGap(59, 59, 59)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbMaPhieuThuePhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(lbMaHD3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(ButtonLapHD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 86, Short.MAX_VALUE)
                        .addComponent(jButtonResert)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(LBPhongTrong1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField1)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbMaDSHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonInHD, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(435, 435, 435)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMaPhieuThuePhong, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonLapHD)
                                .addComponent(ButtonXoaHD)
                                .addComponent(lbMaHD3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaHD2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonTim)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonResert)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonInHD, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBPhongTrong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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

        CheckOut2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckOut2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/check-out.png"))); // NOI18N
        CheckOut2.setText("Check Out");
        CheckOut2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        HoaDonDatPhong2.setBackground(new java.awt.Color(238, 255, 255));
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

        DatDichVu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reception.png"))); // NOI18N
        DatDichVu4.setText("Danh Sách Đặt Dịch Vụ");
        DatDichVu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatDichVu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDichVu4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DatPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckIn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonDatPhong2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckOut2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSKhachHang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSDatPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1295, Short.MAX_VALUE)
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        dispose();
        new QuanLiPhong().setVisible(true); 
    }//GEN-LAST:event_QuanLiActionPerformed

    private void ButtonInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInHDActionPerformed
         try {
        int selectedRow = tblDSHOADON.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để in!");
            return;
        }

        String maHD = tblDSHOADON.getValueAt(selectedRow, 0).toString();

        // --- Tìm hóa đơn theo mã ---
        HoaDonDTO hoaDon = null;
        List<HoaDonDTO> danhSachHoaDon = hoaDonBLL.layDanhSachHoaDon();
        for (HoaDonDTO hd : danhSachHoaDon) {
            if (maHD.equals(hd.getMaHD())) {
                hoaDon = hd;
                break;
            }
        }
        if (hoaDon == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn!");
            return;
        }

        // --- Lấy phiếu thuê ---
        int maPTP = hoaDon.getMaPTP();
        PhieuThuePhongDTO phieuThue = null;
        ArrayList<PhieuThuePhongDTO> danhSachPhieuThue = phieuThuePhongBLL.layDanhSachPhieuThue();
        for (PhieuThuePhongDTO ptp : danhSachPhieuThue) {
            if (maPTP == ptp.getMaThuePhong()) {
                phieuThue = ptp;
                break;
            }
        }
        if (phieuThue == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu thuê!");
            return;
        }

        // --- Lấy nhân viên ---
        int maNV = phieuThue.getMaNhanVien();
        NhanVienDTO nhanVien = null;
        ArrayList<NhanVienDTO> danhSachNhanVien = nhanVienBLL.layDanhSachNhanVien();
        for (NhanVienDTO nv : danhSachNhanVien) {
            if (maNV == nv.getMaNhanVien()) {
                nhanVien = nv;
                break;
            }
        }
        if (nhanVien == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên!");
            return;
        }

        // --- Lấy khách hàng ---
        int maKH = phieuThue.getMaKhachHang();
        KhachHangDTO khachHang = null;
        ArrayList<KhachHangDTO> danhSachKhachHang = khachHangBLL.layDanhSachKhachHang();
        for(KhachHangDTO kh : danhSachKhachHang) {
            if(maKH == kh.getMaKhachHang()) {
                khachHang = kh;
                break;
            }
        }
        if(khachHang == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng!");
            return;
        }

        // --- Lấy chi tiết hóa đơn ---
        List<ChiTietHoaDonDTO> dsChiTiet = chiTietHoaDonBLL.getByMaHD(maHD);

        // --- Phân loại chi tiết ---
        StringBuilder tienPhong = new StringBuilder();
        StringBuilder tienDichVu = new StringBuilder();
        double tongTienPhong = 0, tongTienDV = 0;

        for (ChiTietHoaDonDTO ct : dsChiTiet) {
            double thanhTien = ct.getThanhTien();
            if ("Tiền Phòng".equals(ct.getLoaiChiTiet())) {
                tienPhong.append("--Phòng ").append(ct.getMaPhong())
                    .append(" | 1 ngày | ")
                    .append(ct.getDonGia()).append("k/ngày | ")
                    .append(thanhTien).append("k\n");
                tongTienPhong += thanhTien;
            } else if ("Tiền Dịch Vụ".equals(ct.getLoaiChiTiet())) {
                ArrayList<QuanLiDichVuDTO> danhSachDichVu = quanLiDichVuBLL.layDanhSachDichVu();
                QuanLiDichVuDTO tenDV = null;
                for(QuanLiDichVuDTO dv : danhSachDichVu) {
                    if(ct.getMaDV() == dv.getMaDichVu()) {
                        tenDV = dv;
                        break;
                    }
                }
                if(tenDV == null) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy dich vụ !");
            return;
                }
                tienDichVu.append("--Phòng ").append(ct.getMaPhong())
                    .append(" | ").append(tenDV.getTenDichVu())
                    .append(" | ").append(ct.getSoLuong()).append(" x ")
                    .append(ct.getDonGia()).append("k = ")
                    .append(thanhTien).append("k\n");
                tongTienDV += thanhTien;
            }
        }

        double tongCong = tongTienPhong + tongTienDV;

        // --- Tạo nội dung hóa đơn ---
        String hoaDonText =
                """
                ------------------------------------------------
                                KH\u00c1CH S\u1ea0N LHQT
                              H\u00d3A \u0110\u01a0N THANH TO\u00c1N
                ------------------------------------------------
                  M\u00e3 H\u00f3a \u0110\u01a1n: """ + maHD + "\n" +
                "  Ngày Lập: " + hoaDon.getNgayLap() + "\n" +
                "  Khách hàng: " + khachHang.getHo() + " " + khachHang.getTen() + "\n" +
                "  Nhân viên lập: " + nhanVien.getHo() + " " + nhanVien.getTen() + "\n\n" +
                "  *** Tiền thuê phòng ***\n" +
                tienPhong.toString() + "\n" +
                "  *** Dịch vụ đã sử dụng ***\n" +
                tienDichVu.toString() + "\n" +
                "-----------------------------------------------\n" +
                "  Tổng tiền phòng: " + tongTienPhong + "k\n" +
                "  Tổng tiền dịch vụ: " + tongTienDV + "k\n" +
                "  Tổng cộng thanh toán: " + tongCong + "k\n" +
                "-----------------------------------------------\n" +
                "             Xin cảm ơn Quý khách!";

        // --- Hiển thị ---
        JTextArea textArea = new JTextArea(hoaDonText);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(this, scrollPane, "Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi in hóa đơn: " + ex.getMessage());
    }
    }//GEN-LAST:event_ButtonInHDActionPerformed

    private void ButtonLapHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLapHDActionPerformed
        try {
        String maPTP = cbMaPhieuThuePhong.getSelectedItem().toString();
        Date ngayLap = new java.sql.Date(System.currentTimeMillis());

        String maHD; // dùng đúng 1 biến cho mã hóa đơn

        boolean daCoHoaDon = hoaDonBLL.kiemTraHoaDonTonTai(Integer.parseInt(maPTP));
        if (daCoHoaDon) {
            maHD = hoaDonBLL.getMaHoaDonByMaPTP(Integer.parseInt(maPTP));
        } else {
            maHD = hoaDonBLL.generateNextMaHD();
            hoaDonBLL.insertHoaDon(maHD, maPTP, ngayLap, 0);
        }

        // Lấy danh sách chi tiết đã có trong hóa đơn cũ
        List<ChiTietHoaDonDTO> daCoChiTiet = chiTietHoaDonBLL.getByMaHD(maHD);
        Set<String> keyChiTiet = new HashSet<>();
        for (ChiTietHoaDonDTO ct : daCoChiTiet) {
            String key = ct.getMaPhong() + "_" + (ct.getMaDV() != null ? ct.getMaDV() : "null") + "_" + ct.getLoaiChiTiet();
            keyChiTiet.add(key);
        }

        double tongTien = 0;
        
        // Nếu đã có hóa đơn, lấy tổng tiền cũ để cộng dồn
        List<ChiTietHoaDonDTO> danhSachCTMoi = chiTietHoaDonBLL.getByMaHD(maHD);
            for (ChiTietHoaDonDTO ct : danhSachCTMoi) {
                tongTien += ct.getThanhTien();
            }

        // 1. Lấy danh sách chi tiết phòng từ MaPTP
        danhSachChiTietPhieuThue = chiTietPhieuThuePhongBLL.layDanhSachChiTiet(); 
        List<ChiTietPhieuThuePhongDTO> danhSachTheoPhieuThue = new ArrayList<>();
        for (ChiTietPhieuThuePhongDTO ct : danhSachChiTietPhieuThue) {
            if (String.valueOf(ct.getMaThuePhong()).equals(maPTP)) {
                danhSachTheoPhieuThue.add(ct);
            }
        }
        for (ChiTietPhieuThuePhongDTO phong : danhSachTheoPhieuThue) {
            double thanhTien = phong.getThanhTien();

            String keyPhong = phong.getMaPhong() + "_null_Tiền Phòng";
            if (!keyChiTiet.contains(keyPhong)) {
                chiTietHoaDonBLL.insertChiTietHoaDon(new ChiTietHoaDonDTO(
                    0, maHD, phong.getMaPhong(), null, "Tiền Phòng", 1, phong.getGiaPhong(), thanhTien
                ));
                tongTien += thanhTien;
            }

            List<DatDichVuDTO> dsDV = datDichVuBLL.getByIDChiTietPhieuThue(phong.getId());
            for (DatDichVuDTO dv : dsDV) {
                String keyDV = phong.getMaPhong() + "_" + dv.getMaDichVu() + "_Tiền Dịch Vụ";
                if (!keyChiTiet.contains(keyDV)) {
                    chiTietHoaDonBLL.insertChiTietHoaDon(new ChiTietHoaDonDTO(
                        0, maHD, phong.getMaPhong(), dv.getMaDichVu(), "Tiền Dịch Vụ",
                        dv.getSoLuong(), dv.getDonGia(), dv.getThanhTien()
                    ));
                    tongTien += dv.getThanhTien();
                }
            }
        }


        // Cập nhật tổng tiền vào HoaDon
        hoaDonBLL.updateTongTien(maHD, tongTien);

        // Hiển thị lên form
        txtMaHoaDon.setText(maHD);
        txtNgayLap.setText(ngayLap.toString());
        txtTongTien.setText(String.valueOf(tongTien));

        JOptionPane.showMessageDialog(this, "Lập hóa đơn thành công!");
        
        loadDataHoaDon();
        loadDataChiTietHoaDon();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi lập hóa đơn: " + ex.getMessage());
    }
    }//GEN-LAST:event_ButtonLapHDActionPerformed

    private void jButtonResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResertActionPerformed
        txtTimKiem.setText("");
        cbTimKiem.setSelectedIndex(0);
        
        loadDataHoaDon();
        loadDataChiTietHoaDon();
    }//GEN-LAST:event_jButtonResertActionPerformed

    private void ButtonXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXoaHDActionPerformed
int selectedRow = tblDSHOADON.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để xóa!");
        return;
    }

    String maHD = model.getValueAt(selectedRow, 0).toString(); // Giả sử mã hóa đơn nằm ở cột 0

    int confirm = JOptionPane.showConfirmDialog(this, 
        "Bạn có chắc chắn muốn xóa hóa đơn " + maHD + " không?",
        "Xác nhận xóa",
        JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            boolean success = hoaDonBLL.xoaHoaDon(maHD);
            if (success) {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công!");

                // Cập nhật lại bảng Hóa đơn
                model.removeRow(selectedRow);

                // Xóa chi tiết hóa đơn nếu đang hiển thị chi tiết của hóa đơn này
                modelChiTiet.setRowCount(0); // xóa sạch bảng chi tiết
            } else {
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn thất bại!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa hóa đơn: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_ButtonXoaHDActionPerformed

    private void ButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimActionPerformed
        String loaiTim = cbTimKiem.getSelectedItem().toString(); // Lấy tiêu chí
        String tuKhoa = txtTimKiem.getText().trim(); // Lấy từ khóa tìm

        try {
            HoaDonBLL bll = new HoaDonBLL();
            ArrayList<HoaDonDTO> ketQua = bll.timHoaDon(loaiTim, tuKhoa);

            model.setRowCount(0); // Xóa dữ liệu cũ

            for (HoaDonDTO hd : ketQua) {
                model.addRow(new Object[]{
                    hd.getMaHD(),
                    hd.getMaPTP(),
                    hd.getNgayLap(),
                    hd.getTongTien()
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + ex.getMessage());
        }
    }//GEN-LAST:event_ButtonTimActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void DatPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatPhong2ActionPerformed
        dispose();
        new PhieuThuePhong().setVisible(true);
    }//GEN-LAST:event_DatPhong2ActionPerformed

    private void DatDichVu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVu3ActionPerformed
        dispose();
        new DatDichVu().setVisible(true);
    }//GEN-LAST:event_DatDichVu3ActionPerformed

    private void DatDichVu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DatDichVu4ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void txtNgayLapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayLapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayLapActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void HoaDonDatPhong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDatPhong2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoaDonDatPhong2ActionPerformed

    private void DSKhachHang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSKhachHang2ActionPerformed
        dispose();
        new DanhSachKhachHang().setVisible(true);
    }//GEN-LAST:event_DSKhachHang2ActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            DanhSachHoaDon danhsachHoaDon = null;
            try {
                danhsachHoaDon = new DanhSachHoaDon(); // Tạo đối tượng QuanLiPhong
            } catch (SQLException ex) {
                Logger.getLogger(DanhSachHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            danhsachHoaDon.setVisible(true); // Hiển thị giao diện
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonInHD;
    private javax.swing.JButton ButtonLapHD;
    private javax.swing.JButton ButtonTim;
    private javax.swing.JButton ButtonXoaHD;
    private javax.swing.JButton CheckIn2;
    private javax.swing.JButton CheckOut2;
    private javax.swing.JButton DSDatPhong2;
    private javax.swing.JButton DSKhachHang2;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton DatDichVu3;
    private javax.swing.JButton DatDichVu4;
    private javax.swing.JButton DatPhong2;
    private javax.swing.JButton HoaDonDatPhong2;
    private javax.swing.JButton KhachSan;
    private javax.swing.JLabel LBPhongTrong1;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTable TablePhongTrong;
    private javax.swing.JLabel Tittle;
    private javax.swing.ButtonGroup bGNam_Nu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMaPhieuThuePhong;
    private javax.swing.JComboBox<String> cbTimKiem;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbMaDSHD;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbMaHD1;
    private javax.swing.JLabel lbMaHD2;
    private javax.swing.JLabel lbMaHD3;
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
    private javax.swing.JTable tblDSCHITIETHOADON;
    private javax.swing.JTable tblDSHOADON;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}

