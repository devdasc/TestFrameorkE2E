package com.javacoder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePagePOF;
import pageObjects.LoginPagePOF;

public class LoginPage extends BrowserInvokation {
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());

	@BeforeTest
	public void invokeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("The driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to home page");

	}

	@DataProvider
	public Object[][] getData() {
		// rows stands for how many different data types should the test run on
		// cols stand for how many values for each test
		// 0th row
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@abc.com";
		data[0][1] = "12345";
		// 1st row
		data[1][0] = "abcd@abc.com";
		data[1][1] = "123456";
		return data;
	}

	@Test(priority = 1)
	public void clickLoginLink() throws IOException {
		HomePagePOF homePage = new HomePagePOF(driver);
		homePage.loginLink().click();
		log.info("clicked on login link");

	}

	@Test(dataProvider = "getData", priority = 2)
	public void getLogIn(String userName, String password) {
		LoginPagePOF loginPage = new LoginPagePOF(driver);
		loginPage.emailTxtBox().sendKeys(userName);
		loginPage.passwordTxtBox().sendKeys(password);
		loginPage.logInButton().click();
		loginPage.emailTxtBox().clear();
		loginPage.passwordTxtBox().clear();
		log.info("logging in with 2 different users");
	}

	@AfterTest
	public void tearDown() {
		
			driver.close();
			driver=null;
		

	}
}
