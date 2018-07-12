package com.guru.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.Base.BaseClass;

public class LoginGuruPage extends BaseClass{
	
	//page object repository
	
	@FindBy(name="uid")
	WebElement userid;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public LoginGuruPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//action/methods
	
	public String loginTitle() {
		return driver.getTitle();
	}
	
	public HomeGuruPage login() {
		userid.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomeGuruPage();
	}
	
}
