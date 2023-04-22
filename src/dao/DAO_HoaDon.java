package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;

public class DAO_HoaDon {
	public static ArrayList<HoaDon> getDanhSachHoaDon(){
		ArrayList<HoaDon> listKH = new ArrayList<HoaDon>();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM HoaDon";
			Statement stm = connect.createStatement();
			
			ResultSet result = stm.executeQuery(sql);
			while(result.next()) {
				int maHoaDon = result.getInt("MaHoaDon");
				int maDonDat = result.getInt("MaDonDat");
				double phuPhi = result.getDouble("PhuPhi");
				double tongThanhTien = result.getDouble("TongThanhTien");
				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
				Timestamp ngayTraPhong = result.getTimestamp("NgayTraPhong");
				HoaDon tempHoaDon = new HoaDon(maHoaDon, maDonDat, phuPhi, tongThanhTien, ngayDatPhong, ngayTraPhong);
				listKH.add(tempHoaDon);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listKH;
	}
	public static HoaDon getHoaDonTheoMa(int maHoaDonCanTim) {
		HoaDon tempHoaDon = new HoaDon();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM HoaDon "
					+ "WHERE MaHoaDon = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			
			prpStm.setInt(1, maHoaDonCanTim);
			
			ResultSet result = prpStm.executeQuery();
			
			int rowCount = 0;
			
			while(result.next()) {
				int maHoaDon = result.getInt("MaHoaDon");
				int maDonDat = result.getInt("MaDonDat");
				double phuPhi = result.getDouble("PhuPhi");
				double tongThanhTien = result.getDouble("TongThanhTien");
				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
				Timestamp ngayTraPhong = result.getTimestamp("NgayTraPhong");
				tempHoaDon = new HoaDon(maHoaDon, maDonDat, phuPhi, tongThanhTien, ngayDatPhong, ngayTraPhong);
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
		return tempHoaDon;
	}
}