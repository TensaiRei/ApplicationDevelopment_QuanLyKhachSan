package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DoanhThu;

public class DAO_DoanhThu {
    public DAO_DoanhThu() {}
    public static ArrayList<DoanhThu> getDSDoanhThu() {
        ArrayList<DoanhThu> listDT = new ArrayList<DoanhThu>();
        try {
            ConnectDB.getInstance().connectDatabase();
            Connection connect = ConnectDB.getConnection();
            String sql = ""
                    + "SELECT hd.MaHoaDon, sum(hd.TongThanhTien) as ThanhTien, hd.NgayDatPhong "
                    + "FROM HoaDon hd join DonDatPhong ddp on hd.MaDonDat=ddp.MaDonDat "
                    + "GROUP BY hd.MaHoaDon, hd.NgayDatPhong";
            PreparedStatement prpStm = connect.prepareStatement(sql);
            ResultSet result = prpStm.executeQuery();
            int rowCount = 0;
            while (result.next()) {
                String ID = result.getString(1);
                double ThanhTien = result.getDouble(2);
                Timestamp ThoiGian = result.getTimestamp(3);
                DoanhThu dt = new DoanhThu(ID, ThanhTien, ThoiGian);
                listDT.add(dt);
                rowCount++;
            }
            if (rowCount == 0)
                return null;
            return listDT;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectDB.getInstance().disconnectDatabase();
        }
        return listDT;
    }
}
