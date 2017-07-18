package hr.icm.soc17.examples.anchorpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneExampleFxml extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("anchor-pane-scenebuilder-example.fxml"));
		
		Scene scene = new Scene(root, 800, 640);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ICM SoC - AnchorPane Example");
		primaryStage.show();
	}
	
	public static void main(String[] args) {		
		launch(args);
	}

}
