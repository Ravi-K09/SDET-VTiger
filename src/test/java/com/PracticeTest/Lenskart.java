package com.PracticeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.lenskart.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	
}
}
