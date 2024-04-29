package com.karthika.q1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q1Application {

	public static String URL = "https://economictimes.indiatimes.com/et-now/results";

	public static void main(String[] args) throws InterruptedException {
		WebDriver webDriver = new ChromeDriver();
		webDriver.get(URL);
		Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		Actions action = new Actions(webDriver);

		// wait.until(d->d.findElement(By.linkText("Mutual Funds")));

		webDriver.findElement(By.linkText("Mutual Funds")).click();

		action.scrollToElement(webDriver.findElement(By.xpath("/html/body/section/main/div[1]/section/div[6]")));

		wait.until(d -> d.findElement(By.id("schemenm")));

		Select option1 = new Select(webDriver.findElement(By.id("amcSelection")));
		option1.selectByVisibleText("Canara Robeco");
		wait.until(d -> d.findElement(By.id("schemenm")));
		Select option2 = new Select(webDriver.findElement(By.id("schemenm")));
		option2.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");

		webDriver.findElement(By.id("anchor3")).click();

		// 2nd tab
		String current = webDriver.getWindowHandle();
		for (String windowHandle : webDriver.getWindowHandles()) {
			if (!windowHandle.equals(current)) {
				webDriver.switchTo().window(windowHandle);
				break;
			}
		}
		wait.until(d -> d.findElement(By.cssSelector("#installment_type")));
		webDriver.findElement(By.cssSelector("#installment_type"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]")));
		webDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li")));
		webDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]")));
		webDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li")));
		webDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[4]")));
		webDriver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[4]"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mf_features > li:nth-child(2)")));
		webDriver.findElement(By.cssSelector(".mf_features > li:nth-child(2)")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/main/div[10]/section[5]/div/div[1]/section[1]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]")));
		System.out.println(webDriver.findElement(By.xpath(
				"/html/body/main/div[10]/section[5]/div/div[1]/section[1]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"))
				.getText());
	}

}
