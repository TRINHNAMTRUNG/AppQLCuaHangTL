package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.connectDBs;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.SanPham;
public class DAO_KhachHang {
	public ArrayList<KhachHang> getAllKhach(){
		ArrayList<KhachHang> listKhach= new ArrayList<KhachHang>();
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM KhachHang");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String maKhach = rs.getString("maKhach");
				String tenKhach = rs.getString("tenKhach");
				String soDienThoai = rs.getString("soDienThoai");
				String mail = rs.getString("mail");
				int diemTichLuy = rs.getInt("diemTichLuy");
				
				KhachHang kh = new KhachHang(tenKhach, mail, soDienThoai, maKhach, diemTichLuy);
				listKhach.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return listKhach;
	}
	public KhachHang getKhach(String sdt){
		KhachHang kh= null;
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM KhachHang WHERE soDienThoai = ?");
			stmt.setString(1, sdt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String maKhach = rs.getString("maKhach");
				String tenKhach = rs.getString("tenKhach");
				String soDienThoai = rs.getString("soDienThoai");
				String mail = rs.getString("mail");
				int diemTichLuy = rs.getInt("diemTichLuy");
				kh = new KhachHang(tenKhach, mail, soDienThoai, maKhach, diemTichLuy);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return kh;
	}
	public boolean addKhach(KhachHang kh) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("INSERT INTO KhachHang (maKhach, tenKhach, soDienThoai, mail, diemTichLuy) VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKhach());
			stmt.setString(3, kh.getSdt());
			stmt.setString(4, kh.getEmail());
			stmt.setInt(5, kh.getDiemTichLuy());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public boolean updateKhach(KhachHang kh) {
		Connection con = connectDBs.getConnConnection();
		PreparedStatement stmt = null;
		boolean success = false;
		try {
			stmt = con.prepareStatement("UPDATE KhachHang SET tenKhach = ?, soDienThoai = ?, mail = ?, diemTichLuy = ? WHERE maKhach = ?");
			stmt.setString(1, kh.getTenKhach());
			stmt.setString(2, kh.getSdt());
			stmt.setString(3, kh.getEmail());
			stmt.setInt(4, kh.getDiemTichLuy());
			stmt.setString(5, kh.getMaKH());
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return success;
	}
}
