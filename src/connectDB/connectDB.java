package connectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connectDB {
	public static Connection con = null;
	private static connectDB instance = new connectDB();	
	public static connectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException {				
			String url = "jdbc:sqlserver://localhost:1433;databasename=HotelManagement";
			String user = "sa";
			String password = "123456789";
			con = DriverManager.getConnection(url, user, password);		
	}	
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {	e.printStackTrace();			}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
