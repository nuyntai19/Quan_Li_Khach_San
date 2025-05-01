package UI;

import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.KiemTraTinhTrangBUS;
import DTO.KiemTraTinhTrang;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DlgKTphong extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textTKmaPhong;
	private JTable table;
	private DefaultTableModel modelTinhTrang;
	private JScrollPane scrollPane;
	private final KiemTraTinhTrangBUS ktttBUS = new KiemTraTinhTrangBUS();
	private JTable table_1;
	private int ma;

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
	public DlgKTphong(int maPhong) {
		this.ma = maPhong;
		initComponents();
	}
	public void initComponents(){
		setTitle("Kiểm tra tình trạng phòng");
		setBounds(100, 100, 1238, 380);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1238, 303);
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 102, 1238, 201);
		contentPanel.add(scrollPane);
		
		
		modelTinhTrang = new DefaultTableModel(new String[]{
			    "Mã kiểm tra", "Mã phòng", "Mã nhân viên", "Ngày kiểm tra", "Mô tả thiệt hại", "Chi phí đền bù"
			}, 0) {
			@Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
		
		table_1 = new JTable();
		table.setModel(modelTinhTrang);
		scrollPane.setViewportView(table_1);
		loadDataToModel();
		
		textTKmaPhong = new JTextField();
		textTKmaPhong.setBounds(186, 32, 306, 43);
		contentPanel.add(textTKmaPhong);
		textTKmaPhong.setColumns(10);
		
		JButton btnTk = new JButton("Tìm");
		btnTk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jBtTimKiemActionPerformed(e);
			}
		});
		btnTk.setForeground(new Color(255, 255, 255));
		btnTk.setBackground(new Color(52, 152, 219));
		btnTk.setBounds(530, 33, 117, 43);
		contentPanel.add(btnTk);
		
		JLabel lblNewLabel = new JLabel("Mã phòng:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(66, 32, 108, 43);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 299, 1238, 53);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setBounds(1011, 8, 94, 39);
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(52, 152, 219));
				
				buttonPane.add(okButton);
			
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(1135, 8, 86, 39);
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(52, 152, 219));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	private void loadDataToModel() 
	{
        modelTinhTrang.setRowCount(0);
        for (KiemTraTinhTrang kttt : ktttBUS.getDsKTTT()) {
            modelTinhTrang.addRow(new Object[]{
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
	public void napDuLieu(int maPhong) 
	{
        try {
        	KiemTraTinhTrang kttt = ktttBUS.timTheoMaPhong(maPhong);
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
	
	private void jBtTimKiemActionPerformed(ActionEvent e) 
	{
        String maPhongStr = textTKmaPhong.getText().trim();
        if (maPhongStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã phòng.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int maPhong = Integer.parseInt(maPhongStr);
            modelTinhTrang.setRowCount(0);
            napDuLieu(maPhong);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Mã phòng phải là số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
	
}
