package custom_Gui;

import javax.swing.*;

import entity.DonVi;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DialogSL extends JDialog implements ActionListener {
    private JTextField txtSL;
    private JButton btnXacNhan;
    private JLabel lblTitle;
	private JButton btnHuy;
	private JComboBox <DonVi> comboBoxDonVi;
	private DefaultComboBoxModel<DonVi>  modelCombo;
    private int slMoi = -1; 
    private DonVi dv;

    public DialogSL(JPanel parentPanel, ArrayList<DonVi> listDonVi, int slHienTai) {
        super((JFrame) SwingUtilities.getWindowAncestor(parentPanel), "Thêm khách", true);
        setSize(289, 211);
        setLocationRelativeTo((JFrame) SwingUtilities.getWindowAncestor(parentPanel));
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        lblTitle = new JLabel("NHẬP SỐ LƯỢNG");
        lblTitle.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setBounds(77, 11, 127, 27);
        panel.add(lblTitle);

        JLabel lblSL = new JLabel("Số lượng:");
        lblSL.setBounds(10, 52, 69, 14);
        panel.add(lblSL);

        btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setBounds(21, 136, 100, 27);
        panel.add(btnXacNhan);

        txtSL = new JTextField();
        txtSL.setColumns(10);
        txtSL.setBounds(77, 49, 181, 20);
        txtSL.setText(String.valueOf(slHienTai));
        txtSL.selectAll();
        panel.add(txtSL);

        
       
        getContentPane().add(panel, BorderLayout.CENTER);
        
        btnHuy = new JButton("Hủy");
        btnHuy.setBounds(158, 136, 100, 27);
        panel.add(btnHuy);
        
        JLabel lblDonVi = new JLabel("Số lượng:");
        lblDonVi.setBounds(10, 84, 69, 14);
        panel.add(lblDonVi);
        
        modelCombo = new DefaultComboBoxModel<DonVi>();
        for (DonVi donVi : listDonVi) {
			modelCombo.addElement(donVi);
		}
        comboBoxDonVi = new JComboBox<DonVi>(modelCombo);
        dv= (DonVi) comboBoxDonVi.getSelectedItem();
        comboBoxDonVi.setBounds(77, 80, 181, 22);
        panel.add(comboBoxDonVi);
        btnHuy.addActionListener(this);
        btnXacNhan.addActionListener(this);
        
    }
    public DonVi getDonViMoi() {
    	return dv;
    }
    public int getSLMoi() {
    	return slMoi;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXacNhan)) {
            if (valid()) {
            	slMoi = Integer.parseInt(txtSL.getText());
                dv = (DonVi) comboBoxDonVi.getSelectedItem();
                dispose();
            }
        }
        if(o.equals(btnHuy)) {
        	dispose();
        }
    }

    public boolean valid() {
        if (!txtSL.getText().matches( "^(?!0)\\d{1,}$")) {
        	JOptionPane.showMessageDialog(this, "SL không hợp lệ");
        	return false;
        }
        return true;
    }
}
