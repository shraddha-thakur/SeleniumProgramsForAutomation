package com.jsp.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class Waits extends BaseTestClass {
	/*
	 * Why do we need waits in Selenium?
	Most web applications are developed with Ajax and Javascript. When a page loads on a browser, the various web elements that someone wants to interact with may load at various time intervals.
	This obviously creates difficulty in identifying any element. On top of that, if an element is not located then the “ElementNotVisibleException/NoSuchElementException” appears.
	 */
	//	@Test
	public static void waitDemo1(){


		ExtentReport.createTestName("waitDemo1 gettinf NoSuchElementException");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("testWait123")).click();

		WebElement ele = DriverManager.getDriver().findElement(By.xpath("//div[text()='Welcome To Automation Testing Insider']"));
		String text  = ele.getText();

		System.out.println("Welcome msg is : "  + text);
	}

	@Test(enabled = false)
	public static void implicitwaitDemo2(){

		ExtentReport.createTestName("implicitwaitDemo2");
		//		DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("testWait123")).click();

		WebElement ele = DriverManager.getDriver().findElement(By.xpath("//div[text()='Welcome To Automation Testing Insider']"));
		String text  = ele.getText();

		System.out.println("Welcome msg is : "  + text);

		/*
		 * In the above code, I have given an implicit wait at 30 seconds, which implies that the maximum wait time is
		 * 30 seconds for the particular element to load or to arrive at the output. Implicit wait is a dynamic wait.
		 */
	}

	/*
	 * What are dynamic waits?
Implicit, Explicit, and Fluent waits are dynamic waits.
Consider a situation where you have given a TimeOut value of 30 seconds.
If the element is loaded in 5 seconds, then rest 25 seconds will be ignored.
It won’t wait until the TimeOut value is completed, i.e 30 seconds. That’s why all waits are considered as dynamic waits.
	Explicit Wait - Explicit waits are used to halt the execution until the time a particular condition is met or the maximum time has elapsed. Explicit waits are a concept from the dynamic wait, which waits dynamically for specific conditions. It can be implemented by the WebDriverWait class. To understand the explicit wait in Selenium WebDriver, you should know the requirements and why we use wait statements in programs.

In order to declare explicit wait, one has to use “ExpectedConditions”. The following Expected Conditions can be used in Explicit Wait.

alertIsPresent()
elementSelectionStateToBe()
elementToBeClickable()
elementToBeSelected()
frameToBeAvaliableAndSwitchToIt()
invisibilityOfTheElementLocated()
invisibilityOfElementWithText()
presenceOfAllElementsLocatedBy()
presenceOfElementLocated()
textToBePresentInElement()
textToBePresentInElementLocated()
textToBePresentInElementValue()
titleIs()
titleContains()
visibilityOf()
visibilityOfAllElements()
visibilityOfAllElementsLocatedBy()
visibilityOfElementLocated()

Syntax:
WebDriverWait wait= new WebDriverWait(driver, 5);
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(“xpath")));

Example – Suppose I have a web page that has some login form, and after login, it takes a lot of time to load the account or home page. This page is dynamic — it means that sometimes it takes 10 seconds to load the homepage, and sometimes, it’s 15 seconds and so on. In such situations, explicit wait helps us to wait until a specific page is not present.

	 *
	 *
	 */



	@Test(enabled = false)
	public static void explicitwaitDemo3(){

		ExtentReport.createTestName("explicitwaitDemo3");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("testWait123")).click();
		String xpath = "//div[text()='Welcome To Automation Testing Insider']";
		WebElement ele = findelement(DriverManager.getDriver(), xpath,10);
		String text  = ele.getText();

		System.out.println("Welcome msg is : "  + text);
		ExtentManager.getExtentTest().pass("Welcome msg is : "  + text);

	}

	private static WebElement findelement(WebDriver driver, String xpath, int timeout) {
		WebElement ele = new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return ele;
	}


	/*
	 * Fluent Wait - The Fluent Wait command defines the maximum amount of time for Selenium WebDriver to wait
	 * for a certain condition to appear. It also defines the frequency with which WebDriver will check
	 * if the condition appears before throwing the “ElementNotVisibleException”.


Syntax:
Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
.withTimeout(Duration.ofSeconds(40))
.pollingEvery(Duration.ofSeconds(8))
.ignoring(Exception.class);

   WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.xpath(“xpath"));
     }
   });

Example: Let's consider a scenario where an element is loaded at different intervals of time.
The element might load within 10 seconds, 20 seconds or even more then that
if we declare an explicit wait of 20 seconds. It will wait till the specified time before throwing an exception.
In such scenarios, the fluent wait is the ideal wait to use as this will try to find the element at different frequency
until it finds it or the final timer runs out.

	 */


	@Test(enabled = false)
	public static void fluentwaitDemo4(){

		ExtentReport.createTestName("fluentwaitDemo4");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("testWait123")).click();
		String xpath = "//div[text()='Welcome To Automation Testing Insider']";

		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		ExtentManager.getExtentTest().pass("Fluent wait ");


		WebElement ele = wait.until(new Function<WebDriver, WebElement>(){

			@Override
			public WebElement apply (WebDriver driver)
			{
				return driver.findElement(By.xpath(xpath));
			}
		});
		ExtentManager.getExtentTest().pass("Fluent wait applied");

		String text  = ele.getText();

		System.out.println("The msg is : "  + text);
		ExtentManager.getExtentTest().pass("The msg is : "  + text);

	}

	/*
	 * Some other waits are:
PageLoadTimeOut - One of the timeouts is focused on the time a webpage needs to be loaded
– the pageLoadTimeout limits the time that the script allots for a web page to be displayed.
Page load timeout is useful when we perform a performance test.
Page Load timeout is applicable only to driver.get() and driver.navigate().to() methods in selenium.

Syntax:  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

Consider below example where we used PageLoadTimeOut to limit the page to be loaded in 5 seconds
 but page did not load in 5 seconds and throws TimeoutException exception.
	 */


	@Test(enabled = false)
	public static void pageLoadTimeoutDemo5() throws Exception{

		ExtentReport.createTestName("pageLoadTimeoutDemo5");
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("testWait123")).click();
		Thread.sleep(5000);
		String xpath = "//div[text()='Welcome To Automation Testing Insider']";
		WebElement ele = DriverManager.getDriver().findElement(By.xpath("//div[text()='Welcome To Automation Testing Insider']"));
		String text  = ele.getText();

		System.out.println("Welcome msg is : "  + text);
		ExtentManager.getExtentTest().pass("Welcome msg is : "  + text);

	}
	/*
	 * Thread.sleep() - Sleep is a static method that belongs to the thread class.
	 * This method can be called using the reference of the class name i.e Thread.
	 * If you use Thread.sleep while performing automation testing with Selenium,
	 * then this method will stop the execution of the script for the specified duration of time,
	 * irrespective of whether the element is found or not on the web page.

	Syntax: Thread.sleep(5000);
	 */
	@Test
	public static void threadSleepDemo6() throws Exception{

		ExtentReport.createTestName("threadSleepDemo6");

		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().findElement(By.id("testWait123")).click();
		Thread.sleep(10000);
		String xpath = "//div[text()='Welcome To Automation Testing Insider']";
		WebElement ele = DriverManager.getDriver().findElement(By.xpath("//div[text()='Welcome To Automation Testing Insider']"));
		String text  = ele.getText();

		System.out.println("Welcome msg is : "  + text);
		ExtentManager.getExtentTest().pass("Welcome msg is : "  + text);

		/*
		 * Consider the above example, the element will be visible in 5 seconds
		 * but WebDriver will still wait for another 5 seconds.
		 * It will increase test execution time.
		 */
	}


}

