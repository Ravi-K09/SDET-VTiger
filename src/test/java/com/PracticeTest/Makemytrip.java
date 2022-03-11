package com.PracticeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip {
public static void main(String[] args) throws Throwable {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		int count=0;
		String src="hyderabad";
		
		driver.findElement(By.xpath("//div[@class='landingContainer']")).click();
		
		driver.findElement(By.id("fromCity")).click();
		
//		driver.findElement(By.id("fromCity")).sendKeys(src);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src);
		Thread.sleep(6000);
		List<WebElement> fromcitylist = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));
		
		for (WebElement ele : fromcitylist) {
			String option=ele.getText();
			Thread.sleep(3000);
			if(option.contains(src)) {
				System.out.println(option);
				ele.click();
				//				count++;
				break;
			}
		}
		//		if(count!=0) {
		//			System.out.println("your entered city is:"+ city);
		//		}
		//		else {
		//			System.out.println("entered city is not available");
		//		}
		String dest="mysore";
		Thread.sleep(3000);
		driver.findElement(By.id("toCity")).sendKeys(dest);
	
		Thread.sleep(3000);
		List<WebElement> Tocitylist = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
		for (WebElement elem : Tocitylist) {
			String tooption=elem.getText();
			if(tooption.contains(dest)) {
				elem.click();
				break;
			}
		}
//		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		Thread.sleep(3000);
}
}
