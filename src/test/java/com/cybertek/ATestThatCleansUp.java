package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ATestThatCleansUp {
	
//	Test Case 1
//    Go to amazon
//    search for something
//
//Test Case 2
//    Go to Google
//    Search for something
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void searchGoogle() {
		driver.get("http:\\google.com");		
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium Cookbook"+ Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Selenium Cookbook"));
	}
	
	@Test
	public void searchAmazon() {
		driver.get("http:\\amazon.com");		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("fathers day gift"+ Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("fathers day gift"));	
	}
	
	@AfterMethod
	public void tearDown() {		
		driver.close();
	}

}
