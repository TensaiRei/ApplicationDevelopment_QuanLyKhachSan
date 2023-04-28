package gui;

import java.util.ArrayList;

import dao.DAO_DichVu;
import dao.DAO_DonDatPhong;
import dao.DAO_DonDatPhong_DichVu;
import dao.DAO_DonDatPhong_Phong;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_LoaiPhong;
import dao.DAO_Phong;
import dao.DAO_TaiKhoan;
import dao.DAO_TiepTan;
import entity.DichVuDat;
import entity.HoaDon;

@SuppressWarnings("unused")
public class Testing {
	
	public static void main(String[] args) {
		//Test DAO_DichVu
			//System.out.println(DAO_DichVu.getAllDSDichVu());
			//System.out.println(DAO_DichVu.getDSDichVuTheoThucAn());
			//System.out.println(DAO_DichVu.getDSDichVuTheoDoUong());
			//System.out.println(DAO_DichVu.getDSDichVuConLai());
			//System.out.println(DAO_DichVu.getDichVuTheoMaDichVu("DVF001"));
			//System.out.println(DAO_DichVu.getDSDichVuConLai());
			//System.out.println(DAO_DichVu.getDanhSachDichVuTheoDanhSachDichVuDuocDat(new ArrayList<DichVuDat>() {{add(new DichVuDat(1, 100000, "DVD001", "PHG0401", 3));}}));
		//Test DAO_DonDatPhong_DichVu
			//System.out.println(DAO_DonDatPhong_DichVu.getDanhSachDichVuDatTheoMaDonDat(100000));
			//System.out.println(DAO_DonDatPhong_DichVu.getDanhSachDichVuDatTheoMaDonDatMaPhong(100000, "PHG0401"));
		//Test Dao_DonDatPhong_Phong
			//System.out.println(DAO_DonDatPhong_Phong.getDanhSachMaPhongDuocDatTheoMaDonDat(100000));
			//System.out.println(DAO_DonDatPhong_Phong.getMaDonDatGanNhatCuaPhong("PHG0401"));
		//Test DAO_DonDatPhong
			//System.out.println(DAO_DonDatPhong.getDanhSachDonDatPhong());
			//System.out.println(DAO_DonDatPhong.getDonDatPhongTheoMaDonDat(100000));
		//Test DAO_HoaDon
			//System.out.println(DAO_HoaDon.getDanhSachHoaDon());
			//System.out.println(DAO_HoaDon.getHoaDonTheoMaHoaDon(100000));
		//Test DAO_KhachHang
			//System.out.println(DAO_KhachHang.getDanhSachKhachHang());
			//System.out.println(DAO_KhachHang.getKhachHangTheoMaKhachHang(10000));
		//Test DAO_Phong
			//System.out.println(DAO_Phong.getDanhSachPhong());
			//System.out.println(DAO_Phong.getDanhSachPhongTheoDanhSachMaPhongDuocDat(new ArrayList<String>() {{add("PHG0401"); add("PHG0402");}}));
			//System.out.println(DAO_Phong.getPhongTheoMaPhong("PHG0401"));
		//Test DAO_LoaiPhong
			//System.out.println(DAO_LoaiPhong.getLoaiPhongTheoMaLoaiPhong("LPG0001"));
		//Test DAO_TaiKhoan
			//System.out.println(DAO_TaiKhoan.kiemTraTaiKhoan(null, null));
			//System.out.println(DAO_TaiKhoan.getTaiKhoanHienHanh());
		//Test DAO_TiepTan
			//System.out.println(DAO_TiepTan.getDanhSachTiepTan());
			//System.out.println(DAO_TiepTan.getTiepTanTheoMaTaiKhoan("TKNTTN0001"));
		//Test UI_ChiTietDonDat
			//UI_Main.newUI_MainInstance();
			//UI_Main.getUI_MainInstance().setVisible(true);
			//UI_Main.getUI_MainInstance().showUI(UI_ChiTietDonDat.getUI_ChiTietDonDatInstance());
		//Test UI_DonDatPhong;
			//UI_Main.newUI_MainInstance();
			//UI_Main.getUI_MainInstance().setVisible(true);
			//UI_Main.getUI_MainInstance().showUI(UI_DonDatPhong.getUI_DonDatPhongInstance());
	}
}
