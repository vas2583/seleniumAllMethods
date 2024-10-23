package com.nt.checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com");
		WebElement ele=driver.findElement(By.id("sunday"));
		System.out.println(ele.getText());
		
		driver.findElement(By.id("sunday")).click();
		
		List<WebElement>list=driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++) {
        	list.get(i).click();
        }
        System.out.println("all check box is selected");
      List<WebElement> list1=driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']/following::label[@class='form-check-label']"));
      System.out.println(list1.size());
      for(WebElement n:list1) {
    	  System.out.println(n.getText());
      }
	}

}
