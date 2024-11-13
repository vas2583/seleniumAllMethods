package com.nit.findby;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="username")
	WebElement un;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	  }
	
	//Methods to perform this page
	  public void username() {
		  un.sendKeys("Admin");
	  }
	  public void password() {
		  pass.sendKeys("admin123");  
	  }
	  public void performlogin() {
		  login.click();
	  }

}
