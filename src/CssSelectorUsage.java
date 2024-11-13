import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CssSelectorUsage {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
 //find By tag Name
	    List<WebElement> li=driver.findElements(By.cssSelector("a"));
	      for(WebElement ele:li) {
		System.out.println(ele.getText());
	    }
		 
//login function using class id  with css Selector
	      WebElement un=driver.findElement(By.cssSelector("[name='username']"));
	      un.sendKeys("Admin");
	      WebElement pass=driver.findElement(By.cssSelector("[type='password']"));
	      pass.sendKeys("admin123");
	      WebElement log=driver.findElement(By.cssSelector("[type='submit']"));
	      log.click();
	      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	     WebElement home=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
	     WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
	      
	      if(ele.isDisplayed()) {
	    	  System.out.println("Login SuccessFull");
	        }
	      else
	    	  System.out.println("Login Not sucessFull");
	      
	      //open new tab
	        driver.switchTo().newWindow(WindowType.TAB);
	        driver.get("https://www.amazon.in/");
	        WebElement search=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
	        search.sendKeys("shoes");
	        search.sendKeys(Keys.ENTER);
	        
	       int size=driver.findElements(By.cssSelector("div .s-image")).size();
	       System.out.println(size);
	        
	        
	     // driver.quit();
	      
	      
	      

	 }

}
