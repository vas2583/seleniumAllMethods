package com.nt.methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FoundElementInScrollPage {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String s="City of Glass";
	System.out.println(s);
		Actions ac=new Actions(driver);
		//ac.scrollToElement(ele);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView();",ele);
		
		boolean b=false;
		while(!b) {
		  List<WebElement>li=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		 
	       for(WebElement e:li) {
	    	   String book=e.getText();
	    	   if(s.equals(book)) {
	    		   System.out.println(s+" is  found");
	    		   b=true;
	    		   break;
	    	   }   
	       }
	       
	       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	       Thread.sleep(3000);
	    }
	}

}
