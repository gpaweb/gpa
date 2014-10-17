package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.DB;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class VehiculeListController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void testDb(ActionEvent event){
		//System.out.println("Hello world");
		String url = "jdbc:mysql://localhost/gpa2k15";
		String dbName = "gpa2k15";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String dbPassword = "passwd12";
		
		DB db = new DB(url, dbName, driver, userName, dbPassword);
		
	}

}
