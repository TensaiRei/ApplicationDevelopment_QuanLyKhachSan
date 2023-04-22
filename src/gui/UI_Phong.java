package gui;

import javax.swing.JPanel;

public class UI_Phong extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UI_Phong instance = new UI_Phong();
	//
	public static UI_Phong getUI_PhongInstance() {
		instance = new UI_Phong();
		return instance;
	}
	//
	public UI_Phong() {
		
	}
}
