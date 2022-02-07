package com.crm_Vtiger;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger_FRAMES.IAutoconstant;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_createcustomerDD {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconstant.propfilepath);

		Properties pro=new Properties();
		pro.load(fis);
		String browser= pro.getProperty("Browser");
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getProperty("Url"));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(pro.getProperty("UN"));
		driver.findElement(By.name("user_password")).sendKeys(pro.getProperty("PW"));
		driver.findElement(By.id("submitButton")).click();

//		Create organization using Drop downs 
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		FileInputStream fis1=new FileInputStream(IAutoconstant.excelpath);
		String orgname=WorkbookFactory.create(fis1).getSheet("orgname").getRow(3).getCell(0).getStringCellValue();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		WebElement rating = driver.findElement(By.xpath("//select[@name='rating']"));
		WebElement actype = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select sel=new Select(industry);
		sel.selectByValue("Hospitality");
		Select sel1=new Select(rating);
		sel1.selectByValue("Active");
		Select sel2=new Select(actype);
		sel2.selectByValue("Customer");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		
//Verify Organization
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		Select sel3=new Select(driver.findElement(By.id("bas_searchfield")));
		sel3.selectByValue("accountname");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println("organisation name is :" +value);
		if(value.equalsIgnoreCase(orgname))
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}
		
//		Signout from application
		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(signoutimg).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//	driver.close();



	}
}