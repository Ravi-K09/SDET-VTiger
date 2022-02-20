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

	public WebElement getSelectorgbtn() {
		return selectorgbtn;
	}

	public WebElement getChildsearchtxtb() {
		return childsearchtxtb;
	}

	public WebElement getChildsearchbtn() {
		return childsearchbtn;
	}

	public WebElement getOptselect() {
		return optselect;
	}

	public WebElement getContactsavebtn() {
		return contactsavebtn;
	}

	@FindBy(xpath="//input[@name='account_name']/../img")
	 private WebElement selectorgbtn;
	 
	 @FindBy(id="search_txt")
	 private WebElement childsearchtxtb;
	 
	 @FindBy(xpath="//input[@name='search']")
	 private WebElement childsearchbtn;
	 
	 @FindBy(xpath="//a[@id='1']")
	 private WebElement optselect;
	 
	 @FindBy(xpath="//input[@name='search_text']")
	 private WebElement pcontsearctxtb;
	 
	 @FindBy(xpath="//select[@id='bas_searchfield']")
	 private WebElement intxtdd;
	 
	 public WebElement getIntxtdd() {
		return intxtdd;
	}

	public WebElement getPcontsearctxtb() {
		return pcontsearctxtb;
	}
	@FindBy(xpath="//input[@type='submit']")
	 private WebElement contactsavebtn;
	
	@FindBy(xpath="//input[@name='submit']")
	 private WebElement verifysubmitbtn;
	public WebElement getVerifysubmitbtn() {
		return verifysubmitbtn;
	}
	 
	 
	 
	 
	
}
