package com.learn.automation.factory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.learn.automation.dataprovider.configReader;

public class BrowserFactory {

	public static WebDriver startBrowser(String browsername, String applicatioinURL) throws NumberFormatException, IOException {
		WebDriver driver = null;

		if (browsername.equalsIgnoreCase("Google chrome") || browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox") || browsername.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge") || browsername.equalsIgnoreCase("microsoft edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configReader.getProperty("pageload"))));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Integer.parseInt(configReader.getProperty("scriptload"))));
		driver.get(applicatioinURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configReader.getProperty("implicit"))));
		
		return driver;
	}
}
