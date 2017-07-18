package hr.icm.soc17.movieapp.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieCollection {
	
	private ObservableList<Movie> movies;
	
	public MovieCollection() {
		this(Collections.emptyList());
	}
	
	public MovieCollection(List<Movie> initialItems) {
		movies = FXCollections.observableArrayList();
		initialItems.forEach(i -> movies.add(i));
	}
	
	public void registerCollectionObserver(MovieObserver mo) {
		movies.forEach(m -> m.registerObserver(mo));
	}
	
	public void removeCollectionObserver(MovieObserver mo) {
		movies.forEach(m -> m.removeObserver(mo));
	}
	
	public void addMovie(Movie m) {
		if (m == null) {
			throw new RuntimeException("Cannot add null movie.");
		}
		
		movies.add(m);
	}
	
	public void removeMovie(Movie m) {
		if (m == null) {
			throw new RuntimeException("Cannot remove null movie.");
		}
		
		movies.remove(movies.indexOf(m));
	}
	
	public MovieCollection getMoviesByName(String name) {
		return new MovieCollection(movies.stream().filter(movie -> movie.getTitle().equals(name)).collect(Collectors.toList()));
	}
	
	public MovieCollection getMoviesByYear(int year) {
		return new MovieCollection(movies.stream().filter(movie -> movie.getYear() == year).collect(Collectors.toList()));
	}
	
	public int getSize() {
		return movies.size();
	}
	
	public ObservableList<Movie> getMovieList() {
		return FXCollections.unmodifiableObservableList(movies);
	}
}
