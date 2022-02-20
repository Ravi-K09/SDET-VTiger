package com.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//class name should be same as page name
//	public LoginPage(WebDriver driver)
	WebDriver driver;
	
	@FindBy(name="user_name")
		private WebElement usernametxtfld;
	
	@FindBy(name="user_password")
	private WebElement passwordtxtfld;
	

	public WebElement getUsernametxtfld() {
		return usernametxtfld;
	}

	public WebElement getPasswordtxtfld() {
		return passwordtxtfld;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	@FindBy(id="submitButton")
	private WebElement loginbtn;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}
