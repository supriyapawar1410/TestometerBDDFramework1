package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import locators.LandingPageLocators;

public class LandingPageStepDefinitions 
{
	LandingPageLocators landingpage= new LandingPageLocators();
	
	@Given("^I am on the landing page$")
	public void verifyLandingPage()
	{
		landingpage.verifyLandingPage();
	}
	
	@Then("^I see the features called (.*)$")
	public void verifyFeaturesOnLandingPage(String featureName) {
		landingpage.verifyFeatures(featureName);
	}

	@And("^I close the popup when I see it$")
	public void closePopup() throws InterruptedException
	{
		landingpage.closePopupIfDisplayed();
	}
}
