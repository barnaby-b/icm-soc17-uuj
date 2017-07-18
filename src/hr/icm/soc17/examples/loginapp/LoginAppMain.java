package hr.icm.soc17.examples.loginapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginAppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane rootGrid = (GridPane) FXMLLoader.load(getClass().getResource("view/login-app.fxml"));
		
		Scene scene = new Scene(rootGrid, 840, 600);
		primaryStage.setTitle("ICM SoC - LOGIN");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	