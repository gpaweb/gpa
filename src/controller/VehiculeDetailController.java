package controller;

import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.CommonFunctions;
import model.vehicule.VehiculeToBeModified;

public class VehiculeDetailController implements Initializable {
	@FXML
	private TextField noStockTextField;
	@FXML
	private TextField noSerieTextField;
	@FXML
	private TextField anneeFabTextField;
	@FXML
	private TextField marqueTextField;
	@FXML
	private TextField modeleTextField;
	@FXML
	private TextField couleurTextField;
	@FXML
	private TextField noImmatricTextField;
	@FXML
	private TextField cilyndreTextField;
	@FXML
	private TextField kilometrageTextField;
	@FXML
	private ComboBox estVenduCombo;
	@FXML
	private ComboBox transmissionCombo;
	@FXML
	private TextField prixAchatTextField;
	@FXML
	private TextField prixVenteTextField;
	@FXML
	private TextField prixEntretiensTextField;
	@FXML
	private TextField profitPerteTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(VehiculeToBeModified.toText());
		estVenduCombo.getItems().addAll("Oui", "Non");
		setFieldsWithVehiculeData();
	}

	public void setFieldsWithVehiculeData() {
		StringBuilder sbAnneeFab = new StringBuilder();
		sbAnneeFab.append(VehiculeToBeModified.getAnnee());
		String anneeFab = sbAnneeFab.toString();

		StringBuilder sbKilo = new StringBuilder();
		sbKilo.append(VehiculeToBeModified.getKilometrage());
		String kilometrage = sbKilo.toString();

		/*
		 * StringBuilder sbPrixClient = new StringBuilder();
		 * sbPrixClient.append(VehiculeToBeModified.getPrixClient()); String
		 * prixClient = sbPrixClient.toString();
		 */

		noStockTextField.setText(VehiculeToBeModified.getStockNumber());
		noSerieTextField.setText(VehiculeToBeModified.getNoSerie());
		anneeFabTextField.setText(anneeFab);
		marqueTextField.setText(VehiculeToBeModified.getMarque());
		modeleTextField.setText(VehiculeToBeModified.getModele());
		couleurTextField.setText(VehiculeToBeModified.getCouleur());
		noImmatricTextField.setText(VehiculeToBeModified.getNoClef());
		cilyndreTextField.setText(VehiculeToBeModified.getCilyndre());
		kilometrageTextField.setText(kilometrage);
		if (VehiculeToBeModified.isEstVendu() == true) {
			estVenduCombo.setValue("Oui");
		} else {
			estVenduCombo.setValue("Non");
		}
		transmissionCombo.getEditor().setText(
				VehiculeToBeModified.getTransmission());
		prixAchatTextField.setText(CommonFunctions.displayCurrency(VehiculeToBeModified
				.getPrixAcheteur()));
		prixVenteTextField.setText(CommonFunctions.displayCurrency(VehiculeToBeModified.getPrixVente()));

	}



}
