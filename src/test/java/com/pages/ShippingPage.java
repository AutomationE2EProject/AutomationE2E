package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//button[@name='processCarrier']");
	private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR = By.cssSelector("#cgv");

	public ShippingPage(WebDriver driver) {
		super(driver);
	}
	public PaymentPage goToPaymentPage() {
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", getDriver().findElement(ACCEPT_TERMS_CHECKBOX_LOCATOR));
//		moveToElement(ACCEPT_TERMS_CHECKBOX_LOCATOR);
//		clickOnCheckBox(ACCEPT_TERMS_CHECKBOX_LOCATOR);
		clickOnElement(PROCEED_TO_CHECKOUT_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
