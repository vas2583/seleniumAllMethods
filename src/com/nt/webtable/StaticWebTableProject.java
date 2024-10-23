package com.nt.webtable;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticWebTableProject {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://blazedemo.com");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.name("fromPort"));
		Select sc=new Select(ele);
		sc.selectByVisibleText("Boston");
		WebElement ele1=driver.findElement(By.name("toPort"));
	    Select sc1=new Select(ele1);
	    driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
	    boolean bo1=driver.findElement(By.xpath("//input[@type='submit']/ancestor::table/preceding::h3")).isDisplayed();
	     if(bo1==true) {
	    	String str=driver.findElement(By.xpath("//table[contains(@class,'table')]//tr[1]/td[6]")).getText();
	     }
	    	//number of rows
	    	int row=driver.findElements(By.xpath("//table[contains(@class,'table')]//tr")).size();
	    	String str[] =new String[row-1];
	    	System.out.println(row);
	    	for(int i=1;i<row;i++) {
	    		String text=driver.findElement(By.xpath("//table[contains(@class,'table')]//tr["+i+"]/td[6]")).getText();
	    		System.out.println(text);
	    		str[i-1]=text;	
	    	}
	    	
	    	Arrays.sort(str);
	    	for(int i=0;i<str.length;i++) {
	    		
	    		System.out.println(str[i]);
	    	    }
	     	for(int i=1;i<row;i++) {
	    		WebElement ele3=driver.findElement(By.xpath("//table[contains(@class,'table')]//tr["+i+"]/td[6]"));
	    		 String text=ele3.getText();
	    		if(text.equals(str[0])) {
	    	     driver.findElement(By.xpath("//table[contains(@class,'table')]//tr["+i+"]/td[1]")).click();
	                break;
	    		}
	     	}
	    		driver.findElement(By.id("inputName")).sendKeys("vasu");
	    		driver.findElement(By.id("address")).sendKeys("ravicharla");
	    		driver.findElement(By.id("city")).sendKeys("nuzvid");
	    		driver.findElement(By.id("state")).sendKeys("nuzvid");
	    		driver.findElement(By.id("zipCode")).sendKeys("521202");
	    		WebElement ele5=driver.findElement(By.id("cardType"));
	    		Select sc5=new Select(ele5);
	    		sc5.selectByVisibleText("American Express");
	    		driver.findElement(By.id("creditCardNumber")).sendKeys("123456");
	    		driver.findElement(By.id("nameOnCard")).sendKeys("vasu");
	    		driver.findElement(By.name("rememberMe")).click();
	    		
	    		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    		
	    		boolean bo5=driver.findElement(By.xpath("//h1[text()='Thank you for your purchase today!']")).isDisplayed();
	    		if(bo5==true) {
	    			System.out.println("thanks for booking::");
	    		}
	              
	    	}
	    	
	    	
	    	

	}
	

