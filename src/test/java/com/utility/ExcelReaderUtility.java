package com.utility;

import java.awt.Window.Type;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uo.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> excelReader(String filename) {
		// TODO Auto-generated method stub
		
//		File excelFile = new File(System.getProperty("user.dir")+"\\testData\\"+filename);
		File excelFile = new File("./testData/"+filename);
		XSSFWorkbook xssfWorkBook;
		XSSFSheet xssfSheet; 
		List<User> userList = new ArrayList<User>();
		User user;
		Row row;
		try {
			xssfWorkBook = new XSSFWorkbook(excelFile);
			xssfSheet = xssfWorkBook.getSheet("LoginData");
			Iterator<Row> rowIterator = xssfSheet.rowIterator();
			rowIterator.next();
			while(rowIterator.hasNext()) {
				
				row = rowIterator.next();
				if(row.getCell(0).toString().length()>0){
				userList.add(new User(row.getCell(0).toString(), row.getCell(1).toString()));
				}
				}
			
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
