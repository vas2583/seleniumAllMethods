package com.nt.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullPage {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		TakesScreenshot ts=(TakesScreenshot)driver;
		/*
		 * File src=ts.getScreenshotAs(OutputType.FILE); File file=new
		 * File(System.getProperty("user.dir")+"\\screenshot\\fullpage1.png");
		 * //src.renameTo(file); FileUtils.copyFile(src, file);
		 */
		
		//particular Part
		/*
		 * WebElement
		 * ele=driver.findElement(By.xpath("//div[@class='orangehrm-login-form']"));
		 * File src=ele.getScreenshotAs(OutputType.FILE); File target=new
		 * File(System.getProperty("user.dir")+"\\screenshot\\somePart.png");
		 * src.renameTo(target);
		 */
		//particular Element
		WebElement ele=driver.findElement(By.xpath("//img[@alt='//img[@alt='company-branding']"));
		 File src=ele.getScreenshotAs(OutputType.FILE);
		 File target=new File(System.getProperty("user.dir")+"\\screenshot\\oneEle.png");
		 src.renameTo(target);
		 
		
		
	}

}
