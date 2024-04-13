package custom_Gui;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import gui.GUI_SanPham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class CardProducts extends JPanel{

	private Box pcard;
	private JPanel pAnh;
	private JPanel pGia;
	private JPanel pTen;
	private JLabel lblAnh;
	private JLabel lblGia;
	private JLabel lblTen;

	public CardProducts(String path, String ten, String gia) {
		setPreferredSize(new Dimension(153, 200));
		setLayout(new BorderLayout());
		
		pcard = Box.createVerticalBox();
//		pcard.setPreferredSize(new Dimension(153,200));
		
		pAnh = new JPanel();
		pGia = new JPanel();
		pTen = new JPanel();
		
		lblAnh = new JLabel();
		lblGia = new JLabel(gia);
		lblTen = new JLabel(ten);
		lblTen.setPreferredSize(new Dimension(125, 20));
		
		lblAnh.setPreferredSize(new Dimension(108, 121));
		ImageIcon imgicon = new ImageIcon(CardProducts.class.getResource(path));
		Image img1 = imgicon.getImage();
		Image img2 = img1.getScaledInstance(108, 121, Image.SCALE_SMOOTH);
		imgicon = new ImageIcon(img2);
		lblAnh.setIcon(imgicon);
		
		pcard.add(Box.createVerticalStrut(3));
		pAnh.add(lblAnh);
		pcard.add(pAnh);
		pcard.add(Box.createVerticalStrut(3));
		pTen.add(lblTen);
		pcard.add(pTen);
		pcard.add(Box.createVerticalStrut(3));
		pGia.add(lblGia);
		pcard.add(pGia);
		pcard.add(Box.createVerticalStrut(3));
		add(pcard);
		pcard.setBorder(new LineBorder(Color.BLACK));
		
//		setBackground(new Color(210, 205, 220));
//		setSize(153,200);
//		setLayout(null);
//		
//		JLabel lblTen = new JLabel(ten);
//		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTen.setBounds(10, 138, 133, 20);
//		add(lblTen);
//		
//		JLabel lblGia = new JLabel(gia);
//		lblGia.setHorizontalAlignment(SwingConstants.CENTER);
//		lblGia.setBounds(10, 169, 133, 20);
//		add(lblGia);
//		
//		JLabel lblAnhSP = new JLabel("Ảnh sp");
//		lblAnhSP.setHorizontalAlignment(SwingConstants.CENTER);
//		lblAnhSP.setBounds(23, 11, 108, 121);
//		add(lblAnhSP);
//		
//		ImageIcon imgicon = new ImageIcon(CardProducts.class.getResource(path));
//		Image img1 = imgicon.getImage();
//		Image img2 = img1.getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH);
//		imgicon = new ImageIcon(img2);
//		lblAnhSP.setIcon(imgicon);
		
		
	}
}