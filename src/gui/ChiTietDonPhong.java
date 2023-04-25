package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_DichVu;
import dao.DAO_DonDatPhong;
import dao.DAO_DonDatPhong_DichVu;
import dao.DAO_DonDatPhong_Phong;
import dao.DAO_KhachHang;
import dao.DAO_Phong;
import entity.DichVu;
import entity.DichVuDat;
import entity.DonDatPhong;
import entity.KhachHang;
import entity.Phong;

import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class ChiTietDonPhong extends JFrame implements ItemListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	private JPanel contentPane;
	private JTextField txtSoPhong;
	private JPanel pnlRoomDetail;
	private JTable tableServices;
	private DefaultTableModel tableModelServices;
	private JTextField txtNumber;
	private JTable table_OrderDetails;
	private DefaultTableModel tableModelOrderDetails;
	private JTextField txtMaKH;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtCCCD;
	private JTextField txtSDT;
	private JTextField txtQuocTich;
	private JTextField txtMaPhong;
	private JTextField txtTang;
	private JTextField txtTenPhong;
	private JTextField textTinhTrang;
	private JTextField txtLoaiPhong;
	private JTextField txtGia;
	private JLabel lblQuocTich;
	private JComboBox<String> cboTypeOfServices;
	
	private JButton btnAddServices;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietDonPhong frame = new ChiTietDonPhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiTietDonPhong() {
		setResizable(false);
		setAlwaysOnTop(true);
		setBackground(Color.WHITE);
		setTitle("Chi tiết phòng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(
				new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlCustomerDetail = new JPanel();
		pnlCustomerDetail.setBackground(new Color(240, 255, 255));
		pnlCustomerDetail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pnlCustomerDetail.setBounds(5, 70, 600, 240);
		contentPane.add(pnlCustomerDetail);
		pnlCustomerDetail.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMaKH.setBounds(10, 30, 150, 24);
		pnlCustomerDetail.add(lblMaKH);
		
		JLabel lblHo = new JLabel("Họ:");
		lblHo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHo.setBounds(10, 80, 40, 24);
		pnlCustomerDetail.add(lblHo);
		
		JLabel lblTen = new JLabel("Tên:");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTen.setBounds(300, 80, 50, 24);
		pnlCustomerDetail.add(lblTen);
		
		JLabel lblCCCD = new JLabel("CCCD/CMND:");
		lblCCCD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCCCD.setBounds(10, 130, 130, 24);
		pnlCustomerDetail.add(lblCCCD);
		
		lblQuocTich = new JLabel("Quốc tịch:");
		lblQuocTich.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuocTich.setBounds(300, 130, 100, 24);
		pnlCustomerDetail.add(lblQuocTich);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSDT.setBounds(10, 180, 130, 24);
		pnlCustomerDetail.add(lblSDT);
		
		txtMaKH = new JTextField();
		txtMaKH.setBackground(Color.WHITE);
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaKH.setEditable(false);
		txtMaKH.setBorder(null);
		txtMaKH.setBounds(160, 30, 150, 24);
		pnlCustomerDetail.add(txtMaKH);
		txtMaKH.setColumns(12);
		
		txtHo = new JTextField();
		txtHo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHo.setEditable(false);
		txtHo.setColumns(12);
		txtHo.setBorder(null);
		txtHo.setBackground(Color.WHITE);
		txtHo.setBounds(50, 80, 220, 24);
		pnlCustomerDetail.add(txtHo);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setEditable(false);
		txtTen.setColumns(12);
		txtTen.setBorder(null);
		txtTen.setBackground(Color.WHITE);
		txtTen.setBounds(350, 80, 150, 24);
		pnlCustomerDetail.add(txtTen);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCCCD.setEditable(false);
		txtCCCD.setColumns(20);
		txtCCCD.setBorder(null);
		txtCCCD.setBackground(Color.WHITE);
		txtCCCD.setBounds(140, 130, 140, 24);
		pnlCustomerDetail.add(txtCCCD);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setEditable(false);
		txtSDT.setColumns(20);
		txtSDT.setBorder(null);
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setBounds(140, 180, 140, 24);
		pnlCustomerDetail.add(txtSDT);
		
		txtQuocTich = new JTextField();
		txtQuocTich.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtQuocTich.setEditable(false);
		txtQuocTich.setColumns(12);
		txtQuocTich.setBorder(null);
		txtQuocTich.setBackground(Color.WHITE);
		txtQuocTich.setBounds(399, 130, 200, 24);
		pnlCustomerDetail.add(txtQuocTich);
		
		pnlRoomDetail = new JPanel();
		pnlRoomDetail.setBackground(new Color(240, 255, 255));
		pnlRoomDetail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Room Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pnlRoomDetail.setBounds(610, 70, 650, 240);
		contentPane.add(pnlRoomDetail);
		pnlRoomDetail.setLayout(null);
		
		JLabel lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setBounds(10, 30, 100, 24);
		lblMaPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlRoomDetail.add(lblMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(110, 30, 150, 24);
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(12);
		txtMaPhong.setBorder(null);
		txtMaPhong.setBackground(Color.WHITE);
		pnlRoomDetail.add(txtMaPhong);
		
		JLabel lblTang = new JLabel("Tầng:");
		lblTang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTang.setBounds(310, 30, 60, 24);
		pnlRoomDetail.add(lblTang);
		
		txtTang = new JTextField();
		txtTang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTang.setEditable(false);
		txtTang.setColumns(12);
		txtTang.setBorder(null);
		txtTang.setBackground(Color.WHITE);
		txtTang.setBounds(370, 30, 150, 24);
		pnlRoomDetail.add(txtTang);
		
		JLabel lblTenPhong = new JLabel("Tên phòng:");
		lblTenPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenPhong.setBounds(10, 80, 110, 24);
		pnlRoomDetail.add(lblTenPhong);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenPhong.setEditable(false);
		txtTenPhong.setColumns(16);
		txtTenPhong.setBorder(null);
		txtTenPhong.setBackground(Color.WHITE);
		txtTenPhong.setBounds(120, 80, 150, 24);
		pnlRoomDetail.add(txtTenPhong);
		
		textTinhTrang = new JTextField();
		textTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTinhTrang.setEditable(false);
		textTinhTrang.setColumns(20);
		textTinhTrang.setBorder(null);
		textTinhTrang.setBackground(Color.WHITE);
		textTinhTrang.setBounds(420, 80, 200, 24);
		pnlRoomDetail.add(textTinhTrang);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng:");
		lblTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTinhTrang.setBounds(310, 80, 110, 24);
		pnlRoomDetail.add(lblTinhTrang);
		
		JLabel lblLoaiPhong = new JLabel("Loại Phòng:");
		lblLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoaiPhong.setBounds(10, 130, 110, 24);
		pnlRoomDetail.add(lblLoaiPhong);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(16);
		txtLoaiPhong.setBorder(null);
		txtLoaiPhong.setBackground(Color.WHITE);
		txtLoaiPhong.setBounds(120, 130, 150, 24);
		pnlRoomDetail.add(txtLoaiPhong);
		
		JLabel lblGia = new JLabel("Giá tiền:");
		lblGia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGia.setBounds(310, 130, 80, 24);
		pnlRoomDetail.add(lblGia);
		
		txtGia = new JTextField();
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGia.setEditable(false);
		txtGia.setColumns(16);
		txtGia.setBorder(null);
		txtGia.setBackground(Color.WHITE);
		txtGia.setBounds(390, 130, 150, 24);
		pnlRoomDetail.add(txtGia);
		
		JLabel lblMnt = new JLabel("Mã đơn đặt:");
		lblMnt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMnt.setBounds(10, 184, 130, 24);
		pnlRoomDetail.add(lblMnt);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setColumns(16);
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setBounds(140, 184, 150, 24);
		pnlRoomDetail.add(textField);
		
		String[] header = {"Mã Dịch Vụ", "Tên Dịch Vụ", "Đơn giá", "Loại Dịch Vụ"};
		tableModelServices = new DefaultTableModel(header, 0);
		
		JPanel panelServices = new JPanel();
		panelServices.setBackground(new Color(240, 255, 255));
		panelServices.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Services", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelServices.setBounds(5, 320, 520, 300);
		contentPane.add(panelServices);
		panelServices.setLayout(null);
		tableServices = new JTable(tableModelServices);
		tableServices.setBackground(SystemColor.text);
		tableServices.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tableServices);
		scrollPane.setBounds(10, 20, 500, 200);
		panelServices.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblSort = new JLabel("Lọc theo:");
		lblSort.setBounds(10, 240, 65, 30);
		panelServices.add(lblSort);
		lblSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cboTypeOfServices = new JComboBox<String>();
		cboTypeOfServices.setMaximumRowCount(20);
		cboTypeOfServices.setBounds(75, 240, 180, 30);
		cboTypeOfServices.addItem("All Services");
		cboTypeOfServices.addItem("Foods");
		cboTypeOfServices.addItem("Drinks");
		cboTypeOfServices.addItem("Others Services");
		panelServices.add(cboTypeOfServices);
		cboTypeOfServices.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSort.setLabelFor(cboTypeOfServices);
		
		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setBounds(260, 240, 70, 30);
		panelServices.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNumber = new JTextField();
		txtNumber.setBounds(330, 240, 60, 30);
		panelServices.add(txtNumber);
		txtNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumber.setColumns(10);
		
		btnAddServices = new JButton("THÊM");
		btnAddServices.setIcon(new ImageIcon("img\\add.png"));
		btnAddServices.setBounds(400, 240, 110, 30);
		panelServices.add(btnAddServices);
		btnAddServices.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddServices.setEnabled(false);
		
		JPanel panelOrderDetails = new JPanel();
		panelOrderDetails.setBackground(new Color(240, 255, 255));
		panelOrderDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Room's Order Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelOrderDetails.setBounds(530, 320, 730, 300);
		contentPane.add(panelOrderDetails);
		
		String[] header_OrderDetails = {"Mã Đơn Đặt", "Mã Dịch Vụ", "Tên Dịch Vụ", "Số lượng", "Đơn giá", "Thành tiền"};
		tableModelOrderDetails = new DefaultTableModel(header_OrderDetails, 0);
		panelOrderDetails.setLayout(null);
		
		JScrollPane scrollPane_OrderDetails = new JScrollPane();
		scrollPane_OrderDetails.setBounds(10, 20, 710, 265);
		panelOrderDetails.add(scrollPane_OrderDetails);
		table_OrderDetails = new JTable(tableModelOrderDetails);
		scrollPane_OrderDetails.setViewportView(table_OrderDetails);
		
		JPanel panel_Phong = new JPanel();
		panel_Phong.setBackground(new Color(240, 255, 255));
		panel_Phong.setBounds(382, 10, 500, 50);
		contentPane.add(panel_Phong);
		panel_Phong.setLayout(null);
		
		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(270, 5, 230, 40);
		panel_Phong.add(txtSoPhong);
		txtSoPhong.setForeground(Color.BLACK);
		txtSoPhong.setHorizontalAlignment(SwingConstants.LEFT);
		txtSoPhong.setText("");
		txtSoPhong.setBackground(new Color(240, 255, 255));
		txtSoPhong.setFont(new Font("Tahoma", Font.BOLD, 36));
		txtSoPhong.setBorder(null);
		txtSoPhong.setColumns(10);
		
		JLabel lblPhong = new JLabel("Phòng:");
		lblPhong.setBackground(new Color(240, 255, 255));
		lblPhong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhong.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPhong.setBounds(0, 0, 240, 50);
		panel_Phong.add(lblPhong);
		
		ConnectDB.getInstance().connectDatabase();
		updateServicesTableData();
		
		cboTypeOfServices.addItemListener(this);
		
		tableServices.addMouseListener(this);
		
		setThongTinUI("PHG0402");
	}

	public void setThongTinUI(String maPhongCanSet) {
		Phong phong = DAO_Phong.getPhongTheoMaPhong(maPhongCanSet);
		int maPhong = DAO_DonDatPhong_Phong.getMaDonDatGanNhatCuaPhong(phong.getMaPhong());
		ArrayList<DichVuDat> listDVD = DAO_DonDatPhong_DichVu.getDanhSachDichVuDatTheoMaDonDatMaPhong(maPhong, phong.getMaPhong());
		DonDatPhong donDatPhong = DAO_DonDatPhong.getDonDatPhongTheoMaDonDat(maPhong);
		KhachHang khachHang = DAO_KhachHang.getKhachHangTheoMaKhachHang(donDatPhong.getMaKhachHang());
		
		txtSoPhong.setText(Integer.toString(phong.getSoPhong()));
		
		txtMaKH.setText(Integer.toString(khachHang.getMaKhachHang()));
		txtHo.setText(khachHang.getHoDem());
		txtTen.setText(khachHang.getTen());
		txtCCCD.setText(khachHang.getCccd());
		txtQuocTich.setText(khachHang.getQuocTich());
		txtSDT.setText(khachHang.getSdt());
		
		txtMaPhong.setText(phong.getMaPhong());
		txtTang.setText(Integer.toString(phong.getSoTang()));
		txtTenPhong.setText(phong.getTenPhong());
		textTinhTrang.setText(phong.getTinhTrang().toString());
		txtLoaiPhong.setText(phong.getLoaiPhong().getTenLoaiPhong());
		txtGia.setText(Double.toString(phong.getLoaiPhong().getDonGia()));
		
		for(DichVuDat thisDichVuDat : listDVD) {
			DichVu thisDichVu = DAO_DichVu.getDichVuTheoMaDichVu(thisDichVuDat.getMaDichVu());
			tableModelOrderDetails.addRow(new String[] {
				Integer.toString(thisDichVuDat.getMaDonDat()),
				thisDichVuDat.getMaDichVu(),
				thisDichVu.getTenDichVu(),
				Integer.toString(thisDichVuDat.getSoLuong()),
				Double.toString(thisDichVu.getDonGia()),
				Double.toString(thisDichVuDat.getSoLuong()*thisDichVu.getDonGia())
			});
		}
	}
	
	private void updateServicesTableData() {
		ArrayList<DichVu> listDV = DAO_DichVu.getAllDSDichVu();
		tableModelServices.setRowCount(0);
		for (DichVu dichvu : listDV) {
			String[] rowDatas = {dichvu.getMaDichVu(), dichvu.getTenDichVu(), 
					dichvu.getDonGia() + "", dichvu.getLoaiDV() + ""};
			tableModelServices.addRow(rowDatas);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = cboTypeOfServices.getSelectedItem();
		if (o.equals("Foods")) {
			tableModelServices.setRowCount(0);
			ArrayList<DichVu> listDV = DAO_DichVu.getDSDichVuTheoThucAn();
			for (DichVu dichvu : listDV) {
				String[] rowDatas = {dichvu.getMaDichVu(), dichvu.getTenDichVu(), 
						dichvu.getDonGia() + "", dichvu.getLoaiDV() + ""};
				tableModelServices.addRow(rowDatas);
			}
		} else if (o.equals("Drinks")) {
			tableModelServices.setRowCount(0);
			ArrayList<DichVu> listDV = DAO_DichVu.getDSDichVuTheoDoUong();
			for (DichVu dichvu : listDV) {
				String[] rowDatas = {dichvu.getMaDichVu(), dichvu.getTenDichVu(), 
						dichvu.getDonGia() + "", dichvu.getLoaiDV() + ""};
				tableModelServices.addRow(rowDatas);
			}
		} else if (o.equals("Others Services")) {
			tableModelServices.setRowCount(0);
			ArrayList<DichVu> listDV = DAO_DichVu.getDSDichVuConLai();
			for (DichVu dichvu : listDV) {
				String[] rowDatas = {dichvu.getMaDichVu(), dichvu.getTenDichVu(), 
						dichvu.getDonGia() + "", dichvu.getLoaiDV() + ""};
				tableModelServices.addRow(rowDatas);
			}
		} else
			updateServicesTableData();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableServices.getSelectedRow();
		if (row != -1) {
			btnAddServices.setEnabled(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}