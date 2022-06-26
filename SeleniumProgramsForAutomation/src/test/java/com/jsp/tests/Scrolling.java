package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class Scrolling extends BaseTestClass {

	@Test
	public static void verifyScrollUpDown() throws InterruptedException {


		ExtentReport.createTestName("verifyScrollUpDown");
		String url = "https://www.facebook.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();

		//		Scroll down the page
		js.executeScript("window.scrollBy(100,300)");
		ExtentManager.getExtentTest().pass("Scroll by: window.scrollBy(100,300)");

		DriverManager.getDriver().navigate().refresh();
		Thread.sleep(2000);

		//		Scroll  bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		ExtentManager.getExtentTest().pass("Scroll by: window.scrollTo(0, document.body.scrollHeight");

		DriverManager.getDriver().navigate().refresh();
		Thread.sleep(3000);

		//		Scroll  to particular element of the page
		WebElement element = DriverManager.getDriver().findElement(By.linkText("Log In"));

		js.executeScript("arguments[0].scrollIntoView", element);
		ExtentManager.getExtentTest().pass("Scroll by: arguments[0].scrollIntoView\", element");

		element.click();

		Thread.sleep(2000);

	}





}