package hr.icm.soc17.movieapp.view;
import java.io.IOException;
import java.util.List;

import hr.icm.soc17.movieapp.model.GlobalCollection;
import hr.icm.soc17.movieapp.model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class MovieTableView {

	@FXML
	private TableView<Movie> movieTable;
	
	@FXML
	private TableColumn<Movie, String> titleColumn;
	
	@FXML
	private TableColumn<Movie, Double> ratingColumn;
	
	@FXML
	private TableColumn<Movie, Integer> yearColumn;
	
	@FXML
	private TableColumn<Movie, List<String>> castColumn;
	
	@FXML
	private TableColumn<Movie, String> descColumn;
	
	@FXML
	private Button removeButton;
	
	@FXML
	private Button addButton;
	
	public MovieTableView() {
		
	}
	
	public void initialize() {
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
		castColumn.setCellValueFactory(new PropertyValueFactory<>("cast"));
		descColumn.setCellValueFactory(new PropertyValueFactory<>("desc"));
		
		removeButton.setDisable(true);
		
		movieTable.setItems(GlobalCollection.getCollection().getMovieList());
		
		movieTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
			if (newVal == null) {
				removeButton.setDisable(true);
			} else {
				removeButton.setDisable(false);
			}
		});
		
		
//		List<String> cast = new ArrayList<String>();
//		cast.add("123");
//		cast.add("345");
//		cast.add("567");
//		GlobalCollection.getCollection().addMovie(new Movie("Movie n", 9.7, 1323, cast, "1234566"));
//		GlobalCollection.getCollection().getMovieList().get(0).setCast(cast);
	}
	
	@FXML
	private void removeMovie(ActionEvent event) {
		Movie selected = movieTable.getSelectionModel().getSelectedItem();
		GlobalCollection.getCollection().removeMovie(selected);
	}
	
	@FXML
	private void addMovie(ActionEvent event) {
		BorderPane addMoviePane;
		try {
			addMoviePane = FXMLLoader.load(getClass().getResource("add-movie.fxml"));
		} catch (IOException e) {
			System.out.println("Cannot instantiate view.");
			return;
		}
		
		MainView v = (MainView) ViewProvider.getViewByName("main");
		Tab t = new Tab("Add Movie");
		t.setContent(addMoviePane);
		v.spawnTab(t, true);
	}
}
