package com.learn.automation.helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learn.automation.dataprovider.configReader;
import com.learn.automation.factory.BrowserFactory;

public class BaseClass {

	
	 public WebDriver driver;
	
	@BeforeClass
	public void setupApplication() throws IOException
	{
		System.out.println("LOG:INFO - RUNNING Base Class Before Class -setting the application");
		driver= BrowserFactory.startBrowser(configReader.getProperty("browser"),configReader.getProperty("url"));	
	}
	
	@AfterClass
	public void Teardown() {
		System.out.println("LOG:INFO -RUNNING After Class -Terminating the Application");
		driver.quit();
		
	}
}
