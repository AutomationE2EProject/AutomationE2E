package com.ui.listeners;

import com.aventstack.extentreports.*;
import java.io.ObjectInputFilter.Status;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger =  LoggerUtility.getLogger(this.getClass());
//	ExtentSparkReporter extentSparkReporter;
//	ExtentReports extentReports;
//	ExtentTest extentTest;
	
	
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
		  }

		
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " PASSED");
		ExtentReportUtility.getTest().log(com.aventstack.extentreports.Status.PASS, result.getMethod().getMethodName() + " PASSED");

	}

		 
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " FAILED");
		ExtentReportUtility.getTest().log(com.aventstack.extentreports.Status.FAIL, result.getMethod().getMethodName() + " FAILED");
		logger.error(result.getThrowable());
		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase)testclass).getInstance();
		String path = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(path);
		  }
	
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReportUtility.getTest().log(com.aventstack.extentreports.Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

	}
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
//		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports.html");
//		extentReports = new ExtentReports();
//		extentReports.attachReporter(extentSparkReporter);
		ExtentReportUtility.setUpSparkReport("report.html");
	}
	public void onFinish(ITestContext context) {
		logger.info("Test Completed");
//		extentReports.flush();
		ExtentReportUtility.flushTest();
	}

		
	
}
