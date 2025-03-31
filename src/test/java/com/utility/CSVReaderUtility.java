package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.uo.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> csvReader() {
		// TODO Auto-generated method stub
//		File file = new File(System.getProperty("user.dir")+"\\testData\\loginData.csv");
		File file = new File("./testData/loginData.csv");
		FileReader fileReader;
		CSVReader data;
		List<User> userList = null;
		String line[];
		User userData;
		try {
			fileReader = new FileReader(file);
			data = new CSVReader(fileReader);
			userList = new ArrayList<User>();
			data.readNext();
			
			while((line = data.readNext())!=null) {
				userData = new User(line[0],line[1]);
				userList.add(userData);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		 catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();

	}

}
