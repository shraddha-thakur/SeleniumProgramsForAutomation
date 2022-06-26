package com.jsp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ExcelPOI extends BaseTestClass{


	@Test
	public void excelFileRead() throws IOException {

		ExtentReport.createTestName("verify Excel File Read working or not");
		String url = "http://demowebshop.tricentis.com/login";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		File ff = new File(System.getProperty("user.dir")+"/src/test/resources/excel/testData.xlsx");
		FileInputStream fi = new FileInputStream(ff);

		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int roc = sheet.getLastRowNum();
		System.out.println(roc);
		ExtentManager.getExtentTest().info("No. of Rows " + roc);

		for(int i = 1; i <= roc; i++) {

			String uname = sheet.getRow(i).getCell(0).getStringCellValue();
			String pwd = sheet.getRow(i).getCell(1).getStringCellValue();

			System.out.println(uname + " " + pwd);
			ExtentManager.getExtentTest().info(uname + " " + pwd);

			DriverManager.getDriver().findElement(By.id("Email")).clear();
			DriverManager.getDriver().findElement(By.id("Email")).sendKeys(uname);
			DriverManager.getDriver().findElement(By.id("Password")).sendKeys(pwd);
			DriverManager.getDriver().findElement(By.xpath("//input[@value='Log in']")).click();
			ExtentManager.getExtentTest().pass(uname + " " + pwd + " values entered");
		}
	}

}
