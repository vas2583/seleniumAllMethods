package com.nt.mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickWithOutUsinClickMethod {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));.
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("open url");
		WebElement ele=driver.findElement(By.linkText("GUI Elements & AJAX"));
		Actions ac=new Actions(driver);
       // ele.sendKeys(Keys.ENTER);
		  ac.doubleClick(ele).perform();
		  Thread.sleep(3000);
		  WebElement ele1=driver.findElement(By.xpath("//h3[contains(@class,'post-title entry-title')]"));
             boolean bo1=ele1.isDisplayed();
             if(bo1==true) {
            	 System.out.println("click action performed");
             }
		  
        
        
	}

}
