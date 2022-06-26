package com.jsp.drivers;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.jsp.enums.ConfigPropertiesEnum;
import com.jsp.utility.ConfigPropertiesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {}

	//	protected static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void initDriver(String browser) throws Exception{ //
		if (Objects.isNull(DriverManager.getDriver())) {

			if (browser.equalsIgnoreCase(ConfigPropertiesUtils.get(ConfigPropertiesEnum.BROWSER))) {

				//				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				DesiredCapabilities cap = new DesiredCapabilities().chrome();

				// get browser name
				String browsername=cap.getBrowserName();
				String browserversion=cap.getVersion();
				//				System.out.println(browsername+ " " +browserversion);

				cap.setCapability(ChromeOptions.CAPABILITY, options);
				//				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				DriverManager.setDriver(new ChromeDriver(cap));




				//			} else if (browser.equalsIgnoreCase("firefox")) {
				//				WebDriverManager.firefoxdriver().setup();
				//				FirefoxOptions fp = new FirefoxOptions();
				//				String path = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
				//				fp.setBinary(path);
				//				DriverManager.setDriver( new FirefoxDriver(fp));
				//
				//			} else if (browser.equalsIgnoreCase("IE")) {
				//				WebDriverManager.iedriver().setup();
				//				DriverManager.setDriver(new InternetExplorerDriver());
				//			}

				//			DriverManager.setDriver(DriverManager.getDriver());

				//			DriverManager.getDriver().get(ConfigPropertiesUtils.get("url"));
			}


		}}

	public static void tearDown() {
		if (Objects.nonNull(DriverManager.getDriver())) {

			DriverManager.getDriver().quit();
			DriverManager.unload();
			System.out.println("Browser Quit");

		}
	}

}
