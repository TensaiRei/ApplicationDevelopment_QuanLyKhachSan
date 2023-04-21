package entity;

import java.util.Objects;

public class Phong {
	private String maPhong;
	private int soPhong;
	private int soTang;
	private String tenPhong;
	public enum enum_TinhTrang{
		Available, Booked, Not_Available
	}
	private enum_TinhTrang tinhTrang;
	private LoaiPhong loaiPhong;
	//
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong.trim().equals("")?"-----":maPhong;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong<0?0:soPhong;
	}

	public int getSoTang() {
		return soTang;
	}

	public void setSoTang(int soTang) {
		this.soTang = soTang<0?0:soTang;
	}

	public String getTenPhong() {
		return tenPhong.trim().equals("")?"-----":maPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public enum_TinhTrang getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(enum_TinhTrang tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		if(loaiPhong == null)
			loaiPhong = new LoaiPhong();
		this.loaiPhong = loaiPhong;
	}
	
	public Phong(String maPhong, int soPhong, int soTang, String tenPhong, enum_TinhTrang tinhTrang, LoaiPhong loaiPhong) {
		setMaPhong(maPhong);
		setSoPhong(soPhong);
		setSoTang(soTang);
		setTenPhong(tenPhong);
		setTinhTrang(tinhTrang);
		setLoaiPhong(loaiPhong);
	}
	
	public Phong(String maPhong) {
		setMaPhong(maPhong);
		setSoPhong(0);
		setSoTang(0);
		setTenPhong("");
		setTinhTrang(null);
		setLoaiPhong(null);
	}
	public Phong() {
		setMaPhong("");
		setSoPhong(0);
		setSoTang(0);
		setTenPhong("");
		setTinhTrang(null);
		setLoaiPhong(null);
	}
	@Override
	public String toString() {
		return maPhong + ";" + soPhong + ";" + soTang + ";" + tenPhong
				+ ";" + tinhTrang + ";" + loaiPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
}
