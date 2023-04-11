package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;

public class DAO_Account {
	public static void getTaiKhoan() {
		
	}
	public static boolean kiemTraTaiKhoan(String username, String password) {
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		int rowCounter = 0;
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM Account "
					+ "WHERE AccountUsername = ? AND CONVERT(varchar, DECRYPTBYPASSPHRASE('QUANLYKHACHSAN', AccountPassword)) = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setString(1, username);
			prpStm.setString(2, password);
			ResultSet result = prpStm.executeQuery();
			
			while(result.next()) {rowCounter++;}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		if(rowCounter > 0 )
			return true;
		else
			return false;
	}
}
