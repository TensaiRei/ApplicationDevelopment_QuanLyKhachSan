package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import dao.DAO_HoaDon;
import entity.HoaDon;

public class UI_HoaDon extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UI_HoaDon instance = new UI_HoaDon(); 
	private DefaultTableModel modelHD;
	//
	private javax.swing.JButton btnChiTiet;
    private javax.swing.ButtonGroup btnGroupLoc;
    private javax.swing.ButtonGroup btnGroupTim;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTaiLai;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlFunc;
    private javax.swing.JPanel pnlLoc;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JRadioButton radCCCD;
    private javax.swing.JRadioButton radMHD;
    private javax.swing.JRadioButton radND;
    private javax.swing.JRadioButton radNT;
    private javax.swing.JScrollPane scrHD;
    private javax.swing.JTable tblHD;
    //
    public UI_HoaDon() {
    	initComponents();
    	addTableModel();
    	addActionListener();
    	addButtonGroup();
    	addDanhSachHoaDon();
    	setDecorateButton();
    }
    //
    public static UI_HoaDon getUI_HoaDonInstance() {return instance;}
    //                         
    private void initComponents() {

        btnGroupTim = new javax.swing.ButtonGroup();
        btnGroupLoc = new javax.swing.ButtonGroup();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlFunc = new javax.swing.JPanel();
        btnChiTiet = new javax.swing.JButton();
        btnHuyHD = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        pnlTim = new javax.swing.JPanel();
        radMHD = new javax.swing.JRadioButton();
        radCCCD = new javax.swing.JRadioButton();
        btnLoc = new javax.swing.JButton();
        pnlLoc = new javax.swing.JPanel();
        radND = new javax.swing.JRadioButton();
        radNT = new javax.swing.JRadioButton();
        btnTaiLai = new javax.swing.JButton();
        pnlTable = new javax.swing.JPanel();
        scrHD = new javax.swing.JScrollPane();
        tblHD = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));
        setDoubleBuffered(false);
        setLayout(new java.awt.BorderLayout(3, 3));

        pnlTitle.setBackground(new java.awt.Color(204, 204, 204));
        pnlTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlTitle.setPreferredSize(new java.awt.Dimension(935, 50));
        pnlTitle.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Danh sách Hóa đơn");
        pnlTitle.add(lblTitle, new java.awt.GridBagConstraints());

        add(pnlTitle, java.awt.BorderLayout.PAGE_START);

        pnlFunc.setBackground(new java.awt.Color(204, 204, 204));
        pnlFunc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlFunc.setPreferredSize(new java.awt.Dimension(175, 507));

        btnChiTiet.setBackground(new java.awt.Color(128, 128, 255));
        btnChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChiTiet.setForeground(new java.awt.Color(34, 34, 34));
        btnChiTiet.setText("Chi tiết");
        btnChiTiet.setPreferredSize(new java.awt.Dimension(150, 50));
        pnlFunc.add(btnChiTiet);

        btnHuyHD.setBackground(new java.awt.Color(128, 128, 255));
        btnHuyHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHuyHD.setForeground(new java.awt.Color(34, 34, 34));
        btnHuyHD.setText("Hủy Hóa đơn");
        btnHuyHD.setToolTipText("");
        btnHuyHD.setPreferredSize(new java.awt.Dimension(150, 50));
        pnlFunc.add(btnHuyHD);

        btnTim.setBackground(new java.awt.Color(128, 128, 255));
        btnTim.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTim.setForeground(new java.awt.Color(34, 34, 34));
        btnTim.setText("Tìm");
        btnTim.setPreferredSize(new java.awt.Dimension(150, 50));
        pnlFunc.add(btnTim);

        pnlTim.setOpaque(false);
        pnlTim.setPreferredSize(new java.awt.Dimension(150, 75));
        pnlTim.setLayout(new javax.swing.BoxLayout(pnlTim, javax.swing.BoxLayout.Y_AXIS));

        radMHD.setBackground(new java.awt.Color(204, 204, 204));
        radMHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radMHD.setText("Theo Mã Hóa đơn");
        pnlTim.add(radMHD);

        radCCCD.setBackground(new java.awt.Color(204, 204, 204));
        radCCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radCCCD.setText("Theo CCCD Khách");
        pnlTim.add(radCCCD);

        pnlFunc.add(pnlTim);

        btnLoc.setBackground(new java.awt.Color(128, 128, 255));
        btnLoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(34, 34, 34));
        btnLoc.setText("Lọc");
        btnLoc.setPreferredSize(new java.awt.Dimension(150, 50));
        pnlFunc.add(btnLoc);

        pnlLoc.setOpaque(false);
        pnlLoc.setPreferredSize(new java.awt.Dimension(150, 75));
        pnlLoc.setLayout(new javax.swing.BoxLayout(pnlLoc, javax.swing.BoxLayout.Y_AXIS));

        radND.setBackground(new java.awt.Color(204, 204, 204));
        radND.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radND.setText("Theo Ngày đặt");
        pnlLoc.add(radND);

        radNT.setBackground(new java.awt.Color(204, 204, 204));
        radNT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNT.setText("Theo Ngày trả");
        pnlLoc.add(radNT);

        pnlFunc.add(pnlLoc);

        btnTaiLai.setBackground(new java.awt.Color(255, 128, 128));
        btnTaiLai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTaiLai.setForeground(new java.awt.Color(34, 34, 34));
        btnTaiLai.setText("Tải lại");
        btnTaiLai.setPreferredSize(new java.awt.Dimension(150, 50));
        pnlFunc.add(btnTaiLai);

        add(pnlFunc, java.awt.BorderLayout.LINE_END);

        pnlTable.setBackground(new java.awt.Color(204, 204, 204));
        pnlTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlTable.setLayout(new java.awt.BorderLayout());

        tblHD.setRowHeight(40);
        scrHD.setViewportView(tblHD);

        pnlTable.add(scrHD, java.awt.BorderLayout.CENTER);

        add(pnlTable, java.awt.BorderLayout.CENTER);
    }
    private void addTableModel() {
		modelHD = new DefaultTableModel(new String [] {"Mã Hóa đơn", "Mã Đơn đặt", "Phụ phí", "Tổng tiền", "Ngày đặt", "Ngày trả"}, 0);
		tblHD.setModel(modelHD);
	}
    private void addActionListener() {
		btnChiTiet.addActionListener(this);
		btnHuyHD.addActionListener(this);
		btnLoc.addActionListener(this);
		btnTaiLai.addActionListener(this);
	}
	private void addButtonGroup() {
		btnGroupTim.add(radMHD);
		btnGroupTim.add(radCCCD);
		
		btnGroupLoc.add(radND);
		btnGroupLoc.add(radNT);
	}
	private void addDanhSachHoaDon() {
    	ArrayList<HoaDon> listHD = DAO_HoaDon.getDanhSachHoaDon();
    	for(HoaDon thisHoaDon : listHD) {
    		modelHD.addRow(new String[] {
    			Integer.toString(thisHoaDon.getMaHoaDon()),
    			Integer.toString(thisHoaDon.getMaDonDat()),
    			Double.toString(thisHoaDon.getPhuPhi()),
    			Double.toString(thisHoaDon.getTongThanhTien()),
    			thisHoaDon.getNgayDatPhong().toString(),
    			thisHoaDon.getNgayTraPhong().toString()
    		});
    	}
    }
	private void setDecorateButton() {
		btnChiTiet.setFocusPainted(false);
		btnHuyHD.setFocusPainted(false);
		btnLoc.setFocusPainted(false);
		btnTaiLai.setFocusPainted(false);
	}
	private void xemChiTiet() {
		int row = tblHD.getSelectedRow();
		if(row == -1)
			JOptionPane.showMessageDialog(this, "Vui lòng chọn Hóa đơn cần xem");
		else {
			UI_Main.getUI_MainInstance().showUI(UI_ChiTietHoaDon.getUI_ChiTietHoaDonInstance());
			UI_ChiTietHoaDon.getUI_ChiTietHoaDonInstance().setHoaDon(Integer.parseInt(modelHD.getValueAt(row, 0).toString()));
		}
	}
	private void reloadTable() {
		modelHD.getDataVector().removeAllElements();
		addDanhSachHoaDon();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnChiTiet))
			xemChiTiet();
		if(o.equals(btnHuyHD));
		if(o.equals(btnLoc));
		if(o.equals(btnTaiLai))
			reloadTable();
	}
}
