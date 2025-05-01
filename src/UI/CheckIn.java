package UI;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import BLL.CheckInOutBLL;
import BLL.KiemTraTinhTrangBUS;
import DAO.ChiTietPhieuThuePhongDAO;
import DAO.PhieuThuePhongDAO;
import DAO.QuanLiPhongDAO;
import DTO.ChiTietPhieuThuePhongDTO;
import DTO.KiemTraTinhTrang;
import DTO.PhieuThuePhongDTO;
import DTO.QuanLiPhongDTO;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import UI.*;
import com.toedter.calendar.JDateChooser;

public class CheckIn extends  JFrame {
	private static final long serialVersionUID = 1L;

	private  JButton CheckIn;
    private  JButton CheckOut;
    private  JButton DSDatDichVu;
    private  JButton DSDatPhong;
    private  JButton DSKhachHang;
    private  JButton DatDichVu;
    private  JButton DatPhong;
    private  JButton HoaDonDatPhong;
    private  JButton KhachSan;
    private  JButton NutDangNhap;
    private  JButton QuanLi;
    private  JLabel Tittle;
    private  JButton home;
    private  JButton jButton9;
    private  JLabel jLabel2;
    private  JPanel jPanel1;
    private  JPanel jPanel2;
    private  JPanel jPanel3;
    private  JPanel jPanel5;
    private  JLabel labelMK;
    private  JLabel lbDangNhap;
    private  Menu menu1;
    private  Menu menu2;
    private  Menu menu3;
    private  Menu menu4;
    private  Menu menu5;
    private  Menu menu6;
    private  MenuBar menuBar1;
    private  MenuBar menuBar2;
    private  MenuBar menuBar3;
    private  JButton self;
    private JPanel panel;
    private JTextField textField_1;
    private JLabel lblMaPhong;
    private JTextField textField_2;
    private JLabel lblLoaiPhong;
    private JTextField textField_3;
    private JTextField textField_4;
    private JLabel lblSoGiuong;
    private JLabel lblDonGia;
    private JTextField textField_5;
    private int maPhong;
    private int maThuePhong;

	private DefaultTableModel modelTinhTrang;
	private JLabel lblMaPhongKT1;
	private JLabel lblNewLabel_1;
	private JTextField txtMaPhongKT;
	private JButton btnCheckIn;
	private JButton btnHuyCK;

	private final KiemTraTinhTrangBUS ktttBUS = new KiemTraTinhTrangBUS();

	private KiemTraTinhTrang kttt;
	private JTable table;
	private JLabel lblTenKH;
	private JTextField textField_6;
	private JLabel lblNgayDatPhong;
	private JLabel lblNgyTrPhng;
	private JLabel lblMaThuePhong;
	private final QuanLiPhongDAO phongDAO = new QuanLiPhongDAO(); // hoặc PhongDAO nếu bạn dùng DAO
	private final ChiTietPhieuThuePhongDAO chiTietDAO = new ChiTietPhieuThuePhongDAO();
	private final PhieuThuePhongDAO phieuThueDAO = new PhieuThuePhongDAO();
	private final CheckInOutBLL checkInOutBLL = new CheckInOutBLL();
	
