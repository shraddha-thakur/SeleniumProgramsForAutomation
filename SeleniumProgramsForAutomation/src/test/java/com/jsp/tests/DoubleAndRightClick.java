package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DoubleAndRightClick extends BaseTestClass{

	@Test
	public static void verifyDoubleAndRightClick() throws InterruptedException {

		ExtentReport.createTestName("DoubleAndRightClick");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement doubleClickBtn= DriverManager.getDriver().findElement(By.id("doubleClickBtn"));

		WebElement rightClickBtn= DriverManager.getDriver().findElement(By.id("rightClickBtn"));

		Actions act= new Actions( DriverManager.getDriver());

		act.doubleClick(doubleClickBtn).perform();

		System.out.println("Double clicked");

		ExtentManager.getExtentTest().pass("Double clicked");
		//
		//		Thread.sleep(2000);

		DriverManager.getDriver().switchTo().alert().accept();

		Thread.sleep(2000);

		act.contextClick(rightClickBtn).perform();
		System.out.println("Context clicked");

		ExtentManager.getExtentTest().pass("Context clicked");


		Thread.sleep(2000);

	}
}
