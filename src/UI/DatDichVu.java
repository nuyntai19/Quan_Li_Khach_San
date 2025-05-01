package UI;

import DTO.*;
import BLL.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatDichVu extends javax.swing.JFrame {
    
    private final DefaultTableModel modelDichVu,modelChiTietPhieuThue;
    private ArrayList<QuanLiDichVuDTO> danhSachDichVuGoc = new ArrayList<>();
    private ArrayList<ChiTietPhieuThuePhongDTO> danhSachCTPhieuThuePhong = new ArrayList<>();


    private final QuanLiDichVuBLL dichVuBLL;
    
    private final DatDichVuBLL datDichVuBLL;
    private final ChiTietPhieuThuePhongBLL chiTietPhieuThuePhongBLL; 
    private String ngayTraPhongSelected; // lưu ngày trả phòng khi click bảng

    
    public DatDichVu() {
        initComponents();
        
        dichVuBLL = new QuanLiDichVuBLL();
        datDichVuBLL = new DatDichVuBLL();
        chiTietPhieuThuePhongBLL = new ChiTietPhieuThuePhongBLL(); 

        modelDichVu = (DefaultTableModel) tblDSDICHVU.getModel(); 
        modelChiTietPhieuThue = (DefaultTableModel) tblDSCHITIETPHIEUTHUE.getModel();

        loadDataDSDICHVU();
        loadDataDSCTPhieuThuePhong();
        
        tblDSDICHVU.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSDICHVU.getSelectedRow();
                if (selectedRow != -1) {
                    String maDichVu = getValue(tblDSDICHVU, selectedRow, 0);
                    String donGia = getValue(tblDSDICHVU, selectedRow, 3);

                    // Gán dữ liệu vào các ô nhập liệu tương ứng
                    txtMaDichVu.setText(maDichVu);
                    txtDonGia.setText(donGia);
                }
            }

            // Hàm tiện ích để lấy giá trị có kiểm null
            private String getValue(JTable table, int row, int col) {
                Object value = table.getValueAt(row, col);
                return value != null ? value.toString() : "";
            }
        });
        
        tblDSCHITIETPHIEUTHUE.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSCHITIETPHIEUTHUE.getSelectedRow();
                if (selectedRow != -1) {
                    String id = getValue(tblDSCHITIETPHIEUTHUE, selectedRow, 0);
                    String ngayTraPhong = getValue(tblDSCHITIETPHIEUTHUE, selectedRow, 4);

                    txtID.setText(id);

                    ngayTraPhongSelected = ngayTraPhong; // lưu lại ngày trả phòng được chọn
                }
            }

            private String getValue(JTable table, int row, int col) {
                Object value = table.getValueAt(row, col);
                return value != null ? value.toString() : "";
            }
        });

    }
    
    private void loadDataDSDICHVU() {
        try {
            modelDichVu.setRowCount(0); // Xóa dữ liệu cũ

            // Đảm bảo rằng bảng đã có các cột cần thiết
            modelDichVu.setColumnIdentifiers(new String[] {
                "Mã Dịch Vụ", "Tên Dịch Vụ", "Mô Tả", "Đơn Giá", "Số lượng"
            });

            // Lấy lại dữ liệu từ cơ sở dữ liệu
            danhSachDichVuGoc = dichVuBLL.layDanhSachDichVu();
            for (QuanLiDichVuDTO dv : danhSachDichVuGoc) {
                modelDichVu.addRow(new Object[] {
                    dv.getMaDichVu(), dv.getTenDichVu(), dv.getMoTa(), dv.getDonGia(), dv.getSoLuong()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
        }
    }
    
    private void loadDataDSCTPhieuThuePhong() {
        try {
            modelChiTietPhieuThue.setRowCount(0); // Xóa dữ liệu cũ

            // Đảm bảo rằng bảng đã có các cột cần thiết
            modelChiTietPhieuThue.setColumnIdentifiers(new String[] {
                "ID", "Mã Đặt Phòng", "Mã Phòng", "Ngày Đặt Phòng", "Ngày Trả Phòng", "Giá Phòng", "Thành Tiền"
            });

            // Lấy lại dữ liệu từ cơ sở dữ liệu
            danhSachCTPhieuThuePhong = chiTietPhieuThuePhongBLL.layDanhSachChiTiet();
            for (ChiTietPhieuThuePhongDTO ctptp : danhSachCTPhieuThuePhong) {
                modelChiTietPhieuThue.addRow(new Object[] {
                    ctptp.getId(), ctptp.getMaThuePhong(), ctptp.getMaPhong(), ctptp.getNgayDatPhong(), ctptp.getNgayTraPhong(), ctptp.getGiaPhong(), ctptp.getThanhTien()
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
        DSPhong = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Tittle = new javax.swing.JLabel();
        self = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        DatPhong = new javax.swing.JButton();
        CheckIn = new javax.swing.JButton();
        CheckOut = new javax.swing.JButton();
        HoaDonDatPhong = new javax.swing.JButton();
        DSKhachHang = new javax.swing.JButton();
        DatDichVu = new javax.swing.JButton();
        DSDatPhong = new javax.swing.JButton();
        DatDichVu1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbMaDP = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lbMaDV = new javax.swing.JLabel();
        txtMaDichVu = new javax.swing.JTextField();
        lbSL = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lbDonGia = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        lbThanhTien = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        lbTIMDICHVU = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDSDICHVU = new javax.swing.JTable();
        lbPHIEUDATPHONG = new javax.swing.JLabel();
        txtTimMaDichVu = new javax.swing.JTextField();
        txtTimTenDV = new javax.swing.JTextField();
        lbTimMaDV = new javax.swing.JLabel();
        lbTimMaDV1 = new javax.swing.JLabel();
        btnTimDichVu = new javax.swing.JButton();
        btnTimDatPhong = new javax.swing.JButton();
        txtTimChiTietPhieuThue = new javax.swing.JTextField();
        btnDatDichVu = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSCHITIETPHIEUTHUE = new javax.swing.JTable();
        cbTimChiTietPhieuThue = new javax.swing.JComboBox<>();
        btnTinhTien = new javax.swing.JButton();
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

        DSPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/room.png"))); // NOI18N
        DSPhong.setText("Danh Sách Phòng");
        DSPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DangNhap");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1430, 776));

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
                .addGap(18, 18, 18))
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(244, 387));

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
        HoaDonDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonDatPhongActionPerformed(evt);
            }
        });

        DSKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/registration-form.png"))); // NOI18N
        DSKhachHang.setText("Danh Sách Khách Hàng");
        DSKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DSKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSKhachHangActionPerformed(evt);
            }
        });

        DatDichVu.setBackground(new java.awt.Color(238, 255, 255));
        DatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/desk-bell.png"))); // NOI18N
        DatDichVu.setText("Đặt Dịch Vụ");
        DatDichVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDichVuActionPerformed(evt);
            }
        });

        DSDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/list.png"))); // NOI18N
        DSDatPhong.setText("Danh Sách Đặt Phòng");
        DSDatPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DSDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSDatPhongActionPerformed(evt);
            }
        });

        DatDichVu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reception.png"))); // NOI18N
        DatDichVu1.setText("Danh Sách Đặt Dịch Vụ");
        DatDichVu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatDichVu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDichVu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(DSDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(HoaDonDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DatDichVu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DatPhong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DSKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DatDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))))
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
                .addComponent(DatDichVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(204, 204, 204))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐẶT DỊCH VỤ");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        lbMaDP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaDP.setText("ID :");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        lbMaDV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaDV.setText("Mã dịch vụ:");

        txtMaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDichVuActionPerformed(evt);
            }
        });

        lbSL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSL.setText("Số lượng cần đặt:");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        lbDonGia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDonGia.setText("Đơn giá:");

        txtDonGia.setEditable(false);
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        lbThanhTien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbThanhTien.setText("Thành tiền:");

        txtThanhTien.setEditable(false);
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        lbTIMDICHVU.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbTIMDICHVU.setText("TÌM DỊCH VỤ");

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

        lbPHIEUDATPHONG.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbPHIEUDATPHONG.setText("TÌM PHÒNG ĐÃ ĐẶT");

        txtTimMaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimMaDichVuActionPerformed(evt);
            }
        });

        txtTimTenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimTenDVActionPerformed(evt);
            }
        });

        lbTimMaDV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTimMaDV.setText("Mã dịch vụ:");

        lbTimMaDV1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTimMaDV1.setText("Tên dịch vụ:");

        btnTimDichVu.setBackground(new java.awt.Color(52, 152, 219));
        btnTimDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnTimDichVu.setText("Tìm");
        btnTimDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimDichVuActionPerformed(evt);
            }
        });

        btnTimDatPhong.setBackground(new java.awt.Color(52, 152, 219));
        btnTimDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimDatPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnTimDatPhong.setText("Tìm");
        btnTimDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimDatPhongActionPerformed(evt);
            }
        });

        txtTimChiTietPhieuThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimChiTietPhieuThueActionPerformed(evt);
            }
        });

        btnDatDichVu.setBackground(new java.awt.Color(52, 152, 219));
        btnDatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDatDichVu.setForeground(new java.awt.Color(255, 255, 255));
        btnDatDichVu.setText("Đặt dịch vụ");
        btnDatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatDichVuActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        btnReset.setBorderPainted(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblDSCHITIETPHIEUTHUE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã đặt phòng", "Mã phòng", "Ngày đặt phòng", "Ngày trả phòng", "Giá phòng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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
        jScrollPane3.setViewportView(tblDSCHITIETPHIEUTHUE);

        cbTimChiTietPhieuThue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã đặt phòng", "Mã phòng", "Ngày Đặt Phòng", "Ngày Trả Phòng", " " }));

        btnTinhTien.setBackground(new java.awt.Color(52, 152, 219));
        btnTinhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTinhTien.setForeground(new java.awt.Color(255, 255, 255));
        btnTinhTien.setText("Tính");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(501, 501, 501))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbPHIEUDATPHONG)
                                .addGap(257, 257, 257)
                                .addComponent(txtTimChiTietPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbTimChiTietPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(btnDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbSL)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(lbTIMDICHVU, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(208, 208, 208))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(lbTimMaDV)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTimMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addComponent(lbTimMaDV1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTimTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(41, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTIMDICHVU, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTimMaDV)
                        .addComponent(lbTimMaDV1)
                        .addComponent(txtTimTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimDichVu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSL, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTinhTien))
                        .addGap(14, 14, 14)
                        .addComponent(btnDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPHIEUDATPHONG, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimDatPhong)
                            .addComponent(txtTimChiTietPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTimChiTietPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE))
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
       dispose();
        new PhieuThuePhong().setVisible(true);
    }//GEN-LAST:event_DatPhongActionPerformed

    private void selfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        new PhieuThuePhong().setVisible(true);         
    }//GEN-LAST:event_KhachSanActionPerformed

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

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtMaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDichVuActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void txtTimMaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimMaDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimMaDichVuActionPerformed

    private void txtTimTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimTenDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimTenDVActionPerformed

    private void btnTimDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimDichVuActionPerformed
        try {
            String maDichVu = txtTimMaDichVu.getText().trim(); // Lấy mã dịch vụ
            String tenDichVu = txtTimTenDV.getText().trim(); // Lấy tên dịch vụ

            // Gọi hàm tìm kiếm từ BLL
            ArrayList<QuanLiDichVuDTO> ketQua = dichVuBLL.timDichVu(maDichVu, tenDichVu);

            // Hiển thị kết quả trong bảng hoặc danh sách
            // Giả sử bạn có một JTable để hiển thị danh sách
            DefaultTableModel model = (DefaultTableModel) tblDSDICHVU.getModel();
            model.setRowCount(0);  // Xóa dữ liệu cũ trong bảng

            for (QuanLiDichVuDTO dv : ketQua) {
                Object[] row = new Object[]{
                    dv.getMaDichVu(),
                    dv.getTenDichVu(),
                    dv.getMoTa(),
                    dv.getDonGia(),
                    dv.getSoLuong()
                };
                model.addRow(row);
            }

            if (ketQua.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy dịch vụ phù hợp!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnTimDichVuActionPerformed

    private void btnTimDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimDatPhongActionPerformed
        String loaiTim = cbTimChiTietPhieuThue.getSelectedItem().toString(); // Lấy tiêu chí
        String tuKhoa = txtTimChiTietPhieuThue.getText().trim(); // Lấy từ khóa tìm

        try {
            ChiTietPhieuThuePhongBLL bll = new ChiTietPhieuThuePhongBLL();
            ArrayList<ChiTietPhieuThuePhongDTO> ketQua = bll.timChiTiet(loaiTim, tuKhoa);

            // Sau khi có danh sách kết quả, bạn cần đổ lại lên table
            // Giả sử bạn có 1 JTable tên là tableChiTietThue

            DefaultTableModel model = (DefaultTableModel) tblDSCHITIETPHIEUTHUE.getModel();
            model.setRowCount(0); // Xóa bảng cũ

            for (ChiTietPhieuThuePhongDTO ct : ketQua) {
                model.addRow(new Object[]{
                    ct.getId(),
                    ct.getMaThuePhong(),
                    ct.getMaPhong(),
                    ct.getNgayDatPhong(),
                    ct.getNgayTraPhong(),
                    ct.getGiaPhong(),
                    ct.getThanhTien()
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnTimDatPhongActionPerformed
 
    private void txtTimChiTietPhieuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimChiTietPhieuThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimChiTietPhieuThueActionPerformed

    private void DatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVuActionPerformed
        dispose();
        new DatDichVu().setVisible(true);
    }//GEN-LAST:event_DatDichVuActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtTimMaDichVu.setText("");
        txtTimTenDV.setText("");
        txtTimChiTietPhieuThue.setText("");
        
        loadDataDSDICHVU();
        loadDataDSCTPhieuThuePhong();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        try {
            // Lấy số lượng và đơn giá từ TextField
            int soLuong = Integer.parseInt(txtSoLuong.getText().trim());
            double donGia = Double.parseDouble(txtDonGia.getText().trim());

            // Tính thành tiền
            double thanhTien = soLuong * donGia;

            // Hiển thị kết quả (ví dụ gán vào 1 TextField txtThanhTien)
            txtThanhTien.setText(String.format("%.2f", thanhTien));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ cho Số lượng và Giá tiền.");
        }
    }//GEN-LAST:event_btnTinhTienActionPerformed

    private void btnDatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatDichVuActionPerformed
        try {
            if (txtID.getText().isEmpty() || txtMaDichVu.getText().isEmpty() || 
                txtSoLuong.getText().isEmpty() || txtDonGia.getText().isEmpty() || 
                txtThanhTien.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                return;
            }

            if (ngayTraPhongSelected == null || ngayTraPhongSelected.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng trước khi đặt dịch vụ.");
                return;
            }

            // Kiểm tra ngày trả phòng
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // đúng định dạng ngày của bạn
            Date ngayTraPhong = sdf.parse(ngayTraPhongSelected);
            Date ngayHienTai = new Date();

            if (ngayTraPhong.before(ngayHienTai)) {
                JOptionPane.showMessageDialog(this, "Đã quá hạn trả phòng, không thể đặt dịch vụ!");
                return;
            }

            // Lấy số lượng còn lại của dịch vụ
            int maDichVu = Integer.parseInt(txtMaDichVu.getText());
            int soLuongYeuCau = Integer.parseInt(txtSoLuong.getText());
            int soLuongDangCo = dichVuBLL.laySoLuongDangCo(maDichVu); // Lấy số lượng còn lại trong cơ sở dữ liệu

            if (soLuongYeuCau > soLuongDangCo) {
                JOptionPane.showMessageDialog(this, "Số lượng dịch vụ không đủ!");
                return;
            }

            // Tạo đối tượng DTO và thêm dịch vụ
            DatDichVuDTO ddv = new DatDichVuDTO(
                Integer.parseInt(txtID.getText()),
                Integer.parseInt(txtMaDichVu.getText()),
                Integer.parseInt(txtSoLuong.getText()),
                Double.parseDouble(txtDonGia.getText()),
                Double.parseDouble(txtThanhTien.getText())
            );

            datDichVuBLL.themDatDichVu(ddv);

            // Giảm số lượng dịch vụ trong cơ sở dữ liệu
            dichVuBLL.giamSoLuong(maDichVu, soLuongYeuCau);
            loadDataDSDICHVU();

            JOptionPane.showMessageDialog(this, "Đặt dịch vụ thành công và đã cập nhật số lượng dịch vụ.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnDatDichVuActionPerformed

    private void DatDichVu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DatDichVu1ActionPerformed

    private void HoaDonDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDatPhongActionPerformed
        dispose();
        try {
            new DanhSachHoaDon().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DatDichVu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HoaDonDatPhongActionPerformed

    private void DSKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSKhachHangActionPerformed
        dispose();
            new DanhSachKhachHang().setVisible(true);
        
    }//GEN-LAST:event_DSKhachHangActionPerformed

    private void DSDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSDatPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DSDatPhongActionPerformed

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
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatDichVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton CheckOut;
    private javax.swing.JButton DSDatPhong;
    private javax.swing.JButton DSKhachHang;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton DatDichVu;
    private javax.swing.JButton DatDichVu1;
    private javax.swing.JButton DatPhong;
    private javax.swing.JButton HoaDonDatPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JButton QuanLi;
    private javax.swing.JLabel Tittle;
    private javax.swing.JButton btnDatDichVu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimDatPhong;
    private javax.swing.JButton btnTimDichVu;
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JComboBox<String> cbTimChiTietPhieuThue;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbMaDP;
    private javax.swing.JLabel lbMaDV;
    private javax.swing.JLabel lbPHIEUDATPHONG;
    private javax.swing.JLabel lbSL;
    private javax.swing.JLabel lbTIMDICHVU;
    private javax.swing.JLabel lbThanhTien;
    private javax.swing.JLabel lbTimMaDV;
    private javax.swing.JLabel lbTimMaDV1;
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
    private javax.swing.JTable tblDSCHITIETPHIEUTHUE;
    private javax.swing.JTable tblDSDICHVU;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimChiTietPhieuThue;
    private javax.swing.JTextField txtTimMaDichVu;
    private javax.swing.JTextField txtTimTenDV;
    // End of variables declaration//GEN-END:variables
}

