package entity;

import java.util.Objects;

public class DonVi {
	private String maDonVi, tenDonVi;

	public DonVi(String maDonVi, String tenDonVi) {
		super();
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
	}

	public DonVi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDonVi);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DonVi other = (DonVi) obj;
//		return Objects.equals(maDonVi, other.maDonVi);
//	}

	@Override
	public String toString() {
		return tenDonVi;
	} 
	
}
