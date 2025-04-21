package UI;

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


//DTO
class TaiKhoanDTO {
    private int maTaiKhoan;
    private String tenDangNhap;
    private String matKhau;
    private int maNhanVien;
    private String vaiTro;
    private String trangThai;

    // Constructors
    public TaiKhoanDTO() {}

    public TaiKhoanDTO(int maTaiKhoan, String tenDangNhap, String matKhau,
                       int maNhanVien, String vaiTro, String trangThai) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maNhanVien = maNhanVien;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    // Getters & Setters
    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

//DAO

class TaiKhoanDAO {
    public TaiKhoanDTO dangNhap(String tenDangNhap, String matKhau) {
        TaiKhoanDTO tk = null;
        try {
            Connection conn = sql.DatabaseQLKS.getConnection();
            String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ? AND TrangThai = 'active'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                tk = new TaiKhoanDTO();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setMaNhanVien(rs.getInt("MaNhanVien"));
                tk.setVaiTro(rs.getString("VaiTro"));
                tk.setTrangThai(rs.getString("TrangThai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }
    
    public TaiKhoanDTO layTaiKhoanDangNhapTuBangNhanVienDangNhap() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = sql.DatabaseQLKS.getConnection();
            String sql = "SELECT TOP 1 MaTaiKhoan, TenDangNhap, MaNhanVien, VaiTro FROM NhanVienDangNhap ORDER BY ThoiGianDangNhap DESC";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMaNhanVien(rs.getInt("MaNhanVien"));
                tk.setVaiTro(rs.getString("VaiTro"));
                return tk;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.DatabaseQLKS.close(conn, stmt, rs);
        }
        return null;
    }


}

class TaiKhoanBLL {
    TaiKhoanDAO dao = new TaiKhoanDAO();

    // Đăng nhập
    public TaiKhoanDTO dangNhap(String tenDangNhap, String matKhau) {
        return dao.dangNhap(tenDangNhap, matKhau);
    }

    // Thêm thông tin đăng nhập vào bảng tạm
    public void themDangNhapVaoBangTam(TaiKhoanDTO tk) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = sql.DatabaseQLKS.getConnection();
            String sql = "INSERT INTO NhanVienDangNhap (MaTaiKhoan, TenDangNhap, MaNhanVien, VaiTro, ThoiGianDangNhap) " +
                         "VALUES (?, ?, ?, ?, GETDATE())";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tk.getMaTaiKhoan());
            ps.setString(2, tk.getTenDangNhap());
            ps.setInt(3, tk.getMaNhanVien());
            ps.setString(4, tk.getVaiTro());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Xóa toàn bộ thông tin trong bảng NhanVienDangNhap
    public void xoaTatCaDangNhapBangTam() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = sql.DatabaseQLKS.getConnection();
            String sql = "DELETE FROM NhanVienDangNhap";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

public class GiaoDienDangNhap extends javax.swing.JFrame {

    private Component frame;
    public GiaoDienDangNhap() {
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
        DSDatDichVu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        LBTenDN = new javax.swing.JLabel();
        LBMK = new javax.swing.JLabel();
        TXTenDN = new javax.swing.JTextField();
        btnDangNhap = new javax.swing.JButton();
        TXMK = new javax.swing.JPasswordField();
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

        DSKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/registration-form.png"))); // NOI18N
        DSKhachHang.setText("Danh Sách Khách Hàng");
        DSKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        DSDatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DSDatDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reception.png"))); // NOI18N
        DSDatDichVu.setText("Danh Sách Đặt Dịch Vụ");
        DSDatDichVu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

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
                    .addComponent(DSKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(DSDatDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
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
                .addComponent(HoaDonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSDatDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(307, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        LBTenDN.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LBTenDN.setText("Tên Đăng Nhập: ");

        LBMK.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LBMK.setText("Mật Khẩu: ");

        TXTenDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTenDNActionPerformed(evt);
            }
        });

        btnDangNhap.setBackground(new java.awt.Color(52, 152, 219));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng Nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(535, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(501, 501, 501))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDangNhap)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBTenDN)
                            .addComponent(LBMK, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXTenDN, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(TXMK))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LBMK, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TXMK, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1418, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
       JOptionPane.showMessageDialog(frame, "Bạn cần đăng nhập!");
    }//GEN-LAST:event_DatPhongActionPerformed

    private void selfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed

        JOptionPane.showMessageDialog(frame, "Bạn cần đăng nhập!");
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        
    }//GEN-LAST:event_KhachSanActionPerformed

    private void TXTenDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenDNActionPerformed
        
    }//GEN-LAST:event_TXTenDNActionPerformed

    private void QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        JOptionPane.showMessageDialog(frame, "Bạn cần đăng nhập!");
    }//GEN-LAST:event_QuanLiActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String tenDangNhap = TXTenDN.getText();
        String matKhau = new String(TXMK.getPassword());

        TaiKhoanBLL bll = new TaiKhoanBLL();
        TaiKhoanDTO tk = bll.dangNhap(tenDangNhap, matKhau);

        if (tk != null && tk.getTrangThai().equalsIgnoreCase("active")) {
            // Đăng nhập thành công
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");

            // Thêm vào bảng tạm
            bll.themDangNhapVaoBangTam(tk);

            // Mở form chính (DatPhong)
            UI.PhieuThuePhong datPhong = new UI.PhieuThuePhong();
            datPhong.setVisible(true);

            // Đóng form đăng nhập
            this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!");
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

   
    public static void main(String args[]) {
        TaiKhoanBLL bll = new TaiKhoanBLL();
        bll.xoaTatCaDangNhapBangTam();  

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienDangNhap().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton CheckOut;
    private javax.swing.JButton DSDatDichVu;
    private javax.swing.JButton DSKhachHang;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton DatPhong;
    private javax.swing.JButton HoaDonDatPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JLabel LBMK;
    private javax.swing.JLabel LBTenDN;
    private javax.swing.JButton QuanLi;
    private javax.swing.JPasswordField TXMK;
    private javax.swing.JTextField TXTenDN;
    private javax.swing.JLabel Tittle;
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
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
    // End of variables declaration//GEN-END:variables

}




