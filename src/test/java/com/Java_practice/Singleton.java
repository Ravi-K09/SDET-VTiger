package com.Java_practice;

public class Singleton {

	public void sample()
	{
		System.out.println("sample");
	}

	public void Demo()
	{
		System.out.println("Demo");
	}
	private Singleton()
	{
		System.out.println("constructor created");
	}

	public static Singleton objectsingleton()
	{
		Singleton sin=new Singleton();
		return sin;
	}

}
