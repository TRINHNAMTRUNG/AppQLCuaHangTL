package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon;
	private NhanVien nv; 
	private KhachHang kh;
	private LocalDateTime ngayLap;
	private double tongTien;
	private double tienThua, tienKhach; 
	private int diemSuDung;
	public HoaDon(String maHoaDon, NhanVien nv, KhachHang kh, LocalDateTime ngayLap, double tongTien, double tienThua,
			double tienKhach, int diemSuDung) {
		super();
		this.maHoaDon = maHoaDon;
		this.nv = nv;
		this.kh = kh;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.tienThua = tienThua;
		this.tienKhach = tienKhach;
		this.diemSuDung = diemSuDung;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public NhanVien getNv() {
		return nv;
	}
	public void setNv(NhanVien nv) {
		this.nv = nv;
	}
	public KhachHang getKh() {
		return kh;
	}
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public double getTienThua() {
		return tienThua;
	}
	public void setTienThua(double tienThua) {
		this.tienThua = tienThua;
	}
	public double getTienKhach() {
		return tienKhach;
	}
	public void setTienKhach(double tienKhach) {
		this.tienKhach = tienKhach;
	}
	public int getDiemSuDung() {
		return diemSuDung;
	}
	public void setDiemSuDung(int diemSuDung) {
		this.diemSuDung = diemSuDung;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", nv=" + nv + ", kh=" + kh + ", ngayLap=" + ngayLap + ", tongTien="
				+ tongTien + ", tienThua=" + tienThua + ", tienKhach=" + tienKhach + ", diemSuDung=" + diemSuDung + "]";
	}

	
}	
