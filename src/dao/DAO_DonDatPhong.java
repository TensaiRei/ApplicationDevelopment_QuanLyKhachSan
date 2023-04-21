package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DonDatPhong;
import entity.DonDatPhong.enum_HinhThucThue;

public class DAO_DonDatPhong {
	public static ArrayList<DonDatPhong> getDanhSachDonDatPhong(){
		ArrayList<DonDatPhong> listKH = new ArrayList<DonDatPhong>();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM DonDatPhong";
			Statement stm = connect.createStatement();
			
			ResultSet result = stm.executeQuery(sql);
			while(result.next()) {
				int maDonDatPhong = result.getInt("MaDonDat");
				int maKhachHang = result.getInt("MaKhachHang");
				String maTiepTan = result.getString("MaTiepTan");
				int soLuongKhach = result.getInt("SoLuongKhach");
				String hinhThucThue = result.getString("HinhThucThue");
				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
				enum_HinhThucThue enumHinhThucThue = null;
				if(hinhThucThue.equals("Theo giờ")) {
					enumHinhThucThue = enum_HinhThucThue.Hours;
				}
				if(hinhThucThue.equals("Theo ngày")) {
					enumHinhThucThue = enum_HinhThucThue.Days;
				}
				DonDatPhong tempDonDatPhong = new DonDatPhong(maDonDatPhong, maKhachHang, maTiepTan, soLuongKhach, enumHinhThucThue, ngayDatPhong);
				listKH.add(tempDonDatPhong);
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
}
