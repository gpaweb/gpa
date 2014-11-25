package controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CommonFunctions;
import model.entretien.Entretien;
import model.vehicule.VehiculeToBeModified;

public class VehiculeDetailController implements Initializable {
	@FXML
	private TableView<Entretien> tableEntretien;
	@FXML
	private TableColumn<Entretien, Date> dateEntretienCol;
	@FXML
	private TableColumn<Entretien, String> detaillantCol;
	@FXML
	private TableColumn<Entretien, String> descriptionCol;
	@FXML
	private TableColumn<Entretien, String> noFactureCol;
	@FXML
	private TableColumn<Entretien, BigDecimal> prixCol;
	private ObservableList<Entretien> listeEntretiensVehicule;
	
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
	@FXML
	private Label totalEntretienLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(VehiculeToBeModified.toText());
		estVenduCombo.getItems().addAll("Oui", "Non");
		setFieldsWithVehiculeData();
		
		try {
			String sql = "SELECT * FROM Entretiens WHERE fldNoStock='"+VehiculeToBeModified.getStockNumber()+"'";
			listeEntretiensVehicule = Entretien.listeDeEtretien(sql);
			fillEntretienTable(listeEntretiensVehicule);
			BigDecimal test = Entretien.getTotalEntretientVehicule(VehiculeToBeModified.getStockNumber());
			totalEntretienLabel.setText("Total : "+CommonFunctions.displayCurrency(test)+" ");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	
	public void fillEntretienTable(ObservableList<Entretien> listeEntretiens){
		System.out.println("Nombre d'éléments :" + listeEntretiens.size());
		try {
			dateEntretienCol.setCellValueFactory(new PropertyValueFactory<Entretien, Date>("date"));
			detaillantCol.setCellValueFactory(new PropertyValueFactory<Entretien, String>("nomSousContractant"));
			descriptionCol.setCellValueFactory(new PropertyValueFactory<Entretien, String>("description"));
			noFactureCol.setCellValueFactory(new PropertyValueFactory<Entretien, String>("noFacture"));
			prixCol.setCellValueFactory(new PropertyValueFactory<Entretien, BigDecimal>("cout"));
			tableEntretien.setItems(listeEntretiens);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}



}
