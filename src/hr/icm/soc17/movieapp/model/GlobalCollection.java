package hr.icm.soc17.movieapp.model;

public class GlobalCollection {
	
	private static MovieCollection movieCollection;
	
	static {
		movieCollection = new MovieCollection();
	}
	
	private GlobalCollection() {
		
	}
	
	
	public static MovieCollection getCollection() {
		return movieCollection;
	}
	
}
