package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void OkPressed(ActionEvent event) throws Exception{
		((Node)(event.getSource())).getScene().getWindow().hide();
		Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Vehiculeslist.fxml"));
		Stage stage = new Stage();	
		Scene scene = new Scene(parent,1024,768);
		stage.setScene(scene);
		stage.setTitle("Gestion de parc automobile");
		stage.show();
	}

}
