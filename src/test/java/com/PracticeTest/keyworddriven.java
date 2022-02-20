package com.PracticeTest;

import java.io.FileInputStream;
import java.util.Properties;

public class keyworddriven {
public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream("../project/properties.txt");
	Properties pro=new Properties();
	pro.load(fis);
	String val= pro.getProperty("UN");
	System.out.println(val);
}
}
