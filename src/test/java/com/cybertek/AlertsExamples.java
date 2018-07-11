package com.cybertek;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsExamples extends TestBase {

	@Test
	public void jsAlertTest() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button)[1]")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		// click ok on alert.
		alert.accept();

		driver.findElement(By.xpath("(//button)[2]")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(1000);
		// click cancel on alert
		alert.dismiss();

		driver.findElement(By.xpath("(//button)[3]")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(1000);
		// types on alert
		alert.sendKeys("K Boooom");
		// get the text
		System.out.println(alert.getText());
		// click ok

		try {
			Alert alert1 = driver.switchTo().alert();
		} catch (NoAlertPresentException e) {

			// fail() --> fails the assertion, throw assertion error.
			Assert.fail("Alert was not present");
		}
		alert.accept();
	}

	@Test
	public void htmlPopUps() {
		driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
		driver.findElement(By.xpath("//span[.='Destroy the World']")).click();

		assertTrue(driver.findElement(By.xpath("//span[.='No']")).isDisplayed());
		// locate the no button on the pop up and click
		driver.findElement(By.xpath("//span[.='No']")).click();
	}

}
