package com.nt.mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
        WebElement ele=driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        WebElement ele1=driver.findElement(By.xpath("//a[text()='Frames']"));
        Actions ac=new Actions(driver);
        ac.moveToElement(ele).perform();
        ac.moveToElement(ele1).click().perform();
   
        
        
      //a[text()='SwitchTo']
      //a[text()="Frames"]

	}

}
