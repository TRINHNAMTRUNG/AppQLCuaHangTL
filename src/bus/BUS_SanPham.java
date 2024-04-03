package bus;

import java.util.ArrayList;

import dao.DAO_SanPham;
import entity.DonVi;
import entity.LoaiSanPham;
import entity.SanPham;

public class BUS_SanPham {
	private DAO_SanPham daoSanPham = new DAO_SanPham();
	
	public BUS_SanPham() {
		
	}
	public ArrayList<SanPham> getAllSanPham(){
		System.out.println("checkkk");
		return daoSanPham.getAllSanPham();
	}
	public boolean addSanPham(SanPham sanPham, boolean kiemTraTonTaiSanPham){
		return daoSanPham.addSanPham(sanPham, kiemTraTonTaiSanPham);
	}
	public boolean deleteSanPham(SanPham sanPham){
		return daoSanPham.deleteSanPham(sanPham);
	}
	public boolean updateSanPham(SanPham sanPham){
		return daoSanPham.updateSanPham(sanPham);
	}
	public ArrayList<SanPham> timKiemDieuKien(String maLoai,String giaTu, String giaDen, boolean trangThai){
		return daoSanPham.getSanPhamDieuKiem(maLoai, giaTu, giaDen, trangThai);
	}
	public ArrayList<SanPham> timKiemMaHoacTen(String infoMaHoacTen){
		return daoSanPham.getSanPhamMaHoacTen(infoMaHoacTen);
	}
	
	public ArrayList<LoaiSanPham> getAllLoaiSanPham(){
		return daoSanPham.getAllLoaiSanPham();
	}
	public ArrayList<DonVi> getAllDonVi(){
		return daoSanPham.getAllDonVi();
	}
	public boolean addDonVi(DonVi donVi){
		return daoSanPham.addDonVi(donVi);
	}
	public boolean addLoaiSanPham(LoaiSanPham loaiSanPham){
		return daoSanPham.addLoaiSanPham(loaiSanPham);
	}
	
}
