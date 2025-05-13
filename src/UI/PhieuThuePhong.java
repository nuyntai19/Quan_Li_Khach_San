package UI;

import BLL.QuanLiPhongBLL;
import BLL.PhieuThuePhongBLL;
import DTO.ChiTietPhieuThuePhongDTO;
import DTO.QuanLiPhongDTO;
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
import java.util.List;
import DTO.KhachHangDTO;
import BLL.KhachHangBLL;
import DTO.PhieuThuePhongDTO;
import BLL.DanhSachTamCTPhieuThuePhong;
import BLL.ChiTietPhieuThuePhongBLL;
import BLL.ThongTinNhanVienBLL;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.logging.Level;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class PhieuThuePhong extends javax.swing.JFrame {
    
    private ArrayList<QuanLiPhongDTO> danhSachPhongGoc = new ArrayList<>();
    private ArrayList<ChiTietPhieuThuePhongDTO> danhSachChiTiet = new ArrayList<>();
    private final DefaultTableModel model;
    private final PhieuThuePhongBLL phieuThuePhongBLL;
    private final QuanLiPhongBLL phongBLL;
    
    public PhieuThuePhong() {
        initComponents();
        phieuThuePhongBLL = new PhieuThuePhongBLL();
        phongBLL = new QuanLiPhongBLL();
        model = (DefaultTableModel) tblDSPHONGTRONG.getModel(); 
        
        loadDataPhong();
        
        tblDSPHONGTRONG.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSPHONGTRONG.getSelectedRow();
                if (selectedRow != -1) {
                    String maPhong = getValue(tblDSPHONGTRONG, selectedRow, 0);
                    String maLoaiPhong = getValue(tblDSPHONGTRONG, selectedRow, 1);
                    String soGiuong = getValue(tblDSPHONGTRONG, selectedRow, 2);
                    String donGia = getValue(tblDSPHONGTRONG, selectedRow, 3);
                    String trangThai = getValue(tblDSPHONGTRONG, selectedRow, 4);

                    // Gán dữ liệu vào các ô nhập liệu tương ứng
                    TXMaPhong.setText(maPhong);
                    TXMaLoaiPhong.setText(maLoaiPhong);
                    TXSoGiuong.setText(soGiuong);
                    TXGiaThue.setText(donGia);
                }
            }

            // Hàm tiện ích để lấy giá trị có kiểm null
            private String getValue(JTable table, int row, int col) {
                Object value = table.getValueAt(row, col);
                return value != null ? value.toString() : "";
            }
        });
        JTableHeader header = tblDSPHONGTRONG.getTableHeader(); 
        header.setFont(new Font("Arial", Font.BOLD, 12));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        
        
    }
    
    private void loadDataPhong() {
        try {
            model.setRowCount(0); // Xóa dữ liệu cũ

            model.setColumnIdentifiers(new String[] {
                "Mã Phòng", "Mã Loại Phòng", "Số Giường", "Đơn Giá", "Trạng Thái"
            });

            // Lấy lại dữ liệu từ BLL
            danhSachPhongGoc = phongBLL.layDanhSachPhong();

            // chỉ hiển thị phòng có trạng thái là "Trống"
            for (QuanLiPhongDTO phong : danhSachPhongGoc) {
                    model.addRow(new Object[] {
                        phong.getMaPhong(), phong.getMaLoaiPhong(), phong.getSoGiuong(),
                        phong.getDonGia(), phong.getTrangThai()
                    });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
        }
    }

    
    public void nhanThongTinKhachHang(String maKH, String ho, String ten, String gioiTinh, Date ngaySinh, String sdt, String email) {
        TXKhachHang.setText(maKH);
        TXHo.setText(ho);
        TXTen.setText(ten);
        TXSDT.setText(sdt);
        TXEmail.setText(email);
        DCNgaySinh.setDate(ngaySinh);

        if (gioiTinh.equalsIgnoreCase("Nam")) {
            RBNam.setSelected(true);
        } else {
            RBNu.setSelected(true);
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
        jPanel3 = new javax.swing.JPanel();
        DatPhong = new javax.swing.JButton();
        CheckIn = new javax.swing.JButton();
        CheckOut = new javax.swing.JButton();
        HoaDonDatPhong = new javax.swing.JButton();
        DSKhachHang = new javax.swing.JButton();
        DatDichVu = new javax.swing.JButton();
        DSDatPhong = new javax.swing.JButton();
        DatDichVu1 = new javax.swing.JButton();
        DatDichVu2 = new javax.swing.JButton();
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
        lbHo = new javax.swing.JLabel();
        TXHo = new javax.swing.JTextField();
        lbHo1 = new javax.swing.JLabel();
        TXTen = new javax.swing.JTextField();
        lbKH1 = new javax.swing.JLabel();
        TXSDT = new javax.swing.JTextField();
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
        LBMaLoaiPhongTrong = new javax.swing.JLabel();
        lbSoGiuongPhongTrong = new javax.swing.JLabel();
        TXSoGiuongTim = new javax.swing.JTextField();
        ButtonTim = new javax.swing.JButton();
        ButtonDatPhong = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSPHONGTRONG = new javax.swing.JTable();
        lbNgayDP = new javax.swing.JLabel();
        lbNgayTP = new javax.swing.JLabel();
        DCNgayDP = new com.toedter.calendar.JDateChooser();
        DCNgayTP = new com.toedter.calendar.JDateChooser();
        jButtonResert = new javax.swing.JButton();
        lbMoTa1 = new javax.swing.JLabel();
        TXTongTien = new javax.swing.JTextField();
        ButtonChonNhieuPhongDat = new javax.swing.JButton();
        ButtonXemChiTietDat = new javax.swing.JButton();
        lbMaPhong1 = new javax.swing.JLabel();
        TXMaPhongTim = new javax.swing.JTextField();
        lbSoGiuongPhongTrong1 = new javax.swing.JLabel();
        TXDonGiaTim = new javax.swing.JTextField();
        TXMaLoaiPhongTim = new javax.swing.JTextField();
        ButtonChonNhieuPhongDat1 = new javax.swing.JButton();
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));

        DatPhong.setBackground(new java.awt.Color(238, 255, 255));
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
        CheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInActionPerformed(evt);
            }
        });

        CheckOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/check-out.png"))); // NOI18N
        CheckOut.setText("Check Out");
        CheckOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutActionPerformed(evt);
            }
        });

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

        DatDichVu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/checkTinhTrang.png"))); // NOI18N
        DatDichVu2.setText("Kiểm tra tình trạng");
        DatDichVu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DatDichVu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDichVu2ActionPerformed(evt);
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
                    .addComponent(DSKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(DatDichVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        TXMaPhong.setEditable(false);
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

        lbHo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo.setText("Họ:");

        TXHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXHoActionPerformed(evt);
            }
        });

        lbHo1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbHo1.setText("Tên:");

        TXTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenActionPerformed(evt);
            }
        });

        lbKH1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbKH1.setText("Số điện thoại:");

        TXSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSDTActionPerformed(evt);
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
        LBPhongTrong.setText("Danh sách phòng :");

        LBPhongTrong1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        LBPhongTrong1.setText("TÌM PHÒNG TRỐNG:");

        LBMaLoaiPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBMaLoaiPhongTrong.setText("Mã loại phòng:");

        lbSoGiuongPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuongPhongTrong.setText("Số giường:");

        TXSoGiuongTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSoGiuongTimActionPerformed(evt);
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

        ButtonDatPhong.setBackground(new java.awt.Color(52, 152, 219));
        ButtonDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ButtonDatPhong.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDatPhong.setText("Đặt phòng");
        ButtonDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDatPhongActionPerformed(evt);
            }
        });

        tblDSPHONGTRONG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Mã loại phòng", "Số giường", "Đơn giá", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDSPHONGTRONG);

        lbNgayDP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgayDP.setText("Ngày đặt phòng:");

        lbNgayTP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbNgayTP.setText("Ngày trả phòng:");

        jButtonResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        jButtonResert.setBorderPainted(false);
        jButtonResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });

        lbMoTa1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMoTa1.setText("Tổng tiền");

        TXTongTien.setEditable(false);
        TXTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTongTienActionPerformed(evt);
            }
        });

        ButtonChonNhieuPhongDat.setBackground(new java.awt.Color(52, 152, 219));
        ButtonChonNhieuPhongDat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonChonNhieuPhongDat.setForeground(new java.awt.Color(255, 255, 255));
        ButtonChonNhieuPhongDat.setText("Chọn");
        ButtonChonNhieuPhongDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChonNhieuPhongDatActionPerformed(evt);
            }
        });

        ButtonXemChiTietDat.setBackground(new java.awt.Color(52, 152, 219));
        ButtonXemChiTietDat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonXemChiTietDat.setForeground(new java.awt.Color(255, 255, 255));
        ButtonXemChiTietDat.setText("Chi tiết đặt");
        ButtonXemChiTietDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonXemChiTietDatActionPerformed(evt);
            }
        });

        lbMaPhong1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaPhong1.setText("Mã phòng:");

        TXMaPhongTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMaPhongTimActionPerformed(evt);
            }
        });

        lbSoGiuongPhongTrong1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuongPhongTrong1.setText("Đơn giá:");

        TXDonGiaTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXDonGiaTimActionPerformed(evt);
            }
        });

        TXMaLoaiPhongTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMaLoaiPhongTimActionPerformed(evt);
            }
        });

        ButtonChonNhieuPhongDat1.setBackground(new java.awt.Color(52, 152, 219));
        ButtonChonNhieuPhongDat1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonChonNhieuPhongDat1.setForeground(new java.awt.Color(255, 255, 255));
        ButtonChonNhieuPhongDat1.setText("Tính Tổng");
        ButtonChonNhieuPhongDat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonChonNhieuPhongDat1ActionPerformed(evt);
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
                    .addComponent(TXGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(TXHo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbHo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTen, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)))
                        .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMoTa1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXSDT)
                            .addComponent(DCNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(TXEmail)
                            .addComponent(TXTongTien))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbNgayTP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DCNgayTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbNgayDP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DCNgayDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBNam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RBNu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ButtonChonNhieuPhongDat, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(ButtonXemChiTietDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonChonNhieuPhongDat1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(505, 505, 505))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMaPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSoGiuongPhongTrong1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TXMaPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXDonGiaTim, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LBMaLoaiPhongTrong))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(TXMaLoaiPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(97, 97, 97)
                                        .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TXSoGiuongTim, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addComponent(jButtonResert))
                            .addComponent(LBPhongTrong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(LBPhongTrong1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BTKH)
                                            .addComponent(lbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbHo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TXTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TXMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TXSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(RBNu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ButtonChonNhieuPhongDat))))
                            .addComponent(DCNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TXGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbNgayTP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonXemChiTietDat, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(DCNgayTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMoTa1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonChonNhieuPhongDat1))
                .addGap(16, 16, 16)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(LBPhongTrong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBMaLoaiPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonTim)
                            .addComponent(lbMaPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXMaPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXMaLoaiPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXSoGiuongTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSoGiuongPhongTrong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXDonGiaTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(ButtonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonResert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(LBPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void DatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
         
    }//GEN-LAST:event_DatPhongActionPerformed

    private void selfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        new PhieuThuePhong().setVisible(true);        
    }//GEN-LAST:event_KhachSanActionPerformed

    private void TXDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXDPActionPerformed

    private void TXKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXKhachHangActionPerformed

    private void BTKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTKHActionPerformed
        ChonKhachHang chonKH = new ChonKhachHang(this);
        chonKH.setVisible(true);
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

    private void TXTenLP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLP1ActionPerformed

    private void TXHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXHoActionPerformed

    private void TXTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenActionPerformed

    private void TXSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSDTActionPerformed

    private void TXEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXEmailActionPerformed

    private void RBNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBNamActionPerformed

    private void TXSoGiuongTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoGiuongTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoGiuongTimActionPerformed

    private void ButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTimActionPerformed
        try {
        String maPhongStr = TXMaPhongTim.getText().trim();
        String soGiuongStr = TXSoGiuongTim.getText().trim();
        String maLoaiPhong = TXMaLoaiPhongTim.getText().trim();
        String donGiaStr = TXDonGiaTim.getText().trim();

        // Chuyển đổi các giá trị đầu vào
        Integer maPhong = maPhongStr.isEmpty() ? null : Integer.parseInt(maPhongStr);
        Integer soGiuong = soGiuongStr.isEmpty() ? null : Integer.parseInt(soGiuongStr);
        Double donGia = donGiaStr.isEmpty() ? null : Double.parseDouble(donGiaStr); 
        String maLoaiPhongFilter = maLoaiPhong.isEmpty() ? null : maLoaiPhong; 

        model.setRowCount(0); // Xóa bảng

        for (QuanLiPhongDTO phong : danhSachPhongGoc) {
            boolean match = true;

            // Kiểm tra các điều kiện tìm kiếm
            if (maPhong != null && phong.getMaPhong() != maPhong) match = false;
            if (soGiuong != null && phong.getSoGiuong() != soGiuong) match = false;
            if (maLoaiPhongFilter != null && !phong.getMaLoaiPhong().equals(maLoaiPhongFilter)) match = false;
            if (donGia != null && phong.getDonGia() != donGia) match = false; // Kiểm tra điều kiện đơn giá

            // Nếu khớp với tất cả điều kiện thì thêm vào bảng
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
        // Xóa nội dung các TextField
        TXMaPhongTim.setText("");
        TXSoGiuongTim.setText("");
        TXMaLoaiPhongTim.setText("");
        TXDonGiaTim.setText("");

        model.setRowCount(0); 

        for (QuanLiPhongDTO phong : danhSachPhongGoc) {
            model.addRow(new Object[] {
                    phong.getMaPhong(), phong.getMaLoaiPhong(), phong.getSoGiuong(),
                    phong.getDonGia(), phong.getTrangThai()
            });
        }
    }//GEN-LAST:event_jButtonResertActionPerformed

    private void DatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVuActionPerformed
        dispose();
        new DatDichVu().setVisible(true);
    }//GEN-LAST:event_DatDichVuActionPerformed

    private void TXTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTongTienActionPerformed

    private void ButtonChonNhieuPhongDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChonNhieuPhongDatActionPerformed
        try {
        // Lấy dữ liệu từ các TextField
        String maDatPhongStr = TXDP.getText().trim();
        String maPhongStr = TXMaPhong.getText().trim();
        Date ngayDatPhong = DCNgayDP.getDate();
        Date ngayTraPhong = DCNgayTP.getDate();
        String giaPhongStr = TXGiaThue.getText().trim();

        // Kiểm tra dữ liệu nhập đầy đủ
        if (maDatPhongStr.isEmpty() || maPhongStr.isEmpty() || ngayDatPhong == null || ngayTraPhong == null || giaPhongStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }

        // Chuẩn hóa ngày
        Date ngayDatPhongChuan = chuanHoaNgay(ngayDatPhong);
        Date ngayTraPhongChuan = chuanHoaNgay(ngayTraPhong);
        Date ngayHienTaiChuan = chuanHoaNgay(new Date());

        // Kiểm tra logic ngày
        if (ngayDatPhongChuan.before(ngayHienTaiChuan)) {
            JOptionPane.showMessageDialog(this, "Ngày đặt phòng phải lớn hơn hoặc bằng ngày hiện tại.");
            return;
        }

        if (ngayDatPhongChuan.after(ngayTraPhongChuan)) {
            JOptionPane.showMessageDialog(this, "Ngày đặt phòng phải nhỏ hơn hoặc bằng ngày trả phòng.");
            return;
        }

        // Parse dữ liệu
        int maDatPhong = Integer.parseInt(maDatPhongStr);
        int maPhong = Integer.parseInt(maPhongStr);
        double giaPhong = Double.parseDouble(giaPhongStr);

        // Lấy danh sách tạm và kiểm tra mã đặt phòng
        List<ChiTietPhieuThuePhongDTO> danhSachTam = BLL.DanhSachTamCTPhieuThuePhong.getDanhSachChiTiet();
        if (!danhSachTam.isEmpty()) {
            int maDatPhongCu = danhSachTam.get(0).getMaThuePhong();
            if (maDatPhongCu != maDatPhong) {
                JOptionPane.showMessageDialog(this, "Đây là danh sách phòng muốn đặt của mã đặt phòng " + maDatPhongCu + ". Không nên thay đổi mã đặt phòng khác.");
                return;
            }
        }

        // Kiểm tra phòng trùng lịch trong dữ liệu đã lưu (trạng thái đang dùng hoặc chờ xác nhận)
        QuanLiPhongBLL quanLiPhongBLL = new QuanLiPhongBLL();
        ArrayList<QuanLiPhongDTO> dsp = quanLiPhongBLL.layDanhSachPhong();
        for (QuanLiPhongDTO p : dsp) {
            if (p.getMaPhong() == maPhong && ("Dang su dung".equals(p.getTrangThai()) || "Dang cho xac nhan".equals(p.getTrangThai()))) {
                ChiTietPhieuThuePhongBLL ctptPhongBLL = new ChiTietPhieuThuePhongBLL();
                ArrayList<ChiTietPhieuThuePhongDTO> dsct = ctptPhongBLL.layDanhSachChiTiet();
                for (ChiTietPhieuThuePhongDTO ct : dsct) {
                    if (ct.getMaPhong() == maPhong) {
                        boolean isOverlapping = !(ngayTraPhongChuan.before(chuanHoaNgay(ct.getNgayDatPhong())) ||
                                                  ngayDatPhongChuan.after(chuanHoaNgay(ct.getNgayTraPhong())));
                        if (isOverlapping) {
                            JOptionPane.showMessageDialog(this, "Phòng này đang thuê hoặc đang chờ xác nhận và bị trùng thời gian.");
                            return;
                        }
                    }
                }
            }
        }

        // Kiểm tra phòng trùng trong danh sách tạm
        for (ChiTietPhieuThuePhongDTO ct : danhSachTam) {
            if (ct.getMaPhong() == maPhong) {
                boolean isOverlapping = !(ngayTraPhongChuan.before(chuanHoaNgay(ct.getNgayDatPhong())) ||
                                          ngayDatPhongChuan.after(chuanHoaNgay(ct.getNgayTraPhong())));
                if (isOverlapping) {
                    JOptionPane.showMessageDialog(this, "Phòng này đã được chọn trước đó với thời gian bị trùng.");
                    return;
                }
            }
        }

        // Tính thành tiền
        long diffInDays = (ngayTraPhongChuan.getTime() - ngayDatPhongChuan.getTime()) / (1000 * 60 * 60 * 24);
        double thanhTien = giaPhong * diffInDays;

        // Thêm vào danh sách tạm
        ChiTietPhieuThuePhongDTO chiTiet = new ChiTietPhieuThuePhongDTO(
            maDatPhong, maPhong, ngayDatPhongChuan, ngayTraPhongChuan, giaPhong, thanhTien
        );
        BLL.DanhSachTamCTPhieuThuePhong.addChiTiet(chiTiet);

        JOptionPane.showMessageDialog(this, "Đã thêm phòng muốn đặt.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xử lý dữ liệu: " + e.getMessage());
    }
    }//GEN-LAST:event_ButtonChonNhieuPhongDatActionPerformed

    
    private Date chuanHoaNgay(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(sdf.format(date));
    }
    private void ButtonXemChiTietDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonXemChiTietDatActionPerformed
        try {
            ChiTietPhieuThuePhong chiTietFrame = new ChiTietPhieuThuePhong();
            chiTietFrame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi mở giao diện chi tiết: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonXemChiTietDatActionPerformed

    private void TXMaPhongTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMaPhongTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMaPhongTimActionPerformed

    private void TXDonGiaTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXDonGiaTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXDonGiaTimActionPerformed

    private void TXMaLoaiPhongTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMaLoaiPhongTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMaLoaiPhongTimActionPerformed

    private void ButtonChonNhieuPhongDat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonChonNhieuPhongDat1ActionPerformed
        try {
            double tongTien = 0.0;

            List<ChiTietPhieuThuePhongDTO> ds = BLL.DanhSachTamCTPhieuThuePhong.getDanhSachChiTiet();
            for (ChiTietPhieuThuePhongDTO chiTiet : ds) {
                tongTien += chiTiet.getThanhTien();
            }

            // Hiển thị kết quả tổng tiền lên TextField
            TXTongTien.setText(String.format("%.2f", tongTien));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tính tổng tiền: " + e.getMessage());
        }
    }//GEN-LAST:event_ButtonChonNhieuPhongDat1ActionPerformed

    private void ButtonDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDatPhongActionPerformed
        try {
            // 0. Kiểm tra các trường không được để trống
            if (TXKhachHang.getText().trim().isEmpty() ||
                TXHo.getText().trim().isEmpty() ||
                TXTen.getText().trim().isEmpty() ||
                DCNgaySinh.getDate() == null ||
                TXEmail.getText().trim().isEmpty() ||
                TXSDT.getText().trim().isEmpty() ||
                TXDP.getText().trim().isEmpty() ||
                TXTongTien.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin trước khi đặt phiếu thuê!");
                return;
            }

            // 1. Lưu thông tin khách hàng
            String maKhachHangStr = TXKhachHang.getText().trim();
            int maKhachHang = Integer.parseInt(maKhachHangStr);
            String ho = TXHo.getText().trim();
            String ten = TXTen.getText().trim();
            java.util.Date ngaySinh = DCNgaySinh.getDate();
            String gioiTinh = RBNam.isSelected() ? "Nam" : "Nu";
            String email = TXEmail.getText().trim();
            String sdt = TXSDT.getText().trim();

            KhachHangDTO khach = new KhachHangDTO(maKhachHang, ho, ten, new java.sql.Date(ngaySinh.getTime()), gioiTinh, email, sdt);
            KhachHangBLL khBLL = new KhachHangBLL();
            if (!khBLL.kiemTraTonTai(maKhachHang)) {
                khBLL.themKhachHang(khach);
            }

            // 2. Lấy mã nhân viên từ tài khoản đăng nhập
            TaiKhoanDAO tkDAO = new TaiKhoanDAO();
            TaiKhoanDTO tk = tkDAO.layTaiKhoanDangNhapTuBangNhanVienDangNhap();
            int maNhanVien = tk.getMaNhanVien();

            List<ChiTietPhieuThuePhongDTO> danhSachChiTiet = DanhSachTamCTPhieuThuePhong.getDanhSachChiTiet();

            if (danhSachChiTiet.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Danh sách phòng muốn đặt đang rỗng. Vui lòng chọn phòng trước khi đặt phiếu .");
                return;
            }

            for (ChiTietPhieuThuePhongDTO ct : danhSachChiTiet) {
                System.out.println(ct);
            }

            // 3. Lưu phiếu thuê phòng
            int maThuePhong = Integer.parseInt(TXDP.getText().trim());
            java.util.Date ngayLapPhieu = new java.util.Date(); // Ngày hiện tại
            double tongTien = Double.parseDouble(TXTongTien.getText().trim());
            String trangThai = "Dang cho xac nhan";
            // Kiểm tra xem mã thuê phòng có trùng với mã thuê phòng trong danh sách tạm không
            for (ChiTietPhieuThuePhongDTO ct : danhSachChiTiet) {
               if(ct.getMaThuePhong() != maThuePhong) {
                   JOptionPane.showMessageDialog(this, "Mã thuê phòng không trùng với mã thuê phòng trong danh tạm đang lưu");
                   return;
                }
            }

            PhieuThuePhongDTO phieu = new PhieuThuePhongDTO(maThuePhong, maKhachHang, maNhanVien, ngayLapPhieu, tongTien, trangThai);
            PhieuThuePhongBLL phieuBLL = new PhieuThuePhongBLL();
            phieuBLL.themPhieuThue(phieu); // Lưu phiếu thuê

            // 4. Lưu chi tiết phiếu thuê + cập nhật trạng thái phòng
            ChiTietPhieuThuePhongBLL chiTietBLL = new ChiTietPhieuThuePhongBLL();
            QuanLiPhongBLL phongBLL = new QuanLiPhongBLL();
            for (ChiTietPhieuThuePhongDTO ct : danhSachChiTiet) {
                try {
                    chiTietBLL.themChiTiet(ct); // Lưu chi tiết
                    phongBLL.capNhatTrangThai(ct.getMaPhong(), "Dang cho xac nhan"); // Cập nhật trạng thái phòng
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi lưu chi tiết phòng: " + e.getMessage());
                }
            }

            JOptionPane.showMessageDialog(this, "Đặt phiếu thuê phòng thành công! -- Vui lòng qua phần CheckIn để xác nhận !");
            DanhSachTamCTPhieuThuePhong.clearDanhSach(); // Xóa danh sách tạm sau khi lưu
            loadDataPhong();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi đặt phiếu thuê phòng: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonDatPhongActionPerformed

    private void DatDichVu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVu1ActionPerformed
        dispose();
        new DanhSachDatDichVu().setVisible(true);
    }//GEN-LAST:event_DatDichVu1ActionPerformed

    private void HoaDonDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonDatPhongActionPerformed
        dispose();
        try {
            new DanhSachHoaDon().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThuePhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HoaDonDatPhongActionPerformed

    private void DSKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSKhachHangActionPerformed
        dispose();
        new DanhSachKhachHang().setVisible(true);
    }//GEN-LAST:event_DSKhachHangActionPerformed

    private void DSDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSDatPhongActionPerformed
        dispose();
        new DanhSachDatPhongGUI().setVisible(true);
    }//GEN-LAST:event_DSDatPhongActionPerformed

    private void CheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInActionPerformed
        dispose();
        new DSCheckInGUI().setVisible(true);
    }//GEN-LAST:event_CheckInActionPerformed

    private void CheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutActionPerformed
        dispose();
        new DSCheckOutGUI().setVisible(true);
    }//GEN-LAST:event_CheckOutActionPerformed

    private void DatDichVu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDichVu2ActionPerformed
        dispose();
        new KiemTraPhongGUI().setVisible(true);
    }//GEN-LAST:event_DatDichVu2ActionPerformed

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
        } catch (Exception ex) { // Gộp tất cả các ngoại lệ vào một catch
            java.util.logging.Logger.getLogger(PhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuThuePhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTKH;
    private javax.swing.JButton ButtonChonNhieuPhongDat;
    private javax.swing.JButton ButtonChonNhieuPhongDat1;
    private javax.swing.JButton ButtonDatPhong;
    private javax.swing.JButton ButtonTim;
    private javax.swing.JButton ButtonXemChiTietDat;
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton CheckOut;
    private com.toedter.calendar.JDateChooser DCNgayDP;
    private com.toedter.calendar.JDateChooser DCNgaySinh;
    private com.toedter.calendar.JDateChooser DCNgayTP;
    private javax.swing.JButton DSDatPhong;
    private javax.swing.JButton DSKhachHang;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton DatDichVu;
    private javax.swing.JButton DatDichVu1;
    private javax.swing.JButton DatDichVu2;
    private javax.swing.JButton DatPhong;
    private javax.swing.JButton HoaDonDatPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JLabel LBMaLoaiPhongTrong;
    private javax.swing.JLabel LBPhongTrong;
    private javax.swing.JLabel LBPhongTrong1;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JRadioButton RBNam;
    private javax.swing.JRadioButton RBNu;
    private javax.swing.JTextField TXDP;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXDonGiaTim;
    private javax.swing.JTextField TXEmail;
    private javax.swing.JTextField TXGiaThue;
    private javax.swing.JTextField TXHo;
    private javax.swing.JTextField TXKhachHang;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXMaLoaiPhong;
    private javax.swing.JTextField TXMaLoaiPhongTim;
    private javax.swing.JTextField TXMaPhong;
    private javax.swing.JTextField TXMaPhongTim;
    private javax.swing.JTextField TXSDT;
    private javax.swing.JTextField TXSoGiuong;
    private javax.swing.JTextField TXSoGiuongTim;
    private javax.swing.JTextField TXTen;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTextField TXTongTien;
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
    private javax.swing.JLabel lbMaPhong1;
    private javax.swing.JLabel lbMoTa1;
    private javax.swing.JLabel lbNgayDP;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbNgayTP;
    private javax.swing.JLabel lbSoGiuong;
    private javax.swing.JLabel lbSoGiuongPhongTrong;
    private javax.swing.JLabel lbSoGiuongPhongTrong1;
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
    private javax.swing.JTable tblDSPHONGTRONG;
    // End of variables declaration//GEN-END:variables
}
