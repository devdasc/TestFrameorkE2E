package com.javacoder;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePagePOF;
import pageObjects.LoginPagePOF;



public class HomePage  extends BrowserInvokation{
	
	public HomePage() throws IOException {
		driver = initializeDriver();	
	}
	
	@DataProvider
	public Object[][] getData() {
		// rows stands for how many different data types should the test run on
		// cols stand for how many values for each test
		//0th row
		Object[][] data = new Object[2][2];
		data[0][0]="abc@abc.com";
		data[0][1]="12345";
		//1st row
		data[1][0]="abcd@abc.com";
		data[1][1]="123456";
		return data;
	}

	@Test(priority=1)
	public void basePageNavigation() throws IOException {
		//driver = initializeDriver();
		String url = "http://www.qaclickacademy.com/";
		//getDriver();
		driver.get(url);
	}
	@Test(priority=2)
	public void validateText() {
		HomePagePOF homePage = new HomePagePOF(driver);
		Assert.assertEquals(homePage.getTitle().getText(),"FEATURED COURSES");
	}
	
	@Test(priority=3)
	public void clickLoginLink() throws IOException {
		HomePagePOF homePage = new HomePagePOF(driver);
		homePage.loginLink().click();
		
	}
	@Test(dataProvider="getData",priority=4)
	public void getLogIn(String userName, String password) {
		LoginPagePOF loginPage = new LoginPagePOF(driver);
		loginPage.emailTxtBox().sendKeys(userName);
		loginPage.passwordTxtBox().sendKeys(password);
		loginPage.logInButton().click();
		loginPage.emailTxtBox().clear();
		loginPage.passwordTxtBox().clear();
	}

}
