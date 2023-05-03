package gui;

import java.util.ArrayList;

import dao.DAO_DichVu;
import dao.DAO_DonDatPhong;
import dao.DAO_DonDatPhong_DichVu;
import dao.DAO_DonDatPhong_Phong;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_LoaiPhong;
import dao.DAO_TaiKhoan;
import dao.DAO_TiepTan;
import entity.DichVu;
import entity.DonDatPhong;
import entity.DonDatPhong_DichVu;
import entity.DonDatPhong_Phong;
import entity.Enum_HinhThucThue;
import entity.Enum_TrangThaiThanhToan;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.TiepTan;

@SuppressWarnings("unused")
public class Testing {

	public static void main(String[] args) {
		//DAO_TaiKhoan
//		System.out.println(DAO_TaiKhoan.kiemTraTaiKhoan("ThienPhu", "NguyenThienPhu"));
//		System.out.println(DAO_TaiKhoan.kiemTraTaiKhoan("ThienPhu", "NguyenThienPhuc"));
		
//		System.out.println(DAO_TaiKhoan.getTaiKhoanTheoMaTaiKhoan("TKNTTN0000"));
//		System.out.println(DAO_TaiKhoan.getTaiKhoanTheoMaTaiKhoan("TKNTTN0001"));
//		System.out.println(DAO_TaiKhoan.getTaiKhoanTheoMaTaiKhoan("TKNTTN0002"));
		
		//DAO_TiepTan
//		for(TiepTan thisTiepTan : DAO_TiepTan.getDanhSachTiepTan()) {
//			System.out.println(thisTiepTan);
//		}
		
//		System.out.println(DAO_TiepTan.getTiepTanTheoMaTiepTan("TTN0000"));
//		System.out.println(DAO_TiepTan.getTiepTanTheoMaTiepTan("TTN0001"));

//		System.out.println(DAO_TiepTan.getTiepTanTheoMaTaiKhoan("TKNTTN0000"));
//		System.out.println(DAO_TiepTan.getTiepTanTheoMaTaiKhoan("TKNTTN0001"));
	
		//DAO_KhachHang
//		for(KhachHang thisKhachHang : DAO_KhachHang.getDanhSachKhachHang()) {
//			System.out.println(thisKhachHang);
//		}
		
//		System.out.println(DAO_KhachHang.getKhachHangTheoMaKhachHang(0));
//		System.out.println(DAO_KhachHang.getKhachHangTheoMaKhachHang(10000));
		
//		System.out.println(DAO_KhachHang.getKhachHangTheoCCCD("077100000000"));
//		System.out.println(DAO_KhachHang.getKhachHangTheoCCCD("077100000001"));

//		System.out.println(DAO_KhachHang.createKhachHang(new KhachHang("Nguyễn Nam", "Sáu", "0684096850431", "0333000102", "Việt Nam")));
		
		//DAO_LoaiPhong
//		for(LoaiPhong thisLoaiPhong : DAO_LoaiPhong.getAllLoaiPhong()) {
//			System.out.println(thisLoaiPhong);
//		}
		
//		System.out.println(DAO_LoaiPhong.getLoaiPhongTheoMaLoaiPhong("LPG0000"));
//		System.out.println(DAO_LoaiPhong.getLoaiPhongTheoMaLoaiPhong("LPG0001"));
	
		//DAO_Phong
		
		//DAO_DichVu
//		for(DichVu thisDichVu : DAO_DichVu.getAllDSDichVu()) {
//			System.out.println(thisDichVu);
//		}
		
//		for(DichVu thisDichVu : DAO_DichVu.getDSDichVuTheoThucAn()) {
//			System.out.println(thisDichVu);
//		}
		
//		for(DichVu thisDichVu : DAO_DichVu.getDSDichVuTheoDoUong()) {
//			System.out.println(thisDichVu);
//		}
		
//		for(DichVu thisDichVu : DAO_DichVu.getDSDichVuConLai()) {
//			System.out.println(thisDichVu);
//		}
		
//		System.out.println(DAO_DichVu.getDichVuTheoMaDichVu("DVD000"));
//		System.out.println(DAO_DichVu.getDichVuTheoMaDichVu("DVD001"));
		
		//DAO_DonDatPhong
//		for(DonDatPhong thisDonDatPhong : DAO_DonDatPhong.getDanhSachDonDatPhong()) {
//			System.out.println(thisDonDatPhong);
//		}
		
//		System.out.println(DAO_DonDatPhong.getDonDatPhongTheoMaDonDat(0));
//		System.out.println(DAO_DonDatPhong.getDonDatPhongTheoMaDonDat(100000));
		
//		System.out.println(DAO_DonDatPhong.createDonDatPhong(new DonDatPhong(DAO_KhachHang.getKhachHangTheoMaKhachHang(10000), DAO_TiepTan.getTiepTanTheoMaTiepTan("TTN0001"), 10, Enum_HinhThucThue.Days, Enum_TrangThaiThanhToan.Yet)));
		
		//DAO_DonDatPhong_DichVu
		
//		for(DonDatPhong_DichVu thisDDV : DAO_DonDatPhong_DichVu.getDanhSachDichVuDat()) {
//			System.out.println(thisDDV);
//		}
		
//		for(DonDatPhong_DichVu thisDDV : DAO_DonDatPhong_DichVu.getDanhSachDichVuDatTheoMaDonDat(100000)) {
//			System.out.println(thisDDV);
//		}
		
//		for(DonDatPhong_DichVu thisDDV : DAO_DonDatPhong_DichVu.getDanhSachDichVuDatTheoMaDonDatMaPhong(100000, "PHG0401")) {
//			System.out.println(thisDDV);
//		}
		
		//DAO_DonDatPhong_Phong
		
//		for(DonDatPhong_Phong thisDP : DAO_DonDatPhong_Phong.getDanhSachPhongDat()) {
//			System.out.println(thisDP);
//		}
		
//		for(DonDatPhong_Phong thisDP : DAO_DonDatPhong_Phong.getDanhSachPhongDatTheoMaDonDat(100000)) {
//			System.out.println(thisDP);
//		}
		
		//DAO_HoaDon
//		for(HoaDon thisHoaDon : DAO_HoaDon.getDanhSachHoaDon()) {
//			System.out.println(thisHoaDon);
//		}
	}
}
