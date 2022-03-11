package com.TestNG_Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.vtiger.IAutoconstant;

public class Dtaprovider_usingexcel {
@Test(dataProvider ="read")
	public void readexceldata(Object UN,Object PW, Object OTP)
	
	{
		System.out.println(UN+""+PW+""+OTP);
	}
	
	@DataProvider
	public Object[][] read() throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream(IAutoconstant.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		int lastrow=wb.getSheet("sheet1").getLastRowNum();
		short lastcell=wb.getSheet("sheet1").getRow(1).getLastCellNum();
		System.out.println(lastcell);
	
	  Object arr[][]=new Object[lastrow][3];
	  for(int i=0;i<lastrow;i++)
	  {
		  arr[i][0]=wb.getSheet("sheet1").getRow(i).getCell(0).getStringCellValue();
		  arr[i][1]=wb.getSheet("sheet1").getRow(i).getCell(1).getStringCellValue();
		  arr[i][2]=wb.getSheet("sheet1").getRow(i).getCell(2).getNumericCellValue();
	  }
	return arr;
	
	
	}
}
