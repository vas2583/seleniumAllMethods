package om.nt.slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args)throws Exception {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	     driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");
	    WebElement element= driver.findElement(By.xpath("//input[@type='range' and @id='ageInputId']"));
		System.out.println(element.getLocation());
		System.out.println(element.getLocation().getX());
		Thread.sleep(2000);
		Actions ac=new Actions(driver);
		ac.dragAndDropBy(element,282,204).perform();
		System.out.println(element.getAttribute("value"));
		 Thread.sleep(2000);
		 ac.dragAndDropBy(element,382,204).perform();
		 System.out.println(element.getLocation());
		 
		

	}

}
