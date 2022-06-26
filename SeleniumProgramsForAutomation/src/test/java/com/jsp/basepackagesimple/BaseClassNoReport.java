package com.jsp.basepackagesimple;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class BaseClassNoReport {

	public static WebDriver dr;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;

	//@BeforeSuite
	public void setExtent() {
		spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-output/ExtentReports/ExtentReport.html")
				.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD, ViewName.TEST}).apply();

		spark.config().setDocumentTitle("Automation Test Report");
		spark.config().setReportName("Java Selenium Programs for Automation");
		spark.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();

		extent.attachReporter(spark);

		extent.setSystemInfo("HostName", "My Host");
		extent.setSystemInfo("Project Name", "Java Selenium Programs for Automation");
		extent.setSystemInfo("Tester", "Shraddha Thakur");
		extent.setSystemInfo("OS", "win 7");
		extent.setSystemInfo("Browser", "Chrome");

	}

	//	@AfterSuite
	public void endReport() {
		extent.flush();
		try {
			Desktop.getDesktop().browse(new File(createFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		} // open the file in desktop default browser

	}



	@BeforeMethod
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		DesiredCapabilities cap = new DesiredCapabilities().chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, option);

		dr = new ChromeDriver(cap);
		//dr.manage().window().maximize();


	}

	@AfterMethod
	public static void tearDown(ITestResult result) {
		//		if(result.getStatus()==ITestResult.FAILURE) {
		//			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		//			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		//
		//			test.fail("Click to see screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
		//
		//		}
		//		else if(result.getStatus()==ITestResult.SKIP) {
		//			test.log(Status.SKIP, "Skipped Test case is : " + result.getName());
		//		}
		//		else if(result.getStatus()==ITestResult.SUCCESS) {
		//			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
		//		}
		//


		dr.quit();
	}

	private static String getBase64() {

		return ((TakesScreenshot)dr).getScreenshotAs(OutputType.BASE64);
	}

	public static String createFilePath() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-reports/";
		String extentreportfilepath = EXTENTREPORTFOLDERPATH + "index_" + dateformat.format(cal.getTime()) + ".html";
		return extentreportfilepath;

	}

}


/*
 * @Test public void test() {
 * 
 * }
 */
