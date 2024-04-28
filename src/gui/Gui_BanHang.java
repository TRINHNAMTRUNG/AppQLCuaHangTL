package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;

import bus.BUS_ChiTietHoaDon;
import bus.BUS_HoaDon;
import bus.BUS_KhachHang;
import bus.BUS_SanPham;
import custom_Gui.CardProducts;
import custom_Gui.CustomTableHeaderRenderer;
import custom_Gui.DialogAddCustomers;
import custom_Gui.DialogHoaDon;
import custom_Gui.DialogSL;
import entity.ChiTietHoaDon;
import entity.DonVi;
import entity.GiaSanPham;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

public class Gui_BanHang extends JPanel implements ActionListener, DocumentListener, ItemListener, MouseListener{
	private JTextField txtTimSP;
	private JTextField txtMaVach;
	private JTextField txtSdt;
	private DefaultTableModel modelSanPham;
	private JTable tableSanPham;
	private JScrollPane scrollTableSanPham;
	private BUS_SanPham busSanPham = new BUS_SanPham();
	private JPanel pHoaDon;
	private JPanel pWrapSP;
	private JLabel lblTimSP;
	private JButton btnLamMoiGH;
	private JPanel pBarThanhToan;
	private JLabel lblMaVach;
	private JLabel lblTongTien;
	private JLabel lblTongTienHD;
	private JLabel lblValueTongTienHD;
	private JLabel lblValueTongTien;
	private JLabel lblTienKhach;
	private JLabel lblTienThua;
	private JLabel lblValueTienThua;
	private JPanel pTichDiem;
	private JLabel lblSdt;
	private JButton btnThemKhach;
	private JLabel lblDiem;
	private JButton btnHuy;
	private JButton btnTimSDT;
	private JLabel lblDiemDoi;
	private JLabel lblValueDiem;
	private JButton btnThanhToan;

	private BUS_KhachHang bus_KhachHang = new BUS_KhachHang();
	private boolean StatusDoiTichDiem = false;
	private JTextField txtDiemDoi;
	private JCheckBox checkBoxDiem;
	private JLabel lblValueGiaCuoiCung;
	private JTextField lblValueTienKhach;
	private BUS_HoaDon bus_HoaDon = new BUS_HoaDon();
	private BUS_ChiTietHoaDon bus_ChiTietHoaDon = new BUS_ChiTietHoaDon();
	private JPanel pSP;
	public Gui_BanHang() {
		setSize(913,625);
		setLayout(null);

		pHoaDon = new JPanel();
		pHoaDon.setBackground(new Color(224, 240, 196));
		pHoaDon.setBounds(0, 0, 672, 246);
		add(pHoaDon);
		pHoaDon.setLayout(new BorderLayout(0, 0));
		String[] header = {"Mã vạch","Mã giá", "Tên SP", "DVT", "SL", "Đơn giá", "Thành tiền"};
		modelSanPham = new DefaultTableModel(header,0);
		tableSanPham = new JTable(modelSanPham);
		tableSanPham.setRowHeight(30); 
		tableSanPham.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer(tableSanPham));
		TableColumn column = tableSanPham.getColumnModel().getColumn(3);
		column.setPreferredWidth(90);
		tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(40);
		scrollTableSanPham = new JScrollPane(tableSanPham);
		pHoaDon.add(scrollTableSanPham);

		pWrapSP = new JPanel();
		pWrapSP.setBackground(new Color(220, 239, 218));
		pWrapSP.setBorder(new LineBorder(new Color(0, 0, 0)));
		pWrapSP.setBounds(0, 246, 672, 379);
		add(pWrapSP);
		pWrapSP.setLayout(null);

		lblTimSP = new JLabel("Tên hoặc mã sp:");
		lblTimSP.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTimSP.setBounds(10, 11, 114, 26);
		pWrapSP.add(lblTimSP);

		txtTimSP = new JTextField();
		txtTimSP.setBounds(124, 16, 278, 20);
		pWrapSP.add(txtTimSP);
		txtTimSP.setColumns(10);

