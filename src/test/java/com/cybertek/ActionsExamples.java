package com.cybertek;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExamples {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void doubleClickTest() {
		driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
		WebElement slides = driver.findElement(By.id("slide_content"));

		Actions action = new Actions(driver);
		action.doubleClick(slides).perform();
	}

	@Test(priority = 2)
	public void hoverTest() {

		driver.get("https://www.amazon.com/");
		WebElement hovers = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));

		Actions action = new Actions(driver);

		// moves the mouse on the top of the element
		action.moveToElement(hovers).perform();

		driver.findElement(By.linkText("Your Garage")).click();

	}

	@Test(priority = 3)
	public void hoverTest2() {
		driver.get("https://www.amazon.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[.='Back to top']"))).perform();
		// action.moveByOffset(5, 5).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();

	}

	@Test(priority = 4)
	public void scrollTest() throws InterruptedException {
		driver.get("http://amazon.com");
		Actions action = new Actions(driver);
		//
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
		action.sendKeys(Keys.ARROW_DOWN).perform();		

		action.sendKeys(Keys.ARROW_DOWN).perform();
	}
	
	
	@Test(priority = 5)
	public void dragNDrop() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions action = new Actions(driver);
		//drag n drop operation involves 2 elements. source and target. 
		//source --> element which will move
		//target  - > element where we drop the source.
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droptarget"));
		action.dragAndDrop(source, target).perform();
		
		
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		// driver.close();
	}

}
