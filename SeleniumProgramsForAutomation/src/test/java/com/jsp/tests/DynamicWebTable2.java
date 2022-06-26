package com.jsp.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DynamicWebTable2 extends BaseTestClass {



	//	@Test
	public void dynamicWebTable2() throws Exception {

		ExtentReport.createTestName("verify Dynamic Web Table of MMT date picker ");
		String url = "https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		// Locating departure date calendar

		ExtentManager.getExtentTest().pass("passing the date as \"2020\", \"May\", \"4\"");
		WebElement departCal= DriverManager.getDriver().findElement(By.id("datepicker"));
		DynamicWebTable2.selectDate(departCal, "2020", "May", "4");


	}


	public static void selectDate(WebElement calendar, String year, String monthName, String day) throws InterruptedException
	{
		//Clicking on calendar to open calendar widget
		calendar.click();
		// Select year first
		// Since drop down has been created using SELECT tag, We can use Select class.
		WebElement yearDropDown= DriverManager.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear= new Select(yearDropDown);
		selectYear.selectByVisibleText(year);
		Thread.sleep(2000);
		ExtentManager.getExtentTest().pass("selectYear by passing year");

		// Select Month
		WebElement monthDropDown= DriverManager.getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth= new Select(monthDropDown);
		selectMonth.selectByVisibleText(monthName);
		ExtentManager.getExtentTest().pass("selectMonth  by passing month");

		// Select date
		WebElement date= DriverManager.getDriver().findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a[text()='"+day+"']"));
		date.click();
		Thread.sleep(2000);
		ExtentManager.getExtentTest().pass("selectDate by passing date");


		// Printing selected date
		String selectedDate= calendar.getAttribute("value");
		System.out.println("Selected Date: "+selectedDate);
		ExtentManager.getExtentTest().pass("Selected Date: "+selectedDate);


	}

	// Code to get java month number
	public static int getMonthJavaInt(String monthName) throws Exception
	{
		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}




	@Test
	public void dynamicWebTable3() throws Exception {

		ExtentReport.createTestName("verify Dynamic Web Table of MMT date picker using javascriptexecutor");
		String url = "https://jqueryui.com/resources/demos/datepicker/dropdown-month-year.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		ExtentManager.getExtentTest().pass("passing the date as 10/09/2017 ");
		WebElement departCal= DriverManager.getDriver().findElement(By.id("datepicker"));
		DynamicWebTable2.setDateUsingJavaScriptInCalendar(DriverManager.getDriver(),"10/09/2017",departCal);
		ExtentManager.getExtentTest().pass("Selected date as 10/09/2017");

	}


	public static void setDateUsingJavaScriptInCalendar(WebDriver driver, String value, WebElement calLocator)
	{
		JavascriptExecutor jse= (JavascriptExecutor)DriverManager.getDriver();
		String script= "arguments[0].setAttribute('value','"+value+"');";
		jse.executeScript(script, calLocator);
		ExtentManager.getExtentTest().pass("Java Script Executed " + script);

	}

}


