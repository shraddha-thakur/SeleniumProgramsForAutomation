package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ToolTip extends BaseTestClass {


	@Test(priority = 1, invocationCount = 3)
	public static void ToolTipbyAction() {

		ExtentReport.createTestName("ToolTipbyAction", "Shraddha Thakur");
		String url = "https://demo.guru99.com/test/tooltip.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);
		String pagetitle = DriverManager.getDriver().getTitle();
		ExtentManager.getExtentTest().info("Page Title is  " + pagetitle);
		System.out.println("URL opened");

		String expectedTooltip = "What's new in 3.2+++++";
		WebElement tp1 = DriverManager.getDriver().findElement(By.xpath("//*[@id='download_now']"));

		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(tp1).build().perform();

		WebElement tp1text = DriverManager.getDriver().findElement(By.xpath("//*[@class='box']/div/a"));
		String tooltip = tp1text.getText();
		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock("Expected Tooltip: " + expectedTooltip, "Actual Tooltip: " + tooltip));


		Assert.assertEquals(tooltip, expectedTooltip);

		//		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed", ExtentColor.GREEN));

	}

	@Test(priority = 2, dependsOnMethods = "ToolTipbyAction", alwaysRun = true)
	public static void ToolTipbyAtributeTitle() {

		ExtentReport.createTestName("ToolTipbyAtributeTitle", "Shraddha Thakur");

		String url = "https://jqueryui.com/tooltip/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);
		String pagetitle = DriverManager.getDriver().getTitle();
		ExtentManager.getExtentTest().info("Page Title is  " + pagetitle);
		System.out.println("URL opened");

		DriverManager.getDriver().switchTo().frame(DriverManager.getDriver().findElement(By.className("demo-frame")));
		ExtentManager.getExtentTest().info("Switching to Frame");

		String expectedTooltip = "We ask for your age only for statistical purposes.";

		WebElement tp2 = DriverManager.getDriver().findElement(By.xpath("//*[@id='age']"));
		//*[@id="age"]

		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView", tp2);

		String tp2text = tp2.getAttribute("title");

		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock("Expected Tooltip: " + expectedTooltip, "Actual Tooltip: " + tp2text));

		Assert.assertEquals(tp2text, expectedTooltip);


		//		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed", ExtentColor.GREEN));

	}


}
