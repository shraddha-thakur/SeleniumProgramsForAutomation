package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class FileUploadSendKeys extends BaseTestClass{

	@Test(enabled = false)
	public void fileUpload() {

		ExtentReport.createTestName("verify FileUploadSendKeys by sendKeys ");
		String url = "https://demo.guru99.com/test/upload/";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		WebElement uploadElement = DriverManager.getDriver().findElement(By.id("uploadfile_0"));

		// enter the file path onto the file-selection input field
		uploadElement.sendKeys("C:\\Users\\Shraddhya\\Desktop\\vitthal.jpg");
		ExtentManager.getExtentTest().pass("file path send to element");

		// check the "I accept the terms of service" check box
		DriverManager.getDriver().findElement(By.id("terms")).click();

		// click the "UploadFile" button
		DriverManager.getDriver().findElement(By.name("send")).click();
	}



	@Test(enabled = false)
	public void fileUpload2() {

		ExtentReport.createTestName("verify FileUploadSendKeys by sendKeys ");
		String url = "https://www.monsterindia.com/seeker/registration";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		// FILE UPLOADING USING SENDKEYS ....

		WebElement browse = DriverManager.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
		//click on ‘Choose file’ to upload the desired file
		browse.sendKeys("C:\\Users\\Shraddhya\\Desktop\\Test.txt");
		ExtentManager.getExtentTest().pass("file path send to element");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Uploading the file using sendKeys
		System.out.println("File is Uploaded Successfully");
		ExtentManager.getExtentTest().pass("File is Uploaded Successfully");


	}



	@Test
	public void fileUpload3() throws InterruptedException {

		ExtentReport.createTestName("verify FileUploadSendKeys by sendKeys ");
		String url = "https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		// FILE UPLOADING USING SENDKEYS ....

		Thread.sleep(2000);
		Actions act= new Actions(DriverManager.getDriver());
		WebElement chooseFile=	DriverManager.getDriver().findElement(By.id("fileupload1"));
		act.moveToElement(chooseFile).perform();
		Thread.sleep(1000);
		chooseFile.sendKeys("C:\\Users\\Shraddhya\\Desktop\\Test.txt");
		ExtentManager.getExtentTest().pass("file path send to element");




	}
}

