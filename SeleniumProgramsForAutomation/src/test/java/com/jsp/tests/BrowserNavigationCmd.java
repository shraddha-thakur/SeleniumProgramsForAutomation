package com.jsp.tests;

import org.testng.annotations.Test;

import com.jsp.basepackage.xBaseTestClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class BrowserNavigationCmd extends BaseTestClass{

	@Test
	public void browserNavigationCmd() {


		ExtentReport.createTestName("browserNavigationCmd");
		DriverManager.getDriver().get("https://google.com");

		String url = "https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html";

		DriverManager.getDriver().navigate().to(url);
		ExtentManager.getExtentTest().pass("Navigate to URL " + url);

		DriverManager.getDriver().navigate().back();
		ExtentManager.getExtentTest().pass("Navigate Back");

		DriverManager.getDriver().navigate().forward();
		ExtentManager.getExtentTest().pass("Navigate Forward");

		DriverManager.getDriver().navigate().refresh();
		ExtentManager.getExtentTest().pass("Page Refresh");



	}



}
