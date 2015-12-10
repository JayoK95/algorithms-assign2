package models;

public class Rating 
{
	private User user;
	private Movie movie;
	private double rating;

	public Rating(User user, Movie movie, double rating) 
	{
		this.user = user;
		this.movie = movie;
		this.rating = rating;
	}

	public User getUser()
	{
		return user;
	}
	
	public int getUserID()
	{
		return user.getUserID();
	}
	
	public Movie getMovie()
	{
		return movie;
	}
	
	public int getMovieID()
	{
		return movie.getMovieID();
	}
	
	public double getRating()
	{
		return rating;
	}
	
	public void setRating(double change)
	{
		rating = change;
	}
	
	public String toString()
	{
		return user + ". Title: " + movie.getTitle() + ". Rating: " + rating + ".";
	}
}
