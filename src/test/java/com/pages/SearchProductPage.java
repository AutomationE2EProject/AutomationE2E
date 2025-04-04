package com.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utility.BrowserUtility;

public class SearchProductPage extends BrowserUtility{
	private static final By MY_ACCOUNT_LOCATOR = By.xpath("//h1[contains(@class,'product-listing')]/span[@class='lighter']");
	private static final By PRODUCT_NAME_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
	private static final By SINGLE_PRODUCT_NAME_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
	private static final By PRODUCT_MORE_LOCATOR = By.xpath("(//div[@class='button-container']/a[@title='View'])[1]");
	
	public SearchProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	
	public boolean isSearchTermPresentInProductList(String searchTerm){
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(PRODUCT_NAME_LOCATOR);
		boolean result = productNamesList.stream().anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}
	
	public ProductDetailsPage productCheckout(int index) {
		moveToElement(SINGLE_PRODUCT_NAME_LOCATOR);
		clickOnElement(PRODUCT_MORE_LOCATOR);
//		WebElement ele = getAllElements(PRODUCT_MORE_LOCATOR).get(index);
//		clickOn(ele);
		
		
		
		
		return new ProductDetailsPage(getDriver());
	}
	

}
