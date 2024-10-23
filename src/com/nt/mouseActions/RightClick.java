package com.nt.mouseActions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        
  WebElement ele=driver.findElement(By.xpath("//span[text()='right click me']"));
   Actions ac=new Actions(driver);
   ac.contextClick(ele).perform();
   WebElement ele1=driver.findElement(By.xpath("//span[text()='Copy']"));
      ele1.click();
    Alert a=driver.switchTo().alert();
    a.accept();
	}

}
