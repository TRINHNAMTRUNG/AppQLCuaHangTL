package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectDB.connectDBs;
import entity.ChiTietHoaDon;
import entity.HoaDon;

public class DAO_ChiTietHoaDon {
	public boolean addChiTietHoaDon(ChiTietHoaDon cthd) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("INSERT INTO ChiTietHoaDon (maHoaDon, maGiaSanPham, soLuong, thanhTien) VALUES (?,?,?,?)");
			stmt.setString(1, cthd.getHd().getMaHoaDon());
			stmt.setString(2, cthd.getSp().getGiaSanPham().getMaGiaSanPham());
			stmt.setInt(3, cthd.getSl());
			stmt.setDouble(4, cthd.getThanhTien());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return success;
	}
}
