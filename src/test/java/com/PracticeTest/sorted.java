package com.PracticeTest;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class sorted {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("../project/Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("sheet1");
		ArrayList<String> ar=new ArrayList<String>();

		for(int i=1;i<=sh.getLastRowNum();i++)
		{

			String s= wb.getSheet("sheet1").getRow(i).getCell(0).getStringCellValue();


			ar.add(s);
		}


		Collections.sort(ar);

		System.out.println(ar);

	}
}


