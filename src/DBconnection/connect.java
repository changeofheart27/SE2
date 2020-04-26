package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
	private static String DB_URL = "jdbc:mysql://localhost:3306/se2db?useSSL=false";
	private static String USERNAME = "root";
	private static String PASSWORD = "Bich@quynh06";
	
	public static Connection getConnection() {
		Connection connect = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Connect to MySQL database successfully!");
		} catch (Exception e) {
			System.out.println("Connect to MySQL database failed!");
			e.printStackTrace();
		}
		return connect;
	}
}
