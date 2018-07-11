package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * TC 1: Verify Search term
 * 1.Open browser
 * 2.Open Etsy homepage
 * 3.Enter search term
 * 4.Verify the results page title contains the search term
 * 5.Verify search entry is still saved in the search bar
 * 
 */
public class VerifySearch {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();		
		WebDriver driver = new ChromeDriver();
		String searchTerm = "fathers day gifts";
		driver.get("http://etsy.com");
		
		//driver.findElement(By.id("search-query")).sendKeys("fathers day gift");
		WebElement input = driver.findElement(By.id("search-query"));
		
		input.sendKeys(searchTerm + Keys.ENTER); // page refreshed/ directed to results page.
		//locate the element again
		input = driver.findElement(By.id("search-query"));
		String actual = input.getAttribute("value");
		
		System.out.println(actual);
		if(actual.equals(searchTerm)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
			System.out.println("Expected: \t" + searchTerm);
			System.out.println("Found: \t" + actual);
		}
		

	}

}
