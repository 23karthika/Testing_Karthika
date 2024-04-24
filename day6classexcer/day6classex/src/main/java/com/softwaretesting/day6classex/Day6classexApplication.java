package com.softwaretesting.day6classex;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day6classexApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(Day6classexApplication.class, args);

		WebDriver driverChrome=new ChromeDriver();
		Actions actions=new Actions(driverChrome);
		//JavascriptExecutor js=new JavascriptExecutor();
		driverChrome.get("https://magento.softwaretestingboard.com");
		driverChrome.findElement(By.id("search")).click();
		driverChrome.findElement(By.id("search")).sendKeys("Shoes");
		driverChrome.findElement(By.xpath("//*[@id='search_mini_form']/div[2]/button")).click();
		if(driverChrome.findElement(By.xpath("//*[@id='maincontent']/div[1]/h1/span")).getText().contains("Shoes")){
			System.out.print("Confirms the presence");
		}
		else{
			System.out.print("Absence of presence");
		}
		Thread.sleep(2000);

		TakesScreenshot ts=(TakesScreenshot)driverChrome;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./screenshots/shoe.png"));
		Thread.sleep(2000);

		actions.moveToElement(driverChrome.findElement(By.xpath("//*[@id='ui-id-5']/span[1]"))).perform();
		actions.moveToElement(driverChrome.findElement(By.xpath("//*[@id='ui-id-17']/span[1]"))).perform();
		Thread.sleep(2000);

		driverChrome.findElement(By.xpath("//*[@id='ui-id-20']/span")).click();
		Thread.sleep(2000);
		driverChrome.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[3]/div[1]/div/a[2]/span[2]/span[2]")).click();
	}

}
		

