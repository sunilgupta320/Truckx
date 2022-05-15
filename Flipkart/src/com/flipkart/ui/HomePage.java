package com.flipkart.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	@FindBy(xpath="//div[contains(text(),'Truckx')]")
	public WebElement myProfiletab;
	@FindBy(xpath="//div[normalize-space()='Logout']")
	private WebElement logout;
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	public WebElement Search;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void home(String un, String pwd)
	{

		
	}
	
	
	
	 
	
	
	
}