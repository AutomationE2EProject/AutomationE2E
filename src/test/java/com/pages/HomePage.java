package com.pages;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtils;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtils;

final public class HomePage extends BrowserUtility {
	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]"); 
	Logger logger =  LoggerUtility.getLogger(this.getClass());
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtils.getJSONValue(QA).getUrl());
	}
//	
	 
	 public HomePage(Browser browserName,boolean isHeadLess) throws IOException {
		super(browserName,isHeadLess);
//		goToWebsite(PropertiesUtils.getPropertyValue("url"));
		goToWebsite(JSONUtils.getJSONValue(QA).getUrl());
	}
	
	
	public LoginPage clickOnSignButton() {
		
		clickOnElement(SIGN_IN_LOCATOR);
		logger.info("Clicked on SIGN_IN Button " +SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver()); 
		return loginPage;
	}
	
	

}
