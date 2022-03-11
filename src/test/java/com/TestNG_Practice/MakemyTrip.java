package com.TestNG_Practice;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemyTrip {

	@Test(dataProvider = "testdata")
	public void dp(String src,String dest) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		//		String src;
		driver.findElement(By.xpath("//div[@class='landingContainer']")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		Thread.sleep(3000); 
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input")).sendKeys(src);
		driver.findElement(By.xpath("//div[.='"+src+"']")).click();
		Thread.sleep(3000);
		
		
		//		List<WebElement> fromcitylist = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));
		//		for (WebElement ele : fromcitylist) {
		//			String option=ele.getText();
		//			if(option.contains(src)) {
		//				ele.click();
		//				//				count++;
		//				break;
		//			}
		//		}
		//		if(count!=0) {
		//			System.out.println("your entered city is:"+ city);
		//		}
		//		else {
		//			System.out.println("entered city is not available");
		//		}
		//		String dest;
		
		driver.findElement(By.id("toCity")).sendKeys(dest);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();
		
		//		List<WebElement> Tocitylist = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
		//		for (WebElement elem : Tocitylist) {
		//			String tooption=elem.getText();
		//			if(tooption.contains(dest)) {
		//				elem.click();
		//				break;
		//			}
		//		}

		//		Date date=new Date();
		//		String currentdate = date.toString();
		//		String[] arr=currentdate.split(" ");
		//		String day = arr[0];
		//		String month = arr[1];
		//		String todaydate = arr[2];
		//		String year = arr[5];
		//		String datepath=day+" "+month+" "+todaydate+" "+year;

		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(2000);

		for(int i=0;i<12;i++) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='Sat Jul 02 2022']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		//		driver.findElement(By.xpath("//div[@aria-label='"+datepath+"']")).click();
		//		Thread.sleep(3000);
		WebElement submit = driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter ']/a"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();

	}
	@DataProvider
	public Object[][] testdata(){
		Object[][] data=new Object[2][2];
		data[0][0]="HYD";
		data[0][1]="DEL";

		data[1][0]="BOM";
		data[1][1]="DEL";
		return data;	
	}

}