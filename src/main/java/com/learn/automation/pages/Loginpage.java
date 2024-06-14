package com.learn.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learn.automation.helper.utility;

public class Loginpage {

	public Loginpage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	protected WebDriver driver;

	private By newuserlink = By.linkText("New user? Signup");
	private By errormessage = By.className("errorMessage");
	private By username = By.id("email1");
	private By password = By.id("password1");
	private By submit = By.className("submit-btn");

	public void loginToApplication(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		utility.waitforwebelement(driver, submit).click();
	}

	public String captureErrormessage() {
		String errmessage = utility.waitforwebelement(driver, errormessage).getText();
		return errmessage;
	}

	public void clickOnNewLink() {
		driver.findElement(newuserlink).click();

	}
}
