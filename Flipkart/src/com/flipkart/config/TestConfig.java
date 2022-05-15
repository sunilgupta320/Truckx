package com.flipkart.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.Zip;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.flipkart.helper.GetData;
import com.google.common.io.Files;



public class TestConfig
{
	public WebDriver driver;
	@BeforeSuite
	public void preSuite()
	{
		Date d = new Date();
		String date = d.toString().replace(":", "_");
		File srcfolder = new File("./test-output");
		File tarfolder = new File("./reports/"+date+".zip");
		//Zip z = new Zip();
		try {
			//z.zip(srcfolder,tarfolder);
			Files.move(srcfolder, tarfolder);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@BeforeMethod
	public void precondition()
	{
		String browserName = GetData.fromProperties(".\\data\\config.properties", "browser");
		String url = GetData.fromProperties(".\\data\\config.properties", "url");
		if(browserName.equals("FF"))
		{	
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\browser_exe\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", ".\\browser_exe\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
	}
	@AfterMethod
	public void postCondition()
	{
		
		driver.quit();
	}
	
		
	
}
