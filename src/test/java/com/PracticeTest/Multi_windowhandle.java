package com.PracticeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.vtiger.IAutoconstant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multi_windowhandle {
	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://business.linkedin.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Cookie Policy')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'User Agreement')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Accessibility')]")).click();
		Set<String> wins = driver.getWindowHandles();
		String title;
		for (String names : wins) {
			title=driver.switchTo().window(names).getTitle();
			System.out.println(title);
			
			if(title.equalsIgnoreCase("Accessibility"))
			{
				System.out.println(title);
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Accessibility')]")).getText());

	}
}

