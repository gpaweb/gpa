package model.entretien;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Database;
import model.LoginInfo;

public class Entretien {
	private String description;
	private Date date;
	private BigDecimal cout;
	private String nomSousContractant;
	private String noSerieVehicule;
	private String noStockVehicule;
	private String noFacture;

	public Entretien() {

	}

	public Entretien(String description, Date date, BigDecimal cout,
			String nomSousContractant, String noSerieVehicule,
			String noStockVehicule, String noFacture) {
		this.description = description;
		this.date = date;
		this.cout = cout;
		this.nomSousContractant = nomSousContractant;
		this.noSerieVehicule = noSerieVehicule;
		this.noStockVehicule = noStockVehicule;
		this.noFacture = noFacture;
	}

	public String getType() {
		return description;
	}

	public void setType(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getCout() {
		return cout;
	}

	public void setCout(BigDecimal cout) {
		this.cout = cout;
	}

	public String getNomSousContractant() {
		return nomSousContractant;
	}

	public void setNomSousContractant(String nomSousContractant) {
		this.nomSousContractant = nomSousContractant;
	}

	public String getNoSerieVehicule() {
		return noSerieVehicule;
	}

	public void setNoSerieVehicule(String noSerieVehicule) {
		this.noSerieVehicule = noSerieVehicule;
	}

	public String getNoStockVehicule() {
		return noStockVehicule;
	}

	public void setNoStockVehicule(String noStockVehicule) {
		this.noStockVehicule = noStockVehicule;
	}

	public String getNoFacture() {
		return noFacture;
	}

	public void setNoFacture(String noFacture) {
		this.noFacture = noFacture;
	}
	
	public static BigDecimal getTotalEntretientVehicule(String noStock){
		//BigDecimal totalEntretien = new BigDecimal(0.00);
		double totalEntretien = 0;
		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
			// STEP 2: Register JDBC driver
						Class.forName(Database.getDriver());

						// STEP 3: Open a connection
						System.out.println("Connecting to database...");
						
						conn = DriverManager.getConnection(Database.getUrl(), LoginInfo.getUserName(), LoginInfo.getPassword());

						// STEP 4: Executing a query
						System.out.println("Creating statement");
						stmt = conn.createStatement();
						String sql;
						sql = "Select * FROM Entretiens WHERE fldNoStock='"+noStock+"'"; 
						System.out.println("SQL :"+sql);
						rs = stmt.executeQuery(sql);

						// STEP 5: Extract data from result set
						while (rs.next()){
							totalEntretien = totalEntretien + rs.getBigDecimal("fldPrix").doubleValue();
						}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {

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

		BigDecimal total = new BigDecimal(totalEntretien);
		return total;
		
	}

	public static ObservableList<Entretien> listeDeEtretien(String sql) throws SQLException {
		ObservableList<Entretien> entretiens = FXCollections.observableArrayList();
		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try{
			// STEP 2: Register JDBC driver
			Class.forName(Database.getDriver());

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			
			conn = DriverManager.getConnection(Database.getUrl(), LoginInfo.getUserName(), LoginInfo.getPassword());

			// STEP 4: Executing a query
			System.out.println("Creating statement");
			stmt = conn.createStatement();
			//String sql;
			if(sql==""){ sql = "Select * FROM Entretiens"; }
			
			System.out.println("SQL :"+sql);
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()){
				Entretien entretien = new Entretien();
				
				// Retrieve by column name
				String description = rs.getString("fldTypeEntretient");
				entretien.setType(description);
				Date date = rs.getDate("fldDateEffectue");
				entretien.setDate(date);
				BigDecimal cout = rs.getBigDecimal("fldPrix");
				entretien.setCout(cout);
				String nomSousContractant = rs.getString("fldNomSousContractant");
				entretien.setNomSousContractant(nomSousContractant);
				String noSerieVehicule = rs.getString("fldNoSerie");
				entretien.setNoSerieVehicule(noSerieVehicule);
				String noStockVehicule = rs.getString("fldNoStock");
				entretien.setNoStockVehicule(noStockVehicule);
				String noFacture = rs.getString("fldNoFacture");
				entretien.setNoFacture(noFacture);
				
				entretiens.add(entretien);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {

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
		
		return entretiens;
		
	}
}
