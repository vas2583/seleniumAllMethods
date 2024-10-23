package com.nt.webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		List<WebElement> list=driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		int rows=list.size();
		System.out.println(rows+" no of rows");
	List<WebElement>list1=driver.findElements(By.xpath("//table[@name='BookTable']//tr/th"));
	int cols=list1.size();
	System.out.println("no of columns::"+cols);
//get Particular col data 
	String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
	System.out.println(data);
	//get Speciofic row
	List<WebElement> data1=driver.findElements(By.xpath("//table[@name='BookTable']//tr[5]/td"));
	 for(WebElement data2: data1) {
		 System.out.print(data2.getText()+" ");
	 }
	 System.out.println("=======================================\n");
	  for(WebElement colData:list1) {
		  String colName=colData.getText();
		  System.out.print(colName+" ");
	  }
    System.out.println();
   //get All rows Data excluding on COlumn Heading
		 for(int row=2;row<=rows;row++) {
			 for(int col=1;col<=cols;col++) {
				 String msg=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]/td["+col+"]")).getText();
				 System.out.print(msg+" ");
			 }
			 System.out.println();
		 }
		 System.out.println("==========================================");
       		//AuthorNames of Tbale
		 for(int i=2;i<=rows;i++) {
		 String str=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[2]")).getText();
		 //System.out.println(str);
		  if(str.equalsIgnoreCase("mukesh")) {
			 String name= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[1]")).getText();
			 System.out.println(name+"\t"+str); 
		  }
		 
		 }
		//total price of Books
		 int sum=0;
		 for(int i=2;i<=rows;i++) {
		 String str=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[4]")).getText();
		  int price=Integer.parseInt(str);
		  sum=sum+price;
		 }
		 System.out.println(sum);
	 }
	}


