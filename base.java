package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class base {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Web drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait w = new WebDriverWait(driver, 5);

        //expected
        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        //expplicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.promoBtn")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded){
        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i = 0; i < products.size(); i++){
            String[] name = products.get(i).getText().split("-");
            String formatedName = name[0].trim();
            //Cucumber - 1 Kg
            //format text
            //convert array into array list for easy search
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(formatedName)){
                j++;
                //Click on add to cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j == itemsNeeded.length){
                    break;
                }
            }
        }
    }

}
