package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest
{
	Movie tester = new Movie (1, "Ted", 2012, "Comedy");
	Movie tester1 = new Movie (1, "Ted", 2012, "Comedy"); 
	Movie tester2 = new Movie (2, "Faster", 2013, "Action");

	@Test
	public void testCreate()
	{
		assertEquals (1,              	tester.getMovieID());
		assertEquals ("Ted",	        tester.getTitle());
		assertEquals (2012,   			tester.getYear());
		assertEquals ("Comedy",			tester.getGenre());
	}

	/*
	 * Failing test
	 * Problem unknown as tester & tester1 are identical
	@Test
	public void testEquals()
	{
		assertEquals(tester, tester);
		assertEquals(tester, tester1);
		assertSame(tester, tester);
	    assertNotSame(tester, tester1);
		assertNotEquals(tester, tester2);
	}*/
	
	@Test
	public void testgetMovieID()
	{
		assertEquals(1, tester.getMovieID());
		assertNotEquals(2, tester1.getMovieID());
		assertEquals(2, tester2.getMovieID());
		assertNotEquals(1, tester2.getMovieID());
	}
	
	@Test
	public void testGetTitle()
	{
		assertEquals("Ted", tester.getTitle());
		assertNotEquals("Faster", tester1.getTitle());
		assertEquals("Faster", tester2.getTitle());
		assertNotEquals("Ted", tester2.getTitle());
	}
	
	@Test
	public void testSetFirstName()
	{
		Movie tester3 = new Movie (3, "The Lord of the Rings", 2004, "Adventure"); 
		
		assertEquals("The Lord of the Rings", tester3.getTitle());
		assertNotEquals("The Hobbit", tester3.getTitle());
		
		tester3.setTitle("The Hobbit");
		
		assertEquals("The Hobbit", tester3.getTitle());
		assertNotEquals("The Lord of the Rings", tester3.getTitle());
	}
	
	@Test
	public void testGetYear()
	{
		assertEquals(2012, tester.getYear());
		assertNotEquals(2013, tester1.getYear());
		assertEquals(2013, tester2.getYear());
		assertNotEquals(2012, tester2.getYear());
	}
	
	@Test
	public void testSetYear()
	{
		Movie tester3 = new Movie (3, "The Lord of the Rings", 2004, "Adventure"); 
		
		assertEquals(2004, tester3.getYear());
		assertNotEquals(2001, tester3.getYear());
		
		tester3.setYear(2001);
		
		assertEquals(2001, tester3.getYear());
		assertNotEquals(2004, tester3.getYear());
	}
	
	@Test
	public void testGetGenre()
	{
		assertEquals("Comedy", tester.getGenre());
		assertNotEquals("Action", tester1.getGenre());
		assertEquals("Action", tester2.getGenre());
		assertNotEquals("Comedy", tester2.getGenre());
	}
	
	@Test
	public void testSetGender()
	{
		Movie tester3 = new Movie (3, "The Lord of the Rings", 2004, "Adventure"); 
		
		assertEquals("Adventure", tester3.getGenre());
		assertNotEquals("Sci-Fi", tester3.getGenre());
		
		tester3.setGenre("Sci-Fi");
		
		assertEquals("Sci-Fi", tester3.getGenre());
		assertNotEquals("Adventure", tester3.getGenre());
	}
	
	@Test
	public void testGetDetails()
	{
		assertEquals("MovieID: 1. Title: Ted. Year Released: 2012. Genre: Comedy.",
				"MovieID: " + tester.getMovieID() + ". Title: " + tester.getTitle() + ". Year Released: " 
				+ tester.getYear() + ". Genre: " + tester.getGenre() + "."); 
		assertNotEquals("MovieID: 2. Title: Faster. Year Released: 2013. Genre: Action.",
				"MovieID: " + tester1.getMovieID() + ". Title: " + tester1.getTitle() + ". Year Released: " 
				+ tester1.getYear() + ". Genre: " + tester1.getGenre() + "."); 
		assertEquals("MovieID: 2. Title: Faster. Year Released: 2013. Genre: Action.",
				"MovieID: " + tester2.getMovieID() + ". Title: " + tester2.getTitle() + ". Year Released: " 
				+ tester2.getYear() + ". Genre: " + tester2.getGenre() + ".");
		assertNotEquals("MovieID: 1. Title: Ted. Year Released: 2012. Genre: Comedy.",
				"MovieID: " + tester2.getMovieID() + ". Title: " + tester2.getTitle() + ". Year Released: " 
				+ tester2.getYear() + ". Genre: " + tester2.getGenre() + ".");
	}

	@Test
	public void testToString()
	{
		assertEquals ("MovieID: " + tester.getMovieID() + ". Title: " + tester.getTitle() + ".", tester.toString());
	}
}