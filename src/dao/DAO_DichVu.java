package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.DichVu.enum_LoaiDV;

public class DAO_DichVu {
	public DAO_DichVu() {
		
	}
	
	/**
	 * ham lay danh sach tat ca cac dich vu trong database
	 * @return ArrayList
	 */
	public ArrayList<DichVu> getAllDSDichVu() {
		ArrayList<DichVu> listDV = new ArrayList<DichVu>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from DichVu";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maDV = rs.getString("MaDichVu");
				String tenDV = rs.getString("TenDichVu");
				double donGia = rs.getDouble("DonGia");
				String loaiDV = rs.getString("LoaiDichVu");
				
				enum_LoaiDV loaiDichVu = null;
				if (loaiDV.equals("Foods")) {
					loaiDichVu = enum_LoaiDV.Foods;
				}
				if (loaiDV.equals("Drinks")) {
					loaiDichVu = enum_LoaiDV.Drinks;
				}
				if (loaiDV.equals("Others")) {
					loaiDichVu = enum_LoaiDV.Others;
				}
				
				DichVu dv = new DichVu(maDV, tenDV, donGia, loaiDichVu);
				listDV.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDV;
	}
	
	/**
	 * ham lay danh sach cac dich vu thuoc do an
	 * @return ArrayList
	 */
	public ArrayList<DichVu> getDSDichVuTheoThucAn() {
		ArrayList<DichVu> listDV = new ArrayList<DichVu>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from DichVu where LoaiDichVu like 'Foods'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maDV = rs.getString("MaDichVu");
				String tenDV = rs.getString("TenDichVu");
				double donGia = rs.getDouble("DonGia");
				String loaiDV = rs.getString("LoaiDichVu");
				
				enum_LoaiDV loaiDichVu = null;
				if (loaiDV.equals("Foods")) {
					loaiDichVu = enum_LoaiDV.Foods;
				}
				
				DichVu dv = new DichVu(maDV, tenDV, donGia, loaiDichVu);
				listDV.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDV;
	}
	
	/**
	 * ham lay danh sach cac dich vu thuoc do uong
	 * @return ArrayList
	 */
	public ArrayList<DichVu> getDSDichVuTheoDoUong() {
		ArrayList<DichVu> listDV = new ArrayList<DichVu>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from DichVu where LoaiDichVu like 'Drinks'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maDV = rs.getString("MaDichVu");
				String tenDV = rs.getString("TenDichVu");
				double donGia = rs.getDouble("DonGia");
				String loaiDV = rs.getString("LoaiDichVu");
				
				enum_LoaiDV loaiDichVu = null;
				if (loaiDV.equals("Drinks")) {
					loaiDichVu = enum_LoaiDV.Drinks;
				}
				
				DichVu dv = new DichVu(maDV, tenDV, donGia, loaiDichVu);
				listDV.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDV;
	}
	
	/**
	 * ham lay danh sach cac dich vu khac
	 * @return ArrayList
	 */
	public ArrayList<DichVu> getDSDichVuConLai() {
		ArrayList<DichVu> listDV = new ArrayList<DichVu>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from DichVu where LoaiDichVu like 'Others'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maDV = rs.getString("MaDichVu");
				String tenDV = rs.getString("TenDichVu");
				double donGia = rs.getDouble("DonGia");
				String loaiDV = rs.getString("LoaiDichVu");
				
				enum_LoaiDV loaiDichVu = null;
				if (loaiDV.equals("Others")) {
					loaiDichVu = enum_LoaiDV.Others;
				}
				
				DichVu dv = new DichVu(maDV, tenDV, donGia, loaiDichVu);
				listDV.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDV;
	}
}
