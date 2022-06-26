package com.jsp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.basepackage.xBaseTestClass;
import com.jsp.basepackagesimple.BaseClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;


public class simplepingtest extends BaseTestClass {


	@Test
	public static void pingtest() {

		ExtentReport.createTestName("pingTest");
		String url = "https://www.google.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);


		String pagetitle = DriverManager.getDriver().getTitle();
		Assert.assertEquals(pagetitle, "Google");

		ExtentManager.getExtentTest().info("Page Title is  " + pagetitle);

		System.out.println("URL opened");
		System.out.println("Test Pass");

		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed", ExtentColor.GREEN));
		//		ExtentManager.getExtentTest().fail( MarkupHelper.createLabel("Test Failed", ExtentColor.RED));

		/*
		 * ExtentReport.createTest("pingTest"); String url = "https://www.google.com";
		 * DriverManager.getDriver().get(url);
		 * ExtentManager.getExtentTest().pass("Opening URL " + url);
		 * ExtentManager.getExtentTest().info("Page Title is  " + pagetitle);
		 * ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed",
		 * ExtentColor.GREEN)); ExtentManager.getExtentTest().fail(
		 * MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
		 * 
		 */

	}




}
