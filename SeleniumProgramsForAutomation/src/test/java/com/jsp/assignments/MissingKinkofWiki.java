package com.jsp.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;
import com.jsp.tests.BaseTestClass;

public class MissingKinkofWiki extends BaseTestClass{


	@Test
	void missingLink(){
		ExtentReport.createTestName("missingLink");
		String url = "https://www.wikipedia.org/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



		List<WebElement> links = DriverManager.getDriver().findElements(By.tagName("a"));

		System.out.println("Total values of links are : " + links.size());
		ExtentManager.getExtentTest().info("Total values of links are : " + links.size());


		for (WebElement value : links) {
			System.out.println("Url-- " + value.getText());
			ExtentManager.getExtentTest().info("Url-- " + value.getText());

		}
	}

}
