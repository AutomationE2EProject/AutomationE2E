package com.utility;

import java.beans.Visibility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;


public abstract class BrowserUtility {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger =  LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}



	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}



	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	

	public BrowserUtility(Browser browserName) {
		super();
		logger.info("lunching browser : "+browserName);
		if(browserName.equals(Browser.CHROME)) {
			ChromeOptions option = new ChromeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("--ignore-certificate-errors");
//			option.addArguments("incognito");
			
			driver.set(new ChromeDriver(option));
		}
		else if(browserName.equals(Browser.EDGE)) {
			driver.set(new EdgeDriver());
		}
		else {
			logger.error("Inavalid Browser Name !!! select browser name Chrome or edge : "+browserName);
			System.err.println("Inavalid Browser Name !!! select browser name Chrome or edge");
		}
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadLess) {
		super();
		logger.info("lunching browser : "+browserName);
		ChromeOptions option = new ChromeOptions();
		EdgeOptions edgeOptions = new EdgeOptions();
		if(browserName.equals(Browser.CHROME)) {
			if(isHeadLess) {
			
			option.setAcceptInsecureCerts(true);
			option.addArguments("--ignore-certificate-errors");
			option.addArguments("--headless=new");
			option.addArguments("--window-size=1920,1080");
			
			driver.set(new ChromeDriver(option));
			}
			else {
				option.setAcceptInsecureCerts(true);
				option.addArguments("--ignore-certificate-errors");
				driver.set(new ChromeDriver(option));
			}
		}
		else if(browserName.equals(Browser.EDGE)) {
			if(isHeadLess) {
				edgeOptions.addArguments("--headless=new");
				driver.set(new EdgeDriver());
			}
			else {
				driver.set(new EdgeDriver());
			}
		}
		else {
			logger.error("Inavalid Browser Name !!! select browser name Chrome or edge : "+browserName);
			System.err.println("Inavalid Browser Name !!! select browser name Chrome or edge");
		}
	}
	
	public void goToWebsite(String Url) {
		implicittWait();
		driver.get().get(Url);
		logger.info("Entered URL of the application : "+Url);
		driver.get().manage().window().maximize();
	}
	
	public void clickOnElement(By element) {
		implicittWait();
		driver.get().findElement(element).click();
		logger.info("Clicked on Element  : "+element);
	}

	public void enterText(By element,String text) {
		implicittWait();
		driver.get().findElement(element).sendKeys(text);
		logger.info("Entered Text  : "+text +" Element Locator : "+element);
	}
	
	public String getVisibleText(By element) {
		implicittWait();
		String txt = driver.get().findElement(element).getText();
		
		logger.info("Get the text from element  : "+txt);
		return txt;
	}
	
	public void selectByValue(By element,String Text) {
		Select select = new Select(driver.get().findElement(element));
		select.selectByValue(Text);
		logger.info("Selected by value  : "+Text+"on element "+element);
	}
	
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
	}
	public void implicittWait() {
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void closeBrowser() throws IOException {
		driver.get().quit();
	
	}
	
	public String takeScreenShot(String name) {
		Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
				format.format(date);
		TakesScreenshot screenShot = (TakesScreenshot)driver.get();
		File screenShotData = screenShot.getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir")+"//screenshot//"+name+format+".png";
		String path = "./screenshot/"+name+format+".png";
		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotData, screenShotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	} 
	

}
