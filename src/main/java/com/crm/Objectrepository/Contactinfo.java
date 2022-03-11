package com.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinfo {
	WebDriver driver;
	public Contactinfo(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement pcontsearctxtb;

	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement intxtdd;

	@FindBy(xpath="//input[@name='submit']")
	private WebElement verifysubmitbtn;

	public WebElement getVerifysubmitbtn() {
		return verifysubmitbtn;
	}
	public WebElement getIntxtdd() {
			return intxtdd;
		}

	public WebElement getPcontsearctxtb() {
			return pcontsearctxtb;
		}

	

	}

