package com.classex3.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(TestingApplication.class, args);

		WebDriver driverchrome=new ChromeDriver();
		driverchrome.get("https://demoblaze.com");
		driverchrome.manage().window().fullscreen();
		driverchrome.findElement(By.linkText("Laptops")).click();
		Thread.sleep(10000);
		driverchrome.findElement(By.linkText("MacBook air")).click();
		Thread.sleep(10000);
		driverchrome.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(10000);
		driverchrome.switchTo().alert().accept();
		Thread.sleep(10000);
		driverchrome.findElement(By.linkText("Cart")).click();
	}

}
