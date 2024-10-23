package com.nt.methods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMethodsRt {

	public static void main(String[] args)throws Exception {
		//WebDriverManager manager=new ChromeDriverManager();
	        //  manager.chromedriver().setup();
//Chrome Options
		  //1st HeadLessMode
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--headless");
		
		  //Running Incoginto
		//options.addArguments("--incognito");
		
		//3rd Disable Extentions
		 //options.addArguments("--disable-extensions");
		
		//4th Launch Chrome With MaximAzied Window
		  // options.addArguments("--start-maximize");
		
		options.addArguments("window-size=1920,1080");
		//
		WebDriver driver=new ChromeDriver(options);
		//driver.manage().window().maximize();
		//implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//get Methods And Rts
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		String pageSource=driver.getPageSource();
		Object obj=driver.getClass();
		System.out.println(obj);
		//open New Window
		driver.switchTo().newWindow(WindowType.TAB);
		 //navigateMethods And Rt
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
//window Handles
		  //geting Current Window value
		String winVal=driver.getWindowHandle();
		System.out.println(winVal);
		//getting all windows VALUES ThatAre Open In WebDriver
		 Set<String> winVals=driver.getWindowHandles();
		 for(String s:winVals) {
			 System.out.println(s);
		 }
		 //switch one Window to another Window
		 List<String> wins=new ArrayList<>(winVals);
		 driver.switchTo().window(wins.get(0));  
		 
//Alerts
		 //simpleAlert
		 driver.switchTo().newWindow(WindowType.TAB);
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.findElement(By.id("alertBtn")).click();
		 Alert a=driver.switchTo().alert();
		 //get Text fROM ALERT bOX
		  String text=a.getText();
		  System.out.println("alert Trext::"+text);
		  //click on Ok Button
		  a.accept();
		  
		  //Conformation Alert
		  driver.findElement(By.id("confirmBtn")).click();
		  Alert a1=driver.switchTo().alert();
		  String conText=a1.getText();
		  System.out.println("ConformationText"+conText);
		  //click on Cancle Button
		  a1.dismiss();
		  
		  //PromptAlert
		  driver.findElement(By.id("promptBtn")).click();
		  Alert a2=driver.switchTo().alert();
		  String promtText=a2.getText();
		  System.out.println("PromptrtEXT::"+promtText);
		  a2.sendKeys("vasuAnjana");
		  a2.accept();
		  
		  //Alert Without Using SwitchTo()
		  //ExplicitWait in Condition
		  driver.findElement(By.id("promptBtn")).click();
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		  Alert popUp=wait.until(ExpectedConditions.alertIsPresent());
		  System.out.println("PromptText WithOUT uSING SwitchTo()::"+popUp.getText());
		  popUp.sendKeys("VASUANJANA");
		  popUp.accept();
		  
//ElemenInteraction Methods
		  Set<String> w=driver.getWindowHandles();
		  List<String>l=new ArrayList(w);
		    driver.switchTo().window(l.get(0));
		//findElement mETHOD
		    WebElement un=driver.findElement(By.name("username"));
		    WebElement pas=driver.findElement(By.name("password"));
		    WebElement log=driver.findElement(By.xpath("//button[@type='submit']"));
		    
		  //getAttribute
		       String attVal=un.getAttribute("class");
		        System.out.println("AttVal::"+attVal);
		        
		    //get CssValue
		        String cssValue=log.getCssValue("color");
		        System.out.println("color::"+cssValue);
		    //get TagName
		        String tagName=log.getTagName();
		        System.out.println("tagName::"+tagName);
		    //isEnable
		      boolean unEn=un.isEnabled();
		      boolean psEn=pas.isEnabled();
		    //is DisPlayed
		      boolean logDis=log.isDisplayed();
		   if(unEn==true)
		      un.sendKeys("Admin");
		   if(psEn==true)
		      pas.sendKeys("admin123");
		   if(logDis==true)
		       log.submit();
		   
		 //findElements
		    List<WebElement> li=driver.findElements(By.tagName("a"));
		    int count=li.size();
		    if(count==15)
		    	System.out.println("thre are 15 links in that page");
		    else
		    	System.out.println("thre are"+count+" links in that page");
		    
		    
//checkBox and RADIO BUTTON
		  driver.switchTo().window(l.get(2));
		   //radioButton
		  WebElement radBtn=driver.findElement(By.id("male"));
		  boolean rb=radBtn.isSelected();
		  if(rb!=true) {
			  radBtn.click();
			  System.out.println("radio Button Selected");
		  }
		  
		  //checkBox &MultipleCheckBox
		  WebElement chBox;
		  boolean cb;
		  chBox=driver.findElement(By.id("sunday"));
		   cb=chBox.isSelected();
		  if(cb!=true) {
		      chBox.click();
		      System.out.println("checkBox One is Selected");
		  }
		  chBox=driver.findElement(By.id("saturday"));
		  cb=chBox.isSelected();
		   if(cb!=true) {
		        chBox.click();
		        System.out.println("individuval Multiple checkBox Selected");
		   }
		   //select Multiple CheckBox if There is Not Selected
		   List<WebElement> mChBox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		   for(int i=0;i<mChBox.size();i++) {
			   if(mChBox.get(i).isSelected()) {
				   System.out.println("ALREADY selected");
			   }
			   else {
				   mChBox.get(i).click();
				   System.out.println(mChBox.get(i).getText()+" is Selected Now");
			     } 
			 //select last 3 CheckBox and And unSelect first 4 checkBoxes  
			 if(i<=3) {
				 mChBox.get(i).click();
				 System.out.println("Un selected the CheckBox"+(i+1));	 
			      }
		   }
		   
//DropDown All The Posible Syntaxes
     //1StPosible SelectByVisibleText(),SelectByValue(),SelectByIndex()
		  WebElement dropDown=driver.findElement(By.xpath("//select[@id='country']"));
		   Select s=new Select(dropDown);
		   s.selectByVisibleText("Canada");
		   Thread.sleep(1000);
		   //s.deselectByVisibleText("Canada");
		   Thread.sleep(1000);
		   s.selectByValue("canada");
		   Thread.sleep(1000);
		   //s.deselectByValue("Canada");
		   Thread.sleep(1000);
		   s.selectByIndex(2);
		   //s.deselectByIndex(1);
	
	//2nd Posible get All Options and Select 
		   List<WebElement>dropDownOptions=s.getOptions();
		   //print All Options
		   for(WebElement option:dropDownOptions) {
			   String optionText=option.getText();
			   System.out.println(optionText);
			   
			   if(optionText.equals("India")) {
				   System.out.println("India Is Present In DropDown List");
				   s.selectByVisibleText("India");
				   System.out.println("India Is Selected");
			   }
		   }
		     WebElement wrapElemt=s.getWrappedElement();
		     System.out.println(wrapElemt);
		     
		    boolean mulDD=s.isMultiple();
		    System.out.println(mulDD);
		    
//Static WebTable
	//Retriveing All the Eleemnts From  WebTable
     //getING No Of rows In Table
		     int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
      //getIng No Of Columns
		     int cols=driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]//th")).size();
		//Now Retrive The data From table Using Loop
		      for(int i=2;i<=rows;i++) {
		    	  for(int j=1;j<=cols;j++) {
		    		  String td=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
		    		   System.out.print(td+" ");
		    	  }
		    	  System.out.println();
		      }
		      
		   //To retrive Particular Cell Data
		  String cellData=driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]//td[3]")).getText();
		     System.out.println("particular Cell Data::"+cellData);
		     System.out.println("======================");
		     
