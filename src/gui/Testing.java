package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import connectDB.ConnectDB;
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
import entity.Phong;
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
		
//		ConnectDB.getInstance().connectDatabase();
//		Connection connect = ConnectDB.getConnection();
//		ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
//		
//		try {
//			String sql = ""
//					+ "SELECT * "
//					+ "FROM HoaDon";
//			PreparedStatement prpStm = connect.prepareStatement(sql);
//			
//			
//			
//			ResultSet result = prpStm.executeQuery();
//			
//			while(result.next()) {
//				int maHoaDon = result.getInt("MaHoaDon");
//				int maDonDat = result.getInt("MaDonDat");
//				double phuPhi = result.getDouble("PhuPhi");
//				double tongThanhTien = result.getDouble("TongThanhTien");
//				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
//				Timestamp ngayTraPhong = result.getTimestamp("NgayTraPhong");
//				
//				DonDatPhong donDatPhong = DAO_DonDatPhong.getDonDatPhongTheoMaDonDat(maDonDat);
//				
//				HoaDon tempHoaDon = new HoaDon(maHoaDon, donDatPhong, phuPhi, tongThanhTien, ngayDatPhong, ngayTraPhong);
//				
//				listHD.add(tempHoaDon);
//			}
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		for(HoaDon thisHD : listHD) {
//			double tongTien = 0;
//			double phuPhi = 50000;
//			double tiLeGioThue = 0.07;
//			
//			Enum_HinhThucThue enumHinhThucThue = thisHD.getDonDatPhong().getHinhThucThue();
//			ArrayList<DonDatPhong_Phong> listDP = DAO_DonDatPhong_Phong.getDanhSachPhongDatTheoMaDonDat(thisHD.getDonDatPhong().getMaDonDat());
//			double thoiGianDatPhong = thisHD.getNgayDatPhong().getTime();
//			double thoiGianTraPhong = thisHD.getNgayTraPhong().getTime();
//			long thoiGianThue = 0;
//			if(enumHinhThucThue.equals(Enum_HinhThucThue.Days)) {
//				thoiGianThue = Math.round(Math.ceil((thoiGianTraPhong-thoiGianDatPhong)/86400000));
//			}
//			if(enumHinhThucThue.equals(Enum_HinhThucThue.Hours)) {
//				thoiGianThue = Math.round(Math.ceil((thoiGianTraPhong-thoiGianDatPhong)/3600000));
//			}
//			if(enumHinhThucThue.equals(Enum_HinhThucThue.Days)) {
//        		for(DonDatPhong_Phong thisDP : listDP) {
//        			Phong thisPhong = thisDP.getPhongDat();
//        			double donGiaPhong = thisPhong.getLoaiPhong().getDonGia();
//        			tongTien += donGiaPhong*thoiGianThue;
//        		}
//        	}
//        	if(enumHinhThucThue.equals(Enum_HinhThucThue.Hours)) {
//        		for(DonDatPhong_Phong thisDP : listDP) {
//        			Phong thisPhong = thisDP.getPhongDat();
//        			double donGiaPhong = thisPhong.getLoaiPhong().getDonGia();
//        			tongTien+= donGiaPhong*tiLeGioThue*thoiGianThue;
//        		}
//        	}
//        	
//        	ArrayList<DonDatPhong_DichVu> listDDV = DAO_DonDatPhong_DichVu.getDanhSachDichVuDatTheoMaDonDat(thisHD.getDonDatPhong().getMaDonDat());
//        	
//        	double tongTienDichVu = 0;
//        	if(listDDV != null) {
//        		for(DonDatPhong_DichVu thisDDV : listDDV) {
//            		DichVu thisDichVu = thisDDV.getDichVu();
//            		tongTienDichVu += thisDichVu.getDonGia() * thisDDV.getSoLuong();
//            	}
//        	}
//        	
//        	tongTien = tongTien + tongTienDichVu + listDP.size()*phuPhi;
//        	
//        	NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
//        	System.out.println(nf.format(tongTien));
//        	
//        	try {
//				String sqlUpdate = ""
//						+ "UPDATE HoaDon "
//						+ "SET TongThanhTien = ? "
//						+ "WHERE MaHoaDon = ?";
//				PreparedStatement prpStm = connect.prepareStatement(sqlUpdate);
//				prpStm.setDouble(1, tongTien);
//				prpStm.setInt(2, thisHD.getMaHoaDon());
//				
//				int n = prpStm.executeUpdate();
//				
//				String sqlUpdate2 = ""
//						+ "UPDATE DonDatPhong "
//						+ "SET NgayDatPhong = ? "
//						+ "WHERE MaDonDat = ?";
//				
//				PreparedStatement prpStm2 = connect.prepareStatement(sqlUpdate2);
//				prpStm2.setTimestamp(1, thisHD.getNgayDatPhong());
//				prpStm2.setInt(2, thisHD.getDonDatPhong().getMaDonDat());
//				
//				int n2 = prpStm2.executeUpdate();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("Done");
//		ConnectDB.getInstance().disconnectDatabase();
	}
	
