package com.jsp.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class ScreenShotElementCrop extends BaseTestClass {

	@Test
	public static void screenShotElementCrop() throws IOException{

		ExtentReport.createTestName("ScreenShot of WebElement by croping the image:");
		String url = "https://s1.demo.opensourcecms.com/wordpress/wp-login.php?";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement element = DriverManager.getDriver().findElement(By.id("wp-submit"));

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);
		ExtentManager.getExtentTest().pass("Get entire page screenshot");


		// Get the location,height,width of element on the page
		Point point = element.getLocation();
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		ExtentManager.getExtentTest().pass("Get the location,height,width of element on the page");

		// Crop the entire page screenshot to get only element screenshot
		try {
			BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
					eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		ExtentManager.getExtentTest().pass("Crop the entire page screenshot to get only element screenshot");

		// Copy the element screenshot to desired location
		File screenshotLocation = new File(System.getProperty("user.dir")+"/ScreenShot/CropElementSS.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		ExtentManager.getExtentTest().pass("Copy the element screenshot to desired location");
	}

}
