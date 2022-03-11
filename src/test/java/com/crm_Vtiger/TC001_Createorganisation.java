package com.crm_Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Objectrepository.CreateOrgPage;
import com.crm.Objectrepository.HomePage;
import com.crm.Objectrepository.OrginfoPage;
import com.crm.vtiger.Basetest;

public class TC001_Createorganisation extends Basetest{

	
	
	@Test(groups="smoke")
	public void create_org_test() throws Throwable
	{	
		HomePage  homepage=new HomePage(driver);
		homepage.getOrginizationlink().click();
		 OrginfoPage orginfo=new OrginfoPage(driver);
		orginfo.getOrgimg().click();
		Thread.sleep(3000);
		String orgname=	jv.fakeCompany();
			CreateOrgPage createorg=new CreateOrgPage(driver);
		createorg.getOrgname().sendKeys(orgname);
		createorg.getOrgsavebtn().click();
		Thread.sleep(3000);
		homepage.getOrginizationlink().click();

		orginfo.getSearchtxt().sendKeys(orgname);

		WebElement sel=orginfo.getSellist();
//		WebdriverUtils wu=new WebdriverUtils();
		wutil.selectionlist("accountname", sel);

		orginfo.getSearchbtn().click();
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		Assert.assertEquals(value, orgname, "TC fail");
		System.out.println("TC pass");
		
	}
	@Test(groups={"regression"})
	public void createorg_withoutdata_test() throws InterruptedException
	{
		
		HomePage  homepage=new HomePage(driver);
		homepage.getOrginizationlink().click();
		 OrginfoPage orginfo=new OrginfoPage(driver);
		orginfo.getOrgimg().click();
		Thread.sleep(3000);
		
		CreateOrgPage createorg=new CreateOrgPage(driver);
		createorg.getOrgsavebtn().click();
		String result=wutil.getText(driver);
		System.out.println(result);
		wutil.dismiss(driver);
		Assert.assertEquals(result, "Organization Name cannot be empty");

		System.out.println("TC pass");
		
	}
}
