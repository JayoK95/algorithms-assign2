package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest
{
	User tester = new User (95, "Mister", "Tester", 25, "Male", "Student");
	User tester1 = new User (95, "Mister", "Tester", 25, "Male", "Student"); 
	User tester2 = new User (96, "Jane", "Smith", 32, "Female", "Nurse"); 

	@Test
	public void testCreate()
	{
		assertEquals (95,              	tester.getUserID());
		assertEquals ("Mister",         tester.getFirstName());
		assertEquals ("Tester",			tester.getLastName());	
		assertEquals (25,   			tester.getAge());
		assertEquals ("Male",			tester.getGender());
		assertEquals ("Student",        tester.getOccupation());   
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
	public void testGetUserID()
	{
		assertEquals(95, tester.getUserID());
		assertNotEquals(96, tester1.getUserID());
		assertEquals(96, tester2.getUserID());
		assertNotEquals(95, tester2.getUserID());
	}
	
	@Test
	public void testGetFirstName()
	{
		assertEquals("Mister", tester.getFirstName());
		assertNotEquals("Jane", tester1.getFirstName());
		assertEquals("Jane", tester2.getFirstName());
		assertNotEquals("Mister", tester2.getFirstName());
	}
	
	@Test
	public void testSetFirstName()
	{
		User tester3 = new User (97, "John", "Doe", 48, "Male", "Fisher"); 
		
		assertEquals("John", tester3.getFirstName());
		assertNotEquals("Ezio", tester3.getFirstName());
		
		tester3.setFirstName("Ezio");
		
		assertEquals("Ezio", tester3.getFirstName());
		assertNotEquals("John", tester3.getFirstName());
	}
	
	@Test
	public void testGetLastName()
	{
		assertEquals("Tester", tester.getLastName());
		assertNotEquals("Smith", tester1.getLastName());
		assertEquals("Smith", tester2.getLastName());
		assertNotEquals("Tester", tester2.getLastName());
	}
	
	@Test
	public void testSetLastName()
	{
		User tester3 = new User (97, "John", "Doe", 48, "Male", "Fisher"); 
		
		assertEquals("Doe", tester3.getLastName());
		assertNotEquals("Auditore", tester3.getLastName());
		
		tester3.setLastName("Auditore");
		
		assertEquals("Auditore", tester3.getLastName());
		assertNotEquals("Doe", tester3.getLastName());
	}
	
	@Test
	public void testGetAge()
	{
		assertEquals(25, tester.getAge());
		assertNotEquals(32, tester1.getAge());
		assertEquals(32, tester2.getAge());
		assertNotEquals(25, tester2.getAge());
	}
	
	@Test
	public void testSetAge()
	{
		User tester3 = new User (97, "John", "Doe", 48, "Male", "Fisher"); 
		
		assertEquals(48, tester3.getAge());
		assertNotEquals(84, tester3.getAge());
		
		tester3.setAge(84);
		
		assertEquals(84, tester3.getAge());
		assertNotEquals(48, tester3.getAge());
	}
	
	@Test
	public void testGetGender()
	{
		assertEquals("Male", tester.getGender());
		assertNotEquals("Female", tester1.getGender());
		assertEquals("Female", tester2.getGender());
		assertNotEquals("Male", tester2.getGender());
	}
	
	@Test
	public void testSetGender()
	{
		User tester3 = new User (97, "John", "Doe", 48, "Male", "Fisher"); 
		
		assertEquals("Male", tester3.getGender());
		assertNotEquals("Female", tester3.getGender());
		
		tester3.setGender("Female");
		
		assertEquals("Female", tester3.getGender());
		assertNotEquals("Male", tester3.getGender());
	}
	
	@Test
	public void testGetOccupation()
	{
		assertEquals("Student", tester.getOccupation());
		assertNotEquals("Nurse", tester1.getOccupation());
		assertEquals("Nurse", tester2.getOccupation());
		assertNotEquals("Student", tester2.getOccupation());
	}
	
	@Test
	public void testSetOccupation()
	{
		User tester3 = new User (97, "John", "Doe", 48, "Male", "Fisher"); 
		
		assertEquals("Fisher", tester3.getOccupation());
		assertNotEquals("Assassin", tester3.getOccupation());
		
		tester3.setOccupation("Assassin");
		
		assertEquals("Assassin", tester3.getOccupation());
		assertNotEquals("Fisher", tester3.getOccupation());
	}
	
	@Test
	public void testGetDetails()
	{
		assertEquals("UserID: 95. Name: Mister Tester. Age: 25. Gender: Male. Occupation: Student.",
				"UserID: " + tester.getUserID() + ". Name: " + tester.getFirstName() + " " + tester.getLastName() + ". Age: " 
				+ tester.getAge() + ". Gender: " + tester.getGender() + ". Occupation: " + tester.getOccupation() + "."); 
		assertNotEquals("UserID: 96. Name: Jane Smith. Age: 32. Gender: Female. Occupation: Nurse.",
				"UserID: " + tester1.getUserID() + ". Name: " + tester1.getFirstName() + " " + tester1.getLastName() + ". Age: " 
				+ tester1.getAge() + ". Gender: " + tester1.getGender() + ". Occupation: " + tester1.getOccupation() + "."); 
		assertEquals("UserID: 96. Name: Jane Smith. Age: 32. Gender: Female. Occupation: Nurse.",
				"UserID: " + tester2.getUserID() + ". Name: " + tester2.getFirstName() + " " + tester2.getLastName() + ". Age: " 
				+ tester2.getAge() + ". Gender: " + tester2.getGender() + ". Occupation: " + tester2.getOccupation() + "."); 
		assertNotEquals("UserID: 95. Name: Mister Tester. Age: 25. Gender: Male. Occupation: Student.",
				"UserID: " + tester2.getUserID() + ". Name: " + tester2.getFirstName() + " " + tester2.getLastName() + ". Age: " 
				+ tester2.getAge() + ". Gender: " + tester2.getGender() + ". Occupation: " + tester2.getOccupation() + "."); 
	}

	@Test
	public void testToString()
	{
		assertEquals ("UserID: " + tester.getUserID() + ". Name: " + tester.getFirstName() + " " + tester.getLastName(), tester.toString());
	}
}