package com.nt.alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertClass {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		/*
		 * driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click()
		 * ; Alert a=driver.switchTo().alert(); System.out.println(a.getText());
		 * a.accept();
		 * driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click
		 * (); Alert a1=driver.switchTo().alert(); System.out.println(a1.getText());
		 * a1.dismiss();
		 * driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click(
		 * ); Thread.sleep(5000); Alert a2=driver.switchTo().alert();
		 * System.out.println(a2.getText()); a2.sendKeys("anajana"); a2.dismiss();
		 */
		
		//with out switchTo method
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Alert a4=wait.until(ExpectedConditions.alertIsPresent());
		  System.out.println(a4.getText());
		  a4.accept();
        driver.close();
	}

}
