package com.PracticeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrollbr {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.flipkart.in");
		driver.manage().window().maximize();
		//div[.='POCO M3 Pro 5G (Cool Blue, 64 GB)']/ancestor::a[@class='_1fQZEK']//span[.='Add to Compare']
		driver.findElement(By.xpath("//button[.='✕']")).sendKeys(Keys.ENTER);
		WebElement location = driver.findElement(By.xpath("//h2[.='Lifestyle']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(location));
		
//		FluentWait wait1 = new FluentWait(driver);
		
		
		//.getLocation();
		System.out.println(location);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("Window.scrollby(25, "+location.y+")");
		
		js.executeScript("arguments[0].scrollIntoView();", location);

	}
}