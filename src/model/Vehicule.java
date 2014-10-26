package model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Vehicule {
	private String noSerie;
	private String marque;
	private String modele;
	private int annee;
	private String couleur;
	private String typeVendeur;
	private String dateAchat;
	private String noVendeur;
	private boolean estVendu;
	private BigDecimal prixVente;
	private String typeAcheteur;
	private String noAcheteur;
	private BigDecimal prixAcheteur;
	private String dateVente;
	private boolean aEuEchange;
	private boolean aEuEntretien;
	private String transmission;
	private String noClef;
	private int kilometrage;
	private String cilyndre;
	private String stockNumber;
	private String Cheque;
	private BigDecimal prixClient;
	private boolean venteAvecContrat;

	public Vehicule() {

	}

	public Vehicule(String noSerie, String marque, String modele, int annee,
			String couleur, String typeVendeur, String dateAchat,
			String noVendeur, boolean estVendu, BigDecimal prixVente,
			String typeAcheteur, String noAcheteur, BigDecimal prixAcheteur,
			String dateVente, boolean aEuEchange, boolean aEuEntretien,
			String transmission, String noClef, int kilometrage,
			String cilyndre, String stockNumber, String cheque,
			BigDecimal prixClient, boolean venteAvecContrat) {
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
	
	

	public String getNoSerie() {
		return noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getTypeVendeur() {
		return typeVendeur;
	}

	public void setTypeVendeur(String typeVendeur) {
		this.typeVendeur = typeVendeur;
	}

	public String getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getNoVendeur() {
		return noVendeur;
	}

	public void setNoVendeur(String noVendeur) {
		this.noVendeur = noVendeur;
	}

	public boolean isEstVendu() {
		return estVendu;
	}

	public void setEstVendu(boolean estVendu) {
		this.estVendu = estVendu;
	}

	public BigDecimal getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(BigDecimal prixVente) {
		this.prixVente = prixVente;
	}

	public String getTypeAcheteur() {
		return typeAcheteur;
	}

	public void setTypeAcheteur(String typeAcheteur) {
		this.typeAcheteur = typeAcheteur;
	}

	public String getNoAcheteur() {
		return noAcheteur;
	}

	public void setNoAcheteur(String noAcheteur) {
		this.noAcheteur = noAcheteur;
	}

	public BigDecimal getPrixAcheteur() {
		return prixAcheteur;
	}

	public void setPrixAcheteur(BigDecimal prixAcheteur) {
		this.prixAcheteur = prixAcheteur;
	}

	public String getDateVente() {
		return dateVente;
	}

	public void setDateVente(String dateVente) {
		this.dateVente = dateVente;
	}

	public boolean isaEuEchange() {
		return aEuEchange;
	}

	public void setaEuEchange(boolean aEuEchange) {
		this.aEuEchange = aEuEchange;
	}

	public boolean isaEuEntretien() {
		return aEuEntretien;
	}

	public void setaEuEntretien(boolean aEuEntretien) {
		this.aEuEntretien = aEuEntretien;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getNoClef() {
		return noClef;
	}

	public void setNoClef(String noClef) {
		this.noClef = noClef;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getCilyndre() {
		return cilyndre;
	}

	public void setCilyndre(String cilyndre) {
		this.cilyndre = cilyndre;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getCheque() {
		return Cheque;
	}

	public void setCheque(String cheque) {
		Cheque = cheque;
	}

	public BigDecimal getPrixClient() {
		return prixClient;
	}

	public void setPrixClient(BigDecimal prixClient) {
		this.prixClient = prixClient;
	}

	public boolean isVenteAvecContrat() {
		return venteAvecContrat;
	}

	public void setVenteAvecContrat(boolean venteAvecContrat) {
		this.venteAvecContrat = venteAvecContrat;
	}

	public static ObservableList<Vehicule> listAllVehicule() throws SQLException {
		ObservableList<Vehicule> vehicules = FXCollections.observableArrayList();

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
				Vehicule vehicule = new Vehicule();
				
				// Retrieve by column name
				String noSerie = rs.getString("fldNoSerie");
				vehicule.setNoSerie(noSerie);
				String marque = rs.getString("fldMarque");
				vehicule.setMarque(marque);
				String modele = rs.getString("fldModele");
				vehicule.setModele(modele);
				int annee = rs.getInt("fldAnnee");
				vehicule.setAnnee(annee);
				String couleur = rs.getString("fldNoPeinture");
				vehicule.setCouleur(couleur);
				String typeVendeur = rs.getString("fldTypeVendeur");
				vehicule.setTypeVendeur(typeVendeur);
				String dateAchat = rs.getString("fldDateAchat");
				vehicule.setDateAchat(dateAchat);
				String noVendeur = rs.getString("fldNovendeur");
				vehicule.setNoVendeur(noVendeur);
				boolean estVendu = rs.getBoolean("fldVente");
				vehicule.setEstVendu(estVendu);
				BigDecimal prixVente = rs.getBigDecimal("fldPrixVente");
				vehicule.setPrixVente(prixVente);
				String typeAcheteur = rs.getString("fldTypeAcheteur");
				vehicule.setTypeAcheteur(typeAcheteur);
				String noAcheteur = rs.getString("fldNoAcheteur");
				vehicule.setNoAcheteur(noAcheteur);
				BigDecimal prixAchat = rs.getBigDecimal("fldPrixAchat");
				vehicule.setPrixAcheteur(prixAchat);
				String dateVente = rs.getString("fldDateVente");
				vehicule.setDateVente(dateVente);
				boolean aEuEchange = rs.getBoolean("fldEchange");
				vehicule.setaEuEchange(aEuEchange);
				boolean aEuEntretien = rs.getBoolean("fldEntretien");
				vehicule.setaEuEntretien(aEuEntretien);
				String transmission = rs.getString("fldTransmission");
				vehicule.setTransmission(transmission);
				String noClef = rs.getString("fldNoClef");
				vehicule.setNoClef(noClef);
				int kilometrage = rs.getInt("fldKilometrage");
				vehicule.setKilometrage(kilometrage);
				String cylindre = rs.getString("fldCylindre");
				vehicule.setCilyndre(cylindre);
				String stockNumber = rs.getString("fldStockNumber");
				vehicule.setStockNumber(stockNumber);
				String cheque = rs.getString("fldCheque");
				vehicule.setCheque(cheque);
				BigDecimal prixClient = rs.getBigDecimal("fldPrixClient");
				vehicule.setPrixClient(prixClient);
				boolean venteAvecContrat = rs.getBoolean("fldVenteAvecContrat");
				vehicule.setVenteAvecContrat(venteAvecContrat);

				vehicules.add(vehicule);
				
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
		return vehicules;

		

	}

}
