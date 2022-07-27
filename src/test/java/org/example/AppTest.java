package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofMillis;


public class AppTest {

    public static void main(String[] args) throws InterruptedException {

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome_Web_Driver\\chromedriver.exe");

        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        // Launch Website
        driver.navigate().to("https://pastebin.com/");

        //Maximize the browser
        driver.manage().window().maximize();
        WebElement newPaste = driver.findElement(By.name("PostForm[text]"));
        newPaste.sendKeys("Hello from Web Driver Sanjeev");
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)"," ");
       WebElement elem = driver.findElement(By.id("select2-postform-expiration-container"));
       Thread.sleep(2000);
       System.out.println(new WebDriverWait(driver,ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(elem)).isDisplayed());
       new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(elem)).click();
       driver.findElement(By.xpath("//span[@class= 'select2-results']/ul/li[3]")).click();
       driver.findElement(By.id("postform-name")).sendKeys("Hello web from sanjeev");
       driver.findElement(By.xpath("//button[text() = 'Create New Paste']")).click();




    }
}
