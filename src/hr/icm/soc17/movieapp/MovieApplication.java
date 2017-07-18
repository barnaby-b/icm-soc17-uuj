package hr.icm.soc17.movieapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hr.icm.soc17.movieapp.model.GlobalCollection;
import hr.icm.soc17.movieapp.model.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MovieApplication extends Application {
	
	private static BorderPane startScreenContent;
	
	public static void main(String[] args) {
		initalizeMovieCollection();
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane master = FXMLLoader.load(getClass().getResource("view/main-view.fxml"));
		
		Scene mainScene = new Scene(master, 800, 600);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("ICM MovieApp 2017");
		primaryStage.show();
		
	}
	
	public static BorderPane getStartScreenContent() throws IOException {
		if (startScreenContent != null) {
			return startScreenContent;
		}
		
		startScreenContent = FXMLLoader.load(MovieApplication.class.getResource("view/movie-table.fxml"));
		return startScreenContent;
	}
	
	public static void initalizeMovieCollection() {
		List<String> cast = new ArrayList<String>();
		cast.add("Morgan Freeman");
		cast.add("Tim Robbins");
		cast.add("Bob Gunton");
		
		Movie shawsank = new Movie("The Shawshank Redemption", 9.3, 1994, cast, 
				"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");
		
		cast.clear();
		cast.add("Marlon Brando");
		cast.add("Al Pacino");
		cast.add("James Caan");
		
		Movie godfather = new Movie("The Godfather", 9.2, 1972, cast,
				"The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
		
		
		cast.clear();
		cast.add("Al Pacino");
		cast.add("Robert De Niro");
		cast.add("Robert Duvall");
		
		Movie godfather2 = new Movie("The Godfather II", 9.0, 1974, cast,
				"The early life and career of Vito Corleone in 1920s New York is portrayed while his son, "
				+ "Michael, expands and tightens his grip on the family crime syndicate.");
		
		cast.clear();
		cast.add("Christian Bale");
		cast.add("Heath Ledger");
		cast.add("Aaron Eckhart");
		
		Movie darkKnight = new Movie("The Dark Knight", 9.0, 2008, cast,
				"When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, "
				+ "the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.");
		
	
		GlobalCollection.getCollection().addMovie(darkKnight);
		GlobalCollection.getCollection().addMovie(godfather);
		GlobalCollection.getCollection().addMovie(shawsank);
		GlobalCollection.getCollection().addMovie(godfather2);		
	}
}
