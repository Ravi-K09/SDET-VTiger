package com.CRM_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC022_ConvertLead {


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
		Thread.sleep(3000);
		String lname="AA";
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(lname);

		Select sel1=new Select(driver.findElement(By.id("bas_searchfield")));
		sel1.selectByValue("lastname");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Leads']")).click();

		driver.findElement(By.xpath("//a[text()='Convert Lead']")).click();


		WebElement chkb = driver.findElement(By.xpath("//input[@id='select_account']"));
		chkb.isSelected();

		Select sel2=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
		sel2.selectByValue("Healthcare");


		//		WebElement contchk = driver.findElement(By.xpath("//input[@id='select_contact']"));

		// check box for contacts
		WebElement contchk = driver.findElement(By.xpath("//input[@id='select_potential']"));

		if(contchk.isSelected()==false)
		{
			contchk.click();
		}
		else
		{

		}

		driver.findElement(By.xpath("//img[@id='jscal_trigger_closedate']")).click();


		Thread.sleep(4000);


		//				driver.findElement(By.xpath("(//td[text()='14'])[6]")).submit();
		//		
		//		driver.findElement(By.xpath("//input[@name='Save']")).click();
		//		

		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(signoutimg).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//	driver.close();



	}
}