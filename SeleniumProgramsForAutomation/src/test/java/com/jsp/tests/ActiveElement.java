package com.jsp.tests;

import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ActiveElement extends BaseTestClass{
	@Test
	public static void verifyActiveElement1() throws InterruptedException {

		ExtentReport.createTestName("verify Active Element Google");
		String url = "https://www.google.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);

		DriverManager.getDriver().switchTo().activeElement().sendKeys("automation testing type on focus");
		System.out.println(DriverManager.getDriver().switchTo().activeElement().isEnabled());
		Thread.sleep(2000);
		ExtentManager.getExtentTest().pass("Active Element is  " + DriverManager.getDriver().switchTo().activeElement().getAttribute("name"));

	}
	@Test
	public static void verifyActiveElement2() throws InterruptedException {

		ExtentReport.createTestName("verify Active Element demowebshop");
		String url = "http://demowebshop.tricentis.com/login";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);

		DriverManager.getDriver().switchTo().activeElement().sendKeys("automation testing type on focus");
		System.out.println(DriverManager.getDriver().switchTo().activeElement().isEnabled());
		Thread.sleep(2000);
		ExtentManager.getExtentTest().pass("Active Element is  " + DriverManager.getDriver().switchTo().activeElement().getTagName());

	}
}
