package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import dao.DAO_DonDatPhong_Phong;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import entity.DonDatPhong_Phong;
import entity.Enum_HinhThucThue;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;

public class UI_ThongKe extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UI_ThongKe instance = new UI_ThongKe();
	private static final double tiLeGioThue = 0.07;
	//
	private DefaultTableModel modelTheoThang;
	private DefaultTableModel modelTheoNam;
	private DefaultTableModel modelKhachHang;
	//
	private javax.swing.JButton btnThongKeThang;
    private javax.swing.JButton btnThongKeNam;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboNamOnly;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JLabel lblINgay;
    private javax.swing.JLabel lblITongDoanhThuThang;
    private javax.swing.JLabel lblITongDoanhThuNam;
    private javax.swing.JLabel lblITongHoaDonThang;
    private javax.swing.JLabel lblITongHoaDonNam;
    private javax.swing.JLabel lblITongSoPhongThang;
    private javax.swing.JLabel lblITongSoPhongNam;
    private javax.swing.JLabel lblLNgay;
    private javax.swing.JLabel lblLTongDoanhThu1;
    private javax.swing.JLabel lblLTongDoanhThu2;
    private javax.swing.JLabel lblLTongHoaDon1;
    private javax.swing.JLabel lblLTongHoaDon2;
    private javax.swing.JLabel lblLTongSoPhong1;
    private javax.swing.JLabel lblLTongSoPhong2;
    private javax.swing.JLabel lblNam1;
    private javax.swing.JLabel lblNam2;
    private javax.swing.JLabel lblNone10;
    private javax.swing.JLabel lblNone11;
    private javax.swing.JLabel lblNone4;
    private javax.swing.JLabel lblNone5;
    private javax.swing.JLabel lblNone6;
    private javax.swing.JLabel lblNone7;
    private javax.swing.JLabel lblNone8;
    private javax.swing.JLabel lblNone9;
    private javax.swing.JLabel lblPhong1;
    private javax.swing.JLabel lblThongKe1;
    private javax.swing.JLabel lblThongKe2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlKQ1;
    private javax.swing.JPanel pnlKQ2;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlOption1;
    private javax.swing.JPanel pnlOption2;
    private javax.swing.JPanel pnlOptionTK1;
    private javax.swing.JPanel pnlOptionTK2;
    private javax.swing.JPanel pnlTK1;
    private javax.swing.JPanel pnlTK2;
    private javax.swing.JPanel pnlTheoNam;
    private javax.swing.JPanel pnlTheoThang;
    private javax.swing.JTabbedPane pnlThongKe;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTitleNgay;
    private javax.swing.JPanel pnlTitleThongKe1;
    private javax.swing.JPanel pnlTitleThongKe2;
    private javax.swing.JScrollPane scrHoaDon1;
    private javax.swing.JScrollPane scrHoaDon2;
    private javax.swing.JTable tblHoaDon1;
    private javax.swing.JTable tblHoaDon2;
    //
	public UI_ThongKe() {
        initComponents();
        addModel();
        addItem();
        addActionListener();
    }
	//
	public static UI_ThongKe getUI_ThongKeInstance() {return instance;}
	//
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlThongKe = new javax.swing.JTabbedPane();
        pnlTheoThang = new javax.swing.JPanel();
        pnlOption1 = new javax.swing.JPanel();
        pnlTitleThongKe1 = new javax.swing.JPanel();
        lblThongKe1 = new javax.swing.JLabel();
        pnlTK1 = new javax.swing.JPanel();
        pnlOptionTK1 = new javax.swing.JPanel();
        lblNam1 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        lblPhong1 = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        lblNone4 = new javax.swing.JLabel();
        lblNone5 = new javax.swing.JLabel();
        lblNone6 = new javax.swing.JLabel();
        btnThongKeThang = new javax.swing.JButton();
        pnlKQ1 = new javax.swing.JPanel();
        lblLTongHoaDon1 = new javax.swing.JLabel();
        lblITongHoaDonThang = new javax.swing.JLabel();
        lblLTongSoPhong1 = new javax.swing.JLabel();
        lblITongSoPhongThang = new javax.swing.JLabel();
        lblLTongDoanhThu1 = new javax.swing.JLabel();
        lblITongDoanhThuThang = new javax.swing.JLabel();
        scrHoaDon1 = new javax.swing.JScrollPane();
        tblHoaDon1 = new javax.swing.JTable();
        pnlTheoNam = new javax.swing.JPanel();
        pnlOption2 = new javax.swing.JPanel();
        pnlTitleThongKe2 = new javax.swing.JPanel();
        lblThongKe2 = new javax.swing.JLabel();
        pnlTK2 = new javax.swing.JPanel();
        pnlOptionTK2 = new javax.swing.JPanel();
        lblNam2 = new javax.swing.JLabel();
        cboNamOnly = new javax.swing.JComboBox<>();
        lblNone7 = new javax.swing.JLabel();
        lblNone8 = new javax.swing.JLabel();
        lblNone9 = new javax.swing.JLabel();
        lblNone10 = new javax.swing.JLabel();
        lblNone11 = new javax.swing.JLabel();
        btnThongKeNam = new javax.swing.JButton();
        pnlKQ2 = new javax.swing.JPanel();
        lblLTongHoaDon2 = new javax.swing.JLabel();
        lblITongHoaDonNam = new javax.swing.JLabel();
        lblLTongSoPhong2 = new javax.swing.JLabel();
        lblITongSoPhongNam = new javax.swing.JLabel();
        lblLTongDoanhThu2 = new javax.swing.JLabel();
        lblITongDoanhThuNam = new javax.swing.JLabel();
        scrHoaDon2 = new javax.swing.JScrollPane();
        tblHoaDon2 = new javax.swing.JTable();
        pnlKhachHang = new javax.swing.JPanel();
        pnlTitleNgay = new javax.swing.JPanel();
        lblLNgay = new javax.swing.JLabel();
        lblINgay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));
        setLayout(new java.awt.BorderLayout(3, 3));

        pnlTitle.setBackground(new java.awt.Color(204, 204, 204));
        pnlTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlTitle.setPreferredSize(new java.awt.Dimension(935, 50));
        pnlTitle.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Thống kê");
        pnlTitle.add(lblTitle, new java.awt.GridBagConstraints());

        add(pnlTitle, java.awt.BorderLayout.NORTH);

        pnlTheoThang.setBackground(new java.awt.Color(204, 204, 204));
        pnlTheoThang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlTheoThang.setLayout(new java.awt.BorderLayout());

        pnlOption1.setBackground(new java.awt.Color(153, 153, 153));
        pnlOption1.setOpaque(false);
        pnlOption1.setPreferredSize(new java.awt.Dimension(300, 472));
        pnlOption1.setLayout(new java.awt.BorderLayout());

        pnlTitleThongKe1.setPreferredSize(new java.awt.Dimension(300, 50));
        pnlTitleThongKe1.setLayout(new java.awt.GridBagLayout());

        lblThongKe1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongKe1.setText("Lựa chọn thống kê");
        pnlTitleThongKe1.add(lblThongKe1, new java.awt.GridBagConstraints());

        pnlOption1.add(pnlTitleThongKe1, java.awt.BorderLayout.NORTH);

        pnlTK1.setLayout(new java.awt.GridLayout(2, 1));

        pnlOptionTK1.setLayout(new java.awt.GridLayout(4, 2));

        lblNam1.setText("Năm:");
        pnlOptionTK1.add(lblNam1);
        pnlOptionTK1.add(cboNam);

        lblPhong1.setText("Tháng");
        pnlOptionTK1.add(lblPhong1);
        pnlOptionTK1.add(cboThang);
        pnlOptionTK1.add(lblNone4);
        pnlOptionTK1.add(lblNone5);
        pnlOptionTK1.add(lblNone6);

        btnThongKeThang.setText("Thống Kê");
        pnlOptionTK1.add(btnThongKeThang);

        pnlTK1.add(pnlOptionTK1);

        pnlKQ1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kết quả"));
        pnlKQ1.setLayout(new java.awt.GridLayout(4, 3));

        lblLTongHoaDon1.setText("Tổng số hóa đơn:");
        pnlKQ1.add(lblLTongHoaDon1);
        pnlKQ1.add(lblITongHoaDonThang);

        lblLTongSoPhong1.setText("Tổng số phòng đã đặt:");
        pnlKQ1.add(lblLTongSoPhong1);
        pnlKQ1.add(lblITongSoPhongThang);

        lblLTongDoanhThu1.setText("Tổng doanh thu:");
        pnlKQ1.add(lblLTongDoanhThu1);
        pnlKQ1.add(lblITongDoanhThuThang);

        pnlTK1.add(pnlKQ1);

        pnlOption1.add(pnlTK1, java.awt.BorderLayout.CENTER);

        pnlTheoThang.add(pnlOption1, java.awt.BorderLayout.EAST);

        scrHoaDon1.setViewportView(tblHoaDon1);

        pnlTheoThang.add(scrHoaDon1, java.awt.BorderLayout.CENTER);

        pnlThongKe.addTab("Doanh Thu Theo Tháng", pnlTheoThang);

        pnlTheoNam.setBackground(new java.awt.Color(204, 204, 204));
        pnlTheoNam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlTheoNam.setLayout(new java.awt.BorderLayout());

        pnlOption2.setBackground(new java.awt.Color(153, 153, 153));
        pnlOption2.setOpaque(false);
        pnlOption2.setPreferredSize(new java.awt.Dimension(300, 472));
        pnlOption2.setLayout(new java.awt.BorderLayout());

        pnlTitleThongKe2.setPreferredSize(new java.awt.Dimension(300, 50));
        pnlTitleThongKe2.setLayout(new java.awt.GridBagLayout());

        lblThongKe2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongKe2.setText("Lựa chọn thống kê");
        pnlTitleThongKe2.add(lblThongKe2, new java.awt.GridBagConstraints());

        pnlOption2.add(pnlTitleThongKe2, java.awt.BorderLayout.NORTH);

        pnlTK2.setLayout(new java.awt.GridLayout(2, 1));

        pnlOptionTK2.setLayout(new java.awt.GridLayout(4, 2));

        lblNam2.setText("Năm:");
        pnlOptionTK2.add(lblNam2);
        pnlOptionTK2.add(cboNamOnly);
        pnlOptionTK2.add(lblNone7);
        pnlOptionTK2.add(lblNone8);
        pnlOptionTK2.add(lblNone9);
        pnlOptionTK2.add(lblNone10);
        pnlOptionTK2.add(lblNone11);

        btnThongKeNam.setText("Thống Kê");
        pnlOptionTK2.add(btnThongKeNam);

        pnlTK2.add(pnlOptionTK2);

        pnlKQ2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kết quả"));
        pnlKQ2.setLayout(new java.awt.GridLayout(4, 3));

        lblLTongHoaDon2.setText("Tổng số hóa đơn:");
        pnlKQ2.add(lblLTongHoaDon2);
        pnlKQ2.add(lblITongHoaDonNam);

        lblLTongSoPhong2.setText("Tổng số phòng đã đặt:");
        pnlKQ2.add(lblLTongSoPhong2);
        pnlKQ2.add(lblITongSoPhongNam);

        lblLTongDoanhThu2.setText("Tổng doanh thu:");
        pnlKQ2.add(lblLTongDoanhThu2);
        pnlKQ2.add(lblITongDoanhThuNam);

        pnlTK2.add(pnlKQ2);

        pnlOption2.add(pnlTK2, java.awt.BorderLayout.CENTER);

        pnlTheoNam.add(pnlOption2, java.awt.BorderLayout.EAST);

        scrHoaDon2.setViewportView(tblHoaDon2);

        pnlTheoNam.add(scrHoaDon2, java.awt.BorderLayout.CENTER);

        pnlThongKe.addTab("Doanh Thu Theo Năm", pnlTheoNam);

        pnlKhachHang.setBackground(new java.awt.Color(204, 204, 204));
        pnlKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlKhachHang.setLayout(new java.awt.BorderLayout());

        pnlTitleNgay.setPreferredSize(new java.awt.Dimension(931, 50));
        pnlTitleNgay.setLayout(new java.awt.GridBagLayout());

        lblLNgay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLNgay.setText("Ngày:");
        pnlTitleNgay.add(lblLNgay, new java.awt.GridBagConstraints());

        lblINgay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlTitleNgay.add(lblINgay, new java.awt.GridBagConstraints());

        pnlKhachHang.add(pnlTitleNgay, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(tblKhachHang);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlKhachHang.add(jPanel2, java.awt.BorderLayout.CENTER);

        pnlThongKe.addTab("Khách hàng trong Ngày", pnlKhachHang);

        add(pnlThongKe, java.awt.BorderLayout.CENTER);
        pnlThongKe.getAccessibleContext().setAccessibleName("Doanh Thu Theo Năm");
    }
    public void addModel() {
    	modelTheoThang = new DefaultTableModel(new String [] {
                "Mã hóa đơn", "Ngày trả phòng", "Tổng tiền phòng"
            }, 0);
    	modelTheoNam = new DefaultTableModel(new String [] {
                "Mã hóa đơn", "Ngày trả phòng", "Tổng tiền phòng"
            }, 0);
    	modelKhachHang = new DefaultTableModel(new String [] {
                "Mã khách hàng", "Căn Cước Công Dân", "Họ và Tên", "Số điện thoại", "Quốc Tịch"
            }, 0);
    	
    	tblHoaDon1.setModel(modelTheoThang);
    	tblHoaDon2.setModel(modelTheoNam);
    	tblKhachHang.setModel(modelKhachHang);
    }
    public void thongKeTheoThang() {
    	String stringThang = cboThang.getSelectedItem().toString();
    	String stringNam = cboNam.getSelectedItem().toString();
    	
    	int thang = 0;
    	int nam = 0;
    	
    	try {
			thang = Integer.parseInt(stringThang);
			nam = Integer.parseInt(stringNam);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
    	
    	ArrayList<HoaDon> listHD = DAO_HoaDon.getDanhSachHoaDonTheoThangVaNam(thang, nam);
    	
    	NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
    	
    	if(listHD != null) {
    		double tongDoanhThu = 0;
        	int tongSoPhong = 0;
    		modelTheoThang.getDataVector().removeAllElements();
    		for(HoaDon thisHoaDon : listHD) {
    			int soPhong = DAO_DonDatPhong_Phong.tongSoPhongTrongMotDonDat(thisHoaDon.getDonDatPhong().getMaDonDat());
    			tongSoPhong += soPhong;
    			double tienPhong = tinhThongTienPhongCuaMotHoaDon(thisHoaDon);
    			tongDoanhThu += tienPhong;
        		modelTheoThang.addRow(new String[] {
        			Integer.toString(thisHoaDon.getMaHoaDon()),
        			thisHoaDon.getNgayTraPhong().toString(),
        			nf.format(tienPhong)
        		});

        		int tongHoaDon = listHD.size();
        		setKetQuaThongKeThang(tongHoaDon, tongSoPhong, tongDoanhThu);
        		
        	}
    	}
    	else {
    		JOptionPane.showMessageDialog(this, "Không có dữ liệu Thống kê");
    	}
    }
    public void thongKeTheoNam() {
    	String stringNam = cboNamOnly.getSelectedItem().toString();
    	int nam = 0;
    	try {
			nam = Integer.parseInt(stringNam);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
    	ArrayList<HoaDon> listHD = DAO_HoaDon.getDanhSachHoaDonTheoNam(nam);
    	NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
    	if(listHD != null) {
    		double tongDoanhThu = 0;
        	int tongSoPhong = 0;
    		modelTheoNam.getDataVector().removeAllElements();
    		for(HoaDon thisHoaDon : listHD) {
    			int soPhong = DAO_DonDatPhong_Phong.tongSoPhongTrongMotDonDat(thisHoaDon.getDonDatPhong().getMaDonDat());
    			tongSoPhong += soPhong;
    			double tienPhong = tinhThongTienPhongCuaMotHoaDon(thisHoaDon);
    			tongDoanhThu += tienPhong;
        		modelTheoNam.addRow(new String[] {
        			Integer.toString(thisHoaDon.getMaHoaDon()),
        			thisHoaDon.getNgayTraPhong().toString(),
        			nf.format(tienPhong)
        		});
        	}
    		int tongHoaDon = listHD.size();
    		setKetQuaThongKeNam(tongHoaDon, tongSoPhong, tongDoanhThu);
    	}
    	else {
    		JOptionPane.showMessageDialog(this, "Không có dữ liệu thống kê");
    	}
    }
    public void showKhachHangTrongNgay() {
    	ArrayList<KhachHang> listKhachHang = DAO_KhachHang.getDanhSachKhachHangDatPhongTrongNgay();
    	if(listKhachHang != null) {
    		modelKhachHang.getDataVector().removeAllElements();
    		for(KhachHang thisKhachHang : listKhachHang) {
    			modelKhachHang.addRow(new String[] {
    	    		Integer.toString(thisKhachHang.getMaKhachHang()),
    	    		thisKhachHang.getCccd(),
    	    		thisKhachHang.getHoDem() + " " + thisKhachHang.getTen(),
    	    		thisKhachHang.getSdt(),
    	    		thisKhachHang.getQuocTich()
    	    	});
    		}
    	}
    }
    public void addItem() {
    	for(int i = 1; i <= 12; i++) {
    		cboThang.addItem(Integer.toString(i));
    	}
    	
    	cboNam.addItem(Integer.toString(2022));
    	cboNam.addItem(Integer.toString(2023));
    	
    	cboNamOnly.addItem(Integer.toString(2022));
    	cboNamOnly.addItem(Integer.toString(2023));
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnThongKeThang) {
			thongKeTheoThang();
		}
			
		if(o == btnThongKeNam)
			thongKeTheoNam();
	}
	public double tinhThongTienPhongCuaMotHoaDon(HoaDon thisHD) {
		double tongTien = 0;
		
		Enum_HinhThucThue enumHinhThucThue = thisHD.getDonDatPhong().getHinhThucThue();
		ArrayList<DonDatPhong_Phong> listDP = DAO_DonDatPhong_Phong.getDanhSachPhongDatTheoMaDonDat(thisHD.getDonDatPhong().getMaDonDat());
		double thoiGianDatPhong = thisHD.getNgayDatPhong().getTime();
		double thoiGianTraPhong = thisHD.getNgayTraPhong().getTime();
		long thoiGianThue = 0;
		if(enumHinhThucThue.equals(Enum_HinhThucThue.Days)) {
			thoiGianThue = Math.round(Math.ceil((thoiGianTraPhong-thoiGianDatPhong)/86400000));
		}
		if(enumHinhThucThue.equals(Enum_HinhThucThue.Hours)) {
			thoiGianThue = Math.round(Math.ceil((thoiGianTraPhong-thoiGianDatPhong)/3600000));
		}
		if(enumHinhThucThue.equals(Enum_HinhThucThue.Days)) {
    		for(DonDatPhong_Phong thisDP : listDP) {
    			Phong thisPhong = thisDP.getPhongDat();
    			double donGiaPhong = thisPhong.getLoaiPhong().getDonGia();
    			tongTien += donGiaPhong*thoiGianThue;
    		}
    	}
    	if(enumHinhThucThue.equals(Enum_HinhThucThue.Hours)) {
    		for(DonDatPhong_Phong thisDP : listDP) {
    			Phong thisPhong = thisDP.getPhongDat();
    			double donGiaPhong = thisPhong.getLoaiPhong().getDonGia();
    			tongTien+= donGiaPhong*tiLeGioThue*thoiGianThue;
    		}
    	}
    	return tongTien;
	}
	public void addActionListener() {
		btnThongKeThang.addActionListener(this);
		btnThongKeNam.addActionListener(this);
	}
	
	public void setKetQuaThongKeThang(int tongHoaDon, int tongSoPhong, double tongDoanhThu) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
		lblITongHoaDonThang.setText(Integer.toString(tongHoaDon));
		lblITongSoPhongThang.setText(Integer.toString(tongSoPhong));
		lblITongDoanhThuThang.setText(nf.format(tongDoanhThu));
	}
	
	public void setKetQuaThongKeNam(int tongHoaDon, int tongSoPhong, double tongDoanhThu) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
		lblITongHoaDonNam.setText(Integer.toString(tongHoaDon));
		lblITongSoPhongNam.setText(Integer.toString(tongSoPhong));
		lblITongDoanhThuNam.setText(nf.format(tongDoanhThu));
	}
	
	public void resetModel() {
		modelTheoThang.getDataVector().removeAllElements();
		modelTheoNam.getDataVector().removeAllElements();
	}
}
