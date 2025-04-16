package doanquanlikhachsan;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
// Removed unused and unresolved import
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import sql.DatabaseQLKS;
import java.util.ArrayList;


class LoaiPhongDTO {
    private String maLoaiPhong;
    private String tenLoaiPhong;
    private String moTa;

    public LoaiPhongDTO() {
    }

    public LoaiPhongDTO(String maLoaiPhong, String tenLoaiPhong, String moTa) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.moTa = moTa;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}

class QuanLiPhongDTO {
    private int maPhong;
    private String maLoaiPhong;
    private int soGiuong;
    private double donGia;
    private String trangThai;

    public QuanLiPhongDTO() {
    }

    public QuanLiPhongDTO(int maPhong, String maLoaiPhong,int soGiuong, double donGia, String trangThai) {
        this.maPhong = maPhong;
        this.maLoaiPhong = maLoaiPhong;
        this.soGiuong = soGiuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public int getSoGiuong() {
        return soGiuong;
    }

    public void setSoGiuong(int soGiuong) {
        this.soGiuong = soGiuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

class LoaiPhongDAO {
    public ArrayList<LoaiPhongDTO> layDanhSachLoaiPhong() throws SQLException {
        ArrayList<LoaiPhongDTO> dslp = new ArrayList<>();
        String sql = "SELECT * FROM LoaiPhong";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dslp.add(new LoaiPhongDTO(
                    rs.getString("MaLoaiPhong"),
                    rs.getString("TenLoaiPhong"),
                    rs.getString("MoTa")
                ));
            }
        }
        return dslp;
    }
}

class LoaiPhongBLL {
    private final LoaiPhongDAO loaiPhongDAO;

    public LoaiPhongBLL() {
        loaiPhongDAO = new LoaiPhongDAO();
    }
    
    public ArrayList<LoaiPhongDTO> layDanhSachLoaiPhong() throws SQLException {
        return loaiPhongDAO.layDanhSachLoaiPhong();
    }
    
}

class QuanLiPhongDAO {
    public boolean kiemTraTonTai(int maPhong) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Phong WHERE MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPhong);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }
    
    public void themPhong(QuanLiPhongDTO phong) throws SQLException {
        String sql = "INSERT INTO Phong (MaPhong, MaLoaiPhong, SoGiuong, DonGia, TrangThai) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseQLKS.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, phong.getMaPhong());
            stmt.setString(2, phong.getMaLoaiPhong());
            stmt.setInt(3, phong.getSoGiuong());
            stmt.setDouble(4, phong.getDonGia());
            stmt.setString(5, phong.getTrangThai());
            stmt.executeUpdate();
        }
    }
    
    public void suaPhong(QuanLiPhongDTO phong) throws SQLException {
        String sql = "UPDATE Phong SET MaLoaiPhong = ?, SoGiuong = ?, DonGia = ?, TrangThai = ? WHERE MaPhong = ?";
        try (Connection connection = DatabaseQLKS.getConnection(); 
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, phong.getMaLoaiPhong());
            stmt.setInt(2, phong.getSoGiuong());
            stmt.setDouble(3, phong.getDonGia());
            stmt.setString(4, phong.getTrangThai());
            stmt.setInt(5, phong.getMaPhong()); 

            int rowsAffected = stmt.executeUpdate(); 
            if (rowsAffected == 0) {
                throw new SQLException("Không tìm thấy phòng với mã: " + phong.getMaPhong());
            }
        }
    }
    
    public ArrayList<QuanLiPhongDTO> layDanhSachPhong() throws SQLException {
        ArrayList<QuanLiPhongDTO> dsp = new ArrayList<>();
        String sql = "SELECT * FROM Phong";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                dsp.add(new QuanLiPhongDTO(
                    rs.getInt("MaPhong"),
                    rs.getString("MaLoaiPhong"),
                    rs.getInt("SoGiuong"),
                    rs.getDouble("DonGia"),
                    rs.getString("TrangThai")
                ));
            }
        }
        return dsp;
    }
    
