package hr.icm.soc17.movieapp.model;

import java.util.List;

public interface MovieObserver {
	public void titleChanged(String oldTitle, Movie m);
	public void ratingChanged(double oldRating, Movie m);
	public void yearChanged(int oldYear, Movie m);
	public void castChanged(List<String> oldCast, Movie m);
	public void descChanged(String oldDesc, Movie m);
}
