package com.karthika;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    String username, password;
    String URL = "http://dbankdemo.com/bank/login";

    @BeforeTest
    public void init() throws IOException {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        Workbook workbook = new XSSFWorkbook("D:\\Testing\\Day 8\\q1\\files\\credentials.xlsx");
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        username = row.getCell(0).getStringCellValue();
        password = row.getCell(1).toString();
        System.out.println(password);
        workbook.close();
    }

    @Test(priority = 1)
    public void Test1() throws IOException {
        webDriver.manage().window().maximize();
        webDriver.get(URL);
        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.id("submit")).click();
        if (webDriver.getCurrentUrl().contains("home")) {
            System.out.println("URL verified");
        } else {
            System.out.println("URL invalid");
        }
    }

    @Test(priority = 2)
    public void Test2() {
        webDriver.get(URL);
        webDriver.manage().window().maximize();
        webDriver.get(URL);
        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.id("submit")).click();
        // NewPage
        WebElement deposit = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/aside/nav/div[2]/ul/li[5]/a")));
        deposit.click();

        WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedAccount")));
        Select options = new Select(drop);
        options.selectByVisibleText("Individual Checking(standard checking) (Savings)");

        webDriver.findElement(By.id("amount")).sendKeys("5000");

        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[2]/button[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[4]")));
        String d = webDriver
                .findElement(By.xpath(
                        "/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[4]"))
                .getText();

        if (d.equals("$5000.00")) {
            System.out.println("The deposited amount is present");
        } else {
            System.out.println("The deposited amount is not present");
        }
    }

    @Test(priority = 3)
    public void Test3() {
        webDriver.get(URL);
        webDriver.manage().window().maximize();
        webDriver.get(URL);
        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.id("submit")).click();
        // NewPage
        WebElement deposit = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("withdraw-menu-item")));
        deposit.click();

        WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectedAccount")));
        Select options = new Select(drop);
        options.selectByVisibleText("Individual Checking(standard checking) (Savings)");

        webDriver.findElement(By.id("amount")).sendKeys("3000");

        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[2]/button[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[4]")));
        String d = webDriver
                .findElement(By.xpath(
                        "/html/body/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[4]"))
                .getText();

        if (d.equals("$-3000.00")) {
            System.out.println("The withdrawal amount is present");
        } else {
            System.out.println("The withdrawal amount is not present");
        }
    }

    @AfterTest
    public void destroy() {
        webDriver.quit();
    }
}
