package com.flipkart.test.functional;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenShot 
{
	@Test
	public void test() throws IOException
	{
		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File srcimg = edriver.getScreenshotAs(OutputType.FILE);
		File tarimg = new File("./screenshot/testimg.jpg");
		FileUtils.copyFile(srcimg, tarimg);
	}
}









