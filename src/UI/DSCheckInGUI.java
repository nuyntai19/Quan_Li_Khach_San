package UI;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import BLL.CheckInOutBLL;
import BLL.CheckInOutTEMP;
import BLL.KiemTraTinhTrangBUS;
import BLL.TaiKhoanBLL;
import BLL.ThongTinNhanVienBLL;
import DAO.ChiTietPhieuThuePhongDAO;
import DAO.PhieuThuePhongDAO;
import DAO.QuanLiPhongDAO;
import DTO.CheckInOutDTO;
import DTO.KiemTraTinhTrang;
import DTO.QuanLiPhongDTO;
import DTO.TaiKhoanDTO;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class DSCheckInGUI extends  JFrame {
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
    private JTextField textTK;
    private JTable table;

	private JScrollPane scrollPane;

	private DefaultTableModel model;
	private final KiemTraTinhTrangBUS ktttBUS = new KiemTraTinhTrangBUS();
	private final QuanLiPhongDAO phongDAO = new QuanLiPhongDAO();
	private final ChiTietPhieuThuePhongDAO chiTietDAO = new ChiTietPhieuThuePhongDAO();
	private final PhieuThuePhongDAO phieuThueDAO = new PhieuThuePhongDAO();
	private final CheckInOutBLL checkInOutBLL = new CheckInOutBLL();
	private JButton btnHuy;
	private JButton btnRefresh;

	private ArrayList<CheckInOutDTO> danhSach;
	private JButton KiemTraTinhTrang;
	private JComboBox cbDK;

	private DlgInOutKTTT dlg;


	public DSCheckInGUI() {
		
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
        		jbtDSDatPhongActionPerformed(e);
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
        setTitle("CHECK IN");
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
         		dispose();
                new KiemTraPhongGUI().setVisible(true);
         	}
         });
         KiemTraTinhTrang.setText("Kiểm tra tình trạng");
         KiemTraTinhTrang.setIcon(new ImageIcon(DSCheckInGUI.class.getResource("/ICON/checkTinhTrang.png")));
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
         
         JLabel lblNewLabel = new JLabel("DANH SÁCH CHECK IN");
         lblNewLabel.setFont(new Font("Segoe UI", 1, 19));
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel.setForeground(new Color(52, 152, 219));
         
         JTextField textField = new JTextField();
         textField.setEditable(false);
         textField.setBackground(new Color(52, 152, 219));
         textField.setColumns(10);
         textField.setBorder(null);
         
         scrollPane = new JScrollPane();
         
         textTK = new JTextField();
         textTK.setColumns(10);
         
         JButton btnTim = new JButton("Tìm");
         btnTim.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtTimKiemActionPerformed(e);
         	}
         });
         btnTim.setForeground(new Color(255, 255, 255));
         btnTim.setBackground(new Color(52, 152, 219));
         btnTim.setFont(new Font("Dialog", Font.BOLD, 14));
         
         JButton btnCheckIn = new JButton("CHECK IN");
         btnCheckIn.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtCheckInActionPerformed(e);
         		loadDataToModel();
         	}
         });
         btnCheckIn.setForeground(new Color(255, 255, 255));
         btnCheckIn.setBackground(new Color(52, 152, 219));
         btnCheckIn.setFont(new Font("Dialog", Font.BOLD, 14));
         
         btnHuy = new JButton("HUỶ");
         btnHuy.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		//jBtHuyActionPerformed(e);
         		jBtHuy2ActionPerformed(e);
         		loadDataToModel();
         	}
         });
         btnHuy.setForeground(Color.WHITE);
         btnHuy.setFont(new Font("Dialog", Font.BOLD, 14));
         btnHuy.setBackground(new Color(52, 152, 219));
         
         btnRefresh = new JButton("");
         btnRefresh.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtRefreshActionPerformed(e);
         	}
         });
         btnRefresh.setOpaque(false);
         btnRefresh.setIcon(new ImageIcon(DSCheckInGUI.class.getResource("/ICON/refresh_40.png")));
         btnRefresh.setFocusPainted(false);
         btnRefresh.setContentAreaFilled(false);
         btnRefresh.setBorderPainted(false);
         btnRefresh.setBackground(Color.WHITE);
         
         cbDK = new JComboBox();
         cbDK.setModel(new DefaultComboBoxModel<>(new String[] { "_", "Mã thuê phòng", "Mã phòng", "Mã khách hàng", "Ngày đặt phòng", "Ngày trả phòng", "Trạng thái"}));
         
         JButton btnKTTT = new JButton("Kiểm tra tình trạng");
         btnKTTT.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtKTTTActionPerformed(e);
         	}
         });
         btnKTTT.setForeground(Color.WHITE);
         btnKTTT.setFont(new Font("Dialog", Font.BOLD, 14));
         btnKTTT.setBackground(new Color(52, 152, 219));

         GroupLayout gl_panel = new GroupLayout(panel);
         gl_panel.setHorizontalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
         				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
         					.addContainerGap())))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(33)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(textTK, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
         					.addGap(18)
         					.addComponent(cbDK, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
         					.addGap(32)
         					.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
         					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(btnCheckIn, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
         					.addGap(18)
         					.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED, 665, Short.MAX_VALUE)
         					.addComponent(btnKTTT, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
         			.addGap(31))
         );
         gl_panel.setVerticalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(12)
         			.addComponent(lblNewLabel)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(textField, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(12)
         					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
         					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
         					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         							.addComponent(btnCheckIn, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
         							.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
         						.addComponent(btnKTTT, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(18)
         					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         						.addComponent(textTK, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
         						.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
         						.addComponent(cbDK, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))))
         			.addPreferredGap(ComponentPlacement.UNRELATED)
         			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap())
         );
         model = new DefaultTableModel(new String[]{
        		 "Mã thuê phòng", "Mã phòng" , "Mã khách hàng", "Ngày đặt phòng", "Ngày trả phòng", "Trạng thái"
 	        }, 0) {
 	            @Override
 	            public boolean isCellEditable(int row, int column) {
 	                return false;
 	            }
 	        };
 	        
         table = new JTable();
         table.setModel(model);
         scrollPane.setViewportView(table);
         
         loadDataToModel();
         
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
    private void jbtDSDatPhongActionPerformed(ActionEvent evt){
    	dispose();
        new DanhSachDatPhongGUI().setVisible(true);
    }
    
    
    private void jBtTimKiemActionPerformed(ActionEvent evt) {
    	String loaiTim = cbDK.getSelectedItem().toString(); // Lấy tiêu chí
        String tuKhoa = textTK.getText().trim(); // Lấy từ khóa tìm

        try {
            ArrayList<CheckInOutDTO> ketQua = checkInOutBLL.timChiTietCheckInOut(loaiTim, tuKhoa);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); 

            for (CheckInOutDTO ct : ketQua) {
                model.addRow(new Object[]{
                    ct.getMaThuePhong(),        
                    ct.getMaPhong(),            
                    ct.getMaKhachHang(),        
                    ct.getNgayDatPhong(),       
                    ct.getNgayTraPhong(),    
                    ct.getTrangThai()         
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + ex.getMessage());
        }
    }
    
    
    
    private void loadDataToModel() {
        model.setRowCount(0);
        try {
        	danhSach = checkInOutBLL.layDanhSachCheckInHopLe();
        	if (danhSach != null) 
        	{
	        	checkInOutBLL.kiemTraQuaHanCheckIn(danhSach);
	        	
				for (CheckInOutDTO c : danhSach) {
				    model.addRow(new Object[]{
				    	c.getMaThuePhong(),
				        c.getMaPhong(),
				        c.getMaKhachHang(),
				        c.getNgayDatPhong(),
				        c.getNgayTraPhong(),
				        c.getTrangThai()
				    });
				}
			} else JOptionPane.showMessageDialog(null, "danh sách CheckInOut rỗng.");	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
    }
    
    private void jBtRefreshActionPerformed(ActionEvent evt){
    	try {
            loadDataToModel();
            textTK.setText("");
            JOptionPane.showMessageDialog(null, "Làm mới thành công.");	
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi làm mới dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    private boolean KTPhong(int maPhong, int maThuePhong) throws SQLException {
        KiemTraTinhTrang kt = ktttBUS.timKTTT(maPhong, maThuePhong);

        if (kt != null) 
        {
            String moTaThietHai = kt.getMoTaThietHai();
            if (moTaThietHai.equalsIgnoreCase("Khong"))
                return true;
            else {
	            int option = JOptionPane.showConfirmDialog(null, 
	                    "Phòng gặp sự cố: " + moTaThietHai + ".\nHuỷ phòng và hoàn tiền?", 
	                    "Xác nhận huỷ phòng", JOptionPane.OK_CANCEL_OPTION);
	
	            if (option == JOptionPane.OK_OPTION) 
	            {
	                checkInOutBLL.xoaCheckInDTO(maPhong);
	                try {
	                    phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, "Da huy");
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	                try {
	                    phongDAO.capNhatTrangThaiPhong(maPhong, "Dang bao tri");
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	                return false;
	            } 
	            else return false;
            }
        }
        return true;
    }
    
 // kt Mô tả thiệt hại và checkin
    private void jBtCheckInActionPerformed(ActionEvent evt) {
    	int selectedRow = table.getSelectedRow(); 
    	
    	if (selectedRow != -1) { 
    	    try {
    	    	int maThuePhong = Integer.parseInt(table.getValueAt(selectedRow, 0).toString()); 
    	    	int maPhong = Integer.parseInt(table.getValueAt(selectedRow, 1).toString());
    	    	String tt = table.getValueAt(table.getSelectedRow(), 5).toString();

    	        
    	        if( tt.equalsIgnoreCase("Qua han check-in")) {
    	        	JOptionPane.showMessageDialog(this, "Phòng " + maPhong 
    	        			+" đã quá hạn thời hạn check-in! \n\n	Vui lòng đặt phòng mới.");
    	        	return;
    	        }
    	        if (phongDAO.timPhongTheoMa(maPhong).getTrangThai().equalsIgnoreCase("Dang su dung")) {
    	        	//System.out.print(rootPaneCheckingEnabled);
    	        	JOptionPane.showMessageDialog(this, "Phòng " + maPhong 
    	        				+" đang được sử dụng không thể check-in");
    	        	return;
    	        }
    	        // nếu phòng đó ko "Dang su dung thì moi cho check in"
    	        if (!KTPhong(maPhong, maThuePhong)) {
    	            return;
    	        }
    	        else {
	    	        phongDAO.capNhatTrangThaiPhong(maPhong, "Dang su dung");
	    	        phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, "Dang thue");
	    	        
	    	        // add vào ds tạm
//	    	        CheckInOutDTO c = new CheckInOutDTO();
//	    	        c = checkInOutBLL.timCheckInOut(maPhong);
//	                c.setTrangThai("Da check-in");
	    	        JOptionPane.showMessageDialog(this, "Check-in thành công!");
	                
	                loadDataToModel();
    	        }
    	    } catch (SQLException ex) {
    	        ex.printStackTrace();
    	        JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật trạng thái!");
    	    } catch (NumberFormatException ex) {
    	        JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ!");
    	    }
    	} else {
    	    JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng trong bảng!");
    	}

    }

   
    private void jBtHuy2ActionPerformed(ActionEvent evt) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn phòng cần huỷ.");
	        return;
	    }
	
	    int maThuePhong = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
	    int maPhong = Integer.parseInt(table.getValueAt(selectedRow, 1).toString());
	    String trangThai = table.getValueAt(selectedRow, 5).toString();
	
	    int confirm = JOptionPane.showConfirmDialog(null, 
	        "Bạn có chắc chắn muốn huỷ phòng này?", 
	        "Xác nhận huỷ phòng", JOptionPane.OK_CANCEL_OPTION);
	
	    if (confirm != JOptionPane.OK_OPTION) return;
	
	    try {
	        if ("Qua han check-in".equalsIgnoreCase(trangThai)) {
	            // Không cần kiểm tra tình trạng phòng vì khách chưa đến
	            phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, "Da huy");
	            phongDAO.capNhatTrangThaiPhong(maPhong, "Trong"); // hoặc "Dang bao tri" nếu có lý do nội bộ
	            JOptionPane.showMessageDialog(null, "Đã huỷ phòng quá hạn check-in thành công.");
	            return;
	        }
	
	        KiemTraTinhTrang kttt = ktttBUS.timKTTT(maPhong, maThuePhong);
	        String moTa = (kttt != null) ? kttt.getMoTaThietHai() : "Khong";
	
	        if ("Dang cho xac nhan".equalsIgnoreCase(trangThai)) 
	        {
	            if (!"Khong".equalsIgnoreCase(moTa)) 
	            {
	                int opt = JOptionPane.showConfirmDialog(null,
	                    "Phòng gặp sự cố: " + moTa + ".\nHuỷ phòng và hoàn tiền?",
	                    "Xác nhận huỷ phòng", JOptionPane.YES_NO_OPTION);
	
	                if (opt == JOptionPane.YES_OPTION) {
	                    phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, "Da huy");
	                    phongDAO.capNhatTrangThaiPhong(maPhong, "Dang bao tri");
	                    JOptionPane.showMessageDialog(null, "Đã huỷ phòng thành công.");
	                }
	            } 
	            else {
	                phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, "Da huy");
	                phongDAO.capNhatTrangThaiPhong(maPhong, "Trong");
	                JOptionPane.showMessageDialog(null, "Đã huỷ phòng thành công.");
	            }
	        }
	
	        else {
	            // Trường hợp mặc định khác trạng thái đã nêu
	            if (!KTPhong(maPhong, maThuePhong)) return;
	            phieuThueDAO.capNhatTrangThaiPhieu(maThuePhong, "Da huy");
	            phongDAO.capNhatTrangThaiPhong(maPhong, "Trong");
	            checkInOutBLL.xoaCheckInDTO(maPhong);
	            JOptionPane.showMessageDialog(null, "Đã huỷ phòng thành công.");
	        }
	
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Lỗi khi huỷ phòng.");
	    }
    }



    private void jBtKTTTActionPerformed(ActionEvent e) {
    	int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
        	String maPhong = String.valueOf(table.getValueAt(selectedRow, 1));
        	String maThuePhong = String.valueOf(table.getValueAt(selectedRow, 0));

            // dialog
            dlg = new DlgInOutKTTT(model, table.getSelectedRow());
            dlg.setModelAndRow(model, selectedRow);
            dlg.setDataAddKTTT(maPhong, maThuePhong);
            dlg.setLocationRelativeTo(null);
            dlg.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                	loadDataToModel();
                }
            });
            dlg.setVisible(true);
            
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
            Logger.getLogger(DSCheckInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DSCheckInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DSCheckInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DSCheckInGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSCheckInGUI().setVisible(true);
            }
        });
         
    }
}
