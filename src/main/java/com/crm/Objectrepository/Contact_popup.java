package com.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_popup {
	WebDriver driver;
	public Contact_popup(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getChildsearchtxtb() {
		return childsearchtxtb;
	}

	public WebElement getChildsearchbtn() {
		return childsearchbtn;
	}
	@FindBy(xpath="//input[@id='search_txt']")
	 private WebElement childsearchtxtb;
	 
	 @FindBy(xpath="//input[@name='search']")
	 private WebElement childsearchbtn;
	 
	 @FindBy(xpath="//a[@id='1']")
	 private WebElement optselect;
	 
	 public WebElement getOptselect() {
			return optselect;
		}

}
