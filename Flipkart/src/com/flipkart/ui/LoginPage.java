package com.flipkart.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement userNameTextbox;
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordTextbox;
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement loginButton;
	@FindBy(xpath="//span[text()=\"Your username or password is incorrect\"]")
	public  WebElement invalidcredential;
	@FindBy(xpath="//span[@class='_36KMOx']//span[contains(text(),'Login')]")
	public  WebElement logoutvalidation;
	@FindBy(xpath="//a[@href='#']")
	public  WebElement logout;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pwd)
	{
		userNameTextbox.sendKeys(un);
		passwordTextbox.sendKeys(pwd);
		loginButton.click();
	}
	
	
	
	 
	
	
	
}
