package com.TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider1 {

	@Test(dataProvider = "city")
	public void travel(String src,String dest,String stop)
	{
		System.out.println(src+" "+dest+" "+stop);
	}
@DataProvider
public Object[][] city(){
	Object arr[][]=new Object[3][3];
arr[0][0]="hyd";
arr[0][1]="warangal";
arr[0][2]="jangon";

arr[1][0]="hyd";
arr[1][1]="nizamabad";
arr[1][2]="karimnagar";

arr[2][0]="hyd";
arr[2][1]="vijayavada";
arr[2][2]="suryapet";
return arr;
}
}