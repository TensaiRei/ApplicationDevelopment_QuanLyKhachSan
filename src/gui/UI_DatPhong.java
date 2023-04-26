package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAO_LoaiPhong;
import entity.LoaiPhong;
import entity.Phong;

public class UI_DatPhong extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static UI_DatPhong instance = new UI_DatPhong();

	public static UI_DatPhong getUI_DatPhongInstance() {
		return instance;
	}

	private JLabel lblHo;
	private JLabel lblTen;
	private JLabel lblCCCD;
	private JLabel lblSDT;
	private JLabel lblQuocTich;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtCCCD;
	private JTextField txtSDT;
	private JTextField txtQuocTich;
	private JLabel lblMaPhong;
	private JTextField txtMaPhong;
	private JLabel lblTenPhong;
	private JTextField txtTenPhong;
	private JLabel lblSoPhong;
	private JTextField txtSoPhong;
	private JLabel lblSoTang;
	private JTextField txtSoTang;
	private JLabel lblLoaiPhong;
	private JTextField txtLoaiPhong;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnDat;
	private static DefaultTableModel modelAvai;
	private JTable tableAvai;
	private static DefaultTableModel modelBook;
	private JTable tableBook;

	private static ArrayList<Phong> dsPhongDaThem = new ArrayList<Phong>();
	private static ArrayList<Phong> dsPhongsCoTheThem = new ArrayList<Phong>();

	public UI_DatPhong() {
		createGUI();

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnDat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnThem))
			handlerBtnThem();
		else if (object.equals(btnXoa))
			handlerBtnXoa();
		else if (object.equals(btnDat))
			handlerBtnDat();
	}

	private void handlerBtnThem() {

	}

	private void handlerBtnXoa() {

	}

	private void handlerBtnDat() {
		if (validateForm()) {
			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
		}
	}

//  validate
	private boolean validateForm() {
		if (!validateHo())
			return false;
		if (!validateTen())
			return false;
		if (!validateCCCD())
			return false;
		if (!validateSDT())
			return false;
		if (!validateQuocTich())
			return false;
		return true;
	}

	private boolean validateHo() {
		if (txtHo.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được bỏ trống họ");
			txtHo.requestFocus();
			return false;
		}  else if(!txtHo.getText().matches("([a-zA-Z\\p{IsLatin} ]*?)*")) {
			JOptionPane.showMessageDialog(this, "Họ chỉ gồm chữ thường và cách nhau 1 khoảng trắng");
			txtHo.requestFocus();
			return false;
		}
		return true;
	}

	private boolean validateTen() {
		if (txtTen.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được bỏ trống tên");
			txtTen.requestFocus();
			return false;
		} else if(!txtTen.getText().matches("([a-zA-Z\\p{IsLatin} ]*?)*")) {
			JOptionPane.showMessageDialog(this, "Tên chỉ gồm chữ thường và cách nhau 1 khoảng trắng");
			txtTen.requestFocus();
			return false;
		}
		return true;
	}

	private boolean validateCCCD() {
		if (txtCCCD.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được bỏ trống CCCD");
			txtCCCD.requestFocus();
			return false;
		}  else if(!txtCCCD.getText().matches("^0\\d{11}$")) {
			JOptionPane.showMessageDialog(this, "Gồm 12 chữ số và bắt đầu là số 0");
			txtCCCD.requestFocus();
			return false;
		}
		return true;
	}

	private boolean validateSDT() {
		if (txtSDT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được bỏ trống số điện thoại");
			txtSDT.requestFocus();
			return false;
		}   else if(!txtSDT.getText().matches("^0\\d{9}$")) {
			JOptionPane.showMessageDialog(this, "Gồm 10 chữ số và bắt đầu là số 0");
			txtSDT.requestFocus();
			return false;
		}
		return true;
	}

	private boolean validateQuocTich() {
		if (txtQuocTich.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được bỏ trống quốc tịch");
			txtQuocTich.requestFocus();
			return false;
		} else if(!txtQuocTich.getText().matches("([a-zA-Z\\p{IsLatin} ]*?)*")) {
			JOptionPane.showMessageDialog(this, "Quốc tịch chỉ gồm chữ thường và cách nhau 1 khoảng trắng");
			txtQuocTich.requestFocus();
			return false;
		}
		return true;
	}

//  load data
	public static void addListRoom(ArrayList<Phong> dsPhongDat) {
		dsPhongDaThem = dsPhongDat;

		for (Phong phong : dsPhongDaThem) {
			String tinhTrang;
			LoaiPhong loaiPhong = DAO_LoaiPhong.getLoaiPhongTheoMaLoaiPhong(phong.getLoaiPhong().getMaloaiPhong());
			modelBook.addRow(
					new String[] { phong.getMaPhong(), phong.getTenPhong(), loaiPhong.getTenLoaiPhong()});
		}
	}
	
	public String createKhachHang() {
//		String maKhachHang = 
	}

