package com.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class LoginPage extends BrowserUtility {
	
	private static final By CREATE_EMAIL_LOCATOR = By.xpath("//input[@id='email_create']");
	private static final By BUTTON_CREATE_ACCOUNT_LOCATOR = By.xpath("//button[@id='SubmitCreate']");
	private static final By GENDER_LOCATOR = By.xpath("//input[@id='id_gender1']");
	private static final By FIRST_NAME_LOCATOR = By.xpath("//input[@id='customer_firstname']");
	private static final By LAST_NAME_LOCATOR = By.xpath("//input[@id='customer_lastname']");
	private static final By PASSWORD_LOCATOR = By.xpath("//input[@id='passwd']");
	private static final By SELECT_DAY_LOCATOR = By.xpath("//select[@id='days']");
	private static final By SELECT_MONTH_LOCATOR = By.xpath("//select[@id='months']");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@id='submitAccount']");
	private static final By EMAIL_LOCATOR = By.xpath("//input[@id='email']");
	private static final By SUBMIT_LOGIN_LOCATOR = By.xpath("//button[@id='SubmitLogin']");
	Logger logger =  LoggerUtility.getLogger(this.getClass());

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	public MyAccountPage doLoginWith(String email,String password) {
		enterText(EMAIL_LOCATOR,email );
		logger.info("Entered Email : "+email);
		enterText(PASSWORD_LOCATOR, password);
		logger.info("Entered Password : "+password);
		clickOnElement(SUBMIT_LOGIN_LOCATOR);
		logger.info("Clicked on submit button "+SUBMIT_LOGIN_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	
}
