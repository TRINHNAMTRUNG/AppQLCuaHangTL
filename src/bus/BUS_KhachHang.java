package bus;

import java.util.ArrayList;

import dao.DAO_KhachHang;
import entity.KhachHang;
public class BUS_KhachHang {
	DAO_KhachHang daoKhachHang = new DAO_KhachHang();
	public ArrayList<KhachHang> getAllKhach(){
		return daoKhachHang.getAllKhach();
	}
	public KhachHang getKhach(String sdt){
		return daoKhachHang.getKhach(sdt);
	}
	public boolean addKhach(KhachHang kh){
		return daoKhachHang.addKhach(kh);
	}
	public boolean updateKhach(KhachHang kh){
		return daoKhachHang.updateKhach(kh);
	}
}
