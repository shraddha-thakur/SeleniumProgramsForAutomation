package com.jsp.tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DropDownBootStrap extends BaseTestClass {

	@Test
	public static void dropDownDemo() throws InterruptedException {


		ExtentReport.createTestName("DropDownBootStrap");
		String url = "https://www.automationtestinginsider.com/2019/12/bootstrap-dropdown-example_12.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.xpath("//button[@id='bootstrapmenu']")).click();

		List <WebElement> options=DriverManager.getDriver().findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));

		for(WebElement ele:options) {

			String value=ele.getText();

			System.out.println(value);

			if(value.equalsIgnoreCase("contact us")) {

				ele.click();
				break;
			}
		}
	}
}


