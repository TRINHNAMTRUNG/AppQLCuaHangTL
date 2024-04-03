package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import connectDB.connectDBs;
import entity.DonVi;
import entity.GiaSanPham;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.SanPham;

public class DAO_SanPham {
	private static void close(ResultSet rs, PreparedStatement stmt) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<SanPham> getSanPhamMaHoacTen(String infoSanPham){
		ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(""
					+ "SELECT GiaSanPham.maSanPham, \r\n"
					+ "       SanPham.tenSanPham, \r\n"
					+ "	      GiaSanPham.anhSanPham,\r\n"
					+ "	      GiaSanPham.trangThai,\r\n"
					+ "       NhaCungCap.tenNhaCungCap, \r\n"
					+ "       NhaCungCap.maNhaCungCap, \r\n"
					+ "       LoaiSanPham.tenLoai, \r\n"
					+ "       LoaiSanPham.maLoai, \r\n"
					+ "       DonVi.tenDonVi, \r\n"
					+ "       GiaSanPham.soLuong, \r\n"
					+ "       GiaSanPham.donGia, \r\n"
					+ "       GiaSanPham.giaVon, \r\n"
					+ "       GiaSanPham.maGiaSanPham \r\n"
					+ "FROM GiaSanPham\r\n"
					+ "JOIN DonVi ON GiaSanPham.maDonVi = DonVi.maDonVi\r\n"
					+ "JOIN SanPham ON GiaSanPham.maSanPham = SanPham.maSanPham\r\n"
					+ "JOIN LoaiSanPham ON SanPham.maLoaiSanPham = LoaiSanPham.maLoai\r\n"
					+ "JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNhaCungCap\r\n"
					+ "WHERE SanPham.maSanPham = ? OR SanPham.tenSanPham LIKE  ?");
			stmt.setString(1, infoSanPham);
			stmt.setString(2,"%"+ infoSanPham +"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				GiaSanPham giaSanPham = new GiaSanPham();
				DonVi donVi = new DonVi();
				LoaiSanPham loaiSanPham = new LoaiSanPham();
				NhaCungCap nhaCungCap = new NhaCungCap();

				nhaCungCap.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
				nhaCungCap.setMaNhaCungCap(rs.getString("maNhaCungCap"));
				loaiSanPham.setTenLoai(rs.getString("tenLoai"));
				loaiSanPham.setMaLoai(rs.getString("maLoai"));
				donVi.setTenDonVi(rs.getString("tenDonVi"));
				giaSanPham.setSoLuong(rs.getInt("soLuong"));
				giaSanPham.setDonGia(rs.getDouble("donGia"));
				giaSanPham.setGiaVon(rs.getDouble("giaVon"));
				giaSanPham.setMaGiaSanPham(rs.getString("maGiaSanPham"));
				giaSanPham.setTrangThai(rs.getBoolean("trangThai"));
				giaSanPham.setDonVi(donVi);

				String maSanPham = rs.getString("maSanPham");
				String tenSanPham = rs.getString("tenSanPham");
				String anhSanPham = rs.getString("anhSanPham");
				giaSanPham.setAnhSanPham(anhSanPham);
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, loaiSanPham, nhaCungCap, giaSanPham);
				listSanPham.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listSanPham;
	}
	public ArrayList<SanPham> getSanPhamDieuKiem(String maLoai, String giaTu, String giaDen, boolean TrangThai){
		ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = ""
					+ "SELECT GiaSanPham.maSanPham, \r\n"
					+ "       SanPham.tenSanPham, \r\n"
					+ "	      GiaSanPham.anhSanPham,\r\n"
					+ "	      GiaSanPham.trangThai,\r\n"
					+ "       NhaCungCap.tenNhaCungCap, \r\n"
					+ "       NhaCungCap.maNhaCungCap, \r\n"
					+ "       LoaiSanPham.tenLoai, \r\n"
					+ "       LoaiSanPham.maLoai, \r\n"
					+ "       DonVi.tenDonVi, \r\n"
					+ "       GiaSanPham.soLuong, \r\n"
					+ "       GiaSanPham.donGia, \r\n"
					+ "       GiaSanPham.giaVon, \r\n"
					+ "       GiaSanPham.maGiaSanPham \r\n"
					+ "FROM GiaSanPham\r\n"
					+ "JOIN DonVi ON GiaSanPham.maDonVi = DonVi.maDonVi\r\n"
					+ "JOIN SanPham ON GiaSanPham.maSanPham = SanPham.maSanPham\r\n"
					+ "JOIN LoaiSanPham ON SanPham.maLoaiSanPham = LoaiSanPham.maLoai\r\n"
					+ "JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNhaCungCap\r\n"
					+ "WHERE maLoai = ? AND trangThai = ?";

			if(!giaTu.isEmpty() && !giaDen.isEmpty()) {
				sql +=" AND donGia BETWEEN ? AND ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, maLoai);
				stmt.setBoolean(2, TrangThai);
				stmt.setString(3, giaTu);
				stmt.setString(4, giaDen);
			}else {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, maLoai);
				stmt.setBoolean(2, TrangThai);
				System.out.println("zo zo ");
			}

