package com.jsp.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DropDownListSortedOrNot extends BaseTestClass {


	@Test
	public static void dropDownListSortedOrNot() throws InterruptedException {

		ExtentReport.createTestName("DropDownListSortedOrNot");
		String url = "https://demoqa.com/select-menu";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);



		WebElement eledropdown = DriverManager.getDriver().findElement(By.xpath("//select[@id='oldSelectMenu']"));
		//		eledropdown.click();
		Thread.sleep(3000);
		List<WebElement> dropdownvalues = eledropdown.findElements(By.tagName("option"));

		ArrayList<String> listValues = new ArrayList<String>();

		for(WebElement value : dropdownvalues) {
			System.out.println("values are : " + value.getText());
			ExtentManager.getExtentTest().info("values are : " + value.getText());
			listValues.add(value.getText());
		}

		boolean sortedOrNot = sortedOrNot(listValues);
		assertEquals(sortedOrNot, true);

		ExtentManager.getExtentTest().pass("DropDown sorted or not : "+ sortedOrNot);

		//		System.out.println("Test Pass");
		//		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed", ExtentColor.GREEN));
		//		ExtentManager.getExtentTest().fail( MarkupHelper.createLabel("Test Failed", ExtentColor.RED));

		//		ExtentManager.getExtentTest().pass( MarkupHelper.createLabel("Test Executed", ExtentColor.GREEN));

	}

	private static boolean sortedOrNot(ArrayList<String> dropdownvalues) {
		System.out.println("number of values: " + dropdownvalues.size());
		for(int i =0; i < dropdownvalues.size(); i++) {

			int temp = dropdownvalues.get(i).compareTo(dropdownvalues.get(i+1));
			System.out.println(temp);

			if(temp > 1) {
				System.out.println("i value " + i);
				return false;
			}
		}
		return true;
	}



}
