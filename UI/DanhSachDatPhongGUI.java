package UI;

import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class DanhSachDatPhongGUI extends  JFrame {
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
    private JTable table;
    private JTextField textField_1;
    private JLabel lblNewLabel_2;
    private JTextField textField_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JButton btnNewButton_4;
	private DefaultTableModel model;
	private boolean daThemCheckbox = false;
	public DanhSachDatPhongGUI() {
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
        setTitle("DanhSachDatPhong");
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
         					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1163, GroupLayout.PREFERRED_SIZE)))
         			.addContainerGap())
         );
         layout.setVerticalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
         				.addGroup(layout.createSequentialGroup()
         					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         				.addComponent(panel, 0, 0, Short.MAX_VALUE))
         			.addGap(125))
         );
         
         JLabel lblNewLabel = new JLabel("DANH SÁCH ĐẶT PHÒNG");
         lblNewLabel.setFont(new Font("Segoe UI", 1, 19));
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel.setForeground(new Color(52, 152, 219));
         
         JTextField textField = new JTextField();
         textField.setEditable(false);
         textField.setBackground(new Color(52, 152, 219));
         textField.setColumns(10);
         textField.setBorder(null);
         
         JScrollPane scrollPane = new JScrollPane();
         
         JButton btnNewButton = new JButton("Tìm");
         btnNewButton.setForeground(new Color(255, 255, 255));
         btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
         btnNewButton.setBackground(new Color(52, 152, 219));
         
         JLabel lblNewLabel_1 = new JLabel("Mã đặt phòng:");
         lblNewLabel_1.setFont(new Font("Times New Roman", 1, 14));
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_1.setBackground(new Color(255, 255, 255));
         
         textField_1 = new JTextField();
         textField_1.setColumns(10);
         
         lblNewLabel_2 = new JLabel("Mã phòng:");
         lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_2.setFont(new Font("Times New Roman", 1, 14));
         lblNewLabel_2.setBackground(Color.WHITE);
         
         textField_2 = new JTextField();
         textField_2.setColumns(10);
         
         lblNewLabel_3 = new JLabel("Mã khách hàng:");
         lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_3.setBackground(Color.WHITE);
         
         lblNewLabel_4 = new JLabel("Tên khách hàng:");
         lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_4.setBackground(Color.WHITE);
         
         textField_3 = new JTextField();
         textField_3.setColumns(10);
         
         textField_4 = new JTextField();
         textField_4.setColumns(10);
         
         JButton btnNewButton_1 = new JButton("Sửa");
         btnNewButton_1.setForeground(Color.WHITE);
         btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 15));
         btnNewButton_1.setBackground(new Color(52, 152, 219));
         
         btnNewButton_2 = new JButton("Xoá");
         btnNewButton_2.setForeground(Color.WHITE);
         btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 15));
         btnNewButton_2.setBackground(new Color(52, 152, 219));
         
         btnNewButton_3 = new JButton("Chọn nhiều");
         btnNewButton_3.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		if (!daThemCheckbox) {
         	        themCotCheckbox();
         	        daThemCheckbox = true;
         	       btnNewButton_3.setText("Huỷ chọn nhiều"); // đổi tên nút cho trực quan
         	    } else {
         	        xoaCotCheckbox();
         	        daThemCheckbox = false;
         	       btnNewButton_3.setText("Chọn nhiều"); // đổi tên lại như ban đầu
         	    }
         	}
         });
         btnNewButton_3.setForeground(Color.WHITE);
         btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 15));
         btnNewButton_3.setBackground(new Color(52, 152, 219));
         
         lblNewLabel_5 = new JLabel("Từ:");
         lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_5.setBackground(Color.WHITE);
         
         JDateChooser dateChooser = new JDateChooser();
         
         lblNewLabel_6 = new JLabel("Đến:");
         lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_6.setBackground(Color.WHITE);
         
         JDateChooser dateChooser_1 = new JDateChooser();
         
         lblNewLabel_7 = new JLabel("Ngày trả phòng:");
         lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_7.setBackground(Color.WHITE);
         
         lblNewLabel_8 = new JLabel("Ngày trả phòng:");
         lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_8.setBackground(Color.WHITE);
         
         lblNewLabel_9 = new JLabel("Từ:");
         lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_9.setBackground(Color.WHITE);
         
         lblNewLabel_10 = new JLabel("Đến:");
         lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_10.setBackground(Color.WHITE);
         
         JDateChooser dateChooser_2 = new JDateChooser();
         
         JDateChooser dateChooser_3 = new JDateChooser();
         
         btnNewButton_4 = new JButton("RESET");
         btnNewButton_4.setForeground(Color.WHITE);
         btnNewButton_4.setFont(new Font("Dialog", Font.BOLD, 15));
         btnNewButton_4.setBackground(new Color(52, 152, 219));
         
         JLabel lblNewLabel_11 = new JLabel("Trạng thái:");
         lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
         lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 14));
         lblNewLabel_11.setBackground(Color.WHITE);
         
         JCheckBox chckbxNewCheckBox = new JCheckBox("Đã check-in");
         chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
         
         JCheckBox chckbxCheckout = new JCheckBox("Đã check-out");
         chckbxCheckout.setFont(new Font("Times New Roman", Font.BOLD, 14));
         
         JCheckBox chckbxHonThnh = new JCheckBox("Đã hoàn thành");
         chckbxHonThnh.setFont(new Font("Times New Roman", Font.BOLD, 14));

         GroupLayout gl_panel = new GroupLayout(panel);
         gl_panel.setHorizontalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
         					.addContainerGap())
         				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
         					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         								.addGroup(gl_panel.createSequentialGroup()
         									.addGap(18)
         									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
         										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
         										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
         										.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
         									.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
         									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
         										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
         										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
         										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
         									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         										.addGroup(gl_panel.createSequentialGroup()
         											.addGap(24)
         											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
         												.addComponent(lblNewLabel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         												.addComponent(lblNewLabel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
         											.addPreferredGap(ComponentPlacement.RELATED)
         											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         												.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
         												.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
         										.addGroup(gl_panel.createSequentialGroup()
         											.addGap(18)
         											.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
         									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         										.addGroup(gl_panel.createSequentialGroup()
         											.addGap(25)
         											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         												.addGroup(gl_panel.createSequentialGroup()
         													.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         													.addPreferredGap(ComponentPlacement.RELATED)
         													.addComponent(dateChooser_3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
         												.addGroup(gl_panel.createSequentialGroup()
         													.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         													.addPreferredGap(ComponentPlacement.RELATED)
         													.addComponent(dateChooser_2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))
         										.addGroup(gl_panel.createSequentialGroup()
         											.addGap(16)
         											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
         									.addGap(25)
         									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         										.addComponent(chckbxCheckout, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
         										.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
         										.addComponent(chckbxHonThnh, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
         										.addGroup(gl_panel.createSequentialGroup()
         											.addGap(1)
         											.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
         									.addGap(69))
         								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
         									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
         									.addGap(381)))
         							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
         								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
         								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
         								.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))))
         					.addGap(17))))
         );
         gl_panel.setVerticalGroup(
         	gl_panel.createParallelGroup(Alignment.TRAILING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(12)
         					.addComponent(lblNewLabel)
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
         					.addGap(18)
         					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
         							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
         						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addPreferredGap(ComponentPlacement.RELATED)
         							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
         								.addComponent(lblNewLabel_11, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))))
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
         							.addPreferredGap(ComponentPlacement.RELATED)
         							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
         							.addPreferredGap(ComponentPlacement.RELATED)
         							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
         						.addGroup(gl_panel.createSequentialGroup()
         							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         								.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
         								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
         									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
         									.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
         								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
         								.addComponent(dateChooser_2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
         								.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
         							.addPreferredGap(ComponentPlacement.RELATED)
         							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         								.addGroup(gl_panel.createSequentialGroup()
         									.addComponent(chckbxCheckout, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
         									.addPreferredGap(ComponentPlacement.RELATED)
         									.addComponent(chckbxHonThnh, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
         								.addComponent(dateChooser_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
         								.addGroup(gl_panel.createSequentialGroup()
         									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
         										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
         										.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
         									.addPreferredGap(ComponentPlacement.RELATED)
         									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
         										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
         								.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
         								.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
         							.addGap(48)))
         					.addGap(43))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(251)
         					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
         					.addGap(26)))
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap())
         );
         
         table = new JTable();
         table.setBackground(new Color(255, 255, 255));
         scrollPane.setViewportView(table);
         model = new DefaultTableModel();
         model.setColumnIdentifiers(new String[] {
        		 "Mã đặt phòng", "Mã phòng", "Mã khách hàng", "Tên khách hàng", "Ngày nhận phòng", "Ngày trả phòng", "Trạng thái"
         });

         table.setModel(model);

         panel.setLayout(gl_panel);
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatPhongActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
        dispose();
        new DatPhong().setVisible(true);   
    }//GEN-LAST:event_DatPhongActionPerformed

    private void selfActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        new DanhSachDatPhongGUI().setVisible(true);        
    }//GEN-LAST:event_KhachSanActionPerformed

    
    private void homeActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        dispose();
        new DanhSachDatPhongGUI().setVisible(true);
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

    private void themCotCheckbox() {
        TableColumn checkColumn = new TableColumn();
        checkColumn.setHeaderValue("Chọn");
        checkColumn.setCellEditor(new DefaultCellEditor(new JCheckBox()));
        checkColumn.setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                JCheckBox checkBox = new JCheckBox();
                if (value instanceof Boolean) {
                    checkBox.setSelected((Boolean) value);
                }
                checkBox.setHorizontalAlignment(SwingConstants.CENTER);
                return checkBox;
            }
        });

        table.addColumn(checkColumn);
        ((DefaultTableModel) table.getModel()).addColumn("Chọn", new Boolean[table.getRowCount()]);
    }
    private void xoaCotCheckbox() {
        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            if ("Chọn".equals(columnModel.getColumn(i).getHeaderValue())) {
                columnModel.removeColumn(columnModel.getColumn(i));
                break;
            }
        }

        // Xoá khỏi model nếu muốn
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int colIndex = model.findColumn("Chọn");
        if (colIndex != -1) {
            model.setColumnCount(model.getColumnCount() - 1); // hoặc dùng logic khác nếu cần chính xác index
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
            Logger.getLogger(DanhSachDatPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DanhSachDatPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DanhSachDatPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DanhSachDatPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachDatPhongGUI().setVisible(true);
            }
        });
    }
}
