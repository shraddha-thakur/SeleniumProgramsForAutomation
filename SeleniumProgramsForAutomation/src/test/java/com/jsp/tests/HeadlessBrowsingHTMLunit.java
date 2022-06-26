package com.jsp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessBrowsingHTMLunit {



	/** add this dependency in POM.xml
	 * <!-- for headless browser testing -->
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/htmlunit-driver -->
		<!-- <dependency> <groupId>org.seleniumhq.selenium</groupId> <artifactId>htmlunit-driver</artifactId>
			<version>3.56.0</version> </dependency> -->

	 */

	//@BeforeTest
	//public void startHeadless() {
	//	WebDriver dr = new HtmlUnitDriver();
	//	dr.get("https://www.google.com");
	//	System.out.println("Headless browser started");
	//}

	@Test
	public void testHeadlessBrowser() {

		WebDriver dr = new HtmlUnitDriver();
		dr.get("https://www.google.com");
		System.out.println("Browser URL executed");
		System.out.println(dr.getTitle());

		System.out.println(dr.getCurrentUrl());


		dr.quit();

	}


	//@AfterTest

}



