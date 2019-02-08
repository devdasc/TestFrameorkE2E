package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javacoder.BrowserInvokation;

public class HomePagePOF {

	WebDriver driver;

	public HomePagePOF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement loginLink;
	
	//@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/h2[1]")
	WebElement getTitle;
	
	/*@FindBy(xpath="//button[text()='NO THANKS']")
	WebElement clickNoThanks;*/
	By popup=By.xpath("//button[text()='NO THANKS']");

	public WebElement loginLink() {
		return loginLink;
	}
	public WebElement getTitle() {
		return getTitle;
	}
	public int getpopupSize(){
		return driver.findElements(popup).size();
	}
	public WebElement getPopup() {
		return driver.findElement(popup);
	}

}
