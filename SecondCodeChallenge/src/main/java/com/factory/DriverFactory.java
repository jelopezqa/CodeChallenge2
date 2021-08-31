package com.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverFactory {
	
	static String pathFormat = System.getProperty("user.dir")+"\\src\\main\\resources\\%s";
	public WebDriver driver;
	static String url = "http://the-internet.herokuapp.com";  
		
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", String.format(pathFormat, "chromedriver.exe"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closingBrowser() throws InterruptedException {
		driver.quit();
	}

}
