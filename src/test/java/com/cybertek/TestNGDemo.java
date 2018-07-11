package com.cybertek;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	@BeforeClass
	public void setUpClass() {
		System.out.println("Runs once before everything in this class. ");
	}
	
	@BeforeMethod
	public void setUpMethod() { 
		System.out.println("runs before every method.");
	}	

	@Test
	public void firstOne() {		
		System.out.println("First test");				
	}
	
	@Test
	public void secondOne () {
		System.out.println("Second test");
	}

	@AfterMethod
	public void tearDownMethod() {
		System.out.println("runs again, after every method");
	}
	
	@AfterClass
	public void tearDownClass() {
		System.out.println("Runs once after everything in this class");
	}

}
