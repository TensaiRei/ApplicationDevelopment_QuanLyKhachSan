package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class DAO_KhachHang {
	public DAO_KhachHang() {
		
	}
	public static ArrayList<KhachHang> getDanhSachKhachHang(){
		ArrayList<KhachHang> listKH = new ArrayList<KhachHang>();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM KhachHang";
			Statement stm = connect.createStatement();
			
			ResultSet result = stm.executeQuery(sql);
			while(result.next()) {
				int maKhachHang = result.getInt("MaKhachHang");
				String hoDem = result.getString("HoDem");
				String ten = result.getString("Ten");
				String cccd = result.getString("CCCD");
				String sdt = result.getString("SDT");
				String quocTich = result.getString("QuocTich");
				KhachHang tempKhachHang = new KhachHang(maKhachHang, hoDem, ten, cccd, sdt, quocTich);
				listKH.add(tempKhachHang);
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
	
	public static KhachHang getKhachHangTheoMa(int maKhachHangCanTim) {
		KhachHang tempKhachHang = new KhachHang();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM KhachHang "
					+ "WHERE MaKhachHang = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			
			prpStm.setInt(1, maKhachHangCanTim);
			
			ResultSet result = prpStm.executeQuery();
			
			int rowCount = 0;
			
			while(result.next()) {
				int maKhachHang = result.getInt("MaKhachHang");
				String hoDem = result.getString("HoDem");
				String ten = result.getString("Ten");
				String cccd = result.getString("CCCD");
				String sdt = result.getString("SDT");
				String quocTich = result.getString("QuocTich");
				tempKhachHang = new KhachHang(maKhachHang, hoDem, ten, cccd, sdt, quocTich);
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
		return tempKhachHang;
	}
}
