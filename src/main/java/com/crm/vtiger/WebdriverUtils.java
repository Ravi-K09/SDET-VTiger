package com.crm.vtiger;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtils {

	/**
	 * This method is provide page load time out
	 * @param driver
	 */
	public void pageLodeTimeout(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}

	/**
	 * This method used for select the elements from drop dowm
	 * @param orgname1
	 * @param driver
	 */

	public void selectionlist(int index,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	public void selectionlist(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	public void selectionlist(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

	public void sendKeys(WebDriver driver,String Send) {
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(Send);
	}

	public void getText(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.getText();
	}

	public void dismiss(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}

	public void accept(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	
	public void movetoelement(WebDriver driver, WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	
	/**
	 * window handle
	 */
	public void swtichtowindow(String title,WebDriver driver)
	{
		Set<String> winids = driver.getWindowHandles();
		String currenttitle;
		for (String string : winids) 
		{
			currenttitle=	driver.switchTo().window(string).getTitle();

			if(currenttitle.contains(title)) 
			{
				break;
			}
		}
	}

}

