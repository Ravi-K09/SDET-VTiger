package com.crm_Vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Objectrepository.ContactPage;
import com.crm.Objectrepository.Contact_popup;
import com.crm.Objectrepository.Contactinfo;
import com.crm.Objectrepository.HomePage;
import com.crm.vtiger.Basetest;
import com.crm.vtiger.ExcelUtils;

public class TC003_Createcontact extends Basetest{

	@Test(groups={"regression"})
	public void contactcreation() throws InterruptedException, Throwable, IOException
	{
		HomePage homepage=new HomePage(driver);
		homepage.getContactslink().click();
		ContactPage contpage=new ContactPage(driver);
		contpage.getCreatecontactlink().click();
		WebElement prefixname=contpage.getNameprefix();
		wutil.selectionlist("Mr.", prefixname);

		String randomfname=jv.fakefirstName();
		String randomlname=jv.fakelastName();
		String fname=randomfname;
		String lname=randomlname;
		contpage.getFirstnametxtb().sendKeys(fname);
		contpage.getLastnametxtb().sendKeys(lname);
		//		click on + icon for add organization name
		contpage.getSelectorgbtn().click();
		Thread.sleep(3000);
		wutil.swtichtowindow("Accounts", driver);
		Thread.sleep(2000);
		ExcelUtils excelutil=new ExcelUtils();
		String orgname=excelutil.readDatafromExcel("orgname", 3, 0);
		Contact_popup cntp=new Contact_popup(driver);
		cntp.getChildsearchtxtb().sendKeys(orgname);
		cntp.getChildsearchbtn().click();
		Thread.sleep(3000);
		cntp.getOptselect().click();
		wutil.swtichtowindow("Contacts", driver);
		contpage.getContactsavebtn().click();
		Thread.sleep(3000);
		homepage.getContactslink().click();
		Thread.sleep(3000);
		Contactinfo cntinfo=new Contactinfo(driver);
		cntinfo.getPcontsearctxtb().sendKeys(lname);
		WebElement insel=cntinfo.getIntxtdd();
		wutil.selectionlist("lastname", insel);
		cntinfo.getVerifysubmitbtn().click();
		Thread.sleep(2000);
		String ln = driver.findElement(By.xpath("(//a[@title=\"Contacts\"])[2]")).getText();
		Assert.assertEquals(lname, ln,"TC Fail");	
	System.out.println("TC pass");
	}
		
@Test(groups={"smoke"})
public void createwithoutdata_contact_test() throws Throwable
{
	HomePage homepage=new HomePage(driver);
	homepage.getContactslink().click();
	ContactPage contpage=new ContactPage(driver);
	contpage.getCreatecontactlink().click();
	contpage.getContactsavebtn().click();
	Thread.sleep(2000);
	String result=wutil.getText(driver);
	System.out.println(result);
	wutil.dismiss(driver);
	Assert.assertEquals(result, "Last Name cannot be empty");
	System.out.println("TC pass");
	
	
}

	}		


