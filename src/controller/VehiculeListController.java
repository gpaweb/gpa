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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DBClass;
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
	private ToggleButton estVenduToggle;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		try {
			listAllVehicule = Vehicule.listAllVehicule();
			fillVehiculeTable(listAllVehicule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	public void EstVenduClick(){
		if(estVenduToggle.getText()=="Oui"){
			estVenduToggle.setText("Non");
		}else{
			estVenduToggle.setText("Oui");
		}
	}
	
	@FXML
	public void fillVehiculeTable(ObservableList<Vehicule> listeVehicule){
		/*assert tableVehicule != null : "fx:id=\"tableVehicule\" was not injected: check your FXML file 'Véhiculelist.fxml'.";
		*/
		try {
			noStockCol.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("stockNumber"));
			noSerieCol.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("noSerie"));
			anneeCol.setCellValueFactory(new PropertyValueFactory<Vehicule,Integer>("annee"));
			marqueCol.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("marque"));
			modeleCol.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("modele"));
			couleurCol.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("couleur"));
			transmissionCol.setCellValueFactory(new PropertyValueFactory<Vehicule,String>("transmission"));
			kilometrageCol.setCellValueFactory(new PropertyValueFactory<Vehicule,Integer>("kilometrage"));
			tableVehicule.setItems(listeVehicule);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
	
	
	}
	
	
}
