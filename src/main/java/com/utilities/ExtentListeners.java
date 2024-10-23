package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners implements ITestListener{

	static String filename="mavenreport.html";
	private static ExtentReports extent=ExtentManager.CreateInstance("C:\\Users\\SRAVAN KUMAR SARA\\eclipse-workspace\\maven\\"+filename);
	public static ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest("@TestCase : "+result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE :- "+methodName.toUpperCase()+" PASSED "+"<b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("On Fail");
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE :- "+methodName.toUpperCase()+" FAILED "+"<b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);
	}
	
	public void onFinsih(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
	}
	
}
