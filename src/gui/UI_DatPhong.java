package gui;

import javax.swing.JPanel;

public class UI_DatPhong extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static UI_DatPhong instance = new UI_DatPhong();
	public static UI_DatPhong getUI_DatPhongInstance() {return instance;}
	
	public UI_DatPhong() {
		createGUI();
	}
	
	private void createGUI() {
		createFrom();
		createTable();
		createOption();
	}
	
	private void createFrom() {
		
	}
	private void createTable() {
		
	}
	private void createOption() {
		
	}
}
