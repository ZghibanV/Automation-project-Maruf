package com.cybertek;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestThatDependOnEachOther extends TestBase {
	
	@Test(priority = 1)
	public void opensThePage() {
		driver.get("https://google.com");
	}
	
	@Test(priority = 2)
	public void types() { 
		driver.findElement(By.name("q")).sendKeys("Look for the boogeyman");
	}

}
