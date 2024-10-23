package com.nt.webtable;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


		public class countOfRecords {
		    public static void main(String[] args) {
		        int count = 0;
		        WebDriver driver = new ChromeDriver();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.get("file:///D:/htmlprograms/webTable.html");
		        driver.manage().window().maximize();

		        
		        List<WebElement> list = driver.findElements(By.xpath("//table[@id='productTable']//tr/td[4]/input[@type='checkbox']"));
		        System.out.println("Total checkboxes: " + list.size());
                 
		        
				/*
				 * for (WebElement checkbox : checkboxes) { 
				 * if (checkbox.isSelected()) {
				 * count++; 
				 *    }
				 *  }
				 */
		        
		        
		      
		        
		         Stream st=list.stream();
		        long count1=st.filter(checkbox->((WebElement)checkbox).isSelected()).count();
		          
		            
		        System.out.println("Number of selected checkboxes: " + count1);

		        // Close the browser
		        //driver.quit();
		    }
		}
