package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import connectDB.connectDBs;
import entity.HoaDon;

public class DAO_HoaDon {
	public boolean addHoaDon(HoaDon hd) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("INSERT INTO HoaDon (maHoaDon, maNhanVien, ngayLap, tongTien, maKhach, tienKhach, tienthua, diemSuDung) VALUES (?,?,?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(2, hd.getNv().getMaNhanVien());
			Timestamp timestamp = Timestamp.valueOf(hd.getNgayLap());
			stmt.setTimestamp(3, timestamp);
			stmt.setDouble(4, hd.getTongTien());
			stmt.setString(5, hd.getKh().getMaKH());
			stmt.setDouble(6, hd.getTienKhach());
			stmt.setDouble(7, hd.getTienThua());
			stmt.setInt(8, hd.getDiemSuDung());
			
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
