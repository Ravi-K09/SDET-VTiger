package com.CRM_practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC021_Createlead_wothoutdata {
	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Leads']")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();

		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String text="Last Name cannot be empty";
		Alert a1=driver.switchTo().alert();
		String alrt = a1.getText();
		
		
		System.out.println(alrt);
		a1.accept();

		if(alrt.equals(text))
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}

		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(signoutimg).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//	driver.close();

	}

}
