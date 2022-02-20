package com.PracticeTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sort_pricelist_amazon {
//public static void main(String[] args) {
	@Test
	public void flip() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	 
//	((RemoteWebDriver) driver).setLogLevel(Level.INFO);
	 
	driver.get("http://www.amazon.in");
	driver.manage().window().maximize();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles under 20000",Keys.ENTER);
	driver.findElement(By.xpath("//span[text()='realme']")).click();
	List<WebElement> list=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	ArrayList<Integer> ar=new ArrayList<Integer>();

	for (WebElement price :list) {
	 String s= price.getText();
		 
		 String[] str = s.split(",");

			String prices=str[0]+str[1];

			int pr= Integer.parseInt(prices);
		 
		 ar.add(pr);
	}
	Collections.sort(ar);
	System.out.println(ar);
	System.out.println(ar.get(0));
	System.out.println(ar.get(ar.size()-1));
	
  

	
}}
