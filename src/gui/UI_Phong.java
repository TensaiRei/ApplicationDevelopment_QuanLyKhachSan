package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI_Phong extends JPanel{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UI_Phong() {
		this.setBackground(Color.red);
		this.add(new JLabel("DON'T MAKE ANYMORE") {
			private static final long serialVersionUID = 1L;
		{setFont(new Font("Arial",Font.BOLD,60));}});
		this.add(new JLabel("Đây là UI Phòng sau khi đăng nhập") {
			private static final long serialVersionUID = 1L;
		{setFont(new Font("Arial",Font.BOLD,12));}});
	}
}
