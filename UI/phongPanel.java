package UI;

import javax.swing.border.LineBorder;

import java.awt.*;
import javax.swing.*;

public class phongPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public phongPanel() {
		setBackground(new Color(206, 206, 206));
		setLayout(null);
		this.setBorder(new LineBorder(Color.WHITE, 1, true)); // true = bo góc

		
		JLabel label = new JLabel("New label");
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 95, 30);
		add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(173, 0, 95, 30);
		add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 239, 239));
		panel.setBounds(0, 104, 268, 36);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(phongPanel.class.getResource("/ICON/clock.png")));
		lblNewLabel.setBounds(6, 6, 24, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(160, 0, 108, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(34, 0, 75, 36);
		panel.add(lblNewLabel_1_1);

	}
}
