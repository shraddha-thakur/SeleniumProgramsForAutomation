package com.jsp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ExcelPOIDataProvider extends BaseTestClass{


	@Test(dataProvider = "getCellData")
	public static void excelFileReadDP(String uname, String pwd) throws IOException {

		ExtentReport.createTestName("verify Excel File Read with Data Provider working or not");
		String url = "http://demowebshop.tricentis.com/login";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("Email")).clear();
		DriverManager.getDriver().findElement(By.id("Email")).sendKeys(uname);
		DriverManager.getDriver().findElement(By.id("Password")).sendKeys(pwd);
		DriverManager.getDriver().findElement(By.xpath("//input[@value='Log in']")).click();
		ExtentManager.getExtentTest().pass(uname + " " + pwd + " values entered");

	}

	@DataProvider
	public Object[][] getCellData() throws Exception {

		File ff = new File(System.getProperty("user.dir")+"/src/test/resources/excel/testData.xlsx");
		FileInputStream file = new FileInputStream(ff);

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		int cellcount = sheet.getRow(0).getLastCellNum();
		System.out.println(cellcount);


		Object data[][] = new Object[rowcount][cellcount];

		for(int i = 1; i<=rowcount; i++) {
			//			Row r = sheet.getRow(i);

			for(int j=0;j<cellcount; j++) {
				//				Cell c = r.getCell(j);
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;



		//		System.out.println(roc);
		//		ExtentManager.getExtentTest().info("No. of Rows " + roc);

		//		for(int i = 1; i <= roc; i++) {
		//
		//			String uname = sheet.getRow(i).getCell(0).getStringCellValue();
		//			String pwd = sheet.getRow(i).getCell(1).getStringCellValue();
		//
		//			System.out.println(uname + " " + pwd);
		//			ExtentManager.getExtentTest().info(uname + " " + pwd);
		//
		//		}
	}

}
