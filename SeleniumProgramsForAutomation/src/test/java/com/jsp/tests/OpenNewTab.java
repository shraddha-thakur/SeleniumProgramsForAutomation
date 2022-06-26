package com.jsp.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class OpenNewTab {
	//	@Test
	public static void openNewTab() throws InterruptedException {

		ExtentReport.createTestName("Open New Tab");
		String url = "https://www.google.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Test on URL " + url);

		Thread.sleep(2000);
		DriverManager.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		System.out.println("New Tab Opened");
		ExtentManager.getExtentTest().pass("New Tab Opened");

		DriverManager.getDriver().get("https://www.gmail.com");
		System.out.println("URL navigated to > " + DriverManager.getDriver().getCurrentUrl());
		ExtentManager.getExtentTest().pass("URL navigated to > " + DriverManager.getDriver().getCurrentUrl());

		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(	DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(tabs.get(0));
		System.out.println("Window switched to > " + DriverManager.getDriver().getCurrentUrl());
		ExtentManager.getExtentTest().pass("Window switched to >" + DriverManager.getDriver().getCurrentUrl());

		Thread.sleep(5000);

	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");

		WebDriver driver=new ChromeDriver();

		driver.get("https://www.google.com");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		System.out.println("New Tab Opened");

		driver.get("https://www.gmail.com");
		System.out.println("URL navigated to > " + driver.getCurrentUrl());
		Thread.sleep(2000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		System.out.println("Window switched to > " + driver.getCurrentUrl());

		Thread.sleep(5000);

		driver.close();
		System.out.println("Test Passed");
	}

}
