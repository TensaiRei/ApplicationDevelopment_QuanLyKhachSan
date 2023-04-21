package entity;

import java.util.Objects;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private double donGia;

	public enum enum_LoaiDV {
		Foods, Drinks, Others
	};

	private enum_LoaiDV loaiDV;

	public DichVu() {
		super();
	}

	public DichVu(String maDichVu, String tenDichVu, double donGia, enum_LoaiDV loaiDV) {
		super();
		setMaDichVu(maDichVu);
		setTenDichVu(tenDichVu);
		setLoaiDV(loaiDV);
		setDonGia(donGia);
	}

	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		if (maDichVu.trim().length() > 0) this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		if (tenDichVu.trim().length() > 0)this.tenDichVu = tenDichVu;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia >= 0) this.donGia = donGia;
	}

	public enum_LoaiDV getLoaiDV() {
		return loaiDV;
	}

	public void setLoaiDV(enum_LoaiDV loaiDV) {
		this.loaiDV = loaiDV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", donGia=" + donGia + ", loaiDV=" + loaiDV
				+ "]";
	}

	
}
