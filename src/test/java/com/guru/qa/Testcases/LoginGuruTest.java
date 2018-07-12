package com.guru.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.qa.Base.BaseClass;
import com.guru.qa.Pages.LoginGuruPage;



public class LoginGuruTest extends BaseClass{
	
	LoginGuruPage loginpage;
	
	public LoginGuruTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		intializeDriver();
		
		loginpage = new LoginGuruPage();
		
	}
	
	@Test(priority=2)
	public void loginTest() {
		loginpage.login();
		
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
