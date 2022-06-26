package com.jsp.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class TakesScreenshotTest extends BaseTestClass {
	@Test
	public static void testCase1(){

		ExtentReport.createTestName("testCase1");
		String url = "https://www.google.com/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("ScreenShot Demo");
		Assert.assertTrue(false);
		//		TakesScreenshotDemo.screenShot(DriverManager.getDriver(), "testCase1");
	}


	@Test
	public static void testCase2(){

		ExtentReport.createTestName("testCase2");
		String url = "https://www.google.com/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);
		Assert.assertTrue(true);
		//		TakesScreenshotDemo.screenShot(DriverManager.getDriver(),"testCase2");
	}


	@AfterMethod
	public static void closedown(ITestResult result) {
		if(result.FAILURE == result.getStatus()) {
			TakesScreenshotDemo.screenShot(DriverManager.getDriver(), result.getName());
		}
	}
}

