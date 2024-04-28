package custom_Gui;

import javax.swing.*;


import entity.ChiTietHoaDon;
import entity.HoaDon;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DialogHoaDon extends JDialog implements ActionListener {
    private JButton btnXacNhan;
    private JLabel lblTitle;
	private JButton btnHuy;
	private JPanel panel;
	private JLabel lblMaHD;
	private JLabel lblDonVi;
	private JScrollPane scrollPCTHD;
	private JPanel pCTHD;
	private JPanel pTitleHD;
	private JLabel lblSoLuong;
	private JLabel lblGiaBan;
	private JLabel lblThanhTien;
	private JLabel lblDonVi_1;
	private JLabel lblPhaiThanhToan;
	private JLabel lblValuePhaiThanhToan;
	private JLabel lblVND;
	private JLabel lblTienKhach;
	private JLabel lblTongHD;
	private JLabel lblValueTongHD;
	private JLabel lblVND_1;
	private JLabel lblDiem;
	private JLabel lblValueDiem;
	private JLabel lblTienThua;
	private JLabel lblValueTienKhach;
	private JLabel lblVND_2;
	private JLabel lblValueTienThua;
	private JLabel lblVND_2_1;
	private JLabel lblim;
	private JLabel lblChiTietHD;
	private JLabel lblValueMaHD;
	private boolean statusXacNhan = false;
	private ArrayList<ChiTietHoaDon> listCthdPDF;
	private HoaDon hdPDF;
	private String tongGiaSPPDF;

    public DialogHoaDon(JPanel parentPanel,ArrayList<ChiTietHoaDon> listCthd, HoaDon hd, double tongGiaSP) {
        super((JFrame) SwingUtilities.getWindowAncestor(parentPanel), "Hóa Đơn", true);
        listCthdPDF = listCthd;
    	hdPDF = hd;
    	tongGiaSPPDF = formatMonney(tongGiaSP);
    	
        setSize(381, 497);
        setLocationRelativeTo((JFrame) SwingUtilities.getWindowAncestor(parentPanel));
        getContentPane().setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(null);

        lblTitle = new JLabel("PHIẾU THANH TOÁN CỬA HÀNG TIỆN LỢI");
        lblTitle.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setBounds(46, 11, 285, 27);
        panel.add(lblTitle);

        lblMaHD = new JLabel("Mã hóa đơn:");
        lblMaHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        lblMaHD.setBounds(10, 36, 105, 14);
        panel.add(lblMaHD);

        btnXacNhan = new JButton("Xác nhận");
        btnXacNhan.setBounds(257, 422, 100, 27);
        panel.add(btnXacNhan);

        
       
        getContentPane().add(panel, BorderLayout.CENTER);
        
        btnHuy = new JButton("Hủy");
        btnHuy.setBounds(10, 422, 100, 27);
        panel.add(btnHuy);
        
        lblDonVi = new JLabel("--------------------------------------------------------------------------------------");
        lblDonVi.setBounds(10, 74, 347, 14);
        panel.add(lblDonVi);
        
        scrollPCTHD = new JScrollPane();
        scrollPCTHD.setBounds(10, 113, 347, 166);
        panel.add(scrollPCTHD);
        
        pCTHD = new JPanel();
        scrollPCTHD.setViewportView(pCTHD);
        
        pTitleHD = new JPanel();
        pTitleHD.setBounds(20, 84, 337, 27);
        panel.add(pTitleHD);
        pTitleHD.setLayout(new GridLayout(0, 3, 0, 0));
        
        lblSoLuong = new JLabel("SL");
        lblSoLuong.setForeground(new Color(0, 0, 255));
        lblSoLuong.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        pTitleHD.add(lblSoLuong);
        
        lblGiaBan = new JLabel("Giá bán (VND)");
        lblGiaBan.setForeground(new Color(0, 0, 255));
        lblGiaBan.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        pTitleHD.add(lblGiaBan);
        
        lblThanhTien = new JLabel("Thành tiền (VAT)");
        lblThanhTien.setForeground(new Color(0, 0, 255));
        lblThanhTien.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        pTitleHD.add(lblThanhTien);
        
        lblDonVi_1 = new JLabel("--------------------------------------------------------------------------------------");
        lblDonVi_1.setBounds(10, 278, 347, 14);
        panel.add(lblDonVi_1);
        
        lblPhaiThanhToan = new JLabel("Phải thanh toán:");
        lblPhaiThanhToan.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblPhaiThanhToan.setBounds(10, 339, 121, 20);
        panel.add(lblPhaiThanhToan);
        
        
        lblValuePhaiThanhToan = new JLabel(formatMonney(hd.getTongTien()));
        lblValuePhaiThanhToan.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblValuePhaiThanhToan.setBounds(220, 342, 93, 14);
        panel.add(lblValuePhaiThanhToan);
        
        lblVND = new JLabel("VND");
        lblVND.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblVND.setBounds(320, 342, 37, 14);
        panel.add(lblVND);
        
        lblTienKhach = new JLabel("Tiền khách:");
        lblTienKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblTienKhach.setBounds(10, 365, 121, 20);
        panel.add(lblTienKhach);
        
        lblTongHD = new JLabel("Tổng hóa đơn:");
        lblTongHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblTongHD.setBounds(10, 290, 121, 20);
        panel.add(lblTongHD);
        
        ///----------------
        
        lblValueTongHD = new JLabel(formatMonney(tongGiaSP));
        lblValueTongHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblValueTongHD.setBounds(220, 290, 93, 14);
        panel.add(lblValueTongHD);
        
        lblVND_1 = new JLabel("VND");
        lblVND_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblVND_1.setBounds(320, 290, 37, 14);
        panel.add(lblVND_1);
        
        lblDiem = new JLabel("Điểm sử dụng:");
        lblDiem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblDiem.setBounds(10, 314, 121, 20);
        panel.add(lblDiem);
        
        lblTienThua = new JLabel("Tiền Thừa:");
        lblTienThua.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblTienThua.setBounds(10, 390, 121, 20);
        panel.add(lblTienThua);
        
        lblValueDiem = new JLabel(String.valueOf(hd.getDiemSuDung()));
        lblValueDiem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblValueDiem.setBounds(220, 317, 93, 14);
        panel.add(lblValueDiem);
        
        lblValueTienKhach = new JLabel(formatMonney(hd.getTienKhach()));
        lblValueTienKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblValueTienKhach.setBounds(220, 370, 93, 14);
        panel.add(lblValueTienKhach);
        
        lblVND_2 = new JLabel("VND");
        lblVND_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblVND_2.setBounds(320, 370, 37, 14);
        panel.add(lblVND_2);
        
        lblValueTienThua = new JLabel(formatMonney(hd.getTienThua()));
        lblValueTienThua.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblValueTienThua.setBounds(220, 397, 93, 14);
        panel.add(lblValueTienThua);
        
        lblVND_2_1 = new JLabel("VND");
        lblVND_2_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblVND_2_1.setBounds(320, 397, 37, 14);
        panel.add(lblVND_2_1);
        
        lblim = new JLabel("Điểm");
        lblim.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        lblim.setBounds(320, 317, 47, 14);
        panel.add(lblim);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = hd.getNgayLap().format(formatter);
        lblChiTietHD = new JLabel("IdKhach: "+hd.getKh().getMaKH()+" - Date: "+ formattedDateTime+ " - NV: "+hd.getNv().getMaNhanVien());
        lblChiTietHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        lblChiTietHD.setBounds(10, 59, 347, 14);
        panel.add(lblChiTietHD);
        
        lblValueMaHD = new JLabel(hd.getMaHoaDon());
        lblValueMaHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        lblValueMaHD.setBounds(117, 36, 182, 14);
        panel.add(lblValueMaHD);
        pCTHD.setLayout(new BorderLayout(0, 0));
        
        Box boxCen = Box.createVerticalBox();
        pCTHD.add(boxCen);
        for (ChiTietHoaDon chiTietHoaDon : listCthd) {
        	
			JPanel pRow = new JPanel(new GridLayout(1, 3));
			JPanel pName = new JPanel();
			pName.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel lblSL = new JLabel(String.valueOf(chiTietHoaDon.getSl()));
			JLabel lblDG = new JLabel(formatMonney(chiTietHoaDon.getSp().getGiaSanPham().getDonGia()));
			JLabel lblTT = new JLabel(formatMonney(chiTietHoaDon.getThanhTien()));
			JLabel lblTenSP = new JLabel(chiTietHoaDon.getSp().getTenSanPham() + " ( " +chiTietHoaDon.getSp().getGiaSanPham().getDonVi().getTenDonVi()+" )");
			lblSL.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblDG.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblTT.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			pName.add(lblTenSP);
			pRow.add(lblSL);
			pRow.add(lblDG);
			pRow.add(lblTT);
			boxCen.add(pName);
			boxCen.add(pRow);
		}
        JPanel temp = new JPanel();
        temp.setLayout(new BorderLayout());
        boxCen.add(temp);
        btnHuy.addActionListener(this);
        btnXacNhan.addActionListener(this);
        
    }
    public String formatMonney(double num) {
		DecimalFormat pattern = new DecimalFormat("#,###");
		return pattern.format(num);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXacNhan)) {
        	statusXacNhan = true;
        	try {
        		PDFExporter pdf = new PDFExporter(listCthdPDF, hdPDF, tongGiaSPPDF);
				pdf.exportToPDF("HD"+hdPDF.getMaHoaDon()+".pdf");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	dispose();
        }
        if(o.equals(btnHuy)) {
        	statusXacNhan = false;
        	dispose();
        }
    }
    public boolean getStatusXacNhan() {
    	return statusXacNhan;
    }
}

