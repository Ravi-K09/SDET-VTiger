package com.PracticeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonpractice {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://www.amazon.in");
	driver.manage().window().maximize();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles under 20000",Keys.ENTER);
	driver.findElement(By.xpath("//span[text()='realme']")).click();
	List<WebElement> list=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	
	String names=null;
	for(int i=0;i<list.size();i++)
	{
		 names=list.get(i).getText().toLowerCase();
		//System.out.println(names);
	
		if(names.contains("realme"))
		{
			System.out.println("TC PASS");
			break;
		}else
		{
		System.out.println("TC FAIL");	
		
		}
	}

}
}
