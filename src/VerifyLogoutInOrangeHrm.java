import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogoutInOrangeHrm {

	public static void main(String[] args)throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("login successfull");
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.linkText("Add Employee")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("logout sucessfull");
	}

}
