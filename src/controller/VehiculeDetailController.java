package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
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
			String sql = "SELECT * FROM Entretiens WHERE fldNoStock='"
					+ VehiculeToBeModified.getStockNumber() + "'";
			listeEntretiensVehicule = Entretien.listeDeEtretien(sql);
			fillEntretienTable(listeEntretiensVehicule);
			BigDecimal test = Entretien
					.getTotalEntretientVehicule(VehiculeToBeModified
							.getStockNumber());
			totalEntretienLabel.setText("Total : "
					+ CommonFunctions.displayCurrency(test) + " ");

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
		prixAchatTextField.setText(CommonFunctions
				.displayCurrency(VehiculeToBeModified.getPrixAcheteur()));
		if (VehiculeToBeModified.isEstVendu() == true) {
			prixVenteTextField.setText(CommonFunctions
					.displayCurrency(VehiculeToBeModified.getPrixVente()));
		}
		double prixAvecEntretiens;
		double prixEntretiens = Entretien.getTotalEntretientVehicule(
				VehiculeToBeModified.getStockNumber()).doubleValue();

		prixAvecEntretiens = VehiculeToBeModified.getPrixAcheteur()
				.doubleValue() + prixEntretiens;
		prixEntretiensTextField.setText(CommonFunctions
				.displayCurrency(prixAvecEntretiens));
		if (VehiculeToBeModified.isEstVendu() == true) {
			double profitPerte = VehiculeToBeModified.getPrixVente()
					.doubleValue() - prixAvecEntretiens;
			profitPerteTextField.setText(CommonFunctions
					.displayCurrency(profitPerte));
		}
	}

	public void fillEntretienTable(ObservableList<Entretien> listeEntretiens) {
		System.out.println("Nombre d'éléments :" + listeEntretiens.size());
		try {
			dateEntretienCol
					.setCellValueFactory(new PropertyValueFactory<Entretien, Date>(
							"date"));
			detaillantCol
					.setCellValueFactory(new PropertyValueFactory<Entretien, String>(
							"nomSousContractant"));
			descriptionCol
					.setCellValueFactory(new PropertyValueFactory<Entretien, String>(
							"description"));
			FormattedTableCellFactory<Entretien, String> pp = new FormattedTableCellFactory<Entretien, String>();
			pp.setAlignment(TextAlignment.RIGHT);
			noFactureCol.setCellFactory(pp);
			noFactureCol
					.setCellValueFactory(new PropertyValueFactory<Entretien, String>(
							"noFacture"));
			prixCol.setCellValueFactory(new PropertyValueFactory<Entretien, BigDecimal>(
					"cout"));
			prixCol.setCellFactory(new Callback<TableColumn<Entretien, BigDecimal>, TableCell<Entretien, BigDecimal>>() {

				@Override
				public TableCell call(TableColumn p) {
					TableCell cell = new TableCell<Entretien, BigDecimal>() {
						@Override
						public void updateItem(BigDecimal item, boolean empty) {
							super.updateItem(item, empty);
							setText(empty ? null : getString());
							setGraphic(null);
						}

						private String getString() {
							String ret = "";
							if (getItem() != null) {
								String gi = getItem().toString();
								NumberFormat df = DecimalFormat.getInstance();
								df.setMinimumFractionDigits(2);
								df.setRoundingMode(RoundingMode.DOWN);

								ret = df.format(Double.parseDouble(gi));
							} else {
								ret = "0.00";
							}
							return ret;
						}
					};

					cell.setStyle("-fx-alignment: center-right;");
					// cell.getStyleClass().add(("-fx-alignment: center-right;"));
					// cell.getStyleClass().add(("-fx-padding: 5px;"));
					return cell;
				}
			});

			tableEntretien.setItems(listeEntretiens);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

}
