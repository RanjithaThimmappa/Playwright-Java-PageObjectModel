package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void loginPageNavigationTest()
	{
		loginPage=homePage.navigateToLoginPage();
		String actualLoginPageTitle=loginPage.getLoginPageTitle();
		System.out.println("Login page title"+ actualLoginPageTitle);
	    Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	 @Test(priority=2)
	  public void forgotpasswordLinkexiststest() {
	 
	 Assert.assertTrue(loginPage.isForgotpwdLinkExists()); }
	 
    @Test(priority=3)
	public void appLoginTest()
	{
    	Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}
}
