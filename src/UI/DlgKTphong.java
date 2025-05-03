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

public class DlgKTphong extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaKT;
	private JTextField txtMaThuePhong;
	private JTextField txtMaNV;
	private JTextField txtNgayKT;
	private JTextField txtMoTa;
	private JTextField txtChiPhi;
	private JTextField txtMaPhong;
	private NhanVienBLL nvBLL ;
	private final KiemTraTinhTrangBUS ktttBLL = new KiemTraTinhTrangBUS();
	private final PhieuThuePhongBLL phieuThueBLL = new PhieuThuePhongBLL();
	private final QuanLiPhongDAO phongDAO = new QuanLiPhongDAO();

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
            Logger.getLogger(DlgKTphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DlgKTphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DlgKTphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch ( UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DlgKTphong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//		try {
//			DlgKTphong dialog = new DlgKTphong();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKTphong() {
		try {
			nvBLL = new NhanVienBLL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    initComponents();
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
		lblNewLabel.setBounds(31, 20, 101, 36);
		contentPanel.add(lblNewLabel);
		
		txtMaKT = new JTextField();
		txtMaKT.setBounds(218, 15, 245, 36);
		contentPanel.add(txtMaKT);
		txtMaKT.setColumns(10);
		}
		{
			JLabel lblMThuPhng = new JLabel("Mã thuê phòng:");
			lblMThuPhng.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblMThuPhng.setBounds(31, 111, 122, 36);
			contentPanel.add(lblMThuPhng);
		}
		{
			txtMaThuePhong = new JTextField();
			txtMaThuePhong.setColumns(10);
			txtMaThuePhong.setBounds(218, 106, 245, 36);
			contentPanel.add(txtMaThuePhong);
		}
		{
			JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
			lblMNhnVin.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblMNhnVin.setBounds(31, 159, 122, 36);
			contentPanel.add(lblMNhnVin);
		}
		{
			txtMaNV = new JTextField();
			txtMaNV.setColumns(10);
			txtMaNV.setBounds(218, 154, 245, 36);
			contentPanel.add(txtMaNV);
		}
		{
			JLabel lblNgyKimTra = new JLabel("Ngày kiểm tra:");
			lblNgyKimTra.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNgyKimTra.setBounds(31, 207, 122, 36);
			contentPanel.add(lblNgyKimTra);
		}
		{
			JLabel lblNgyKimTra = new JLabel("Mô tả thiệt hại:");
			lblNgyKimTra.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblNgyKimTra.setBounds(31, 255, 122, 36);
			contentPanel.add(lblNgyKimTra);
		}
		{
			txtNgayKT = new JTextField();
			txtNgayKT.setColumns(10);
			txtNgayKT.setBounds(218, 202, 245, 36);
			contentPanel.add(txtNgayKT);
		}
		{
			txtMoTa = new JTextField();
			txtMoTa.setColumns(10);
			txtMoTa.setBounds(218, 250, 245, 36);
			contentPanel.add(txtMoTa);
		}
		{
			JLabel lblChiPhn = new JLabel("Chi phí đền bù:");
			lblChiPhn.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblChiPhn.setBounds(31, 303, 122, 36);
			contentPanel.add(lblChiPhn);
		}
		{
			txtChiPhi = new JTextField();
			txtChiPhi.setColumns(10);
			txtChiPhi.setBounds(218, 298, 245, 36);
			contentPanel.add(txtChiPhi);
		}
		{
			JLabel lblMaPhong = new JLabel("Mã phòng:");
			lblMaPhong.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblMaPhong.setBounds(31, 63, 122, 36);
			contentPanel.add(lblMaPhong);
		}
		{
			txtMaPhong = new JTextField();
			txtMaPhong.setColumns(10);
			txtMaPhong.setBounds(218, 63, 245, 36);
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
			
			            
			            if (maKiemTraText.isEmpty() || !maKiemTraText.matches("\\d+")) 
			            {
			                JOptionPane.showMessageDialog(null, "Mã Kiểm Tra phải là một số nguyên hợp lệ!");
			                return;
			            }
			            if (maPhongText.isEmpty() || !maKiemTraText.matches("\\d+")) 
			            {
			                JOptionPane.showMessageDialog(null, "Mã Kiểm Tra phải là một số nguyên hợp lệ!");
			                return;
			            }
			            if (maNhanVienText.isEmpty() || !maNhanVienText.matches("\\d+")) 
			            {
			                JOptionPane.showMessageDialog(null, "Mã Nhân Viên phải là một số nguyên hợp lệ!");
			                return;
			            }
			            if (maThuePhongText.isEmpty() || !maThuePhongText.matches("\\d+")) 
			            {
			                JOptionPane.showMessageDialog(null, "Mã Thuê Phòng phải là một số nguyên hợp lệ!");
			                return;
			            }
			
			            if (ngayKiemTraText.isEmpty() || !ngayKiemTraText.matches("\\d{4}/\\d{2}/\\d{2}")) 
			            {
			                JOptionPane.showMessageDialog(null, "Ngày Kiểm Tra phải có định dạng 'yyyy/MM/dd'!");
			                return;
			            }
			
			            if (chiPhiText.isEmpty() || !chiPhiText.matches("\\d+(\\.\\d+)?")) 
			            {
			                JOptionPane.showMessageDialog(null, "Chi Phí phải là một số hợp lệ!");
			                return;
			            }
			            
			            int maKiemTra = Integer.parseInt(maKiemTraText);
			            if (ktttBLL.timKiemKTTT(maKiemTra) != null){
			            	JOptionPane.showMessageDialog(null, "Mã kiểm tra đã tồn tại!");
			            }
			            int maPhong = Integer.parseInt(maPhongText);
			            if (! phongDAO.kiemTraTonTai(maPhong)){
			            	JOptionPane.showMessageDialog(null, "Mã phòng không tồn tại!");
			            }
			            int maThuePhong = Integer.parseInt(maThuePhongText);
			            if (! phieuThueBLL.kiemTraTonTai(maThuePhong))
			            {
			            	JOptionPane.showMessageDialog(null, "Mã thuê phòng không tồn tại!");
			            }
			            
			            int maNhanVien = Integer.parseInt(maNhanVienText);
			            if (! nvBLL.kiemTraTonTai(maNhanVien)){
			            	JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại!");
			            }
			            
			            Date ngayKiemTra = java.sql.Date.valueOf(LocalDate.parse(ngayKiemTraText, DateTimeFormatter.ofPattern("yyyy/MM/dd")));
			            // mô tả sẵn string k cần đổi
			            BigDecimal chiPhiDenBu = new BigDecimal(chiPhiText);
			            
			            KiemTraTinhTrang kt = new KiemTraTinhTrang(maKiemTra, maPhong, maThuePhong, maNhanVien, ngayKiemTra, moTaThietHai, chiPhiDenBu);
			
		                if (ktttBLL != null && ktttBLL.themKTTT(kt)) 
		                {
		                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
		                    dispose();  // Đóng dialog sau khi thêm thành công
		                } else {
		                    JOptionPane.showMessageDialog(null, "Thêm thất bại!");
		                }
		           	} catch (DateTimeParseException ex) {
			            JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng 'yyyy/mm/dd'.");
		           	} catch (Exception ex) {
		           		JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi lưu: " + ex.getMessage());
		           	}
		    }
		});
				buttonPane.setLayout(null);
				buttonPane.add(okButton);
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
	

}

