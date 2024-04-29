package bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.connectDBs;
import dao.DAO_NhaCungCap;
import entity.NhaCungCap;
import entity.SanPham;

public class BUS_NhaCungCap {
	private DAO_NhaCungCap daoNhaCungCap = new DAO_NhaCungCap();
	
	public BUS_NhaCungCap() {
		
	}
	public ArrayList<NhaCungCap> getAllNhaCungCap(){
		return daoNhaCungCap.getAllNhaCungCap();
	}
	
	public boolean addNhaCungCap(NhaCungCap ncc){
		if (kiemTraMaTonTai(ncc.getMaNhaCungCap())) {
	        return false;
	    }

	    return daoNhaCungCap.addNCC(ncc);
	}
	
	public boolean deleteNhaCungCap(NhaCungCap ncc){
		return daoNhaCungCap.deleteNhaCungCap(ncc);
	}
	
	public boolean updateNhaCungCap(NhaCungCap ncc){
		return daoNhaCungCap.updateSanPham(ncc);
	}
	
	public ArrayList<NhaCungCap> timKiemMa(String ma){
		return daoNhaCungCap.getNhaCungCapTheoMa(ma);
	}
	
	public ArrayList<NhaCungCap> timKiemSDT(String sdt){
		return daoNhaCungCap.getNhaCungCapTheoSDT(sdt);
	}
	
	public boolean kiemTraMaTonTai(String maNhaCungCap) {
	    connectDBs.getInstance();
	    Connection con = connectDBs.getConnConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    boolean tonTai = false;

	    try {
	        String sql = "SELECT COUNT(*) AS count FROM NhaCungCap WHERE maNhaCungCap = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, maNhaCungCap);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt("count");
	            if (count > 0) {
	                tonTai = true;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return tonTai;
	}
}