package com.jsp.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class AlertDemo extends BaseTestClass{


	//	@Test
	public static void verifySimpleAlert() throws InterruptedException {

		ExtentReport.createTestName("verify Simple Alert");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);

		DriverManager.getDriver().findElement(By.id("simpleAlert")).click();
		ExtentManager.getExtentTest().pass("Clicked on Simple alert button");

		Alert alert =  DriverManager.getDriver().switchTo().alert();

		String simplealerttext  = alert.getText();
		System.err.println(simplealerttext);
		ExtentManager.getExtentTest().pass("Simple Alert text is : " +simplealerttext );

		alert.accept();
		ExtentManager.getExtentTest().pass("Simple Alert OK button clicked by accept");
		Thread.sleep(2000);



	}


	//	@Test
	public static void verifyConfirmationAlert() throws InterruptedException { // failed

		ExtentReport.createTestName("verify Confirmation Alert");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);
		ExtentManager.getExtentTest().pass("Clicked on Confirmation Alert button");

		DriverManager.getDriver().findElement(By.id("confirmationAlert")).click();
		Thread.sleep(2000);
		if(isAlertPresent(DriverManager.getDriver())) { // failed
			System.out.println("Alert is present.");
			ExtentManager.getExtentTest().pass("Alert is present.");

		}else {
			System.out.println("Alert is not present.");
			ExtentManager.getExtentTest().pass("Alert is not present.");

		}
	}
	public static boolean isAlertPresent(WebDriver webDriver) {

		try {
			Alert alert = webDriver.switchTo().alert();
			String alertText = alert.getText();
			//			alert.accept();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
		}
		return false;
	}


	@Test
	public static void verifyPromptAlert() throws InterruptedException { // failed

		ExtentReport.createTestName("verify Prompt Alert");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);

		DriverManager.getDriver().findElement(By.id("promptAlert")).click();
		ExtentManager.getExtentTest().pass("Clicked on Prompt Alert button");

		//		Alert alert = DriverManager.getDriver().switchTo().alert();
		//		String alertText = alert.getText();
		//
		//		alert.sendKeys("yes");
		//		Thread.sleep(2000);
		//		alert.accept();



		Alert alert = DriverManager.getDriver().switchTo().alert();
		Thread.sleep(2000);
		String alertText = alert.getText();
		System.out.println("Alert Text is: " + alertText);
		alert.sendKeys("Yes"); // failed-  did not send keys to alert
		Thread.sleep(2000);
		alert.accept();

	}






}

