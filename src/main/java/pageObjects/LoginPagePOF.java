package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javacoder.BrowserInvokation;

public class LoginPagePOF<WebElements> {

	WebDriver driver;

	public LoginPagePOF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	WebElement emailTxtBox;
	
	@FindBy(id = "user_password")
	WebElement passwordTxtBox;

	@FindBy(xpath="//input[@value='Log In']")
	WebElement logInButton;
		
	public WebElement emailTxtBox() {
		return emailTxtBox;
	}
	public WebElement passwordTxtBox() {
		return passwordTxtBox;
	}
	
	public WebElement logInButton() {
		return logInButton;
	}
	

}
