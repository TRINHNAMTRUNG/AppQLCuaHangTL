package bus;


import dao.DAO_DangNhap;
import entity.TaiKhoan;

public class BUS_DangNhap {
	DAO_DangNhap dao_DangNhap = new DAO_DangNhap();
	public TaiKhoan getTaiKhoan(String manv){
		return dao_DangNhap.getTaiKhoan(manv);
	}
}
