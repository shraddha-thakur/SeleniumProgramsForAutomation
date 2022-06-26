package com.jsp.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GET_All_Emps extends BaseTestClass {


	@BeforeClass
	void getAllEmployees() throws InterruptedException {

		// specify base uri
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";

		// Request object
		httpRequest = RestAssured.given();

		// Response object
		response = httpRequest.request(Method.GET, "/employees");
		ExtentManager.getExtentTest().info("HTTP Request");

		Thread.sleep(3000);
	}

	@Test(groups = {"GET"})
	void checkResponseBody() {
		ExtentReport.createTestName("********Started TC001_Get_All_Employees***********");

		//print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : " + responseBody);
		ExtentManager.getExtentTest().info("Response Body is : " + responseBody);

	}

}
