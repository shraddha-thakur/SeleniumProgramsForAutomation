package com.jsp.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.basepackage.xBaseTestClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ImportLinks extends BaseTestClass {


	@Test
	public static void importLinks() {

		ExtentReport.createTestName("importLinks");
		String url = "http://demowebshop.tricentis.com/register";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);

		List<WebElement> links = DriverManager.getDriver().findElements(By.tagName("a"));
		System.out.println(links.size());
		ExtentManager.getExtentTest().info("Total Links are : " + links.size());

		HashMap<String, String> linkname = new HashMap<>();
		for(int i=1; i< links.size(); i++) {
			String t1 = links.get(i).getText();
			String t2 = links.get(i).getAttribute("href");
			System.out.println(t1 + "--------->"+ t2);
			ExtentManager.getExtentTest().info(t1 + "--------->"+ t2);
			linkname.put(t1, t2);
		}
		//		ExtentManager.getExtentTest().pass(MarkupHelper.createOrderedList(Arrays.asList(linkname)).getMarkup());


		//		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed", ExtentColor.GREEN).getMarkup());
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
