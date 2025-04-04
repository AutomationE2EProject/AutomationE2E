package com.pages;

import java.awt.RenderingHints.Key;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class MyAccountPage extends BrowserUtility {
	
	private static final By MY_ACCOUNT_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SIGN_OUT_LOCATOR = By.xpath("//a[@class='logout']");
	private static final By SEARCH_LOCATOR = By.id("search_query_top");
	private static final By MY_ADDRESS_LOCATOR = By.xpath("//span[text()='Add my first address']");
	Logger logger =  LoggerUtility.getLogger(this.getClass());
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getUserName(){
		return getVisibleText(MY_ACCOUNT_LOCATOR);
	}


	public SearchProductPage searchProdcut(String search_product){
		enterText(SEARCH_LOCATOR, search_product);
		enterTextWithEnter(SEARCH_LOCATOR, Keys.ENTER);
		SearchProductPage searchProductPage = new SearchProductPage(getDriver());
		return searchProductPage;
		
	}
	
	public MyAddressPage goToMyAddressPage(){
		clickOnElement(MY_ADDRESS_LOCATOR);
		return new MyAddressPage(getDriver());
	}
	
	
}
