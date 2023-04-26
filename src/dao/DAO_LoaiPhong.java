package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhong;

public class DAO_LoaiPhong {
 
	public static ArrayList<LoaiPhong> getAllLoaiPhong() {
		ArrayList<LoaiPhong> cacLoaiPhong = new ArrayList<LoaiPhong>();
		try {
			ConnectDB.getInstance().connectDatabase();;
			Connection connection = ConnectDB.getConnection();
			
			String sql = "select * from LoaiPhong";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String maLoaiPhong = rs.getString("maLoaiPhong");
				String tenLoaiPhong = rs.getString("tenLoaiPhong");
				double donGia = rs.getDouble("donGia");
				LoaiPhong loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, donGia);
				cacLoaiPhong.add(loaiPhong);			
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
		return cacLoaiPhong;
	}

	public static LoaiPhong getLoaiPhongTheoMaLoaiPhong(String maLoaiPhongCanTim) {
		LoaiPhong loaiPhong = new LoaiPhong();
		try {
			ConnectDB.getInstance().connectDatabase();
			Connection connect = ConnectDB.getConnection();
			String sql = ""
					+ "SELECT * "
					+ "FROM LoaiPhong "
					+ "WHERE MaLoaiPhong = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setString(1, maLoaiPhongCanTim);
			ResultSet result = prpStm.executeQuery();
			int rowCount = 0;
			while(result.next()) {
				String maLoaiPhong = result.getString("MaLoaiPhong");
				String tenLoaiPhong = result.getString("TenLoaiPhong");
				double donGia = result.getDouble("DonGia");
				loaiPhong = new LoaiPhong(maLoaiPhong, tenLoaiPhong, donGia);
				return loaiPhong;
			}
			if(rowCount == 0) return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return loaiPhong;
	}
}
