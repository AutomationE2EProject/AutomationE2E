package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.uo.pojo.AddressPojo;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {
	private static final By SELECT_SIZE_LOCATOR = By.cssSelector("#group_1");
	private static final By ADDTOCART_LOCATOR = By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");
	
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsPage changeSize(Size size) {
		moveToElement(SELECT_SIZE_LOCATOR);
		System.out.println("");
//		clickOnElement(SELECT_SIZE_LOCATOR);
		selectByVisibleText(SELECT_SIZE_LOCATOR, size.toString());
		return new ProductDetailsPage(getDriver());
	}

	public ProductDetailsPage addToCart() {
		clickOnElement(ADDTOCART_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}

	public ShoppingCartPage proceedToCheckout() {
		clickOnElement(PROCEED_TO_CHECKOUT_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}
	
	

	

}
