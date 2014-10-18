package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.Vehicule;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class VehiculeListController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void testDb(ActionEvent event){
		Vehicule.listAllVehicule();
	}

}
