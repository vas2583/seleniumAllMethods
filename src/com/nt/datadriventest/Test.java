package com.nt.datadriventest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) throws Exception {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://fd-calculator.in/result");
        driver.manage().window().maximize();
        String path=System.getProperty("user.dir")+"\\sheets\\Book4.xlsx";
        System.out.println(path);
		
		  int total_rows=Utility.getRowCount(path,"Sheet1");
		  System.out.println(total_rows);
		  for(int i=1;i<=total_rows;i++) {
			  String principleAmount=Utility.getcellData(path,"Sheet1",i,0);
			  String priod1=Utility.getcellData(path,"Sheet1",i,1);
			  String priod2=Utility.getcellData(path,"Sheet1",i,2);
			  String interst=Utility.getcellData(path,"Sheet1",i,3);
			  String compound=Utility.getcellData(path,"Sheet1",i,4);
			  String expected_val=Utility.getcellData(path,"Sheet1",i,5);
			  
			  
	
			  
			  
			  driver.findElement(By.xpath("//input[@id='amountInputField']")).sendKeys(principleAmount);
			  driver.findElement(By.xpath("//input[@id='periodInputField']")).sendKeys(priod1);
			  WebElement ele=driver.findElement(By.xpath("//select[@id='amountSelectField']"));
			  Select sc=new Select(ele);
			  sc.selectByVisibleText(priod2);
			  driver.findElement(By.xpath("//input[@id='interestInputField']")).sendKeys(interst);
			  WebElement ele2=driver.findElement(By.xpath("//select[@id='frequencySelectField']"));
			  Select sc1=new Select(ele2);
			  sc1.selectByVisibleText(compound);
			  //click on 	Button
			  driver.findElement(By.xpath("//button[@id='calculateButton']")).click();
			  
			  String actual=driver.findElement(By.xpath("//span[@id='futureValue']")).getText();
			  if(expected_val.equalsIgnoreCase(actual)) {
				  System.out.println("passed");
				  Utility.setCellData(path,"Sheet1",i,7,"passed");
				  Utility.fillGreenColor(path,"Sheet1",i,7);
			     }
			  else {
				  System.out.println("failed");
				  Utility.setCellData(path,"Sheet1",i,7,"failed");
				  Utility.fillRedColor(path,"Sheet1",i,7);
				  
			  }
			  
			 
		  }
		 
        

	}

}