//                                                  TÌM KIẾM BẰNG SQL (NẾU CẦN)
//    public ArrayList<QuanLiPhongDTO> timKiemPhong(Integer maPhong, Integer soGiuong, Integer maLoaiPhong, String tenLoaiPhong) throws SQLException {
//        ArrayList<QuanLiPhongDTO> danhSach = new ArrayList<>();
//
//        StringBuilder sql = new StringBuilder("SELECT p.MaPhong, p.MaLoaiPhong, p.SoGiuong, p.DonGia, p.TrangThai " +
//                                              "FROM Phong p " +
//                                              "JOIN LoaiPhong lp ON p.MaLoaiPhong = lp.MaLoaiPhong " +
//                                              "WHERE 1=1");
//
//        if (maPhong != null) {
//            sql.append(" AND p.MaPhong = ?");
//        }
//        if (soGiuong != null) {
//            sql.append(" AND p.SoGiuong = ?");
//        }
//        if (maLoaiPhong != null) {
//            sql.append(" AND p.MaLoaiPhong = ?");
//        }
//        if (tenLoaiPhong != null && !tenLoaiPhong.isEmpty()) {
//            sql.append(" AND lp.TenLoaiPhong LIKE ?");
//        }
//
//        try (Connection conn = DatabaseQLKS.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
//
//            int index = 1;
//            if (maPhong != null) {
//                stmt.setInt(index++, maPhong);
//            }
//            if (soGiuong != null) {
//                stmt.setInt(index++, soGiuong);
//            }
//            if (maLoaiPhong != null) {
//                stmt.setInt(index++, maLoaiPhong);
//            }
//            if (tenLoaiPhong != null && !tenLoaiPhong.isEmpty()) {
//                stmt.setString(index++, "%" + tenLoaiPhong + "%");
//            }
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                danhSach.add(new QuanLiPhongDTO(
//                    rs.getInt("MaPhong"),
//                    rs.getString("MaLoaiPhong"),
//                    rs.getInt("SoGiuong"),
//                    rs.getDouble("DonGia"),
//                    rs.getString("TrangThai")
//                ));
//            }
//        }
//
//        return danhSach;
//    }
    
    // Xóa phòng
    public void xoaPhong(int maPhong) throws SQLException {
        String sql = "DELETE FROM Phong WHERE MaPhong = ?";
        try (Connection conn = DatabaseQLKS.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maPhong);
            stmt.executeUpdate();
        }
    }
}

// Business Logic Layer (BLL)
class QuanLiPhongBLL {
    private final QuanLiPhongDAO phongDAO;

    public QuanLiPhongBLL() {
        phongDAO = new QuanLiPhongDAO();
    }

    public void themPhong(QuanLiPhongDTO phong) throws Exception {
        if (phongDAO.kiemTraTonTai(phong.getMaPhong())) {
            throw new Exception("Mã phòng đã tồn tại!");
        }
        phongDAO.themPhong(phong);
    }

    
    public void suaPhong(QuanLiPhongDTO phong) throws SQLException {
        if (!phongDAO.kiemTraTonTai(phong.getMaPhong())) {
            throw new SQLException("Không tìm thấy phòng với mã: " + phong.getMaPhong());
        }
        phongDAO.suaPhong(phong);  // Gọi phương thức sửa trong DAO
    }

    public ArrayList<QuanLiPhongDTO> layDanhSachPhong() throws SQLException {
        return phongDAO.layDanhSachPhong();
    }

    public void xoaPhong(int maPhong) throws SQLException {
        phongDAO.xoaPhong(maPhong);
    }
}


public class QuanLiPhong extends javax.swing.JFrame {
    
    private ArrayList<QuanLiPhongDTO> danhSachPhongGoc = new ArrayList<>();
    
