package com.nt.methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CountElementsByScrollPage {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*List<WebElement>li=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
	     System.out.println(li.size());*/
		/*
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		List<WebElement>li=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
		System.out.println(li.size());
	    */
		int priveousCount=0;
		int currentCount=0;
		while(true) {
			List<WebElement>li=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			currentCount=li.size();
			if(currentCount==priveousCount) {
				break;
			   }
			priveousCount=currentCount;
			/*
			 * JavascriptExecutor js=(JavascriptExecutor)driver;
			 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			 */
			Actions ac=new Actions(driver);
			ac.sendKeys(Keys.END).perform();
			Thread.sleep(3000);
		}
		System.out.println("The No of Elements in Page is:::"+currentCount);
		
	     

	}

}
