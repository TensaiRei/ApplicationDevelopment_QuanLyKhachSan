package gui;

import dao.DAO_Account;

public class Initiate {

	public static void main(String[] args) {
		if(DAO_Account.kiemTraTaiKhoan("ThienPhu", "nguyenthienph") == true) System.out.println("Có tài khoản");
		else System.out.println("Không có tài khoản");
	}

}
