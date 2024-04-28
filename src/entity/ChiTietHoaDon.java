package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private HoaDon hd;
	private SanPham sp;
	private int sl; 
	private double thanhTien;
	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoaDon(HoaDon hd, SanPham sp, int sl, double thanhTien) {
		super();
		this.hd = hd;
		this.sp = sp;
		this.sl = sl;
		this.thanhTien = thanhTien;
	}
	public HoaDon getHd() {
		return hd;
	}
	public void setHd(HoaDon hd) {
		this.hd = hd;
	}
	public SanPham getSp() {
		return sp;
	}
	public void setSp(SanPham sp) {
		this.sp = sp;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(hd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(hd, other.hd);
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [hd=" + hd + ", sp=" + sp + ", sl=" + sl + ", thanhTien=" + thanhTien + "]";
	}
	
}
