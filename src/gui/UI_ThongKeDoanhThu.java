
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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DAO_DoanhThu;
import entity.DoanhThu;

import javax.swing.JScrollPane;

public class UI_ThongKeDoanhThu extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
        docuLieuTuDBVaoTB();

        // =================================
    }

    public void docuLieuTuDBVaoTB() {
        ArrayList<DoanhThu> listDoanhThu = DAO_DoanhThu.getDSDoanhThu();
        for (DoanhThu dt : listDoanhThu) {
            modelDoanhThu.addRow(new Object[] { dt.getId(), dt.getThanhtien(), dt.getThoiGian() });
        }
    }

}
