package entity;

import java.sql.Timestamp;

public class HoaDon {
	private int maHoaDon;
	private int maDonDat;
	private double phuPhi;
	private double tongThanhTien;
	private Timestamp ngayDatPhong;
	private Timestamp ngayTraPhong;
	//
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getMaDonDat() {
		return maDonDat;
	}
	public void setMaDonDat(int maDonDat) {
		this.maDonDat = maDonDat;
	}
	public double getPhuPhi() {
		return phuPhi;
	}
	public void setPhuPhi(double phuPhi) {
		this.phuPhi = phuPhi;
	}
	public double getTongThanhTien() {
		return tongThanhTien;
	}
	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}
	public Timestamp getNgayDatPhong() {
		return ngayDatPhong;
	}
	public void setNgayDatPhong(Timestamp ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}
	public Timestamp getNgayTraPhong() {
		return ngayTraPhong;
	}
	public void setNgayTraPhong(Timestamp ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}
	//
	public HoaDon(int maHoaDon, int maDonDat, double phuPhi, double tongThanhTien, Timestamp ngayDatPhong,
			Timestamp ngayTraPhong) {
		super();
		setMaHoaDon(maHoaDon);
		setMaDonDat(maDonDat);
		setPhuPhi(phuPhi);
		setTongThanhTien(tongThanhTien);
		setNgayDatPhong(ngayDatPhong);
		setNgayTraPhong(ngayTraPhong);
	}
	public HoaDon() {
		super();
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maDonDat=" + maDonDat + ", phuPhi=" + phuPhi + ", tongThanhTien="
				+ tongThanhTien + ", ngayDatPhong=" + ngayDatPhong + ", ngayTraPhong=" + ngayTraPhong + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maHoaDon;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (maHoaDon != other.maHoaDon)
			return false;
		return true;
	}
	
}
