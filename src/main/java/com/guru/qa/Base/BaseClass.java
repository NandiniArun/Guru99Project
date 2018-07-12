package com.guru.qa.Base;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\ab461w\\eclipse-workspace\\javatutorial.tv\\Guru99Project\\src\\main\\java\\com\\guru\\qa\\Config\\config.properties");
			prop.load(ip);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void intializeDriver() {
		
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab461w\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ab461w\\Downloads\\geckodriver-v0.16.0-win32\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
/*		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
*/		
		driver.get(prop.getProperty("url"));
		
	}

}