//	public static void tinhTongTienTheoPhong() {
//		ConnectDB.getInstance().connectDatabase();
//		Connection connect = ConnectDB.getConnection();
//		ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
//		int thang = 5;
//		int nam = 2023;
//		
//		try {
//			String sql = ""
//					+ "SELECT * "
//					+ "FROM HoaDon "
//					+ "WHERE YEAR(NgayTraPhong) = ? AND MONTH(NgayTraPhong) = ?";
//			PreparedStatement prpStm = connect.prepareStatement(sql);
//			
//			prpStm.setInt(1, nam);
//			prpStm.setInt(2, thang);
//			
//			ResultSet result = prpStm.executeQuery();
//			
//			while(result.next()) {
//				int maHoaDon = result.getInt("MaHoaDon");
//				int maDonDat = result.getInt("MaDonDat");
//				double phuPhi = result.getDouble("PhuPhi");
//				double tongThanhTien = result.getDouble("TongThanhTien");
//				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
//				Timestamp ngayTraPhong = result.getTimestamp("NgayTraPhong");
//				
//				DonDatPhong donDatPhong = DAO_DonDatPhong.getDonDatPhongTheoMaDonDat(maDonDat);
//				
//				HoaDon tempHoaDon = new HoaDon(maHoaDon, donDatPhong, phuPhi, tongThanhTien, ngayDatPhong, ngayTraPhong);
//				
//				listHD.add(tempHoaDon);
//			}
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		for(HoaDon thisHD : listHD) {
//			double tongTien = 0;
//			double tiLeGioThue = 0.07;
//			Enum_HinhThucThue enumHinhThucThue = thisHD.getDonDatPhong().getHinhThucThue();
//			ArrayList<DonDatPhong_Phong> listDP = DAO_DonDatPhong_Phong.getDanhSachPhongDatTheoMaDonDat(thisHD.getDonDatPhong().getMaDonDat());
//			double thoiGianDatPhong = thisHD.getNgayDatPhong().getTime();
//			double thoiGianTraPhong = thisHD.getNgayTraPhong().getTime();
//			long thoiGianThue = 0;
//			if(enumHinhThucThue.equals(Enum_HinhThucThue.Days)) {
//				thoiGianThue = Math.round(Math.ceil((thoiGianTraPhong-thoiGianDatPhong)/86400000));
//			}
//			if(enumHinhThucThue.equals(Enum_HinhThucThue.Hours)) {
//				thoiGianThue = Math.round(Math.ceil((thoiGianTraPhong-thoiGianDatPhong)/3600000));
//			}
//			if(enumHinhThucThue.equals(Enum_HinhThucThue.Days)) {
//        		for(DonDatPhong_Phong thisDP : listDP) {
//        			Phong thisPhong = thisDP.getPhongDat();
//        			double donGiaPhong = thisPhong.getLoaiPhong().getDonGia();
//        			tongTien += donGiaPhong*thoiGianThue;
//        		}
//        	}
//        	if(enumHinhThucThue.equals(Enum_HinhThucThue.Hours)) {
//        		for(DonDatPhong_Phong thisDP : listDP) {
//        			Phong thisPhong = thisDP.getPhongDat();
//        			double donGiaPhong = thisPhong.getLoaiPhong().getDonGia();
//        			tongTien+= donGiaPhong*tiLeGioThue*thoiGianThue;
//        		}
//        	}
//        	NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
//        	System.out.println(nf.format(tongTien));
//		}
//	}
}

