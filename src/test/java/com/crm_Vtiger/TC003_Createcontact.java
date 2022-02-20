package com.crm_Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.Objectrepository.ContactPage;
import com.crm.Objectrepository.HomePage;
import com.crm.Objectrepository.LoginPage;
import com.crm.vtiger.ExcelUtils;
import com.crm.vtiger.FileUtill;
import com.crm.vtiger.Javautil;
import com.crm.vtiger.WebdriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_Createcontact {

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
		homepage.getContactslink().click();
		ContactPage contpage=new ContactPage(driver);
		contpage.getCreatecontactlink().click();
		WebElement prefixname=contpage.getNameprefix();
		wutils.selectionlist("Mr.", prefixname);
		Javautil java=new Javautil();
		String randomfname=java.fakefirstName();
		String randomlname=java.fakelastName();
		String fname=randomfname;
		String lname=randomlname;
		contpage.getFirstnametxtb().sendKeys(fname);
		contpage.getLastnametxtb().sendKeys(lname);
		//		click on + icon for add organization name
		contpage.getSelectorgbtn().click();
		Thread.sleep(3000);
		wutils.swtichtowindow("=", driver);
		ExcelUtils excelutil=new ExcelUtils();
		String orgname=excelutil.readDatafromExcel("orgname", 3, 0);
		contpage.getChildsearchtxtb().sendKeys(orgname);
		contpage.getChildsearchbtn().click();
		Thread.sleep(3000);
		contpage.getOptselect().click();
		wutils.swtichtowindow("Contacts", driver);
		contpage.getContactsavebtn().click();
		Thread.sleep(3000);
		homepage.getContactslink().click();
		Thread.sleep(3000);
		contpage.getPcontsearctxtb().sendKeys(lname);
		WebElement insel=contpage.getIntxtdd();
		wutils.selectionlist("lastname", insel);
		contpage.getVerifysubmitbtn().click();
		Thread.sleep(2000);
		String ln = driver.findElement(By.xpath("(//a[@title=\"Contacts\"])[2]")).getText();
		if(ln.equalsIgnoreCase(lname))	
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}
		//		Signout from application
		WebElement signoutimg=homepage.getSignoutimg();
		wutils.movetoelement(driver, signoutimg);
		homepage.getSignoutlink().click();
		//	driver.close();

	}		}


