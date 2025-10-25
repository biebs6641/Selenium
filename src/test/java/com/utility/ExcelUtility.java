package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static String  getData(int rownumber, int cellNumber) throws InvalidFormatException, IOException {
		
		//create file class object
		
		File file =new File("C:\\Users\\LEGION\\Desktop\\TestData.xlsx");
		//create workbook objevt 
		XSSFWorkbook book = new XSSFWorkbook(file);
		//create sheet object
		Sheet sheet= book.getSheetAt(0);
//		specify row and cell data
		return sheet.getRow(rownumber).getCell(cellNumber).getStringCellValue();
		
		
		
	}
}
