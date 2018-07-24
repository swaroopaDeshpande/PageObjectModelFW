package com.crm.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long Page_Load_TimeOut = 40;
	public static long implicit_wait = 40;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	static Workbook book;
	static Sheet sheet;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\HP\\workspace\\POM_FW\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData_POM.xlsx";

	// get data from excel:
	public static Object[][] getDataFromSheet(String sheetName) {

		// To read data
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// created XL workbook
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// need to get sheet name
		sheet = book.getSheet(sheetName);
		// this method return object[][] array
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "--------" + sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		//Files.createFile("currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")));"
		
		}

}
