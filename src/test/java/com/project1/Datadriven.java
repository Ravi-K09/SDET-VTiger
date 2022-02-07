package com.project1;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Datadriven {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("../project/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("sheet1");

		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			int s= (int) wb.getSheet("sheet1").getRow(i).getCell(1).getNumericCellValue();
			if(s>=50000) {
				String name= wb.getSheet("sheet1").getRow(i).getCell(0).getStringCellValue();

				System.out.println(name);
			}

		}

	}


}
