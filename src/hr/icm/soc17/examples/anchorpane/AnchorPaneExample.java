package hr.icm.soc17.examples.anchorpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = new AnchorPane();
		
		Button b1 = new Button("Button 1");
		Button b2 = new Button("Button 2");
		
		AnchorPane.setLeftAnchor(b1, 5.0);
		AnchorPane.setTopAnchor(b1, 20.0);
		AnchorPane.setBottomAnchor(b1, 20.0);
		
		AnchorPane.setRightAnchor(b2, 5.0);
		AnchorPane.setTopAnchor(b2, 20.0);
		AnchorPane.setBottomAnchor(b2, 20.0);
		
		root.getChildren().addAll(b1, b2);
		Scene scene = new Scene(root, 820, 640);
		
		primaryStage.setTitle("ICM SoC - AnchorPane example");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {		
		launch(args);
	}

}
