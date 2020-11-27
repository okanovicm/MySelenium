package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tables {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Web drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.id("product"));
        int rowCount = table.findElements(By.tagName("tr")).size();
        System.out.println("Number of rows: " + rowCount);

        WebElement rows = table.findElement(By.tagName("tr"));
        int columnCount = rows.findElements(By.tagName("th")).size();
        System.out.println("Number of columns: " + columnCount);

        System.out.println(table.findElement(By.xpath("//tbody/tr[3]")).getText());
    }
}
