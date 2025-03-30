package com.ui.test;

import static com.constants.Browser.CHROME;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtlity;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the home page for the website ")
	void setUp(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("true")boolean isHeadless, 
			ITestResult result) throws IOException {
//		 homePage = new HomePage(CHROME);
//		 homePage = new HomePage(CHROME,true);
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtlity.intializeLambdaTestSession("chrome", result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			logger.info("Load the home page of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Close the browser")
	void close() throws IOException {
		if(isLambdaTest)
		{
			LambdaTestUtlity.quitSession();//cloud
		}else {
			homePage.closeBrowser();//local
		}
		
	}

}
