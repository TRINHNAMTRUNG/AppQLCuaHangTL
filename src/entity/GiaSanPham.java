package entity;

import java.util.Objects;

public class GiaSanPham {
	private String maGiaSanPham, anhSanPham;
	private SanPham sanPham;
	private DonVi donVi;
	private int soLuong;
	private double donGia, giaVon;
	private boolean trangThai;
	public GiaSanPham(String maGiaSanPham, String anhSanPham, SanPham sanPham, DonVi donVi, int soLuong, double donGia,
			double giaVon, boolean trangThai) {
		super();
		this.maGiaSanPham = maGiaSanPham;
		this.anhSanPham = anhSanPham;
		this.sanPham = sanPham;
		this.donVi = donVi;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.giaVon = giaVon;
		this.trangThai = trangThai;
	}
	public GiaSanPham(String maGiaSanPham, String anhSanPham, DonVi donVi, int soLuong, double donGia,
			double giaVon, boolean trangThai) {
		super();
		this.maGiaSanPham = maGiaSanPham;
		this.anhSanPham = anhSanPham;
		this.donVi = donVi;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.giaVon = giaVon;
		this.trangThai = trangThai;
	}
	public GiaSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaGiaSanPham() {
		return maGiaSanPham;
	}
	public void setMaGiaSanPham(String maGiaSanPham) {
		this.maGiaSanPham = maGiaSanPham;
	}
	public String getAnhSanPham() {
		return anhSanPham;
	}
	public void setAnhSanPham(String anhSanPham) {
		this.anhSanPham = anhSanPham;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public DonVi getDonVi() {
		return donVi;
	}
	public void setDonVi(DonVi donVi) {
		this.donVi = donVi;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getGiaVon() {
		return giaVon;
	}
	public void setGiaVon(double giaVon) {
		this.giaVon = giaVon;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anhSanPham, donGia, donVi, giaVon, maGiaSanPham, sanPham, soLuong, trangThai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaSanPham other = (GiaSanPham) obj;
		return Objects.equals(anhSanPham, other.anhSanPham)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(donVi, other.donVi)
				&& Double.doubleToLongBits(giaVon) == Double.doubleToLongBits(other.giaVon)
				&& Objects.equals(maGiaSanPham, other.maGiaSanPham) && Objects.equals(sanPham, other.sanPham)
				&& soLuong == other.soLuong && trangThai == other.trangThai;
	}
	@Override
	public String toString() {
		return "GiaSanPham [maGiaSanPham=" + maGiaSanPham + ", anhSanPham=" + anhSanPham + ", sanPham=" + sanPham
				+ ", donVi=" + donVi + ", soLuong=" + soLuong + ", donGia=" + donGia + ", giaVon=" + giaVon
				+ ", trangThai=" + trangThai + "]";
	}
	
	
}
