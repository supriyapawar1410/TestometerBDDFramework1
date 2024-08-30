package locators;

import org.openqa.selenium.By;

import Utilities.WebDriverActions;

public class PropertyTypeLocators extends WebDriverActions 
{
	
	
	private By getPropertyType(String propertyName)
	{
		return By.xpath("//div[@data-testid='webcore-carousel-title' and text()='"+propertyName+"']");
		
	}
	
	public void verifyPropertyType(String propertyName)
	{
		WaitUntilVisibilityOfElementLocated(getPropertyType(propertyName));
	}
}
