package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVuDat;

public class DAO_DonDatPhong_DichVu {
	public DAO_DonDatPhong_DichVu() {}
	public static ArrayList<DichVuDat> getDanhSachDichVuDatTheoMaDonDat(int maDonDatCanTim){
		ArrayList<DichVuDat> listDVD = new ArrayList<DichVuDat>();
		try {
			ConnectDB.getInstance().connectDatabase();
			Connection connect = ConnectDB.getConnection();
			String sql = "SELECT * "
					+ "FROM DonDatPhong_DichVu "
					+ "WHERE MaDonDat = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setInt(1, maDonDatCanTim);
			ResultSet result = prpStm.executeQuery();
			int rowCount = 0;
			while(result.next()) {
				int id = result.getInt("ID");
				int maDonDat = result.getInt("MaDonDat");
				String maDichVu = result.getString("MaDichVu");
				String maPhong = result.getString("MaPhong");
				int soLuong = result.getInt("SoLuong");
				DichVuDat tempDichVuDat = new DichVuDat(id, maDonDat, maDichVu, maPhong, soLuong);
				listDVD.add(tempDichVuDat);
				rowCount++;
			}
			if(rowCount == 0) return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listDVD;
	}
	public static ArrayList<DichVuDat> getDanhSachDichVuDatTheoMaDonDatMaPhong(int maDonDatCanTim, String maPhongCanTim){
		ArrayList<DichVuDat> listDVD = new ArrayList<DichVuDat>();
		try {
			ConnectDB.getInstance().connectDatabase();
			Connection connect = ConnectDB.getConnection();
			String sql = "SELECT * "
					+ "FROM DonDatPhong_DichVu "
					+ "WHERE MaDonDat = ? AND MaPhong = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setInt(1, maDonDatCanTim);
			prpStm.setString(2, maPhongCanTim);
			ResultSet result = prpStm.executeQuery();
			int rowCount = 0;
			while(result.next()) {
				int id = result.getInt("ID");
				int maDonDat = result.getInt("MaDonDat");
				String maDichVu = result.getString("MaDichVu");
				String maPhong = result.getString("MaPhong");
				int soLuong = result.getInt("SoLuong");
				DichVuDat tempDichVuDat = new DichVuDat(id, maDonDat, maDichVu, maPhong, soLuong);
				listDVD.add(tempDichVuDat);
				rowCount++;
			}
			if(rowCount == 0) return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listDVD;
	}
}
