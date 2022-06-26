package com.jsp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadlessBrowsingFirefox {


	@Test
	private void firefoxHeadlessBrowsing() {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

		FirefoxOptions foption = new FirefoxOptions();

		foption.setHeadless(true);

		WebDriver driver = new FirefoxDriver(foption);

		driver.get("https://www.selenium.dev");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		driver.quit();
		System.out.println("Firefox Headless Driver closed");

	}

}