	public CheckIn(String ma, String ma1) {
		int maThuePhong = Integer.parseInt(ma);
		this.maThuePhong = maThuePhong;
		int maPhong = Integer.parseInt(ma1);
		this.maPhong = maPhong;
		modelTinhTrang = new DefaultTableModel(new String[]{
			    "Mã kiểm tra", "Mã phòng", "Mã nhân viên", "Ngày kiểm tra", "Mô tả thiệt hại", "Chi phí đền bù"
			}, 0);
		
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new  JPanel();
        jButton9 = new  JButton();
        jLabel2 = new  JLabel();
        menuBar1 = new  MenuBar();
        menu1 = new  Menu();
        menu2 = new  Menu();
        menuBar2 = new  MenuBar();
        menu3 = new  Menu();
        menu4 = new  Menu();
        menuBar3 = new  MenuBar();
        menu5 = new  Menu();
        menu6 = new  Menu();
        lbDangNhap = new  JLabel();
        NutDangNhap = new  JButton();
        labelMK = new  JLabel();
        jPanel1 = new  JPanel();
        Tittle = new  JLabel();
        self = new  JButton();
        home = new  JButton();
        jPanel3 = new  JPanel();
        DatPhong = new  JButton();
        CheckIn = new  JButton();
        CheckOut = new  JButton();
        HoaDonDatPhong = new  JButton();
        DSDatPhong = new  JButton();
        DSDatPhong.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                new DanhSachDatPhongGUI().setVisible(true);
        	}
        });
        DSKhachHang = new  JButton();
        DSDatDichVu = new  JButton();
        DatDichVu = new  JButton();
        jPanel5 = new  JPanel();
        KhachSan = new  JButton();
        QuanLi = new  JButton();
        

         GroupLayout jPanel2Layout = new  GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jButton9.setText("jButton3");

        jLabel2.setBackground(new  Color(102, 204, 0));
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

        lbDangNhap.setFont(new  Font("Times New Roman", 1, 14)); // NOI18N
        lbDangNhap.setText("Tên đăng nhập:");

        NutDangNhap.setFont(new  Font("Segoe UI", 0, 14)); // NOI18N
        NutDangNhap.setText("Đăng Nhập");

        labelMK.setFont(new  Font("Times New Roman", 1, 14)); // NOI18N
        labelMK.setText("Mật khẩu: ");
        labelMK.setPreferredSize(new  Dimension(90, 17));

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHECK ");
        setBackground(new  Color(255, 255, 255));

        jPanel1.setBackground(new  Color(52, 152, 219));

        Tittle.setFont(new  Font("Segoe UI", 3, 24)); // NOI18N
        Tittle.setForeground(new  Color(255, 255, 255));
        Tittle.setText("KHÁCH SẠN LQHT");
        Tittle.setIconTextGap(10);

        self.setBackground(new  Color(52, 152, 219));
        self.setForeground(new  Color(255, 255, 255));
        self.setIcon(new  ImageIcon(getClass().getResource("/ICON/user (1).png"))); // NOI18N
        self.setBorder(null);
        self.addActionListener(new   ActionListener() {
            public void actionPerformed(  ActionEvent evt) {
                selfActionPerformed(evt);
            }
        });

        home.setBackground(new  Color(52, 152, 219));
        home.setIcon(new  ImageIcon(getClass().getResource("/ICON/home (1).png"))); // NOI18N
        home.setBorder(null);
        home.addActionListener(new   ActionListener() {
            public void actionPerformed(  ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

         GroupLayout jPanel1Layout = new  GroupLayout(jPanel1);
         jPanel1Layout.setHorizontalGroup(
         	jPanel1Layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
         			.addGap(16)
         			.addComponent(Tittle, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED, 1025, Short.MAX_VALUE)
         			.addComponent(self, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(home, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
         	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
         		.addGroup(jPanel1Layout.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
         				.addComponent(Tittle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
         				.addComponent(self, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
         				.addComponent(home, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
         			.addContainerGap())
         );
        jPanel1.setLayout(jPanel1Layout);

        jPanel3.setBackground(new  Color(255, 255, 255));
        jPanel3.setBorder( BorderFactory.createLineBorder(new  Color(52, 152, 219), 5));

        DatPhong.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        DatPhong.setIcon(new  ImageIcon(getClass().getResource("/ICON/review.png"))); // NOI18N
        DatPhong.setText("Đặt Phòng");
        DatPhong.setHorizontalAlignment( SwingConstants.LEFT);
        DatPhong.addActionListener(new   ActionListener() {
            public void actionPerformed(  ActionEvent evt) {
                DatPhongActionPerformed(evt);
            }
        });

        CheckIn.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        CheckIn.setIcon(new  ImageIcon(getClass().getResource("/ICON/check-in.png"))); // NOI18N
        CheckIn.setText("Check In");
        CheckIn.setHorizontalAlignment( SwingConstants.LEFT);

        CheckOut.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        CheckOut.setIcon(new  ImageIcon(getClass().getResource("/ICON/check-out.png"))); // NOI18N
        CheckOut.setText("Check Out");
        CheckOut.setHorizontalAlignment( SwingConstants.LEFT);

        HoaDonDatPhong.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        HoaDonDatPhong.setIcon(new  ImageIcon(getClass().getResource("/ICON/bill.png"))); // NOI18N
        HoaDonDatPhong.setText("Hóa Đơn ");
        HoaDonDatPhong.setHorizontalAlignment( SwingConstants.LEFT);

        DSDatPhong.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        DSDatPhong.setIcon(new  ImageIcon(getClass().getResource("/ICON/list.png"))); // NOI18N
        DSDatPhong.setText("Danh Sách Đặt Phòng");
        DSDatPhong.setHorizontalAlignment( SwingConstants.LEFT);

        DSKhachHang.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        DSKhachHang.setIcon(new  ImageIcon(getClass().getResource("/ICON/registration-form.png"))); // NOI18N
        DSKhachHang.setText("Danh Sách Khách Hàng");
        DSKhachHang.setHorizontalAlignment( SwingConstants.LEFT);

        DSDatDichVu.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        DSDatDichVu.setIcon(new  ImageIcon(getClass().getResource("/ICON/reception.png"))); // NOI18N
        DSDatDichVu.setText("Danh Sách Đặt Dịch Vụ");
        DSDatDichVu.setHorizontalAlignment( SwingConstants.LEFT);

        DatDichVu.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        DatDichVu.setIcon(new  ImageIcon(getClass().getResource("/ICON/desk-bell.png"))); // NOI18N
        DatDichVu.setText("Đặt Dịch Vụ");
        DatDichVu.setHorizontalAlignment( SwingConstants.LEFT);
        DatDichVu.addActionListener(new   ActionListener() {
            public void actionPerformed(  ActionEvent evt) {
                DatDichVuActionPerformed(evt);
            }
        });

         GroupLayout jPanel3Layout = new  GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(DatPhong,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckIn,  GroupLayout.Alignment.TRAILING,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonDatPhong,  GroupLayout.Alignment.TRAILING,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CheckOut,  GroupLayout.Alignment.TRAILING,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSDatPhong,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DSKhachHang,  GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(DSDatDichVu,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDichVu,  GroupLayout.Alignment.TRAILING,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DatPhong,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckIn,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckOut,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSDatPhong,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HoaDonDatPhong,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSKhachHang,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DSDatDichVu,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DatDichVu,  GroupLayout.PREFERRED_SIZE, 47,  GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new  Color(255, 255, 255));
        jPanel5.setBorder( BorderFactory.createBevelBorder(BevelBorder.RAISED));

        KhachSan.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        KhachSan.setText("Khách Sạn");
        KhachSan.addActionListener(new   ActionListener() {
            public void actionPerformed(  ActionEvent evt) {
                KhachSanActionPerformed(evt);
            }
        });

        QuanLi.setFont(new  Font("Segoe UI", 1, 14)); // NOI18N
        QuanLi.setText("Quản Lí");
        QuanLi.addActionListener(new   ActionListener() {
            public void actionPerformed(  ActionEvent evt) {
                QuanLiActionPerformed(evt);
            }
        });

         GroupLayout jPanel5Layout = new  GroupLayout(jPanel5);
         jPanel5Layout.setHorizontalGroup(
         	jPanel5Layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(jPanel5Layout.createSequentialGroup()
         			.addGap(18)
         			.addComponent(KhachSan)
         			.addGap(18)
         			.addComponent(QuanLi, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap(22, Short.MAX_VALUE))
         );
         jPanel5Layout.setVerticalGroup(
         	jPanel5Layout.createParallelGroup(Alignment.TRAILING)
         		.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
         			.addComponent(KhachSan, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
         			.addComponent(QuanLi, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
         );
        jPanel5.setLayout(jPanel5Layout);
         
         panel = new JPanel();
         panel.setBackground(new Color(255, 255, 255));

         GroupLayout layout = new  GroupLayout(getContentPane());
         layout.setHorizontalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(layout.createParallelGroup(Alignment.LEADING)
         				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1438, Short.MAX_VALUE)
         				.addGroup(layout.createSequentialGroup()
         					.addGroup(layout.createParallelGroup(Alignment.LEADING)
         						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         						.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1155, GroupLayout.PREFERRED_SIZE)
         					.addGap(8)))
         			.addContainerGap())
         );
         layout.setVerticalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addGroup(layout.createParallelGroup(Alignment.LEADING)
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         				.addComponent(panel, 0, 0, Short.MAX_VALUE))
         			.addGap(125))
         );
         
         JLabel lblNewLabel = new JLabel("Check In");
         lblNewLabel.setFont(new Font("Segoe UI", 1, 19));
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel.setForeground(new Color(52, 152, 219));
         
         JTextField textField = new JTextField();
         textField.setEditable(false);
         textField.setBackground(new Color(52, 152, 219));
         textField.setColumns(10);
         textField.setBorder(null);
         
         lblMaThuePhong = new JLabel("Mã thuê phòng:");
         lblMaThuePhong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         textField_1 = new JTextField();
         textField_1.setColumns(10);
         
         lblMaPhong = new JLabel("Mã phòng:");
         lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         textField_2 = new JTextField();
         textField_2.setColumns(10);
         
         lblLoaiPhong = new JLabel("Loại phòng:");
         lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         textField_3 = new JTextField();
         textField_3.setColumns(10);
         
         textField_4 = new JTextField();
         textField_4.setColumns(10);
         
         lblSoGiuong = new JLabel("Số giường:");
         lblSoGiuong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         lblDonGia = new JLabel("Đơn giá:");
         lblDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         textField_5 = new JTextField();
         textField_5.setColumns(10);
         
         JScrollPane scrollPane = new JScrollPane();
         
         lblMaPhongKT1 = new JLabel("Mã phòng:");
         lblMaPhongKT1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         lblNewLabel_1 = new JLabel("Kiểm tra phòng");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
         
         txtMaPhongKT = new JTextField();
         txtMaPhongKT.setColumns(10);
         
         JButton btnKiemTra = new JButton("Kiểm tra");
         btnKiemTra.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtTimKiemActionPerformed(e);
         	}
         });
         btnKiemTra.setForeground(new Color(255, 255, 255));
         btnKiemTra.setBackground(new Color(52, 152, 219));
         btnKiemTra.setFont(new Font("Dialog", Font.BOLD, 15));
         
         btnCheckIn = new JButton("Xác nhận");
         btnCheckIn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtSaveActionPerformed(e);
         	}
         });
         btnCheckIn.setForeground(Color.WHITE);
         btnCheckIn.setFont(new Font("Dialog", Font.BOLD, 15));
         btnCheckIn.setBackground(new Color(52, 152, 219));
         
         btnHuyCK = new JButton("Huỷ");
         btnHuyCK.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtHuyActionPerformed(e);
         	}
         });
         btnHuyCK.setForeground(Color.WHITE);
         btnHuyCK.setFont(new Font("Dialog", Font.BOLD, 15));
         btnHuyCK.setBackground(new Color(52, 152, 219));
         
         lblTenKH = new JLabel("Tên khách hàng:");
         lblTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         textField_6 = new JTextField();
         textField_6.setColumns(10);
         
         lblNgayDatPhong = new JLabel("Ngày đặt phòng");
         lblNgayDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         lblNgyTrPhng = new JLabel("Ngày trả phòng:");
         lblNgyTrPhng.setFont(new Font("Times New Roman", Font.PLAIN, 14));
         
         JDateChooser dateChooserNgayDat = new JDateChooser();
         
         JDateChooser dateChooserNgayTra = new JDateChooser();

         GroupLayout gl_panel = new GroupLayout(panel);
         gl_panel.setHorizontalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 1143, Short.MAX_VALUE)
         					.addContainerGap())))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(lblMaPhongKT1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(txtMaPhongKT, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
         					.addGap(12))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(btnKiemTra, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
         					.addGap(49))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
         					.addPreferredGap(ComponentPlacement.RELATED)))
         			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap())
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap(765, Short.MAX_VALUE)
         			.addComponent(btnHuyCK, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
         			.addGap(35)
         			.addComponent(btnCheckIn, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
         			.addGap(41))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(191)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(lblSoGiuong, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         					.addGap(6)
         					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(lblLoaiPhong, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         					.addGap(6)
         					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
         				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
         					.addGroup(gl_panel.createSequentialGroup()
         						.addComponent(lblMaPhong, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         						.addPreferredGap(ComponentPlacement.RELATED)
         						.addComponent(textField_2))
         					.addGroup(gl_panel.createSequentialGroup()
         						.addComponent(lblMaThuePhong, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         						.addPreferredGap(ComponentPlacement.RELATED)
         						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))))
         			.addGap(156)
         			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
         					.addGroup(gl_panel.createSequentialGroup()
         						.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         						.addGap(6)
         						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
         					.addGroup(gl_panel.createSequentialGroup()
         						.addComponent(lblNgayDatPhong, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         						.addPreferredGap(ComponentPlacement.RELATED)
         						.addComponent(dateChooserNgayDat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         					.addGroup(gl_panel.createSequentialGroup()
         						.addComponent(lblNgyTrPhng, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         						.addPreferredGap(ComponentPlacement.RELATED)
         						.addComponent(dateChooserNgayTra, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(lblDonGia, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
         					.addGap(6)
         					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
         			.addContainerGap(204, Short.MAX_VALUE))
         );
         gl_panel.setVerticalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(12)
         			.addComponent(lblNewLabel)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(textField, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
         			.addGap(61)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         						.addComponent(lblMaThuePhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
         						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
         					.addGap(18)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addComponent(lblMaPhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addGap(1)
         							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
         					.addGap(18)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addComponent(lblLoaiPhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addGap(1)
         							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
         					.addGap(18)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addComponent(lblSoGiuong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addGap(1)
         							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         								.addComponent(lblDonGia, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
         								.addGroup(gl_panel.createSequentialGroup()
         									.addGap(1)
         									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
         								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addComponent(lblTenKH, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addGap(1)
         							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
         					.addGap(18)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
         						.addComponent(dateChooserNgayDat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         						.addComponent(lblNgayDatPhong, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
         					.addGap(18)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addComponent(dateChooserNgayTra, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
         						.addComponent(lblNgyTrPhng, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
         			.addGap(96)
         			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
         						.addComponent(txtMaPhongKT)
         						.addComponent(lblMaPhongKT1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
         					.addGap(18)
         					.addComponent(btnKiemTra, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
         					.addGap(13))
         				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
         			.addGap(26)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addComponent(btnCheckIn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
         				.addComponent(btnHuyCK, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
         			.addGap(20))
         );
         
         table = new JTable();
         table.setModel(modelTinhTrang);
         scrollPane.setViewportView(table);
         panel.setLayout(gl_panel);
         
        getContentPane().setLayout(layout);
 
        

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatPhongActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
        dispose();
        new PhieuThuePhong().setVisible(true);   
    }//GEN-LAST:event_DatPhongActionPerformed

    private void selfActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        new DSCheckInGUI().setVisible(true);        
    }//GEN-LAST:event_KhachSanActionPerformed

    private void homeActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        dispose();
        new DSCheckInGUI().setVisible(true);
    }//GEN-LAST:event_homeActionPerformed

    private void QuanLiActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_QuanLiActionPerformed
        ThongTinNhanVienBLL bll = new ThongTinNhanVienBLL();
        if (bll.laAdminDangNhap()) {
            // Mở giao diện quản lý
            new QuanLiPhong().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_QuanLiActionPerformed

    private void DatDichVuActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_DatDichVuActionPerformed
        dispose();
        new DatDichVu().setVisible(true);
    }//GEN-LAST:event_DatDichVuActionPerformed
    
    public void napDuLieu(int maPhong) {
        try {
            kttt = ktttBUS.timTheoMaPhong(maPhong);
            if (kttt != null) {
                modelTinhTrang.addRow(new Object[]{
                    kttt.getMaKiemTra(),
                    kttt.getMaPhong(),
                    kttt.getMaNhanVien(),
                    kttt.getNgayKiemTra(),
                    kttt.getMoTaThietHai(),
                    kttt.getChiPhiDenBu()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void jBtTimKiemActionPerformed(ActionEvent e) {
        String maPhongStr = txtMaPhongKT.getText().trim();
        if (maPhongStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã phòng.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int maPhong = Integer.parseInt(maPhongStr);
            
            // Xóa dữ liệu cũ trong bảng trước khi thêm mới
            modelTinhTrang.setRowCount(0);

            // Gọi hàm nạp dữ liệu
            napDuLieu(maPhong);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Mã phòng phải là số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
//    private void hienThiThongTin(int maPhong) {
//        QuanLiPhongDTO phong = phongDAO.timPhongTheoMa(maPhong);
//        ChiTietPhieuThuePhongDTO chiTiet = chiTietDAO.timChiTietTheoMaPhong(maPhong);
//        PhieuThuePhongDTO phieu = phieuThueDAO.timPhieuTheoMa(chiTiet.getMaThuePhong());
//        
//
//        // Gán dữ liệu vào các text field
//        txtMaPhong.setText(String.valueOf(maPhong));
//        txtLoaiPhong.setText(phong.getMaLoaiPhong());
//        txtSoGiuong.setText(String.valueOf(phong.getSoGiuong()));
//        txtDonGia.setText(String.valueOf(phong.getDonGia()));
//        txtMaThuePhong.setText(String.valueOf(phieu.getMaThuePhong()));
//        txtTenKH.setText(khach.getTenKhachHang());
//
//        dateChooserNgayDat.setDate(chiTiet.getNgayDatPhong());
//        dateChooserNgayTra.setDate(chiTiet.getNgayTraPhong());
//    }
//    
    private void jBtSaveActionPerformed(ActionEvent evt) {
        try {
            int maPhong = this.maPhong; 
            int maThuePhong = this.maThuePhong;
            phongDAO.capNhatTrangThaiPhong(maPhong, "Đang sử dụng");
            phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, "Đang thuê");
            checkInOutBLL.updTTCheckInOut(maPhong);
            
            JOptionPane.showMessageDialog(this, "Check-in thành công!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật trạng thái!");
        }
    }
    
    	private void jBtHuyActionPerformed(ActionEvent evt) {
    		int maPhong = this.maPhong;
            KiemTraTinhTrang kiemTraTinhTrang = ktttBUS.timKiemKTTT(maPhong);

            if (kiemTraTinhTrang != null) {
                String moTaThietHai = kiemTraTinhTrang.getMoTaThietHai();
                
                int option = JOptionPane.showConfirmDialog(null, 
                        "Huỷ phòng vì " + moTaThietHai + ". Tiến hành hoàn tiền!", 
                        "Xác nhận huỷ phòng", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    checkInOutBLL.xoaCheckInDTO(maPhong);
                    try {
                    	phieuThueDAO.capNhatTrangThaiPhieu(maPhong, "Đã huỷ");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                    	phongDAO.capNhatTrangThaiPhong(maPhong, "Đang bảo trì");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                       
                }
            }
    	}

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
            for ( LookAndFeelInfo info :  UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                     UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn().setVisible(true);
            }
        });
         
    }
}
