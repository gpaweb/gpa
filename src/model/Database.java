package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Database {
	// JDBC driver name and database URL
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/gpa2k15?zeroDateTimeBehavior=convertToNull";
	// Database credentials
	private static String dbName = "gpa2k15";

	private Database() {
		// super();
	}

	public static String getDriver() {
		return driver;
	}

	public static String getUrl() {
		return url;
	}

	public static String getDbName() {
		return dbName;
	}

	public static boolean testDbConnection(String userName, String password) {
		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName(Database.getDriver());

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(Database.getUrl(), userName,
					password);
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
