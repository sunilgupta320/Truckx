package com.flipkart.test.functional;


import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

import org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.DefPKCS12KeyStore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.flipkart.config.TestConfig;
import com.flipkart.helper.GetData;
import com.flipkart.helper.Handler;
import com.flipkart.ui.HomePage;
import com.flipkart.ui.LoginPage;
import com.flipkart.ui.ProductPage;


public class TestLoginSC_01 extends TestConfig
{
	
	@Test
	public void TC1_Login() throws InterruptedException 
	{
		String un = GetData.fromExcel(".\\data\\tdata.xlsx", "TC_01", 1, 0);
		String pwd = GetData.fromExcel(".\\data\\tdata.xlsx", "TC_01", 1, 1);
		LoginPage l =	new LoginPage(driver);
		l.login(un, pwd);
		Thread.sleep(2000);
		HomePage H= new HomePage(driver);
		boolean profile = H.myProfiletab.isDisplayed();
		if(profile==true)
		{
			System.out.println("Login Successfully");
		}
		else
		{
			System.out.println("Login Failed");
		}
		
	}
	
	@Test
	public void TC2_Login() 
	{
		String un = GetData.fromExcel(".\\data\\tdata.xlsx", "TC_01", 2, 0);
		String pwd = GetData.fromExcel(".\\data\\tdata.xlsx", "TC_01", 2, 1);
		LoginPage l =	new LoginPage(driver);
		l.login(un, pwd);
		String actualText = l.invalidcredential.getText();
		String expectedText = "Your username or password is incorrect";
		if(actualText.equals(expectedText))
		{
			System.out.println("As expected throwing error on entering of invalid credential");
		}
		else 
		{
			System.out.println("Not throwing error on entering of invalid crednetial");
		}
		
		
	 
		
	}
	

	@Test
	public void TC3_Addtocart() throws InterruptedException
	{
		TC1_Login();
		HomePage H= new HomePage(driver);
		H.Search.sendKeys("Shirts",Keys.ENTER);
		ProductPage P=new ProductPage(driver);
		P.firstproduct.click();
		P.secondproduct.click();
		Set<String> Uids= driver.getWindowHandles();
		Iterator<String> itr= Uids.iterator();
		String ParentID= itr.next();
		String ChildID1= itr.next();
		String ChildID2= itr.next();
		driver.switchTo().window(ChildID1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		P.selectSize.click();
		js.executeScript("window.scrollBy(0,2000)", "");
		P.addtoCart.click();
		driver.switchTo().window(ChildID2);
		js.executeScript("window.scrollBy(0,700)", "");
		P.selectSize.click();
		js.executeScript("window.scrollBy(0,3000)", "");
		P.addtoCart.click();
		String pt = P.pageTitle.getText();

		if(pt.equals("My Cart (2)"))
		{
			System.out.println("Selected product added in cart successfully");
		}
		else {
			System.out.println("Selected product not added in cart");
		}			
	}
	
	
	@Test
	public void TC4_Remove_product_from_cart() throws InterruptedException
	{
		TC1_Login();
		ProductPage P = new ProductPage(driver);
		P.carticon.click();
		
		P.removeprodfromcart.click();
		P.Removebutton.click();
		Thread.sleep(1000);
		boolean toastmsg = P.toastmsgonremoveproduct.isDisplayed();
		if(toastmsg==true)
		{
			System.out.println("product removed successfully from cart");
		}
		else 
		{
			System.out.println("product not removed from cart");
				
		}
		Thread.sleep(5000);
		P.removeprodfromcart.click();
		P.Removebutton.click();
		Thread.sleep(2000);
		boolean toastmsg1 = P.toastmsgonremoveproduct.isDisplayed();
		if(toastmsg1==true)
		{
			System.out.println("product removed successfully from cart");
		}
		else 
		{
			System.out.println("product not removed from cart");
				
		}
		Thread.sleep(1000);
				
	}
	
	@Test
	public void TC5_Navigate_to_Orderspage() throws InterruptedException
	{
		TC1_Login();
		LoginPage l =	new LoginPage(driver);
		HomePage H= new HomePage(driver);
		ProductPage P = new ProductPage(driver);
		Handler.mouseHover(driver, H.myProfiletab);
		P.orders.click();
		String actualTitle = P.searchOrder.getText();
		String expectedTitle="Search Orders";
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Able to view Order list page");
		}
		else 
		{
			System.out.println("Not able to view Order list page");
		}
		Handler.mouseHover(driver, H.myProfiletab);
		l.logout.click();
		boolean status = l.logoutvalidation.isDisplayed();	
		if(status==true)
		{
			System.out.println("Logout Successfully");
		}
		else
		{
			System.out.println("Logout Failed");
		}
	}

	

}
