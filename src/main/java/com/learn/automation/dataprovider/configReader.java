package com.learn.automation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class configReader {

	static String value = null;

	@Test
	public static String getProperty(String key) throws IOException {
		File src = new File(System.getProperty("user.dir") + "/config/config.properties ");
		FileInputStream fis = new FileInputStream(src);

		Properties pro = new Properties();
		pro.load(fis);

		value = pro.getProperty(key);

		return value;
	}
}
