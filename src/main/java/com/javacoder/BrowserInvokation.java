package com.javacoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInvokation {
	protected static WebDriver driver;

	public static WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\devda\\EE-workspace\\TestFrameworke2e\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			String driverKey = "webdriver.chrome.driver";
			String driverPath = "C:\\Users\\devda\\Documents\\Udemy\\Selenium\\chromedriver_win32\\chromedriver.exe";
			System.setProperty(driverKey, driverPath);

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

		} else if (browserName.equals("IE")) {

		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;
	}

}
