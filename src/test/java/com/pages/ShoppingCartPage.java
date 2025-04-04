package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("(//a[@title='Proceed to checkout'])[2]");
	
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public ConfirmAddressPage goToAddressPage() {
		clickOnElement(PROCEED_TO_CHECKOUT_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}

}
