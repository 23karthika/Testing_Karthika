package com.karthika.q1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q1Application {

	public static void main(String[] args) throws InterruptedException {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://www.demoblaze.com/");

		Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		wait.until(d -> d.findElement(By.linkText("Laptops")));

		webDriver.findElement(By.linkText("Laptops")).click();

		wait.until(d -> d.findElement(By.linkText("MacBook air")));
		webDriver.findElement(By.linkText("MacBook air")).click();

		wait.until(d -> d.findElement(By.linkText("Add to cart")));
		webDriver.findElement(By.linkText("Add to cart")).click();

		wait.until(ExpectedConditions.alertIsPresent());
		webDriver.switchTo().alert().accept();

		webDriver.findElement(By.linkText("Cart")).click();

		wait.until(d -> d.findElement(By.tagName("td")));
		List<WebElement> list = webDriver.findElements(By.tagName("td"));
		System.out.println("Title : " + list.get(1).getText());
		System.out.println("Price : " + list.get(2).getText());

	}

}
