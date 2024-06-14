package com.learn.automation.sample;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	@Test
	public void test1() {

		// extentsparkreporter helps in configuration like filename,path,chart
		// location,themes,titles
		// extent Report- maintains a single report from main class to end class
		// extent test- responsible to maintain test within report logs like fatal,loss,
		// pass,error,warning
		// flush--writes methods in report
		// mediaentrybuilder -screenshot

		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/Automation.html");

		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Spring 1 Title");
		reporter.config().setReportName("Automation Report");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		ExtentTest test1 = extent.createTest("LoginTestcase");
		test1.log(Status.INFO, "user enter the email");
		test1.log(Status.INFO, "password field is entered");
		test1.log(Status.PASS, "Login is done successfully");
		extent.flush();
		
		ExtentTest test2= extent.createTest("payment");
		test2.info("enter the card details");
		test2.info("enterthe cvv no details");
		test2.fail("Payment failed due to wrong OTP ");
		test2.fail("payment transaction failed", MediaEntityBuilder.createScreenCaptureFromBase64String("C:\\Users\\91966\\Desktop\\extensions\\HomeMountain.jpg","Current Status").build());
		extent.flush();
		
		ExtentTest test12= extent.createTest("logout");
		test12.info("press the logout button");
		test12.skip("no need to do logout");
		extent.flush();
	}

}
