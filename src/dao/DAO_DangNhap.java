package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.connectDBs;
import entity.NhanVien;
import entity.TaiKhoan;

public class DAO_DangNhap {
	public TaiKhoan getTaiKhoan(String manv){
		TaiKhoan tk = null;
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM TaiKhoan WHERE maNhanVien = ?");
			stmt.setString(1, manv);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				NhanVien nv = new NhanVien();
				nv.setMaNhanVien(maNhanVien);
				String pass = rs.getString("matKhau");
				tk = new TaiKhoan(nv, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return tk;
	}
	
}
