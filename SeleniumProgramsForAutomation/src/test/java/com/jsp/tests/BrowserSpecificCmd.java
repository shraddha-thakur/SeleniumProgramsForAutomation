package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jsp.basepackagesimple.BaseClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class BrowserSpecificCmd extends BaseTestClass {

	@Test
	public static void browserSpecificCommands() {

		ExtentReport.createTestName("browserSpecificCommands");
		DriverManager.getDriver().get("http://demowebshop.tricentis.com/");

		String curURL = DriverManager.getDriver().getCurrentUrl();
		System.out.println(curURL);
		ExtentManager.getExtentTest().pass("URL Opened" + curURL);

		String title = DriverManager.getDriver().getTitle();
		System.out.println(title);
		ExtentManager.getExtentTest().pass("Page Title" + title);

		boolean result = DriverManager.getDriver().getPageSource().contains("searchtermautocomplete");
		Assert.assertTrue(result, "Text found in page source");
		ExtentManager.getExtentTest().pass("getPageSource Assertion" + result);
		String newURL = "https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html";
		DriverManager.getDriver().navigate().to(newURL);
		ExtentManager.getExtentTest().pass("Page Navigated to " + newURL);

		DriverManager.getDriver().switchTo().frame("packageFrame");
		ExtentManager.getExtentTest().pass("Switching to Frame");

		DriverManager.getDriver().findElement(By.linkText("Actions")).click();
		ExtentManager.getExtentTest().pass("Actions Link Clicked ");

		DriverManager.getDriver().switchTo().defaultContent();
		ExtentManager.getExtentTest().pass("Switched to Default Frame");

		int width = DriverManager.getDriver().manage().window().getSize().getWidth();
		int height = DriverManager.getDriver().manage().window().getSize().getHeight();

		Dimension size = DriverManager.getDriver().manage().window().getSize();
		int w1 = size.getWidth();
		int h1 = size.getHeight();

		System.out.println(w1 + " " + h1);
		ExtentManager.getExtentTest().info(w1 + " " + h1);

		DriverManager.getDriver().manage().window().setSize(new Dimension(800, 600));
		ExtentManager.getExtentTest().pass("Window Size set to new Dimension");


		DriverManager.getDriver().manage().window().getPosition().getX();
		DriverManager.getDriver().manage().window().getPosition().getY();

		Point position = DriverManager.getDriver().manage().window().getPosition();

		System.out.println(position.getX());
		System.out.println(position.getY());

		ExtentManager.getExtentTest().pass("Window Position is " + position.getX() + " & " + position.getY());


		DriverManager.getDriver().manage().window().maximize();
		System.out.println("window maximized");
		ExtentManager.getExtentTest().pass("window maximized");



		//		DriverManager.getDriver().manage().window().minimize(); // webdrivermanager

		DriverManager.getDriver().manage().window().fullscreen();
		System.out.println("window fullscreen");
		ExtentManager.getExtentTest().pass("window fullscreen");

		DriverManager.getDriver().manage().window().setPosition(new Point(200, 200));

		//		dr.manage().deleteAllCookies();
		//
		//		Deleting the specific cookie with cookie name "--abcd"
		//		dr.manage().deleteCookieNamed("__abcd");

		//		dr.close();
		//		dr.quit();
		//

	}

}
