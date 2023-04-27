package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO_LoaiPhong;
import dao.DAO_Phong;
import entity.LoaiPhong;
import entity.Phong;


public class UI_Phong extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static UI_Phong instance = new UI_Phong();

	public static UI_Phong getUI_PhongInstance() {
		return instance;
	}

	private JButton btnThue;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnLoc;
	private JComboBox<String> cboLoaiPhong;
	private JComboBox<String> cboTinhTrang;
	ArrayList<Phong> dsPhong = new ArrayList<Phong>();

	public UI_Phong() {
		setBackground(new java.awt.Color(102, 102, 102));
		setDoubleBuffered(false);
		setLayout(new java.awt.BorderLayout(3, 3));

		createGUI();
		
		btnThue.addActionListener(this);
		btnLoc.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(btnThue))
			handlerBtnThue();
		else if(object.equals(btnLoc)) 	
			handlerBtnloc();
	}
	
	private void handlerBtnThue() {
		int row = table.getSelectedRowCount();
		if(row == 0)
			JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng muốn đặt");
		else {
			ArrayList<Phong> dsPhongBooking= new ArrayList<Phong>();
			int[] selectedRows = table.getSelectedRows();
			for(int i=0; i<selectedRows.length; i++) {
				String maPhong = (String) table.getValueAt(i, 0);
				Phong p = new Phong(maPhong);
				p =  dsPhong.get(dsPhong.indexOf(p));
				dsPhongBooking.add(p);
			}
			UI_Main.getUI_MainInstance().showUI(UI_DatPhong.getUI_DatPhongInstance());
			UI_DatPhong.getUI_DatPhongInstance().addListRoom(dsPhongBooking);
		}
	}
	
	private void handlerBtnloc() {
		model.setRowCount(0);
		if(cboTinhTrang.getSelectedIndex()==0) {
			dsPhong = DAO_Phong.getDanhSachPhong();
		} else {
			String tinhTrang =(String) cboTinhTrang.getSelectedItem();
			dsPhong = DAO_Phong.filterPhong(tinhTrang);
		}
		
		
		addAllTableData(dsPhong);
		
	}

	private void createGUI() {
		createTitle();
		createTable();
		createOption();
	}

	private void createTitle() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
		panel.setPreferredSize(new Dimension(935, 50));
		panel.setLayout(new GridBagLayout());

		JLabel lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
		lblTitle.setText("Danh sách Phòng");
		panel.add(lblTitle, new GridBagConstraints());

		add(panel, BorderLayout.PAGE_START);
	}

	private void createTable() {
		JScrollPane scroll;
		String[] headers = { "Mã phòng", "Số phòng", "Số tầng", "Tên phòng", "tinhTrang", "Loại phòng" };
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		add(scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 250));

		table.setRowHeight(40);
		dsPhong = DAO_Phong.getDanhSachPhong();
		addAllTableData(dsPhong);
	}

	private void createOption() {
		JPanel panel = new JPanel();
		add(panel, BorderLayout.LINE_END);
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
		panel.setPreferredSize(new java.awt.Dimension(175, 507));

		panel.add(btnThue = new JButton());
		btnThue.setBackground(new Color(128, 128, 255));
		btnThue.setFont(new Font("Segoe UI", 0, 18)); 
		btnThue.setForeground(new Color(34, 34, 34));
		btnThue.setText("Thuê phòng");
		btnThue.setPreferredSize(new Dimension(150, 50));
		
		panel.add(btnLoc = new JButton());
		btnLoc.setBackground(new Color(128, 128, 255));
		btnLoc.setFont(new Font("Segoe UI", 0, 18));
		btnLoc.setForeground(new Color(34, 34, 34));
		btnLoc.setText("Lọc phòng");
		btnLoc.setPreferredSize(new Dimension(150, 50));

		JPanel pnlTinhTrang = new JPanel();
		pnlTinhTrang.add(cboTinhTrang = new JComboBox<String>());
		cboTinhTrang.setPreferredSize(new Dimension(150, 30));
		String[] tinhTrang = {"Tất cả", "Available", "Booked", "Not Available"};
		cboTinhTrang.setModel(new DefaultComboBoxModel<String>(tinhTrang));;
		panel.add(cboTinhTrang);
	}

	private void addAllTableData(ArrayList<Phong> dsPhong) {
		for (Phong phong : dsPhong) {
			String tinhTrang;
			switch (phong.getTinhTrang()) {
			case Available: {
				tinhTrang = "Available";
				break;
			}
			case Booked: {
				tinhTrang = "Booked";
				break;
			}
			case Not_Available: {
				tinhTrang = "Not Available";
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + dsPhong);
			}
			LoaiPhong loaiPhong = DAO_LoaiPhong.getLoaiPhongTheoMaLoaiPhong(phong.getLoaiPhong().getMaloaiPhong());
			model.addRow(new String[] { phong.getMaPhong(), phong.getSoPhong() + "", phong.getSoTang() + "",
					phong.getTenPhong(), tinhTrang, loaiPhong.getTenLoaiPhong(), });
		}
	}

	
}