/*
 * What happens when we use Implicit wait and Explicit wait together:

Implicit wait destroys meaning of using explicit wait when using together.
So it is advised not to use implicit wait and explicit wait together.
 Actually when we use both waits together, both waits will be applied at the same time and it get messed up.

Now we will see reason behind these using below scenarios:

1. Explicit Wait= Implicit Wait (Say 10 seconds)

Both waits get activated at same time to locate element. Explicit wait keeps searching for an element
till it is found and implicit wait allows webdriver to search till timeout.
When explicit wait starts and looks for element, because of implicit wait it needs to wait for 10 seconds
because element is not found. So both waits completes 10 seconds wait time.

2. Implicit wait(20) > Explicit Wait(10)

When explicit wait starts looking for element, it needs to wait for 20 seconds because of implicit wait time.

3. Implicit wait(10) < Explicit Wait(20)

When explicit wait starts looking for element, it needs to wait for 10 seconds because of implicit wait. After that implicit wait throws exception because of not able to locate element.  Exception stops explicit wait to search further and does not allow to reach its timeout.

Few more points to remember:
1. The most widely used waits are implicit and explicit waits. Fluent waits are not preferable for real-time projects.
2. We use FluentWait commands mainly when we have web elements which sometimes visible in few seconds
and some times take more time than usual. Mostly in Ajax applications.
3. We use mostly explicit wait because it is for specific condition/element
and we have more flexibility in using explicit rather than implicit.

 */







