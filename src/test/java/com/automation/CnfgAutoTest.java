package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CnfgAutoTest {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void login () {
		driver.get(ConfigAutomation.getMyValue("URL"));
//		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys(ConfigAutomation.getMyValue("User"));
		driver.findElement(By.id("passwd")).sendKeys(ConfigAutomation.getMyValue("Password"));
		driver.findElement(By.id("SubmitLogin")).click();
		
	}
	
	
	
	@AfterClass
	public void closure() throws InterruptedException {
		Thread.sleep(2000);
		//driver.quit();
	}

}
