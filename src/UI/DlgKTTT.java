package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.KiemTraTinhTrangBUS;
import BLL.NhanVienBLL;
import BLL.PhieuThuePhongBLL;
import DAO.QuanLiPhongDAO;
import DTO.KiemTraTinhTrang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DlgKTTT extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaKT;
	private JTextField txtMaThuePhong;
	private JTextField txtMaNV;
	private JTextField txtNgayKT;
	private JTextField txtMoTa;
	private JTextField txtChiPhi;
	private DefaultTableModel model;
	private int selectedRow;
	private JTextField txtMaPhong;
	
	private KiemTraTinhTrangBUS ktttBLL = new KiemTraTinhTrangBUS();
	private final PhieuThuePhongBLL phieuThueBLL = new PhieuThuePhongBLL();
	private final QuanLiPhongDAO phongDAO = new QuanLiPhongDAO();
	private NhanVienBLL nvBLL ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for ( LookAndFeelInfo info :  UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                     UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DlgKTTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DlgKTTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DlgKTTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DlgKTTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//		try {
//			DlgKTTT dialog = new DlgKTTT();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKTTT(DefaultTableModel model, int selectedRow) {
	    this.model = model;
	    this.selectedRow = selectedRow;
	    try {
			nvBLL = new NhanVienBLL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    initComponents();
	    txtMaKT.setEditable(false);
	    txtMaKT.setFocusable(false);
	    txtMaKT.setBackground(new Color(242, 242, 242)); 
	    
	    txtMaPhong.setEditable(false);
	    txtMaPhong.setFocusable(false);
	    txtMaPhong.setBackground(new Color(242, 242, 242));
	    
	    txtMaThuePhong.setEditable(false);
	    txtMaThuePhong.setFocusable(false);
	    txtMaThuePhong.setBackground(new Color(242, 242, 242));
	}
	public void initComponents() {
		setTitle("CHI TIẾT KIỂM TRA");
		setBounds(100, 100, 500, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
		JLabel lblNewLabel = new JLabel("Mã kiểm tra:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(29, 19, 101, 36);
		contentPanel.add(lblNewLabel);
		
		txtMaKT = new JTextField();
		txtMaKT.setBounds(216, 15, 245, 36);
		contentPanel.add(txtMaKT);
		txtMaKT.setColumns(10);
		}
		{
			JLabel lblMThuPhng = new JLabel("Mã thuê phòng:");
			lblMThuPhng.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblMThuPhng.setBounds(29, 110, 122, 36);
			contentPanel.add(lblMThuPhng);
		}
		{
			txtMaThuePhong = new JTextField();
			txtMaThuePhong.setColumns(10);
			txtMaThuePhong.setBounds(216, 105, 245, 36);
			contentPanel.add(txtMaThuePhong);
		}
		{
			JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
			lblMNhnVin.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblMNhnVin.setBounds(29, 158, 122, 36);
			contentPanel.add(lblMNhnVin);
		}
		{
			txtMaNV = new JTextField();
			txtMaNV.setColumns(10);
			txtMaNV.setBounds(216, 153, 245, 36);
			contentPanel.add(txtMaNV);
		}
		{
			JLabel lblNgyKimTra = new JLabel("Ngày kiểm tra:");
			lblNgyKimTra.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNgyKimTra.setBounds(29, 206, 122, 36);
			contentPanel.add(lblNgyKimTra);
		}
		{
			JLabel lblNgyKimTra = new JLabel("Mô tả thiệt hại:");
			lblNgyKimTra.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNgyKimTra.setBounds(29, 254, 122, 36);
			contentPanel.add(lblNgyKimTra);
		}
		{
			txtNgayKT = new JTextField();
			txtNgayKT.setColumns(10);
			txtNgayKT.setBounds(216, 201, 245, 36);
			contentPanel.add(txtNgayKT);
		}
		{
			txtMoTa = new JTextField();
			txtMoTa.setColumns(10);
			txtMoTa.setBounds(216, 249, 245, 36);
			contentPanel.add(txtMoTa);
		}
		{
			JLabel lblChiPhn = new JLabel("Chi phí đền bù:");
			lblChiPhn.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblChiPhn.setBounds(29, 302, 122, 36);
			contentPanel.add(lblChiPhn);
		}
		{
			txtChiPhi = new JTextField();
			txtChiPhi.setColumns(10);
			txtChiPhi.setBounds(216, 297, 245, 36);
			contentPanel.add(txtChiPhi);
		}
		{
			JLabel lblMaPhong = new JLabel("Mã phòng:");
			lblMaPhong.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblMaPhong.setBounds(29, 62, 122, 36);
			contentPanel.add(lblMaPhong);
		}
		{
			txtMaPhong = new JTextField();
			txtMaPhong.setColumns(10);
			txtMaPhong.setBounds(216, 57, 245, 36);
			contentPanel.add(txtMaPhong);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 351, 500, 54);
			contentPanel.add(buttonPane);
			{
				JButton okButton = new JButton("Lưu");
				okButton.setBounds(266, 6, 96, 42);
				okButton.setBackground(new Color(52, 152, 219));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Dialog", Font.BOLD, 15));

				okButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
			        try {
			            
			            String maKiemTraText = txtMaKT.getText().trim();
			            String maPhongText = txtMaPhong.getText().trim();
			            String maThuePhongText = txtMaThuePhong.getText().trim();
			            String maNhanVienText = txtMaNV.getText().trim();
			            String ngayKiemTraText = txtNgayKT.getText().trim();
			            String moTaThietHai = txtMoTa.getText().trim();
			            String chiPhiText = txtChiPhi.getText().trim();
			
			            
			            if (maKiemTraText.isEmpty() || !maKiemTraText.matches("\\d+")) {
			                JOptionPane.showMessageDialog(null, "Mã Kiểm Tra phải là một số nguyên hợp lệ!");
			                return;
			            }
			            if (maPhongText.isEmpty() || !maKiemTraText.matches("\\d+")) {
			                JOptionPane.showMessageDialog(null, "Mã Kiểm Tra phải là một số nguyên hợp lệ!");
			                return;
			            }
			            if (maNhanVienText.isEmpty() || !maNhanVienText.matches("\\d+")) {
			                JOptionPane.showMessageDialog(null, "Mã Nhân Viên phải là một số nguyên hợp lệ!");
			                return;
			            }
			            if (maThuePhongText.isEmpty() || !maThuePhongText.matches("\\d+")) {
			                JOptionPane.showMessageDialog(null, "Mã Thuê Phòng phải là một số nguyên hợp lệ!");
			                return;
			            }
			
			            // Kiểm tra định dạng ngày tháng
			            if (ngayKiemTraText.isEmpty() || !ngayKiemTraText.matches("\\d{4}-\\d{2}-\\d{2}")) {
			                JOptionPane.showMessageDialog(null, "Ngày Kiểm Tra phải có định dạng 'yyyy-MM-dd'!");
			                return;
			            }
			
			            // Kiểm tra chi phí (BigDecimal)
			            if (chiPhiText.isEmpty() || !chiPhiText.matches("\\d+(\\.\\d+)?")) {
			                JOptionPane.showMessageDialog(null, "Chi Phí phải là một số hợp lệ!");
			                return;
			            }
			            int maKiemTra = Integer.parseInt(maKiemTraText);
			            int maPhong = Integer.parseInt(maPhongText);
			            int maThuePhong = Integer.parseInt(maThuePhongText);
			            
			            int maNhanVien = Integer.parseInt(maNhanVienText);
			            if (! nvBLL.kiemTraTonTai(maNhanVien)){
			            	JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại!");
			            }
			            
			            Date ngayKiemTra = java.sql.Date.valueOf(LocalDate.parse(ngayKiemTraText, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			            // mô tả sẵn string k cần đổi
			            BigDecimal chiPhiDenBu = new BigDecimal(chiPhiText);
			            
			            KiemTraTinhTrang kt = new KiemTraTinhTrang(maKiemTra, maPhong, maThuePhong, maNhanVien, ngayKiemTra, moTaThietHai, chiPhiDenBu);
//			
//		                model.setValueAt(maKiemTra, selectedRow, 0);
//		                model.setValueAt(maPhong, selectedRow, 1);
//		                model.setValueAt(maThuePhong, selectedRow, 2);
//		                model.setValueAt(maNhanVien, selectedRow, 3);
//		                model.setValueAt(ngayKiemTra, selectedRow, 4);
//		                model.setValueAt(moTaThietHai, selectedRow, 5);
//		                model.setValueAt(chiPhiDenBu, selectedRow, 6);
//		
		                if (ktttBLL != null && ktttBLL.suaKTTT(kt)) {
		                    JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
		                    dispose();
		                } else {
		                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
		                }
			        } catch (DateTimeParseException ex) {
			            JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng 'yyyy-MM-dd'.");
			        } catch (Exception ex) {
			            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi lưu: " + ex.getMessage());
			        }
			    }
			});
				buttonPane.setLayout(null);

				//okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				//getRootPane().setDefaultButton(okButton);
			}
			{
				// Nút Cancel (Hủy)
			    JButton cancelButton = new JButton("Cancel");
			    cancelButton.setBounds(387, 6, 96, 42);
			    cancelButton.setBackground(new Color(52, 152, 219));
			    cancelButton.setForeground(new Color(255, 255, 255));
			    cancelButton.setFont(new Font("Dialog", Font.BOLD, 15));
			    cancelButton.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            dispose(); 
			        }
			    });
				buttonPane.add(cancelButton);
			}
		}
		
	}
	public void setData(String maKT, String maPhong, String maThuePhong, String maNV, String ngayKT, String moTa, String chiPhi) {
	    txtMaKT.setText(maKT);
	    txtMaPhong.setText(maPhong);
	    txtMaThuePhong.setText(maThuePhong);
	    txtMaNV.setText(maNV);
	    txtNgayKT.setText(ngayKT);
	    txtMoTa.setText(moTa);
	    txtChiPhi.setText(chiPhi);
	}
	public void setModelAndRow(DefaultTableModel model, int row) {
	    this.model = model;
	    this.selectedRow = row;
	}
	

}

