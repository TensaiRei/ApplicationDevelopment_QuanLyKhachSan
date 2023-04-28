package entity;

public class PhongDat {
	private int ID;
	private DonDatPhong donDatPhong;
	private Phong phong;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public DonDatPhong getDonDatPhong() {
		return donDatPhong;
	}

	public void setDonDatPhong(DonDatPhong donDatPhong) {
		this.donDatPhong = donDatPhong;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public PhongDat(int iD, DonDatPhong donDatPhong, Phong phong) {
		super();
		ID = iD;
		this.donDatPhong = donDatPhong;
		this.phong = phong;
	}

}
