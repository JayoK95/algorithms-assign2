package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatingTest
{
	User tester1 = new User (1, "Ted", "Mosby", 21, "Male", "Architect"); 
	Movie tester2 = new Movie (1, "Faster", 2013, "Action");
	Rating tester = new Rating (tester1, tester2, 4);
	
	@Test
	public void testCreate()
	{
		assertEquals (tester1,         	tester.getUser());
		assertEquals (tester2,	        tester.getMovie());
		assertEquals (4,	   			tester.getRating(), 0.01);
	}
	
	@Test
	public void testGetUser()
	{
		User tester3 = new User(2, "Barney", "Stinson", 35, "Male", "Legend");
		
		assertEquals(tester1, tester.getUser());
		assertNotEquals(tester3, tester.getUser());
	}
	
	@Test
	public void testGetMovie()
	{
		Movie tester3 = new Movie(2, "Ted", 2011, "Comedy");
		
		assertEquals(tester2, tester.getMovie());
		assertNotEquals(tester3, tester.getMovie());
	}
	
	@Test
	public void testGetRating()
	{
		assertEquals(4, tester.getRating(), 0.01);
		assertNotEquals(3, tester.getRating(), 0.01);
	}
	
	@Test
	public void testSetRating()
	{
		assertEquals(4, tester.getRating(), 0.01);
		assertNotEquals(3.5, tester.getRating(), 0.01);
		
		tester.setRating(3.5);
		
		assertEquals(3.5, tester.getRating(), 0.01);
		assertNotEquals(4.0, tester.getRating(), 0.01);
	}

	@Test
	public void testToString()
	{
		assertEquals (tester.getUser() + ". Title: " + tester.getMovie().getTitle() + ". Rating: " + tester.getRating() + ".", tester.toString());
	}
}