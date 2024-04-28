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
import java.awt.FlowLayout;
import java.awt.Font;

public class CardProducts extends JPanel{

	private Box pcard;
	private JPanel pAnh;
	private GradientPanel pGia;
	private JPanel pTen;
	private JLabel lblAnh;
	private JLabel lblGia;
	private JLabel lblTen;
	private JLabel lblSL;
	private JPanel pSL;

	public CardProducts(String path, String ten, String gia, int sl) {
		setPreferredSize(new Dimension(153, 260));
		setLayout(new BorderLayout());
		RoundedPanel pRound = new RoundedPanel(16);
		pcard = Box.createVerticalBox();
		pcard.setBackground(new Color(255, 255, 255));
		pRound.add(pcard);
//		pcard.setPreferredSize(new Dimension(153,200));
		
		pAnh = new JPanel();
		pGia = new GradientPanel();
		pSL = new JPanel();
		pTen = new JPanel();
		
		lblAnh = new JLabel();
		lblGia = new JLabel(gia+ " VND");
		lblGia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblSL = new JLabel("SL: "+sl);
		lblSL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblTen = new JLabel("<html><div style='word-wrap: break-word; vertical-align: middle;text-align: center;'>" + ten + "</div></html>");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblTen.setPreferredSize(new Dimension(135, 30));
		
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
		pSL.add(lblSL);
		pcard.add(pSL);
		JPanel pTemp = new JPanel();
		pTemp.setLayout(new BorderLayout());
		pcard.add(pTemp);
		add(pRound);
	}
}