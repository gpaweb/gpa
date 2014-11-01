package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Vehicule;

public class VehiculeListController implements Initializable {

	@FXML
	private TableView<Vehicule> tableVehicule;
	@FXML
	private TableColumn<Vehicule, String> noStockCol;
	@FXML
	private TableColumn<Vehicule, String> noSerieCol;
	@FXML
	private TableColumn<Vehicule, Integer> anneeCol;
	@FXML
	private TableColumn<Vehicule, String> marqueCol;
	@FXML
	private TableColumn<Vehicule, String> modeleCol;
	@FXML
	private TableColumn<Vehicule, String> couleurCol;
	@FXML
	private TableColumn<Vehicule, String> transmissionCol;
	@FXML
	private TableColumn<Vehicule, Integer> kilometrageCol;

	private ObservableList<Vehicule> listAllVehicule;

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
	private ToggleButton estVenduToggle;
	@FXML
	private TextField couleurTextField;
	@FXML
	private TextField noImmatricTextField;
	@FXML
	private ComboBox transmissionCombo;
	@FXML
	private TextField cilyndreTextField;
	@FXML
	private TextField kilometrageDeTextField;
	@FXML
	private TextField kilometrageATextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			listAllVehicule = Vehicule.listeDeVehicule("");
			fillVehiculeTable(listAllVehicule);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void marqueChange() {
		try {
			listAllVehicule = Vehicule
					.listeDeVehicule("Select * FROM Vehicules WHERE fldMarque LIKE '%"
							+ marqueTextField.getText() + "%'");
			fillVehiculeTable(listAllVehicule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void EstVenduClick() {
		if (estVenduToggle.getText() == "Oui") {
			estVenduToggle.setText("Non");
		} else {
			estVenduToggle.setText("Oui");
		}
	}

	@FXML
	public void fillVehiculeTable(ObservableList<Vehicule> listeVehicule) {

		/*
		 * assert tableVehicule != null :
		 * "fx:id=\"tableVehicule\" was not injected: check your FXML file 'Véhiculelist.fxml'."
		 * ;
		 */
		System.out.println("Nombre d'éléments :" + listeVehicule.size());
		try {
			noStockCol
					.setCellValueFactory(new PropertyValueFactory<Vehicule, String>(
							"stockNumber"));
			noSerieCol
					.setCellValueFactory(new PropertyValueFactory<Vehicule, String>(
							"noSerie"));
			anneeCol.setCellValueFactory(new PropertyValueFactory<Vehicule, Integer>(
					"annee"));
			marqueCol
					.setCellValueFactory(new PropertyValueFactory<Vehicule, String>(
							"marque"));
			modeleCol
					.setCellValueFactory(new PropertyValueFactory<Vehicule, String>(
							"modele"));
			couleurCol
					.setCellValueFactory(new PropertyValueFactory<Vehicule, String>(
							"couleur"));
			transmissionCol
					.setCellValueFactory(new PropertyValueFactory<Vehicule, String>(
							"transmission"));
			kilometrageCol
					.setCellValueFactory(new PropertyValueFactory<Vehicule, Integer>(
							"kilometrage"));
			tableVehicule.setItems(listeVehicule);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}

	}

	public String createSQLRequestForVehicule() {
		String sqlRq = "SELECT * FROM Vehicules";
		boolean premierElementRencontre = false;

		if (noStockTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldStockNumber LIKE '%"
						+ noStockTextField.getText() + "%'";
			} else {
				sqlRq += " AND fldStockNumber LIKE '%"
						+ noStockTextField.getText() + "%'";
			}
		}

		if (noSerieTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldNoSerie LIKE '%"
						+ noSerieTextField.getText() + "%'";
			} else {
				sqlRq += " AND fldNoSerie LIKE '%" + noSerieTextField.getText()
						+ "%'";
			}
		}

		if (anneeFabTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += "WHERE fldAnnee LIKE '%" + anneeFabTextField.getText()
						+ "%'";
			} else {
				sqlRq += "AND fldAnnee LIKE '%" + anneeFabTextField.getText()
						+ "%'";
			}
		}

		if (marqueTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += "WHERE fldMarque LIKE '%" + marqueTextField.getText()
						+ "%'";
			} else {
				sqlRq += "AND fldMarque LIKE '%" + marqueTextField.getText()
						+ "%'";
			}
		}

		if (modeleTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += "WHERE fldModele LIKE '%" + modeleTextField.getText()
						+ "%'";
			} else {
				sqlRq += "AND fldModele LIKE '%" + modeleTextField.getText()
						+ "%'";
			}
		}

		if (estVenduToggle.getText() == "Oui") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldVente = 1";
			} else {
				sqlRq += " AND fldVente = 1";
			}
		} else {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldVente = 0";
			} else {
				sqlRq += " AND fldVente = 0";
			}
		}

		if (couleurTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldNoPeinture LIKE '%"
						+ couleurTextField.getText() + "%'";
			} else {
				sqlRq += " AND fldNoPeinture LIKE '%"
						+ couleurTextField.getText() + "%'";
			}
		}
		// À compléter, je ne trouve pas le champ dans la BD
		if (noImmatricTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += "";
			} else {
				sqlRq += "";
			}
		}

		if (transmissionCombo.getValue() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += "";
			} else {
				sqlRq += "";
			}
		}

		if (cilyndreTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += "";
			} else {
				sqlRq += "";
			}
		}

		if (kilometrageDeTextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldKilometrage >="
						+ kilometrageDeTextField.getText();
			} else {
				sqlRq += " AND fldKilometrage >="
						+ kilometrageDeTextField.getText();
			}
		}

		if (kilometrageATextField.getText() != "") {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldKilometrage <= "
						+ kilometrageATextField.getText();
			} else {
				sqlRq += " WHERE fldKilometrage <="
						+ kilometrageATextField.getText();
			}
		}
		return sqlRq;

	}

}
