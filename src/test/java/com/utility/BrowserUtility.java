package com.utility;

import java.awt.RenderingHints.Key;
import java.beans.Visibility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;


public abstract class BrowserUtility {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger =  LoggerUtility.getLogger(this.getClass());
	WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}



	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}



	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		}
		else if(browserName.equals(Browser.EDGE)) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
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
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}
			else {
				option.setAcceptInsecureCerts(true);
				option.addArguments("--ignore-certificate-errors");
				driver.set(new ChromeDriver(option));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}
		}
		else if(browserName.equals(Browser.EDGE)) {
			if(isHeadLess) {
				edgeOptions.addArguments("--headless=new");
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
			}
			else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
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
//		implicittWait();
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.get().findElement(element).click();
		logger.info("Clicked on Element  : "+element);
	}

	public void clickOn(WebElement element) {
//		implicittWait();
//		element.click();
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		logger.info("Clicked on Element  : "+element);
	}

	public void clickOnCheckBox(By element) {
//		implicittWait();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.get().findElement(element).click();
		logger.info("Clicked on Element  : "+element);
	}
	public void clearText(By element) {
//		implicittWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.get().findElement(element).clear();;
		logger.info("Clear Text Element Locator : "+element);
	}

	public void enterText(By element,String text) {
//		implicittWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.get().findElement(element).sendKeys(text);
		logger.info("Entered Text  : "+text +" Element Locator : "+element);
	}

	public void enterTextWithEnter(By element,Keys key) {
//		implicittWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.get().findElement(element).sendKeys(key);
		logger.info("Entered Special Key  : "+key +" Element Locator : "+element);
	}
	
	public String getVisibleText(By element) {
//		implicittWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		String txt = driver.get().findElement(element).getText();
		
		logger.info("Get the text from element  : "+txt);
		return txt;
	}

	public List<String> getAllVisibleText(By element) {
//		implicittWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		List<WebElement> elements = driver.get().findElements(element);
		List<String> names = new ArrayList();
		for (WebElement ele : elements) {
			names.add(ele.getText());
			
		}
		logger.info("Get the text from element  : "+names);
		return names;
	}

	public List<WebElement> getAllElements(By element) {
//		implicittWait();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
		List<WebElement> elements = driver.get().findElements(element);
		logger.info("Get all elements  : "+elements);
		return elements;
	}
	
	public void selectByValue(By element,String Text) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Select select = new Select(driver.get().findElement(element));
		select.selectByValue(Text);
		logger.info("Selected by value  : "+Text+"on element "+element);
	}

	public void selectByVisibleText(By element,String Text) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.get().findElement(element);
		Select select = new Select(ele);
		select.selectByVisibleText(Text);
		logger.info("Selected by VisibleText  : "+Text+"on element "+element);
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
	
	public void moveToElement(By element) {
	Actions actions = new Actions(getDriver());
	actions.moveToElement(getDriver().findElement(element)).perform();
	}
}
