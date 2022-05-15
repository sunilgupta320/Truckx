package com.flipkart.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
	WebDriver driver;
	@FindBy(xpath="/html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/a[1]")
	public WebElement firstproduct;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]")
	public WebElement secondproduct;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	public WebElement addtoCart;
	@FindBy(id="swatch-0-size")
	public WebElement selectSize;
	@FindBy(xpath="//div[@class='_3g_HeN']")
    public WebElement pageTitle;
	
	@FindBy(xpath="//div[@class='_1Er18h']//div[2]//div[1]//div[2]//div[2]//div[2]")
    public WebElement removeprodfromcart;
	@FindBy(className  ="_3SkBxJ")
    public WebElement carticon;
	@FindBy(xpath = "//div[@class='_3dsJAO _24d-qY FhkMJZ']")
    public WebElement Removebutton;
	@FindBy(xpath = "//div[@class='_2sKwjB']")
    public WebElement toastmsgonremoveproduct;
	@FindBy(xpath = "//a[@href='/account/orders?link=home_orders']")
    public WebElement orders;
	@FindBy(xpath = "//span[normalize-space()='Search Orders']")
    public WebElement searchOrder;
	
	
	
	
	
	
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pwd)
	{
		
	}
	
	
	
	 
	
	
	
}
