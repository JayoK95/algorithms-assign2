package models;

public class User 
{
	private int userID;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String occupation;
	
	public User(int userID, String firstName, String lastName, int age, String gender, String occupation) 
	{
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
	}
	
	public int getUserID()
	{
		return userID;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String change)
	{
		firstName = change;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String change)
	{
		lastName = change;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int change)
	{
		age = change;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String change)
	{
		gender = change;
	}
	
	public String getOccupation()
	{
		return occupation;
	}
	
	public void setOccupation(String change)
	{
		occupation = change;
	}
	
	public String getDetails()
	{
		return ("UserID: " + userID + ". Name: " + firstName + " " + lastName + ". Age: " + age + ". Gender: " + gender + ". Occupation: " + occupation + ".");
	}
	
	public String toString()
	{
		return ("UserID: " + userID + ". Name: " + firstName + " " + lastName);
	}
}
