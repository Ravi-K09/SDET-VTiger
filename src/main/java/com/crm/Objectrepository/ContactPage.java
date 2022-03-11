package com.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement  createcontactlink;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement nameprefix;
	
	@FindBy(name="firstname")
	private WebElement firstnametxtb;
	
	@FindBy(name="lastname")
	private WebElement lastnametxtb;
	
	@FindBy(xpath="//input[@name='account_name']/../img")
	private WebElement selectorgbtn;
	
	 public WebElement getCreatecontactlink() {
		return createcontactlink;
	}

	public WebElement getNameprefix() {
		return nameprefix;
	}

	public WebElement getFirstnametxtb() {
		return firstnametxtb;
	}

	public WebElement getLastnametxtb() {
		return lastnametxtb;
	}
	@FindBy(xpath="//input[@type='submit']")
	 private WebElement contactsavebtn;
	
	public WebElement getContactsavebtn() {
		return contactsavebtn;
	}
	
	public WebElement getSelectorgbtn() {
		return selectorgbtn;
	}
	 
	 
	
}
