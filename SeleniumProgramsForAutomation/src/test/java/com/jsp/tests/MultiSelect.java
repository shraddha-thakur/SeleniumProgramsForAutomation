package com.jsp.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.jsp.basepackagesimple.BaseClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class MultiSelect extends BaseTestClass{

	@Test
	public static void multiSelect() throws Exception {
		ExtentReport.createTestName("multiSelect");

		DriverManager.getDriver().get("https://demoqa.com/select-menu");
		DriverManager.getDriver().manage().window().maximize();



		Select se2 = new Select(DriverManager.getDriver().findElement(By.id("cars")));

		//Get the list of all the options
		System.out.println("The dropdown options are -");
		ExtentManager.getExtentTest().pass("The dropdown options are -");

		List<WebElement> options = se2.getOptions();

		for(WebElement option: options)
			ExtentManager.getExtentTest().pass(option.getText());
		//			System.out.println(option.getText());

		//Using isMultiple() method to verify if the element is multi-select, if yes go onto next steps else exit

		if(se2.isMultiple()) {

			//Selecting option as 'Opel'-- ByIndex
			System.out.println("Select option Opel by Index");
			se2.selectByIndex(2);
			ExtentManager.getExtentTest().pass("Selected option Opel by Index");


			//			se2.deselectAll();
			//			Thread.sleep(2000);

			//Selecting the option as 'volvo'-- ByValue
			System.out.println("Select option volvo by Value");

			se2.selectByValue("volvo");
			ExtentManager.getExtentTest().pass("Selected option volvo by Value");

			Thread.sleep(2000);

			//			se2.deselectAll();
			//			Thread.sleep(2000);
			// Selecting the option by text
			System.out.println("Select option Audi by Text");
			se2.selectByVisibleText("Audi");
			ExtentManager.getExtentTest().pass("Selected option Audi by Text");

			//Get the list of selected options
			System.out.println("The selected values in the dropdown options are -");
			ExtentManager.getExtentTest().info("The selected values in the dropdown options are -");

			List<WebElement> selectedOptions = se2.getAllSelectedOptions();

			for(WebElement selectedOption: selectedOptions)
				ExtentManager.getExtentTest().pass(selectedOption.getText());

			//				System.out.println(selectedOption.getText());

			// Deselect the value "Audi" by Index
			System.out.println("DeSelect option Audi by Index");
			se2.deselectByIndex(3);
			ExtentManager.getExtentTest().pass("DeSelected option Audi by Index 3");


			//Deselect the value "Opel" by visible text
			System.out.println("Select option Opel by Text");
			se2.deselectByVisibleText("Opel");
			ExtentManager.getExtentTest().pass("DeSelected option Opel by Text");


			//Validate that both the values are deselected
			System.out.println("The selected values after deselect in the dropdown options are -");
			List<WebElement> selectedOptionsAfterDeselect = se2.getAllSelectedOptions();

			for(WebElement selectedOptionAfterDeselect: selectedOptionsAfterDeselect)
				ExtentManager.getExtentTest().pass(selectedOptionAfterDeselect.getText());
			//System.out.println(selectedOptionAfterDeselect.getText());

			//Step#8- Deselect all values
			se2.deselectAll();
			ExtentManager.getExtentTest().pass("DeSelected All");


		}

	}

}
