package com.assignment2.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment2.base.Base;
import com.assignment2.pages.SwagLabsLoginPage;
import com.assignment2.util.ExcelFileReader;

public class SwagLabsLoginTest extends Base{

	SwagLabsLoginPage slp;
	
	public SwagLabsLoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		slp = new SwagLabsLoginPage();	
	}
	
	@Test
	public void swagLabTest() throws InterruptedException {
		ExcelFileReader reader = new ExcelFileReader();
		reader.testData("E:\\JAVA Practice\\Assignment2\\src\\main\\java\\com\\assignment2\\testdata\\ExcelTestData.xlsx");
		String row = ExcelFileReader.sheet.getRow(1).getCell(0).getStringCellValue();
		String row1 = ExcelFileReader.sheet.getRow(1).getCell(1).getStringCellValue();
		slp.swaglabs(row, row1, slp.Dropdownbox, "Price (low to high)");
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
