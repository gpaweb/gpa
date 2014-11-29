package model.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Database;
import model.LoginInfo;

public class Particulier extends Intervenants {
	private String prenom;

	public Particulier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public static Particulier getParticulier(String noParticulier) {
		Particulier particulier = new Particulier();

		// STEP 1: Declare the needed objects
		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName(Database.getDriver());

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(Database.getUrl(),
					LoginInfo.getUserName(), LoginInfo.getPassword());

			// STEP 4: Executing a query
			System.out.println("Creating statement");
			stmt = conn.createStatement();
			// String sql;
			String sql = "Select * FROM Particuliers WHERE fldNoParticulier = "
					+ noParticulier;

			System.out.println("SQL :" + sql);
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				particulier.setNom(rs.getString("fldNom"));
				particulier.setPrenom(rs.getString("fldPrenom"));
				particulier.setAdresse(rs.getString("fldAdresse"));
				particulier.setTelephone(rs.getString("fldTelephone"));
				particulier.setCodePostal(rs.getString("fldCodePostal"));
				particulier.setEmail(rs.getString("fldEmail"));
				particulier.setVille(rs.getString("fldVille"));
				particulier.setPay(rs.getString("fldPay"));
				particulier.setProvince(rs.getString("fldProvince"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return particulier;
	}
}
