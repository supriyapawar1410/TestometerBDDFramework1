package locators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import Utilities.Logs;
import Utilities.WebDriverActions;


public class LandingPageLocators extends WebDriverActions {
	
	private By logInButton= By.xpath("//a[@aria-label='Sign in']");
	
	private By popUp=By.xpath("//button[starts-with(@aria-label, 'Dismiss')]");
	
	private By staysOption = By.id("accommodations");

	private By flightsOption = By.id("flights");

	private By packagesOption = By.id("packages");

	private By carsOption = By.id("cars");

	private By attractionOption = By.id("attractions");

	private By taxisOption = By.id("airport_taxis");
	
	

	public void clicklogInButton()
	{
		WaitUntilElementToBeClickable(logInButton).click();
	}
	
	public void verifyLandingPage()
	{
		Assert.assertEquals(getCurrentUrl(), "https://www.booking.com/");
	}
	
	public void verifyFeatures(String featureName) {
		Assert.assertTrue(WaitUntilVisibilityOfElementLocated(getFeatureByName(featureName)).isDisplayed());
	}
	
	public void closePopupIfDisplayed() throws InterruptedException
	{
		try {
        	Thread.sleep(5000);
		       
	        WebElement crossPopup= WaitUntilElementToBeClickable(popUp);
	        
	        if(crossPopup.isDisplayed())
	        {
	        	crossPopup.click();
	        }
	        }catch(TimeoutException ex)
	        {
	        	Logs.getLog().getLogger("LandingPageLocators").error("popup is not displayed");
	        }
	        
	}
	
	public By getFeatureByName(String featureName) {

		switch(featureName) {

		case "Stays":
			return staysOption;

		case "Flights":
			return flightsOption;

		case "Flights+Hotel":
			return packagesOption;

		case "Car rentals":
			return carsOption;

		case "Attractions":
			return attractionOption;

		case "Airport taxis":
			return taxisOption;

		default: return null;
		}

	}
}
