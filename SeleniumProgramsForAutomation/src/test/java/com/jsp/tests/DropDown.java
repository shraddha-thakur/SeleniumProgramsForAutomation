package com.jsp.tests;


import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DropDown extends BaseTestClass {

	//	@Test
	public static void dropDownTest() throws InterruptedException {


		ExtentReport.createTestName("dropDownTest");
		String url = "https://demoqa.com/select-menu";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();


		// 7506184479 = manorekha

		//Step#3- Selecting the dropdown element by locating its id
		WebElement eledropdown = DriverManager.getDriver().findElement(By.xpath("//select[@id='oldSelectMenu']"));
		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView", eledropdown);

		Select se = new Select(eledropdown);

		//Step#4- Printing the options of the dropdown
		//Get list of web elements

		List<WebElement> lst = se.getOptions();
		//Looping through the options and printing dropdown options
		System.out.println("Total dropdown options are:" + lst.size());
		ExtentManager.getExtentTest().info("Total dropdown options are:" + lst.size());

		System.out.println("The dropdown options are:");
		ExtentManager.getExtentTest().info("The dropdown options are: ");

		for(WebElement options : lst) {
			System.out.println(options.getText());
			ExtentManager.getExtentTest().info(options.getText());

		}

		//Step#5- Selecting the option as 'Purple'-- selectByIndex
		System.out.println("Select the Option by Index 4");
		ExtentManager.getExtentTest().info("Select the Option by Index 4");

		se.selectByIndex(4);
		System.out.println("Select value is: " + se.getFirstSelectedOption().getText());
		ExtentManager.getExtentTest().pass("Select value is: " + se.getFirstSelectedOption().getText());

		Thread.sleep(2000);

		//Step#6- Selecting the option as 'Indigo'-- selectByVisibleText
		System.out.println("Select the Option by Text Indigo");
		ExtentManager.getExtentTest().info("Select the Option by value 4");

		se.selectByVisibleText("Indigo");
		System.out.println("Select value is: " + se.getFirstSelectedOption().getText());
		ExtentManager.getExtentTest().pass("Select value is: " + se.getFirstSelectedOption().getText());

		Thread.sleep(2000);

		//Step#7- Selecting an option by its value
		System.out.println("Select the Option by value 4");
		ExtentManager.getExtentTest().info("Select the Option by value 4");

		se.selectByValue("4");
		System.out.println("Select value is: " + se.getFirstSelectedOption().getText());
		ExtentManager.getExtentTest().pass("Select value is: " + se.getFirstSelectedOption().getText());

		Thread.sleep(2000);


		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed", ExtentColor.GREEN));


	}

	@Test
	void dropdownWiki(){
		ExtentReport.createTestName("dropdownWiki");
		String url = "https://www.wikipedia.org/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement dropdown = DriverManager.getDriver().findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);

		select.selectByValue("hi");

		List<WebElement> values = dropdown.findElements(By.tagName("option"));

		System.out.println("Total values of dropdown are : " + values.size());
		ExtentManager.getExtentTest().info("Total values of dropdown are : " + values.size());

		System.out.println(values.get(0).getText());
		ExtentManager.getExtentTest().info(values.get(0).getText());

		System.out.println(values.get(0).getAttribute("lang"));
		ExtentManager.getExtentTest().info(values.get(0).getAttribute("lang"));

		for (WebElement value : values) {
			System.out.println(value.getText());
			ExtentManager.getExtentTest().info(value.getText());

		}


		// print links

		List<WebElement> links = DriverManager.getDriver().findElements(By.tagName("a"));

		System.out.println("Total values of links are : " + links.size());
		ExtentManager.getExtentTest().info("Total values of links are : " + links.size());


		for (WebElement value : links) {
			System.out.println("Url-- " + value.getText());
			ExtentManager.getExtentTest().info("Url-- " + value.getText());

		}


	}


	//	@Test
	void dropdownEcho(){
		ExtentReport.createTestName("dropdownWiki");
		String url = "https://echoecho.com/htmlforms11.htm";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//		System.out.println(isElementPresent("//td[5]/select"));

		System.out.println(isElementPresent(By.name("dropdownmenu")));
		//		System.out.println(DriverManager.getDriver().findElement(By.xpath("//td[5]/select")).isDisplayed());
		ExtentManager.getExtentTest().info("Given element present ? "+ isElementPresent(By.name("dropdownmenu")));

	}

	boolean isElementPresent(By by) {
		/*
		 * try{ DriverManager.getDriver().findElement(By.xpath(xpath)); return true;
		 * 
		 * }catch (Throwable t) { return false; }
		 */

		int size = DriverManager.getDriver().findElements(by).size();
		if(size== 0) {
			return false;
		}else {
			return true;
		}

	}
}



