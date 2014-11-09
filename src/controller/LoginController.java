package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.Database;
import model.LoginInfo;
import javafx.application.Platform;
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

public class LoginController implements Initializable {
	@FXML
	private TextField userNameTextField;
	@FXML
	private PasswordField passwordTextField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void cancelPressed(){
		System.exit(0);
	}
	
	public void okPressed(ActionEvent event) throws Exception {
		LoginInfo.setUserName(userNameTextField.getText());
		LoginInfo.setPassword(passwordTextField.getText());
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (Database.testDbConnection(LoginInfo.getUserName(),
						LoginInfo.getPassword()) == true) {
					System.out.println("Database connexion sucessfull");
					((Node) (event.getSource())).getScene().getWindow().hide();
					Parent parent;
					try {
						parent = FXMLLoader.load(getClass().getResource(
								"/fxml/Vehiculeslist.fxml"));
						Stage stage = new Stage();
						Scene scene = new Scene(parent, 1024, 768);
						stage.setScene(scene);
						stage.setTitle("Gestion de parc automobile");
						stage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("Database connexion failed");
				}
			}
		});

	}

}
