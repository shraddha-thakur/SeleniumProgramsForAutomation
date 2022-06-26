package com.jsp.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class CheckBoxex extends BaseTestClass{

	@Test
	public static void checkBoxTest() throws InterruptedException {


		ExtentReport.createTestName("checkBoxTest");
		String url = "http://tizag.com/htmlT/htmlcheckboxes.php";
		DriverManager.getDriver().get(url);
		ExtentManager.getExtentTest().pass("Opening URL : " + url);

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//		DriverManager.getDriver().findElement(By.xpath("//div[4]/input[1]")).click();
		//		DriverManager.getDriver().findElement(By.xpath("//div[4]/input[2]")).click();
		//		DriverManager.getDriver().findElement(By.xpath("//div[4]/input[3]")).click();
		//		DriverManager.getDriver().findElement(By.xpath("//div[4]/input[4]")).click();

		//		for(int i=1; i<=4;i++) {
		//			DriverManager.getDriver().findElement(By.xpath("//div[4]/input[" + i +"]")).click();
		//
		//		}


		/*
		 * int i =1; int count =0;
		 * 
		 * while(isElementPresent(By.xpath("//div[4]/input[" + i +"]"))) {
		 * DriverManager.getDriver().findElement(By.xpath("//div[4]/input[" + i
		 * +"]")).click(); ExtentManager.getExtentTest().pass("Checkbox: "+ i
		 * +" is clicked");
		 * 
		 * i++; count++;
		 * 
		 * } System.out.println("Total Checkboxes are : " + count);
		 * ExtentManager.getExtentTest().pass("Total Checkboxes are : " + count);
		 */

		WebElement block = DriverManager.getDriver().findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes = block.findElements(By.name("sports"));
		System.out.println(checkboxes.size());

		for(WebElement checkbox : checkboxes) {
			checkbox.click();
			//			ExtentManager.getExtentTest().pass("Checkbox: "+ checkbox +" is clicked");
		}
	}


	static boolean isElementPresent(By by) {
		/*
		 * try{ DriverManager.getDriver().findElement(By.xpath(xpath)); return true;
		 * 
		 * }catch (Throwable t) { return false; }
		 */

		int size = DriverManager.getDriver().findElements(by).size();
		if(size== 0) {
			return false;
		}else {
			return true;
		}

	}

}



/*
 * 1. find the missing link of wikipedia
 * 2. Check the all checkboxes
 * 3. Get the name of checkboxes
 * 4. randomly select 2 checkboxes
 */