//Dynamic WebTable Using Pagination
		     //Firtst Find No Of Pages if we it display Last Num
		int noOfPages=driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();
   //Find Each Page No of Rows ANd Coilumns And Display Details And CheckBox Selected
		    int dwttrows=driver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
		    int dwtCols=driver.findElements(By.xpath("//table[@id='productTable']//tr[1]//th")).size();
		     for(int i=1;i<=noOfPages;i++) {
		    	 System.out.println("The "+i+" production Details");
		    	  WebElement activePage=driver.findElement(By.xpath("//ul[@id='pagination']//li//a[text()='"+i+"']"));
		    	   if(i>1) {
		    		activePage.click();
		    	      }
		    	 for(int j=1;j<dwttrows;j++) {
		    		 WebElement txt=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[1]"));
		 			WebElement txt1=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[2]"));
		 			WebElement txt2=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[3]"));
		 			WebElement txt3=driver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]/td[4]//input[@type='checkbox']"));
		 			     
		 		       String td1=txt.getText();
		 		       int id=Integer.parseInt(td1);
		 		        if(id==1|| id==6 ||id==11 ||id==20) {
		 		        	txt3.click();
		 		             }
		 		        String td2=txt1.getText();
		 		        String td3=txt2.getText();
		 		        boolean bo1=txt3.isSelected();
		 		       System.out.println(td1+" "+td2+" "+td3+" "+bo1);
		    	         }
		    		 System.out.println();
		            }
		     
