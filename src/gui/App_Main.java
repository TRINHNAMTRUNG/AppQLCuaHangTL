package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import connectDB.connectDBs;
import custom_Gui.ImageScaler;
import custom_Gui.RoundedPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;


public class App_Main extends JFrame implements MouseListener{
	private Color hoverColor, defaultColor;
	private JPanel pMain;
	private RoundedPanel pBanHang;
	private JPanel pRoot;
	private JPanel pLogo;
	private JLabel lblLogo;
	private JLabel lblNameStore;
	private JPanel pMenu;
	private RoundedPanel pHome;
	private JLabel lblHome;
	private RoundedPanel pNhaCungCap;
	private JLabel lblNhaCungCap;
	private RoundedPanel pSanPham;
	private JLabel lblSanPham;
	private RoundedPanel pNhanVien;
	private JLabel lblNhanVien;
	private RoundedPanel pBaoCao;
	private JLabel lblBaoCao;
	private RoundedPanel pDangXuat;
	private JLabel lblDangXuat;
	private RoundedPanel pKhuyenMai;
	private JLabel lblKhuyenMai;
	private JLabel lblBanHang;
	private RoundedPanel pViewControl;
	private JLabel lblNewLabel_1;
	public App_Main() {
		try {
			connectDBs.getInstance().connect();
			System.out.println("Connected !!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		URL url = App_Main.class.getResource("/image/iconFrame.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		
		setTitle("App Quản Lý Cửa Hàng Tiện Lợi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1150, 684);
		setLocationRelativeTo(null);
		setIconImage(img);
		setFont(new Font("Times New Roman", Font.BOLD, 13));
		setResizable(false);
		
		pMain = new JPanel();
		pMain.setBackground(new Color(59, 132, 52));
		getContentPane().add(pMain);
		pMain.setLayout(null);
		
		pRoot = new JPanel();
		pRoot.setBackground(new Color(42, 82, 39));
		pRoot.setBounds(0, 0, 203, 647);
		pMain.add(pRoot);
		pRoot.setLayout(null);
		
		pLogo = new JPanel();
		pLogo.setBackground(new Color(42, 82, 39));
		pLogo.setBounds(10, 11, 183, 153);
		pRoot.add(pLogo);
		pLogo.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(0, 0, 183, 126);
		lblLogo.setIcon(new ImageScaler("/image/gros.PNG", 183, 126).getScaledImageIcon());
		pLogo.add(lblLogo);
		
		lblNameStore = new JLabel("Coconut Store");
		lblNameStore.setForeground(new Color(242, 127, 87));
		lblNameStore.setFont(new Font("Monotype Corsiva", Font.BOLD, 25));
		lblNameStore.setBounds(25, 126, 148, 27);
		pLogo.add(lblNameStore);
		
		pMenu = new JPanel();
		pMenu.setBackground(new Color(42, 82, 39));
		pMenu.setBounds(10, 163, 183, 473);
		pRoot.add(pMenu);
		pMenu.setLayout(null);
		
		pHome = new RoundedPanel(12);
		pHome.setBackground(new Color(59, 132, 52));
		pHome.setBounds(10, 21, 163, 38);
		pMenu.add(pHome);
		pHome.setLayout(null);
		
		lblHome = new JLabel("Trang Chủ");
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setBounds(23, 0, 104, 38);
		lblHome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHome.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconHome.png")));
		pHome.add(lblHome);
		
		pNhaCungCap = new RoundedPanel(12);
		pNhaCungCap.setBackground(new Color(59, 132, 52));
		pNhaCungCap.setBounds(10, 73, 163, 38);
		pMenu.add(pNhaCungCap);
		pNhaCungCap.setLayout(null);
		
		lblNhaCungCap = new JLabel("Nhà Cung Cấp");
		lblNhaCungCap.setForeground(new Color(255, 255, 255));
		lblNhaCungCap.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconNhaCungCap.png")));
		lblNhaCungCap.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhaCungCap.setBounds(23, 0, 131, 38);
		pNhaCungCap.add(lblNhaCungCap);
		
		pSanPham = new RoundedPanel(12);
		pSanPham.setBackground(new Color(59, 132, 52));
		pSanPham.setBounds(10, 129, 163, 38);
		pMenu.add(pSanPham);
		pSanPham.setLayout(null);
		
		lblSanPham = new JLabel("Sản phẩm");
		lblSanPham.setForeground(new Color(255, 255, 255));
		lblSanPham.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconSanPham.png")));
		lblSanPham.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSanPham.setBounds(23, 0, 104, 38);
		pSanPham.add(lblSanPham);
		
		pNhanVien = new RoundedPanel(12);
		pNhanVien.setBackground(new Color(59, 132, 52));
		pNhanVien.setBounds(10, 184, 163, 38);
		pMenu.add(pNhanVien);
		pNhanVien.setLayout(null);
		
		lblNhanVien = new JLabel("Nhân Viên");
		lblNhanVien.setForeground(new Color(255, 255, 255));
		lblNhanVien.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconNhanVien.png")));
		lblNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNhanVien.setBounds(23, 0, 104, 38);
		pNhanVien.add(lblNhanVien);
		
		pBaoCao = new RoundedPanel(12);
		pBaoCao.setBackground(new Color(59, 132, 52));
		pBaoCao.setBounds(10, 241, 163, 38);
		pMenu.add(pBaoCao);
		pBaoCao.setLayout(null);
		
		lblBaoCao = new JLabel("Báo Cáo");
		lblBaoCao.setForeground(new Color(255, 255, 255));
		lblBaoCao.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconBaoCao.png")));
		lblBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBaoCao.setBounds(23, 0, 104, 38);
		pBaoCao.add(lblBaoCao);
		
		pDangXuat = new RoundedPanel(12);
		pDangXuat.setBackground(new Color(59, 132, 52));
		pDangXuat.setBounds(10, 428, 163, 38);
		pMenu.add(pDangXuat);
		pDangXuat.setLayout(null);
		
		lblDangXuat = new JLabel("Đăng Xuất");
		lblDangXuat.setForeground(new Color(255, 255, 255));
		lblDangXuat.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconDangXuat.png")));
		lblDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDangXuat.setBounds(23, 0, 104, 38);
		pDangXuat.add(lblDangXuat);
		
		pKhuyenMai = new RoundedPanel(12);
		pKhuyenMai.setBackground(new Color(59, 132, 52));
		pKhuyenMai.setBounds(10, 296, 163, 38);
		pMenu.add(pKhuyenMai);
		pKhuyenMai.setLayout(null);
		
		lblKhuyenMai = new JLabel("Khuyến Mãi");
		lblKhuyenMai.setForeground(new Color(255, 255, 255));
		lblKhuyenMai.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconKhuyenMai.png")));
		lblKhuyenMai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKhuyenMai.setBounds(23, 0, 117, 38);
		pKhuyenMai.add(lblKhuyenMai);
		
		pBanHang = new RoundedPanel(12);
		pBanHang.setLayout(null);
		pBanHang.setBackground(new Color(59, 132, 52));
		pBanHang.setBounds(10, 355, 163, 38);
		pMenu.add(pBanHang);
		
		lblBanHang = new JLabel("Bán Hàng");
		lblBanHang.setIcon(new ImageIcon(App_Main.class.getResource("/image/iconBanHang.png")));
		lblBanHang.setForeground(Color.WHITE);
		lblBanHang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBanHang.setBounds(23, 0, 117, 38);
		pBanHang.add(lblBanHang);
		
		pViewControl = new RoundedPanel(10);
		pViewControl.setLayout(new BorderLayout());
		pViewControl.setBounds(213, 11, 913, 625);
		pMain.add(pViewControl);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(App_Main.class.getResource("/image/ff.jpg")));
		pViewControl.add(lblNewLabel_1, BorderLayout.CENTER);
	
		
		pBanHang.addMouseListener(this);
		pBaoCao.addMouseListener(this);
		pDangXuat.addMouseListener(this);
		pHome.addMouseListener(this);
		pKhuyenMai.addMouseListener(this);
		pNhaCungCap.addMouseListener(this);
		pNhanVien.addMouseListener(this);
		pSanPham.addMouseListener(this);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new App_Main().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
        });
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj =  e.getSource();
		pViewControl.removeAll();
		if(obj.equals(pHome)) {
			pViewControl.add(new GUI_TrangChu());
		}
		if(obj.equals(pNhaCungCap)) {
			pViewControl.add(new GUI_NhaCungCap());
		}
		if(obj.equals(pSanPham)) {
			pViewControl.add(new GUI_SanPham());
		}
		if(obj.equals(pNhanVien)) {
			pViewControl.add(new GUI_NhanVien());
		}
		if(obj.equals(pBaoCao)) {
			pViewControl.add(new GUI_BaoCao());
		}
		if(obj.equals(pKhuyenMai)) {
			pViewControl.add(new GUI_KhuyenMai());
		}
		if(obj.equals(pBanHang)) {
			pViewControl.add(new Gui_BanHang());
		}
		if(obj.equals(pDangXuat)) {
			int checkLogOut = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không ?", " Xác nhận",JOptionPane.YES_NO_OPTION);
			if (checkLogOut == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Thoát thành công!!!");
				dispose();
				new GUI_DangNhap().setVisible(true);
			}
		}
		pViewControl.revalidate();
	    pViewControl.repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		hoverColor = new Color(123,174,94);
		
		Object obj =  e.getSource();
		JPanel sourcePanel = (JPanel) obj;
		sourcePanel.setBackground(hoverColor);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		defaultColor = new Color(59, 132, 52);
		Object obj =  e.getSource();
		JPanel sourcePanel = (JPanel) obj;
		sourcePanel.setBackground(defaultColor);
		
	}
}
