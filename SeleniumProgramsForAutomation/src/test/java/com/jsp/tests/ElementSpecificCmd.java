package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jsp.basepackagesimple.BaseClass;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ElementSpecificCmd extends BaseTestClass {

	@Test
	private void elementSpecificCmd() {
		//headless
		ExtentReport.createTestName("elementSpecificCmd");
		String url = "http://demowebshop.tricentis.com/register";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("URL Opened "+ url);

		DriverManager.getDriver().findElement(By.name("FirstName")).sendKeys("JohnJohmytest tests test");
		DriverManager.getDriver().findElement(By.name("FirstName")).clear();

		DriverManager.getDriver().findElement(By.id("gender-female")).click();
		ExtentManager.getExtentTest().pass("Click command");

		System.out.println("Click:\r\n"
				+ "The click command emulates a click operation for a link, button, checkbox or radio button. In Selenium Webdriver, execute click after finding an element.");

		String header = DriverManager.getDriver().findElement(By.tagName("h1")).getText();
		System.out.println("Get text by tagname " + header);
		ExtentManager.getExtentTest().pass("Get text by tagname " + header);

		System.out.println("getText:\r\n"
				+ "The command is used to retrieve the inner text of the specified web element. The command doesn’t require any parameter and returns a string value.");
		System.out.println();

		WebElement optmale = DriverManager.getDriver().findElement(By.id("gender-male"));
		optmale.click();
		boolean elb = optmale.isSelected();
		System.out.println("Element is selected : " + elb);

		ExtentManager.getExtentTest().pass("Element is selected : " + elb);

		System.out.println("IsSelected:\r\n"
				+ "isSelected() is the method used to verify if the web element is selected or not.");
		System.out.println();

		boolean isenable = DriverManager.getDriver().findElement(By.id("register-button")).isEnabled();
		System.out.println("Element is enabled : " + isenable);
		ExtentManager.getExtentTest().pass("Element is enabled : " + isenable);

		System.out.println("IsEnabled:\r\n"
				+ "isEnabled() is the method used to verify if the web element is enabled or disabled within the webpage. isEnabled() is primarily used with buttons. ");
		System.out.println();

		boolean isdisplay = DriverManager.getDriver().findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']")).isDisplayed();
		Assert.assertTrue(isdisplay, "Element is displayed");
		ExtentManager.getExtentTest().pass("Element isDisplayed : " + isdisplay);

		System.out.println();
		System.out.println(" IsDisplayed:\r\n"
				+ "isDisplayed() is the method used to verify a presence of a web element within the webpage. The method returns a “true” value if the specified web element is present on the web page and a “false” value if the web element is not present on the web page.");
		String textattribute = DriverManager.getDriver().findElement(By.id("small-searchterms")).getAttribute("value");
		System.out.println();

		System.out.println("Get Attribute text : " + textattribute);
		ExtentManager.getExtentTest().pass("Get Attribute text : " + textattribute);

		System.out.println("getAttribute:\r\n"
				+ "The command is used to retrieve the value of the specified attribute. The command requires a single string parameter that refers to an attribute whose value we aspire to know and returns a string value. as a result.");
		System.out.println();

		DriverManager.getDriver().findElement(By.id("small-searchterms")).sendKeys("Text to entered");
		ExtentManager.getExtentTest().pass("Send keys");

		System.out.println("sendkeys:\r\n"
				+ "This is a method for sending one or more keystrokes to the active window");
		System.out.println();

		System.out.println("Submit:\r\n"
				+ "submit() is used to click Button in Web page. Selenium Webdriver has one special method to submit any form and that method name Is submit(). You can use .click() method to click on any button.There is no restriction for click buttons. We can use .submit() method for only submit form after click on button. That means element's type = \"submit\" and button should be inside <form> tag, then only submit() will work.");

		System.out.println("10. getSize: \r\n"
				+ "It will returns the \"Dimension\" object. If you want to get the width and Height of the specific element on the webpage then use \"getsize()\" method.\r\n"
				+ "\r\n"
				+ "11. getCssValue: - getCssValue method in selenium fetches the value of a CSS property of an web element.\r\n"
				+ "\r\n"
				+ "12. getLocation: \r\n"
				+ "In Selenium WebDriver APIs, there is a method getLocation() which returns point, containing location of top left hand corner of the element. Let's say, it returns (x, y).\r\n"
				+ "\r\n"
				+ "13. getTagname: \r\n"
				+ "This method gets the tag name of this element. This accepts nothing as a parameter and returns a String value. Command – element.getTagName();");






	}

}