//Dynamic WebTable every time changes in Columns and Rows
		     //No of Rows
		    List<WebElement> row=driver.findElements(By.xpath("//table[@id='taskTable']/tbody/tr"));
		    int noOfRows=row.size();
		    for(int i=1;i<=noOfRows;i++) {
		    	WebElement bro=driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr["+i+"]/td[1]"));
		    	String broName=bro.getText();
		    	if(broName.equals("Chrome")) {
		    		WebElement ele=driver.findElement(By.xpath("//td[text()='Chrome']/following-sibling::*[contains(text(),'%')]"));
		    		String cpu=ele.getText();
		    	      System.out.println("chrome Cpu usage::"+cpu);	
		    	   
		    	   WebElement acpeCpu=driver.findElement(By.xpath("//p[text()='CPU load of Chrome process: ']/strong"));
		    	   String ac=acpeCpu.getText();
		    	   if(cpu.equals(ac)) {
		    		   System.out.println("cpu time matched As expexted::"+cpu+"=="+ac);
		    	   }
		    	   else
		    		   System.out.println("Cpu time not matched::"+cpu+"!="+ac);
		    	}
		    }

//DatePaicker Jquery
     String month="August";
     String year="2025";
     String date="17";
     
     //find The Element
     WebElement dataPicker=driver.findElement(By.xpath("//input[@id='datepicker']"));
		     dataPicker.click();
		  while(true){
		String getMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String getYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		  if(month.equals(getMonth)&&year.equals(getYear)) {
			  System.out.println("Year ANd Month Selected");
			  break;
		             }
		  WebElement next=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		  		next.click();
		  }
		  //select Date iN datePicker Is WEbTable it is in Table Format
		    //rows
		  List<WebElement> dr=driver.findElements(By.xpath("//table[contains(@class,'ui-date')]//tbody/tr"));
		  int totlaRows=dr.size();
		  List<WebElement>dc=driver.findElements(By.xpath("//table[contains(@class,'ui-date')]//tbody/tr[1]//td"));
		  int totalCols=dr.size();
		  for(int i=1;i<=totlaRows;i++){
			  for(int j=1;j<=totalCols;j++) {
				WebElement dt=driver.findElement(By.xpath("//table[contains(@class,'ui-date')]//tbody/tr["+i+"]//td["+j+"]"));
				String getDate=dt.getText();
				if(date.equals(getDate)) {
					dt.click();
					break;
				    }//if
			    }//inner forllop  
		  }//outer forloop	
//Action Methods In ActionClass
		  //MoveToElement();
		  WebElement apple=driver.findElement(By.linkText("Apple"));
		  apple.click();
		  WebElement store=driver.findElement(By.xpath("(//span[@class='globalnav-link-text-container'])[1]"));
		  Actions ac=new Actions(driver);
		  ac.moveToElement(store).perform();
		Thread.sleep(1000);
		driver.navigate().back();
		//RightClick()
		WebElement btn=driver.findElement(By.id("btn1"));
		ac.contextClick(btn).perform();
		Thread.sleep(1000);
		
		//Dynamic WebElement And Double Click();
		  WebElement star=driver.findElement(By.xpath("//button[@name='start' or @name='stop']"));
		  ac.doubleClick(star).build().perform();
		   Thread.sleep(1000);
		//dragANdDrop()
		   WebElement source=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		   WebElement target=driver.findElement(By.id("droppable"));
		   ac.dragAndDrop(source,target).perform();
	    //dragAndDropBy()
		   WebElement myslider=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]"));
		   //get Location Of Point
		   System.out.println("location of My silder is::"+myslider.getLocation());
		   //get X-axis And Y axis Location
		   int x=myslider.getLocation().getX();
		   int y=myslider.getLocation().getY();
		   System.out.println("x-axis::"+x+"\n y-axis::"+y);
		   ac.dragAndDropBy(myslider,250,0).perform();
		   int x1=myslider.getLocation().getX();
		   int y1=myslider.getLocation().getY();
		   System.out.println("x-axis::"+x1+"\n y-axis::"+y1);
		   
