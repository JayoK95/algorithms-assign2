package models;

public class Movie 
{
	private int movieID;
	private String title;;
	private int year;
	private String genre;
	private double averageRating;
	private double totalRating;
	private double ratingCount;
	
	public Movie(int movieID, String title, int year, String genre) 
	{
		this.movieID = movieID;
		this.title = title;
		this.year = year;
		this.genre = genre;
		ratingCount = 0;
		totalRating = 0;
		averageRating = 0;
	}
	
	public int getMovieID()
	{
		return movieID;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String change)
	{
		title = change;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int change)
	{
		year = change;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public void setGenre(String change)
	{
		genre = change;
	}
	
	public double getTotalRating()
	{
		return totalRating;
	}
	
	public void setTotalRating(double rating)
	{
		totalRating = totalRating + rating;
	}
	
	public double getRatingCount()
	{
		return ratingCount;
	}
	
	public void setRatingCount()
	{
		ratingCount = ratingCount + 1.0;
	}
	
	
	public double getAverageRating()
	{
		return averageRating;
	}
	
	public void setAverageRating()
	{
		averageRating = totalRating / ratingCount;
	}
	
	public String getDetails()
	{
		return ("MovieID: " + movieID + ". Title: " + title + ". Year Released: " + year + ". Genre: " + genre + ". Average Rating: " + averageRating + ".");
	}
	
	public String toString()
	{
		return ("MovieID: " + movieID + ". Title: " + title + ".");
	}
}
