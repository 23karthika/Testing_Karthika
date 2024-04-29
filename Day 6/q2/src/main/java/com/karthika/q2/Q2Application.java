package com.karthika.q2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q2Application {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		chromeOptions.addArguments("--user-data-dir=" + System.getProperty("user.dir") + "\\AppData");

		WebDriver webDriver = new ChromeDriver(chromeOptions);
		Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

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
				.visibilityOfElementLocated(By.linkText("Mutual Funds")));

		webDriver.findElement(By.linkText("Mutual Funds")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/section/section[1]/div/div/div[1]/div[5]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/ul/li[2]/a")));

		webDriver.findElement(By.xpath(
				"/html/body/section/section[1]/div/div/div[1]/div[5]/div/div/div/div[1]/div/div[3]/div[1]/div[1]/ul/li[2]/a"))
				.click();

		webDriver.quit();

	}

}
