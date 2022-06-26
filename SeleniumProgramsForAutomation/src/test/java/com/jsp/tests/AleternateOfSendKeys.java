package com.jsp.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class AleternateOfSendKeys extends BaseTestClass {


	//	@Test
	public void alternateOfSendkeys() {
		ExtentReport.createTestName("Verify alternate Of Sendkeys using Java Script working or not");

		String url = "https://www.facebook.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);
		DriverManager.getDriver().manage().window().maximize();

		WebElement element = DriverManager.getDriver().findElement(By.id("email"));

		System.out.println("Page title is : "+ DriverManager.getDriver().getTitle());
		ExtentManager.getExtentTest().info("Entering value in textbox...");

		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("document.getElementById('email').value='Test Values'");



		ExtentManager.getExtentTest().pass("Value passed in textbox by Java Script.");


		String s = element.getAttribute("value");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Value entered is " + s);
		ExtentManager.getExtentTest().pass("Value entered in text box is " + s);


	}

	@Test

	public void alternateOfSendkeys2() throws InterruptedException {
		ExtentReport.createTestName("Verify alternate Of Sendkeys using Java Script working or not");

		String url = "https://www.facebook.com";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);
		DriverManager.getDriver().manage().window().maximize();

		WebElement element = DriverManager.getDriver().findElement(By.id("email"));

		System.out.println("Page title is : "+ DriverManager.getDriver().getTitle());
		ExtentManager.getExtentTest().info("Entering value in textbox...");

		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		//		driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element, attributeName, value);
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",
				element, "value", "Test Values in textbox by JS......");
		Thread.sleep(2000);
		ExtentManager.getExtentTest().pass("Value passed in textbox by Java Script.");


		String s = element.getAttribute("value");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Value entered is " + s);
		ExtentManager.getExtentTest().pass("Value entered in text box is " + s);

	}

}


/*

public class WriteInTextboxWithoutSendkeys
{
   public static void setAttribute(WebElement element, String attributeName,
         String value)
   {
      WrapsDriver wd = (WrapsDriver) element;
      JavascriptExecutor driver = (JavascriptExecutor)wd.getWrappedDriver();
      driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",
            element, attributeName, value);
   }
   public static void main(String[] args)
   {
      WebDriver driver=new FirefoxDriver();
      driver.get("https://www.facebook.com/");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      WebElement input_user=driver.findElement(By.xpath("//*[@id='email']"));
      setAttribute(input_user,"value","SoftwareTestingBlog");
   }
}




 */



