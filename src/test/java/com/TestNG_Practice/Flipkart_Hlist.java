package com.TestNG_Practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Hlist {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.flipkart.in");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[.='✕']")).sendKeys(Keys.ENTER);
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//div[@class='_1psGvi SLyWEo']/div[.='Home']"))).perform();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));


		List<WebElement> sublist = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));

		for (int i = 1; i <=list.size(); i++) {

			ac.moveToElement(driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a["+i+"]"))).build().perform();
			System.out.println(list.get(i).getText());
			Thread.sleep(1000);
			for (int j = 0; j < sublist.size(); j++) {	
				System.out.println(sublist.get(j).getText());		
			}
			System.out.println("======");
		}
	}		
}
//
//
//

