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
	public DAO_KhachHang() {}
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
			int rowCount = 0;
			while(result.next()) {
				int maKhachHang = result.getInt("MaKhachHang");
				String hoDem = result.getString("HoDem");
				String ten = result.getString("Ten");
				String cccd = result.getString("CCCD");
				String sdt = result.getString("SDT");
				String quocTich = result.getString("QuocTich");
				KhachHang tempKhachHang = new KhachHang(maKhachHang, hoDem, ten, cccd, sdt, quocTich);
				listKH.add(tempKhachHang);
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
	
	public static KhachHang getKhachHangTheoMaKhachHang(int maKhachHangCanTim) {
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
	public boolean createKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance().connectDatabase();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n =0;
		try {
			statement = con.prepareStatement("INSERT INTO KhachHang(HoDem, Ten, CCCD, SDT, QuocTich) VALUES(?,?,?,?,?)");
			//MaKhachHang là cột tăng tự động không cần thêm vào
			statement.setString(1, khachHang.getHoDem());
			statement.setString(2, khachHang.getTen());
			statement.setString(3, khachHang.getCccd());
			statement.setString(4, khachHang.getSdt());
			statement.setString(5, khachHang.getQuocTich());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				ConnectDB.getInstance().disconnectDatabase();
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean updateKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance().connectDatabase();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n =0;
		try {
			statement = con.prepareStatement("UPDATE KhachHang SET HoDem=?, Ten=?, CCCD=?, SDT=?, QuocTich=? WHERE MaKhachHang=?");
			statement.setString(1, khachHang.getHoDem());
			statement.setString(2, khachHang.getTen());
			statement.setString(3, khachHang.getCccd());
			statement.setString(4, khachHang.getSdt());
			statement.setString(5, khachHang.getQuocTich());
			statement.setInt(6, khachHang.getMaKhachHang());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				ConnectDB.getInstance().disconnectDatabase();
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
}
