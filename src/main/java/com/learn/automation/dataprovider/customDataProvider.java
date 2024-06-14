package com.learn.automation.dataprovider;

import org.testng.annotations.DataProvider;

public class customDataProvider {

	@DataProvider(name = "login")
	public static Object[][] getLogindata() {

		Object[][] arr = ExcelReader.getdatafromsheet("users");
		return arr;
	}
}
