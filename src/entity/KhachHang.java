package entity;

import java.util.Objects;

public class KhachHang {
	public String maKH;
	public String hoDem;
	public String ten;
	public String cmnd;
	public String sdt;
	public String quocTich;
	
	public KhachHang(String maKH, String hoDem, String ten, String cmnd, String sdt, String quocTich) {
		super();
		setMaKH(maKH);
		setHoDem(hoDem);
		setTen(ten);
		setCmnd(cmnd);
		setSdt(sdt);
		setQuocTich(quocTich);
	}
	public KhachHang(String maKH) {
		this(maKH,"hoDem","ten","cmnd","sdt","quocTich");
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH.trim().equals("")?"maKH":maKH;
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
		return Objects.equals(cmnd, other.cmnd) && Objects.equals(hoDem, other.hoDem)
				&& Objects.equals(maKH, other.maKH) && Objects.equals(quocTich, other.quocTich)
				&& Objects.equals(sdt, other.sdt) && Objects.equals(ten, other.ten);
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoDem=" + hoDem + ", ten=" + ten + ", cmnd=" + cmnd + ", sdt=" + sdt
				+ ", quocTich=" + quocTich + "]";
	}
	
	
}
