package com.karthika.h1;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class H1Application {

	public static void main(String[] args) throws Exception {
		WebDriver webDriver = new ChromeDriver();
		Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
		Actions actions = new Actions(webDriver);
		// open
		String URL = "https://magento.softwaretestingboard.com/";
		webDriver.get(URL);

		WebElement search = webDriver.findElement(By.id("search"));

		// type
		search.sendKeys("Shoes");

		// submit
		webDriver.findElement(By.cssSelector("[type=submit]")).click();

		wait.until(d -> d.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span")));

		String txt = webDriver.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span")).getText();
		if (txt.contains("Shoes")) {
			System.out.println("Contains Shoes");
			// screenshot
			File scrnSht = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrnSht, new File("./screenshots/image.png"));
		} else {
			System.out.println("Does not contain Shoes");
		}
		WebElement men = webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]"));
		actions.moveToElement(men).perform();
		wait.until(
				d -> d.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/ul/li[1]")));

		actions.moveToElement(
				webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/ul/li[1]")))
				.perform();

		wait.until(d -> d.findElement(By.cssSelector("#ui-id-20")));

		webDriver.findElement(By.cssSelector("#ui-id-20"))
				.click();

		wait.until(d -> d.getCurrentUrl() != URL);

		webDriver.navigate().to(URL);

		// scroll

		actions.scrollToElement(webDriver
				.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div/a[2]/span[2]/span[2]")));

		webDriver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div/a[2]/span[2]/span[2]"))
				.click();

		wait.until(d -> d.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[4]/ol/li[3]/div/a")));

		webDriver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[4]/ol/li[3]/div/a")).click();

		wait.until(d -> d.getCurrentUrl() != URL);
		webDriver.findElement(By.cssSelector("#option-label-size-143-item-168")).click();
		webDriver.findElement(By.cssSelector("#option-label-color-93-item-56")).click();
		WebElement qty = webDriver.findElement(By.id("qty"));
		qty.clear();
		qty.sendKeys("4");

		webDriver.findElement(By.id("product-addtocart-button")).click();

		webDriver.quit();
	}

}
