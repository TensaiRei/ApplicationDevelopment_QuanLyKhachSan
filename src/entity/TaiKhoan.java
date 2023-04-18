package entity;

public class TaiKhoan {
	private String maTaiKhoan;
	private String tenTaiKhoan;
	//
	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}
	private void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	private void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	//
	public TaiKhoan(String maTaiKhoan, String tenTaiKhoan) {
		super();
		this.setMaTaiKhoan(maTaiKhoan);
		this.setTenTaiKhoan(tenTaiKhoan);
	}
	//
	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", tenTaiKhoan=" + tenTaiKhoan + "]";
	}
	
}
