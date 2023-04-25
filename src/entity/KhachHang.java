package entity;

import java.util.Objects;

public class KhachHang {
	public int maKH;
	public String hoDem;
	public String ten;
	public String cmnd;
	public String sdt;
	public String quocTich;
	
	public KhachHang(int maKH, String hoDem, String ten, String cmnd, String sdt, String quocTich) {
		super();
		setMaKH(maKH);
		setHoDem(hoDem);
		setTen(ten);
		setCmnd(cmnd);
		setSdt(sdt);
		setQuocTich(quocTich);
	}
	public KhachHang(int maKH) {
		this(maKH,"hoDem","ten","cmnd","sdt","quocTich");
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH<=0?0:maKH;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem.trim().equals("")?"hodem":hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten.trim().equals("")?"ten":ten;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd.trim().equals("")?"cmnd":cmnd;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt.trim().equals("")?"sdt":sdt;
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich.trim().equals("")?"quocTich":quocTich;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cmnd, hoDem, maKH, quocTich, sdt, ten);
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
		return Objects.equals(cmnd, other.cmnd) && Objects.equals(hoDem, other.hoDem) && maKH == other.maKH
				&& Objects.equals(quocTich, other.quocTich) && Objects.equals(sdt, other.sdt)
				&& Objects.equals(ten, other.ten);
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoDem=" + hoDem + ", ten=" + ten + ", cmnd=" + cmnd + ", sdt=" + sdt
				+ ", quocTich=" + quocTich + "]";
	}
	
	
	
	
}
