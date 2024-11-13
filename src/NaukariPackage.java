import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukariPackage {

	public static void main(String[] args) throws AWTException, Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://www.naukri.com/mnjuser/homepage");
	   driver.findElement(By.id("usernameField")).sendKeys("abhishekroc890@gmail.com");
	   driver.findElement(By.id("passwordField")).sendKeys("Chintu@567");
	   driver.findElement(By.xpath("//button[@type='submit' and text()='Login']")).click();
	   driver.findElement(By.xpath("//div[@class='view-profile-wrapper']//a")).click();
	   driver.findElement(By.xpath("//input[@type='button' and @value='Update resume']")).click();
	   Thread.sleep(5000);
	   StringSelection selection=new StringSelection("C:\\Users\\vasuk\\OneDrive\\Documents\\InterviewDocs\\Vasu_QA1.pdf");
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
	   Thread.sleep(5000);
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_CONTROL);
	   r.keyPress(KeyEvent.VK_V);
	   r.keyRelease(KeyEvent.VK_CONTROL);
	   r.keyRelease(KeyEvent.VK_V);
	   
	   r.keyPress(KeyEvent.VK_ENTER);
	   r.keyRelease(KeyEvent.VK_ENTER);
	   
	   
	   
	   
	   
	}

}
