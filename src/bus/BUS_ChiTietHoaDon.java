package bus;

import dao.DAO_ChiTietHoaDon;
import entity.ChiTietHoaDon;

public class BUS_ChiTietHoaDon {
	DAO_ChiTietHoaDon dao_ChiTietHoaDon = new DAO_ChiTietHoaDon();
	public boolean addChiTietHoaDon(ChiTietHoaDon cthd) {
		return dao_ChiTietHoaDon.addChiTietHoaDon(cthd);
	}
}
