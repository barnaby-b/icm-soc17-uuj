package hr.icm.soc17.examples.gridpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		
		//Element 1
		Button b1 = new Button("Element 1");
		root.add(b1, 0, 0);
		
		//Element 2 - Gornja metoda je "convenience method"
		//U pozadini radi ovo:
		Button b2 = new Button("Element 2");
		GridPane.setColumnIndex(b2, 1);
		GridPane.setRowIndex(b2, 0);
		root.getChildren().add(b2);
		
		
		
		Scene scene = new Scene(root, 820, 640);
		
		primaryStage.setTitle("ICM SoC - GridPane example");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {		
		launch(args);
	}

}
