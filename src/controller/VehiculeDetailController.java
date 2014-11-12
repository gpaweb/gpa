package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.VehiculeToBeModified;
import javafx.fxml.Initializable;

public class VehiculeDetailController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(VehiculeToBeModified.toText());
	}

}
