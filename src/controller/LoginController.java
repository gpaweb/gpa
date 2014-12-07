package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Database;
import model.LoginInfo;

public class LoginController implements Initializable {
	@FXML
	private TextField userNameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Label WarningLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				userNameTextField.requestFocus();
			}
		});

	}

	public void cancelPressed() {
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
					WarningLabel.setVisible(false);
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

					WarningLabel.setTextFill(Color.RED);
					WarningLabel.setText("Nom d'usager ou mot de passe invalide.");
					WarningLabel.setVisible(true);

					userNameTextField.requestFocus();

					FadeTransition fader = createFader(WarningLabel);

					SequentialTransition blinkThenFade = new SequentialTransition(
							WarningLabel, fader);
					blinkThenFade.play();
				}
			}
		});

	}

	private FadeTransition createFader(Node node) {
		FadeTransition fade = new FadeTransition(Duration.seconds(2), node);
		fade.setFromValue(1);
		fade.setToValue(0);

		return fade;
	}
}
