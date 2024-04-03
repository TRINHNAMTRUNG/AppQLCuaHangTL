package entity;

import java.util.Objects;

public class SanPham {
	private String maSanPham, tenSanPham;
	private LoaiSanPham loaiSanPham;
	private NhaCungCap nhaCungCap;
	private GiaSanPham giaSanPham;
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String maSanPham, String tenSanPham, LoaiSanPham loaiSanPham, NhaCungCap nhaCungCap,
			GiaSanPham giaSanPham) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.loaiSanPham = loaiSanPham;
		this.nhaCungCap = nhaCungCap;
		this.giaSanPham = giaSanPham;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}
	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public GiaSanPham getGiaSanPham() {
		return giaSanPham;
	}
	public void setGiaSanPham(GiaSanPham giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	@Override
	public int hashCode() {
		return Objects.hash(giaSanPham, loaiSanPham, maSanPham, nhaCungCap, tenSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(giaSanPham, other.giaSanPham) && Objects.equals(loaiSanPham, other.loaiSanPham)
				&& Objects.equals(maSanPham, other.maSanPham) && Objects.equals(nhaCungCap, other.nhaCungCap)
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", loaiSanPham=" + loaiSanPham
				+ ", nhaCungCap=" + nhaCungCap + ", giaSanPham=" + giaSanPham + "]";
	}
	
	
}