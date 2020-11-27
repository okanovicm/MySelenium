package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Web drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope

        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //limiting scope to one section

        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

            String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
            Thread.sleep(5000);

        }//opens all tabs

        Set<String> abc = driver.getWindowHandles();
        Iterator<String> it = abc.iterator();

        //Itarets for every tab
        while(it.hasNext()){

            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
