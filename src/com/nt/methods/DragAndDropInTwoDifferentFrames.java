package com.nt.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragAndDropInTwoDifferentFrames {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://G:/WorkSpeace/dragandDropWithTwoFrames/index.html");
		driver.switchTo().frame("sourceFrame");
		WebElement source=driver.findElement(By.id("sub-frame-error"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("destinationFrame");
		//WebElement ele=driver.findElement(By.)
		
		

	}

}
