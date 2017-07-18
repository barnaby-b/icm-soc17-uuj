package hr.icm.soc17.examples.gridpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneGrowthPriorityExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		//PRVI STUPAC OSTAVLJAMO PRAZNIM
		
		//Element 1
		Button b1 = new Button("Element 1");
		root.add(b1, 1, 0);
		
		//Element 2 - Gornja metoda je "convenience method"
		//U pozadini radi ovo:
		Button b2 = new Button("Element 2");
		GridPane.setColumnIndex(b2, 2);
		GridPane.setRowIndex(b2, 0);
		root.getChildren().add(b2);
		
		//Fiksiramo sirinu stupca
		root.getColumnConstraints().add(new ColumnConstraints());
		root.getColumnConstraints().add(new ColumnConstraints(100));
		root.getColumnConstraints().add(new ColumnConstraints(200));
//
		
		b1.setPrefWidth(100);
		b2.setPrefWidth(200);
		
		//Prvi stupac zauzima sav moguci slobodan prostor.
//		ColumnConstraints c1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
//		c1.setHgrow(Priority.ALWAYS);
//		root.getColumnConstraints().set(0, c1);
		
		Scene scene = new Scene(root, 820, 640);
		
		primaryStage.setTitle("ICM SoC - GridPane example");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {		
		launch(args);
	}

}
