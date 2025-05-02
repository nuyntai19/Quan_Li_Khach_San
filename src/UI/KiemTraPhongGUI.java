package UI;

import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;

import BLL.KiemTraTinhTrangBUS;
import BLL.ThongTinNhanVienBLL;
import DTO.CheckInOutDTO;
import DTO.KiemTraTinhTrang;

public class KiemTraPhongGUI extends  JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<KiemTraTinhTrang> dsKTTT = new ArrayList<>();
	private final KiemTraTinhTrangBUS ktttBUS;
	
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
    private JScrollPane scrollPane;
    private JTable table;

	private DefaultTableModel model;
	private JButton btnRefresh;
	private DlgKTTT dlg;
	private JButton btnSua;
	private String maPhong;
	private JTextField textFieldTK;
	private JComboBox cbDK;
	public KiemTraPhongGUI() {
	    ktttBUS = new KiemTraTinhTrangBUS();
	   

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
        CheckOut = new  JButton();
        HoaDonDatPhong = new  JButton();
        DSDatPhong = new  JButton();
        DSDatPhong.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                new KiemTraPhongGUI().setVisible(true);
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
        setTitle("KiemTraDatPhong");
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
         
         JButton KiemTraTinhTrang = new JButton();
         KiemTraTinhTrang.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		KiemTinhTrangActionPerformed(e);
         	}
         });
         KiemTraTinhTrang.setText("Kiểm tra tình trạng");
         KiemTraTinhTrang.setIcon(new ImageIcon(KiemTraPhongGUI.class.getResource("/ICON/checkTinhTrang.png")));
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
         
         JLabel lblNewLabel = new JLabel("KIỂM TRA PHÒNG");
         lblNewLabel.setFont(new Font("Segoe UI", 1, 19));
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel.setForeground(new Color(52, 152, 219));
         
         JTextField textField = new JTextField();
         textField.setEditable(false);
         textField.setBackground(new Color(52, 152, 219));
         textField.setColumns(10);
         textField.setBorder(null);
         
         scrollPane = new JScrollPane();
         
         btnRefresh = new JButton("");
         btnRefresh.setIcon(new ImageIcon(KiemTraPhongGUI.class.getResource("/ICON/refresh_40.png")));
         btnRefresh.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtRefreshActionPerformed(e);
         	}
         });
         btnRefresh.setBackground(new Color(255, 255, 255));
         btnRefresh.setContentAreaFilled(false);  // tắt nền
         btnRefresh.setBorderPainted(false);      // tắt viền
         btnRefresh.setFocusPainted(false);       // tắt viền khi focus
         btnRefresh.setOpaque(false);
         
         JButton btnThem = new JButton("Thêm");
         btnThem.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtThemRowActionPerformed(e);
         	}
         });
         btnThem.setForeground(Color.WHITE);
         btnThem.setFont(new Font("Dialog", Font.BOLD, 15));
         btnThem.setBackground(new Color(52, 152, 219));
         
         JButton btnNewButton_2 = new JButton("Tìm");
         btnNewButton_2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtTimKiemActionPerformed(e);
         	}
         });
         btnNewButton_2.setBackground(new Color(52, 152, 219));
         btnNewButton_2.setForeground(new Color(255, 255, 255));
         btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
         
         JButton btnXoa = new JButton("Xoá");
         btnXoa.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtDeleteActionPerformed(e);
         	}
         });
         btnXoa.setForeground(Color.WHITE);
         btnXoa.setFont(new Font("Dialog", Font.BOLD, 15));
         btnXoa.setBackground(new Color(52, 152, 219));
         
         btnSua = new JButton("Sửa");
         btnSua.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		jBtSuaActionPerformed(e);
         	}
         });
         btnSua.setForeground(Color.WHITE);
         btnSua.setFont(new Font("Dialog", Font.BOLD, 15));
         btnSua.setBackground(new Color(52, 152, 219));
         
         textFieldTK = new JTextField();
         textFieldTK.setColumns(10);
         
         cbDK = new JComboBox();
         cbDK.setModel(new DefaultComboBoxModel<>(new String[] { "_", "Mã kiểm tra", "Mã phòng", "Mã thuê phòng",
        		 	"Mã nhân viên", "Ngày kiểm tra", "Mô tả thiệt hại", "Chi phí đền bù"}));

         GroupLayout gl_panel = new GroupLayout(panel);
         gl_panel.setHorizontalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
         				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
         					.addContainerGap())))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(65)
         			.addComponent(textFieldTK, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(cbDK, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
         			.addGap(18)
         			.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
         			.addGap(463)
         			.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
         			.addGap(20))
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1151, Short.MAX_VALUE)
         			.addContainerGap())
         		.addGroup(gl_panel.createSequentialGroup()
         			.addGap(45)
         			.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
         			.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
         			.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
         			.addGap(33)
         			.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
         			.addGap(770))
         );
         gl_panel.setVerticalGroup(
         	gl_panel.createParallelGroup(Alignment.LEADING)
         		.addGroup(gl_panel.createSequentialGroup()
         			.addContainerGap()
         			.addComponent(lblNewLabel)
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(textField, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
         			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(18)
         					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
         				.addGroup(gl_panel.createSequentialGroup()
         					.addGap(28)
         					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
         						.addGroup(gl_panel.createSequentialGroup()
         							.addComponent(cbDK, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
         							.addPreferredGap(ComponentPlacement.RELATED))
         						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         							.addComponent(textFieldTK, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
         							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))))
         			.addGap(83)
         			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
         				.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
         				.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
         				.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
         			.addPreferredGap(ComponentPlacement.RELATED)
         			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
         			.addContainerGap())
         );
         
         table = new JTable();
         table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
         table.setRowHeight(24);
         table.setBackground(new Color(255, 255, 255));
         table.addMouseListener(new MouseAdapter() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	    	jBtSelectRowActionPerformed(e);
        	    }
        	});
         
         model = new DefaultTableModel(new String[]{
 	            "Mã kiểm tra", "Mã phòng", "Mã thuê phòng", "Mã nhân viên",
 	            	"Ngày kiểm tra", "Mô tả thiệt hại", "Chi phí đền bù"
 	        }, 0) {
 	            @Override
 	            public boolean isCellEditable(int row, int column) {
 	                return false;
 	            }
 	        };
 	     table.setModel(model);
	     scrollPane.setViewportView(table);
     	 loadDataToModel();
        
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
        new KiemTraPhongGUI().setVisible(true);        
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
    
    private void KiemTinhTrangActionPerformed(ActionEvent evt) {
    	dispose();
        new KiemTraPhongGUI().setVisible(true);
    }
    
    
    private void jBtTimKiemActionPerformed(ActionEvent evt) {
    	String loaiTim = cbDK.getSelectedItem().toString(); // Lấy tiêu chí
        String tuKhoa = textFieldTK.getText().trim(); // Lấy từ khóa tìm

        try {
            ArrayList<KiemTraTinhTrang> ketQua = ktttBUS.timChiTietKiemTraTinhTrang(loaiTim, tuKhoa);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); 

            for (KiemTraTinhTrang kttt : ketQua) {
                model.addRow(new Object[]{
                		kttt.getMaKiemTra(),
        	            kttt.getMaPhong(),
        	            kttt.getMaThuePhong(),
        	            kttt.getMaNhanVien(),
        	            kttt.getNgayKiemTra(),
        	            kttt.getMoTaThietHai(),
        	            kttt.getChiPhiDenBu()         
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tìm kiếm: " + ex.getMessage());
        }
    }
    
    private void jBtRefreshActionPerformed(  ActionEvent evt) {
    	try {
    	    ktttBUS.getdsKTTT(); 
    	    model.setRowCount(0);

    	    for (KiemTraTinhTrang kttt : ktttBUS.getDsKTTT()) {
    	        model.addRow(new Object[]{
    	            kttt.getMaKiemTra(),
    	            kttt.getMaPhong(),
    	            kttt.getMaThuePhong(),
    	            kttt.getMaNhanVien(),
    	            kttt.getNgayKiemTra(),
    	            kttt.getMoTaThietHai(),
    	            kttt.getChiPhiDenBu()
    	        });
    	    }
    	    textFieldTK.setText("");
    	} catch (SQLException e) {
    		JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    	    e.printStackTrace();
    	}
    }
    private void jBtThemRowActionPerformed(ActionEvent e) {
        int selectedRow = -1;
        DlgKTTT dlg = new DlgKTTT(model, selectedRow);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }
    private void jBtSuaActionPerformed(ActionEvent e){
    	int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String maKiemTra = (String) table.getValueAt(selectedRow, 0);
            String maThuePhong = (String) table.getValueAt(selectedRow, 1);
            String maNhanVien = (String) table.getValueAt(selectedRow, 2);
            String ngayKiemTra = (String) table.getValueAt(selectedRow, 3);
            String moTa = (String) table.getValueAt(selectedRow, 4);
            String chiPhi = (String) table.getValueAt(selectedRow, 5);

            // dialog
            dlg = new DlgKTTT(model, table.getSelectedRow());
            dlg.setModelAndRow(model, selectedRow);
            dlg.setData(maKiemTra, maPhong, maThuePhong, maNhanVien, ngayKiemTra, moTa, chiPhi);
            dlg.setLocationRelativeTo(null);
            dlg.setVisible(true);
        }
    }

    private void jBtSelectRowActionPerformed(MouseEvent e) {
    	if (e.getClickCount() == 2) { // Double click
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String maKiemTra = (String) table.getValueAt(selectedRow, 0);
                String maPhong = (String) table.getValueAt(selectedRow, 1);
                String maThuePhong = (String) table.getValueAt(selectedRow, 2);
                String maNhanVien = (String) table.getValueAt(selectedRow, 3);
                String ngayKiemTra = (String) table.getValueAt(selectedRow, 4);
                String moTa = (String) table.getValueAt(selectedRow, 5);
                String chiPhi = (String) table.getValueAt(selectedRow, 6);

                // dialog
                dlg = new DlgKTTT(model, table.getSelectedRow());
                dlg.setModelAndRow(model, selectedRow);
                dlg.setData(maKiemTra, maPhong, maThuePhong, maNhanVien, ngayKiemTra, moTa, chiPhi);
                dlg.setLocationRelativeTo(null);
                dlg.setVisible(true);
            }
        }
    }
    private void jBtDeleteActionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xoá.");
            return;
        }

        try {
            int maKiemTra = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());

            int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xoá kiểm tra có mã: " + maKiemTra + "?",
                "Xác nhận xoá", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = ktttBUS.xoaKTTT(maKiemTra);

                if (success) {
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Xoá thành công.");
                    loadDataToModel();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xoá. Vui lòng thử lại.");
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void loadDataToModel() {
        model.setRowCount(0);
        for (KiemTraTinhTrang kttt : ktttBUS.getDsKTTT()) {
            model.addRow(new Object[]{
                kttt.getMaKiemTra(),
                kttt.getMaPhong(),
                kttt.getMaThuePhong(),
                kttt.getMaNhanVien(),
                kttt.getNgayKiemTra(),
                kttt.getMoTaThietHai(),
                kttt.getChiPhiDenBu()
            });
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
            Logger.getLogger(KiemTraPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(KiemTraPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KiemTraPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KiemTraPhongGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
         EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KiemTraPhongGUI().setVisible(true);
            }
        });
         
    }
}
