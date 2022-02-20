package com.PracticeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Img_in_amazon {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
List<WebElement> imglinks = driver.findElements(By.tagName("img"));
System.out.println(imglinks.size());
for (WebElement linktext : imglinks) {
	String text=linktext.getAttribute("src");
	System.out.println(text);
}

}}
