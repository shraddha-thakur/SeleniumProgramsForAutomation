package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class DragAndDropDemo extends BaseTestClass{


	@Test
	public static void verifyDragAndDropDemo() throws InterruptedException {

		ExtentReport.createTestName("DragAndDropDemo");
		String url = "https://demoqa.com/droppable/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement dragable = DriverManager.getDriver().findElement(By.id("draggable"));
		WebElement dropable = DriverManager.getDriver().findElement(By.id("droppable"));

		Actions act = new Actions(DriverManager.getDriver());

		//		act.dragAndDrop(dragable, dropable).perform(); // 1
		act.dragAndDropBy(dragable, 150, 20).perform(); // 2
		Thread.sleep(2000);

		//		act.clickAndHold(dragable).moveToElement(dropable).release().build().perform(); // 3
		ExtentManager.getExtentTest().pass("Drag and Drop performed");

		WebElement dropmessage = DriverManager.getDriver().findElement(By.xpath("//div/p[(text()='Dropped!')]"));

		if(dropmessage.isDisplayed()) {
			System.out.println("Success");
			System.out.println("Message is: " + dropmessage.getText());
		}else {
			System.out.println("Failed");
		}
		Thread.sleep(2000);


	}
}
