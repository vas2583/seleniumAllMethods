package com.nt.JavaScriptExcecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionMethods {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement ele=driver.findElement(By.name("username"));
		WebElement pass=driver.findElement(By.name("password"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].value='Admin';", ele);
		js.executeScript("arguments[0].value='admin123';", pass);
		System.out.println("pass&username is Entered");
		Thread.sleep(2000);
		WebElement logbtn=driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click();",logbtn);
		
		
	}}
		