package com.jsp.tests;

import org.testng.annotations.Test;

import com.jsp.basepackagesimple.BaseClassNoReport;
import com.jsp.drivers.DriverManager;

public class PingTestNoReport extends BaseClassNoReport   {


	@Test
	public void pinggoogle() {

DriverManager.getDriver().get("https://www.google.com/");
String title = DriverManager.getDriver().getTitle();
System.out.println(title);

	}
}
