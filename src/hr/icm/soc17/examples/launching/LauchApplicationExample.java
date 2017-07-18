package hr.icm.soc17.examples.launching;

import javafx.application.Application;
import javafx.stage.Stage;

public class LauchApplicationExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		launch(args);
	}

}
