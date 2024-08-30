package stepDefinitions;

import io.cucumber.java.en.Then;
import locators.PropertyTypeLocators;

public class PropertTypeStepDefinition {
	
	PropertyTypeLocators PropertyType= new PropertyTypeLocators();
	
	@Then("^I see Browse By Property Types (.*)$")
	public void verifyPropertyType(String popertyName)
	{
		
		PropertyType.verifyPropertyType(popertyName);
	}

}
