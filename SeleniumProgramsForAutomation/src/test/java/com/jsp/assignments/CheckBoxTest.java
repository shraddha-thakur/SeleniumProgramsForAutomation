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

public class CheckBoxTest extends BaseTestClass{

	/*
	 * 2. Check the all checkboxes - done
	 * 3. Get the name of checkboxes
	 * 4. randomly select 2 checkboxes
	 */
	@Test
	public static void checkBoxTest() throws InterruptedException {


		ExtentReport.createTestName("Check the all checkboxes");
		String url = "http://tizag.com/htmlT/htmlcheckboxes.php";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();
		//		DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//		WebElement block = DriverManager.getDriver().findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes = DriverManager.getDriver().findElements(By.name("sports"));

		System.out.println(checkboxes.size());
		ExtentManager.getExtentTest().info("Checkboxes : " + checkboxes.size());

		for(WebElement checkbox : checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
				checkbox.click();
			}else {
				checkbox.click();
			}
			System.out.println(checkbox.getAttribute("value").toString());
			ExtentManager.getExtentTest().info(checkbox.getAttribute("value").toString());

		}
		Thread.sleep(3000);

	}


	//	@Test
	public static void checkBoxRandom2() throws InterruptedException {


		ExtentReport.createTestName("Check the Random 2 checkboxes");
		String url = "http://tizag.com/htmlT/htmlcheckboxes.php";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		List<WebElement> checkboxes = DriverManager.getDriver().findElements(By.name("sports"));


		for(WebElement checkbox : checkboxes) {
			checkbox.click();
		}

	}

}


