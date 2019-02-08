package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePagePOF;
import pageObjects.LoginPagePOF;

import org.junit.runner.RunWith;

import com.javacoder.BrowserInvokation;

@RunWith(Cucumber.class)
public class StepDefination  extends BrowserInvokation{

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Given("^Click on Login link in home page to land on secure sign in page$")
	public void click_on_Login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		HomePagePOF homePage = new HomePagePOF(driver);
		if(homePage.getpopupSize()>0){
			homePage.getPopup().click();
		}
		homePage.loginLink().click();
	}
	

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPagePOF loginPage = new LoginPagePOF(driver);
		loginPage.emailTxtBox().sendKeys(username);
		loginPage.passwordTxtBox().sendKeys(password);
		loginPage.logInButton().click();
    }


	@Then("^Very the user is successfully logged in$")
	public void very_the_user_is_successfully_logged_in() throws Throwable {
		System.out.println("Logged in successfully");
	}
	  @And("^Close browsers$")
	    public void close_browsers() throws Throwable {
		  driver.quit();
	    }
   
}