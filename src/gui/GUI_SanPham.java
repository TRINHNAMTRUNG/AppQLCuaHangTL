package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import bus.BUS_NhaCungCap;
import bus.BUS_SanPham;
import custom_Gui.CustomBtn;
import custom_Gui.CustomTableHeaderRenderer;
import custom_Gui.ImageScaler;
import custom_Gui.RoundButton;
import custom_Gui.copyImage;
import entity.DonVi;
import entity.GiaSanPham;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.SanPham;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI_SanPham extends JPanel implements ActionListener, MouseListener, DocumentListener{
	private JTable tableSanPham;
	private JTextField txtMaSP;
	private JTextField txtMaVach;
	private JTextField txtTenSP;
	private JTextField txtGiaBan;
	private JTextField txtGiaTu;
	private JTextField txtGiaDen;
	private JTextField txtSoLuong;

	private JComponent pTimKiem;
	private JPanel pT1;
	private JLabel lblTitleTimKiemSP;
	private JLabel lblTenOrMa;
	private JLabel lblLoi;
	private JLabel lblGiaTu;
	private JLabel lblGiaDen;
	private JLabel lblTinhTrang;
	private JComboBox<String> comboTinhTrang;
	private JComboBox<LoaiSanPham> comboLoaiTimKiem;
	private RoundButton btnTimKiem;
	private RoundButton btnLamMoiTimKiem;
	private JLabel lblVNDS;
	private JLabel lblVNDA;
	private JPanel pThongTinSanPham;
	private JPanel pT2;
	private JComponent lblTitleThongTinSP;
	private JLabel lblMaVach;
	private JLabel lblTenSanPham;
	private JLabel lblLoai;
	private JLabel lblNCC;
	private JComboBox<LoaiSanPham> comboLoai;
	private JLabel lblDonVi;
	private JComboBox<DonVi> comboDonVi;
	private JLabel lblGiaBan;
	private JLabel lblVND;
	private JLabel lblAnhSP;
	private JLabel lblSoLuong;
	private RoundButton btnChonFile;
	private RoundButton btnXoa;
	private RoundButton btnSua;
	private CustomBtn btnThem;
	private JScrollPane scrollTableSanPham;
	private DefaultTableModel modelTable;
	private DefaultComboBoxModel<LoaiSanPham> modelComBoLoaiTimKiem;
	private DefaultComboBoxModel<DonVi> modelComboDonVi;
	private DefaultComboBoxModel<NhaCungCap> modelComboNCC;

	ArrayList<SanPham> listSanPham;
	ArrayList<DonVi> listDonVi;
	ArrayList<LoaiSanPham> listLoaiSanPham;
	ArrayList<NhaCungCap> listNhaCungCap;

	private BUS_SanPham busSanPham;
	private BUS_NhaCungCap busNhaCungCap;
	private JTextField txtGiaVon;
	private JLabel lblGiaVon;
	private JLabel lblVND_1;
	private JLabel lblTinhTrangInfo;
	private JLabel lblKQTinhTrang;
	private JComboBox<NhaCungCap> comboNCC;
	private int selectedRow;
	private JFileChooser file;
	private ImageIcon myImage;
	private File f;
	private String p;
	private RoundButton btnLuu;
	private RoundButton btnHuy;
	private Object choosebtn;
	
	
	public GUI_SanPham() {
		setSize(913,625);
		setLayout(null);

		pTimKiem = new JPanel();
		pTimKiem.setBackground(new Color(119, 165, 187));
		pTimKiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		pTimKiem.setBounds(0, 0, 273, 310);
		add(pTimKiem);
		pTimKiem.setLayout(null);

		pT1 = new JPanel();
		pT1.setBackground(new Color(11, 102, 106));
		pT1.setBounds(0, 0, 273, 29);
		pTimKiem.add(pT1);

		lblTitleTimKiemSP = new JLabel("Tìm Kiếm");
		lblTitleTimKiemSP.setForeground(new Color(197, 224, 231));
		lblTitleTimKiemSP.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pT1.add(lblTitleTimKiemSP);

		lblTenOrMa = new JLabel("Tên hoặc Mã:");
		lblTenOrMa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenOrMa.setBounds(10, 40, 91, 29);
		pTimKiem.add(lblTenOrMa);

		lblLoi = new JLabel("Loại:");
		lblLoi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLoi.setBounds(10, 101, 91, 29);
		pTimKiem.add(lblLoi);

		lblGiaTu = new JLabel("Giá từ:");
		lblGiaTu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGiaTu.setBounds(10, 141, 91, 29);
		pTimKiem.add(lblGiaTu);

		lblGiaDen = new JLabel("Giá đến:");
		lblGiaDen.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGiaDen.setBounds(10, 181, 91, 29);
		pTimKiem.add(lblGiaDen);

		lblTinhTrang = new JLabel("Tình trạng:");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTinhTrang.setBounds(10, 221, 91, 29);
		pTimKiem.add(lblTinhTrang);

		String[] item = {"Còn hàng", "Hết hàng"};
		comboTinhTrang = new JComboBox<>(item);
		comboTinhTrang.setBounds(100, 225, 163, 23);
		pTimKiem.add(comboTinhTrang);

		modelComBoLoaiTimKiem = new DefaultComboBoxModel<>();
		comboLoaiTimKiem = new JComboBox<>(modelComBoLoaiTimKiem);
		comboLoaiTimKiem.setBounds(100, 105, 163, 23);
		pTimKiem.add(comboLoaiTimKiem);

		btnTimKiem = new RoundButton("Tìm", 10);
		btnTimKiem.setBackground(new Color(53, 94, 241));
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTimKiem.setBounds(162, 268, 101, 31);
		btnTimKiem.setFocusPainted(false);
		pTimKiem.add(btnTimKiem);

		btnLamMoiTimKiem = new RoundButton("Làm mới", 10);
		btnLamMoiTimKiem.setBackground(new Color(53, 94, 241));
		btnLamMoiTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLamMoiTimKiem.setBounds(10, 268, 101, 31);
		btnLamMoiTimKiem.setFocusPainted(false);
		pTimKiem.add(btnLamMoiTimKiem);

		lblVNDS = new JLabel("VND");
		lblVNDS.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVNDS.setBounds(239, 141, 34, 29);
		pTimKiem.add(lblVNDS);

		lblVNDA = new JLabel("VND");
		lblVNDA.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVNDA.setBounds(239, 181, 34, 29);
		pTimKiem.add(lblVNDA);

		txtMaSP = new JTextField();
		txtMaSP.setBounds(100, 44, 163, 23);
		pTimKiem.add(txtMaSP);
		txtMaSP.setColumns(10);

		txtGiaTu = new JTextField();
		txtGiaTu.setColumns(10);
		txtGiaTu.setBounds(100, 145, 135, 23);
		pTimKiem.add(txtGiaTu);

		txtGiaDen = new JTextField();
		txtGiaDen.setColumns(10);
		txtGiaDen.setBounds(100, 185, 135, 23);
		pTimKiem.add(txtGiaDen);

		pThongTinSanPham = new JPanel();
		pThongTinSanPham.setBackground(new Color(119, 165, 187));
		pThongTinSanPham.setBorder(new LineBorder(new Color(0, 0, 0)));
		pThongTinSanPham.setBounds(283, 0, 630, 310);
		add(pThongTinSanPham);
		pThongTinSanPham.setLayout(null);

		pT2 = new JPanel();
		pT2.setBackground(new Color(11, 102, 106));
		pT2.setBounds(0, 0, 630, 31);
		pThongTinSanPham.add(pT2);

		lblTitleThongTinSP = new JLabel("Thông Tin Sản Phẩm");
		lblTitleThongTinSP.setForeground(new Color(197, 224, 231));
		lblTitleThongTinSP.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pT2.add(lblTitleThongTinSP);

		lblMaVach = new JLabel("Mã vạch:");
		lblMaVach.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMaVach.setBounds(127, 42, 67, 29);
		pThongTinSanPham.add(lblMaVach);

		lblTenSanPham = new JLabel("Tên:");
		lblTenSanPham.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenSanPham.setBounds(127, 91, 67, 29);
		pThongTinSanPham.add(lblTenSanPham);

		lblLoai = new JLabel("Loại:");
		lblLoai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLoai.setBounds(421, 42, 54, 29);
		pThongTinSanPham.add(lblLoai);

		lblNCC = new JLabel("NCC:");
		lblNCC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNCC.setBounds(127, 181, 67, 29);
		pThongTinSanPham.add(lblNCC);

		comboLoai = new JComboBox<>(modelComBoLoaiTimKiem);
		comboLoai.setBounds(485, 46, 135, 23);
		pThongTinSanPham.add(comboLoai);

		lblDonVi = new JLabel("Đơn vị:");
		lblDonVi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDonVi.setBounds(421, 91, 54, 29);
		pThongTinSanPham.add(lblDonVi);

		modelComboDonVi = new DefaultComboBoxModel<>();
		comboDonVi = new JComboBox<>(modelComboDonVi);
		comboDonVi.setBounds(485, 95, 135, 23);
		pThongTinSanPham.add(comboDonVi);

		lblGiaBan = new JLabel("Giá bán:");
		lblGiaBan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGiaBan.setBounds(125, 141, 69, 29);
		pThongTinSanPham.add(lblGiaBan);

		lblVND = new JLabel("VND");
		lblVND.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVND.setBounds(363, 141, 34, 29);
		pThongTinSanPham.add(lblVND);

		txtMaVach = new JTextField();
		txtMaVach.setColumns(10);
		txtMaVach.setBounds(195, 46, 202, 23);
		pThongTinSanPham.add(txtMaVach);

		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(195, 95, 202, 23);
		pThongTinSanPham.add(txtTenSP);

		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(194, 142, 159, 23);
		pThongTinSanPham.add(txtGiaBan);

		lblAnhSP = new JLabel("");
		lblAnhSP.setIcon(new ImageIcon(GUI_SanPham.class.getResource("/image/noproductimage.png")));
		lblAnhSP.setBackground(new Color(192, 192, 192));
		lblAnhSP.setBounds(10, 42, 107, 128);
		pThongTinSanPham.add(lblAnhSP);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(485, 145, 135, 23);
		pThongTinSanPham.add(txtSoLuong);

		lblSoLuong = new JLabel("SL:");
		lblSoLuong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSoLuong.setBounds(421, 141, 54, 29);
		pThongTinSanPham.add(lblSoLuong);

		btnChonFile = new RoundButton("Chọn File", 5);
		btnChonFile.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChonFile.setBounds(20, 193, 89, 23);
		pThongTinSanPham.add(btnChonFile);
		btnChonFile.setBackground(new Color(53, 94, 241));
		btnChonFile.setBorder(null);
		btnChonFile.setFocusPainted(false);

		btnXoa = new RoundButton("Xóa", 5);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXoa.setBounds(127, 268, 90, 31);
		pThongTinSanPham.add(btnXoa);
		btnXoa.setBackground(new Color(53, 94, 241));
		btnXoa.setFocusPainted(false);

		btnSua = new RoundButton("Sửa", 5);
		btnSua.setForeground(new Color(0, 0, 0));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSua.setBounds(232, 268, 90, 31);
		pThongTinSanPham.add(btnSua);
		btnSua.setBackground(new Color(53,94,241));
		btnSua.setFocusPainted(false);

		btnThem = new CustomBtn("Thêm", null, 15, 0, 1);
		btnThem.setForeground(Color.decode("#ffffff"));
		btnThem.setIcon(new ImageScaler("/icon/icon_add.png", 18, 18).getScaledImageIcon());
		btnThem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnThem.setBounds(20, 268, 90, 31);
		pThongTinSanPham.add(btnThem);
		btnThem.setBackground(new Color(53, 94, 241));
		btnThem.setBorder(null);
		btnThem.setFocusPainted(false);

		lblGiaVon = new JLabel("Giá vốn:");
		lblGiaVon.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGiaVon.setBounds(127, 221, 69, 29);
		pThongTinSanPham.add(lblGiaVon);

		txtGiaVon = new JTextField();
		txtGiaVon.setColumns(10);
		txtGiaVon.setBounds(195, 225, 159, 23);
		pThongTinSanPham.add(txtGiaVon);

		lblVND_1 = new JLabel("VND");
		lblVND_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVND_1.setBounds(363, 221, 34, 29);
		pThongTinSanPham.add(lblVND_1);

		lblTinhTrangInfo = new JLabel("Tình trạng:");
		lblTinhTrangInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTinhTrangInfo.setBounds(421, 221, 80, 29);
		pThongTinSanPham.add(lblTinhTrangInfo);

		lblKQTinhTrang = new JLabel("");
		lblKQTinhTrang.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblKQTinhTrang.setBounds(498, 221, 108, 29);
		pThongTinSanPham.add(lblKQTinhTrang);

		modelComboNCC = new DefaultComboBoxModel<>();
		comboNCC = new JComboBox<>(modelComboNCC);
		comboNCC.setBounds(195, 185, 425, 23);
		pThongTinSanPham.add(comboNCC);

		btnLuu = new RoundButton("Sửa", 5);
		btnLuu.setText("Lưu");
		btnLuu.setForeground(Color.BLACK);
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLuu.setFocusPainted(false);
		btnLuu.setBackground(new Color(53, 94, 241));
		btnLuu.setBounds(431, 268, 60, 31);
		pThongTinSanPham.add(btnLuu);

		btnHuy = new RoundButton("Sửa", 5);
		btnHuy.setText("Hủy");
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHuy.setFocusPainted(false);
		btnHuy.setBackground(new Color(53, 94, 241));
		btnHuy.setBounds(548, 268, 60, 31);
		pThongTinSanPham.add(btnHuy);

		scrollTableSanPham = new JScrollPane();
		scrollTableSanPham.setBounds(0, 315, 913, 310);
		String[] header = {"Mã vạch","Mã giá", "Tên SP", "Giá", "DVT", "SL", "Nhà cung cấp", "Loại"};
		modelTable = new DefaultTableModel(header,0);
		tableSanPham = new JTable(modelTable);
		tableSanPham.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollTableSanPham.setViewportView(tableSanPham);
		tableSanPham.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer(tableSanPham));
		tableSanPham.getTableHeader().setPreferredSize(new Dimension(tableSanPham.getTableHeader().getWidth(), 30));
		add(scrollTableSanPham);


		busSanPham = new BUS_SanPham();
		listSanPham = busSanPham.getAllSanPham();
		DecimalFormat pattern = new DecimalFormat("#,###");
		for (SanPham sanPham : listSanPham) {
			Object[] newRow = {sanPham.getMaSanPham(),sanPham.getGiaSanPham().getMaGiaSanPham(), sanPham.getTenSanPham(),pattern.format(sanPham.getGiaSanPham().getDonGia()), sanPham.getGiaSanPham().getDonVi().getTenDonVi(), sanPham.getGiaSanPham().getSoLuong(), sanPham.getNhaCungCap().getTenNhaCungCap(), sanPham.getLoaiSanPham().getTenLoai()};
			modelTable.addRow(newRow);
			System.out.println(sanPham);
		}
		listDonVi = busSanPham.getAllDonVi();
		for (DonVi donVi : listDonVi) {
			modelComboDonVi.addElement(donVi);
		}
		listLoaiSanPham = busSanPham.getAllLoaiSanPham();
		for (LoaiSanPham loaiSanPham : listLoaiSanPham) {
			modelComBoLoaiTimKiem.addElement(loaiSanPham);
		}
		busNhaCungCap = new BUS_NhaCungCap();
		listNhaCungCap = busNhaCungCap.getAllNhaCungCap();
		for (NhaCungCap ncc : listNhaCungCap) {
			modelComboNCC.addElement(ncc);
		}
		btnChonFile.addActionListener(this);
		btnLamMoiTimKiem.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnHuy.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.setEnabled(false);
		btnLuu.setEnabled(false);
		tableSanPham.addMouseListener(this);
		txtMaSP.getDocument().addDocumentListener(this);
		TableColumn column = tableSanPham.getColumnModel().getColumn(2);
		column.setPreferredWidth(200);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if(obj.equals(btnLamMoiTimKiem)) {
			txtGiaDen.setText("");
			txtMaSP.setText("");
			txtGiaTu.setText("");
			comboLoaiTimKiem.setSelectedIndex(0);
			comboTinhTrang.setSelectedIndex(0);
			txtMaSP.requestFocus();
		}
		if(obj.equals(btnSua)) {
			selectedRow = tableSanPham.getSelectedRow();
			if(selectedRow != -1) {
				//				KhoaBangThongTin(false);
				txtMaSP.requestFocus();
				choosebtn = obj;
				khoabtn(true);
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần update!");
			}
		}
		if(obj.equals(btnThem)) {
			lamMoiThongTin();
			//			KhoaBangThongTin(false);
			txtMaSP.requestFocus();
			choosebtn = obj;
			khoabtn(true);
		}
		if(obj.equals(btnLuu)) {
			if(choosebtn.equals(btnThem)) {
				themSanPham();
			}
			if(choosebtn.equals(btnSua)) {
				updateSanPham();
			}
			if(choosebtn.equals(btnXoa)) {

			}
			//			KhoaBangThongTin(true);
			khoabtn(false);
		}
		if(obj.equals(btnHuy)) {

			//			KhoaBangThongTin(true);
			khoabtn(false);
		}
		if(obj.equals(btnTimKiem)) {
			timKiemDieuKiem();
		}
		if(obj.equals(btnXoa)) {
			lamMoiThongTin();
			//			KhoaBangThongTin(false);
			txtMaSP.requestFocus();
			choosebtn = obj;
			khoabtn(true);
		}
		if(obj.equals(btnChonFile)) {
			file = new JFileChooser();
			file.setCurrentDirectory(new File("user.dir"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpg", "jpeg", "gif");
			file.addChoosableFileFilter(filter);
			int a = file.showSaveDialog(null);
			if(a==JFileChooser.APPROVE_OPTION) {
				f = file.getSelectedFile();
				p = f.getAbsolutePath();
				lblAnhSP.setIcon(mySetIcon(p, null));
				String tenFileAnh = f.getName();
				System.out.println(tenFileAnh);
				lblAnhSP.putClientProperty("imageName", tenFileAnh);
			}
		}
	}
	public void khoabtn(boolean trangThai) {
		btnThem.setEnabled(!trangThai);
		btnSua.setEnabled(!trangThai);
		btnXoa.setEnabled(!trangThai);
		btnHuy.setEnabled(trangThai);
		btnLuu.setEnabled(trangThai);
	}
	public void lamMoiThongTin() {
		comboNCC.setSelectedIndex(0);
		txtMaVach.setText("");
		txtSoLuong.setText("");
		txtGiaBan.setText("");
		txtGiaVon.setText("");
		txtTenSP.setText("");
		comboDonVi.setSelectedIndex(0);
		comboLoai.setSelectedIndex(0);
		txtMaSP.requestFocus();
		lblAnhSP.setIcon(new ImageIcon(GUI_SanPham.class.getResource("/image/noproductimage.png")));
		lblKQTinhTrang.setText("Hết hàng");
	}
	public ImageIcon mySetIcon(String m, byte[] image) {
		if(m!=null) {
			myImage = new ImageIcon(m);
		}else {
			myImage = new ImageIcon(image);
		}
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		return i;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		selectedRow = tableSanPham.getSelectedRow();
		String maGiaSanPham;
		maGiaSanPham = tableSanPham.getValueAt(selectedRow, 1).toString();
		renderTTSanPham(maGiaSanPham);
	}
	public boolean valid() {
		DecimalFormat pattern = new DecimalFormat("#,###");
		String maSanPham = txtMaVach.getText();
		String tenSP = txtTenSP.getText();
		String giaVon = txtGiaVon.getText();
		String giaBan = txtGiaBan.getText();

		if(!maSanPham.matches("^\\d{13}$")) {
			JOptionPane.showMessageDialog(this, "Mã không được trống");
			return false;
		}
		if(tenSP.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Tên sản phẩm không được trống");
			return false;
		}
		if(txtGiaBan.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Giá bán không được trống");
			return false;
		}
		if(!giaBan.matches("^[0-9]+(?:,[0-9]+)?$")) {
			JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ");
			return false;
		}
		if(txtGiaVon.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Giá vốn không được trống");
			return false;
		}
		try {
			if(!giaVon.matches("^[0-9]+(?:,[0-9]+)?$") || pattern.parse(txtGiaVon.getText()).doubleValue() > pattern.parse(txtGiaBan.getText()).doubleValue()  ) {
				JOptionPane.showMessageDialog(this, "Giá vốn không âm hoặc > giá bán");
				return false;
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public SanPham layThongTin() {
		DecimalFormat pattern = new DecimalFormat("#,###");
		String maSanPham = txtMaVach.getText();
		String tenSanPham = txtTenSP.getText();
		NhaCungCap nhaCungCap = (NhaCungCap) comboNCC.getSelectedItem();
		LoaiSanPham loaiSanPham = (LoaiSanPham) comboLoai.getSelectedItem();
		String anhSanPham = (String) lblAnhSP.getClientProperty("imageName");

		DonVi donVi = (DonVi) comboDonVi.getSelectedItem();
		int soLuong = Integer.parseInt(txtSoLuong.getText());
		double giaBan = 0, giaVon = 0;
		boolean trangThai = false;
		if(lblKQTinhTrang.getText().equals("Còn hàng")) {
			trangThai = true;
			
		}
		try {
			giaBan = pattern.parse(txtGiaBan.getText()).doubleValue();
			giaVon = pattern.parse(txtGiaVon.getText()).doubleValue(); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String maGiaSanPham = "";
		GiaSanPham giaSanPham = new GiaSanPham(maGiaSanPham, anhSanPham, donVi, soLuong, giaBan, giaVon, trangThai);

		SanPham sanPham = new SanPham(maSanPham, tenSanPham, loaiSanPham, nhaCungCap, giaSanPham);
		return sanPham;
	}
	public boolean checkImageExists(String imageName) {
		File imageFile = new File("src/image/" + imageName); // Đường dẫn tới thư mục chứa hình ảnh
		return imageFile.exists(); // Kiểm tra xem tệp hình ảnh có tồn tại không
	}
	public boolean kiemTraTonTaiGia(SanPham sanPham) {
		boolean containsSimilarObject = listSanPham.stream().anyMatch(obj -> obj.getMaSanPham().equals(sanPham.getMaSanPham()) && obj.getGiaSanPham().getDonVi().getMaDonVi().equals(sanPham.getGiaSanPham().getDonVi().getMaDonVi()));
		return containsSimilarObject;
	}
	public boolean kiemTraTonTaiSanPham(SanPham sanPham) {
		boolean containsSimilarObject = listSanPham.stream().anyMatch(obj -> obj.getMaSanPham().equals(sanPham.getMaSanPham()));
		return containsSimilarObject;
	}

	public String taoMaGiaSanPham(String maSP, String maDonVi) {
		char[] arrMaSP = maSP.toCharArray();
		String maGia = "";
		Random random = new Random();
//		boolean isDuplicate; 
		for(int i = 7; i<=11; i++) {
			maGia += arrMaSP[i];
		}
		maGia += maDonVi;
//		do {
//			String newMaGia = maGia.trim() + String.format("%03d", random.nextInt(1000));
//			isDuplicate = listSanPham.stream().anyMatch(p -> p.getMaSanPham().equals(newMaGia));
//			if (!isDuplicate) {
//				maGia = newMaGia;
//			}
//		} while (isDuplicate);

		return maGia.trim();
	}
	public void themSanPham() {
		if(valid()) {
			SanPham sanPham = layThongTin();
			boolean kiemTraTonTaiSanPham = kiemTraTonTaiSanPham(sanPham);
			boolean kiemTraTonTaiGia= kiemTraTonTaiGia(sanPham);
			System.out.println(kiemTraTonTaiSanPham);
			if(!kiemTraTonTaiSanPham || (kiemTraTonTaiSanPham && !kiemTraTonTaiGia)) {
				String maGia = taoMaGiaSanPham(sanPham.getMaSanPham(), sanPham.getGiaSanPham().getDonVi().getMaDonVi());
				sanPham.getGiaSanPham().setMaGiaSanPham(maGia); 
				DecimalFormat pattern = new DecimalFormat("#,###");
				boolean status = busSanPham.addSanPham(sanPham, kiemTraTonTaiSanPham);
				if(status) {
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
					boolean checkImageExist = checkImageExists(sanPham.getGiaSanPham().getAnhSanPham());
					if(!checkImageExist) {
						try {
							System.out.println(p);
							copyImage.coppyExtention(p, sanPham.getGiaSanPham().getAnhSanPham());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					if(!txtGiaBan.getText().matches("^\\d{1,3}(,\\d{3})*$")) {
						String giabanF = pattern.format(Double.parseDouble(txtGiaBan.getText()));
						txtGiaBan.setText(giabanF);
						//						tableSanPham.setValueAt(txtGiaBan.getText(), selectedRow, 3);
					}
					//					else {
					//						tableSanPham.setValueAt(txtGiaBan.getText(), selectedRow, 3);
					//					}
					if(!txtGiaVon.getText().matches("^\\d{1,3}(,\\d{3})*$")) {
						String giaVonF = pattern.format(Double.parseDouble(txtGiaVon.getText()));
						txtGiaVon.setText(giaVonF);
					}
					Object[] newRow = {sanPham.getMaSanPham(),sanPham.getGiaSanPham().getMaGiaSanPham(), sanPham.getTenSanPham(),pattern.format(sanPham.getGiaSanPham().getDonGia()), sanPham.getGiaSanPham().getDonVi().getTenDonVi(), sanPham.getGiaSanPham().getSoLuong(), sanPham.getNhaCungCap().getTenNhaCungCap(), sanPham.getLoaiSanPham().getTenLoai()};
					modelTable.addRow(newRow);
					listSanPham.add(sanPham);
				}else {
					JOptionPane.showMessageDialog(this, "Thêm thất bại!");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại!");
			}

		}
	}
	public void updateSanPham() {
		if(valid()) { 
			DecimalFormat pattern = new DecimalFormat("#,###");
			SanPham sanPham = layThongTin();
			String maGiaSanPham = tableSanPham.getValueAt(selectedRow, 1).toString();
			sanPham.getGiaSanPham().setMaGiaSanPham(maGiaSanPham);
			boolean status = busSanPham.updateSanPham(sanPham);
			if(status) {
				JOptionPane.showMessageDialog(this, "Update thành công!");
				boolean checkImageExist = checkImageExists(sanPham.getGiaSanPham().getAnhSanPham());
				if(!checkImageExist) {
					try {
						System.out.println(p);
						copyImage.coppyExtention(p, sanPham.getGiaSanPham().getAnhSanPham());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(!txtGiaBan.getText().matches("^\\d{1,3}(,\\d{3})*$")) {
					String giabanF = pattern.format(Double.parseDouble(txtGiaBan.getText()));
					txtGiaBan.setText(giabanF);
					tableSanPham.setValueAt(txtGiaBan.getText(), selectedRow, 3);
				}else {
					tableSanPham.setValueAt(txtGiaBan.getText(), selectedRow, 3);
				}
				if(!txtGiaVon.getText().matches("^\\d{1,3}(,\\d{3})*$")) {
					String giaVonF = pattern.format(Double.parseDouble(txtGiaVon.getText()));
					txtGiaVon.setText(giaVonF);
				}
				tableSanPham.setValueAt(sanPham.getTenSanPham(), selectedRow, 2);
				tableSanPham.setValueAt(sanPham.getGiaSanPham().getDonVi().getTenDonVi(), selectedRow, 4);
				tableSanPham.setValueAt(sanPham.getNhaCungCap().getTenNhaCungCap(), selectedRow, 6);
				tableSanPham.setValueAt(sanPham.getLoaiSanPham().getTenLoai(), selectedRow, 7);
				OptionalInt index = IntStream.range(0, listSanPham.size()) .filter(i -> listSanPham.get(i).getGiaSanPham().getMaGiaSanPham().equals(maGiaSanPham)).findFirst();
				listSanPham.set(index.getAsInt(), sanPham);
			}else {
				JOptionPane.showMessageDialog(this, "Update thất bại!");
			}
		}
	}
	public void renderTTSanPham(String maGiaSanPham) {
		DecimalFormat pattern = new DecimalFormat("#,###");

		for (SanPham sanPham : listSanPham) {
			if(sanPham.getGiaSanPham().getMaGiaSanPham().equals(maGiaSanPham)) {
				txtMaVach.setText(sanPham.getMaSanPham());
				txtTenSP.setText(sanPham.getTenSanPham());
				txtGiaBan.setText(pattern.format(sanPham.getGiaSanPham().getDonGia()));
				NhaCungCap nhaCungCap = sanPham.getNhaCungCap();
				comboNCC.setSelectedItem(nhaCungCap);
				txtGiaVon.setText(pattern.format(sanPham.getGiaSanPham().getGiaVon()));
				LoaiSanPham loaiSanPham = sanPham.getLoaiSanPham();
				comboLoai.setSelectedItem(loaiSanPham);
				DonVi donVi = sanPham.getGiaSanPham().getDonVi();
				comboDonVi.setSelectedItem(donVi);
				txtSoLuong.setText(String.valueOf(sanPham.getGiaSanPham().getSoLuong()));
				if(sanPham.getGiaSanPham().isTrangThai()) {
					lblKQTinhTrang.setText("Còn hàng");
				}else {
					lblKQTinhTrang.setText("Hết hàng");
				}
				// tạo đối tượng imageicon có hình ảnh là đường dẫn trong src ứng với tên file ảnh trong dbs
				ImageIcon imgicon = new ImageIcon(GUI_SanPham.class.getResource("/image/"+sanPham.getGiaSanPham().getAnhSanPham()));
				Image img1 = imgicon.getImage();
				Image img2 = img1.getScaledInstance(lblAnhSP.getWidth(), lblAnhSP.getHeight(), Image.SCALE_SMOOTH);
				imgicon = new ImageIcon(img2);
				lblAnhSP.setIcon(imgicon);
				lblAnhSP.putClientProperty("imageName", sanPham.getGiaSanPham().getAnhSanPham());
				break;
			}
		}
	}
	public void timKiemMa() {
		ArrayList<SanPham> list = busSanPham.timKiemMaHoacTen(txtMaSP.getText());
		modelTable.setRowCount(0);
		DecimalFormat pattern = new DecimalFormat("#,###");
		for (SanPham sp : list) {
			Object[] newRow = {sp.getMaSanPham(),sp.getGiaSanPham().getMaGiaSanPham(), sp.getTenSanPham(),pattern.format(sp.getGiaSanPham().getDonGia()), sp.getGiaSanPham().getDonVi().getTenDonVi(), sp.getGiaSanPham().getSoLuong(), sp.getNhaCungCap().getTenNhaCungCap(), sp.getLoaiSanPham().getTenLoai()};
			modelTable.addRow(newRow);
		}
	}
	public void timKiemDieuKiem() {
		if(txtGiaTu.getText().isEmpty() && !txtGiaDen.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Giá từ không để trống");
		}else if(!txtGiaTu.getText().isEmpty() && txtGiaDen.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Giá từ không để trống");
		}else if(!txtGiaTu.getText().isEmpty() && !txtGiaDen.getText().isEmpty() && (!txtGiaTu.getText().matches("^[0-9]+(?:,[0-9]+)?$") || !txtGiaDen.getText().matches("^[0-9]+(?:,[0-9]+)?$"))) {
			JOptionPane.showMessageDialog(this, "Khoảng giá điều kiện nhập dạng số >0");
		}else {
			LoaiSanPham loaiSanPham = (LoaiSanPham) comboLoai.getSelectedItem();
			
			String maLoai = loaiSanPham.getMaLoai();
			
			String giaTu = txtGiaTu.getText();
			String giaDen = txtGiaDen.getText();
			boolean trangThai;
			if(comboTinhTrang.getSelectedItem().equals("Còn hàng")) {
				trangThai = true;
			}else{
				trangThai = false;
			}
			ArrayList<SanPham> list = busSanPham.timKiemDieuKien(maLoai, giaTu, giaDen, trangThai);
			modelTable.setRowCount(0);
			DecimalFormat pattern = new DecimalFormat("#,###");
			for (SanPham sp : list) {
				Object[] newRow = {sp.getMaSanPham(),sp.getGiaSanPham().getMaGiaSanPham(), sp.getTenSanPham(),pattern.format(sp.getGiaSanPham().getDonGia()), sp.getGiaSanPham().getDonVi().getTenDonVi(), sp.getGiaSanPham().getSoLuong(), sp.getNhaCungCap().getTenNhaCungCap(), sp.getLoaiSanPham().getTenLoai()};
				modelTable.addRow(newRow);
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {

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
		// TODO Auto-generated method stub

	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		timKiemMa();
		System.out.println();
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		timKiemMa();
		System.out.println();
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		timKiemMa();
		System.out.println();
	}
	
}
