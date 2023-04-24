package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.LoaiPhong;

public class DAO_LoaiPhong {
	public DAO_LoaiPhong() {}
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
