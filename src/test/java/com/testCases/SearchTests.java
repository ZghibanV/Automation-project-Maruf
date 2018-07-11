package com.testCases;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTests {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void amazonSearchOne() throws InterruptedException {

		driver.get("https://amazon.com");
		String str = "Selenium Testing Tools Cookbook";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str + Keys.ENTER);

		String xpath = "//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal'][.='Selenium Testing Tools Cookbook']";
		// isDisplayed -> returns true of the element we located is displayed on the
		// page

		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());

		// 4. Enter search term Java OCA book
		// 5. Verify that a result with “Selenium Testing Tools Cookbook” is not
		// displayed anywhere
		// in the results

		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java OCA book" + Keys.ENTER);

		Thread.sleep(2000);
		try {
			// if the element is still in the html, this line line will handle
			Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
		} catch (NoSuchElementException e) {
			// if the element is not in the html at all, exceptoin will be thrown
			// since are verify sth does not exist, NoSuchElementException means test should
			// pass
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
