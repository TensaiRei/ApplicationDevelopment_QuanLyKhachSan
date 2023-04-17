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
	private static UI_Phong instance = new UI_Phong();
	
	//
	public UI_Phong() {
		this.setBackground(Color.decode("#666666"));
		this.add(new JLabel("Đây là UI Phòng sau khi đăng nhập") {
			private static final long serialVersionUID = 1L;
		{setFont(new Font("Arial",Font.BOLD,12));}});
	}
	
	public static UI_Phong getUI_PhongInstance() {return instance;}
}
