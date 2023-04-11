package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DAO_Account;

public class UI_Login extends JPanel implements ActionListener{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lblUser = new JLabel("Tên Đăng Nhập: ");
	JTextField txtUser = new JTextField();
	JLabel lblPass = new JLabel("Mật khẩu: ");
	JPasswordField txtPass = new JPasswordField();
	
	JButton btnLogin = new JButton("Login");
	JButton btnReset = new JButton("Reset");

	public UI_Login() {
		//Panel
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.decode("#AAAAAA"));
		
		//Panel Username
		JPanel pnlUsername = new JPanel();
		pnlUsername.setLayout(new FlowLayout());
		txtUser.setPreferredSize(new Dimension(200, txtUser.getPreferredSize().height));
		pnlUsername.add(lblUser);
		pnlUsername.add(txtUser);
		
		//Panel Password
		JPanel pnlPassword = new JPanel();
		lblPass.setPreferredSize(lblUser.getPreferredSize());
		pnlPassword.setLayout(new FlowLayout());
		txtPass.setPreferredSize(new Dimension(200, txtUser.getPreferredSize().height));
		pnlPassword.add(lblPass);
		pnlPassword.add(txtPass);
		
		//Panel Button
		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout());
		pnlButton.add(btnLogin);
		pnlButton.add(btnReset);

		//
		JPanel pnlAIO = new JPanel();
		pnlAIO.setLayout(new BoxLayout(pnlAIO, BoxLayout.Y_AXIS));
		pnlAIO.add(pnlUsername);
		pnlAIO.add(pnlPassword);
		pnlAIO.add(pnlButton);
		
		//Add Component
		add(Box.createVerticalGlue());
		add(pnlAIO);
		add(Box.createVerticalGlue());
		
		//
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnLogin) {
			String username = txtUser.getText();
			char[] passwordValue = txtPass.getPassword();
			String password = String.valueOf(passwordValue);
			if(DAO_Account.kiemTraTaiKhoan(username, password) == true) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
				UserInterface ui = UserInterface.getUserInterfaceInstance();
				ui.enableFunctionalButton();
				ui.showUI(new UI_Phong());
			}
			else
				JOptionPane.showMessageDialog(this, "Kiểm tra lại tên đăng nhập và mật khẩu");
		}
		if(o == btnReset) {
			txtUser.setText("");
			txtPass.setText("");
		}
			
		
	}
}
