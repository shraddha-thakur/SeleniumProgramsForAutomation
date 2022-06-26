package com.jsp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver",

				System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		System.out.println("This is Before Test method");

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		boolean img = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img")).isDisplayed();

		Assert.assertTrue(img);

	}


	@Parameters({"username","password"})

	@Test

	public void loginTest(String uname, @Optional("admin123")String pswd) throws InterruptedException {

		driver.findElement(By.id("txtUsername")).sendKeys(uname);

		driver.findElement(By.name("txtPassword")).sendKeys(pswd);

		driver.findElement(By.id("btnLogin")).click();
		boolean img1 = driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img")).isDisplayed();

		Assert.assertTrue(img1);

	}
	@AfterMethod()

	public void tearDown() {

		System.out.println("This is After Test method");
		driver.close();
	}

}
