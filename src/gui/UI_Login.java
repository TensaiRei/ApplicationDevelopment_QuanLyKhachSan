package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DAO_Account;

public class UI_Login extends JPanel implements ActionListener{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JButton btnLogin = new JButton("  Login");
	private JButton btnReset = new JButton("  Reset");

	public UI_Login() {
		//Panel
		JFrame frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setMinimumSize(new Dimension(620, 500));
		frmLogin.setMinimumSize(new Dimension(840, 400));
		frmLogin.setTitle("Paradise Hotel'Login");
		frmLogin.setBounds(100, 100, 640, 368);
		frmLogin.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 410, 360);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSideBackgroundLabel = new JLabel("");
		lblSideBackgroundLabel.setBounds(0, 0, 410, 360);
		lblSideBackgroundLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblSideBackgroundLabel.setAutoscrolls(true);
		lblSideBackgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSideBackgroundLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSideBackgroundLabel.setIcon(new ImageIcon("img\\hotel_2_410x360.jpg"));
		panel_1.add(lblSideBackgroundLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(410, 0, 410, 360);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 130, 80, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Paradise Hotel");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(55, 20, 300, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 190, 80, 40);
		panel.add(lblNewLabel_2);
		


		btnLogin.setIcon(new ImageIcon("img\\check_20x20_1_16x16.png"));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(90, 280, 100, 40);
		panel.add(btnLogin);
		

		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setIcon(new ImageIcon("img\\refresh.png"));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(230, 280, 100, 40);
		panel.add(btnReset);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textUsername.setBounds(110, 130, 280, 40);
		panel.add(textUsername);
		textUsername.setColumns(20);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(110, 190, 280, 40);
		panel.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(170, 70, 70, 20);
		panel.add(lblNewLabel_3);
		
		//
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
		frmLogin.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnLogin) {
			String username = textUsername.getText();
			char[] passwordValue = passwordField.getPassword();
			String password = String.valueOf(passwordValue);
			
			if(DAO_Account.kiemTraTaiKhoan(username, password)) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
					UserInterface ui = UserInterface.getUserInterfaceInstance();
					ui.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu bị sai. Hãy nhập lại!");
				passwordField.selectAll();
				passwordField.requestFocus();
			}
			
		}
		if(o == btnReset) {
			textUsername.setText("");
			passwordField.setText("");
		}	
	}
}
