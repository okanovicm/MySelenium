package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class multipleWindows {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Web drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");

        driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[1]/a")).click();
        System.out.println(driver.getTitle());

        //requires to put into set data structure (Set <String>)
        Set <String> ids = driver.getWindowHandles();

        //iterator method
        Iterator<String> it = ids.iterator();

        //setting a path
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());

    }
}
