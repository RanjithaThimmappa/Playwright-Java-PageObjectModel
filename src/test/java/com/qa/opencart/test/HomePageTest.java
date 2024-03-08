package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;

public class HomePageTest extends BaseTest {

	
	@Test
	public void homePageTitleTest()
	{
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void homePageURLTest()
	{
		String actualURL=homePage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Mac Book"},
			{"iMac"},
			{"Samsung"}
		};
		
	}
	
	@Test(dataProvider="getProductData")
	public void searchTest(String productName)
	{
		String searchText=homePage.doSearch(productName);
		Assert.assertEquals(searchText, "Search - "+productName);
	}
	
}
