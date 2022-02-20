package com.crm.Objectrepository;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CreateOrgPage {
	
		WebDriver driver;

		public WebElement getIndustrydd() {
			return industrydd;
		}

		public WebElement getRatingdd() {
			return ratingdd;
		}

		public WebElement getOrgtypedd() {
			return orgtypedd;
		}
		@FindBy(name="accountname")
		private WebElement orgname;
		
		@FindBy(xpath="//select[@name='industry']")
		private WebElement industrydd;
		
		@FindBy(xpath="//select[@name='rating']")
		private WebElement ratingdd;
		
		@FindBy(xpath="//select[@name='accounttype']")
		private WebElement orgtypedd;

		@FindBy(xpath="//input[@class='crmbutton small save']")
		private WebElement orgsavebtn;

		public WebElement getOrgname() {
			return orgname;
		}

		public WebElement getOrgsavebtn() {
			return orgsavebtn;
		}
		public CreateOrgPage(WebDriver driver)
		{
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}
	}

