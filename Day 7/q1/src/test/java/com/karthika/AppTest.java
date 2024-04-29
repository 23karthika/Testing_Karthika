package com.karthika;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    String URL = "https://economictimes.indiatimes.com/et-now/results/";
    WebDriver webDriver;
    Wait<WebDriver> wait;
    WebElement drop1;
    WebElement drop2;
    Select sel;

    @BeforeTest
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        this.webDriver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @Test
    public void performTasks() {
        webDriver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mutual Funds")));
        webDriver.findElement(By.linkText("Mutual Funds")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("amc")));
        drop1 = webDriver.findElement(By.name("amc"));
        sel = new Select(drop1);
        sel.selectByVisibleText("Canara Robeco");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("schemenm")));
        drop2 = webDriver.findElement(By.id("schemenm"));
        sel = new Select(drop2);
        sel.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("anchor3")));
        webDriver.findElement(By.id("anchor3")).click();
        for (String handle : webDriver.getWindowHandles()) {
            if (!handle.equals(webDriver.getWindowHandle())) {
                webDriver.switchTo().window(handle);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("installment_amt")));
        webDriver.findElement(By.id("installment_amt")).click();

        WebElement per = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]")));

        per.click();

        webDriver.findElement(By.id("installment_period")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[5]")));

        webDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[5]"))
                .click();

        webDriver.findElement(By.xpath("/html/body/main/div[10]/section[3]/div/ul/li[2]")).click();
    }

    @AfterTest
    public void end() {
        System.out.println(webDriver.findElement(By.xpath(
                "/html/body/main/div[10]/section[5]/div/div[1]/section[1]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"))
                .getText());
        webDriver.quit();
    }
}
