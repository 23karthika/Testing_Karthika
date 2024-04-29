package com.kavin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
    Actions action;
    Wait<WebDriver> wait;

    @BeforeTest
    public void init() {
        webDriver = new ChromeDriver();
        action = new Actions(webDriver);

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    }

    @Test
    public void operations() {
        webDriver.get("https://groww.in/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Calculators")));
        action.moveToElement(webDriver.findElement(By.linkText("Calculators"))).perform();
        ;

        webDriver.findElement(By.linkText("Calculators")).click();

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[2]/a[15]")));

        webDriver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/a[15]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input")));

        WebElement amt = webDriver.findElement(By.xpath(
                "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input"));
        amt.clear();
        amt.sendKeys("2300000");

        WebElement intrst = webDriver.findElement(By.xpath(
                "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div/input"));
        intrst.clear();
        intrst.sendKeys("8");

        WebElement yr = webDriver.findElement(By.xpath(
                "/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/input"));
        yr.clear();
        yr.sendKeys("25");

        WebElement table = webDriver
                .findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table"));
        System.out.println(table.getText());
    }

    @AfterTest
    public void destruct() {
        webDriver.quit();
    }
}
