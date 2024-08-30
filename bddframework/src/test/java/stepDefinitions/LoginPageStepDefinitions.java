package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.LandingPageLocators;
import locators.LoginPageLocators;


public class LoginPageStepDefinitions {
	

LoginPageLocators register= new LoginPageLocators();
LandingPageLocators  landingPage= new LandingPageLocators();


@Given("^I click Login$")
public void clickMyAccount()
{
	landingPage.clicklogInButton();
}

 
@When("^I enter username as (.*)$")
public void enterUserName(String username)
{
	register.enterUsername(username);
	register.ClickLoginButton();
}

@And("^I enter password as (.*)$")
public void enterPassword(String password)
{
	register.enterPassword(password);
	
}

@And("^I click on login button$")
public void clickOnLoginButton()
{
	register.ClickLoginButton();
}

@Then("^I see (.*) is displayed$")
public void VerifyDashboardPage(String userName)
{
	register.verifyUserIsLoggedIn(userName);
}	

@Then("^I verify that invalid Email address error message shown to user$")
public void validateInvalidErrorMessage()
{
	register.verifyInvalidEmailMessage();
}

@Then("^I verify that invalid password error message shown to user$")
public void validateInvalidPasswordMessage()
{
	register.verifyInvalidPasswordMessage();
}


}


 