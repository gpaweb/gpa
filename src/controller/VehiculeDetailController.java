package controller;

import java.io.NotSerializableException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.VehiculeToBeModified;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(VehiculeToBeModified.toText());
		estVenduCombo.getItems().addAll("Oui", "Non");
		setFieldsWithVehiculeData();
	}

	public void setFieldsWithVehiculeData() {
		StringBuilder anneeFab = new StringBuilder();
		anneeFab.append(VehiculeToBeModified.getAnnee());
		String annee = anneeFab.toString();

		StringBuilder kilo = new StringBuilder();
		kilo.append(VehiculeToBeModified.getKilometrage());
		String kilometrage = kilo.toString();

		noStockTextField.setText(VehiculeToBeModified.getStockNumber());
		noSerieTextField.setText(VehiculeToBeModified.getNoSerie());
		anneeFabTextField.setText(annee);
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
	}

}
