package com.crm_Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Objectrepository.CreateOrgPage;
import com.crm.Objectrepository.HomePage;
import com.crm.Objectrepository.LoginPage;
import com.crm.Objectrepository.OrginfoPage;
import com.crm.vtiger.FileUtill;
import com.crm.vtiger.Javautil;
import com.crm.vtiger.WebdriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_createcustomerDD {

	public static void main(String[] args) throws Throwable {
		FileUtill futil=new FileUtill();
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		String BROWSER= futil.readDatafromPropfile("Browser");

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
		WebdriverUtils wutils=new WebdriverUtils();
		wutils.pageLodeTimeout(driver);
		LoginPage lpage=new LoginPage(driver);
		lpage.getUsernametxtfld().sendKeys(futil.readDatafromPropfile("UN"));
		lpage.getPasswordtxtfld().sendKeys(futil.readDatafromPropfile("PW"));
		lpage.getLoginbtn().click();
		HomePage homepage=new HomePage(driver);
		homepage.getOrginizationlink().click();
		OrginfoPage orginfo=new OrginfoPage(driver);
		orginfo.getOrgimg().click();
		Thread.sleep(3000);
		Javautil jv=new Javautil();
		String orgname=	jv.fakeCompany();
		CreateOrgPage createorg=new CreateOrgPage(driver);
		createorg.getOrgname().sendKeys(orgname);
		WebElement indsdd=createorg.getIndustrydd();

		WebdriverUtils wu=new WebdriverUtils();
		wu.selectionlist("Hospitality", indsdd);

		WebElement ratingdd=createorg.getRatingdd();
		wu.selectionlist("Active", ratingdd);

		WebElement orgtypedd=createorg.getOrgtypedd();
		wu.selectionlist("Customer", orgtypedd);

		createorg.getOrgsavebtn().click();
		Thread.sleep(3000);

		//Verify Organization
		homepage.getOrginizationlink().click();
		Thread.sleep(3000);


		orginfo.getSearchtxt().sendKeys(orgname);

		WebElement sel=orginfo.getSellist();

		wu.selectionlist("accountname", sel);

		orginfo.getSearchbtn().click();
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
		WebElement signoutimg=homepage.getSignoutimg();

		wu.movetoelement(driver, signoutimg);
		homepage.getSignoutlink().click();
		//	driver.close();


	}
}