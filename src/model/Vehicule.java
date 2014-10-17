package model;

import java.util.Currency;
import java.util.Date;

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
		super();
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

}
