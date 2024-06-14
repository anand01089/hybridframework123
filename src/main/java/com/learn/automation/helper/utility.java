package com.learn.automation.helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility {


	public static WebElement waitforwebelement(WebDriver driver,By locator)
	{
		WebElement element=null;
		for(int i=0;i<=30;i++)
		{
		try 
		{
			element = driver.findElement(locator);
			if(element.isDisplayed()&& element.isEnabled())
			{
				highlightWebElement(driver,locator);
				break;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		}

		return element;
	}

	public static WebElement highlightWebElement(WebDriver driver, By locator) {
		// TODO Auto-generated method stub
		WebElement ele= driver.findElement(locator);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:solid 2px red')", ele);
		js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", ele);
		return ele;
	}

	public static String getcurrentdate() {
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("HH_mm_ss_dd_MM_YYYY");
		return dateformat.format(date);
	}

	public static String getcurrentdatenew() {
		Date date = new Date();
		return new SimpleDateFormat("HH_mm_ss_dd_MM_YYYY").format(date);
	}

	public static void captureScreenshot(WebDriver driver) {

		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File(".\\screenshot\\screenshot1 " + utility.getcurrentdate() + ".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Alert waitforalert(WebDriver driver) {

		Alert alt = null;
		try {
			alt = driver.switchTo().alert();
		} catch (Exception e) {
			System.out.println("no alert found");
		}

		return alt;
	}

	public static Alert waitforalert(WebDriver driver, int seconds) {

		Alert alt = null;
		try {
			Thread.sleep(seconds);
			alt = driver.switchTo().alert();
		} catch (Exception e) {
			System.out.println("no alert found");
		}

		return alt;
	}

	public static void listofallvaluesfromsuggestion(WebDriver driver, String xpathvalue, String elementtosearch) {
		List<WebElement> allsuggestion = driver.findElements(By.xpath(xpathvalue));

		for (WebElement ele : allsuggestion) {
			String values = ele.getText();

			System.out.println("values are " + values);
			if (values.contains(elementtosearch)) {
				System.out.println("element found" + values);
				break;
			}
		}
	}

	public static void listofallvaluesfromsuggestion(WebDriver driver, By locator, String elementtosearch) {
		List<WebElement> allsuggestion = driver.findElements(locator);

		for (WebElement ele : allsuggestion) {
			String values = ele.getText();

			System.out.println("values are " + values);
			if (values.contains(elementtosearch)) {
				System.out.println("element found" + values);
				break;
			}
		}
	}
}
