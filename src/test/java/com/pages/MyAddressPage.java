package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uo.pojo.AddressPojo;
import com.utility.BrowserUtility;

public class MyAddressPage extends BrowserUtility {
	private static final By COMPANY_INPUT_TEXTBOX_LOCATOR = By.xpath("//input[@id='company']");
	private static final By ADDRESS1_INPUT_TEXTBOX_LOCATOR = By.xpath("//input[@id='address1']");
	private static final By ADDRESS2_INPUT_TEXTBOX_LOCATOR = By.xpath("//input[@id='address2']");
	private static final By CITY_INPUT_TEXTBOX_LOCATOR = By.xpath("//input[@id='city']");
	private static final By ZIPCODE_INPUT_TEXTBOX_LOCATOR = By.xpath("//input[@id='postcode']");
	private static final By PHONE_INPUT_TEXTBOX_LOCATOR = By.xpath("//input[@id='phone']");
	private static final By PHONE_MOBILE_INPUT_TEXTBOX_LOCATOR = By.xpath("//input[@id='phone_mobile']");
	private static final By NOTE_TEXTBOX_LOCATOR = By.xpath("//textarea[@id='other']");
	private static final By ASSIGN_ADDRESS_TEXTBOX_LOCATOR = By.xpath("//input[@id='alias']");
	private static final By STATE_SELECT_LOCATOR = By.xpath("//select[@id='id_state']");
	private static final By SUBMIT_ADDRESS_LOCATOR = By.xpath("//button[@id='submitAddress']");
	private static final By ADDRESS_HEADING_LOCATOR = By.xpath("//h3");
	public MyAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String saveAddress(AddressPojo addressPojo) {
		enterText(COMPANY_INPUT_TEXTBOX_LOCATOR, addressPojo.getCompany());
		enterText(ADDRESS1_INPUT_TEXTBOX_LOCATOR, addressPojo.getAddress1());
		enterText(ADDRESS2_INPUT_TEXTBOX_LOCATOR, addressPojo.getAddress2());
		enterText(CITY_INPUT_TEXTBOX_LOCATOR, addressPojo.getCity());
		enterText(STATE_SELECT_LOCATOR, addressPojo.getState());
		enterText(ZIPCODE_INPUT_TEXTBOX_LOCATOR, addressPojo.getZipcode());
		enterText(PHONE_INPUT_TEXTBOX_LOCATOR, addressPojo.getHomePhone());
		enterText(PHONE_MOBILE_INPUT_TEXTBOX_LOCATOR, addressPojo.getMobilePhhone());
		enterText(NOTE_TEXTBOX_LOCATOR, addressPojo.getNotes());
		clearText(ASSIGN_ADDRESS_TEXTBOX_LOCATOR);
		enterText(ASSIGN_ADDRESS_TEXTBOX_LOCATOR, addressPojo.getAddressTitle());
		clickOnElement(SUBMIT_ADDRESS_LOCATOR);
		return getVisibleText(ADDRESS_HEADING_LOCATOR);
	}

	

}
