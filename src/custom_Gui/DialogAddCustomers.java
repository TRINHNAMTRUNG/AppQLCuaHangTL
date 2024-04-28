package custom_Gui;

import javax.swing.*;
import bus.BUS_KhachHang;
import entity.KhachHang;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class DialogAddCustomers extends JDialog implements ActionListener {
    private JTextField txtMaKhach;
    private JTextField txtSDT;
    private JTextField txtTen;
    private JTextField txtEmail;
    private JLabel lblTen;
    private JButton btnXacNhan;
    private JLabel lblSDT;
    private JLabel lblMaKhach;
    private JLabel lblTitle;
    private Object random;
    private BUS_KhachHang bus_KhachHang = new BUS_KhachHang();

    public DialogAddCustomers(JPanel parentPanel) {
        super((JFrame) SwingUtilities.getWindowAncestor(parentPanel), "Thêm khách", true);
        setSize(400, 280);
        setLocationRelativeTo((JFrame) SwingUtilities.getWindowAncestor(parentPanel));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        lblTitle = new JLabel("THÊM KHÁCH HÀNG");
        lblTitle.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setBounds(129, 11, 151, 27);
        panel.add(lblTitle);

        lblMaKhach = new JLabel("Mã khách:");
        lblMaKhach.setBounds(10, 54, 77, 14);
        panel.add(lblMaKhach);

        lblSDT = new JLabel("SDT:");
        lblSDT.setBounds(10, 89, 77, 14);
        panel.add(lblSDT);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 163, 77, 14);
        panel.add(lblEmail);

        btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setBounds(276, 200, 100, 27);
        panel.add(btnXacNhan);

        txtMaKhach = new JTextField();
        txtMaKhach.setBounds(97, 51, 235, 20);
        panel.add(txtMaKhach);
        txtMaKhach.setColumns(10);

        txtSDT = new JTextField();
        txtSDT.setColumns(10);
        txtSDT.setBounds(97, 86, 235, 20);
        panel.add(txtSDT);

        txtTen = new JTextField();
        txtTen.setColumns(10);
        txtTen.setBounds(97, 122, 235, 20);
        panel.add(txtTen);

        lblTen = new JLabel("Tên khách:");
        lblTen.setBounds(10, 125, 77, 14);
        panel.add(lblTen);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(97, 160, 235, 20);
        panel.add(txtEmail);

        btnXacNhan.addActionListener(this);
        txtMaKhach.setEnabled(false);
        txtMaKhach.setText(taoMaKhach());

        add(panel, BorderLayout.CENTER);
    }

    public String taoMaKhach() {
        ArrayList<KhachHang> listKhach = bus_KhachHang.getAllKhach();
        String maKhach = "KH";
        Random random = new Random();
        boolean isDuplicate;
        do {
            String newMaKhach = maKhach.trim() + String.format("%03d", random.nextInt(1000));
            isDuplicate = listKhach.stream().anyMatch(p -> p.getMaKH().equals(newMaKhach));
            if (!isDuplicate) {
                maKhach = newMaKhach;
            }
        } while (isDuplicate);

        return maKhach.trim();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXacNhan)) {
            if (valid()) {
                KhachHang kh = new KhachHang(txtTen.getText(), txtEmail.getText(), txtSDT.getText(), txtMaKhach.getText(), 0);
                bus_KhachHang.addKhach(kh);
                int doDai = txtSDT.getText().length();
                System.out.println("Độ dài số điện thoại: " + doDai);
                dispose(); // Đóng cửa sổ dialog sau khi xác nhận
            }
        }
    }

    public boolean valid() {
        if (!txtEmail.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@gmail\\.com$")) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return false;
        }
        if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên khách không trống");
            return false;
        }
        if (!txtSDT.getText().matches("^0[0-9]{9,10}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return false;
        }
        ArrayList<KhachHang> listKhach = bus_KhachHang.getAllKhach();
        KhachHang kh = new KhachHang(txtTen.getText(), txtEmail.getText(), txtSDT.getText(), txtMaKhach.getText(), 0);
        if (listKhach.contains(kh)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
            return false;
        }
        return true;
    }
}
