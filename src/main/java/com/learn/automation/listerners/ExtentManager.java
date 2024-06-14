package com.learn.automation.listerners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.learn.automation.helper.utility;

public class ExtentManager {

	public static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			extent=createInstance();
			return extent;
		} else {
			return extent;
		}
	}

	public static ExtentReports createInstance() {

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("./Reports/Automation" + utility.getcurrentdatenew()+".html");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setDocumentTitle("Automation title");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkreporter); 
		return extent;
	}
}
