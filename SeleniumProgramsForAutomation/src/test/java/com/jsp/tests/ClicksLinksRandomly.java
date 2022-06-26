package com.jsp.tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ClicksLinksRandomly extends BaseTestClass {

	@Test
	public static void clicksLinksRandomly() throws InterruptedException{
		ExtentReport.createTestName("verify clicks Links Randomly ");
		String url = "https://www.amazon.in/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement Boxarea = DriverManager.getDriver().findElement(By.xpath("//*[@id='nav-xshop']"));
		List<WebElement> l1 = Boxarea.findElements(By.tagName("a"));
		System.out.println("The Number Of Anchor Text " + l1.size());
		ExtentManager.getExtentTest().info("The Number Of Anchor Text " + l1.size());

		for (int i=0; i<l1.size(); i++)
		{
			Random r = new Random();
			l1.get(r.nextInt(5)).click();
			String ptitle=DriverManager.getDriver().getTitle();
			System.out.println(i + " The Page Title is : " + ptitle);
			ExtentManager.getExtentTest().pass("The Page Title is : " + ptitle);

			Thread.sleep(3000);
			DriverManager.getDriver().get("https://www.amazon.in/");
			Thread.sleep(3000);
			Boxarea = DriverManager.getDriver().findElement(By.xpath("//*[@id='nav-xshop']"));
			l1 = Boxarea.findElements(By.tagName("a"));
		}
	}
}

