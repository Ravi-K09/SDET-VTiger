package com.TestNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations {
    @BeforeSuite
	public void Bs()
	{
		System.out.println("Before suit");
	}
    @AfterSuite
	public void As()
	{
		System.out.println("After suit");
	}
	@BeforeClass
	public void Bc()
	{
		System.out.println("Before class");
	}
	@AfterClass
	public void Ac()
	{
		System.out.println("After class");
	}
	
	@BeforeTest
	public void Bt()
	{
		System.out.println("Before test");
	}
	@AfterTest
	public void At()
	{
		System.out.println("After test");
	}
	@BeforeMethod
	public void Bm()
	{
		System.out.println("Before method");
	}
	@AfterMethod
	public void Am()
	{
		System.out.println("After method");
	}
	@Test
	public void Test()
	{
		System.out.println("Test method");
	}
	
}
