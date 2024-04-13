package custom_Gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public class PanelActionButton extends JPanel{


	private JButton btnMinus;
	private JButton btnPlus;
	private JButton btnDelete;

	public PanelActionButton() {
		
		btnMinus= new JButton("");
		btnMinus.setIcon(new ImageScaler("/icon/minus.png", 20, 20).getScaledImageIcon());
		btnPlus = new JButton("");
		btnPlus.setIcon(new ImageScaler("/icon/plus.png", 20, 20).getScaledImageIcon());
		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageScaler("/icon/delete.png", 20, 20).getScaledImageIcon());
		btnPlus.setPreferredSize(new Dimension(40,27));
		btnMinus.setPreferredSize(new Dimension(40,27));
		btnDelete.setPreferredSize(new Dimension(40,27));
		add(btnMinus);
		add(btnPlus);
		add(btnDelete);
	}
	
}
