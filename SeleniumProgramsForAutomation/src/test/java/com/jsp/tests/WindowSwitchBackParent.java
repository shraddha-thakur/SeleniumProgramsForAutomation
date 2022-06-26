package com.jsp.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class WindowSwitchBackParent extends BaseTestClass{

	@Test
	public static void verifySwitchBackParentWindow () throws InterruptedException {
		ExtentReport.createTestName("verify Switched Back to Parent Window");
		String url = "https://demoqa.com/browser-windows";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("windowButton")).click();
		ExtentManager.getExtentTest().pass("New Window button clicked");

		DriverManager.getDriver().findElement(By.id("messageWindowButton")).click();
		ExtentManager.getExtentTest().pass("New Window Message button clicked");



		String mainWindow =  DriverManager.getDriver().getWindowHandle();
		System.out.println("Main window handle is " + mainWindow);
		ExtentManager.getExtentTest().pass("Main window handle is " + mainWindow);

		Set<String> allWindowHandles = DriverManager.getDriver().getWindowHandles();
		System.out.println("Child window handle is " + allWindowHandles);
		ExtentManager.getExtentTest().pass("Child window handle is " + allWindowHandles);

		Iterator<String> iterator = allWindowHandles.iterator();

		while(iterator.hasNext()) {
			String childWindow = iterator.next();

			if(!mainWindow.equalsIgnoreCase(childWindow)) {

				DriverManager.getDriver().switchTo().window(childWindow);

				DriverManager.getDriver().close();
				System.out.println("Child window closed");
				ExtentManager.getExtentTest().pass("Child window closed");
				Thread.sleep(3000);
			}
		}

		DriverManager.getDriver().switchTo().window(mainWindow);
		ExtentManager.getExtentTest().pass("Switched Back to Parent Window");
		WebElement mainText = DriverManager.getDriver().findElement(By.className("main-header"));
		System.out.println("Heading of main window is: " + mainText.getText());
		ExtentManager.getExtentTest().pass("Heading of main window is: " + mainText.getText());

		Thread.sleep(2000);



		//		System.out.println(text.getText()); // no such element: Unable to locate element if we dont handle window
	}
}
