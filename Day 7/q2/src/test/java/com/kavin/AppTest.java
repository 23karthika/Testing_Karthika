package com.kavin;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
    WebDriver webDriver;
    Wait<WebDriver> wait;
    Actions actions;

    @BeforeTest
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        webDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        actions = new Actions(webDriver);
    }

    @Test
    public void operations() {
        webDriver.get("https://www.moneycontrol.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_str")));
        webDriver.findElement(By.id("search_str")).click();
        webDriver.findElement(By.id("search_str")).sendKeys("Reliance Industries");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]/a")));
        webDriver
                .findElement(By.xpath(
                        "/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]/a"))
                .click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("/html/body/div[13]/div[2]/div[2]/div[2]/div[1]/div/h1")));
        if (webDriver.findElement(By.xpath("/html/body/div[13]/div[2]/div[2]/div[2]/div[1]/div/h1")).getText()
                .equals("Reliance Industries Ltd.")) {
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.linkText("Mutual Funds")));

            actions.moveToElement(webDriver.findElement(By.linkText("Mutual Funds"))).perform();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SIP Return")));
            webDriver.findElement(By.linkText("SIP Return")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ff_id")));

            WebElement fund = webDriver.findElement(By.id("ff_id"));
            Select fundSelect = new Select(fund);
            fundSelect.selectByVisibleText("Axis Mutual Fund");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("im_id")));

            WebElement scheme = webDriver.findElement(By.id("im_id"));
            Select schemSelect = new Select(scheme);
            schemSelect.selectByVisibleText("Axis Arbitrage Fund - Direct Plan (G)");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("invamt")));
            WebElement inp = webDriver.findElement(By.name("invamt"));
            inp.sendKeys("100000");
            WebElement st = webDriver.findElement(By.id("stdt"));
            st.sendKeys("2021-08-02");
            WebElement end = webDriver.findElement(By.id("endt"));
            end.sendKeys("2023-08-17");

            webDriver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input"))
                    .click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[5]/table/tbody/tr[1]/td[2]")));

            System.out.println(webDriver
                    .findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[5]/table/tbody/tr[1]/td[2]"))
                    .getText());
            System.out.println(webDriver
                    .findElement(By.xpath("/html/body/div[9]/div[2]/div/div[3]/div[2]/div[5]/table/tbody/tr[3]/td[2]"))
                    .getText());

        } else {
            System.out.println("Reliance Industries Ltd does'nt found");
        }
    }

    @AfterTest
    public void destruct() {
        webDriver.quit();
    }
}
