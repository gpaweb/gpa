package model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Vehicule {
	private String noSerie;
	private String marque;
	private String modele;
	private String annee;
	private String couleur;
	private String typeVendeur;
	private Date dateAchat;
	private String noVendeur;
	private boolean estVendu;
	private Currency prixVente;
	private String typeAcheteur;
	private String noAcheteur;
	private Currency prixAcheteur;
	private Date dateVente;
	private boolean aEuEchange;
	private boolean aEuEntretien;
	private String transmission;
	private String noClef;
	private long kilometrage;
	private String cilyndre;
	private String stockNumber;
	private String Cheque;
	private Currency prixClient;
	private boolean venteAvecContrat;

	public Vehicule(String noSerie, String marque, String modele, String annee,
			String couleur, String typeVendeur, Date dateAchat,
			String noVendeur, boolean estVendu, Currency prixVente,
			String typeAcheteur, String noAcheteur, Currency prixAcheteur,
			Date dateVente, boolean aEuEchange, boolean aEuEntretien,
			String transmission, String noClef, long kilometrage,
			String cilyndre, String stockNumber, String cheque,
			Currency prixClient, boolean venteAvecContrat) {
		this.noSerie = noSerie;
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.couleur = couleur;
		this.typeVendeur = typeVendeur;
		this.dateAchat = dateAchat;
		this.noVendeur = noVendeur;
		this.estVendu = estVendu;
		this.prixVente = prixVente;
		this.typeAcheteur = typeAcheteur;
		this.noAcheteur = noAcheteur;
		this.prixAcheteur = prixAcheteur;
		this.dateVente = dateVente;
		this.aEuEchange = aEuEchange;
		this.aEuEntretien = aEuEntretien;
		this.transmission = transmission;
		this.noClef = noClef;
		this.kilometrage = kilometrage;
		this.cilyndre = cilyndre;
		this.stockNumber = stockNumber;
		Cheque = cheque;
		this.prixClient = prixClient;
		this.venteAvecContrat = venteAvecContrat;
	}

	public static List<Vehicule> listAllVehicule() {
		List<Vehicule> vehiculeList = new ArrayList<Vehicule>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// JDBC driver name and database URL
		final String driver = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://localhost/gpa2k15";
		// Database credentials
		final String dbName = "gpa2k15";
		final String userName = "root";
		final String dbPassword = "passwd12";

		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName(driver);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, userName, dbPassword);

			// STEP 4: Executing a query
			System.out.println("Creating statement");
			stmt = conn.createStatement();
			String sql;
			sql = "Select * FROM Vehicules";
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String noSerie = rs.getString("fldNoSerie");
				String marque = rs.getString("fldMarque");
				String modele = rs.getString("fldModele");
				int annee = rs.getInt("fldAnnee");
				String couleur = rs.getString("fldNoPeinture");
				String typeVendeur = rs.getString("fldTypeVendeur");
				String dateAchat = rs.getString("fldDateAchat");
				String noVendeur = rs.getString("fldNovendeur");
				boolean estVendu = rs.getBoolean("fldVente");
				BigDecimal prixVente = rs.getBigDecimal("fldPrixVente");
				String typeAcheteur = rs.getString("fldTypeAcheteur");
				String noAcheteur = rs.getString("fldNoAcheteur");
				BigDecimal prixAchat = rs.getBigDecimal("fldPrixAchat");
				String dateVente = rs.getString("fldDateVente");
				boolean aEuEchange = rs.getBoolean("fldEchange");
				boolean aEuEntretien = rs.getBoolean("fldEntretien");
				String transmission = rs.getString("fldTransmission");
				String noClef = rs.getString("fldNoClef");
				int kilometrage = rs.getInt("fldKilometrage");
				String cylindre = rs.getString("fldCylindre");
				String stockNumber = rs.getString("fldStockNumber");
				String cheque = rs.getString("fldCheque");
				BigDecimal prixClient = rs.getBigDecimal("fldPrixClient");
				boolean venteAvecContrat = rs.getBoolean("fldVenteAvecContrat");

				System.out.println(marque+" : "+dateAchat);
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
			
			if(stmt!=null){try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}

			if(conn!=null){try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}

		return vehiculeList;

	}

}
