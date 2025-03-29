package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtils;
import com.utility.PropertiesUtils;

public class MyRetryAnalyzer implements IRetryAnalyzer {
//	private static final int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtils.getPropertyValue("MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(JSONUtils.getJSONValue(Env.QA).getMAX_NUMBER_OF_ATTEMPTS());
	private static int current_number_of_attempts=1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(current_number_of_attempts<=MAX_NUMBER_OF_ATTEMPTS)
		{
			current_number_of_attempts++;
			return true;
		}
		return false;
	}
		
}
