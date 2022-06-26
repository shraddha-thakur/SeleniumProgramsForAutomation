package com.jsp.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.jsp.drivers.DriverManager;

public class TakesScreenshotDemo  {

	public static void screenShot(WebDriver driver, String filename){

		TakesScreenshot takescreenshot = (TakesScreenshot)DriverManager.getDriver();
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/ScreenShot/" + filename  + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}


	}
}
