package com.jsp.tests;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class DownloadFileChrome {

	WebDriver driver;
	@Test
	public void chromeHeadlessBrowsing() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		String downloadFilepath = "C:\\Users\\Shraddhya\\Desktop\\TestDownload";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions");
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		driver = new ChromeDriver(options);
		driver.get("https://www.selenium.dev/downloads/");
		driver.findElement(By.linkText("32 bit Windows IE")).click();

		System.out.println("File downloaded");
		driver.close();


	}

}
