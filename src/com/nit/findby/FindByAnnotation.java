package com.nit.findby;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindByAnnotation {
	WebDriver driver;
	@BeforeMethod
	@Parameters({"browser"})
	 public void tearUp(String browser) {
		 if(browser.equals("chrome")) {
			 //WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		   }
		 
		 if(browser.equals("edge")) {
			// WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 }
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   }

	@Test(groups={"smoke"})
	public void login() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPage page=new LoginPage(driver);
		 //enter userName
		  page.username();
		  //enetr the password
		  page.password();
		  //click on loginButton
		  page.performlogin();

	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

}
