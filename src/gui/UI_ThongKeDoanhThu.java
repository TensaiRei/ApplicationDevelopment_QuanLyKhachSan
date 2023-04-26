
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_DoanhThu;
import entity.DoanhThu;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class UI_ThongKeDoanhThu extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DAO_DoanhThu dt_dao;
    private DefaultTableModel modelDoanhThu;
    private JTable tableDoanhThu;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UI_ThongKeDoanhThu frame = new UI_ThongKeDoanhThu();
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
    public UI_ThongKeDoanhThu() throws SQLException {
        ConnectDB.getInstance().connectDatabase();
        dt_dao = new DAO_DoanhThu();

        setTitle("Th\u1ED1ng k\u00EA doanh thu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 891, 576);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setToolTipText("");
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblNewLabel);

        String[] colHeader = { "ID", "Doanh Thu", "Thời gian" };
        modelDoanhThu = new DefaultTableModel(colHeader, 0);
        tableDoanhThu = new JTable(modelDoanhThu);
        add(new JScrollPane(tableDoanhThu), BorderLayout.CENTER);

        // =================================
        // doc du lieu tu database SQL vao Jtable
        ĐocuLieuTuDBVaoTB();

        // =================================

    }

    public void ĐocuLieuTuDBVaoTB() {
        List<DoanhThu> listDoanhThu = dt_dao.getDSDoanhThu();
        for (DoanhThu dt : listDoanhThu) {
            modelDoanhThu.addRow(new Object[] { dt.getId(), dt.getThanhtien(), dt.getThoiGian() });
        }
    }

}
