package com.jsp.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class BrokenLinksTest2 extends BaseTestClass{


	@Test
	public static void verifyBrokenLinks() throws Exception {

		ExtentReport.createTestName("verifyBrokenLinks");

		String url = "http://www.zlti.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);
		//		Thread.sleep(-5000);// java.lang.IllegalArgumentException: timeout value is negative
		List<WebElement> links = DriverManager.getDriver().findElements(By.tagName("a"));

		System.out.println("Total no. of Links are : " + links.size());
		ExtentManager.getExtentTest().info("Total no. of Links are : " + links.size());

		for (WebElement el : links) {
			String url1=el.getAttribute("href");
			verifyUrl(url1);
		}

	}

	public static void verifyUrl(String linkurl) throws IOException {

		try {
			URL url1 = new URL(linkurl);
			HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();

			if(connection.getResponseCode() == 200) {
				System.out.println(linkurl + " - " + connection.getResponseMessage() + " - " + connection.getResponseCode());
				ExtentManager.getExtentTest().pass(linkurl + " - " + connection.getResponseMessage() + " - " + connection.getResponseCode());

			}
			if(connection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {

				System.out.println(linkurl + " - " + connection.getResponseMessage()+ " - " + connection.getResponseCode());
				ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(linkurl + " - " + connection.getResponseMessage()
				+ " - " + connection.getResponseCode(), ExtentColor.RED));

			}



		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
