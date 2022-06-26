package com.jsp.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.jsp.basepackage.xBaseTestClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class GetBrowserName extends BaseTestClass{


	@Test
	public static void GetBrowserName() {

		ExtentReport.createTestName("GetBrowserName");
		String url = "https://www.google.com/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);

		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();

		System.out.println(js.executeScript("return navigator.appCodeName"));
		System.out.println(js.executeScript("return navigator.appVersion"));
		System.out.println(js.executeScript("return navigator.platform"));
		System.out.println(js.executeScript("return navigator.language"));
		System.out.println(js.executeScript("return navigator.javaEnabled()"));

		ExtentManager.getExtentTest().info((String) js.executeScript("return navigator.appCodeName"));

		/**
		 *appName: IE11, Chrome, Firefox, and Safari return appName "Netscape".
		 *appCodeName:	Chrome, Firefox, IE, Safari, and Opera all return appCodeName "Mozilla".
		 */


	}


}
