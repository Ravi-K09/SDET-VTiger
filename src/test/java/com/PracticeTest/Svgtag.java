package com.PracticeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Svgtag {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.flipkart.in");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[.='✕']")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("q")).sendKeys("poco mobiles");
		driver.findElement(By.xpath("//*[local-name()='svg' and  @xmlns='http://www.w3.org/2000/svg']")).click();
}
}