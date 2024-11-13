package com.nt.methods;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadWithOutSendkeys {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        WebElement img=driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        img.click();
        Thread.sleep(10000);
        StringSelection selectio=new StringSelection("C:\\Users\\vasuk\\OneDrive\\Documents\\InterviewDocs\\vasu_img.JPEG");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectio, null);
        System.out.println("Copy the PATH TO CLIPBOARD");
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(5000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("paste to path clipboard");
        

        
    }
}
