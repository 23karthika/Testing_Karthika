package com.karthika.ch1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ch1Application {

	public static void main(String[] args) {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://groww.in/");
		Actions action = new Actions(webDriver);

		Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));

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

		webDriver.quit();

	}

}
