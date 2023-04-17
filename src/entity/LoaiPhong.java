package entity;

import java.util.Objects;

public class LoaiPhong {
	private String maloaiPhong;
	private String tenLoaiPhong;
	private double donGia;

	public String getMaloaiPhong() {
		return maloaiPhong;
	}

	public void setMaloaiPhong(String maloaiPhong) {
		this.maloaiPhong = maloaiPhong.trim().equals("") ? "---" : maloaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong.trim().equals("") ? "---" : tenLoaiPhong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia < 0 ? 0 : donGia;
	}

	public LoaiPhong(String maloaiPhong, String tenLoaiPhong, double donGia) {
		setMaloaiPhong(maloaiPhong);
		setTenLoaiPhong(tenLoaiPhong);
		setDonGia(donGia);
	}

	public LoaiPhong(String maloaiPhong) {
		setMaloaiPhong(maloaiPhong);
		setTenLoaiPhong("");
		setDonGia(0);
	}

	public LoaiPhong() {
		setMaloaiPhong("");
		setTenLoaiPhong("");
		setDonGia(0);
	}

	@Override
	public String toString() {
		return maloaiPhong + ";" + tenLoaiPhong + ";" + donGia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maloaiPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maloaiPhong, other.maloaiPhong);
	}
	
	
	
}
