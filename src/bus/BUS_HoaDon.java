package bus;

import dao.DAO_HoaDon;
import entity.HoaDon;

public class BUS_HoaDon {
	DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	public boolean addHoaDon(HoaDon hd) {
		return dao_HoaDon.addHoaDon(hd);
	}
}
