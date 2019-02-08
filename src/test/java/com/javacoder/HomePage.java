package com.javacoder;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePagePOF;

public class HomePage extends BrowserInvokation {
	private static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void invokeBrowser() throws IOException {
		driver = initializeDriver();
		log.info("The driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to home page");

	}

	@Test(priority = 1)
	public void validateText() {
		HomePagePOF homePage = new HomePagePOF(driver);
		Assert.assertEquals(homePage.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
	}

	@AfterTest
	public void tearDown() {
		
			driver.close();
			driver=null;
		
	}

}
