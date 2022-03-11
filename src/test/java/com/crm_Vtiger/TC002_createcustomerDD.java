package com.crm_Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Objectrepository.CreateOrgPage;
import com.crm.Objectrepository.HomePage;
import com.crm.Objectrepository.OrginfoPage;
import com.crm.vtiger.Basetest;
import com.crm.vtiger.WebdriverUtils;

public class TC002_createcustomerDD extends Basetest{
@Test(groups="regression")
public void createcustomer() throws InterruptedException
{
		HomePage homepage=new HomePage(driver);
		homepage.getOrginizationlink().click();
		OrginfoPage orginfo=new OrginfoPage(driver);
		orginfo.getOrgimg().click();
		Thread.sleep(3000);
		
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
		Assert.assertEquals(value, orgname, "TC fail");
		System.out.println("TC pass");
		
	}
}