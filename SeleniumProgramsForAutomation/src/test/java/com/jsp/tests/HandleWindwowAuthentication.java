package com.jsp.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class HandleWindwowAuthentication extends BaseTestClass{


	@Test
	public static void verifyHandleWindwowAuthentication() throws InterruptedException {

		ExtentReport.createTestName("verify Handle Windwow Authentication");
		String url = "http://admin:admin@the-internet.herokuapp.com/basic_auth"; // passed creds in URL
		DriverManager.getDriver().get(url);
		Thread.sleep(2000);
		ExtentManager.getExtentTest().pass("Passed authentication credentials in URL " + url);

		String succuessText = DriverManager.getDriver().findElement(By.xpath("//*[@id='content']/div/p")).getText();
		String expsuccuessText = "Congratulations! You must have the proper credentials.";
		assertEquals(succuessText, expsuccuessText );

		ExtentManager.getExtentTest().pass(MarkupHelper.createCodeBlock(succuessText, expsuccuessText));

	}

	/*
	 * Download AutoIT and AutoIT editor
		https://www.autoitscript.com/site/autoit/downloads/
		Handle Windows Authentication using AutoIT tool.
	 */

	//	@Test
	public static void verifyHandleWindwowAuthentication1() throws InterruptedException, IOException {

		ExtentReport.createTestName("verify Handle Windwow Authentication");
		String url = "http://the-internet.herokuapp.com/basic_auth"; // passed creds in URL
		DriverManager.getDriver().get(url);
		Thread.sleep(2000);
		ExtentManager.getExtentTest().pass("Passed authentication credentials in URL " + url);

		Thread.sleep(2000);

		Runtime.getRuntime().exec("C:\\Users\\Hitendra\\Desktop\\Authen.exe");
		Thread.sleep(2000);

		String succuessText = DriverManager.getDriver().findElement(By.xpath("//*[@id='content']/div/p")).getText();
		String expsuccuessText = "Congratulations! You must have the proper credentials.";
		assertEquals(succuessText, expsuccuessText );

		ExtentManager.getExtentTest().pass(MarkupHelper.createCodeBlock(succuessText, expsuccuessText));

	}


}