			rs = stmt.executeQuery();
			while(rs.next()) {
				GiaSanPham giaSanPham = new GiaSanPham();
				DonVi donVi = new DonVi();
				LoaiSanPham loaiSanPham = new LoaiSanPham();
				NhaCungCap nhaCungCap = new NhaCungCap();

				nhaCungCap.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
				nhaCungCap.setMaNhaCungCap(rs.getString("maNhaCungCap"));
				loaiSanPham.setTenLoai(rs.getString("tenLoai"));
				loaiSanPham.setMaLoai(rs.getString("maLoai"));
				donVi.setTenDonVi(rs.getString("tenDonVi"));
				giaSanPham.setSoLuong(rs.getInt("soLuong"));
				giaSanPham.setDonGia(rs.getDouble("donGia"));
				giaSanPham.setGiaVon(rs.getDouble("giaVon"));
				giaSanPham.setMaGiaSanPham(rs.getString("maGiaSanPham"));
				giaSanPham.setTrangThai(rs.getBoolean("trangThai"));
				giaSanPham.setDonVi(donVi);

				String maSanPham = rs.getString("maSanPham");
				String tenSanPham = rs.getString("tenSanPham");
				String anhSanPham = rs.getString("anhSanPham");
				giaSanPham.setAnhSanPham(anhSanPham);
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, loaiSanPham, nhaCungCap, giaSanPham);
				listSanPham.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listSanPham;
	}
	public ArrayList<SanPham> getAllSanPham(){
		ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(""
					+ "SELECT GiaSanPham.maSanPham, \r\n"
					+ "       SanPham.tenSanPham, \r\n"
					+ "	      GiaSanPham.anhSanPham,\r\n"
					+ "	      GiaSanPham.trangThai,\r\n"
					+ "       NhaCungCap.tenNhaCungCap, \r\n"
					+ "       NhaCungCap.maNhaCungCap, \r\n"
					+ "       LoaiSanPham.tenLoai, \r\n"
					+ "       LoaiSanPham.maLoai, \r\n"
					+ "       DonVi.tenDonVi, \r\n"
					+ "       DonVi.maDonVi, \r\n"
					+ "       GiaSanPham.soLuong, \r\n"
					+ "       GiaSanPham.maGiaSanPham, \r\n"
					+ "       GiaSanPham.donGia, \r\n"
					+ "       GiaSanPham.giaVon \r\n"
					+ "FROM GiaSanPham\r\n"
					+ "JOIN DonVi ON GiaSanPham.maDonVi = DonVi.maDonVi\r\n"
					+ "JOIN SanPham ON GiaSanPham.maSanPham = SanPham.maSanPham\r\n"
					+ "JOIN LoaiSanPham ON SanPham.maLoaiSanPham = LoaiSanPham.maLoai\r\n"
					+ "JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNhaCungCap;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				GiaSanPham giaSanPham = new GiaSanPham();
				DonVi donVi = new DonVi();
				LoaiSanPham loaiSanPham = new LoaiSanPham();
				NhaCungCap nhaCungCap = new NhaCungCap();

				nhaCungCap.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
				nhaCungCap.setMaNhaCungCap(rs.getString("maNhaCungCap"));
				loaiSanPham.setTenLoai(rs.getString("tenLoai"));
				loaiSanPham.setMaLoai(rs.getString("maLoai"));
				donVi.setTenDonVi(rs.getString("tenDonVi"));
				donVi.setMaDonVi(rs.getString("maDonVi"));
				giaSanPham.setSoLuong(rs.getInt("soLuong"));
				giaSanPham.setDonGia(rs.getDouble("donGia"));
				giaSanPham.setGiaVon(rs.getDouble("giaVon"));
				giaSanPham.setMaGiaSanPham(rs.getString("maGiaSanPham"));
				giaSanPham.setTrangThai(rs.getBoolean("trangThai"));
				giaSanPham.setDonVi(donVi);

				String maSanPham = rs.getString("maSanPham");
				String tenSanPham = rs.getString("tenSanPham");
				String anhSanPham = rs.getString("anhSanPham");
				giaSanPham.setAnhSanPham(anhSanPham);
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, loaiSanPham, nhaCungCap, giaSanPham);
				listSanPham.add(sanPham);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listSanPham;
	}
	public boolean addSanPham(SanPham sanPham, boolean kiemTraTonTaiSanPham) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		boolean success = false;
		try {
			if(!kiemTraTonTaiSanPham) {
				stmt = con.prepareStatement("INSERT INTO SanPham (maSanPham, tenSanPham, maNhaCungCap, maLoaiSanPham) VALUES (?,?,?,?)");
				stmt.setString(1, sanPham.getMaSanPham());
				stmt.setString(2, sanPham.getTenSanPham());
				stmt.setString(3, sanPham.getNhaCungCap().getMaNhaCungCap());
				stmt.setString(4, sanPham.getLoaiSanPham().getMaLoai());
				

				stmt2 = con.prepareStatement("INSERT INTO GiaSanPham (maSanPham, maDonVi, soLuong, donGia, giaVon, maGiaSanPham, trangThai, anhSanPham) VALUES (?,?,?,?,?,?,?,?)");
				stmt2.setString(1, sanPham.getMaSanPham());
				stmt2.setString(2, sanPham.getGiaSanPham().getDonVi().getMaDonVi());
				stmt2.setInt(3, sanPham.getGiaSanPham().getSoLuong());
				stmt2.setDouble(4, sanPham.getGiaSanPham().getDonGia());
				stmt2.setDouble(5, sanPham.getGiaSanPham().getGiaVon());
				stmt2.setString(6, sanPham.getGiaSanPham().getMaGiaSanPham());
				stmt2.setBoolean(7, sanPham.getGiaSanPham().isTrangThai());
				stmt2.setString(8, sanPham.getGiaSanPham().getAnhSanPham());
				int rowsAffected = stmt.executeUpdate();
				int rowsAffected2 = stmt2.executeUpdate();
				if (rowsAffected > 0 && rowsAffected2 > 0) {
					success = true;
				}
			}else {
				stmt2 = con.prepareStatement("INSERT INTO GiaSanPham (maSanPham, maDonVi, soLuong, donGia, giaVon, maGiaSanPham, trangThai, anhSanPham) VALUES (?,?,?,?,?,?,?,?)");
				stmt2.setString(1, sanPham.getMaSanPham());
				stmt2.setString(2, sanPham.getGiaSanPham().getDonVi().getMaDonVi());
				stmt2.setInt(3, sanPham.getGiaSanPham().getSoLuong());
				stmt2.setDouble(4, sanPham.getGiaSanPham().getDonGia());
				stmt2.setDouble(5, sanPham.getGiaSanPham().getGiaVon());
				stmt2.setString(6, sanPham.getGiaSanPham().getMaGiaSanPham());
				stmt2.setBoolean(7, sanPham.getGiaSanPham().isTrangThai());
				stmt2.setString(8, sanPham.getGiaSanPham().getAnhSanPham());
				
				int rowsAffected2 = stmt2.executeUpdate();
				if (rowsAffected2 > 0) {
					success = true;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, stmt);
		}
		return success;
	}
	public boolean updateSanPham(SanPham sanPham) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("UPDATE SanPham SET tenSanPham = ?, maNhaCungCap = ?, maLoaiSanPham = ? WHERE maSanPham = ?");
			stmt.setString(4, sanPham.getMaSanPham());
			stmt.setString(1, sanPham.getTenSanPham());
			stmt.setString(2, sanPham.getNhaCungCap().getMaNhaCungCap());
			stmt.setString(3, sanPham.getLoaiSanPham().getMaLoai());

			stmt2 = con.prepareStatement("UPDATE GiaSanPham SET maDonVi = ?, soLuong = ?, donGia = ?, giaVon = ?, anhSanPham = ? WHERE maGiaSanPham = ?");
			stmt2.setString(6, sanPham.getGiaSanPham().getMaGiaSanPham());
			stmt2.setString(1, sanPham.getGiaSanPham().getDonVi().getMaDonVi());
			stmt2.setInt(2, sanPham.getGiaSanPham().getSoLuong());
			stmt2.setDouble(3, sanPham.getGiaSanPham().getDonGia());
			stmt2.setDouble(4, sanPham.getGiaSanPham().getGiaVon());
			stmt2.setString(5, sanPham.getGiaSanPham().getAnhSanPham());
			int rowsAffected2 = stmt2.executeUpdate();
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0 && rowsAffected2 >0) {
				success = true; // Nếu có hàng bị ảnh hưởng, gán true
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null, stmt);
		}
		return success;
	}
	public boolean deleteSanPham(SanPham sanPham) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("DELETE FROM SanPham  WHERE maSanPham = ?");
			stmt.setString(1, sanPham.getMaSanPham());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				success = true; // Nếu có hàng bị ảnh hưởng, gán true
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null, stmt);
		}
		return success;
	}
	public boolean addDonVi(DonVi donVi) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("INSERT INTO DonVi (maDonVi, tenDonVi) VALUE (?, ?)");
			stmt.setString(1, donVi.getMaDonVi());
			stmt.setString(2, donVi.getTenDonVi());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				success = true; // Nếu có hàng bị ảnh hưởng, gán true
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public ArrayList<DonVi> getAllDonVi(){
		ArrayList<DonVi> listDonVi = new ArrayList<DonVi>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM DonVi");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String tenDonVi = rs.getString("tenDonVi");
				String maDonVi = rs.getString("maDonVi");
				DonVi donVi = new DonVi(maDonVi, tenDonVi);
				listDonVi.add(donVi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listDonVi;
	}
	
	
	public boolean addLoaiSanPham(LoaiSanPham loaiSanPham) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("INSERT INTO DonVi (maLoai, tenLoai) VALUE (?, ?)");
			stmt.setString(1, loaiSanPham.getMaLoai());
			stmt.setString(2, loaiSanPham.getTenLoai());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				success = true; // Nếu có hàng bị ảnh hưởng, gán true
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public ArrayList<LoaiSanPham> getAllLoaiSanPham(){
		ArrayList<LoaiSanPham> listLoaiSanPham = new ArrayList<LoaiSanPham>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM LoaiSanPham");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String tenLoai = rs.getString("tenLoai");
				String maLoai = rs.getString("maLoai");
				LoaiSanPham donVi = new LoaiSanPham(maLoai, tenLoai);
				listLoaiSanPham.add(donVi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listLoaiSanPham;
	}
}
