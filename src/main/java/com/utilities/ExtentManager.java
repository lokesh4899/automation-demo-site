package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static String filename;
	
	public static ExtentReports CreateInstance(String filename) {
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(filename);
		
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(filename);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(filename);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		return extent;

	}

}
