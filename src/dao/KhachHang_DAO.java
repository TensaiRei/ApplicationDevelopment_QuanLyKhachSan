package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public KhachHang_DAO() {
		
	}
	public ArrayList<KhachHang> getAllTableKhachHang(){
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maKH = rs.getString(1);
				String hoDem = rs.getString(2);
				String ten = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				String quocTich = rs.getString(6);
				
				KhachHang kh = new KhachHang(maKH, hoDem, ten, cmnd, sdt, quocTich);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	public ArrayList<KhachHang> getKhachHangTheoMaKH(String maKH){
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from KhachHang where MaKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maKhachHang = rs.getString(1);
				String hoDem = rs.getString(2);
				String ten = rs.getString(3);
				String cmnd = rs.getString(4);
				String sdt = rs.getString(5);
				String quocTich = rs.getString(6);
				
				KhachHang kh = new KhachHang(maKhachHang, hoDem, ten, cmnd, sdt, quocTich);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dskh;
	}
	public boolean create(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n =0;
		try {
			statement = con.prepareStatement("insert into"+" KhachHang values(?,?,?,?,?,?)");
			statement.setString(1, kh.getMaKH());
			statement.setString(2, kh.getHoDem());
			statement.setString(3, kh.getTen());
			statement.setString(4, kh.getCmnd());
			statement.setString(5, kh.getSdt());
			statement.setString(6, kh.getQuocTich());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n =0;
		try {
			statement = con.prepareStatement("update KhachHang set HoDem=?, Ten=?, CCCD=?, SDT=?, QuocTich=?"+" where MaKhachHang=? ");
			statement.setString(1, kh.getHoDem());
			statement.setString(2, kh.getTen());
			statement.setString(3, kh.getCmnd());
			statement.setString(4, kh.getSdt());
			statement.setString(5, kh.getQuocTich());
			statement.setString(6, kh.getMaKH());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
}
