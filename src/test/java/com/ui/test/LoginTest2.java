package com.ui.test;

import org.apache.logging.log4j.Logger;
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
public class LoginTest2 extends TestBase {
//	 HomePage homePage;
	 
	 
//	@BeforeMethod(description = "Load the home page for the website ")
//	void setUp() throws IOException {
//		 homePage = new HomePage(CHROME);
//	}
	 

	@Test(description = "verifies with the valid user able to login to the application",groups= {"e2e"})
	public void loginTest() {
		
		assertEquals(homePage.clickOnSignButton().doLoginWith("test2March14@gmail.com","test2").getUserName(), "Test test");
		}
//	
	@Test(description = "verifies with the valid user able to login to the application",groups= {"e2e","smoke"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginJSONDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginJSONTest(User user) {
//		assertEquals(homePage.clickOnSignButton().doLoginWith("test2March14@gmail.com","test2").getUserName(), "Test test");
		assertEquals(homePage.clickOnSignButton().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Test test");
	}
	
	@Test(description = "verifies with the valid user able to login to the application",dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginCSVDataProvider")
	public void loginCSVTest(User user) {
//		assertEquals(homePage.clickOnSignButton().doLoginWith("test2March14@gmail.com","test2").getUserName(), "Test test");
		assertEquals(homePage.clickOnSignButton().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Test test");
	}
	
	@Test(description = "verifies with the valid user able to login to the application",groups= {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginExcelDataProvider")
	public void loginExcelTest(User user) {
		Logger logger =  LoggerUtility.getLogger(this.getClass());
		logger.info("Started my Login Excel Test");
//		assertEquals(homePage.clickOnSignButton().doLoginWith("test2March14@gmail.com","test2").getUserName(), "Test test");
		assertEquals(homePage.clickOnSignButton().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Test test");
		logger.info("Completed my Login Excel Test");
	}
	
	
	 

}
