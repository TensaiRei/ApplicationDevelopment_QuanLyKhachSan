package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phong;
import entity.Phong.enum_TinhTrang;

public class DAO_Phong {
	public DAO_Phong() {
		
	}
	public static ArrayList<Phong> getDanhSachPhong(){
		ArrayList<Phong> listP = new ArrayList<Phong>();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM Phong";
			Statement stm = connect.createStatement();
			
			ResultSet result = stm.executeQuery(sql);
			while(result.next()) {
				String maPhong = result.getString("MaPhong");
				int soPhong = result.getInt("SoPhong");
				int soTang = result.getInt("SoTang");
				String tenPhong = result.getString("TenPhong");
				
				enum_TinhTrang enumtinhTrang = null;
				String tinhTrang = result.getString("TinhTrang");
				if(tinhTrang.equals("Available"))
					enumtinhTrang = enum_TinhTrang.Available;
				if(tinhTrang.equals("Booked"))
					enumtinhTrang = enum_TinhTrang.Booked;
				if(tinhTrang.equals("Not Available"))
					enumtinhTrang = enum_TinhTrang.Not_Available;
				
				String maLoaiPhong = result.getString("MaLoaiPhong");
				
				Phong tempPhong = new Phong(maPhong, soPhong, soTang, tenPhong, enumtinhTrang, DAO_LoaiPhong.getLoaiPhongTheoMaLoaiPhong(maLoaiPhong));
				
				listP.add(tempPhong);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listP;
	}
	public static ArrayList<Phong> getDanhSachPhongDat(ArrayList<String> listMaPhong){
		ArrayList<Phong> listPhong = new ArrayList<Phong>();
		ArrayList<Phong> listPhongFull = getDanhSachPhong();
		
		for(Phong thisPhong : listPhongFull) {
			for(String thisMaPhong : listMaPhong) {
				if(thisMaPhong.equals(thisPhong.getMaPhong()))
					listPhong.add(thisPhong);
			}
		}
		return listPhong;
	}
}
