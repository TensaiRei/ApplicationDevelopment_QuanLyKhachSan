package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DonDatPhong;
import entity.DonDatPhong.enum_HinhThucThue;
import entity.DonDatPhong.enum_TrangThaiThanhToan;

public class DAO_DonDatPhong {
	public DAO_DonDatPhong() {
	}

	public static ArrayList<DonDatPhong> getDanhSachDonDatPhong() {
		ArrayList<DonDatPhong> listKH = new ArrayList<DonDatPhong>();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = "" + "SELECT * " + "FROM DonDatPhong";
			Statement stm = connect.createStatement();
			ResultSet result = stm.executeQuery(sql);
			int rowCount = 0;
			while (result.next()) {
				int maDonDatPhong = result.getInt("MaDonDat");
				int maKhachHang = result.getInt("MaKhachHang");
				String maTiepTan = result.getString("MaTiepTan");
				int soLuongKhach = result.getInt("SoLuongKhach");
				String hinhThucThue = result.getString("HinhThucThue");
				String trangThaiThanhToan = result.getString("TrangThaiThanhToan");
				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
				enum_HinhThucThue enumHinhThucThue = null;
				if (hinhThucThue.equals("Theo giờ")) {
					enumHinhThucThue = enum_HinhThucThue.Hours;
				}
				if (hinhThucThue.equals("Theo ngày")) {
					enumHinhThucThue = enum_HinhThucThue.Days;
				}
				enum_TrangThaiThanhToan enumTrangThaiThanhToan = null;
				if (trangThaiThanhToan.equals("Chưa thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Yet;
				}
				if (trangThaiThanhToan.equals("Đã thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Paid;
				}
				DonDatPhong tempDonDatPhong = new DonDatPhong(maDonDatPhong, maKhachHang, maTiepTan, soLuongKhach,
						enumHinhThucThue, enumTrangThaiThanhToan, ngayDatPhong);
				listKH.add(tempDonDatPhong);
				rowCount++;
			}
			if (rowCount == 0)
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		return listKH;
	}

	public static DonDatPhong getDonDatPhongTheoMaDonDat(int maDonDatCanTim) {
		DonDatPhong tempDonDatPhong = new DonDatPhong();
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		try {
			String sql = "SELECT * " + "FROM DonDatPhong " + "WHERE MaDonDat = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setInt(1, maDonDatCanTim);
			ResultSet result = prpStm.executeQuery();
			while (result.next()) {
				int maDonDat = result.getInt("MaDonDat");
				int maKhachHang = result.getInt("MaKhachHang");
				String maTiepTan = result.getString("MaTiepTan");
				int soLuongKhach = result.getInt("SoLuongKhach");
				String hinhThucThue = result.getString("HinhThucThue");
				String trangThaiThanhToan = result.getString("TrangThaiThanhToan");
				Timestamp ngayDatPhong = result.getTimestamp("NgayDatPhong");
				enum_HinhThucThue enumHinhThucThue = null;
				if (hinhThucThue.equals("Theo giờ")) {
					enumHinhThucThue = enum_HinhThucThue.Hours;
				} else if (hinhThucThue.equals("Theo ngày")) {
					enumHinhThucThue = enum_HinhThucThue.Days;
				}
				enum_TrangThaiThanhToan enumTrangThaiThanhToan = null;
				if (trangThaiThanhToan.equals("Chưa thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Yet;
				} else if (trangThaiThanhToan.equals("Đã thanh toán")) {
					enumTrangThaiThanhToan = enum_TrangThaiThanhToan.Paid;
				}
				tempDonDatPhong = new DonDatPhong(maDonDat, maKhachHang, maTiepTan, soLuongKhach, enumHinhThucThue,
						enumTrangThaiThanhToan, ngayDatPhong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
		System.out.println(tempDonDatPhong.toString());
		return tempDonDatPhong;
	}

	public static boolean createDonDatPhong(DonDatPhong donDatPhong) {
		ConnectDB.getInstance().connectDatabase();
		Connection connection = ConnectDB.getConnection();
		int n = 0;
		try {
			String sql = "INSERT INTO [dbo].[DonDatPhong]"
					+ " ([MaKhachHang], [MaTiepTan], [SoLuongKhach], [HinhThucThue], [TrangThaiThanhToan], [NgayDatPhong]) "
					+ "VALUES(?,?,?,?,?,CAST(? AS DateTime))";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, donDatPhong.getMaKhachHang() + "");
			statement.setString(2, donDatPhong.getMaTiepTan());
			statement.setString(3, donDatPhong.getSoLuongKhach() + "");
			statement.setString(4, donDatPhong.getHinhThucThue() == enum_HinhThucThue.Days ? "Theo ngày" : "Theo giờ");
			statement.setString(5, "Chưa thanh toán");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = sdf.format(donDatPhong.getNgayDatPhong());
			statement.setString(6, formattedDate);
			n = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return n>0;
	}

	public static int getNewDonDat() {
		ConnectDB.getInstance().connectDatabase();
		int maDonDat=0;
		try {
			Connection connection = ConnectDB.getConnection();
			String sql = "SELECT TOP 1 MaDonDat "
					+ "FROM [dbo].[DonDatPhong] "
					+ "ORDER BY MaDonDat DESC";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				maDonDat = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return maDonDat;
	}
	
	public static void setTrangThaiThanhToanMaDonDat(int maDonDatCanSet, String trangThaiThanhToanCanSet) {
		ConnectDB.getInstance().connectDatabase();
		Connection connect = ConnectDB.getConnection();
		
		try {
			String sql = ""
					+ "UPDATE DonDatPhong "
					+ "SET TrangThaiThanhToan = ? "
					+ "WHERE MaDonDat = ?";
			PreparedStatement prpStm = connect.prepareStatement(sql);
			prpStm.setString(1, trangThaiThanhToanCanSet);
			prpStm.setInt(2, maDonDatCanSet);
			prpStm.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectDB.getInstance().disconnectDatabase();
		}
	}
}
