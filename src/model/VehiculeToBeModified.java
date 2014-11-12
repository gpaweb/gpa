package model;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.mysql.jdbc.PreparedStatement;

public final class VehiculeToBeModified {
	private static String noSerie;
	private static String marque;
	private static String modele;
	private static int annee;
	private static String couleur;
	private static String typeVendeur;
	private static Date dateAchat;
	private static String noVendeur;
	private static boolean estVendu;
	private static BigDecimal prixVente;
	private static String typeAcheteur;
	private static String noAcheteur;
	private static BigDecimal prixAcheteur;
	private static Date dateVente;
	private static boolean aEuEchange;
	private static boolean aEuEntretien;
	private static String transmission;
	private static String noClef;
	private static int kilometrage;
	private static String cilyndre;
	private static String stockNumber;
	private static String Cheque;
	private static BigDecimal prixClient;
	private static boolean venteAvecContrat;

	private VehiculeToBeModified() {

	}

	public static String getNoSerie() {
		return noSerie;
	}

	public static void setNoSerie(String noSerie) {
		VehiculeToBeModified.noSerie = noSerie;
	}

	public static String getMarque() {
		return marque;
	}

	public static void setMarque(String marque) {
		VehiculeToBeModified.marque = marque;
	}

	public static String getModele() {
		return modele;
	}

	public static void setModele(String modele) {
		VehiculeToBeModified.modele = modele;
	}

	public static int getAnnee() {
		return annee;
	}

	public static void setAnnee(int annee) {
		VehiculeToBeModified.annee = annee;
	}

	public static String getCouleur() {
		return couleur;
	}

	public static void setCouleur(String couleur) {
		VehiculeToBeModified.couleur = couleur;
	}

	public static String getTypeVendeur() {
		return typeVendeur;
	}

	public static void setTypeVendeur(String typeVendeur) {
		VehiculeToBeModified.typeVendeur = typeVendeur;
	}

	public static Date getDateAchat() {
		return dateAchat;
	}

	public static void setDateAchat(Date dateAchat) {
		VehiculeToBeModified.dateAchat = dateAchat;
	}

	public static String getNoVendeur() {
		return noVendeur;
	}

	public static void setNoVendeur(String noVendeur) {
		VehiculeToBeModified.noVendeur = noVendeur;
	}

	public static boolean isEstVendu() {
		return estVendu;
	}

	public static void setEstVendu(boolean estVendu) {
		VehiculeToBeModified.estVendu = estVendu;
	}

	public static BigDecimal getPrixVente() {
		return prixVente;
	}

	public static void setPrixVente(BigDecimal prixVente) {
		VehiculeToBeModified.prixVente = prixVente;
	}

	public static String getTypeAcheteur() {
		return typeAcheteur;
	}

	public static void setTypeAcheteur(String typeAcheteur) {
		VehiculeToBeModified.typeAcheteur = typeAcheteur;
	}

	public static String getNoAcheteur() {
		return noAcheteur;
	}

	public static void setNoAcheteur(String noAcheteur) {
		VehiculeToBeModified.noAcheteur = noAcheteur;
	}

	public static BigDecimal getPrixAcheteur() {
		return prixAcheteur;
	}

	public static void setPrixAcheteur(BigDecimal prixAcheteur) {
		VehiculeToBeModified.prixAcheteur = prixAcheteur;
	}

	public static Date getDateVente() {
		return dateVente;
	}

	public static void setDateVente(Date dateVente) {
		VehiculeToBeModified.dateVente = dateVente;
	}

	public static boolean isaEuEchange() {
		return aEuEchange;
	}

	public static void setaEuEchange(boolean aEuEchange) {
		VehiculeToBeModified.aEuEchange = aEuEchange;
	}

	public static boolean isaEuEntretien() {
		return aEuEntretien;
	}

	public static void setaEuEntretien(boolean aEuEntretien) {
		VehiculeToBeModified.aEuEntretien = aEuEntretien;
	}

	public static String getTransmission() {
		return transmission;
	}

	public static void setTransmission(String transmission) {
		VehiculeToBeModified.transmission = transmission;
	}

	public static String getNoClef() {
		return noClef;
	}

	public static void setNoClef(String noClef) {
		VehiculeToBeModified.noClef = noClef;
	}

	public static int getKilometrage() {
		return kilometrage;
	}

	public static void setKilometrage(int kilometrage) {
		VehiculeToBeModified.kilometrage = kilometrage;
	}

	public static String getCilyndre() {
		return cilyndre;
	}

	public static void setCilyndre(String cilyndre) {
		VehiculeToBeModified.cilyndre = cilyndre;
	}

	public static String getStockNumber() {
		return stockNumber;
	}

	public static void setStockNumber(String stockNumber) {
		VehiculeToBeModified.stockNumber = stockNumber;
	}

	public static String getCheque() {
		return Cheque;
	}

	public static void setCheque(String cheque) {
		Cheque = cheque;
	}

	public static BigDecimal getPrixClient() {
		return prixClient;
	}

	public static void setPrixClient(BigDecimal prixClient) {
		VehiculeToBeModified.prixClient = prixClient;
	}

	public static boolean isVenteAvecContrat() {
		return venteAvecContrat;
	}

	public static void setVenteAvecContrat(boolean venteAvecContrat) {
		VehiculeToBeModified.venteAvecContrat = venteAvecContrat;
	}
	
	public static String toText(){
		return marque + " "+ modele+" "+noVendeur; 
		
	}

}
