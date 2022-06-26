package com.jsp.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class BrokenLinksTest extends BaseTestClass{

	List<WebElement> activeLinkImage = new ArrayList<WebElement>();

	@Test(priority = 1)
	public void getLinks() {

		ExtentReport.createTestName("Broken Link Test");
		String url = "https://www.google.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		// List of all links and images
		List<WebElement> linkImgList = DriverManager.getDriver().findElements(By.tagName("a"));
		linkImgList.addAll(DriverManager.getDriver().findElements(By.tagName("img")));

		// Total Links and Images Before
		int total = linkImgList.size();
		System.out.println("Total Links and Images are: " + total);
		ExtentManager.getExtentTest().pass("Total Links and Images are: " + total);

		for (int i = 0; i < linkImgList.size(); i++) {
			if (linkImgList.get(i).getAttribute("href") != null &&(!linkImgList.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinkImage.add(linkImgList.get(i));
			}
		}
		// Total Links and Images After
		int total1 = activeLinkImage.size();
		System.out.println("Total Active Links and Images: " + total1);
		ExtentManager.getExtentTest().pass("Total Active Links and Images: " + total1);

		BrokenLinksVerify obj= new BrokenLinksVerify();
		for (WebElement ele : activeLinkImage) {
			String url1 =ele.getAttribute("href");
			obj.verifyBrokenLinks(url1);
		}
		System.err.println("Total Valid Links: "+obj.validLink);
		System.err.println("Total Invalid Links: "+obj.invalidLink);
		ExtentManager.getExtentTest().pass("Total Valid Links: "+obj.validLink);
		ExtentManager.getExtentTest().pass("Total Invalid Links: "+obj.invalidLink);


	}



}
