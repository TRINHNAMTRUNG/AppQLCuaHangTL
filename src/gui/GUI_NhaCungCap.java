package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import bus.BUS_NhaCungCap;
import bus.BUS_SanPham;
import custom_Gui.CustomTableHeaderRenderer;
import custom_Gui.RoundButton;
import dao.DAO_NhaCungCap;
import entity.NhaCungCap;
import entity.SanPham;

public class GUI_NhaCungCap extends JPanel implements ActionListener, MouseListener{

	private DefaultTableModel modelTable;
	private JTable tableNCC;
	private JScrollPane scrollTableNCC;
	private JLabel lblTitleNCC;
	private JPanel pNCC;
	private JLabel lblTitleChucNang;
	private JPanel pChucNang;
	private JPanel pTim;
	private JLabel lblTitleTim;
	private BUS_NhaCungCap busNCC;
	private ArrayList<NhaCungCap> listNCC;
	private JLabel lblMa;
	private JTextField txtMa;
	private JLabel lblTen;
	private JTextField txtTen;
	private JLabel lblDC;
	private JTextField txtDC;
	private RoundButton btnThem;
	private RoundButton btnXoa;
	private RoundButton btnSua;
	private RoundButton btnXoaTrang;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private Object choosebtn;
	private JTextField txtTimMa;
	private JTextField txtTimSDT;
	private RoundButton btnTaiLai;

	public GUI_NhaCungCap() {
		setSize(913,625);
		setLayout(null);
		
		JPanel pnlNCC = new JPanel();
		pnlNCC.setBackground(new Color(119, 165, 187));
		pnlNCC.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlNCC.setBounds(0, 0, 650, 250);
		add(pnlNCC);
		pnlNCC.setLayout(null);
		
		pNCC = new JPanel();
		pNCC.setBackground(new Color(11, 102, 106));
		pNCC.setBounds(0, 0, 650, 29);
		pnlNCC.add(pNCC);
		
		lblMa = new JLabel("Mã Nhà Cung Cấp:");
		lblMa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMa.setBounds(30, 50, 150, 29);
		pnlNCC.add(lblMa);
		
		txtMa = new JTextField("");
		txtMa.setBounds(160, 50, 400, 25);
		pnlNCC.add(txtMa);
		txtMa.setColumns(10);
		
		lblTen = new JLabel("Tên Nhà Cung Cấp:");
		lblTen.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTen.setBounds(30, 100, 150, 29);
		pnlNCC.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setBounds(160, 100, 400, 25);
		pnlNCC.add(txtTen);
		txtTen.setColumns(10);
		
		lblDC = new JLabel("Địa Chỉ:");
		lblDC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDC.setBounds(30, 150, 150, 29);
		pnlNCC.add(lblDC);
		
		txtDC = new JTextField();
		txtDC.setBounds(160, 150, 400, 25);
		pnlNCC.add(txtDC);
		txtDC.setColumns(10);
		
		lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSDT.setBounds(30, 200, 150, 29);
		pnlNCC.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(160, 200, 400, 25);
		pnlNCC.add(txtSDT);
		txtSDT.setColumns(10);

		
		lblTitleNCC = new JLabel("Thông tin nhà cung cấp");
		lblTitleNCC.setForeground(new Color(197, 224, 231));
		lblTitleNCC.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pNCC.add(lblTitleNCC);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setBackground(new Color(119, 165, 187));
		pnlChucNang.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlChucNang.setBounds(660, 0, 253, 250);
		add(pnlChucNang);
		pnlChucNang.setLayout(null);
		
		pChucNang = new JPanel();
		pChucNang.setBackground(new Color(11, 102, 106));
		pChucNang.setBounds(0, 0, 253, 29);
		pnlChucNang.add(pChucNang);
		
		lblTitleChucNang = new JLabel("Chức năng");
		lblTitleChucNang.setForeground(new Color(197, 224, 231));
		lblTitleChucNang.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pChucNang.add(lblTitleChucNang);
		
		btnThem = new RoundButton("Thêm", 5);
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnThem.setBounds(80, 50, 100, 31);
		pnlChucNang.add(btnThem);
		btnThem.setBackground(new Color(53, 94, 241));
		btnThem.setFocusPainted(false);
		
		btnSua = new RoundButton("Sửa", 5);
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSua.setBounds(80, 100, 100, 31);
		pnlChucNang.add(btnSua);
		btnSua.setBackground(new Color(53, 94, 241));
		btnSua.setFocusPainted(false);
		
		btnXoa = new RoundButton("Xóa", 5);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXoa.setBounds(80, 150, 100, 31);
		pnlChucNang.add(btnXoa);
		btnXoa.setBackground(new Color(53, 94, 241));
		btnXoa.setFocusPainted(false);
		
		btnTaiLai = new RoundButton("Tải Lại", 5);
		btnTaiLai.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTaiLai.setBounds(80, 200, 100, 31);
		pnlChucNang.add(btnTaiLai);
		btnTaiLai.setBackground(new Color(53, 94, 241));
		btnTaiLai.setFocusPainted(false);
		
		JPanel pnlTim = new JPanel();
		pnlTim.setBackground(new Color(119, 165, 187));
		pnlTim.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlTim.setBounds(0, 260, 913, 100);
		add(pnlTim);
		pnlTim.setLayout(null);
		
		pTim = new JPanel();
		pTim.setBackground(new Color(11, 102, 106));
		pTim.setBounds(0, 0, 913, 29);
		pTim.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlTim.add(pTim);
		
		lblTitleTim = new JLabel("Tìm kiếm nhà cung cấp");
		lblTitleTim.setForeground(new Color(197, 224, 231));
		lblTitleTim.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pTim.add(lblTitleTim);
		
		txtTimMa = new JTextField("Nhập mã nhà cung cấp");
		txtTimMa.setBounds(50, 50, 250, 25);
		pnlTim.add(txtTimMa);
		txtTimMa.setColumns(10);
		
		txtTimSDT = new JTextField("Nhập số điện thoại");
		txtTimSDT.setBounds(350, 50, 250, 25);
		pnlTim.add(txtTimSDT);
		txtTimSDT.setColumns(10);
		
	
		
		scrollTableNCC = new JScrollPane();
		scrollTableNCC.setBounds(0, 370, 913, 250);
		String[] header = {"Mã Nhà Cung Cấp","Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại"};
		modelTable = new DefaultTableModel(header,0);
		tableNCC = new JTable(modelTable);
		tableNCC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollTableNCC.setViewportView(tableNCC);
		tableNCC.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer(tableNCC));
		tableNCC.getTableHeader().setPreferredSize(new Dimension(tableNCC.getTableHeader().getWidth(), 30));
		add(scrollTableNCC);
		
