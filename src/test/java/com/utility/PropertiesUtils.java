package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	public static String getPropertyValue(String key)   {
		File file = new File(System.getProperty("user.dir")+"\\config\\QA.properties");
		FileReader fileReader;
		Properties pro = null;
		try {
			fileReader = new FileReader(file);
			pro = new Properties();
			pro.load(fileReader);
		} catch (FileNotFoundException e) {
		}
		
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro.getProperty(key);
	}
	
	
}
