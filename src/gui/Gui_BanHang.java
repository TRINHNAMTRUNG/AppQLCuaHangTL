package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;

import bus.BUS_SanPham;
import custom_Gui.CardProducts;
import custom_Gui.ComboBoxRenderer;
import custom_Gui.PanelActionButton;
import custom_Gui.SpinnerEditor;
import entity.DonVi;
import entity.SanPham;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Gui_BanHang extends JPanel implements ActionListener, DocumentListener, ChangeListener{
	private JTextField txtTimSP;
	private JTextField txtMaVach;
	private JTextField txtSdt;
	private JTextField txtDiemDoi;
	private DefaultTableModel modelSanPham;
	private JTable tableSanPham;
	private JScrollPane scrollTableSanPham;
	private BUS_SanPham busSanPham = new BUS_SanPham();
	private JPanel pHoaDon;
	private JPanel pWrapSP;
	private JLabel lblTimSP;
	private JButton btnTimSP;
	private JPanel pDsSP;
	private JPanel pBarThanhToan;
	private JLabel lblMaVach;
	private JLabel lblTongTien;
	private JLabel lblTongTienHD;
	private JLabel lblValueTongTienHD;
	private JLabel lblValueTongTien;
	private JLabel lblTienKhach;
	private JLabel lblValueTienKhach;
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
	//	private JButton btnTang;
	//	private JButton btnGiam;
	private JButton btnXoa;
	private DefaultComboBoxModel<DonVi> modelComboDonVi;
	private JComboBox<DonVi> combodonVi;
	private JSpinner spinner;

	public Gui_BanHang() {
		setSize(913,625);
		setLayout(null);

		pHoaDon = new JPanel();
		pHoaDon.setBounds(0, 0, 672, 246);
		add(pHoaDon);
		pHoaDon.setLayout(new BorderLayout(0, 0));
		String[] header = {"Mã vạch","Mã giá", "Tên SP", "DVT", "SL", "Đơn giá", "Thành tiền"};
		modelSanPham = new DefaultTableModel(header,0);
		tableSanPham = new JTable(modelSanPham);
		tableSanPham.setRowHeight(30); 
		TableColumn column = tableSanPham.getColumnModel().getColumn(3);
		column.setPreferredWidth(90);
		tableSanPham.getColumnModel().getColumn(4).setPreferredWidth(40);
		scrollTableSanPham = new JScrollPane(tableSanPham);
		pHoaDon.add(scrollTableSanPham);

		pWrapSP = new JPanel();
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

		btnTimSP = new JButton("Tìm");
		btnTimSP.setBounds(412, 15, 73, 23);
		pWrapSP.add(btnTimSP);

		pDsSP = new JPanel();
		pDsSP.setLayout(new FlowLayout(FlowLayout.LEFT));
		pDsSP.setBounds(10, 48, 652, 320);
		pWrapSP.add(pDsSP);


		pBarThanhToan = new JPanel();
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

		lblValueTongTienHD = new JLabel("New label");
		lblValueTongTienHD.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTongTienHD.setBackground(new Color(255, 255, 255));
		lblValueTongTienHD.setBounds(10, 192, 208, 26);
		pBarThanhToan.add(lblValueTongTienHD);

		lblValueTongTien = new JLabel("New label");
		lblValueTongTien.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTongTien.setBackground(Color.WHITE);
		lblValueTongTien.setBounds(10, 117, 208, 26);
		pBarThanhToan.add(lblValueTongTien);

		lblTienKhach = new JLabel("Tiền khách trả:");
		lblTienKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTienKhach.setBounds(10, 229, 155, 26);
		pBarThanhToan.add(lblTienKhach);

		lblValueTienKhach = new JLabel("New label");
		lblValueTienKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTienKhach.setBackground(Color.WHITE);
		lblValueTienKhach.setBounds(10, 266, 208, 26);
		pBarThanhToan.add(lblValueTienKhach);

		lblTienThua = new JLabel("Tiền thừa:");
		lblTienThua.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblTienThua.setBounds(10, 303, 155, 26);
		pBarThanhToan.add(lblTienThua);

		lblValueTienThua = new JLabel("New label");
		lblValueTienThua.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueTienThua.setBackground(Color.WHITE);
		lblValueTienThua.setBounds(10, 340, 208, 26);
		pBarThanhToan.add(lblValueTienThua);

		pTichDiem = new JPanel();
		pTichDiem.setBounds(10, 371, 220, 186);
		pBarThanhToan.add(pTichDiem);
		pTichDiem.setLayout(null);

		lblSdt = new JLabel("SDT:");
		lblSdt.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSdt.setBounds(10, 11, 36, 26);
		pTichDiem.add(lblSdt);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(56, 13, 96, 26);
		pTichDiem.add(txtSdt);

		btnThemKhach = new JButton("Thêm khách");
		btnThemKhach.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnThemKhach.setBounds(10, 153, 200, 26);
		pTichDiem.add(btnThemKhach);

		lblDiem = new JLabel("Điểm:");
		lblDiem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDiem.setBounds(10, 45, 47, 26);
		pTichDiem.add(lblDiem);

		txtDiemDoi = new JTextField();
		txtDiemDoi.setColumns(10);
		txtDiemDoi.setBounds(57, 82, 153, 26);
		pTichDiem.add(txtDiemDoi);

		btnHuy = new JButton("Hủy tích đổi điểm");
		btnHuy.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnHuy.setBounds(10, 119, 200, 26);
		pTichDiem.add(btnHuy);

		btnTimSDT = new JButton("Tìm");
		btnTimSDT.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		btnTimSDT.setBounds(153, 12, 57, 26);
		pTichDiem.add(btnTimSDT);

		lblDiemDoi = new JLabel("Đổi:");
		lblDiemDoi.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblDiemDoi.setBounds(10, 82, 36, 26);
		pTichDiem.add(lblDiemDoi);

		lblValueDiem = new JLabel("Điểm của khách");
		lblValueDiem.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		lblValueDiem.setBounds(57, 45, 141, 26);
		pTichDiem.add(lblValueDiem);

		txtMaVach = new JTextField();
		txtMaVach.setBounds(10, 43, 208, 26);
		pBarThanhToan.add(txtMaVach);
		txtMaVach.setColumns(10);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnThanhToan.setBounds(20, 568, 198, 46);
		pBarThanhToan.add(btnThanhToan);



		btnHuy.addActionListener(this);
		btnThemKhach.addActionListener(this);
		btnTimSDT.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnTimSP.addActionListener(this);
		txtTimSP.getDocument().addDocumentListener(this);
		txtMaVach.getDocument().addDocumentListener(this);
		
		timKiemMa();
	}
	public void timKiemMa() {
		ArrayList<SanPham> list = busSanPham.timKiemMaHoacTen(txtTimSP.getText());
		pDsSP.removeAll();
		DecimalFormat pattern = new DecimalFormat("#,###");
		for (SanPham sp : list) {
			JPanel card = new CardProducts("/image/"+ sp.getGiaSanPham().getAnhSanPham(), sp.getTenSanPham(),pattern.format(sp.getGiaSanPham().getDonGia()) + " VND");
			pDsSP.add(Box.createHorizontalStrut(10));
			pDsSP.add(card);
			System.out.println(sp);
		}
		pDsSP.revalidate();
		pDsSP.repaint();
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
			sl = (int) spinner.getValue();
			donGia = parseFormat(modelSanPham.getValueAt(row, 5).toString());
			tongTien += (sl*donGia);
		}
		lblValueTongTien.setText(pattern.format(tongTien) );
		lblValueTongTienHD.setText(pattern.format(tongTienHD) );
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
						int slMoi = Integer.parseInt(String.valueOf(modelSanPham.getValueAt(row, 4)))+1;
						capNhatRowSP(row, slMoi);
						txtMaVach.setText("");
						capNhatTienThanhToan();
					}else {

						DecimalFormat pattern = new DecimalFormat("#,###");
						SanPham sanPham = listSP.get(0);

						// Tạo một ComboBoxModel mới cho cột đơn vị
						modelComboDonVi = new DefaultComboBoxModel<>();
						combodonVi = new JComboBox<>(modelComboDonVi);
						combodonVi.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent e) {
				            	int row = tableSanPham.getSelectedRow();
				    			if (row != -1) { // Kiểm tra xem có hàng được chọn trong bảng không
				    				DonVi dv = (DonVi) combodonVi.getSelectedItem();
				    				String maGia = taoMaGiaSanPham(modelSanPham.getValueAt(row, 0).toString(), dv.getMaDonVi()) ;
				    				System.out.println(maGia);
				    				SanPham sp = busSanPham.getGiaSanPham(maGia);
				    				double donGia = sp.getGiaSanPham().getDonGia();
				    				int sl = Integer.parseInt(modelSanPham.getValueAt(row, 4).toString());
				    				double thanhTien = (donGia + (donGia * 0.1)) * sl;
				    				modelSanPham.setValueAt(formatMonney(donGia), row, 5);
				    				modelSanPham.setValueAt(formatMonney(thanhTien), row, 6);
				    				modelSanPham.setValueAt(maGia, row, 1);
				    				capNhatTienThanhToan();
				    				System.out.println("XẢY RA TRÊN COMBO");
				    			}
				            }
				        });
						//Duyệt lấy và nạp danh sách đơn vị vào comboboxDonVi
						for (SanPham sp : listSP) {
							modelComboDonVi.addElement(sp.getGiaSanPham().getDonVi());
						}
						combodonVi.setRenderer(new DefaultListCellRenderer() {
							@Override
							public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
								if (value instanceof DonVi) {
									value = ((DonVi) value).getTenDonVi();
								}
								return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
							}
						});
						TableCellEditor comboBoxEditor = new DefaultCellEditor(combodonVi);
						tableSanPham.getColumnModel().getColumn(3).setCellEditor(comboBoxEditor);

						// Tạo một SpinnerEditor mới cho cột số lượng
						spinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
						spinner.addChangeListener(new ChangeListener() {
				            public void stateChanged(ChangeEvent e) {
				            	int row = tableSanPham.getSelectedRow();
				            	double donGia = parseFormat(modelSanPham.getValueAt(row, 5).toString()) ;
				            	double thanhTien = (donGia + (donGia * 0.1)) * (int)spinner.getValue();
				            	modelSanPham.setValueAt(formatMonney(thanhTien), row, 6);
				            	capNhatTienThanhToan();
				            }
				        });
						SpinnerEditor spinnerEditor = new SpinnerEditor(spinner);
						tableSanPham.getColumnModel().getColumn(4).setCellEditor(spinnerEditor);
						
						combodonVi.setSelectedItem(sanPham.getGiaSanPham().getDonVi());
						double thanhTien = sanPham.getGiaSanPham().getDonGia() + (sanPham.getGiaSanPham().getDonGia() * 0.1);
						
						Object[] newRow = {sanPham.getMaSanPham(), sanPham.getGiaSanPham().getMaGiaSanPham(), sanPham.getTenSanPham(), combodonVi.getSelectedItem(), 1, pattern.format(sanPham.getGiaSanPham().getDonGia()), pattern.format(thanhTien)};
						modelSanPham.addRow(newRow);
						txtMaVach.setText("");
						capNhatTienThanhToan();
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
	public void capNhatRowSP(int row, int slMoi) {
		double thanhTienMoi;
		double thanhTien =  parseFormat(modelSanPham.getValueAt(row, 5).toString()) *0.1 * slMoi;
		thanhTienMoi = (thanhTien + (thanhTien*0.1)) * slMoi;
		modelSanPham.setValueAt(slMoi, row, 4);
		modelSanPham.setValueAt(thanhTienMoi, row, 6);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoa)) {
			System.out.println("XOA");
		}
//		if (obj.equals(combodonVi)) { // Kiểm tra xem sự kiện có phải từ combobox đơn vị không
//			
//		}
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
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		Object obj = e.getSource();
		if(obj instanceof JSpinner) {
			capNhatTienThanhToan();
		}
	}
}
