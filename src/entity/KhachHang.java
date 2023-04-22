package entity;

public class KhachHang {
	private int maKhachHang;
	private String hoDem;
	private String ten;
	private String cccd;
	private String sdt;
	private String quocTich;
	//
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}
	//
	public KhachHang(int maKhachHang, String hoDem, String ten, String cccd, String sdt, String quocTich) {
		super();
		setMaKhachHang(maKhachHang);
		setHoDem(hoDem);
		setTen(ten);
		setCccd(cccd);
		setSdt(sdt);
		setQuocTich(quocTich);
	}
	public KhachHang() {
		super();
	}
	//
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoDem=" + hoDem + ", ten=" + ten + ", cccd=" + cccd
				+ ", sdt=" + sdt + ", quocTich=" + quocTich + "]";
	}
	//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maKhachHang;
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
		KhachHang other = (KhachHang) obj;
		if (maKhachHang != other.maKhachHang)
			return false;
		return true;
	}
	
}
