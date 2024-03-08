package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	//string locators
	private String emailid="#input-email";
	private String password="#input-password";
	private String loginBtn="//input[@value='Login']";
	private String forgotPwdLink="//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

	//creating constuctor
	public LoginPage(Page page) {
		this.page=page;
	}
	
	//page actions
	public String getLoginPageTitle()
	{
		return page.title();
	}
	
	public boolean isForgotpwdLinkExists()
	{
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword)
	{
		System.out.println("Application creddetials"+appUserName +":"+ appPassword);;
		page.fill(emailid, appUserName);
		page.fill(password, appPassword);
		page.click(loginBtn);
		if(page.isVisible(logoutLink))
		{
			System.out.println("User is logged out");
			return true;
		}
	return false;
	}
	
}
