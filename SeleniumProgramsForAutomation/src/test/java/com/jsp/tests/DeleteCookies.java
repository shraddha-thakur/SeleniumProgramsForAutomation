package com.jsp.tests;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DeleteCookies extends BaseTestClass{


	//	@Test
	private void deleteAllCookies() {

		ExtentReport.createTestName("verify child Window get text");
		String url = "https://demoqa.com/browser-windows";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().deleteAllCookies();
		System.out.println("Cookies Deleted");
	}



}
