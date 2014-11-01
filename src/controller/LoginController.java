package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.Database;
import model.LoginInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML
	private TextField userNameTextField;
	@FXML
	private PasswordField passwordTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void OkPressed(ActionEvent event) throws Exception{
		LoginInfo.setUserName(userNameTextField.getText());
		LoginInfo.setPassword(passwordTextField.getText());
		
		if(Database.testDbConnection(LoginInfo.getUserName(),LoginInfo.getPassword())==true){
			System.out.println("Database connexion sucessfull");
			((Node)(event.getSource())).getScene().getWindow().hide();
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Vehiculeslist.fxml"));
			Stage stage = new Stage();	
			Scene scene = new Scene(parent,1024,768);
			stage.setScene(scene);
			stage.setTitle("Gestion de parc automobile");
			stage.show();
		} else {
			System.out.println("Database connexion failed");
		}
		
		
	}

}
