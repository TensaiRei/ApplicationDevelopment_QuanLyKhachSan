package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class UserInterface extends JFrame {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final JPanel UI_Phong = new UI_Phong();
	private static UserInterface instance = new UserInterface();
	
	//Global Variable
	JPanel pnlTask;
	
	JButton btnPhong = new JButton("Phòng");
	JButton btnDonDat = new JButton("Đơn Đặt");
	JButton btnHoaDon = new JButton("Hóa Đơn");
	JButton btnDichVu = new JButton("Dịch Vụ");
	JButton btnTiepTan = new JButton("Tiếp Tân");
	JButton btnThongKe = new JButton("Thống Kê");
	JButton btnDangXuat = new JButton("Đăng Xuất");
	
	ArrayList<JButton> functionalButton = new ArrayList<JButton>();
	
	//
	public UserInterface() {
		//Frame
		this.setTitle("Quản Lý Khách Sạn");
		this.setSize(1150, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#CCCCCC"));
		
		//Title Panel
		JLabel lblTitle = new JLabel();
		lblTitle.setText("Quản Lý Khách Sạn");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
		
		JPanel pnlTitle = new JPanel();
		pnlTitle.setLayout(new FlowLayout());
		pnlTitle.setBackground(Color.decode("#999999"));
		pnlTitle.setPreferredSize(new Dimension(0, 50));
		pnlTitle.add(lblTitle);
		
		//Taskbar Panel
		JPanel pnlTaskbar = new JPanel();
		pnlTaskbar.setPreferredSize(new Dimension(200, 0));
		pnlTaskbar.setLayout(new GridLayout(8,1,0,5));
		pnlTaskbar.setBackground(Color.decode("#666666"));
		
		addFunctionalButton();
		
		setDecorateButton();
		
		pnlTaskbar.add(btnPhong);
		pnlTaskbar.add(btnDonDat);
		pnlTaskbar.add(btnHoaDon);
		pnlTaskbar.add(btnDichVu);
		pnlTaskbar.add(btnTiepTan);
		pnlTaskbar.add(btnThongKe);
		pnlTaskbar.add(new JPanel() {private static final long serialVersionUID = 1L;{setOpaque(false);}});
		pnlTaskbar.add(btnDangXuat);
		
		
		
		//Task Panel
		pnlTask = new JPanel();
		pnlTask.setBackground(Color.decode("#666666"));
			
		JPanel pnlCenter = new JPanel();
		surroundPanel(pnlCenter, 25);
		
		pnlCenter.add(pnlTask, BorderLayout.CENTER);
		
		//Main Component
		this.add(pnlTitle, BorderLayout.NORTH);
		this.add(pnlTaskbar, BorderLayout.EAST);
		this.add(pnlCenter, BorderLayout.CENTER);
		
		//Initial Methods
		showUI(UI_Phong);
		disableFunctionalButton();
	}
	
	public void showUI(JPanel panel) {
		pnlTask.removeAll();
		pnlTask.revalidate();
		pnlTask.repaint();
		pnlTask.setLayout(new BorderLayout());
		pnlTask.add(panel, BorderLayout.CENTER);
		setDecorateButton();
		checkPanelInstance(panel);
	}
	public void checkPanelInstance(JPanel panel) {
		if(panel instanceof UI_Phong) {
			btnPhong.setBackground(Color.decode("#08FF08"));
		}
	}
	public void surroundPanel(JPanel panel, int surroundWidth) {
		panel.setLayout(new BorderLayout());
		
		panel.add(new JPanel() {
			private static final long serialVersionUID = 1L;
			{setPreferredSize(new Dimension(0, surroundWidth));}}, BorderLayout.NORTH);
		panel.add(new JPanel() {
			private static final long serialVersionUID = 1L;
			{setPreferredSize(new Dimension(0, surroundWidth));}}, BorderLayout.SOUTH);
		panel.add(new JPanel() {
			private static final long serialVersionUID = 1L;
			{setPreferredSize(new Dimension(surroundWidth, 0));}}, BorderLayout.WEST);
		panel.add(new JPanel() {
			private static final long serialVersionUID = 1L;
			{setPreferredSize(new Dimension(surroundWidth, 0));}}, BorderLayout.EAST);
	}
	public void setDecorateButton() {
		setDecorateOneButton(btnPhong);
		setDecorateOneButton(btnDonDat);
		setDecorateOneButton(btnHoaDon);
		setDecorateOneButton(btnDichVu);
		setDecorateOneButton(btnTiepTan);
		setDecorateOneButton(btnThongKe);
		setDecorateOneButton(btnDangXuat);
		for(JButton thisButton : functionalButton) {
			thisButton.setForeground(Color.decode("#FFFFFF"));
			thisButton.setBackground(Color.decode("#8080ff"));
		}
		btnDangXuat.setBackground(Color.decode("#FF8080"));
	}
	public void setDecorateOneButton(JButton button) {
		button.setPreferredSize(new Dimension(0, 50));
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createBevelBorder(
				BevelBorder.RAISED, Color.white, Color.black));
	}
	public void enableFunctionalButton() {
		for(JButton thisButton : functionalButton) {
			thisButton.setEnabled(true);
		}
	}
	public void disableFunctionalButton() {
		for(JButton thisButton : functionalButton) {
			thisButton.setEnabled(false);
		}
	}
	public void addFunctionalButton() {
		functionalButton.add(btnPhong);
		functionalButton.add(btnDonDat);
		functionalButton.add(btnHoaDon);
		functionalButton.add(btnDichVu);
		functionalButton.add(btnTiepTan);
		functionalButton.add(btnThongKe);
		
	}
	public static UserInterface getUserInterfaceInstance() {return instance;}
}
