package com.nt.webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableWithPageination {
	public static void getProductionDetailsWithOutSelectCheckBox() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> noofPages=driver.findElements(By.xpath("//ul[@id='pagination']/li"));
		int size=noofPages.size();
		System.out.println(size);
		int rows =driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
		System.out.println(rows);
		
		int cols=driver.findElements(By.xpath("//table[@id='productTable']//tr/th")).size();
		System.out.println(cols);
		
		for(int i=1;i<=size;i++){
			 System.out.println("the "+i+" page Production Details");
			WebElement activePage=driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()="+i+"]"));
			if(i>1) {
				activePage.click();
				Thread.sleep(2000);
			} 
			  for(int j=1;j<rows;j++) {
			WebElement text=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[1]"));
			WebElement text1=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[2]"));
			WebElement text2=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[3]"));
			WebElement text3=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[4]"));
		       String td1=text.getText();
		        String td2=text1.getText();
		        String td3=text2.getText();
		        boolean bo1=text3.isSelected();
		       System.out.println(td1+" "+td2+" "+td3+" "+bo1);
			     }
			 
		       }
		System.out.println("================================================");
	}
     public static void SelectSomeCheckBoxRandomly() throws Exception {
    	 int count=0;
    	  WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://testautomationpractice.blogspot.com/");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          List<WebElement> noofPages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
          int size = noofPages.size();
          System.out.println("Total pages: " + size);

          int rows = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
          System.out.println("Total rows (including header): " + rows);

          int cols = driver.findElements(By.xpath("//table[@id='productTable']//tr/th")).size();
          System.out.println("Total columns: " + cols);

          System.out.println("Selecting specific checkboxes and verifying selection");

          for (int i = 1; i <= size; i++) {
              System.out.println("The " + i + " page Production Details");
              WebElement activePage = driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()=" + i + "]"));
              if (i > 1) {
                  activePage.click();
                  Thread.sleep(2000);  
              }
             

              for (int j = 2; j < rows; j++) { 
                  WebElement text = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]/td[1]"));
                  WebElement text1 = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]/td[2]"));
                  WebElement text2 = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]/td[3]"));
                  WebElement checkbox = driver.findElement(By.xpath("//table[@id='productTable']//tr[" + j + "]/td[4]/input[@type='checkbox']"));

                  String td1 = text.getText();  // ID value
                  int id = Integer.parseInt(td1);
                  if (id == 2 || id == 7 || id == 12 || id == 17) {
                      checkbox.click();
                  }
                  String td2 = text1.getText();
                  String td3 = text2.getText();
                //  boolean td4  = checkbox.isSelected(); 
                  if(checkbox.isSelected()) {
                	  count++;
                  }

                  //System.out.println(td1 + " " + td2 + " " + td3 + " " + td4);
               
              }
          }
          //System.out.println(count);
     }
     
     public static void SelectCountOfCheckboxes() throws Exception {
     	 int count=0;
   	  WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://testautomationpractice.blogspot.com/");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         List<WebElement> noofPages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));
         int size = noofPages.size();
         System.out.println("Total pages: " + size);

         int rows = driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
         System.out.println("Total rows (including header): " + rows);

         int cols = driver.findElements(By.xpath("//table[@id='productTable']//tr/th")).size();
         System.out.println("Total columns: " + cols);
           
         System.out.println("Selecting specific checkboxes and verifying selection");
             List<WebElement> list=driver.findElements(By.xpath("//table[@id='productTable']//tr/td[4]"));
              for(WebElement ele: list) {
            	  ele.click();  
              }
             long st=list.stream().filter(s->s.isSelected()).count();
              System.out.println(st);
         }
     
            	
         
            	
            
                 
	public static void main(String[] args)throws Exception {
		//getProductionDetailsWithOutSelectCheckBox();
		//SelectSomeCheckBoxRandomly();
		SelectCountOfCheckboxes();
		
		
	}
}

