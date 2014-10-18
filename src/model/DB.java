package model;
import java.sql.*;

public class DB {
	private String url;
	private String dbName;
	private String driver;
	private String userName;
	private String dbPassword;
	private Connection conn;
	
	public DB(String url, String dbName, String driver, String userName,
			String dbPassword) {
		this.url = url;
		this.dbName = dbName;
		this.driver = driver;
		this.userName = userName;
		this.dbPassword = dbPassword;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, dbPassword);
			System.out.println("Connection establish");
			Statement stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}