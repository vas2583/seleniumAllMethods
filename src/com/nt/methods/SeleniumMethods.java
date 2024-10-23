package com.nt.methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) {
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://tutorialsninja.com/demo/index.php?route=account");
    	String url=driver.getCurrentUrl();
    	if(url.equals("https://tutorialsninja.com/demo/index.php?route=account")) {
    		System.out.println("u r navigation is correct::");
    	}
    	else {
    		System.out.println("u r navigation is wrong");
    		return;
    	}
    	System.out.println(url);
    	String title=driver.getTitle();
    	System.out.println(title);
    	String ui=driver.getPageSource();
    	System.out.println(ui);
    	Object obj=driver.getClass();
    	System.out.println(obj);
       WebElement register=driver.findElement(By.xpath("//a[@title='My Account']"));
       register.click();
      WebElement element= driver.findElement(By.linkText("Register"));
    
      element.click();
       System.out.println(driver.getTitle());
       driver.navigate().back();
       System.out.println("go to home page:;");
       driver.navigate().refresh();
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        List<WebElement> list= driver.findElements(By.tagName("a"));
         for(WebElement ele:list) {
        	 String text=ele.getText();
        	 
        	 System.out.println(text);
        	 if(text.equals("Desktops")) {
        		 ele.click();
        		 
        	 }
         }
        System.out.println("my account is sleect");
    	
    	
    
    }
    
}
