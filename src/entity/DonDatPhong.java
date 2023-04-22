package entity;

import java.sql.Timestamp;

public class DonDatPhong {
	private int maDonDat;
	private int maKhachHang;
	private String maTiepTan;
	private int soLuongKhach;
	public enum enum_HinhThucThue{
		Hours, Days
	}
	private enum_HinhThucThue hinhThucThue;
	public enum enum_TrangThaiThanhToan{
		Yet, Paid
	}
	private enum_TrangThaiThanhToan trangThaiThanhToan;
	private Timestamp ngayDatPhong;
	//
	public int getMaDonDat() {
		return maDonDat;
	}
	public void setMaDonDat(int maDonDat) {
		this.maDonDat = maDonDat;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getMaTiepTan() {
		return maTiepTan;
	}
	public void setMaTiepTan(String maTiepTan) {
		this.maTiepTan = maTiepTan;
	}
	public int getSoLuongKhach() {
		return soLuongKhach;
	}
	public void setSoLuongKhach(int soLuongKhach) {
		this.soLuongKhach = soLuongKhach;
	}
	public enum_HinhThucThue getHinhThucThue() {
		return hinhThucThue;
	}
	public void setHinhThucThue(enum_HinhThucThue hinhThucThue) {
		this.hinhThucThue = hinhThucThue;
	}
	public enum_TrangThaiThanhToan getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}
	public void setTrangThaiThanhToan(enum_TrangThaiThanhToan trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}
	public Timestamp getNgayDatPhong() {
		return ngayDatPhong;
	}
	public void setNgayDatPhong(Timestamp ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}
	//
	public DonDatPhong(int maDonDat, int maKhachHang, String maTiepTan, int soLuongKhach,
			enum_HinhThucThue hinhThucThue, enum_TrangThaiThanhToan trangThaiThanhToan, Timestamp ngayDatPhong) {
		super();
		setMaDonDat(maDonDat);
		setMaKhachHang(maKhachHang);
		setMaTiepTan(maTiepTan);
		setSoLuongKhach(soLuongKhach);
		setHinhThucThue(hinhThucThue);
		setTrangThaiThanhToan(trangThaiThanhToan);
		setNgayDatPhong(ngayDatPhong);
	}
	public DonDatPhong() {
		super();
	}
	//
	@Override
	public String toString() {
		return "DonDatPhong [maDonDat=" + maDonDat + ", maKhachHang=" + maKhachHang + ", maTiepTan=" + maTiepTan
				+ ", soLuongKhach=" + soLuongKhach + ", hinhThucThue=" + hinhThucThue + ", trangThaiThanhToan="
				+ trangThaiThanhToan + ", ngayDatPhong=" + ngayDatPhong + "]";
	}
	//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maDonDat;
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
		DonDatPhong other = (DonDatPhong) obj;
		if (maDonDat != other.maDonDat)
			return false;
		return true;
	}
	
}
