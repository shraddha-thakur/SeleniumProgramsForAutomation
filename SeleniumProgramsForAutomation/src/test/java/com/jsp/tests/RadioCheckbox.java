package com.jsp.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class RadioCheckbox extends BaseTestClass {


	@Test
	public static void verifyRadiobtn(){
		ExtentReport.createTestName("Verify Radiobtn");

		String url = "https://www.automationtestinginsider.com/2019/08/student-registration-form.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement radiobtn = DriverManager.getDriver().findElement(By.name("Gender"));
		ExtentManager.getExtentTest().pass("Female Radio button is clicked");

		System.out.println("Female Radio button is enabled: "+ radiobtn.isEnabled());
		ExtentManager.getExtentTest().pass("Female Radio button is enabled: "+ radiobtn.isEnabled());

		radiobtn.click();
		System.out.println("Female Radio button is selected: "+radiobtn.isSelected());
		ExtentManager.getExtentTest().pass("Female Radio button is selected: "+radiobtn.isSelected());


	}




	@Test
	public static void verifyCheckbox() throws InterruptedException{
		ExtentReport.createTestName("Verify Checkbox");

		String url = "https://www.automationtestinginsider.com/2019/08/student-registration-form.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);
		WebElement chkDrawing = DriverManager.getDriver().findElement(By.xpath("//input[@type='checkbox' and @value='Drawing']"));
		chkDrawing.click();

		ExtentManager.getExtentTest().pass("Checkbox is clicked");
		System.out.println("Checkbox is selected: "+chkDrawing.isSelected());
		ExtentManager.getExtentTest().pass("Checkbox is selected: "+chkDrawing.isSelected());

		List<WebElement> listchk = DriverManager.getDriver().findElements(By.xpath("//input[@type='checkbox' and @name='Hobby']"));

		for (WebElement ele : listchk) {
			String hobbies = ele.getAttribute("value");
			System.out.println(hobbies);
			ExtentManager.getExtentTest().pass(hobbies);
			if(hobbies.equalsIgnoreCase("dancing")) {
				ele.click();
				Thread.sleep(2000);
				break;
			}

		}

	}
}
