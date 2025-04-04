package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.pages.HomePage;
import com.ui.dataproviders.LoginDataProvider;
import com.ui.listeners.TestListener;
import com.uo.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTestInvalidCredentials extends TestBase {
//	 HomePage homePage;
	private static final String EMAIL="test2March14@gmail.com";
	private static final String PASSWORD="test3";
	 
//	@BeforeMethod(description = "Load the home page for the website ")
//	void setUp() throws IOException {
//		 homePage = new HomePage(CHROME);
//	}
	 

	@Test(description = "verify with the invalid user not able to login to the application",groups= {"e2e"})
	public void loginInvalideCredentialsTest() {
		
		assertEquals(homePage.clickOnSignButton().doLoginWithInvalidCredentials(EMAIL,PASSWORD).getErrorMessage(), "Authentication failed.");
		}

}
