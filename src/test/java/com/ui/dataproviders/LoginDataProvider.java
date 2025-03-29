package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.uo.pojo.Config;
import com.uo.pojo.TestData;
import com.uo.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name="LoginJSONDataProvider")
	public Iterator<Object[]> loginJSONDataProvider() throws FileNotFoundException {
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		FileReader fileReader = new FileReader(file);
		TestData data = gson.fromJson(fileReader, TestData.class);
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (User user : data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
	}
	
	
	@DataProvider(name="LoginCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() throws FileNotFoundException {
		
		return CSVReaderUtility.csvReader();
	}
	
	@DataProvider(name="LoginExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() throws FileNotFoundException {
		
		return ExcelReaderUtility.excelReader("loginData.xlsx");
	}
	
}
