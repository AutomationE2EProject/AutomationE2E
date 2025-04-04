package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	private static final By PAY_BY_BANK_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
	private static final By CONFIRM_ORDER_LOCATOR = By.xpath("//button[@type='submit']//span[text()='I confirm my order']");
	private static final By CONFIRM_ORDER_MESSAGE_LOCATOR = By.xpath("//p[text()='Your order on My Shop is complete.']");
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String payment() {
		clickOnElement(PAY_BY_BANK_LOCATOR);
		clickOnElement(CONFIRM_ORDER_LOCATOR);
		return getVisibleText(CONFIRM_ORDER_MESSAGE_LOCATOR);
	}

}