//	create GUI
	private void createGUI() {
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		add(top, BorderLayout.NORTH);
		add(bottom, BorderLayout.SOUTH);

		top.setDoubleBuffered(false);
		top.setLayout(new java.awt.BorderLayout(3, 3));

		createTitle(top);
		createFromUser(top);
		createInfoRoom(top);

		createRoomTable(bottom);
		createOption(bottom);
		createListRoom(bottom);
	}

	private void createTitle(JPanel main) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
		panel.setPreferredSize(new Dimension(940, 35));
		panel.setLayout(new GridBagLayout());

		JLabel lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lblTitle.setText("Đặt phòng");
		panel.add(lblTitle, new GridBagConstraints());

		main.add(panel, BorderLayout.NORTH);
	}

	private void createFromUser(JPanel main) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)),
				"Chi tiết phòng"));
		panel.setPreferredSize(new Dimension(470, 240));
		main.add(panel, BorderLayout.LINE_END);

		panel.setLayout(new GridLayout(5, 2, 10, 10));
		panel.add(lblMaPhong = new JLabel("Mã phòng"));
		lblMaPhong.setFont(new Font("Segoe UI", 1, 18));
		lblMaPhong.setForeground(new Color(102, 102, 102));
		panel.add(txtMaPhong = new JTextField());
		txtMaPhong.setBorder(null);
		txtMaPhong.setEditable(false);

		panel.add(lblTenPhong = new JLabel("Tên phòng"));
		lblTenPhong.setFont(new Font("Segoe UI", 1, 18));
		lblTenPhong.setForeground(new Color(102, 102, 102));
		panel.add(txtTenPhong = new JTextField());
		txtTenPhong.setBorder(null);
		txtTenPhong.setEditable(false);

		panel.add(lblSoPhong = new JLabel("Số phòng"));
		lblSoPhong.setFont(new Font("Segoe UI", 1, 18));
		lblSoPhong.setForeground(new Color(102, 102, 102));
		panel.add(txtSoPhong = new JTextField());
		txtSoPhong.setBorder(null);
		txtSoPhong.setEditable(false);

		panel.add(lblSoTang = new JLabel("Số tầng"));
		lblSoTang.setFont(new Font("Segoe UI", 1, 18));
		lblSoTang.setForeground(new Color(102, 102, 102));
		panel.add(txtSoTang = new JTextField());
		txtSoTang.setBorder(null);
		txtSoTang.setEditable(false);

		panel.add(lblLoaiPhong = new JLabel("Loại phòng"));
		lblLoaiPhong.setFont(new Font("Segoe UI", 1, 18));
		lblLoaiPhong.setForeground(new Color(102, 102, 102));
		panel.add(txtLoaiPhong = new JTextField());
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setEditable(false);

	}

	private void createInfoRoom(JPanel main) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)),
				"Thông tin khách hàng"));
		panel.setPreferredSize(new Dimension(470, 240));
		main.add(panel, BorderLayout.CENTER);

		panel.setLayout(new GridLayout(5, 2, 10, 10));
		panel.add(lblHo = new JLabel("Họ Đệm"));
		lblHo.setFont(new Font("Segoe UI", 1, 18));
		lblHo.setForeground(new Color(102, 102, 102));
		panel.add(txtHo = new JTextField());

		panel.add(lblTen = new JLabel("Tên"));
		lblTen.setFont(new Font("Segoe UI", 1, 18));
		lblTen.setForeground(new Color(102, 102, 102));
		panel.add(txtTen = new JTextField());

		panel.add(lblCCCD = new JLabel("Số CCCD"));
		lblCCCD.setFont(new Font("Segoe UI", 1, 18));
		lblCCCD.setForeground(new Color(102, 102, 102));
		panel.add(txtCCCD = new JTextField());

		panel.add(lblSDT = new JLabel("Số điện thoại"));
		lblSDT.setFont(new Font("Segoe UI", 1, 18));
		lblSDT.setForeground(new Color(102, 102, 102));
		panel.add(txtSDT = new JTextField());

		panel.add(lblQuocTich = new JLabel("Quốc tịch"));
		lblQuocTich.setFont(new Font("Segoe UI", 1, 18));
		lblQuocTich.setForeground(new Color(102, 102, 102));
		panel.add(txtQuocTich = new JTextField());
	}

	private void createRoomTable(JPanel main) {
		JScrollPane scroll;
		String[] headers = { "Mã phòng", "Tên phòng", "Loại phòng" };
		modelBook = new DefaultTableModel(headers, 0);
		tableBook = new JTable(modelBook);
		main.add(scroll = new JScrollPane(tableBook, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.WEST);
		tableBook.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(400, 305));
		scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)),
				"Các phòng đã chọn"));
		scroll.setBackground(new Color(204, 204, 204));
	}

	private void createOption(JPanel main) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setPreferredSize(new Dimension(130, 305));
		main.add(panel, BorderLayout.CENTER);

		panel.add(btnThem = new JButton());
		btnThem.setBackground(new Color(128, 128, 255));
		btnThem.setFont(new Font("Segoe UI", 0, 18));
		btnThem.setForeground(new Color(34, 34, 34));
		btnThem.setText("Thêm phòng");

		panel.add(btnXoa = new JButton());
		btnXoa.setBackground(new Color(128, 128, 255));
		btnXoa.setFont(new Font("Segoe UI", 0, 18));
		btnXoa.setForeground(new Color(34, 34, 34));
		btnXoa.setText("Xóa phòng");
		btnXoa.setBackground(Color.decode("#FF8080"));

		panel.add(btnDat = new JButton());
		btnDat.setBackground(new Color(128, 128, 255));
		btnDat.setFont(new Font("Segoe UI", 0, 18));
		btnDat.setForeground(new Color(34, 34, 34));
		btnDat.setText("Đặt phòng");

	}

	private void createListRoom(JPanel main) {
		JScrollPane scroll;
		String[] headers = { "Mã phòng", "Tên phòng", "Loại phòng" };
		modelAvai = new DefaultTableModel(headers, 0);
		tableAvai = new JTable(modelAvai);
		main.add(scroll = new JScrollPane(tableAvai, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.EAST);
		tableAvai.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(400, 305));
		scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)),
				"Các phòng có thể"));
		scroll.setBackground(new Color(204, 204, 204));
	}

}
