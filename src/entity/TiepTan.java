package entity;

public class TiepTan {
	private String maTiepTan;
	private String hoDem;
	private String ten;
	private String cccd;
	private String sdt;
	private String maTaiKhoan;
	//
	public String getMaTiepTan() {
		return maTiepTan;
	}
	private void setMaTiepTan(String maTiepTan) {
		this.maTiepTan = maTiepTan;
	}
	public String getHoDem() {
		return hoDem;
	}
	private void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	private void setTen(String ten) {
		this.ten = ten;
	}
	public String getCccd() {
		return cccd;
	}
	private void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getSdt() {
		return sdt;
	}
	private void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}
	private void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	//
	public TiepTan(String maTiepTan, String hoDem, String ten, String cccd, String sdt, String maTaiKhoan) {
		super();
		this.setMaTiepTan(maTiepTan);
		this.setHoDem(hoDem);
		this.setTen(ten);
		this.setCccd(cccd);
		this.setSdt(sdt);
		this.setMaTaiKhoan(maTaiKhoan);
	}
	public TiepTan() {
		super();
		this.setMaTiepTan("");
		this.setHoDem("");
		this.setTen("");
		this.setCccd("");
		this.setSdt("");
		this.setMaTaiKhoan("");
	}
	//
	@Override
	public String toString() {
		return "TiepTan [maTiepTan=" + maTiepTan + ", hoDem=" + hoDem + ", ten=" + ten + ", cccd=" + cccd + ", sdt="
				+ sdt + ", maTaiKhoan=" + maTaiKhoan + "]";
	}
	//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTiepTan == null) ? 0 : maTiepTan.hashCode());
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
		TiepTan other = (TiepTan) obj;
		if (maTiepTan == null) {
			if (other.maTiepTan != null)
				return false;
		} else if (!maTiepTan.equals(other.maTiepTan))
			return false;
		return true;
	}
	
}
