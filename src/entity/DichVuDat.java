package entity;

public class DichVuDat {
	private int id;
	private int maDonDat;
	private String maDichVu;
	private String maPhong;
	private int soLuong;
	//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaDonDat() {
		return maDonDat;
	}
	public void setMaDonDat(int maDonDat) {
		this.maDonDat = maDonDat;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	//
	public DichVuDat(int id, int maDonDat, String maDichVu, String maPhong, int soLuong) {
		super();
		setId(id);
		setMaDonDat(maDonDat);
		setMaDichVu(maDichVu);
		setMaPhong(maPhong);
		setSoLuong(soLuong);
	}
	public DichVuDat() {
		super();
	}
	//
	@Override
	public String toString() {
		return "DichVuDat [id=" + id + ", maDonDat=" + maDonDat + ", maDichVu=" + maDichVu + ", maPhong=" + maPhong
				+ ", soLuong=" + soLuong + "]";
	}
}
