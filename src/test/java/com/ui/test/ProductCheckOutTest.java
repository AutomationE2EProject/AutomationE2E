package com.ui.test;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;

import static com.constants.Size.*;
import com.pages.HomePage;
import com.pages.MyAccountPage;
import com.pages.SearchProductPage;
import com.ui.dataproviders.LoginDataProvider;
import com.ui.listeners.TestListener;
import com.uo.pojo.AddressPojo;
import com.uo.pojo.User;
import com.utility.FakerAddressUtility;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class ProductCheckOutTest extends TestBase {
//	 HomePage homePage;
	private static final String EMAIL="test2March14@gmail.com";
	private static final String PASSWORD="test2";
	private static final String SEARCH_TERM="Printed Summer Dress";
	AddressPojo addressPojo;
	MyAccountPage myAccountPage;
	SearchProductPage searchProductPage;
	 
	@BeforeMethod(description = "verify with the valid user able to login to the application")
	void setUp() throws IOException {
		searchProductPage = homePage.clickOnSignButton().doLoginWith(EMAIL,PASSWORD).searchProdcut(SEARCH_TERM);
		
	}

	@Test(description = "MyAddress",groups= {"e2e"})
	public void ProductCheckOutTest() {
		
		assertEquals(searchProductPage.productCheckout(1).changeSize(M).addToCart().proceedToCheckout().goToAddressPage().goToShippingPage().goToPaymentPage().payment(), "Your order on My Shop is complete.");
//		assertTrue(homePage.clickOnSignButton().doLoginWith(EMAIL,PASSWORD).searchProdcut(SEARCH_TERM).getAllSearchProducts().contains("Printed Summer Dress"));
		}

}
