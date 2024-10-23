package com.nt.dropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownClass {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
	    WebElement ele=driver.findElement(By.id("country"));
	    Select sc=new Select(ele);
	    //sc.selectByVisibleText("United Kingdom");
	    //sc.selectByValue("germany");
	    //sc.selectByIndex(2);
	 List<WebElement>list= sc.getOptions();
	   for(WebElement n:list) {
		   System.out.println(n.getText());
	   }
	    
	
	}

}
