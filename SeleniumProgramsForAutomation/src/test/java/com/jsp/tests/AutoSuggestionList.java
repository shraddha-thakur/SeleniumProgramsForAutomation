package com.jsp.tests;
/**
 * 26-02-222
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class AutoSuggestionList extends BaseTestClass{

	//	@Test
	public static void autoSuggestionList() throws InterruptedException {

		ExtentReport.createTestName("verify Auto Suggestion List");
		String url = "https://www.flipkart.com/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);

		DriverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();

		//		/html/body/div[2]/div/div/div/div/div[1]

		//				/html/body/div[2]/div/div/button

		String searchstr = "mobile";

		DriverManager.getDriver().findElement(By.name("q")).sendKeys(searchstr);
		ExtentManager.getExtentTest().pass("Searching for " + searchstr );

		Thread.sleep(2000);

		String xp = "//ul//li//a[contains(text(), '" + searchstr + "')]";

		List<WebElement> ls = DriverManager.getDriver().findElements(By.xpath(xp));
		Thread.sleep(4000);
		for(WebElement search : ls) {
			System.out.println(search.getText());
			ExtentManager.getExtentTest().pass(search.getText());
			Thread.sleep(2000);
		}
	}

	@Test
	public static void autoSuggestion2() throws InterruptedException {

		ExtentReport.createTestName("verify Auto Suggestion List");
		String url = "https://www.google.com/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium");
		ExtentManager.getExtentTest().pass("send search string");
		Thread.sleep(3000);

		List<WebElement> list = DriverManager.getDriver().findElements(By.xpath("//ul/li[@class='sbct']"));
		ExtentManager.getExtentTest().pass("List created of search text");

		for (WebElement element : list) {
			System.out.println(element.getText());
			ExtentManager.getExtentTest().pass("Search text: " + element.getText());

			String searchText=element.getText();

			if(searchText.equals("selenium testing"))
			{
				element.click();
				ExtentManager.getExtentTest().pass("Clicked on given search text");

				break;
			}
		}


	}

}
