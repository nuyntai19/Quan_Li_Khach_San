package UI;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.sql.*;
import com.toedter.calendar.JDateChooser;

import BLL.ChiTietPhieuThuePhongBLL;
import BLL.PhieuThuePhongBLL;
import BLL.ThongTinNhanVienBLL;
import DTO.CheckInOutDTO;
import DTO.ChiTietPhieuThuePhongDTO;
import DTO.PhieuThuePhongDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import UI.QuanLiPhong;

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
	private JTextField textCTPTP;
	private JTextField textField_2;
	private JTable tableCTPhieuThue;
	private JTable tablePhieuThue;
	private JTextField textPTP;
	private JLabel lblNewLabel_1;

	private JScrollPane scrollPane_1;
	private final PhieuThuePhongBLL phieuThueBLL = new PhieuThuePhongBLL();
	private final ChiTietPhieuThuePhongBLL ctphieuThueBLL = new ChiTietPhieuThuePhongBLL();

	private JScrollPane scrollPane;

	private DefaultTableModel modelPhieuThue;
	private DefaultTableModel modelChiTietPhieuThue;
	private JLabel lblNewLabel_2;
	private JButton KiemTraTinhTrang;
	private JButton btnRefreshCTPTP;
	private JButton btnRefreshPTP;

	private JComboBox cbDKPT;

	private JComboBox cbDKCTPT;
	
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
        jPanel3 = new  JPanel();
        DatPhong = new  JButton();
        CheckIn = new  JButton();
        CheckIn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                new DSCheckInGUI().setVisible(true);
        	}
        });
        CheckOut = new  JButton();
        CheckOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                new DSCheckOutGUI().setVisible(true);
        	}
        });
        HoaDonDatPhong = new  JButton();
        HoaDonDatPhong.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                try {
					new DanhSachHoaDon().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        DSDatPhong = new  JButton();
        DSDatPhong.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                new DanhSachDatPhongGUI().setVisible(true);
        	}
        });
        DSKhachHang = new  JButton();
        DSKhachHang.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                new DanhSachKhachHang().setVisible(true);
        	}
        });
        DSDatDichVu = new  JButton();
        DSDatDichVu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                new DanhSachDatDichVu().setVisible(true);
        	}
        });
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

         GroupLayout jPanel1Layout = new  GroupLayout(jPanel1);
         jPanel1Layout.setHorizontalGroup(
         	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
         		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
         			.addGap(16)
         			.addComponent(Tittle, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED, 1086, Short.MAX_VALUE)
         			.addComponent(self, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap())
         );
         jPanel1Layout.setVerticalGroup(
         	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
         		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
         				.addComponent(self, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
         				.addComponent(Tittle, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
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
         
         KiemTraTinhTrang = new JButton();
         KiemTraTinhTrang.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		KiemTinhTrangActionPerformed(e);
         	}
         });
         KiemTraTinhTrang.setText("Kiểm tra tình trạng");
         KiemTraTinhTrang.setIcon(new ImageIcon(DanhSachDatPhongGUI.class.getResource("/ICON/checkTinhTrang.png")));
         KiemTraTinhTrang.setHorizontalAlignment(SwingConstants.LEFT);
         KiemTraTinhTrang.setFont(new Font("Dialog", Font.BOLD, 14));

         GroupLayout jPanel3Layout = new  GroupLayout(jPanel3);
         jPanel3Layout.setHorizontalGroup(
         	jPanel3Layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(jPanel3Layout.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
         				.addComponent(DatPhong, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(CheckIn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(HoaDonDatPhong, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(CheckOut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(DSDatPhong, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(DSKhachHang, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(DSDatDichVu, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(DatDichVu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
         				.addComponent(KiemTraTinhTrang, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
         			.addContainerGap())
         );
         jPanel3Layout.setVerticalGroup(
         	jPanel3Layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(jPanel3Layout.createSequentialGroup()
         			.addContainerGap()
         			.addComponent(DatPhong, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(CheckIn, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(CheckOut, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(DSDatPhong, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(HoaDonDatPhong, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(DSKhachHang, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(DSDatDichVu, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(DatDichVu, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(KiemTraTinhTrang, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap(148, Short.MAX_VALUE))
         );
        jPanel3.setLayout(jPanel3Layout);

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
         
         textCTPTP = new JTextField();
         textCTPTP.setFont(new Font("Times New Roman", Font.BOLD, 14));
         textCTPTP.setColumns(10);
         
         JButton btnTImCTPT = new JButton("Tìm");
         btnTImCTPT.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtTimKiemCTPTActionPerformed(e);
         	}
         });
         btnTImCTPT.setForeground(new Color(255, 255, 255));
         btnTImCTPT.setBackground(new Color(52, 152, 219));
         btnTImCTPT.setFont(new Font("Dialog", Font.BOLD, 14));
         
         scrollPane = new JScrollPane();
         
         textField_2 = new JTextField();
         textField_2.setEditable(false);
         textField_2.setColumns(10);
         textField_2.setBorder(null);
         textField_2.setBackground(new Color(52, 152, 219));
         
         scrollPane_1 = new JScrollPane();
         
         textPTP = new JTextField();
         textPTP.setColumns(10);
         
         JButton btnTimPT = new JButton("Tìm");
         btnTimPT.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtTimKiemPTActionPerformed(e);
         	}
         });
         btnTimPT.setBackground(new Color(52, 152, 219));
         btnTimPT.setFont(new Font("Dialog", Font.BOLD, 14));
         btnTimPT.setForeground(new Color(255, 255, 255));
         
         lblNewLabel_1 = new JLabel("Danh sách phiếu thuê:");
         lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
         
         lblNewLabel_2 = new JLabel("Danh sách chi tiết phiếu thuê:");
         lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
         
         btnRefreshCTPTP = new JButton("");
         btnRefreshCTPTP.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtRefreshCTPTPActionPerformed(e);
         	}
         });
         btnRefreshCTPTP.setOpaque(false);
         btnRefreshCTPTP.setIcon(new ImageIcon(DanhSachDatPhongGUI.class.getResource("/ICON/refresh_40.png")));
         btnRefreshCTPTP.setFocusPainted(false);
         btnRefreshCTPTP.setContentAreaFilled(false);
         btnRefreshCTPTP.setBorderPainted(false);
         btnRefreshCTPTP.setBackground(Color.WHITE);
         
         btnRefreshPTP = new JButton("");
         btnRefreshPTP.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtRefreshPTPActionPerformed(e);
         	}
         });
         btnRefreshPTP.setOpaque(false);
         btnRefreshPTP.setIcon(new ImageIcon(DanhSachDatPhongGUI.class.getResource("/ICON/refresh_40.png")));
         btnRefreshPTP.setFocusPainted(false);
         btnRefreshPTP.setContentAreaFilled(false);
         btnRefreshPTP.setBorderPainted(false);
         btnRefreshPTP.setBackground(Color.WHITE);
         
         cbDKPT = new JComboBox();
         cbDKPT.setModel(new DefaultComboBoxModel<>(new String[] { "_", "Mã thuê phòng", "Mã khách hàng",
        		 "Mã nhân viên", "Ngày lập phiếu", "Tổng tiền", "Trạng thái"}));
         
         cbDKCTPT = new JComboBox();
         cbDKCTPT.setModel(new DefaultComboBoxModel<>(new String[] { "_", "Mã đặt phòng", "Mã phòng",
        		 "Ngày đặt phòng", "Ngày trả phòng", "Giá phòng", "Thành tiền"}));

         GroupLayout gl_panel = new GroupLayout(panel);
         gl_panel.setHorizontalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
         					.addContainerGap())))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(47)
         			.addComponent(textPTP, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
         			.addGap(2)
         			.addComponent(cbDKPT, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.UNRELATED)
         			.addComponent(btnTimPT, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED, 472, Short.MAX_VALUE)
         			.addComponent(btnRefreshPTP, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
         			.addGap(37))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1143, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap(22, Short.MAX_VALUE))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(50)
         					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(58)
         					.addComponent(textCTPTP, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(cbDKCTPT, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
         					.addGap(16)
         					.addComponent(btnTImCTPT, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
         			.addGap(460)
         			.addComponent(btnRefreshCTPTP, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
         			.addGap(38))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(41)
         					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED, 930, GroupLayout.PREFERRED_SIZE))
         				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 1151, GroupLayout.PREFERRED_SIZE))
         			.addContainerGap())
         );
         gl_panel.setVerticalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(12)
         			.addComponent(lblNewLabel)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(textField, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.UNRELATED)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         							.addComponent(textPTP, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
         							.addComponent(btnTimPT, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
         						.addComponent(btnRefreshPTP, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
         				.addComponent(cbDKPT, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
         			.addGap(12)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         							.addComponent(textCTPTP, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
         							.addComponent(btnTImCTPT, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
         						.addComponent(cbDKCTPT, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
         					.addPreferredGap(ComponentPlacement.RELATED)
         					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(18)
         					.addComponent(btnRefreshCTPTP, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
         			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
         			.addGap(14))
         );
         
         modelPhieuThue = new DefaultTableModel(new Object[][]{}, new String[] {
        		 "Mã thuê phòng", "Mã khách hàng", "Mã nhân viên", "Ngày lập phiếu", "Tổng tiền", "Trạng thái"
     	    });
         tablePhieuThue = new JTable(modelPhieuThue);
         scrollPane_1.setViewportView(tablePhieuThue);
         loadDataPhieuThue();
        
         modelChiTietPhieuThue = new DefaultTableModel(new Object[][]{}, new String[]{
        	        "ID","Mã đặt phòng", "Mã phòng", "Ngày đặt phòng", "Ngày trả phòng", "Giá phòng", "Thành tiền"
        	    });
         tableCTPhieuThue = new JTable(modelChiTietPhieuThue);
         scrollPane.setViewportView(tableCTPhieuThue);
         loadDataChiTietPhieuThue();
       

         panel.setLayout(gl_panel);
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatPhongActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
        dispose();
        new QuanLiPhong().setVisible(true);   
    }//GEN-LAST:event_DatPhongActionPerformed

    private void selfActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_selfActionPerformed
        ThongTinNhanVien thongTin = new ThongTinNhanVien(null, true);
        thongTin.setVisible(true);
    }//GEN-LAST:event_selfActionPerformed

    private void KhachSanActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_KhachSanActionPerformed
        dispose();
        new DanhSachDatPhongGUI().setVisible(true);        
    }//GEN-LAST:event_KhachSanActionPerformed

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

    private void KiemTinhTrangActionPerformed(  ActionEvent evt) {//GEN-FIRST:event_DatDichVuActionPerformed
        dispose();
        new KiemTraPhongGUI().setVisible(true);
    }
    
    private void jBtTimKiemPTActionPerformed(ActionEvent evt) {
    	String loaiTim = cbDKPT.getSelectedItem().toString(); // Lấy tiêu chí
        String tuKhoa = textPTP.getText().trim(); // Lấy từ khóa tìm

        try {
            ArrayList<PhieuThuePhongDTO> ketQua = phieuThueBLL.timChiTietPhieuThuePhong(loaiTim, tuKhoa);

            DefaultTableModel model = (DefaultTableModel) tablePhieuThue.getModel();
            model.setRowCount(0); 

            for (PhieuThuePhongDTO phieuThue : ketQua) {
                model.addRow(new Object[]{
            		phieuThue.getMaThuePhong(),
                    phieuThue.getMaKhachHang(),
                    phieuThue.getMaNhanVien(),
                    phieuThue.getNgayLapPhieu(),
                    phieuThue.getTongTien(),
                    phieuThue.getTrangThai()         
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + ex.getMessage());
        }
    }
    private void jBtTimKiemCTPTActionPerformed(ActionEvent evt) {
    	String loaiTim = cbDKCTPT.getSelectedItem().toString(); // Lấy tiêu chí
        String tuKhoa = textCTPTP.getText().trim(); // Lấy từ khóa tìm

        try {
            ArrayList<ChiTietPhieuThuePhongDTO> ketQua = ctphieuThueBLL.timChiTiet(loaiTim, tuKhoa);

            DefaultTableModel model = (DefaultTableModel) tableCTPhieuThue.getModel();
            model.setRowCount(0); 

            for (ChiTietPhieuThuePhongDTO chiTiet : ketQua) {
                model.addRow(new Object[]{
            		chiTiet.getMaThuePhong(),
                    chiTiet.getMaPhong(),
                    chiTiet.getNgayDatPhong(),
                    chiTiet.getNgayTraPhong(),
                    chiTiet.getGiaPhong(),
                    chiTiet.getThanhTien()        
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + ex.getMessage());
        }
    }
    
    private void jBtRefreshPTPActionPerformed(ActionEvent evt){
    	try {
            loadDataPhieuThue();
            textPTP.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi làm mới dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void loadDataPhieuThue() {
        try {
            ArrayList<PhieuThuePhongDTO> dsPhieuThue = phieuThueBLL.layDanhSachPhieuThue();
            modelPhieuThue.setRowCount(0);
            
            for (PhieuThuePhongDTO phieuThue : dsPhieuThue) {
                Object[] row = new Object[]{
                    phieuThue.getMaThuePhong(),
                    phieuThue.getMaKhachHang(),
                    phieuThue.getMaNhanVien(),
                    phieuThue.getNgayLapPhieu(),
                    phieuThue.getTongTien(),
                    phieuThue.getTrangThai()
                };
                modelPhieuThue.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu Phiếu Thuê Phòng.");
        }
    }

    
    private void jBtRefreshCTPTPActionPerformed(ActionEvent evt){
    	try {
            loadDataChiTietPhieuThue();
            textCTPTP.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi làm mới dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void loadDataChiTietPhieuThue() {
        try {
            ArrayList<ChiTietPhieuThuePhongDTO> dsChiTietPhieuThue = ctphieuThueBLL.layDanhSachChiTiet();
            modelChiTietPhieuThue.setRowCount(0);
            
            for (ChiTietPhieuThuePhongDTO chiTiet : dsChiTietPhieuThue) {
                Object[] row = new Object[]{
                	chiTiet.getId(),
                    chiTiet.getMaThuePhong(),
                    chiTiet.getMaPhong(),
                    chiTiet.getNgayDatPhong(),
                    chiTiet.getNgayTraPhong(),
                    chiTiet.getGiaPhong(),
                    chiTiet.getThanhTien()
                };
                modelChiTietPhieuThue.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu Chi Tiết Phiếu Thuê Phòng.");
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
