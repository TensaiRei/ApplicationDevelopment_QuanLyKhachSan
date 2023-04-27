package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DonDatPhong;
import entity.DonDatPhong.enum_HinhThucThue;
import entity.DonDatPhong.enum_TrangThaiThanhToan;

public class DAO_DonDatPhong {
	public DAO_DonDatPhong() {}
	public static ArrayList<DonDatPhong> getDanhSachDonDatPhong(){
		ArrayList<DonDatPhong> listKH = new ArrayList<DonDatPhong>();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM DonDatPhong";
			Statement stm = connect.createStatement();
			ResultSet result = stm.executeQuery(sql);
			int rowCount = 0;
			while(result.next()) {
				int maDonDatPhong = result.getInt("MaDonDat");
				int maKhachHang = result.getInt("MaKhachHang");
				String maTiepTan = result.getString("MaTiepTan");
				int soLuongKhach = result.getInt("SoLuongKhach");
				String hinhThucThue = result.getString("HinhThucThue");
				String trangThaiThanhToan = result.getString("TrangThaiThanhToan");
				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
				enum_HinhThucThue enumHinhThucThue = null;
				if(hinhThucThue.equals("Theo giờ")) {
					enumHinhThucThue = enum_HinhThucThue.Hours;
				}
				if(hinhThucThue.equals("Theo ngày")) {
					enumHinhThucThue = enum_HinhThucThue.Days;
				}
				enum_TrangThaiThanhToan enumTrangThaiThanhToan = null;
				if(trangThaiThanhToan.equals("Chưa thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Yet;
				}
				if(trangThaiThanhToan.equals("Đã thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Paid;
				}
				DonDatPhong tempDonDatPhong = new DonDatPhong(maDonDatPhong, maKhachHang, maTiepTan, soLuongKhach, enumHinhThucThue, enumTrangThaiThanhToan, ngayDatPhong);
				listKH.add(tempDonDatPhong);
				rowCount++;
			}
			if(rowCount == 0) return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listKH;
	}
	public static DonDatPhong getDonDatPhongTheoMaDonDat(int maDonDatCanTim) {
		DonDatPhong tempDonDatPhong = new DonDatPhong();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM DonDatPhong "
					+ "WHERE MaDonDat = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setInt(1, maDonDatCanTim);
			ResultSet result = prpStm.executeQuery();
			int rowCount = 0;
			while(result.next()) {
				int maDonDat = result.getInt("MaDonDat");
				int maKhachHang = result.getInt("MaKhachHang");
				String maTiepTan = result.getString("MaTiepTan");
				int soLuongKhach = result.getInt("SoLuongKhach");
				String hinhThucThue = result.getString("HinhThucThue");
				String trangThaiThanhToan = result.getString("TrangThaiThanhToan");
				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
				enum_HinhThucThue enumHinhThucThue = null;
				if(hinhThucThue.equals("Theo giờ")) {
					enumHinhThucThue = enum_HinhThucThue.Hours;
				}
				if(hinhThucThue.equals("Theo ngày")) {
					enumHinhThucThue = enum_HinhThucThue.Days;
				}
				enum_TrangThaiThanhToan enumTrangThaiThanhToan = null;
				if(trangThaiThanhToan.equals("Chưa thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Yet;
				}
				if(trangThaiThanhToan.equals("Đã thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Paid;
				}
				tempDonDatPhong = new DonDatPhong(maDonDat, maKhachHang, maTiepTan, soLuongKhach, enumHinhThucThue, enumTrangThaiThanhToan, ngayDatPhong);
				rowCount++;
			}
			if(rowCount == 0) return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return tempDonDatPhong;
	}
	public static void setTrangThaiThanhToanMaDonDat(int maDonDatCanSet, String trangThaiThanhToanCanSet) {
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		
		try {
			String sql = ""
					+ "UPDATE DonDatPhong "
					+ "SET TrangThaiThanhToan = ? "
					+ "WHERE MaDonDat = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setString(1, trangThaiThanhToanCanSet);
			prpStm.setInt(2, maDonDatCanSet);
			prpStm.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
	}
}
