package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import locators.LandingPageLocators;

public class LandingPageStepDefinitions 
{
	LandingPageLocators landingpage= new LandingPageLocators();
	
	@Given("^I am on the landing page$")
	public void verifyLandingPage()
	{
		landingpage.verifyLandingPage();
	}

	@And("^I close the popup when I see it$")
	public void closePopup() throws InterruptedException
	{
		landingpage.closePopupIfDisplayed();
	}
}
