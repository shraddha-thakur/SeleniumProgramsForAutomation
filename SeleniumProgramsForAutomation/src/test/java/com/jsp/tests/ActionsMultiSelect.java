package com.jsp.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ActionsMultiSelect extends BaseTestClass{


	@Test
	public static void verifymultiSelectActions() throws InterruptedException {

		ExtentReport.createTestName("DropDownBootStrap");
		String url = "https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		Actions act = new Actions(DriverManager.getDriver());


		List<WebElement> list =DriverManager.getDriver().findElements(By.xpath("//select[@class='form-control pickListSelect pickData']/option"));

		Action actions=act.keyDown(Keys.CONTROL)
				.click(list.get(0))

				.click(list.get(2))

				.click(list.get(4))

				.click(list.get(5))

				.keyUp(Keys.CONTROL)

				.build();


		actions.perform();

		ExtentManager.getExtentTest().pass("Action performed");

		Thread.sleep(2000);

		DriverManager.getDriver().findElement(By.xpath("//div[@class='col-sm-2 pickListButtons']/button[1]"))

		.click();

		Thread.sleep(2000);


	}


}
