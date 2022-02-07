package com.CRM_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC020_CreateleadDD {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		//		implcit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();

		//		Admin login(UN- admin, PW- admin)
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Leads']")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();

		Select sel=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		sel.selectByValue("Mr.");
		String fname="Ram";
		String lname="k";
		String cmpny="Test";

		WebElement firstname = driver.findElement(By.name("firstname"));
		WebElement lastname = driver.findElement(By.name("lastname"));
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(cmpny);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		//		Create organization using Drop downs 

		WebElement leadso = driver.findElement(By.xpath("//select[@name='leadsource']"));

		WebElement indust = driver.findElement(By.xpath("//select[@name='industry']"));
		WebElement leadstat = driver.findElement(By.xpath("//select[@name='leadstatus']"));
		WebElement rating = driver.findElement(By.xpath("//select[@name='rating']"));

		Select sel0=new Select(leadso);
		sel0.selectByValue("Self Generated");
		Select sel1=new Select(indust);
		sel1.selectByValue("Entertainment");
		Select sel2=new Select(leadstat);
		sel2.selectByValue("Not Contacted");
		Select sel3=new Select(rating);
		sel3.selectByValue("Active");

		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Leads']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lname);

		Select sel4=new Select(driver.findElement(By.id("bas_searchfield")));
		sel4.selectByValue("lastname");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("//a[@title='Leads']")).getText();

		if(value.equals(lname))
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
