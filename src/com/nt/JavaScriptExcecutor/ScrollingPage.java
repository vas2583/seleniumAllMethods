package com.nt.JavaScriptExcecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
		Thread.sleep(10000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		/*
		 * jse.executeScript("window.scrollBy(0,3000)","");
		 * System.out.println("complete");
		 */
		//2nd Approch Based ON Condition
		/*
		 * WebElement ele=driver.findElement(By.
		 * xpath("//table[@class='two-column td-red']//td[text()='T']"));
		 * jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		 */
		//3rd end of the page
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		 jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	
		 
		
		
		
		

	}

}
