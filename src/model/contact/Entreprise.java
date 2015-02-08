package model.contact;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Database;
import model.LoginInfo;
import model.entretien.Entretien;

public class Entreprise extends Intervenants {
	private String contact;

	public Entreprise() {
		super();
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public static Entreprise getEntreprise(String noEntreprise) {
		Entreprise entreprise = new Entreprise();

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
			
			String sql;
			if (noEntreprise != "") {
				sql = "Select * FROM Entreprises WHERE fldNoEntreprise = "
						+ noEntreprise;
			} else {
				sql = "Select * FROM Entreprises";
			}

			System.out.println("SQL :" + sql);
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				entreprise.setNom(rs.getString("fldNom"));
				entreprise.setAdresse(rs.getString("fldAdresse"));
				entreprise.setTelephone(rs.getString("fldTelephone"));
				entreprise.setCodePostal(rs.getString("fldCodePostal"));
				entreprise.setEmail(rs.getString("fldEmail"));
				entreprise.setContact(rs.getString("fldContact"));
				entreprise.setVille(rs.getString("fldVille"));
				entreprise.setPay(rs.getString("fldPay"));
				entreprise.setProvince(rs.getString("fldProvince"));
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

		return entreprise;
	}

}
