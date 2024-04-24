package com.karthika.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day2Application.class, args);

		WebDriver chromeDriver=new ChromeDriver();
		WebDriver edgeDriver = new EdgeDriver();
		WebDriver firefoxDriver = new FirefoxDriver();
		chromeDriver.get("https://www.google.com");
		edgeDriver.get("https://www.google.com");
		firefoxDriver.get("https://www.google.com");
	}

}
