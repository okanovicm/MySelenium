package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TableExercises {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Web drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/31888/clk-vs-kdt-1st-match-lanka-premier-league-2020");

        int sum = 0;

        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));

        int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();

        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

        for (int i = 0; i < count-2; i++){
            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int valueInteger = Integer.parseInt(value);
            sum = sum + valueInteger;
        }
        //System.out.println(sum);

        String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
        int extrasValue = Integer.parseInt(extras);

        sum = sum + extrasValue;

        String total = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
        int totalValue = Integer.parseInt(total);

        if (sum == totalValue){
            System.out.println("Sum is correct: " + sum + ", test passed.");
        }else{
            System.out.println("Incorrect sum, test failed.");
        }

    }
}
