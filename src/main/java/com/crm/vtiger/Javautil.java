package com.crm.vtiger;

import java.util.Random;

import com.github.javafaker.Faker;

public class Javautil {

	/**
	 * This method is going to generate a random number
	 * return random number till 1000
	 */
	public int generateRandomNumber()
	{
		Random random=new Random();
		 return random.nextInt();
	}
	/**
	 * This method is going to generate fake first name
	 * return first name
	 */
	public String fakefirstName()
	{
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	
	/**
	 * This method is going to generate fake last name
	 * return last name
	 */
	
	public String fakelastName()
	{
		Faker faker=new Faker();
		return faker.name().lastName();
	}
	
	/**
	 * this method is going to generate fake address
	 * return fake address
	 */
	public String fakeAddress()
	{
		Faker faker=new Faker();
		return faker.address().fullAddress();
	}
	/**
	 * This method is going to generate fake company
	 * returns fake company
	 */
	public String fakeCompany()
	{
		Faker faker=new Faker();
		return faker.company().name();
	}
	
}
