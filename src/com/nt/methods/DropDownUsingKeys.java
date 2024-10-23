package com.nt.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownUsingKeys {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		/*
		 * driver.get("https://testautomationpractice.blogspot.com/"); WebElement
		 * ele=driver.findElement(By.id("country")); ele.click();
		 * ele.sendKeys(Keys.ARROW_DOWN); ele.sendKeys(Keys.ARROW_DOWN);
		 */
		
		driver.get("https://www.amazon.in/");
		WebElement e1=driver.findElement(By.id("searchDropdownBox"));
		e1.click();
		e1.sendKeys(Keys.ARROW_DOWN);
		//e1.sendKeys(Keys.ENTER);
		
	}

}
