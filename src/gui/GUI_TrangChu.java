package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class GUI_TrangChu extends JPanel{
	public GUI_TrangChu() {
		setSize(913,625);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/image/ff.jpg")));
		add(lblNewLabel);
	}
}
