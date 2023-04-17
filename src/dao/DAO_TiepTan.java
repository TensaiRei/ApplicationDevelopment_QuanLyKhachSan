package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TiepTan;

public class DAO_TiepTan {
	public static ArrayList<TiepTan> getDanhSachTiepTan(){
		ArrayList<TiepTan> listTT = new ArrayList<TiepTan>();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM TiepTan";
			Statement stm = connect.createStatement();
			
			ResultSet result = stm.executeQuery(sql);
			while(result.next()) {
				String maTiepTan = result.getString("MaTiepTan");
				String hoDem = result.getString("HoDem");
				String ten = result.getString("Ten");
				String cccd = result.getString("CCCD");
				String sdt = result.getString("SDT");
				String maTaiKhoan = result.getString("MaTaiKhoan");
				TiepTan tempTiepTan = new TiepTan(maTiepTan, hoDem, ten, cccd, sdt, maTaiKhoan);
				listTT.add(tempTiepTan);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listTT;
	}
	public static TiepTan getTiepTanTheoMaTaiKhoan(String maTaiKhoan) {
		ArrayList<TiepTan> listTT = getDanhSachTiepTan();
		for(TiepTan thisTiepTan : listTT) {
			if(thisTiepTan.getMaTaiKhoan().equals(maTaiKhoan)) {
				return thisTiepTan;
			}
		}
		return null;
	}
}
