package com.kavin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver webDriver;
    Wait<WebDriver> wait;
    String URL = "https://www.ixigo.com/";

    @BeforeTest
    public void init() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @Test
    public void operations() throws InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.get(URL);
        // roundButton
        webDriver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]")).click();

        // FROM
        WebElement from = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]")));
        from.click();

        WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input")));
        fromInput.clear();
        fromInput.sendKeys("IDP");
        Thread.sleep(2000);
        WebElement innerFrom = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]")));
        innerFrom.click();

        // TO
        WebElement to = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]")));
        to.click();
        WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input")));
        toInput.clear();
        toInput.sendKeys("DEL");
        Thread.sleep(2000);
        WebElement innerTo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]")));
        innerTo.click();

        // DEPARTURE
        WebElement departure = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]")));
        departure.click();

        Thread.sleep(1000);
        WebElement depart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/div/div[2]/button[10]")));
        depart.click();

        // automatically redirects to return
        // RETURN
        WebElement returnInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[24]")));
        returnInput.click();

        // traveller
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[2]")));
        webDriver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[2]"))
                .click();
        Thread.sleep(1000);

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
        // "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[2]")));
        webDriver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[2]"))
                .click();
        Thread.sleep(1000);

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
        // "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div[3]/div[2]/div/button[2]")));
        webDriver.findElement(By.xpath(
                "/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[3]/div[2]/div/button[2]"))
                .click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/button")).click();

    }

    @AfterTest
    public void destruct() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }
}
