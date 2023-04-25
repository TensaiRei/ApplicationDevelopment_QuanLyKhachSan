package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	//Connect Attributes
	private static ConnectDB instance = new ConnectDB();
	private static Connection connect = null;
	
	//Constructor
	public ConnectDB() {}
	
	//Get
	public static ConnectDB getInstance() {return instance;}
	public static Connection getConnection() {return connect;}
	
	//Methods
	public void connectDatabase() {
		try {
			//Login by Windows Authentication
				//String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagement;integratedSecurity=true;";
			
			//Login by SQL Login
				String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagement";
				String username = "sa";
				String password = "12345678";
				
			connect = DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnectDatabase() {
		if(connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
