package com.nt.methods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindMandatoryFields {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//a[text()='Register'])[2]")).click();
		Thread.sleep(4000);
		List<WebElement>li=driver.findElements(By.xpath("//form[@method='post']//div//label"));
           for(WebElement e:li) {
        	   System.out.println(e.getText());
           }
	}

}
