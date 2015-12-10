import java.util.ArrayList;

import models.Movie;
import models.Rating;
import models.User;

public class MainMethod 
{
	private User currentUser;
	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<Rating> ratings;
	private ArrayList<Movie> top10Movies;
	private int userIDCount;
	private int movieIDCount;

	public MainMethod()
	{
		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		ratings = new ArrayList<Rating>();
		top10Movies = new ArrayList<Movie>();
	}

	public static void main(String[] args)
	{
		MainMethod app = new MainMethod();
		app.run();
	}

	private void run()
	{		
		load();
		top10Movies = movies;
		userIDCount = (users.size()+1);
		movieIDCount = (movies.size()+1);
		runStart();
	}
	
	private void openingGraphic()
	{
		StdOut.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		StdOut.println("~~~          Welcome           ~~~");
		StdOut.println("~~~             to             ~~~");
		StdOut.println("~~~      THE MOVIE CRITIC      ~~~");
		StdOut.println("   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		StdOut.println("");
	}

	private void runStart()
	{
		currentUser = null;
		int choice = startMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				login();
				break;
			default:
				break;   
			}

			choice = startMenu();
			save();
			StdOut.println("");
		}
	}
	
	private int startMenu()
	{
		openingGraphic();
		StdOut.println("1) Login using UserID.");
		StdOut.println("0) Exit System");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}

	private void login()
	{
		listUsers();
		StdOut.print("Please enter your user ID: ");
		int checkUserID = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkUserID > userIDCount)
			{
				break;
			}
			if(checkUserID == users.get(i).getUserID())
			{
				currentUser = users.get(i);
				exists = true;
				break;
			}
		}
		if(exists == false)
		{
			StdOut.println("There is no user with that UserID registered.");
			StdOut.println("");
		}
		else
		{
			StdOut.println("Current User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
			StdOut.println("");
			runMainMenu();
		}
	}

	private int mainMenu()
	{
		StdOut.println("~~~ The Movie Critic ~~~");
		StdOut.print("     ~~ Main Menu ~~");
		StdOut.println("");
		StdOut.println("Current User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
		StdOut.println("");

		StdOut.println("1) ~~ User Menu ~~");
		StdOut.println("2) ~~ Movie Menu ~~");
		StdOut.println("3) ~~ Rating Menu ~~");
		StdOut.println("4) ~~ Search Menu ~~");
		StdOut.println("0) Logout");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println("");
		return choice;
	}

	private void runMainMenu()
	{
		int choice = mainMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				runUserMenu();
				break;
			case 2 : 
				runMovieMenu();
				break;
			case 3 :
				runRatingMenu();
				break;
			case 4 :
				runSearchMenu();
			default:
				break;   
			}

			choice = mainMenu();
			save();
			StdOut.println("");
		}
	}

	private int userMenu()
	{
		StdOut.print("~~ User Menu ~~");
		StdOut.println("");
		StdOut.println("Current User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
		StdOut.println("");

		StdOut.println("1) Register a User");
		StdOut.println("2) Remove a Registered User");
		StdOut.println("3) List Registered Users");
		StdOut.println("4) Show Details of Current User");
		StdOut.println("0) Exit Back to Main Menu");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}

	public void runUserMenu()
	{
		int choice = userMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				addUser();
				break;
			case 2: 
				removeUser();
				break;
			case 3:
				listUsers();
				break;
			case 4:
				showUserDetails();
				break;
			default:
				break;   
			}

			choice = userMenu();
			save();
			StdOut.println("");
		}
	}

	public void addUser()
	{
		StdOut.println("~~ Register a User ~~");
		StdOut.println("");
		StdOut.print("UserID: " + userIDCount);
		StdOut.println(" ");
		int userID = userIDCount;
		StdOut.println(" ");
		StdOut.print("Enter First Name: ");
		String firstName = StdIn.readString();
		StdOut.println(" ");
		StdOut.print("Enter Last Name: ");
		String lastName = StdIn.readString();
		StdOut.println(" ");
		StdOut.print("Enter Age: ");
		int age = StdIn.readInt();
		StdOut.println(" ");
		StdOut.print("Enter Gender: ");
		String gender = StdIn.readString();
		StdOut.println(" ");
		StdOut.print("Enter Occupation: ");
		String occupation = StdIn.readString();
		User user = new User(userID, firstName, lastName, age, gender, occupation);
		users.add(user);
		userIDCount++;
		StdOut.println("");
	}

	public void removeUser()
	{
		if(users.size() != 0)
		{
			listUsers();
			StdOut.print("Enter the UserID of the User you wish to remove: ");
			int removeUserID = StdIn.readInt();
			StdOut.println("");
			boolean exists = false;
			for(int i = 0; i < users.size(); i++)
			{
				if(removeUserID > userIDCount)
				{
					break;
				}
				if(removeUserID == users.get(i).getUserID())
				{
					users.remove(users.get(i));
					exists = true;
					break;
				}
			}
			if(exists == false)
			{
				StdOut.println("There is no User with that UserID registered.");
				StdOut.println("");
			}
		}
		else
		{
			StdOut.println("There have been no Users registered yet.");
			StdOut.println("You must add Users before you are able to remove them.");
			StdOut.println("");
		}
	}

	private void listUsers()
	{
		if(users.size() != 0)
		{
			StdOut.println("~~ Registered Users ~~");
			StdOut.println("");
			for(int i = 0; i < users.size(); i++)
			{
				StdOut.println(users.get(i));
			}
			StdOut.println("");
		}
		else
		{
			StdOut.println("There have been no Users registered yet.");
			StdOut.println("");
		}
	}

	private void showUserDetails()
	{
		StdOut.println("Current User: ");
		StdOut.println("");
		StdOut.println(currentUser.getDetails());
		StdOut.println("");
	}
	
	private int movieMenu()
	{
		StdOut.print("~~ Movie Menu ~~");
		StdOut.println("");
		StdOut.println("Current User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
		StdOut.println("");

		StdOut.println("1) Add a Movie");
		StdOut.println("2) Remove a Movie");
		StdOut.println("3) List all Movies");
		StdOut.println("4) Inspect Movie Details");
		StdOut.println("0) Exit Back to Main Menu");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}

	public void runMovieMenu()
	{
		int choice = movieMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				addMovie();
				break;
			case 2: 
				removeMovie();
				break;
			case 3:
				listMovies();
				break;
			case 4:
				showMovieDetails();
				break;
			default:
				break;   
			}

			choice = movieMenu();
			save();
			StdOut.println("");
		}
	}
	
	public void addMovie()
	{
		StdOut.println("~~ Add a Movie ~~");
		StdOut.println("");
		StdOut.print("MovieID: " + movieIDCount);
		StdOut.println(" ");
		int movieID = movieIDCount;
		StdOut.println(" ");
		StdOut.print("Enter Title: ");
		String title = StdIn.readString();
		StdOut.println(" ");
		StdOut.print("Enter Year Released: ");
		int year = StdIn.readInt();
		StdOut.println(" ");
		StdOut.print("Enter Genre: ");
		String genre = StdIn.readString();
		StdOut.println(" ");
		Movie movie = new Movie(movieID, title, year, genre);
		movies.add(movie);
		movieIDCount++;
		StdOut.println(" ");
	}
	
	public void removeMovie()
	{
		if(movies.size() != 0)
		{
			listMovies();
			StdOut.print("Enter the MovieID of the Movie you wish to remove: ");
			int removeMovieID = StdIn.readInt();
			StdOut.println("");
			boolean exists = false;
			for(int i = 0; i < movies.size(); i++)
			{
				if(removeMovieID > movieIDCount)
				{
					break;
				}
				if(removeMovieID == movies.get(i).getMovieID())
				{
					movies.remove(movies.get(i));
					exists = true;
					break;
				}
			}
			if(exists == false)
			{
				StdOut.println("There is no Movie with that MovieID registered.");
				StdOut.println("");
			}
		}
		else
		{
			StdOut.println("There have been no Movies registered yet.");
			StdOut.println("You must add Movies before you are able to remove them.");
			StdOut.println("");
		}
	}
	
	private void listMovies()
	{
		if(movies.size() != 0)
		{
			StdOut.println("~~ Movies ~~");
			StdOut.println("");
			for(int i = 0; i < movies.size(); i++)
			{
				StdOut.println(movies.get(i));
			}
			StdOut.println("");
		}
		else
		{
			StdOut.println("There have been no Movies added yet.");
			StdOut.println("");
		}
	}
	
	private void showMovieDetails()
	{
		listMovies();
		StdOut.print("Please enter the MovieID of the Movie you wish to inspect: ");
		int checkMovieID = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < movies.size(); i++)
		{
			if(checkMovieID > movieIDCount)
			{
				break;
			}
			if(checkMovieID == movies.get(i).getMovieID())
			{
				StdOut.println(movies.get(i).getDetails());
				StdOut.println("");
				exists = true;
				break;
			}
		}
		if(exists == false)
		{
			StdOut.println("There is no Movie with that MovieID registered.");
			StdOut.println("");
		}
	}
	
	private int ratingMenu()
	{
		StdOut.print("~~ Rating Menu ~~");
		StdOut.println("");
		StdOut.println("Current User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
		StdOut.println("");
		StdOut.println("1) Rate a Movie");
		StdOut.println("0) Exit Back to Main Menu");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}

	public void runRatingMenu()
	{
		int choice = ratingMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				rateMovie();
				break;
			default:
				break;   
			}
			choice = ratingMenu();
			save();
			StdOut.println("");
		}
	}
	
	public void rateMovie()
	{
		listMovies();
		StdOut.print("Please enter the MovieID of the Movie you wish to rate: ");
		int checkMovieID = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < movies.size(); i++)
		{
			if(checkMovieID > movieIDCount)
			{
				break;
			}
			if(checkMovieID == movies.get(i).getMovieID())
			{
				Movie movie = movies.get(i);
				StdOut.println(movies.get(i).getDetails());
				StdOut.println("");
				exists = true;
				StdOut.println("Please rate the Movie 1-5.");
				StdOut.println("1- Very Bad, 2- Bad, 3- Average, 4- Good, 5- Very Good.");
				StdOut.print("==>> ");
				double checkRating = StdIn.readDouble();
				StdOut.println("");
				if(checkRating > 0 && checkRating < 6)
				{
					Rating rating = new Rating(currentUser, movie, checkRating);
					ratings.add(rating);
					movie.setRatingCount();
					movie.setTotalRating(checkRating);
					movie.setAverageRating();
					save();
				}
				else
				{
					StdOut.println("That is not a valid rating.");
					StdOut.println("");
				}
				break;
			}
		}
		if(exists == false)
		{
			StdOut.println("There is no Movie with that MovieID registered.");
			StdOut.println("");
		}
	}
	
	private int searchMenu()
	{
		StdOut.print("~~ Search Menu ~~");
		StdOut.println(" ");
		StdOut.println("Current User: " + currentUser.getFirstName() + " " + currentUser.getLastName());
		StdOut.println("");
		StdOut.println("1) Search for a User");
		StdOut.println("2) Search for a Movie");
		StdOut.println("3) Search for a Rating");
		StdOut.println("0) Exit Back to Main Menu");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}

	public void runSearchMenu()
	{
		int choice = searchMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				searchUser();
				break;
			case 2: 
				searchMovie();
				break;
			case 3 :
				searchRating();
				break;
			default:
				break;   
			}

			choice = searchMenu();
			save();
			StdOut.println("");
		}
	}
	
	public void searchUser()
	{
		int choice = searchUserMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				searchUserID();
				break;
			case 2: 
				searchFirstName();
				break;
			case 3 :
				searchLastName();
				break;
			case 4 :
				searchAge();
				break;
			case 5 :
				searchGender();
				break;
			case 6 :
				searchOccupation();
				break;
			default:
				break;   
			}

			choice = searchUserMenu();
			save();
			StdOut.println("");
		}
	}
	
	public int searchUserMenu()
	{
		StdOut.print("~~ Search User ~~");
		StdOut.println(" ");
		StdOut.println("1) Search by UserID");
		StdOut.println("2) Search by First Name");
		StdOut.println("3) Search by Last Name");
		StdOut.println("4) Search by Age");
		StdOut.println("5) Search by Gender");
		StdOut.println("6) Search by Occupation");
		StdOut.println("0) Exit Back to Search Menu");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}
	
	public void searchUserID()
	{
		StdOut.print("Enter UserID to search for: ");
		int checkUserID = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkUserID == users.get(i).getUserID())
			{
				StdOut.println(users.get(i));
				exists = true;
			}
		}
		StdOut.println("");
		if(exists == false)
		{
			StdOut.println("There is no User with that UserID registered.");
			StdOut.println("");
		}
	}
	
	public void searchFirstName()
	{
		StdOut.print("Enter First Name to search for: ");
		String checkFirstName = StdIn.readString();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkFirstName.equals(users.get(i).getFirstName()))
			{
				StdOut.println(users.get(i));
				exists = true;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no User with that First Name registered.");
			StdOut.println("");
		}
	}
	
	public void searchLastName()
	{
		StdOut.print("Enter Last Name to search for: ");
		String checkLastName = StdIn.readString();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkLastName.equals(users.get(i).getLastName()))
			{
				StdOut.println(users.get(i));
				exists = true;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no User with that Last Name registered.");
			StdOut.println("");
		}
	}
	
	public void searchAge()
	{
		StdOut.print("Enter Age to search for: ");
		int checkAge = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkAge == users.get(i).getAge())
			{
				StdOut.println(users.get(i));
				exists = true;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no User with that Age registered.");
			StdOut.println("");
		}
	}
	
	public void searchGender()
	{
		StdOut.print("Enter a Gender to search for: ");
		String checkGender = StdIn.readString();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkGender.equals(users.get(i).getGender()))
			{
				StdOut.println(users.get(i));
				exists = true;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no User with that Gender registered.");
			StdOut.println("");
		}
	}
	
	public void searchOccupation()
	{
		StdOut.print("Enter a Occupation to search for: ");
		String checkOccupation = StdIn.readString();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkOccupation.equals(users.get(i).getOccupation()))
			{
				StdOut.println(users.get(i));
				exists = true;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no User with that Occupation registered.");
			StdOut.println("");
		}
	}
	
	public void searchMovie()
	{
		int choice = searchMovieMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				searchMovieID();
				break;
			case 2: 
				searchTitle();
				break;
			case 3 :
				searchYearReleased();
				break;
			case 4 :
				searchGenre();
				break;
			default:
				break;   
			}

			choice = searchMovieMenu();
			save();
			StdOut.println("");
		}
	}
	
	public int searchMovieMenu()
	{
		StdOut.print("~~ Search Movie ~~");
		StdOut.println(" ");
		StdOut.println("1) Search by MovieID");
		StdOut.println("2) Search by Title");
		StdOut.println("3) Search by Year Released");
		StdOut.println("4) Search by Genre");
		StdOut.println("0) Exit Back to Search Menu");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}
	
	public void searchMovieID()
	{
		StdOut.print("Enter MovieID to search for: ");
		int checkMovieID = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < movies.size(); i++)
		{
			if(checkMovieID == movies.get(i).getMovieID())
			{
				StdOut.println(movies.get(i));
				exists = true;
			}
		}
		StdOut.println("");
		if(exists == false)
		{
			StdOut.println("There is no Movie with that MovieID registered.");
			StdOut.println("");
		}
	}
	
	public void searchTitle()
	{
		StdOut.print("Enter a Title to search for: ");
		String checkTitle = StdIn.readString();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < movies.size(); i++)
		{
			if(checkTitle.equals(movies.get(i).getTitle()))
			{
				StdOut.println(movies.get(i));
				exists = true;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no Movie with that Title registered.");
			StdOut.println("");
		}
	}
	
	public void searchYearReleased()
	{
		StdOut.print("Enter a Year to search for Movies released in that year: ");
		int checkYear = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < movies.size(); i++)
		{
			if(checkYear == movies.get(i).getYear())
			{
				StdOut.println(movies.get(i));
				exists = true;
			}
		}
		StdOut.println("");
		if(exists == false)
		{
			StdOut.println("There is no Movie with that Release Year registered.");
			StdOut.println("");
		}
	}
	
	public void searchGenre()
	{
		StdOut.print("Enter a Genre to search for: ");
		String checkGenre = StdIn.readString();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < movies.size(); i++)
		{
			if(checkGenre.equals(movies.get(i).getGenre()))
			{
				StdOut.println(movies.get(i));
				exists = true;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no Movie with that Genre registered.");
			StdOut.println("");
		}
	}
	
	public void searchRating()
	{
		int choice = searchRatingMenu();
		while (choice != 0)
		{
			switch (choice)
			{
			case 1 : 
				searchByUser();
				break;
			case 2: 
				searchByMovie();
				break;
			case 3 :
				searchByRating();
				break;
			case 4 :
				showRatings();
				break;
			default:
				break;   
			}

			choice = searchRatingMenu();
			save();
			StdOut.println("");
		}
	}
	
	public int searchRatingMenu()
	{
		StdOut.print("~~ Search Rating ~~");
		StdOut.println(" ");
		StdOut.println("1) Search by User");
		StdOut.println("2) Search by Movie");
		StdOut.println("3) Search by Rating");
		StdOut.println("4) Show all Ratings");
		StdOut.println("0) Exit Back to Search Menu");
		StdOut.print("==>> ");
		int choice = StdIn.readInt();
		StdOut.println(" ");
		return choice;
	}
	
	public void searchByUser()
	{
		listUsers();
		StdOut.print("Enter UserID to see this Users ratings: ");
		int checkUserID = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < users.size(); i++)
		{
			if(checkUserID > userIDCount)
			{
				break;
			}
			if(checkUserID == users.get(i).getUserID())
			{
				exists = true;
				for(int j = 0; j < ratings.size(); j++)
				{
					if(checkUserID == ratings.get(j).getUserID())
					{
						StdOut.println(ratings.get(j));
					}
				}
			}
		}
		StdOut.println("");
		if(exists == false)
		{
			StdOut.println("There is no User with that UserID registered.");
			StdOut.println("");
		}
	}
	
	public void searchByMovie()
	{
		listMovies();
		StdOut.print("Enter MovieID to see this Movie's ratings: ");
		int checkMovieID = StdIn.readInt();
		StdOut.println("");
		boolean exists = false;
		for(int i = 0; i < movies.size(); i++)
		{
			if(checkMovieID > movieIDCount)
			{
				break;
			}
			if(checkMovieID == movies.get(i).getMovieID())
			{
				exists = true;
				for(int j = 0; j < ratings.size(); j++)
				{
					if(checkMovieID == ratings.get(j).getMovieID())
					{
						StdOut.println(ratings.get(j));
					}
				}
			}
		}
		StdOut.println("");
		if(exists == false)
		{
			StdOut.println("There is no Movie with that MovieID registered.");
			StdOut.println("");
		}
	}
	
	public void searchByRating()
	{
		StdOut.println("Enter the Rating to see Movies that have been rated the same (1-5)");
		StdOut.print("==>> ");
		double checkRating = StdIn.readDouble();
		StdOut.println("");
		boolean exists = false;
		for(int j = 0; j < ratings.size(); j++)
		{
			if(checkRating > 0 && checkRating < 6)
			{
				if(checkRating == ratings.get(j).getRating())
				{
					StdOut.println(ratings.get(j));
					exists = true;
				}
			}
			else
			{
				StdOut.println("This is not a valid rating.");
				StdOut.println(" ");
				exists = true;
				break;
			}
		}
		StdOut.println(" ");
		if(exists == false)
		{
			StdOut.println("There is no Movie with that Rating registered.");
			StdOut.println("");
		}
	}
	
	private void showRatings()
	{
		if(ratings.size() != 0)
		{
			StdOut.println("~~ Ratings ~~");
			StdOut.println("");
			for(int i = 0; i < ratings.size(); i++)
			{
				StdOut.println(ratings.get(i));
			}
			StdOut.println("");
		}
		else
		{
			StdOut.println("There have been no Ratings added yet.");
			StdOut.println("");
		}
	}
	
	/*
	 * Started but ran into trouble..
	public void topTenMovies()
	{
		double rating = 0.0;
		int checkMovieID = 0;
		int position = 0;
		Movie movie;
		StdOut.println("~~ Top 10 Movies ~~");
		StdOut.println(" ");
		
		for(int i = 0; i < movies.size(); i++)
		{
			if(movies.get(i).getAverageRating() >= rating);
			{
				checkMovieID = movies.get(i).getMovieID();
				position = i;
				rating = movies.get(i).getAverageRating();	
			}
		}
		movie = movies.get(position);
		top10Movies.add(movie);
	}*/

	public void save()
	{
		StdStream.saveToFile(users, "users.xml");
		StdStream.saveToFile(movies, "movies.xml");
		StdStream.saveToFile(ratings, "ratings.xml");
	}

	public void load()
	{
		users = (ArrayList<User>) StdStream.readFromFile("users.xml");
		movies = (ArrayList<Movie>) StdStream.readFromFile("movies.xml");
		ratings = (ArrayList<Rating>) StdStream.readFromFile("ratings.xml");
	}
}