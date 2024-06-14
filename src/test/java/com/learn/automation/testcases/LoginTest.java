package com.learn.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.learn.automation.constants.constants;
import com.learn.automation.dataprovider.customDataProvider;
import com.learn.automation.helper.BaseClass;
import com.learn.automation.pages.Loginpage;



public class LoginTest extends BaseClass {
	
	// data is cmg from local dataprovider or from  seperate customerized dataprovider
	
	@Test(dataProvider="users" ,dataProviderClass=customDataProvider.class)
	public void logintoApp(String user,String pass)
	{
		
		Loginpage login= new Loginpage(driver);
		login.loginToApplication(user, pass);
		String errormsg=login.captureErrormessage();
		Assert.assertTrue(errormsg.contains(constants.UserEmamilDoesntExist));
	}

}
