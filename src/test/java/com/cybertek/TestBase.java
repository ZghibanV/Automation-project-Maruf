package com.cybertek;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	@AfterClass
	public void closure() {
		driver.quit();
	}
	/*
	 * @param expected title
	 * 
	 * will switch to new tab based on expected title
	 * will switch back to the original tab,
	 * if the expected title does not exist. 
	 * 
	 */
	
	public void switchByTitle(String title) { 
		String original = driver.getWindowHandle();
		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(title)) {
				break;
			}
		}
		driver.switchTo().window(original);
	}

}
