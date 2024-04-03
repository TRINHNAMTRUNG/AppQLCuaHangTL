package bus;

import java.util.ArrayList;

import dao.DAO_NhaCungCap;
import entity.NhaCungCap;

public class BUS_NhaCungCap {
	private DAO_NhaCungCap daoNhaCungCap = new DAO_NhaCungCap();
	
	public BUS_NhaCungCap() {
		
	}
	public ArrayList<NhaCungCap> getAllNhaCungCap(){
		System.out.println("checkkk");
		return daoNhaCungCap.getAllNhaCungCap();
	}
}
