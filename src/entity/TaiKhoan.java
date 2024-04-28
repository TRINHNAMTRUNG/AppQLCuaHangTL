package entity;

import java.util.Objects;

public class TaiKhoan {
	private NhanVien nv;
	private String pass;
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(NhanVien nv, String pass) {
		super();
		this.nv = nv;
		this.pass = pass;
	}
	public NhanVien getNv() {
		return nv;
	}
	public void setNv(NhanVien nv) {
		this.nv = nv;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		return Objects.equals(nv, other.nv);
	}
	@Override
	public String toString() {
		return "TaiKhoan [nv=" + nv + ", pass=" + pass + "]";
	}
	
}
