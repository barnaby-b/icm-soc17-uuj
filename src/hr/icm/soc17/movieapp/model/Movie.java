package hr.icm.soc17.movieapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Movie {
	private String title;
	private double rating;
	private int year;
	private List<String> cast;
	private String desc;
	private List<MovieObserver> observers;
	
	public Movie(String title, double rating, int year, List<String> cast, String desc) {
		
		if (cast == null) {
			throw new RuntimeException("Cast was null.");
		}
		
		if (title == null) {
			throw new RuntimeException("Title was null.");
		}
		
		if (desc == null) {
			throw new RuntimeException("Description was null.");
		}
		
		
		this.title = title;
		this.rating = rating;
		this.year = year;
		this.cast = new ArrayList<String>();
		cast.forEach(member -> this.cast.add(member));
		this.desc = desc;
		
		observers = new ArrayList<MovieObserver>();
	}

	public void registerObserver(MovieObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(MovieObserver o) {
		observers.remove(o);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null) {
			throw new RuntimeException("Title was null.");
		}
		
		String oldTitle = this.title;
		this.title = title;
		observers.forEach(o -> o.titleChanged(oldTitle, this));
		
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		double oldRating = this.rating;
		
		this.rating = rating;

		observers.forEach(o -> o.ratingChanged(oldRating, this));		

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		int oldYear = this.year;
		this.year = year;
		
		observers.forEach(o -> o.yearChanged(oldYear, this));
	}

	public List<String> getCast() {
		return Collections.unmodifiableList(this.cast);
	}

	public void setCast(List<String> cast) {
		if (cast == null) {
			throw new RuntimeException("Cast was null.");
		}
		
		List<String> oldCast = new ArrayList<String>();
		this.cast.forEach(member -> oldCast.add(member));
		
		this.cast = new ArrayList<String>();
		cast.forEach(member -> this.cast.add(member));
		
		observers.forEach(o -> o.castChanged(oldCast, this));
		
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		if (desc == null) {
			throw new RuntimeException("Description was null.");
		}
		
		String oldDesc = this.desc;
		
		this.desc = desc;
		
		observers.forEach(o -> o.descChanged(oldDesc, this));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + ", year=" + year + ", cast=" + cast + ", desc=" + desc
				+ "]";
	}
	
	
}