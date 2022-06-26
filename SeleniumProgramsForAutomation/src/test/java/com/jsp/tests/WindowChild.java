package com.jsp.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class WindowChild extends BaseTestClass{

	@Test
	public static void verifyChildWindow() {
		ExtentReport.createTestName("verify child Window get text");
		String url = "https://demoqa.com/browser-windows";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("windowButton")).click();
		ExtentManager.getExtentTest().pass("Clicking on button from parent window");


		String mainWindowHandle =  DriverManager.getDriver().getWindowHandle();

		Set<String> allWindowHandles = DriverManager.getDriver().getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			if(!mainWindowHandle.equalsIgnoreCase(childWindow)) {
				DriverManager.getDriver().switchTo().window(childWindow);
				WebElement text = DriverManager.getDriver().findElement(By.id("sampleHeading"));
				System.out.println("Heading of child window is: " + text.getText());
				ExtentManager.getExtentTest().pass("Heading of child window is: " + text.getText());
				//				DriverManager.getDriver().close();
				//				ExtentManager.getExtentTest().pass("Child window closed");

			}
		}
		//		System.out.println(text.getText()); // no such element: Unable to locate element if we dont handle window
	}
}
