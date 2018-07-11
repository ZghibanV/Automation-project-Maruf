package com.cybertek;
/*
 * 1.Open browser
 * 2.Go to Mercury Tours application
 * 3.Login as a current user
 * 4.Verify thatdefault Departing Fromvalue is Acapulco
 * 5.Verify that list of locations: Acapulco, Frankfurt, 
 *   London, New York, Paris, Portland, San Francisco, Seattle, Sydney, Zurich
 * 6.Test Departing Fromdropdown functionality by changing different values
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/");
		//find select tag
		WebElement selectTag = driver.findElement(By.name("my_html_select_box"));
		//2. create select object from select tag.
		Select list= new Select(selectTag);
		
		WebElement selected = list.getFirstSelectedOption();
		System.out.println(selected.getText());
		System.out.println("-------------------------");
		List<WebElement> options = list.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
			//select using the visible text.
			list.selectByVisibleText("Bucharest");
			
			System.out.println("selected: \t" + list.getFirstSelectedOption().getText());
			
			//select using the index.
			
			list.selectByIndex(2);
		//	System.out.println("Selected: \t" + list.selectByIndex(0));
			
			Select secondList = new Select(driver.findElement(By.cssSelector("select[multiple='yes']")));
			secondList.selectByVisibleText("New York");
			secondList.selectByVisibleText("Madrid");
		}
		
	}

}
