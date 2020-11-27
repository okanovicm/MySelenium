package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class framesExercise {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Web drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
        System.out.println(driver.findElement(By.id("content")).getText());

    }
}
