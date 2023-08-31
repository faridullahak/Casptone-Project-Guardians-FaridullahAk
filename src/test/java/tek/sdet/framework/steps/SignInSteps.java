package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGenerator;

public class SignInSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@Given("User is on retail website homepage")
	public void userIsOnRetailWebsiteHomepage() {
		Assert.assertTrue(pomFactory.retailHomePage().tekschoolLogo.isDisplayed());
		logger.info("TEKSCHOOL logo is displayed");
	}

	@When("User click on the login link")
	public void userClickOnTheLoginLink() {
		click(pomFactory.retailSignInPage().signInLink);
		logger.info("Login Link was clicked successfully");
	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(pomFactory.retailSignInPage().emailField, email);
		sendText(pomFactory.retailSignInPage().passwordField, password);
		logger.info("Email and Password were entered successfully");
	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(pomFactory.retailSignInPage().loginBttn);
		logger.info("Login button was clicked successfully");
	}
	
	@Then("Verify user is logged in")
	public void verifyUserIsLoggedIn() {
		Assert.assertTrue(pomFactory.retailSignInPage().logoutBttn.isDisplayed());
		  logger.info("User is logged in successfully");
	}

	

	// register
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(pomFactory.retailSignInPage().newAccountBttn);
		logger.info("Create new account bttn clicked successfully");   
	}
	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> accountInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.retailSignInPage().nameInputField, accountInfo.get(0).get("name"));
		sendText(pomFactory.retailSignInPage().emailInputField, DataGenerator.emailGenerator());
		sendText(pomFactory.retailSignInPage().passwordInputField, accountInfo.get(0).get("password"));
		sendText(pomFactory.retailSignInPage().confirmPassInputField, accountInfo.get(0).get("confirmPassword"));
		logger.info("Information was successfully entered");
	}
	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(pomFactory.retailSignInPage().signupBttn);
		logger.info("Signup button was clicked sucessfully");    
	}
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(pomFactory.retailSignInPage().yourProfileText.isDisplayed());
		logger.info("User account is created successfully");   
	}
	
	}

