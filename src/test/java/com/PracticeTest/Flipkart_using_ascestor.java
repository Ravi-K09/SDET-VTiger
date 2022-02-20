package com.PracticeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_using_ascestor {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://www.flipkart.in");
	driver.manage().window().maximize();
	//div[.='POCO M3 Pro 5G (Cool Blue, 64 GB)']/ancestor::a[@class='_1fQZEK']//span[.='Add to Compare']
	driver.findElement(By.xpath("//button[.='✕']")).sendKeys(Keys.ENTER);
	driver.findElement(By.name("q")).sendKeys("poco mobiles",Keys.ENTER);
	driver.findElement(By.xpath("//div[.='POCO M3 Pro 5G (Cool Blue, 64 GB)']/ancestor::a[@class='_1fQZEK']//span[.='Add to Compare']")).click();
//	driver.navigate().back();
	driver.findElement(By.name("q")).sendKeys("samsung mobiles",Keys.ENTER);
	//div[.args=[' Galaxy F12 (Sky Blue, 64 GB)']
	driver.findElement(By.xpath("//div[.='SAMSUNG Galaxy F12 (Sky Blue, 64 GB)']/ancestor::a[@class='_1fQZEK']//span[.='Add to Compare']")).click();
	driver.findElement(By.xpath("//span[.='COMPARE']")).click();
}
}
