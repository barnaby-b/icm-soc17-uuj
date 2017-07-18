package hr.icm.soc17.movieapp.model;

import java.util.List;

public class ObserverTest implements MovieObserver {

	@Override
	public void titleChanged(String old, Movie m) {
		System.out.println("New title: " + m.getTitle());
		System.out.println("Old title: " + old); 
	}

	@Override
	public void ratingChanged(double old, Movie m) {
		System.out.println("New rating: " + m.getRating());
		System.out.println("Old rating: " + old);
	}

	@Override
	public void yearChanged(int old, Movie m) {
		System.out.println("New year: " + m.getYear());
		System.out.println("Old year: " + old); 
	}

	@Override
	public void castChanged(List<String> old, Movie m) {
		System.out.println("New cast: ");
		m.getCast().forEach(System.out::println);
		
		System.out.println("Old cast: ");
		old.forEach(System.out::println);
	}

	@Override
	public void descChanged(String s, Movie m) {
		System.out.println("New desc: " + m.getDesc());
		System.out.println("Old desc: " + s);
	}

}
