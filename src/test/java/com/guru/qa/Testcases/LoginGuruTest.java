package com.guru.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.Base.BaseClass;
import com.guru.qa.Pages.LoginGuruPage;
import com.guru.qa.Utility.TestUtility;



public class LoginGuruTest extends BaseClass{
	
	LoginGuruPage loginpage;
	TestUtility utility;
	
	String sheetname="Login";
	
	public LoginGuruTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		intializeDriver();
		
		loginpage = new LoginGuruPage();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		//Object[][] mydata= new Object[][];
		@SuppressWarnings("static-access")
		Object mydata[][] = utility.readExcelData(sheetname);
		
		return mydata;
		
		
	}
	
	@Test(priority=2,dataProvider="getData")
	public void loginTest(String username,String password) {
		loginpage.login(username,password);
		
	}
	
	
	
	@Test(priority=1)
	public void loginTitleTest() {
		String title = loginpage.loginTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
