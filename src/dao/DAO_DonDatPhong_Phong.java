package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;

public class DAO_DonDatPhong_Phong {
	public DAO_DonDatPhong_Phong() {
		
	}
	public static ArrayList<String> getDanhSachMaPhongDat(int maDonDatCanTim){
		ArrayList<String> listMaPhong = new ArrayList<String>();
		try {
			ConnectDB.getInstance().connectDatabase();
			Connection connect = ConnectDB.getConnection();
			String sql = "SELECT * "
					+ "FROM DonDatPhong_Phong "
					+ "WHERE MaDonDat = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setInt(1, maDonDatCanTim);
			
			ResultSet result = prpStm.executeQuery();
			
			int rowCount = 0;
			
			while(result.next()) {
				String maPhong = result.getString("MaPhong");
				rowCount++;
				listMaPhong.add(maPhong);
			}
			if(rowCount == 0) return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listMaPhong;
	}
	
	public static int getMaDonDatGanNhatCuaPhong(String maPhongCanTim) {
		int maPhong = 0;
		
		try {
			ConnectDB.getInstance().connectDatabase();
			Connection connect = ConnectDB.getConnection();
			String sql = "SELECT TOP 1 * "
					+ "FROM DonDatPhong_Phong "
					+ "WHERE MaPhong = ? "
					+ "ORDER BY ID DESC";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setString(1, maPhongCanTim);
			
			ResultSet result = prpStm.executeQuery();
			
			while(result.next()) {
				maPhong = result.getInt("MaDonDat");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		
		return maPhong;
	}
}
