package windowHandles;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) throws Exception {
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://text-compare.com/");
			driver.manage().window().maximize();
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			String window=driver.getWindowHandle();
			System.out.println(window);
			Set<String> windows=driver.getWindowHandles();
			List<String> windowList=new ArrayList<>(windows);
             driver.switchTo().window(windowList.get(1));
             
			/*
			 * for(String ids: windows) { driver.switchTo().window(ids); break; }
			 */
			
	}

}
