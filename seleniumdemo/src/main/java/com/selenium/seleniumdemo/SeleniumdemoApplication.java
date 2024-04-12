package com.selenium.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumdemoApplication {

	public static void main(String[] args) {

		WebDriver driveredge=new EdgeDriver();
		WebDriver driverfirefox=new FirefoxDriver();
		
		WebDriver driverchrome=new ChromeDriver();
		driverchrome.get("https://www.google.com");
		System.out.println(driverchrome.getTitle());
		driverchrome.close();
		System.out.println(driverchrome.getCurrentUrl());
		System.out.println(driverchrome.getPageSource());
		driverchrome.navigate().refresh();
		driverchrome.close();
		driverchrome.close();
		driveredge.get("https://www.google.com");
		driveredge.close();
		driverfirefox.get("https://www.google.com");
		driveredge.close();

		driverchrome.get("https://www.shoppersstop.com/");
		System.out.println(driverchrome.getTitle());

		driverchrome.findElement(By.className("user-icon")).click();
		driverchrome.close();
		SpringApplication.run(SeleniumdemoApplication.class, args);
	}

}
