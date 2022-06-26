package com.jsp.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.jsp.drivers.DriverManager;
import com.jsp.reports.ExtentManager;
import com.jsp.reports.ExtentReport;

public class CSVRead extends BaseTestClass {

	@Test
	public void csvReadtest() throws FileNotFoundException {
		ExtentReport.createTestName("CSV file Read ");
		String csvfile = "H:\\SELENIUM_WORK\\Shraddha_Automations\\TestCase Studio\\verifyRegister.csv";
		int v = CSVRead.getRowCount(csvfile);
		for(int i=1;i<=v; i++) {
			String t = CSVRead.getValue(csvfile, i, 1);
			System.out.println(t);
		}


	}
	//getting the last data count(rowcount)
	public static int getRowCount(String csvPath) throws FileNotFoundException {

		int rc=0;

		try (Scanner scanner = new Scanner(new File(csvPath))){
			scanner.useDelimiter("\n");
			while(scanner.hasNext()) {
				rc++;
				scanner.next();
			}
		}
		return rc;
	}

	//getting the value from csv cell
	public static String getValue(String csvPath, int rc, int cc) throws FileNotFoundException {

		{
			String v="";
			try(Scanner scanner = new Scanner(new File(csvPath))){
				scanner.useDelimiter("\n");
				for(int i =1; i<rc; i++) {
					if(scanner.hasNext())
						v=scanner.next();
				}
			}
			return v.split(",")[cc-1];

		}

	}


}