//JavaScript Executor USING Selenium
		   //sendKeys
		   WebElement ele=driver.findElement(By.id("name"));
		   JavascriptExecutor js=(JavascriptExecutor) driver;
		   js.executeScript("arguments[0].value='VASU';",ele);
		   System.out.println("Name Is Executed ");
		   //clcik
		   WebElement ele1=driver.findElement(By.xpath("//button[@name='start' or @name='stop']"));
		   js.executeScript("arguments[0].click();",ele1);
		   System.out.println("start button clcik");
		   
		   //scroll Page using y-axis
		   js.executeScript("window.scrollBy(0,2700)","");
		   System.out.println("scroll Upto 2700 in y-axis");
		   Thread.sleep(1000);
		   
		   //scrollPage Particular Element
		     WebElement el2=driver.findElement(By.xpath("//h2[text()='Pagination Web Table']"));
		     js.executeScript("arguments[0].scrollIntoView();",el2);
		     System.out.println("scroll Upto page NationTable");
		     Thread.sleep(1000);
		   //scrollPage Upto last
		     js.executeScript("window.scrollBy(0,document.body.scrollhHeight)");
		     
		    System.out.println("scroll Upto last");
		      Thread.sleep(1000);
		    //scrollPage upto top
		     js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		      System.out.println("scroll upto first");
//ScreenShot In Different Formats AND wITH TIMESTAMP AND Path
		      //Full page
		        //1ST Get date And Time Stamp
		      Date date1=new Date();
		      String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date1);
		      String OriginalPath=System.getProperty("user.dir");
		      String TargetFile=OriginalPath+"\\screenshots\\fullpage_"+timeStamp+".png";
		        TakesScreenshot ts=(TakesScreenshot) driver;
		        
		        File src=ts.getScreenshotAs(OutputType.FILE);
		         File TargetFiles=new File(TargetFile);
		         FileUtils.copyFile(src, TargetFiles);
		     
		     //screenShot on FullBody In Hyml
		         WebElement scs=driver.findElement(By.xpath("//body[@style='cursor: auto;']"));
		         File src1=scs.getScreenshotAs(OutputType.FILE);
		         String TargetFile1=OriginalPath+"\\screenshots\\fullbody_"+timeStamp+".png";
		         File TargetFilebody=new File(TargetFile1);
		         FileUtils.copyFile(src1,TargetFilebody);
//list box Elements Are SOrted Or Not
		    WebElement lis=driver.findElement(By.xpath("//select[@id='colors']"));
		      Select listBox=new Select(lis);
		      List<WebElement> option=listBox.getOptions();
		      List<String> original=new ArrayList<String>();
		      List<String> temp=new ArrayList<String>();
		      
		      for(WebElement opt:option) {
		    	  original.add(opt.getText());
		    	  temp.add(opt.getText());  
		         }
		      
		      Collections.sort(original);
		      System.out.println(original);
		      System.out.println(temp);
		      
		      if(original.equals(temp)) {
		    	  System.out.println("List is in Sorted Order");
		      }
		      else
		    	  System.out.println("List IS nOT sORTED oRDER");
		      
//ListBox As Duplicate Values
		   Set<String> uniqueOptions=new HashSet();
		   boolean flag=false;
		     for(WebElement unOp:option) {
		    	 String ta=unOp.getText();
		            if(!uniqueOptions.add(ta)) {    	 
		    	 		System.out.println("The Dupicate Values is::"+ta);
		    	 		flag=true;
		    	 		}
		            
		            if(flag==false) {
		            	System.out.println("There is No Duplicate in The List::");
		            }
		     }
//eNTER kEYS uSING Actions Class
		  //sswitch to 2nd Window
		     driver.switchTo().window(l.get(1));
		        WebElement un1=driver.findElement(By.name("username"));
			    WebElement pass1=driver.findElement(By.name("password"));
			    WebElement log1=driver.findElement(By.xpath("//button[@type='submit']"));   
		   
			 Actions ac1=new Actions(driver);
			 ac1.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		      ac1.sendKeys("Admin").perform();
		       ac1.keyDown(Keys.TAB).sendKeys("admin123").keyUp(Keys.TAB).perform();
		       ac1.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		       ac1.keyDown(Keys.ENTER).perform();
		       System.out.println("Login SuccessfULL");
		       
		     
		 
	  }//main    	  
	}//class


