package com.softwaretesting.day6classexcer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Day6classexcerApplication {
	public static WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
	public static WebElement element,options;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Day6classexcerApplication.class, args);

		
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.get("https://economictimes.indiatimes.com/et-now/results");

		Thread.sleep(3000);
		driver.findElement(By.linkText("Mutual Funds")).click();
        actions
                .scrollFromOrigin(scrollOrigin, 0, 570)
                .perform();

		Thread.sleep(3000);

		//select AMC name 
		driver.findElement(By.id("amcSelection")).click();
		Select S1 = new Select(driver.findElement(By.id("amcSelection")));
		S1.selectByVisibleText("Canara Robeco");
		Thread.sleep(10000);

		//select scheme name
        driver.findElement(By.id("schemenm")).click();
        Select S2 = new Select(driver.findElement(By.id("schemenm")));
        S2.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
		Thread.sleep(5000);

		//click get details
		driver.findElement(By.id("getDetails")).click();
		Thread.sleep(15000);

		//switching to the next tab 
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
  
		//select type
		element = driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul"));
		element.click();
		options = element.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]/span"));
		options.click();
		Thread.sleep(3000);

		//select amount
		element = driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul"));
		element.click();
		options = element.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]/span"));
		options.click();
		Thread.sleep(3000);

		//select period
		element = driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul"));
		element.click();
		options = element.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[3]/span"));
		options.click();
		Thread.sleep(3000);

		actions
                .scrollFromOrigin(scrollOrigin, 0, 100)
                .perform();
		
		Thread.sleep(3000);

		//click returns
		driver.findElement(By.xpath("//*[@id='mfNav']/div/ul/li[2]")).click();

		//fetching first table row and print in terminal
		element = driver.findElement(By.xpath("/html/body/main/div[10]/section[5]/div/div[1]/section[1]/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
		
		System.out.println("TRAILING RETURNS");
		System.out.println(element.getText());
	}

}
