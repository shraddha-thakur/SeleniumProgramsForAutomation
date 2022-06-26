package com.jsp.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class Action extends BaseTestClass{

	@Test
	public void testAction1() {

		ExtentReport.createTestName("Verify moveToElement Actions working or not");

		String url = "https://demo.guru99.com/test/newtours/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);
		DriverManager.getDriver().manage().window().maximize();

		WebElement link_home = DriverManager.getDriver().findElement(By.linkText("Home"));
		WebElement td_home = DriverManager.getDriver().findElement(By.xpath("//html/body/div"
				+ "/table/tbody/tr/td"
				+ "/table/tbody/tr/td"
				+ "/table/tbody/tr/td"
				+ "/table/tbody/tr"));

		Actions builder = new Actions(DriverManager.getDriver());

		org.openqa.selenium.interactions.Action mouseOverHome = builder.moveToElement(link_home).build();
		ExtentManager.getExtentTest().pass("Hovering on Home");

		String bgColor = td_home.getCssValue("background-color");
		System.out.println("Before Hover " + bgColor);
		ExtentManager.getExtentTest().pass("Before Hover " + bgColor);


		mouseOverHome.perform();
		ExtentManager.getExtentTest().pass("Hover on Home");

		bgColor = td_home.getCssValue("background-color");
		System.out.println("After Hover " + bgColor);
		ExtentManager.getExtentTest().pass("After Hover " + bgColor);

	}

	@Test
	public void testAction2() {

		ExtentReport.createTestName("Very click, SendKeys, keyUp, keyDown, doubleClick & contextClick action performed ");
		DriverManager.getDriver().get("https://www.facebook.com/");
		WebElement txtUsername = DriverManager.getDriver().findElement(By.id("email"));

		Actions builder = new Actions(DriverManager.getDriver());

		org.openqa.selenium.interactions.Action seriesOfActions = builder.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick()
				.contextClick()
				.build();

		seriesOfActions.perform();
		ExtentManager.getExtentTest().log(Status.PASS, "All Actions performed.");
		ExtentManager.getExtentTest().pass("All Actions performed.");
	}


	@Test
	public void testAction3() {

		ExtentReport.createTestName("Verify sendkeys  Action working or not");
		String url = "https://www.google.com/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement txtSearchBox = DriverManager.getDriver().findElement(By.name("q"));

		Actions act = new Actions(DriverManager.getDriver());

		act.sendKeys(txtSearchBox, "iphone").build().perform();

		ExtentManager.getExtentTest().pass("Sendkeys Action done");

		//The build() method generates a composite action containing all actions which are ready to be performed.
		//The perform() method is used to perform the series of actions that are defined.

	}

	@Test
	public void testAction4() {

		ExtentReport.createTestName("verify sendkeys, click, doubleClick, contextClick Action working or not");
		String url = "https://www.amazon.in/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);


		Actions act = new Actions(DriverManager.getDriver());

		WebElement txtSearchBox = DriverManager.getDriver().findElement(By.cssSelector("input#twotabsearchtextbox"));
		String searchtext = "iphone";
		act.sendKeys(txtSearchBox, searchtext).build().perform();

		ExtentManager.getExtentTest().pass("Sendkeys Action performed");
		WebElement btnSearch = DriverManager.getDriver().findElement(By.id("nav-search-submit-button"));

		act.click(btnSearch).build().perform();
		ExtentManager.getExtentTest().pass("Click Action performed");

		Assert.assertEquals(DriverManager.getDriver().getTitle(), "Amazon.in : "+searchtext);

		DriverManager.getDriver().navigate().back();
		ExtentManager.getExtentTest().pass("Navigate Back");

		WebElement element1 = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));

		act.doubleClick(element1).build().perform();
		ExtentManager.getExtentTest().pass("Double Click Action performed");

		assertEquals(DriverManager.getDriver().getTitle(), "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
		ExtentManager.getExtentTest().pass("Assertion for page title");

		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		ExtentManager.getExtentTest().info("Checking for pageload time out");

		act.contextClick().build().perform();
		ExtentManager.getExtentTest().pass("Context Click Action performed");


		//		ExtentManager.getExtentTest().pass("Click Action performed");

		//The build() method generates a composite action containing all actions which are ready to be performed.
		//The perform() method is used to perform the series of actions that are defined.
	}


	@Test
	public void testAction5() {

		ExtentReport.createTestName("verify moveToElement Action working or not");
		String url = "https://www.amazon.in";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);


		WebElement eleResource = DriverManager.getDriver().findElement(By.id("nav-link-accountList"));

		Actions act = new Actions(DriverManager.getDriver());

		act.moveToElement(eleResource).build().perform();
		ExtentManager.getExtentTest().pass("Move To Element Action performed");

		DriverManager.getDriver().findElement(By.linkText("Create a Wish List")).click();
		ExtentManager.getExtentTest().pass("Click on Link from moved to element");

		assertEquals(DriverManager.getDriver().getCurrentUrl(), "https://www.amazon.in/hz/wishlist/intro");
		ExtentManager.getExtentTest().pass("Current URL : " + DriverManager.getDriver().getCurrentUrl());

		assertEquals(DriverManager.getDriver().getTitle(), "Wish List");
		ExtentManager.getExtentTest().pass("Page Title : " + DriverManager.getDriver().getTitle());


	}

	@Test
	public void testAction6() {

		ExtentReport.createTestName("verify DragAndDrop Action working or not");
		String url = "https://jqueryui.com/droppable/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		//		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		DriverManager.getDriver().switchTo().frame(0);

		WebElement source = DriverManager.getDriver().findElement(By.id("draggable"));
		WebElement destination = DriverManager.getDriver().findElement(By.id("droppable"));

		Actions act = new Actions(DriverManager.getDriver());

		//		act.clickAndHold(source).moveToElement(destination).release().build().perform();
		act.dragAndDrop(source, destination).build().perform();
		ExtentManager.getExtentTest().pass("Drag And Drop Action performed");
		act.dragAndDropBy(source, 24, 329).build().perform();

		ExtentManager.getExtentTest().pass("Drag And Drop By Action performed");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAction7() {

		ExtentReport.createTestName("verify Scroll Up & Down the page Action working or not");
		String url = "https://www.amazon.in/ref=nav_logo";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();

		Actions act = new Actions(DriverManager.getDriver());

		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		ExtentManager.getExtentTest().pass("Page Scroll Down Action performed");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		act.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();

		ExtentManager.getExtentTest().pass("Page Scroll Up Action performed");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAction8() {

		ExtentReport.createTestName("verify Copy & Paste, Refresh Actions working or not");
		String url = "https://www.google.com/account/about/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();

		DriverManager.getDriver().findElement(By.xpath("//div[5]/ul/li[1]")).click();
		ExtentManager.getExtentTest().pass("Page Navigated" );

		WebElement txtfirstName = DriverManager.getDriver().findElement(By.name("firstName"));
		WebElement txtUsername = DriverManager.getDriver().findElement(By.name("Username"));

		//		txtfirstName.sendKeys("Shraddha");

		Actions act = new Actions(DriverManager.getDriver());
		//holds the SHIFT key and converts the text to uppercase
		act.keyDown(txtfirstName,Keys.SHIFT).sendKeys("Shraddha").build().perform();
		ExtentManager.getExtentTest().pass("Convert text to UPPERCASE action performed");

		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		ExtentManager.getExtentTest().pass("Text select action performed");
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		ExtentManager.getExtentTest().pass("Text Copy action performed");

		txtUsername.click();

		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		ExtentManager.getExtentTest().pass("Copy & Paste action performed");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
		ExtentManager.getExtentTest().pass("Page Refresh action performed");
		//		try {
		//			Thread.sleep(3000);
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//
	}

	@Test
	public void testAction9() {

		ExtentReport.createTestName("verify Tab Actions working or not");
		String url = "http://demowebshop.tricentis.com/register";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement txtfirstName = DriverManager.getDriver().findElement(By.xpath("//input[@id='FirstName']"));

		Actions act = new Actions(DriverManager.getDriver());
		txtfirstName.click();
		act.sendKeys(Keys.TAB).build().perform();
		//input[@id='FirstName']
		ExtentManager.getExtentTest().pass("Tab action performed");
		act.sendKeys(Keys.TAB).build().perform();
		ExtentManager.getExtentTest().pass("Tab action performed");

		act.sendKeys(Keys.RETURN).build().perform();
		ExtentManager.getExtentTest().pass("Return action performed");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
