package custom_Gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JOptionPaneAddCustomers extends JOptionPane {

	public JOptionPaneAddCustomers() {
		setSize(300,300);
		showOptionDialog(null, null, "Thêm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	}
	
}
