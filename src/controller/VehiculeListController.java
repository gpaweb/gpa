package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.vehicule.Vehicule;
import model.vehicule.VehiculeToBeModified;

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
	private TextField NoStockTextField;
	@FXML
	private TextField NoSerieTextField;
	@FXML
	private TextField AnneeFabTextField;
	@FXML
	private TextField MarqueTextField;
	@FXML
	private TextField ModeleTextField;
	@FXML
	private ComboBox EstVenduCombo;
	@FXML
	private TextField CouleurTextField;
	@FXML
	private TextField NoImmatricTextField;
	@FXML
	private ComboBox TransmissionCombo;
	@FXML
	private TextField KilometrageDeTextField;
	@FXML
	private TextField KilometrageATextField;
	@FXML
	private Label acheterDeLabel;
	@FXML
	private DatePicker acheterDeDatePicker;
	@FXML
	private Label acheterALabel;
	@FXML
	private DatePicker acheterADatePicker;
	@FXML
	private Label venduDeLabel;
	@FXML
	private DatePicker venduDeDatePicker;
	@FXML
	private Label venduALabel;
	@FXML
	private DatePicker venduADatePicker;
	
	@FXML
	private HBox AddVehiculeHBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				NoStockTextField.requestFocus();
				setupListeners();
			}
		});

		tableVehicule.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener() {

					@Override
					public void changed(ObservableValue observable,
							Object oldValue, Object newValue) {
						Vehicule selectedVehicule = (Vehicule) newValue;
						try {
							VehiculeToBeModified
									.setStockNumber(selectedVehicule
											.getStockNumber());
							VehiculeToBeModified.setNoSerie(selectedVehicule
									.getNoSerie());
							VehiculeToBeModified.setMarque(selectedVehicule
									.getMarque());
							VehiculeToBeModified.setModele(selectedVehicule
									.getModele());
							VehiculeToBeModified.setAnnee(selectedVehicule
									.getAnnee());
							VehiculeToBeModified.setCouleur(selectedVehicule
									.getCouleur());
							VehiculeToBeModified
									.setTypeVendeur(selectedVehicule
											.getTypeVendeur());
							VehiculeToBeModified.setDateAchat(selectedVehicule
									.getDateAchat());
							VehiculeToBeModified.setNoVendeur(selectedVehicule
									.getNoVendeur());
							VehiculeToBeModified.setEstVendu(selectedVehicule
									.isEstVendu());
							VehiculeToBeModified.setPrixVente(selectedVehicule
									.getPrixVente());
							VehiculeToBeModified
									.setTypeAcheteur(selectedVehicule
											.getTypeAcheteur());
							VehiculeToBeModified.setNoAcheteur(selectedVehicule
									.getNoAcheteur());
							VehiculeToBeModified
									.setPrixAcheteur(selectedVehicule
											.getPrixAcheteur());
							VehiculeToBeModified.setDateVente(selectedVehicule
									.getDateVente());
							VehiculeToBeModified.setaEuEchange(selectedVehicule
									.isaEuEchange());
							VehiculeToBeModified
									.setaEuEntretien(selectedVehicule
											.isaEuEntretien());
							VehiculeToBeModified
									.setTransmission(selectedVehicule
											.getTransmission());
							VehiculeToBeModified.setNoClef(selectedVehicule
									.getNoClef());
							VehiculeToBeModified
									.setKilometrage(selectedVehicule
											.getKilometrage());
							VehiculeToBeModified.setCilyndre(selectedVehicule
									.getCilyndre());
							VehiculeToBeModified.setCheque(selectedVehicule
									.getCheque());
							VehiculeToBeModified.setPrixClient(selectedVehicule
									.getPrixClient());
							VehiculeToBeModified
									.setVenteAvecContrat(selectedVehicule
											.isVenteAvecContrat());
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				});

		tableVehicule.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)
						&& event.getClickCount() == 2) {
					// TODO Auto-generated method stub
					try {
						Stage stage = new Stage();
						Parent root;

						root = FXMLLoader.load(VehiculeDetailController.class
								.getResource("/fxml/VehiculeDetails.fxml"));
						stage.setScene(new Scene(root));
						stage.setTitle("Modification du véhicule");
						stage.initModality(Modality.APPLICATION_MODAL);
						stage.initOwner(((Node) event.getSource()).getScene()
								.getWindow());
						stage.show();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		AddVehiculeHBox.setOnMousePressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				try {
					Stage stage = new Stage();
					Parent root;

					root = FXMLLoader.load(VehiculeDetailController.class
							.getResource("/fxml/VehiculeDetails.fxml"));
					stage.setScene(new Scene(root));
					stage.setTitle("Ajout de véhicule");
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(((Node) event.getSource()).getScene()
							.getWindow());
					stage.show();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	//	TransmissionCombo.getItems().addAll("Tous", "Automatique", "Manuelle");
	//	TransmissionCombo.setValue("Tous");

		EstVenduCombo.getItems().addAll("Tous", "Oui", "Non");
		EstVenduCombo.setValue("Tous");
		try {
			listAllVehicule = Vehicule.listeDeVehicule("");
			fillVehiculeTable(listAllVehicule);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void clickShow(ActionEvent event) {
		Stage stage = new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(VehiculeDetailController.class
					.getResource("VehiculeDetails.fxml"));
			stage.setScene(new Scene(root));
			stage.setTitle("My modal window");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(((Node) event.getSource()).getScene().getWindow());
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void RechercheChange() {
		try {
			listAllVehicule = Vehicule
					.listeDeVehicule(createSQLRequestForVehicule());
			fillVehiculeTable(listAllVehicule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setFocusNoStock() {
		NoStockTextField.requestFocus();
	}

	public void setFocuNoSerie() {
		NoSerieTextField.requestFocus();
	}

	public void setFocusAnneeFab() {
		AnneeFabTextField.requestFocus();
	}

	public void setFocusMarque() {
		MarqueTextField.requestFocus();
	}

	public void setFocusModele() {
		ModeleTextField.requestFocus();
	}

	public void setFocusEstVendu() {
		EstVenduCombo.requestFocus();
	}

	public void setFocusCouleur() {
		CouleurTextField.requestFocus();
	}

	public void setFocusNoImmatriculation() {
		NoImmatricTextField.requestFocus();
	}

	public void setFocusTransmission() {
		TransmissionCombo.requestFocus();
	}

	public void setFocusKilometrageDe() {
		KilometrageDeTextField.requestFocus();
	}

	public void setFocusKilometrageA() {
		KilometrageATextField.requestFocus();
	}
	
	public void setFocusAcheterDe(){
		acheterDeDatePicker.requestFocus();
	}
	
	public void setFocusAcheterA(){
		acheterADatePicker.requestFocus();
	}
	
	public void setFocusVenduDe(){
		venduDeDatePicker.requestFocus();
	}
	
	public void setFocusVenduA(){
		venduADatePicker.requestFocus();
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
			System.out.println(e.getStackTrace());
		}

	}

	public String createSQLRequestForVehicule() {
		String sqlRq = "SELECT * FROM Vehicules";
		boolean premierElementRencontre = false;

		if (!NoStockTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldStockNumber LIKE '%"
						+ NoStockTextField.getText() + "%'";
			} else {
				sqlRq += " AND fldStockNumber LIKE '%"
						+ NoStockTextField.getText() + "%'";
			}
		}

		if (!NoSerieTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldNoSerie LIKE '%"
						+ NoSerieTextField.getText() + "%'";
			} else {
				sqlRq += " AND fldNoSerie LIKE '%" + NoSerieTextField.getText()
						+ "%'";
			}
		}

		if (!AnneeFabTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldAnnee LIKE '%"
						+ AnneeFabTextField.getText() + "%'";
			} else {
				sqlRq += " AND fldAnnee LIKE '%" + AnneeFabTextField.getText()
						+ "%'";
			}
		}

		if (!MarqueTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldMarque LIKE '%" + MarqueTextField.getText()
						+ "%'";
			} else {
				sqlRq += " AND fldMarque LIKE '%" + MarqueTextField.getText()
						+ "%'";
			}
		}

		if (!ModeleTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldModele LIKE '%" + ModeleTextField.getText()
						+ "%'";
			} else {
				sqlRq += " AND fldModele LIKE '%" + ModeleTextField.getText()
						+ "%'";
			}
		}
		if (!EstVenduCombo.getValue().equals("Tous")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				switch (EstVenduCombo.getValue().toString()) {
				case "Oui":
					sqlRq += " WHERE fldVente = 1";
					break;
				case "Non":
					sqlRq += " WHERE fldVente = 0";
					break;
				}

			} else {
				switch (EstVenduCombo.getValue().toString()) {
				case "Oui":
					sqlRq += " AND fldVente = 1";
					break;
				case "Non":
					sqlRq += " AND fldVente = 0";
					break;
				}
			}
		}

		if (!CouleurTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldNoPeinture LIKE '%"
						+ CouleurTextField.getText() + "%'";
			} else {
				sqlRq += " AND fldNoPeinture LIKE '%"
						+ CouleurTextField.getText() + "%'";
			}
		}
		// À compléter, je ne trouve pas le champ dans la BD
		if (!NoImmatricTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += "";
			} else {
				sqlRq += "";
			}
		}

		if (!TransmissionCombo.getValue().equals("Tous")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldTransmission LIKE '%"
						+ TransmissionCombo.getValue() + "%'";
			} else {
				sqlRq += " AND fldTransmission LIKE '%"
						+ TransmissionCombo.getValue() + "%'";
			}
		}

		if (!KilometrageDeTextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldKilometrage >="
						+ KilometrageDeTextField.getText();
			} else {
				sqlRq += " AND fldKilometrage >="
						+ KilometrageDeTextField.getText();
			}
		}

		if (!KilometrageATextField.getText().equals("")) {
			if (premierElementRencontre == false) {
				premierElementRencontre = true;
				sqlRq += " WHERE fldKilometrage <= "
						+ KilometrageATextField.getText();
			} else {
				sqlRq += " AND fldKilometrage <="
						+ KilometrageATextField.getText();
			}
		}
		return sqlRq;

	}

	public void setupListeners() {

		NoStockTextField.textProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

		NoSerieTextField.textProperty().addListener(
				new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

		AnneeFabTextField.textProperty().addListener(
				new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

		MarqueTextField.textProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

		ModeleTextField.textProperty().addListener(
				new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

		EstVenduCombo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						RechercheChange();
					}
				});

			}
		});

		CouleurTextField.textProperty().addListener(
				new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

		NoImmatricTextField.textProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

	/*	TransmissionCombo.valueProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						RechercheChange();
					}
				});
*/
		KilometrageDeTextField.textProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});

		KilometrageATextField.textProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						if (newValue != oldValue) {
							RechercheChange();
						}
					}
				});
	}

}
