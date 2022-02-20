package com.crm.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public  WebDriver  driver;
	public void openbrowser() throws Throwable
	{	
		FileUtill futil=new FileUtill();

		String BROWSER= futil.readDatafromPropfile("Browser");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{		
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}	
	}
}