		busNCC = new BUS_NhaCungCap();
		listNCC = busNCC.getAllNhaCungCap();
		modelTable.setRowCount(0);
		for (NhaCungCap ncc : listNCC) {
			Object[] newRow = {ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSoDT()};
			modelTable.addRow(newRow);
		}

		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTaiLai.addActionListener(this);
		tableNCC.addMouseListener(this);
		txtTimMa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtTimMa.getText().equals(""))
					txtTimMa.setText("Nhập mã nhà cung cấp");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtTimMa.getText().equals("Nhập mã nhà cung cấp"))
					txtTimMa.setText("");
			}
		});
		
		txtTimSDT.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtTimSDT.getText().equals(""))
					txtTimSDT.setText("Nhập số điện thoại");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtTimSDT.getText().equals("Nhập số điện thoại"))
					txtTimSDT.setText("");
			}
		});
		
		txtTimMa.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
					
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					timKiemTheoMa(txtTimMa.getText());
				
			}
		});
		
		txtTimSDT.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
					
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					timKiemTheoSDT(txtTimSDT.getText());
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableNCC.getSelectedRow();
		txtMa.setText(modelTable.getValueAt(row, 0).toString());
		txtTen.setText(modelTable.getValueAt(row, 1).toString());
		txtDC.setText(modelTable.getValueAt(row, 2).toString());
		txtSDT.setText(modelTable.getValueAt(row, 3).toString());
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnTaiLai)) {
			lamMoiThongTin();
			modelTable.setRowCount(0);
			busNCC = new BUS_NhaCungCap();
			listNCC = busNCC.getAllNhaCungCap();
			for (NhaCungCap ncc : listNCC) {
				Object[] newRow = {ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSoDT()};
				modelTable.addRow(newRow);
			}
			
		}
		if(o.equals(btnThem)) {
			String ma = txtMa.getText();
			String ten = txtTen.getText();
			String dc = txtDC.getText();
			String sdt = txtSDT.getText();
			
			
			if(kiemTraRong(ma)) {
				JOptionPane.showMessageDialog(this, "Vui lòng điền mã nhà cung cấp.");
				txtMa.requestFocus();
                return;
			}
			
			if(kiemTraRong(ten)) {
				JOptionPane.showMessageDialog(this, "Vui lòng điền tên nhà cung cấp.");
				txtMa.requestFocus();
                return;
			}
			
			if(kiemTraRong(dc)) {
				JOptionPane.showMessageDialog(this, "Vui lòng điền địa chỉ nhà cung cấp.");
				txtMa.requestFocus();
                return;
			}
			
			if(kiemTraRong(sdt)) {
				JOptionPane.showMessageDialog(this, "Vui lòng điền số điện thoại nhà cung cấp.");
				txtMa.requestFocus();
                return;
			}
			
			if(!kiemTraTenVaDiaChi(ten)) {
				JOptionPane.showMessageDialog(this, "Tên không hợp lệ.");
				txtTen.requestFocus();
                return;
			}
			
			if(!kiemTraMa(ma)) {
				JOptionPane.showMessageDialog(this, "Mã không hợp lệ.");
				txtMa.requestFocus();
                return;
			}
			
			if(!kiemTraTenVaDiaChi(dc)) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không hợp lệ.");
				txtDC.requestFocus();
                return;
			}
			
			if (!kiemTraSDT(sdt)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
                txtSDT.requestFocus();
                return;
            }
			
			NhaCungCap ncc = new NhaCungCap(ma, ten, dc, sdt);
			
			try {
				if (!busNCC.addNhaCungCap(ncc)) {
			        JOptionPane.showMessageDialog(this, "Trùng mã nhà cung cấp");
			    } else {
			        modelTable.addRow(new Object[] {ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSoDT()});
			    }
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Trùng mã nhà cung cấp");
			}
		}
		if(o.equals(btnSua)) {
			String ma = txtMa.getText();
		    String ten = txtTen.getText();
		    String dc = txtDC.getText();
		    String sdt = txtSDT.getText();
		    
		    NhaCungCap ncc = new NhaCungCap(ma, ten, dc, sdt);
		    
		    try {
		        if (!busNCC.updateNhaCungCap(ncc)) {
		            JOptionPane.showMessageDialog(this, "Không thể cập nhật nhà cung cấp");
		        } else {
		            int rowIndex = tableNCC.getSelectedRow();
		            if (rowIndex != -1) {
		                modelTable.setValueAt(ncc.getMaNhaCungCap(), rowIndex, 0);
		                modelTable.setValueAt(ncc.getTenNhaCungCap(), rowIndex, 1);
		                modelTable.setValueAt(ncc.getDiaChi(), rowIndex, 2);
		                modelTable.setValueAt(ncc.getSoDT(), rowIndex, 3);
		            }
		            JOptionPane.showMessageDialog(this, "Đã cập nhật nhà cung cấp");
		        }
		    } catch (Exception e2) {
		        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật nhà cung cấp");
		    }
		}
		
		if(o.equals(btnXoa)) {
			int rowIndex = tableNCC.getSelectedRow();
		    if (rowIndex != -1) {
		        String maNhaCungCap = (String) modelTable.getValueAt(rowIndex, 0);
		        NhaCungCap ncc = new NhaCungCap(maNhaCungCap);
		        
		        try {
		            if (busNCC.deleteNhaCungCap(ncc)) {
		                modelTable.removeRow(rowIndex);
		                lamMoiThongTin();
		                JOptionPane.showMessageDialog(this, "Đã xóa nhà cung cấp");
		            } else {
		                JOptionPane.showMessageDialog(this, "Không thể xóa nhà cung cấp");
		            }
		        } catch (Exception e2) {
		            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xóa nhà cung cấp");
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhà cung cấp để xóa");
		    }
		}
		
	}
	
	
	public void lamMoiThongTin() {
		txtMa.setText("");
		txtTen.setText("");
		txtDC.setText("");
		txtSDT.setText("");
	}
	
	public void timKiemTheoMa(String ma) {
	    modelTable.setRowCount(0);

	    ArrayList<NhaCungCap> resultList = busNCC.timKiemMa(ma);

	    if (resultList.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp với mã này.");
	    } else {
	        for (NhaCungCap ncc : resultList) {
	            Object[] newRow = {ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSoDT()};
	            modelTable.addRow(newRow);
	        }
	    }
	}
	
	public void timKiemTheoSDT(String sdt) {
	    modelTable.setRowCount(0);

	    ArrayList<NhaCungCap> resultList = busNCC.timKiemSDT(sdt);

	    if (resultList.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp với số điện thoại này.");
	    } else {
	        for (NhaCungCap ncc : resultList) {
	            Object[] newRow = {ncc.getMaNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSoDT()};
	            modelTable.addRow(newRow);
	        }
	    }
	}
	
	private boolean kiemTraRong(String str) {
        return str == null || str.trim().isEmpty();
    }
	
	private boolean kiemTraMa(String ma) {
        return ma.matches("NCC[0-9]+");
    }

    private boolean kiemTraSDT(String sdt) {
        return sdt.matches("\\d{10}");
    }
    
    private boolean kiemTraTenVaDiaChi(String tenVsDiaChi) {
        return tenVsDiaChi.matches("[a-zA-Z0-9]*");
    }


}