package com.jsp.tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DropDownDemo extends BaseTestClass {

	@Test
	public static void dropDownDemo() throws InterruptedException {


		ExtentReport.createTestName("dropDownDemo");
		String url = "https://www.automationtestinginsider.com/2019/08/student-registration-form.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement bDay = DriverManager.getDriver().findElement(By.id("Birthday_Day"));

		WebElement bMonth = DriverManager.getDriver().findElement(By.id("Birthday_Month"));

		WebElement bYear = DriverManager.getDriver().findElement(By.id("Birthday_Year"));



		Select selectDay = new Select(bDay);

		Select selectMonth = new Select(bMonth);

		Select selectYear = new Select(bYear);



		selectDay.selectByIndex(4); // 4

		Thread.sleep(1000);

		selectMonth.selectByValue("February");

		selectMonth.selectByValue("January");

		Thread.sleep(1000);

		selectYear.selectByVisibleText("1990");

		Thread.sleep(1000);



		WebElement firstSelectedItem = selectMonth.getFirstSelectedOption();

		System.out.println("getFirstSelectedOption : "+firstSelectedItem.getText());
		ExtentManager.getExtentTest().pass("getFirstSelectedOption : "+firstSelectedItem.getText());



		List<WebElement> monthList = selectMonth.getOptions();



		System.out.println("total Months: " + monthList.size()); // 13
		ExtentManager.getExtentTest().pass("total Months: " + monthList.size());



		for (WebElement ele : monthList) {

			System.out.println(ele.getText());
			ExtentManager.getExtentTest().pass(ele.getText());

		}


	}

}



