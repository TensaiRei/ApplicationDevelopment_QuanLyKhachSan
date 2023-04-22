package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVuDat;

public class DAO_DonDatPhong_DichVu {
	public DAO_DonDatPhong_DichVu() {
		
	}
	public static ArrayList<DichVuDat> getDanhSachDichVuDat(int maDonDatCanTim){
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
				int maDonDat = result.getInt("MaDonDat");
				String maDichVu = result.getString("MaDichVu");
				int soLuong = result.getInt("SoLuong");
				DichVuDat tempDichVuDat = new DichVuDat(maDonDat, maDichVu, soLuong);
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
