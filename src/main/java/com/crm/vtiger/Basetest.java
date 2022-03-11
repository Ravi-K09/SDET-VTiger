package com.crm.vtiger;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.Objectrepository.HomePage;
import com.crm.Objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public WebdriverUtils wutil=new WebdriverUtils();
	public FileUtill futil=new FileUtill();
	public WebDriver driver;
	public Javautil jv=new Javautil();

	@BeforeSuite(groups={"smoke","integration","regression"})
	public void makeConnections() 
	{
		System.out.println("==Before Suite==");
		System.out.println("==DB Connection==");
	}
	@BeforeTest(groups={"smoke","integration","regression"})
	public void beforetest()
	{
		System.out.println("=before test=");
	}
	@BeforeClass(groups={"smoke","integration","regression"})
	public void launch_browser() throws IOException {
		System.out.println("==launch browser==");

		WebDriverManager.chromedriver().setup();

		String BROWSER=futil.readDatafromPropfile("Browser");


		if(BROWSER.equalsIgnoreCase("chrome"))
		{		
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}

		driver.get(futil.readDatafromPropfile("Url"));
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups={"smoke","integration","regression"})
	public void loginapp() throws Throwable {
		System.out.println("==Login to the App==");
		wutil.pageLodeTimeout(driver);
		LoginPage lpage=new LoginPage(driver);
		lpage.getUsernametxtfld().sendKeys(futil.readDatafromPropfile("UN"));
		lpage.getPasswordtxtfld().sendKeys(futil.readDatafromPropfile("PW"));
		lpage.getLoginbtn().click();
	}
	@AfterMethod(groups={"smoke","integration","regression"})
	public void logoutapp()
	{
		HomePage homepage=new HomePage(driver);
		WebElement signoutimg=homepage.getSignoutimg();
		wutil.movetoelement(driver, signoutimg);
		homepage.getSignoutlink().click();
		System.out.println("==Logout form App==");
	}
	@AfterClass(groups={"smoke","integration","regression"})
	public void teardown() throws Throwable
	{
		Thread.sleep(2000);
		System.out.println("close browser");
		driver.close();
	}
	@AfterSuite
	public void aftersuit()
	{
		System.out.println("----Aftersuit---");
	}
}


