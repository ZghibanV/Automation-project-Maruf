package com.cybertek;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TabsWindowsExample extends TestBase {
	@Test
	public void switchTWindow() {

		driver.get("http://the-internet.herokuapp.com/windows");
		System.out.println(driver.getTitle());

		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getTitle());

		String firstWindow = driver.getWindowHandle();
		System.out.println("current: " + firstWindow);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			System.out.println(string);

			if (!firstWindow.equals(string)) {
				driver.switchTo().window(string);
			}

		}
		
		System.out.println(driver.getTitle());

	}
	
	@Test
	public void switchByTitleTest() { 
		driver.get("http://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.linkText("Click Here")).click();
		String expectedTitle = "New Window";
		switchByTitle(expectedTitle);
		
		assertEquals(driver.getTitle(), expectedTitle, "Title did not match");
	}
	

}
