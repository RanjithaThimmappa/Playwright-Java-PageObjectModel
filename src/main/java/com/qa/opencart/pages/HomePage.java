package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	
	private String search="input[name='search']";
	private String searchicon="div#search button";
	private String searchresulttext="div#content h1";
	private String myAccountText="//span[text()='My Account']";
	private String loginText="//a[text()='Login']";
	
	public HomePage(Page page) {
		this.page = page;
	}

	public String getHomePageTitle()
	{
		String title=page.title();
		System.out.println("page title :" + title);
		return title;
	}
	
	public String getHomePageURL()
	{
		String url=page.url();
		System.out.println("page url :" + url);
		return url;
	}
	
	public String doSearch(String productName)
	{
		page.fill(search,productName);
		page.click(searchicon);
		String header= page.textContent(searchresulttext);
		System.out.println("the search header is: "+ header);
		return header;
	}
	
	public LoginPage navigateToLoginPage()
	{
		page.click(myAccountText);
		page.click(loginText);
		return new LoginPage(page);
	}
	
	
}

