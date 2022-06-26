package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;


public class HighlightElementJS extends BaseTestClass {


	@Test
	public static void highlightElementJS() throws InterruptedException {

		ExtentReport.createTestName("verify Highlight Element by JS");
		String url = "https://www.facebook.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);


		WebElement email  = DriverManager.getDriver().findElement(By.id("email"));
		WebElement pass  = 	DriverManager.getDriver().findElement(By.id("pass"));

		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2x solid red;');", email);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 5x solid white;');", pass);
		Thread.sleep(2000);


		System.out.println("Highlight Element implemented in the test");
		ExtentManager.getExtentTest().pass("Highlight Element implemented in the test");


	}




}
