package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class MyAccountPage extends BrowserUtility {
	
	private static final By MY_ACCOUNT_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SIGN_OUT_LOCATOR = By.xpath("//a[@class='logout']");
	Logger logger =  LoggerUtility.getLogger(this.getClass());
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getUserName(){
		return getVisibleText(MY_ACCOUNT_LOCATOR);
	}


	
}
