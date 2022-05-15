package Test_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sunil.d.kumar.gupta\\Documents\\Sunil\\Tools\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.youtube.com");
		driver.close();
	}

}
