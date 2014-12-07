package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // BorderPane root = new BorderPane();
            Parent root = FXMLLoader.load(getClass().getResource(
                    "/fxml/Login.fxml"));
            Scene scene = new Scene(root);
            // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Gestion de parc automobile");
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("An error as append...");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
