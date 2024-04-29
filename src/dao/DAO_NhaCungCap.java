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

public class DAO_NhaCungCap {
	private static void close(ResultSet rs, PreparedStatement stmt) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<NhaCungCap> getAllNhaCungCap(){
		ArrayList<NhaCungCap> listNhaCungCap = new ArrayList<NhaCungCap>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM NhaCungCap");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String tenNCC = rs.getString("tenNhaCungCap");
				String maNCC = rs.getString("maNhaCungCap");
				String diaChi = rs.getString("diaChiNhaCungCap");
				String soDT = rs.getString("soDienThoai");
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDT);
				listNhaCungCap.add(ncc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listNhaCungCap;
	}
	
	public boolean addNCC(NhaCungCap ncc) {
		connectDBs.getInstance();
	    Connection con = connectDBs.getConnConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("INSERT INTO NhaCungCap (maNhaCungCap, tenNhaCungCap, diaChiNhaCungCap, soDienThoai) VALUES (?,?,?,?)");
	    	stmt.setString(1, ncc.getMaNhaCungCap());
	        stmt.setString(2, ncc.getTenNhaCungCap());
	        stmt.setString(3, ncc.getDiaChi());
	        stmt.setString(4, ncc.getSoDT());

	        n = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	    }
	    return n > 0;
	}
	
	public boolean updateSanPham(NhaCungCap ncc) {
		connectDBs.getInstance();
	    Connection con = connectDBs.getConnConnection();
	    PreparedStatement stmt = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("UPDATE NhaCungCap set tenNhaCungCap = ?, diaChiNhaCungCap = ?, soDienThoai = ? where maNhaCungCap = ?");
	        stmt.setString(1, ncc.getTenNhaCungCap());
	        stmt.setString(2, ncc.getDiaChi());
	        stmt.setString(3, ncc.getSoDT());
	        stmt.setString(4, ncc.getMaNhaCungCap());

	        n = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	    }
	    return n > 0;
	}
	
	public boolean deleteNhaCungCap(NhaCungCap ncc) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("DELETE FROM NhaCungCap  WHERE maNhaCungCap = ?");
			stmt.setString(1, ncc.getMaNhaCungCap());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				success = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(null, stmt);
		}
		return success;
	}
	
	public ArrayList<NhaCungCap> getNhaCungCapTheoMa(String ma){
		ArrayList<NhaCungCap> listNCC = new ArrayList<NhaCungCap>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(""
				    + "SELECT maNhaCungCap, \r\n"
				    + "       tenNhaCungCap, \r\n"
				    + "       diaChiNhaCungCap,\r\n"
				    + "       soDienThoai\r\n"
				    + "FROM NhaCungCap\r\n"
				    + "WHERE maNhaCungCap = ?");
			stmt.setString(1, ma);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String mancc = rs.getString("maNhaCungCap");
				String ten = rs.getString("tenNhaCungCap");
				String dc = rs.getString("diaChiNhaCungCap");
				String sdt = rs.getString("soDienThoai");

				NhaCungCap ncc = new NhaCungCap(mancc, ten, dc, sdt);
				listNCC.add(ncc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listNCC;
	}
	
	public ArrayList<NhaCungCap> getNhaCungCapTheoSDT(String sdt){
		ArrayList<NhaCungCap> listNCC = new ArrayList<NhaCungCap>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(""
				    + "SELECT maNhaCungCap, \r\n"
				    + "       tenNhaCungCap, \r\n"
				    + "       diaChiNhaCungCap,\r\n"
				    + "       soDienThoai\r\n"
				    + "FROM NhaCungCap\r\n"
				    + "WHERE soDienThoai = ?");
			stmt.setString(1, sdt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String mancc = rs.getString("maNhaCungCap");
				String ten = rs.getString("tenNhaCungCap");
				String dc = rs.getString("diaChiNhaCungCap");
				String soDienThoai = rs.getString("soDienThoai");

				NhaCungCap ncc = new NhaCungCap(mancc, ten, dc, soDienThoai);
				listNCC.add(ncc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, stmt);
		}
		return listNCC;
	}
}