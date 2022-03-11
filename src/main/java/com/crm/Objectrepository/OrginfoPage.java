package com.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrginfoPage {
	WebDriver driver;
	public  OrginfoPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement orgimg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtxt;
	
	@FindBy(id="bas_searchfield")
	private WebElement orgtypedd;
	

	
	@FindBy(name="submit")
	private WebElement searchorgbtn;

	public WebElement getOrgimg() {
		return orgimg;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSellist() {
		return orgtypedd;
	}

	public WebElement getSearchbtn() {
		return searchorgbtn;
	}
}

