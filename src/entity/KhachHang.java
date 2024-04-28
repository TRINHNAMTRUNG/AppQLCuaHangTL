package entity;

import java.util.Objects;

public class KhachHang {
	private String tenKhach, email, sdt, maKH;
	private int diemTichLuy;
	

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String tenKhach, String email, String sdt, String maKH, int diemTichLuy) {
		super();
		this.tenKhach = tenKhach;
		this.email = email;
		this.sdt = sdt;
		this.maKH = maKH;
		this.diemTichLuy = diemTichLuy;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	public String getTenKhach() {
		return tenKhach;
	}

	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(sdt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(sdt, other.sdt);
	}

	@Override
	public String toString() {
		return "KhachHang [tenKhach=" + tenKhach + ", email=" + email + ", sdt=" + sdt + ", maKH=" + maKH
				+ ", diemTichLuy=" + diemTichLuy + "]";
	}

	
	
}
