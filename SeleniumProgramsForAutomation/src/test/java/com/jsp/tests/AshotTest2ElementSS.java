package com.jsp.tests;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.javaprograms.CurrentDate;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class AshotTest2ElementSS extends BaseTestClass{
	@Test
	public static void ashotTest2(){


		ExtentReport.createTestName("ScreenShot of WebElement by Ashot API", "Shraddha", "UI");

		String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement element = DriverManager.getDriver().findElement(By.id("btnLogin"));

		//Create the object of AShot() class and get the image co-ordinates
		//by coordsProvider method and take screenshot using takeScreenshot method

		Screenshot Screenshot = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(DriverManager.getDriver(), element);
		ExtentManager.getExtentTest().pass("Create the object of AShot() class and get the image co-ordinates "
				+ "by coordsProvider method and take screenshot using takeScreenshot method ");

		//Copy the element screenshot to desired location
		try {
			ImageIO.write(Screenshot.getImage(), "png", new File(System.getProperty("user.dir")+"/ScreenShot/" + "Ashot2Element_" + CurrentDate.getCurrentDate() + ".png"));
		} catch (IOException e) {
			e.getMessage();
		}

		ExtentManager.getExtentTest().pass("Copy the element screenshot to desired location");




	}

}
