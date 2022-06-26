package com.jsp.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DynamicWebTable extends BaseTestClass {

	@Test
	public void dynamicWebTable1() {
		ExtentReport.createTestName("verify Dynamic Web Table of Redbus date picker ");
		String url = "https://www.redbus.in/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.xpath(".//*[@id='search']/div/div[3]/span")).click();

		List<WebElement> li = DriverManager.getDriver().findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[6]/td[1]"));

		int lisize = li.size();

		for(int i =0; i<lisize; i++) {
			String date = li.get(i).getText();
			System.out.println(date);
			if(date.equals("21"))
			{
				li.get(i).click();
			}
		}

		ExtentManager.getExtentTest().pass("Dynamic Web Table working");

	}






}


