package com.jsp.basepackage;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jsp.constants.FrameworkConstants;
import com.jsp.drivers.Driver;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class xBaseTestClass {

	protected xBaseTestClass() {

	}

	//	public static ExtentTest test;

	@BeforeSuite
	private void beforeSuite() throws Exception {
		ExtentReport.initReports();
	}

	@AfterSuite
	private void afterSuite() throws Exception {
		ExtentReport.flushReports();
	}

	@BeforeMethod
	private void setUp() throws Exception {

		//		Driver.initDriver(ConfigPropertiesUtils.get("browser"));
		Driver.initDriver(FrameworkConstants.getChromebrowser());

		//		DriverManager.getDriver().get(ConfigPropertiesUtils.get("url").trim());
		//		DriverManager.getDriver().get(ConfigPropertiesUtils.get(ConfigProperties.URL).trim());
		//		WebDriverManager.chromedriver().setup();
		//		driver = new ChromeDriver();
		//		driver.get("https://www.google.com");

	}

	@AfterMethod
	private void tearDown(ITestResult result) {

		if(result.getStatus()==ITestResult.FAILURE) {
			ExtentManager.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			ExtentManager.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			ExtentManager.getExtentTest().fail("Click to see screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String(ExtentReport.getBase64()).build());
			//			ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			//			ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//			//			ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(result.getThrowable().getStackTrace() + " - Test Case Failed", ExtentColor.RED));

		}else if (result.getStatus()==ITestResult.SKIP) {
			//			ExtentManager.getExtentTest().skip("Skipped Test Case is : "+ result.getName());
			ExtentManager.getExtentTest().log(Status.SKIP, "Skipped Test Case is : "+ result.getName());
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			ExtentManager.getExtentTest().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));

			//			ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
		}

		Driver.tearDown();

		//		driver.quit();
		//		System.out.println("Test Passed");
	}
}
