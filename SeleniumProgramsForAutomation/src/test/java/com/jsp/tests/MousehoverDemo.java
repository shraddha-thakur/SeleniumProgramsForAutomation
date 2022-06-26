package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class MousehoverDemo extends BaseTestClass{


	@Test
	public static void verifyMousehoverDemo() throws InterruptedException {

		ExtentReport.createTestName("MousehoverDemo");
		String url = "https://s1.demo.opensourcecms.com/wordpress/wp-login.php";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL " + url);

		Actions act = new Actions(DriverManager.getDriver());

		DriverManager.getDriver().findElement(By.id("user_login")).sendKeys("opensourcecms");
		DriverManager.getDriver().findElement(By.id("user_pass")).sendKeys("opensourcecms");
		DriverManager.getDriver().findElement(By.id("wp-submit")).click();
		Thread.sleep(1000);
		ExtentManager.getExtentTest().pass("Logging into appl");

		WebElement logoutOption = DriverManager.getDriver().findElement(By.xpath("//a[text()='Howdy, ']"));

		act.moveToElement(logoutOption).perform();
		ExtentManager.getExtentTest().pass("Mouse Hover action performed");

		DriverManager.getDriver().findElement(By.xpath("//a[@class='ab-item'][text()='Log Out']")).click();
		ExtentManager.getExtentTest().pass("Clicked after Mouse Hover action performed");

		Thread.sleep(2000);


	}
}