    public QuanLiPhong() {
        initComponents();
        phongBLL = new QuanLiPhongBLL();
        model = (DefaultTableModel) tblDSPHONG.getModel(); 
        modelLoaiPhong = (DefaultTableModel) tblDSLOAIPHONG.getModel(); 
        
        loadData();
        loadDataLoaiPhongToTable();
        
        tblDSPHONG.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDSPHONG.getSelectedRow();
                if (selectedRow != -1) {

                    String maPhong = (tblDSPHONG.getValueAt(selectedRow, 0) != null) ? tblDSPHONG.getValueAt(selectedRow, 0).toString() : "";
                    String maLoaiPhong = (tblDSPHONG.getValueAt(selectedRow, 1) != null) ? tblDSPHONG.getValueAt(selectedRow, 1).toString() : "";
                    String soGiuong = (tblDSPHONG.getValueAt(selectedRow, 2) != null) ? tblDSPHONG.getValueAt(selectedRow, 2).toString() : "";
                    String donGia = (tblDSPHONG.getValueAt(selectedRow, 3) != null) ? tblDSPHONG.getValueAt(selectedRow, 3).toString() : "";
                    String trangThai = (tblDSPHONG.getValueAt(selectedRow, 4) != null) ? tblDSPHONG.getValueAt(selectedRow, 4).toString() : "";

                    // Gán dữ liệu vào TextField
                    TXMaPhong.setText(maPhong);
                    TXSoGiuong.setText(soGiuong);
                    TXGiaThue.setText(donGia);
                    TXTrangThai.setText(trangThai);

                    // Tự động chọn lại loại phòng trong ComboBox
                    for (int i = 0; i < CBMaLoaiPhong.getItemCount(); i++) {
                        String phong = CBMaLoaiPhong.getItemAt(i);
                        if (phong.equals(maLoaiPhong)) {
                            CBMaLoaiPhong.setSelectedIndex(i);
                            break;
                        }
                    }

                }
            }
        });
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbMaPhong = new javax.swing.JLabel();
        TXMaPhong = new javax.swing.JTextField();
        lbMaLoaiPhong = new javax.swing.JLabel();
        lbSoGiuong = new javax.swing.JLabel();
        TXSoGiuong = new javax.swing.JTextField();
        lbGiaThue = new javax.swing.JLabel();
        TXGiaThue = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        LBPhongTrong = new javax.swing.JLabel();
        LBPhongTrong1 = new javax.swing.JLabel();
        LBMaLoaiPhongTrong = new javax.swing.JLabel();
        CBMaLoaiPhongTim = new javax.swing.JComboBox<>();
        lbSoGiuongPhongTrong = new javax.swing.JLabel();
        TXSoGiuongTim = new javax.swing.JTextField();
        ButtonTim = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSPHONG = new javax.swing.JTable();
        ButtonThem = new javax.swing.JButton();
        ButtonSua = new javax.swing.JButton();
        ButtonXoa = new javax.swing.JButton();
        LBMaLoaiPhongTrong1 = new javax.swing.JLabel();
        TXMaPhongTim = new javax.swing.JTextField();
        lbTrangThai = new javax.swing.JLabel();
        TXTrangThai = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSLOAIPHONG = new javax.swing.JTable();
        LBPhongTrong2 = new javax.swing.JLabel();
        jButtonResert = new javax.swing.JButton();
        CBMaLoaiPhong = new javax.swing.JComboBox<>();
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

        home.setBackground(new java.awt.Color(52, 152, 219));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/home (1).png"))); // NOI18N
        home.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1064, Short.MAX_VALUE)
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 152, 219));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PHÒNG");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(52, 152, 219));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField1.setEnabled(false);

        lbMaPhong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaPhong.setText("Mã phòng:");

        TXMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMaPhongActionPerformed(evt);
            }
        });

        lbMaLoaiPhong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbMaLoaiPhong.setText("Mã loại phòng:");

        lbSoGiuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbSoGiuong.setText("Số giường:");

        TXSoGiuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXSoGiuongActionPerformed(evt);
            }
        });

        lbGiaThue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbGiaThue.setText("Giá phòng thuê:");

        TXGiaThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXGiaThueActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(52, 152, 219));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(52, 152, 219), 5));
        jTextField2.setEnabled(false);

        LBPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBPhongTrong.setText("Danh sách phòng :");

        LBPhongTrong1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        LBPhongTrong1.setText("TÌM PHÒNG :");

        LBMaLoaiPhongTrong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBMaLoaiPhongTrong.setText("Mã loại phòng:");

        CBMaLoaiPhongTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_", "LP01", "LP02", "LP03", "LP04", "LP05" }));
        CBMaLoaiPhongTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMaLoaiPhongTimActionPerformed(evt);
            }
        });

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

        tblDSPHONG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Mã loại phòng", "Số giường", "Đơn Giá", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDSPHONG);

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

        LBMaLoaiPhongTrong1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBMaLoaiPhongTrong1.setText("Mã phòng:");

        TXMaPhongTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXMaPhongTimActionPerformed(evt);
            }
        });

        lbTrangThai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTrangThai.setText("Trạng thái: ");

        TXTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTrangThaiActionPerformed(evt);
            }
        });

        tblDSLOAIPHONG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã loại phòng", "Tên loại phòng", "Mô tả"
            }
        ));
        jScrollPane3.setViewportView(tblDSLOAIPHONG);

        LBPhongTrong2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LBPhongTrong2.setText("Danh sách loại phòng :");

        jButtonResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/reset_12366642 (1).png"))); // NOI18N
        jButtonResert.setBorderPainted(false);
        jButtonResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResertActionPerformed(evt);
            }
        });

        CBMaLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "_", "LP01", "LP02", "LP03", "LP04", "LP05" }));
        CBMaLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMaLoaiPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBPhongTrong)
                                    .addComponent(LBPhongTrong1)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBMaLoaiPhongTrong1)
                                    .addComponent(lbSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TXMaPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXSoGiuongTim, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(LBPhongTrong2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(LBMaLoaiPhongTrong)
                                        .addGap(49, 49, 49)
                                        .addComponent(CBMaLoaiPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonResert)
                                        .addGap(48, 48, 48))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3)))))
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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXGiaThue, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(CBMaLoaiPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TXTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(494, 494, 494))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonThem)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSua)
                    .addComponent(lbSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXGiaThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonXoa)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(LBPhongTrong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LBMaLoaiPhongTrong1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXMaPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LBMaLoaiPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBMaLoaiPhongTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonResert, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXSoGiuongTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonTim)
                    .addComponent(lbSoGiuongPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBPhongTrong2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
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
                    .addComponent(ButtonKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(256, Short.MAX_VALUE))
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
        new DatPhong().setVisible(true); 
    }//GEN-LAST:event_KhachSanActionPerformed

    private void TXMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMaPhongActionPerformed

    private void TXSoGiuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoGiuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoGiuongActionPerformed

    private void TXGiaThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXGiaThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXGiaThueActionPerformed

    private void TXTenLP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTenLP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTenLP1ActionPerformed

    private void CBMaLoaiPhongTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMaLoaiPhongTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBMaLoaiPhongTimActionPerformed

    private void TXSoGiuongTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXSoGiuongTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXSoGiuongTimActionPerformed

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
                 if (TXMaPhong.getText().isEmpty() || TXSoGiuong.getText().isEmpty() || TXTrangThai.getText().isEmpty() || TXGiaThue.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                     return;
                 }
                 
                 if(!TXTrangThai.getText().equals("Trống")) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập trạng thái là trống khi thêm Phòng.");
                     return;
                 }

                 QuanLiPhongDTO phong = new QuanLiPhongDTO(
                     Integer.parseInt(TXMaPhong.getText()),
                     CBMaLoaiPhong.getSelectedItem().toString(),
                     Integer.parseInt(TXSoGiuong.getText()),
                     Double.parseDouble(TXGiaThue.getText()),
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
            int maPhong = Integer.parseInt(TXMaPhong.getText());
            String maLoaiPhong = CBMaLoaiPhong.getSelectedItem().toString();
            int soGiuong = Integer.parseInt(TXSoGiuong.getText());
            double donGia = Double.parseDouble(TXGiaThue.getText());
            String trangThai = TXTrangThai.getText();  
           


            if (CBMaLoaiPhong.getSelectedItem().toString().equals("_")) {
                     JOptionPane.showMessageDialog(this, "Vui lòng chọn mã loại phòng");
                     return;
            }
            if (TXSoGiuong.getText().isEmpty() || TXTrangThai.getText().isEmpty() || TXGiaThue.getText().isEmpty()) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                     return;
            }
                 
            if(!TXTrangThai.getText().equals("Trống")) {
                     JOptionPane.showMessageDialog(this, "Vui lòng nhập trạng thái là trống khi thêm Phòng.");
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

    private void TXMaPhongTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXMaPhongTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXMaPhongTimActionPerformed

    private void TXTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTrangThaiActionPerformed

    private void ButtonQLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLPhongActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new QuanLiPhong().setVisible(true);
    }//GEN-LAST:event_ButtonQLPhongActionPerformed

    private void QuanLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new QuanLiPhong().setVisible(true);
    }//GEN-LAST:event_QuanLiActionPerformed

    private void ButtonQLDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQLDVActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new QuanLiDichVu().setVisible(true);
    }//GEN-LAST:event_ButtonQLDVActionPerformed

    private void jButtonResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResertActionPerformed
        dispose();
        loadData();
        loadDataLoaiPhongToTable();
        new QuanLiPhong().setVisible(true);
    }//GEN-LAST:event_jButtonResertActionPerformed

    private void CBMaLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMaLoaiPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBMaLoaiPhongActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            QuanLiPhong quanLiPhong = new QuanLiPhong(); // Tạo đối tượng QuanLiPhong
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
    private javax.swing.JButton ButtonThem;
    private javax.swing.JButton ButtonThongKe;
    private javax.swing.JButton ButtonTim;
    private javax.swing.JButton ButtonXoa;
    private javax.swing.JComboBox<String> CBMaLoaiPhong;
    private javax.swing.JComboBox<String> CBMaLoaiPhongTim;
    private javax.swing.JButton DSPhong;
    private javax.swing.JButton KhachSan;
    private javax.swing.JLabel LBMaLoaiPhongTrong;
    private javax.swing.JLabel LBMaLoaiPhongTrong1;
    private javax.swing.JLabel LBPhongTrong;
    private javax.swing.JLabel LBPhongTrong1;
    private javax.swing.JLabel LBPhongTrong2;
    private javax.swing.JButton NutDangNhap;
    private javax.swing.JButton QuanLi;
    private javax.swing.JTextField TXDangNhap;
    private javax.swing.JTextField TXGiaThue;
    private javax.swing.JTextField TXMK;
    private javax.swing.JTextField TXMaPhong;
    private javax.swing.JTextField TXMaPhongTim;
    private javax.swing.JTextField TXSoGiuong;
    private javax.swing.JTextField TXSoGiuongTim;
    private javax.swing.JTextField TXTenLP1;
    private javax.swing.JTextField TXTrangThai;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelMK;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbGiaThue;
    private javax.swing.JLabel lbMaLoaiPhong;
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lbSoGiuong;
    private javax.swing.JLabel lbSoGiuongPhongTrong;
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
    private javax.swing.JTable tblDSLOAIPHONG;
    private javax.swing.JTable tblDSPHONG;
    // End of variables declaration//GEN-END:variables
    private final DefaultTableModel model;
    private final DefaultTableModel modelLoaiPhong;
    private final QuanLiPhongBLL phongBLL;


}

