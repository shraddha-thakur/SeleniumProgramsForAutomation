package com.jsp.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.basepackage.xBaseTestClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

/**
 * Locate Element Using ID Locator
Locate Element Using Name Locator
Locate Element Using ClassName Locator
Locate Element Using Tag Name Locator
Locate Element Using LinkText Locator
Locate Element Using Partial LinkText Locator
Locate Element Using XPath Locator
Locate Element Using CSS Selector

 */


public class Locators extends BaseTestClass{

	@Test
	public void locators() {

		ExtentReport.createTestName("locators");
		String url = "http://demowebshop.tricentis.com/register";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);

		/*
		 * ExtentManager.getExtentTest().info("Page Title is  " + pagetitle);
		 * ExtentManager.getExtentTest().pass(
		 * MarkupHelper.createLabel("Test Executed",ExtentColor.GREEN));
		 * ExtentManager.getExtentTest().fail(MarkupHelper.createLabel("Test Failed",
		 * ExtentColor.RED));
		 * 
		 */




		DriverManager.getDriver().findElement(By.id("gender-female")).click();
		DriverManager.getDriver().findElement(By.name("FirstName")).sendKeys("John");
		DriverManager.getDriver().findElement(By.id("LastName")).sendKeys("Jass");
		DriverManager.getDriver().findElement(By.id("Email")).sendKeys("test123@gmail.com");

		DriverManager.getDriver().findElement(By.cssSelector("input#Password")).sendKeys("12345");

		DriverManager.getDriver().findElement(By.linkText("Log in")).click();

		DriverManager.getDriver().findElement(By.className("email")).sendKeys("test21123@gmail.com");

		DriverManager.getDriver().findElement(By.partialLinkText("Forgot")).click();

		DriverManager.getDriver().findElement(By.xpath("//input[@id='Email']")).sendKeys("test@teasr.com");

		DriverManager.getDriver().navigate().back();

		DriverManager.getDriver().findElement(By.cssSelector("#small-searchterms")).sendKeys("test css selector");

		System.out.println("Test executed");

		ExtentManager.getExtentTest().pass(MarkupHelper.createLabel("All Locators are working.",ExtentColor.GREEN));


	}




}
