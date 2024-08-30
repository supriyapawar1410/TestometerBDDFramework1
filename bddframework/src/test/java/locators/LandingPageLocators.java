package locators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Utilities.Logs;
import Utilities.WebDriverActions;


public class LandingPageLocators extends WebDriverActions {
	
	private By logInButton= By.xpath("//a[@aria-label='Sign in']");
	
	private By popUp= By.xpath("//button[@aria-label='Dismiss sign-in info.']");
	

	public void clicklogInButton()
	{
		WaitUntilElementToBeClickable(logInButton).click();
	}
	
	public void verifyLandingPage()
	{
		Assert.assertEquals(getCurrentUrl(), "https://www.booking.com/");
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
	        }catch(NoSuchElementException ex)
	        {
	        	Logs.getLog().getLogger("LandingPageLocators").error("popup is not displayed");
	        }
	        
			
	}
}
