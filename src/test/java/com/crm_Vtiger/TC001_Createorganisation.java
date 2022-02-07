package com.crm_Vtiger;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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

public class TC001_Createorganisation {
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

		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(3000);
		FileInputStream fis1=new FileInputStream(IAutoconstant.excelpath);
		String orgname=WorkbookFactory.create(fis1).getSheet("orgname").getRow(3).getCell(0).getStringCellValue();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> wins=driver.getWindowHandles();
		Iterator<String> it=wins.iterator();
		String parent=it.next();
		String child=it.next();
		driver. switchTo().window(child);
		driver.findElement(By.id("search_txt")).sendKeys("Rav");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.id("1")).click();
		driver. switchTo().window(parent);

		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		Select sel=new Select(driver.findElement(By.id("bas_searchfield")));
		sel.selectByValue("accountname");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		if(value.equals(orgname))
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
