package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.TaiKhoan;

public class DAO_TaiKhoan {
	private static TaiKhoan taiKhoanHienHanh;
	private static void setTaiKhoanHienHanh(String maTaiKhoan, String tenTaiKhoan) {
		taiKhoanHienHanh = new TaiKhoan(maTaiKhoan, tenTaiKhoan);
	}
	public static TaiKhoan getTaiKhoanHienHanh() {return taiKhoanHienHanh;}
	public static boolean kiemTraTaiKhoan(String username, String password) {
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		boolean tonTai = false;
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM TaiKhoan "
					+ "WHERE TenTaiKhoan = ? AND CONVERT(varchar, DECRYPTBYPASSPHRASE('QUANLYKHACHSAN', MatKhauTaiKhoan)) = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setString(1, username);
			prpStm.setString(2, password);
			ResultSet result = prpStm.executeQuery();
			if(result.next()) {
				setTaiKhoanHienHanh(result.getString("MaTaiKhoan"), result.getString("TenTaiKhoan"));
				tonTai=true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		if(tonTai)
			return true;
		else
			return false;
	}
	
}
