package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongDat;
import entity.DonDatPhong.enum_HinhThucThue;

public class DAO_DonDatPhong_Phong {
	public DAO_DonDatPhong_Phong() {}
	public static ArrayList<String> getDanhSachMaPhongDuocDatTheoMaDonDat(int maDonDatCanTim){
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
				listMaPhong.add(maPhong);
				rowCount++;
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
	
	public static boolean createDonDatPhong_Phong(PhongDat p) {
		ConnectDB.getInstance().connectDatabase();
		Connection connection = ConnectDB.getConnection();
		int n = 0;
		try {
			String sql = "INSERT [dbo].[DonDatPhong_Phong] ([MaDonDat], [MaPhong]) VALUES (?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, p.getDonDatPhong().getMaDonDat()+"");
			statement.setString(2, p.getPhong().getMaPhong());
			n = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return n>0;
	}
}
