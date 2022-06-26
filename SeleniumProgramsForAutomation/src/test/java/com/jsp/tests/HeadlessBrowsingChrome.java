package com.jsp.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessBrowsingChrome {

	WebDriver driver;
	//	@Test
	public void chromeHeadlessBrowsing() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.setHeadless(true);

		driver = new ChromeDriver(options);

		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.quit();
		System.out.println("Chrome Headless Driver closed");
	}

	@Test
	public void chromeHeadlessBrowsing2() throws IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("headless");
		options.addArguments("window-size=1200x600");

		driver = new ChromeDriver(options);
		System.out.println("Test Start");
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/ScreenShot/headlessChrome.png"));


		driver.quit();
		System.out.println("Chrome Headless Driver closed");
	}

	/**
	 * Another approach to  Run Selenium Test In Headless Mode
// Create Object of ChromeOption Class
ChromeOptions option=new ChromeOptions();

//add the –headless argument in option class which will run test in Headless mode
option.addArguments(“–headless”); not working

// pass the option object in ChromeDriver constructor
WebDriver driver=new ChromeDriver(option);
	 */

}
