import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
     driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("welcom");
     Thread.sleep(2000);
     Actions ac=new Actions(driver);
     ac.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
    
     ac.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
     
     ac.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
    
     ac.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
     System.out.println("text Copied from one to another");
     
     
     
	}

}
