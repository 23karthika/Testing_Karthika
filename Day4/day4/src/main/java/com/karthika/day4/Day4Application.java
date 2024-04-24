package com.karthika.day4;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day4Application {

	public static void main(String[] args) {
		SpringApplication.run(Day4Application.class, args);

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.shoppersstop.com/");
		driver.findElement(By.className("user")).click();

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(d -> d.findElement(By.className("user")));

		driver.findElement(By.id("mobileNumber")).sendKeys("8072144646");
	}

}
