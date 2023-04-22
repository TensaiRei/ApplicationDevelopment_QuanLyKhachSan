package entity;

public class DichVuDat {
	private int MaDonDat;
	private String MaDichVu;
	private int soLuong;
	//
	public DichVuDat(int maDonDat, String maDichVu, int soLuong) {
		super();
		setMaDonDat(maDonDat);
		setMaDichVu(maDichVu);
		setSoLuong(soLuong);
	}
	public DichVuDat() {
		super();
	}
	//
	public int getMaDonDat() {
		return MaDonDat;
	}
	public void setMaDonDat(int maDonDat) {
		MaDonDat = maDonDat;
	}
	public String getMaDichVu() {
		return MaDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		MaDichVu = maDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "DichVuDat [MaDonDat=" + MaDonDat + ", MaDichVu=" + MaDichVu + ", soLuong=" + soLuong + "]";
	}
}
