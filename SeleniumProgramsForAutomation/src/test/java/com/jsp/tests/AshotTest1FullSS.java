package com.jsp.tests;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AshotTest1FullSS extends BaseTestClass{
	@Test
	public static void ashotTest1(){


		ExtentReport.createTestName("Full page screen shot using Ashot API.");
		String url = "https://www.automationtestinginsider.com/p/selenium-vi.html";
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		//Create the object of AShot() class and set image strategy by shootingStrategy method
		//and viewportPasting method and take screenshot using takeScreenshot method
		Screenshot Screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(500))
				.takeScreenshot(DriverManager.getDriver());
		ExtentManager.getExtentTest().pass("Create the object of AShot() class and set image strategy by shootingStrategy method and viewportPasting method and take screenshot using takeScreenshot method ");
		//Copy the element screenshot to desired location
		try {
			ImageIO.write(Screenshot.getImage(), "png", new File(System.getProperty("user.dir")+"/ScreenShot/" + "AshotFullPage.png"));
		} catch (IOException e) {
			e.getMessage();
		}

		ExtentManager.getExtentTest().pass("Copy the element screenshot to desired location");


	}

}
