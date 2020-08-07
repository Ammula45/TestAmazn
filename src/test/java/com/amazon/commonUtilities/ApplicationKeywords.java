package com.amazon.commonUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class ApplicationKeywords  {

	public static AndroidDriver<MobileElement> driver;
	public static WebElement ele ;

	public static void lanuchApp() {
		try {
			driver.launchApp();
			System.out.println("App is Launched");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void closeApp() {
		try {
			driver.closeApp();
			System.out.println("App is Closed");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static String ReadExcelData(String ColumnName)throws IOException, InvalidFormatException {
		String SheetName = "Sheet1";

		File file = new File("C:\\Users\\Ravikanth\\eclipse-workspace\\TCSAppium\\extTestData\\Amazon_Testdata.xlsx");
		FileInputStream fi = new FileInputStream(file);

		Workbook wb = WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet(SheetName);
		Row row = sheet.getRow(0);
		
		short lastcolumnused = row.getLastCellNum();
		int colnum = 0;
		for (int i = 0; i < lastcolumnused; i++) {
			if(row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {

				colnum = i;
				break;
			}
		}
		// it will take value from Second row
		row = sheet.getRow(1);
		Cell column = row.getCell(colnum);
		String CellValue = column.getStringCellValue();
		return CellValue;
	}
}

