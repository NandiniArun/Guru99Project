package com.guru.qa.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.guru.qa.Base.BaseClass;

public class TestUtility extends BaseClass{
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] readExcelData(String sheetname) {
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream("C:\\Users\\ab461w\\eclipse-workspace\\javatutorial.tv\\Guru99Project\\src\\main\\java\\com\\guru\\qa\\TestData\\Guru99TestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return data;
		
	}

}