		btnLamMoiGH = new JButton("Làm mới giỏ hàng");
		btnLamMoiGH.setBounds(412, 15, 161, 23);
		pWrapSP.add(btnLamMoiGH);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 652, 320);
		pWrapSP.add(scrollPane);

		pSP = new JPanel();
		pSP.setBackground(new Color(220, 239, 218));
		pSP.setLayout(new FlowLayout(FlowLayout.LEFT));
		pSP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		scrollPane.setViewportView(pSP);


		pBarThanhToan = new JPanel();
		pBarThanhToan.setBackground(new Color(220, 239, 218));
		pBarThanhToan.setBounds(673, 0, 240, 625);
		add(pBarThanhToan);
		pBarThanhToan.setLayout(null);

		lblMaVach = new JLabel("Mã vạch:");
		lblMaVach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblMaVach.setBounds(10, 11, 64, 26);
		pBarThanhToan.add(lblMaVach);

		lblTongTien = new JLabel("Tổng tiền sản phẩm:");
		lblTongTien.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTongTien.setBounds(10, 80, 155, 26);
		pBarThanhToan.add(lblTongTien);

		lblTongTienHD = new JLabel("Tổng tiền hóa đơn:");
		lblTongTienHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTongTienHD.setBounds(10, 155, 155, 26);
		pBarThanhToan.add(lblTongTienHD);

		lblValueTongTienHD = new JLabel("0");
		lblValueTongTienHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTongTienHD.setBackground(new Color(255, 255, 255));
		lblValueTongTienHD.setBounds(10, 192, 100, 26);
		pBarThanhToan.add(lblValueTongTienHD);

		lblValueTongTien = new JLabel("0");
		lblValueTongTien.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTongTien.setBounds(10, 117, 208, 26);
		pBarThanhToan.add(lblValueTongTien);

		lblTienKhach = new JLabel("Tiền khách trả:");
		lblTienKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTienKhach.setBounds(10, 229, 155, 26);
		pBarThanhToan.add(lblTienKhach);

		lblTienThua = new JLabel("Tiền thừa:");
		lblTienThua.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTienThua.setBounds(10, 303, 155, 26);
		pBarThanhToan.add(lblTienThua);

		lblValueTienThua = new JLabel("0");
		lblValueTienThua.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTienThua.setBackground(Color.WHITE);
		lblValueTienThua.setBounds(10, 333, 208, 26);
		pBarThanhToan.add(lblValueTienThua);

		pTichDiem = new JPanel();
		pTichDiem.setBackground(new Color(220, 239, 218));
		pTichDiem.setBounds(10, 364, 220, 198);
		pTichDiem.setBorder(BorderFactory.createTitledBorder("Tích đổi điểm"));
		pBarThanhToan.add(pTichDiem);
		pTichDiem.setLayout(null);

		lblSdt = new JLabel("SDT:");
		lblSdt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSdt.setBounds(10, 23, 36, 26);
		pTichDiem.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(56, 25, 96, 26);
		pTichDiem.add(txtSdt);

		btnThemKhach = new JButton("Thêm khách");
		btnThemKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnThemKhach.setBounds(10, 161, 200, 26);
		pTichDiem.add(btnThemKhach);

		lblDiem = new JLabel("Điểm:");
		lblDiem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDiem.setBounds(10, 56, 47, 26);
		pTichDiem.add(lblDiem);

		btnHuy = new JButton("Hủy tích đổi điểm");
		btnHuy.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnHuy.setBounds(10, 129, 200, 26);
		pTichDiem.add(btnHuy);

		btnTimSDT = new JButton("Tìm");
		btnTimSDT.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		btnTimSDT.setBounds(153, 24, 57, 26);
		pTichDiem.add(btnTimSDT);

		lblDiemDoi = new JLabel("Đổi:");
		lblDiemDoi.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDiemDoi.setBounds(10, 90, 36, 26);
		pTichDiem.add(lblDiemDoi);

		lblValueDiem = new JLabel("0");
		lblValueDiem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueDiem.setBounds(56, 56, 141, 26);
		pTichDiem.add(lblValueDiem);

		txtDiemDoi = new JTextField();
		txtDiemDoi.setBounds(56, 90, 96, 26);
		pTichDiem.add(txtDiemDoi);
		txtDiemDoi.setColumns(10);

		checkBoxDiem = new JCheckBox("Tối đa");
		checkBoxDiem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		checkBoxDiem.setBounds(153, 90, 61, 26);
		pTichDiem.add(checkBoxDiem);

		txtMaVach = new JTextField();
		txtMaVach.setBounds(10, 43, 208, 26);
		pBarThanhToan.add(txtMaVach);
		txtMaVach.setColumns(10);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnThanhToan.setBounds(20, 568, 198, 46);
		pBarThanhToan.add(btnThanhToan);

		txtDiemDoi.setEnabled(false);
		checkBoxDiem.setEnabled(false);
		checkBoxDiem.setSelected(true);

		lblValueGiaCuoiCung = new JLabel("");
		lblValueGiaCuoiCung.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueGiaCuoiCung.setBackground(Color.WHITE);
		lblValueGiaCuoiCung.setBounds(118, 192, 100, 26);
		pBarThanhToan.add(lblValueGiaCuoiCung);

		lblValueTienThua.setForeground(new Color(0, 168, 84));
		lblValueTongTienHD.setForeground(new Color(0, 168, 84));
		lblValueTongTien.setForeground(new Color(0, 168, 84));

		lblValueTienKhach = new JTextField();
		lblValueTienKhach.setForeground(new Color(0, 168, 84));
		lblValueTienKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTienKhach.setBounds(10, 266, 208, 26);
		pBarThanhToan.add(lblValueTienKhach);
		lblValueTienKhach.setColumns(10);

		btnHuy.addActionListener(this);
		btnThemKhach.addActionListener(this);
		btnTimSDT.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnLamMoiGH.addActionListener(this);
		txtTimSP.getDocument().addDocumentListener(this);
		txtMaVach.getDocument().addDocumentListener(this);
		txtDiemDoi.getDocument().addDocumentListener(this);
		lblValueTienKhach.getDocument().addDocumentListener(this);
		checkBoxDiem.addItemListener(this);
		tableSanPham.addMouseListener(this);
		renderListSP();
	}
	public void timKiemMa() {
		ArrayList<SanPham> list = busSanPham.timKiemMaHoacTen(txtTimSP.getText());
		DecimalFormat pattern = new DecimalFormat("#,###");
		pSP.removeAll();
		pSP.revalidate();

		for (SanPham sp : list) {
			JPanel card = new CardProducts("/image/"+ sp.getGiaSanPham().getAnhSanPham(), sp.getTenSanPham(),pattern.format(sp.getGiaSanPham().getDonGia()) , sp.getGiaSanPham().getSoLuong());
			pSP.add(card);
			pSP.add(Box.createHorizontalStrut(10));
			System.out.println(sp);
		}
		pSP.repaint();
	}
	public void renderListSP() {
		ArrayList<SanPham> list = busSanPham.getAllSanPham();
		DecimalFormat pattern = new DecimalFormat("#,###");
		for (SanPham sp : list) {
			JPanel card = new CardProducts("/image/"+ sp.getGiaSanPham().getAnhSanPham(), sp.getTenSanPham(),pattern.format(sp.getGiaSanPham().getDonGia()), sp.getGiaSanPham().getSoLuong());
			pSP.add(card);
			pSP.add(Box.createHorizontalStrut(10));
			System.out.println(sp);
		}
		pSP.revalidate();
		pSP.repaint();
	}
	public int kiemTraCongDon(String maSP) {
		for (int row = 0; row < modelSanPham.getRowCount(); row++) {
			String cellValue = (String) modelSanPham.getValueAt(row, 0); // Lấy giá trị ở cột đầu tiên của hàng row
			if (cellValue.equals(maSP)) {
				return row; // Trả về vị trí của hàng có mã trùng khớp
			}
		}
		return -1;
	}
	public void capNhatTienThanhToan() {
		DecimalFormat pattern = new DecimalFormat("#,###");
		double tongTienHD = 0;
		double tongTien = 0;
		double donGia=0;
		int sl=0;
		for (int row = 0; row < modelSanPham.getRowCount(); row++) {
			tongTienHD += parseFormat(modelSanPham.getValueAt(row, 6).toString());
			sl = Integer.parseInt(modelSanPham.getValueAt(row, 4).toString());
			donGia = parseFormat(modelSanPham.getValueAt(row, 5).toString());
			tongTien += (sl*donGia);
		}
		lblValueTongTien.setText(pattern.format(tongTien) );
		lblValueTongTienHD.setText(pattern.format(tongTienHD) );

	}
	public void capNhatRowSP(int row, int slMoi) {
		double thanhTienMoi;
		double thanhTien =  parseFormat(modelSanPham.getValueAt(row, 5).toString());
		thanhTienMoi = (thanhTien + (thanhTien*0.1)) * slMoi;
		modelSanPham.setValueAt(slMoi, row, 4);
		modelSanPham.setValueAt(formatMonney(thanhTienMoi), row, 6);
	}
	public String taoMaGiaSanPham(String maSP, String maDonVi) {
		char[] arrMaSP = maSP.toCharArray();
		String maGia = "";
		for(int i = 7; i<=11; i++) {
			maGia += arrMaSP[i];
		}
		maGia += maDonVi;
		return maGia.trim();
	}
	public void themSPVaoGio(String maSP) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				ArrayList<SanPham> listSP = busSanPham.timKiemMaHoacTen(maSP);
				if(listSP.size()!=0) {
					int row = kiemTraCongDon(maSP);
					if(row!=-1) {
						int slMoi = Integer.parseInt(modelSanPham.getValueAt(row, 4).toString()) +1;

						capNhatRowSP(row, slMoi);
						System.out.println("row:"+row +"   slMoi:" + slMoi+"  real cell: "+ modelSanPham.getValueAt(row, 4).toString());
						capNhatTienThanhToan();
						if(StatusDoiTichDiem) {
							if(checkBoxDiem.isSelected()) {
								doiDiemToida();
							}else {
								doiDiemKhongToiDa();
							}
						}
						updateTienThua();
						txtMaVach.setText("");
					}else {

						DecimalFormat pattern = new DecimalFormat("#,###");
						// Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm mới
						SanPham sanPham = listSP.get(0);
						String dv = sanPham.getGiaSanPham().getDonVi().getTenDonVi();
						double thanhTien = sanPham.getGiaSanPham().getDonGia() + (sanPham.getGiaSanPham().getDonGia() * 0.1);

						Object[] newRow = {sanPham.getMaSanPham(), sanPham.getGiaSanPham().getMaGiaSanPham(), sanPham.getTenSanPham(), dv, 1, pattern.format(sanPham.getGiaSanPham().getDonGia()), pattern.format(thanhTien)};
						modelSanPham.addRow(newRow);

						capNhatRowSP(kiemTraCongDon(maSP), 1);
						capNhatTienThanhToan();
						if (StatusDoiTichDiem) {
							if (checkBoxDiem.isSelected()) {
								doiDiemToida();
							} else {
								doiDiemKhongToiDa();
							}
						}
						updateTienThua();
						txtMaVach.setText("");
					}
				}
			}
		});

	}
	public double parseFormat(String num) {
		DecimalFormat pattern = new DecimalFormat("#,###");
		try {
			return pattern.parse(num).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public String formatMonney(double num) {
		DecimalFormat pattern = new DecimalFormat("#,###");
		return pattern.format(num);
	}

	public static String taoMaHoaDon() {
		// Lấy thời gian hiện tại
		LocalDateTime now = LocalDateTime.now();

		// Format thời gian theo định dạng "yyyyMMddHHmmss"
		String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

		// Tạo mã hóa đơn từ thời gian và một số duy nhất (ví dụ: 3 chữ số ngẫu nhiên)
		String maHoaDon = formattedDateTime + getRandomNumber(100, 999);

		return maHoaDon;
	}

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	public boolean luuThongTinHoaDon(KhachHang kh, HoaDon hd) {
		boolean statusUpdate = false;
		ArrayList<ChiTietHoaDon> listCTHD = layThongTinCTHD(hd);
		statusUpdate = bus_HoaDon.addHoaDon(hd);
		for (ChiTietHoaDon cthd : listCTHD) {
			statusUpdate = bus_ChiTietHoaDon.addChiTietHoaDon(cthd);
			statusUpdate = busSanPham.updateSoLuongSP(cthd.getSl(), cthd.getSp().getGiaSanPham().getMaGiaSanPham());
		}
		return statusUpdate;
	}
	public ArrayList<ChiTietHoaDon> layThongTinCTHD(HoaDon hd){
		ChiTietHoaDon cthd;
		ArrayList<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();
		String maGiaSanPham;
		double thanhTien;
		int sl;	
		for (int row = 0; row < modelSanPham.getRowCount(); row++) {
			thanhTien = parseFormat(modelSanPham.getValueAt(row, 6).toString());
			SanPham sp = new SanPham();
			maGiaSanPham = modelSanPham.getValueAt(row, 1).toString();
			GiaSanPham giaSP = new GiaSanPham();
			giaSP.setMaGiaSanPham(maGiaSanPham.trim());
			giaSP.setDonGia(parseFormat(modelSanPham.getValueAt(row, 5).toString()));
			sp.setGiaSanPham(giaSP);
			sp.setTenSanPham(modelSanPham.getValueAt(row, 2).toString());
			DonVi dv = new DonVi();
			dv.setTenDonVi(modelSanPham.getValueAt(row, 3).toString());
			sp.getGiaSanPham().setDonVi(dv);;
			sp.setTenSanPham(modelSanPham.getValueAt(row, 2).toString());
			sl = Integer.parseInt(modelSanPham.getValueAt(row, 4).toString());
			cthd = new ChiTietHoaDon(hd, sp, sl, thanhTien);
			listCTHD.add(cthd);
			System.out.println("CTHD123: "+cthd);

		}
		return listCTHD;
	}
	public HoaDon layThongTinHD() {
		KhachHang kh;
		if(StatusDoiTichDiem) {
			kh = bus_KhachHang.getKhach(txtSdt.getText());
		}else {
			kh =new KhachHang();
			kh.setMaKH(null);
		}
		String maHoaDon = taoMaHoaDon();
		NhanVien nv = new NhanVien(); 
		nv.setMaNhanVien(GUI_DangNhap.maNhanVienHienTai);
		LocalDateTime ngayLap =  LocalDateTime.now();
		double tienThua = parseFormat(lblValueTienThua.getText());
		double tienKhach =  parseFormat(lblValueTienKhach.getText());
		double tongTien;
		int diemSuDung =0;


		if(lblValueGiaCuoiCung.getText().equals("")) {
			tongTien = parseFormat(lblValueTongTienHD.getText());
		}else {
			diemSuDung = (int)(parseFormat(lblValueTongTienHD.getText()) - parseFormat(lblValueGiaCuoiCung.getText()));
			tongTien = parseFormat(lblValueGiaCuoiCung.getText());
		}
		HoaDon hd = new HoaDon(maHoaDon, nv, kh, ngayLap, tongTien, tienThua, tienKhach, diemSuDung);
		return hd;
	}
	public DialogHoaDon xemTruocHoaDon(ArrayList<ChiTietHoaDon> listCTHD, HoaDon hd) {
		double tongTien;
		tongTien = parseFormat(lblValueTongTienHD.getText());
		DialogHoaDon dialogHoaDon = new DialogHoaDon(this, listCTHD, hd, tongTien);
		return dialogHoaDon;
	}
	public boolean validTruocThanhToan() {
		if(modelSanPham.getRowCount()==0) {
			JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào trong giỏ!");
			return false;
		}else if(lblValueTienKhach.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tiền khách!");
			return false;
		}else if(parseFormat(lblValueTienThua.getText()) <0) {
			JOptionPane.showMessageDialog(this, "Tiền khách trả không đủ thanh toán!");
			return false;
		}else {
			return true;
		}
	}
	public boolean thanhToan(HoaDon hd) {
		KhachHang kh = bus_KhachHang.getKhach(txtSdt.getText());
		if(StatusDoiTichDiem) {
			doiDiem(kh);
			tichDiem(kh);
			if(updateDiem(kh) && luuThongTinHoaDon(kh, hd)) {
				return true;
			}else {
				return false;
			}
		}else {
			if(luuThongTinHoaDon(kh, hd)) {
				return true;
			}else {
				return false;
			}
		}
	}

	// commit 121
	public KhachHang tichDiem(KhachHang kh) {
		double tongTienHD = parseFormat(lblValueTongTienHD.getText());
		int diemTichLuy = (int)(tongTienHD*0.01);
		kh.setDiemTichLuy(kh.getDiemTichLuy()+diemTichLuy);
		return kh;
	}
	public void doiDiem(KhachHang kh) {
		double tongTienHD = parseFormat(lblValueTongTienHD.getText());
		int diemDoiToiDa = (int)Math.ceil(tongTienHD * 0.1);
		if(checkBoxDiem.isSelected()) {
			if(kh.getDiemTichLuy()>diemDoiToiDa) {
				kh.setDiemTichLuy(kh.getDiemTichLuy()-diemDoiToiDa);
			}
			if(kh.getDiemTichLuy()<diemDoiToiDa) {
				kh.setDiemTichLuy(0);
			}
		}else if(txtDiemDoi.getText().matches("^(?!0)\\d{1,}$")) {
			kh.setDiemTichLuy(kh.getDiemTichLuy()-Integer.parseInt(txtDiemDoi.getText()));
		}
	}
	public void huyTichDoiDiem() {
		StatusDoiTichDiem = false;
		txtSdt.setText("");
		lblValueDiem.setText("0");
		txtDiemDoi.setText("");
		txtDiemDoi.setEnabled(false);
		checkBoxDiem.setEnabled(false);
		updateTongTienSauDoiDiem(0);
	}
	public boolean updateDiem(KhachHang kh) {
		if(bus_KhachHang.updateKhach(kh)) {
			System.out.println("Doi diem thanh cong");
			return true;
		}else {
			System.out.println("Doi diem that bai");
			return false;
		}
	}

	public void updateTongTienSauDoiDiem(int diem) {
		if(diem > 0) {
			String tongTienHD = lblValueTongTienHD.getText();
			lblValueTongTienHD.setText(tongTienHD);
			lblValueTongTienHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
			lblValueTongTienHD.setForeground(Color.RED);
			lblValueGiaCuoiCung.setText(formatMonney(parseFormat(tongTienHD)-diem));
			lblValueGiaCuoiCung.setForeground(new Color(0, 168, 84));
		}else {
			capNhatTienThanhToan();
			lblValueGiaCuoiCung.setText("");
			lblValueTongTienHD.setForeground(new Color(0, 168, 84));
		}
	}
	public void updateTienThua() {
		if(lblValueTienKhach.getText().matches("^(?!0)\\d{1,}$")) {
			double tienThua;
			if(lblValueGiaCuoiCung.getText().equals("")) {
				tienThua = parseFormat(lblValueTienKhach.getText()) - parseFormat(lblValueTongTienHD.getText());
			}else {
				tienThua = parseFormat(lblValueTienKhach.getText()) - parseFormat(lblValueGiaCuoiCung.getText());
			}

			lblValueTienThua.setText(formatMonney(tienThua));
		}
	}
	public void doiDiemToida() {
		double tongTienHD = parseFormat(lblValueTongTienHD.getText());
		int diemDoiToiDa = (int)Math.ceil(tongTienHD * 0.1);
		if(Integer.parseInt(lblValueDiem.getText())>diemDoiToiDa) {
			updateTongTienSauDoiDiem(diemDoiToiDa);
		}else {
			updateTongTienSauDoiDiem(Integer.parseInt(lblValueDiem.getText()));
		}
		updateTienThua();
	}
	public void doiDiemKhongToiDa() {
		if(txtDiemDoi.getText().matches("^(?!0)\\d{1,}$")) {
			updateTongTienSauDoiDiem(Integer.parseInt(txtDiemDoi.getText()));
		}else {
			updateTongTienSauDoiDiem(0);
		}
		updateTienThua();
	}
	public void lamMoiGioHang() {
		modelSanPham.setRowCount(0);
		lblValueGiaCuoiCung.setText("0");
		lblValueTienThua.setText("0");
		lblValueTongTien.setText("0");
		lblValueTienKhach.setText("0");
		lblValueTongTienHD.setText("0");
		huyTichDoiDiem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnTimSDT)) {
			KhachHang kh = bus_KhachHang.getKhach(txtSdt.getText());
			if(kh!=null) {
				int choice = JOptionPane.showConfirmDialog(null, "Tìm thấy khách, bạn có muốn tích điểm ?", "Tích điểm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
				if(choice == JOptionPane.YES_OPTION) {
					StatusDoiTichDiem = true;
					lblValueDiem.setText(String.valueOf(kh.getDiemTichLuy()));
					checkBoxDiem.setEnabled(true);
					doiDiemToida();
				}
			}
		}
		if(obj.equals(btnHuy)) {
			huyTichDoiDiem();
		}
		if(obj.equals(btnThemKhach)) {
			DialogAddCustomers dialog = new DialogAddCustomers(this);
			doiDiemKhongToiDa();
			dialog.setVisible(true);
		}
		if(obj.equals(btnThanhToan)) {
			if(validTruocThanhToan()) {
				HoaDon hd = layThongTinHD();
				DialogHoaDon dialogHD = xemTruocHoaDon(layThongTinCTHD(hd), hd);
				dialogHD.setVisible(true);
				if(dialogHD.getStatusXacNhan()) {
					if(thanhToan(hd)) {
						JOptionPane.showMessageDialog(this, "Thanh toán thành công");
					}else {
						JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
					}
				}
			}
		}
		if(obj.equals(btnLamMoiGH)) {
			lamMoiGioHang();
		}
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		if(doc.equals(txtTimSP.getDocument())) {
			timKiemMa();
		}
		if(doc.equals(txtMaVach.getDocument())) {
			String maVach = txtMaVach.getText();
			if(maVach.matches("^\\d{13}$")) {
				themSPVaoGio(maVach);
			}
		}
		if(doc.equals(txtDiemDoi.getDocument())) {
			doiDiemKhongToiDa();
		}
		if(doc.equals(lblValueTienKhach.getDocument())) {
			updateTienThua();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		if(doc.equals(txtTimSP.getDocument())) {
			timKiemMa();
		}
		if(!txtMaVach.getText().equals("")) {
			if(doc.equals(txtMaVach.getDocument())) {
				String maVach = txtMaVach.getText();
				if(maVach.matches("^\\d{13}$")) {
					themSPVaoGio(maVach);
				}
			}
		}
		if(doc.equals(txtDiemDoi.getDocument())) {
			doiDiemKhongToiDa();
		}
		if(doc.equals(lblValueTienKhach.getDocument())) {
			updateTienThua();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		if(doc.equals(txtTimSP.getDocument())) {
			timKiemMa();
		}
		if(doc.equals(txtMaVach.getDocument())) {
			String maVach = txtMaVach.getText();
			if(maVach.matches("^\\d{13}$")) {
				themSPVaoGio(maVach);
			}
		}
		if(doc.equals(txtDiemDoi.getDocument())) {
			doiDiemKhongToiDa();
		}
		if(doc.equals(lblValueTienKhach.getDocument())) {
			updateTienThua();
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox checkBox = (JCheckBox) e.getSource();
		if(checkBox.equals(checkBoxDiem)) {
			if(checkBox.isSelected()) {
				txtDiemDoi.setEnabled(false);
				txtDiemDoi.setText("");
				doiDiemToida();
			}else {
				txtDiemDoi.setEnabled(true);
				doiDiemKhongToiDa();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableSanPham.getSelectedRow();
		if (row != -1) {
			int choice = JOptionPane.showOptionDialog(null, "Chỉnh sửa sản phẩm", "Edit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Xóa SP", "Sửa SP"}, null);
			if(choice==JOptionPane.YES_OPTION) {
				if(tableSanPham.getRowCount()==1) {
					lamMoiGioHang();
				}else {
					modelSanPham.removeRow(row);
					capNhatTienThanhToan();
					if (StatusDoiTichDiem) {
						if (checkBoxDiem.isSelected()) {
							doiDiemToida();
						} else {
							doiDiemKhongToiDa();
						}
					}
					updateTienThua();
				}
			}else if(choice==JOptionPane.NO_OPTION){
				ArrayList<SanPham> listSP = busSanPham.timKiemMaHoacTen(modelSanPham.getValueAt(row, 0).toString());
				ArrayList<DonVi> listDV = new ArrayList<DonVi>();
				for (SanPham sanPham : listSP) {
					listDV.add(sanPham.getGiaSanPham().getDonVi());
				}
				DialogSL dialogsl = new DialogSL(this, listDV, Integer.parseInt(modelSanPham.getValueAt(row, 4).toString()));
				dialogsl.setVisible(true);
				int slNew = dialogsl.getSLMoi();
				DonVi dvMoi = dialogsl.getDonViMoi();
				if(slNew !=-1) {
					modelSanPham.setValueAt(slNew, row, 4);
				}
				modelSanPham.setValueAt(dvMoi.getTenDonVi(), row, 3);
				String maGia = taoMaGiaSanPham(modelSanPham.getValueAt(row, 0).toString(), dvMoi.getMaDonVi());
				modelSanPham.setValueAt(maGia, row, 1);
				modelSanPham.setValueAt(formatMonney(busSanPham.getGiaSanPham(maGia).getGiaSanPham().getDonGia()) , row, 5);
				capNhatRowSP(row, Integer.parseInt(modelSanPham.getValueAt(row, 4).toString()));
				capNhatTienThanhToan();
				if (StatusDoiTichDiem) {
					if (checkBoxDiem.isSelected()) {
						doiDiemToida();
					} else {
						doiDiemKhongToiDa();
					}
				}
				updateTienThua();
			}
		}
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
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub\
	}
}
