package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DropdownSuggestive {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Web drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("UNI");
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));



        //JavaScript
        /*JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById('autocomplete').value;";
        String text = (String) js.executeScript(script);
        System.out.println(text);

        int i = 0;

        while(!text.equalsIgnoreCase("United States (USA)")){
            i++;
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);
            System.out.println(text);
            if (i > 10){
                break;
            }
        }
        if(i > 10){
            System.out.println("Country not founded");
        }else {
            System.out.println("Country founded: " + text);
        }*/
    }
}
