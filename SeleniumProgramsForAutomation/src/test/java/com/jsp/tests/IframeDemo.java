package com.jsp.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class IframeDemo extends BaseTestClass{

	@Test
	public static void verifyIframeDemo() throws InterruptedException {


		ExtentReport.createTestName("verifyIframeDemo");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		//First finding the elements using any of locator strategy
		List<WebElement> iframList = DriverManager.getDriver().findElements(By.tagName("iframe"));
		int totalFrames = iframList.size();
		System.out.println("No of Frames:" + totalFrames);
		ExtentManager.getExtentTest().pass("No of Frames: " + totalFrames);

		WebElement ele=DriverManager.getDriver().findElement(By.name("iframe_b"));

		System.out.println("Frame Names are:");
		ExtentManager.getExtentTest().pass("Frame Names are: ");

		for (WebElement iframe : iframList) {

			System.out.println(iframe.getAttribute("name"));
			ExtentManager.getExtentTest().pass(iframe.getAttribute("name"));

			if (iframe.getAttribute("name").equals("iframe_b")) {
				//switch to frame by element
				DriverManager.getDriver().switchTo().frame(ele);
				//Perform all the required tasks
				DriverManager.getDriver().findElement(By.id("searchInput")).sendKeys("iframe Testing");
				Thread.sleep(2000);
				//Switching back to the main window
				DriverManager.getDriver().switchTo().defaultContent();
			}
		}
		boolean btnDisplayed = DriverManager.getDriver().findElement(By.id("simpleAlert")).isDisplayed();
		System.out.println(btnDisplayed);

	}

}
