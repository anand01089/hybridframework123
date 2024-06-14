package com.learn.automation.listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportITestListener implements ITestListener 
{

	ExtentReports extent=ExtentManager.getInstance();
//	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	
	
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest extendTest=extent.createTest(result.getMethod().getMethodName());
		System.out.println("LOG:INFO Test Start ...!!!" + result.getMethod().getMethodName());
	}

	public synchronized void onTestSuccess(ITestResult result) {
		parentTest.get().pass("Test Passed");
		
		//here extent= parentTest.get(); so remove everywhere with extent as parenttest.get()
		System.out.println("LOG:Pass- Test Passed ...!!!" + result.getMethod().getMethodName());
	}

	public synchronized void onTestFailure(ITestResult result) {
		
		parentTest.get().fail("Test failed"+result.getThrowable().getMessage());
		System.out.println("LOG:Fail - Test Failed ...!!!" + result.getMethod().getMethodName());
		System.out.println(result.getThrowable().getMessage());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		extent.flush();
		parentTest.get().fail("Test skipped "+result.getMethod().getMethodName());
		System.out.println("LOG:skip - Test Skipped  ...!!!" + result.getMethod().getMethodName());

	}
	
	public synchronized void onTestFinish(ITestContext context) {
		extent.flush();
		System.out.println("LOG:END - Test END ...!!!" + context.getName());
	}

}
