package com.nit.fluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitClass {

	public static void main(String[] args) { 
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		 // Correct use of FluentWait
        FluentWait<WebDriver> wait = new FluentWait<>(driver) // Correct diamond operator <>
                .withTimeout(Duration.ofSeconds(30))    // Maximum wait time
                .pollingEvery(Duration.ofSeconds(5))    // Polling every 5 seconds
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException

        // Wait for the element and store it in ele1
        WebElement ele1 = wait.until(d ->driver.findElement(By.xpath("//button[@type='submit']")));

        // Click the element
        ele1.click();
	System.out.println("element is Clickable");
	
	
	

	}



}
