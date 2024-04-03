package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.connectDBs;
import entity.NhaCungCap;

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
}
