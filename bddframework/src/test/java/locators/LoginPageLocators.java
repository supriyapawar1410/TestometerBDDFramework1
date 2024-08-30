package locators;

import org.junit.Assert;
import org.openqa.selenium.By;


import Utilities.WebDriverActions;


public class LoginPageLocators extends WebDriverActions {
	
	private By userName= By.name("username");
	private By passWord= By.name("password");
	private By loginButton= By.xpath("//button[@type='submit']");
	private By loginuserName= By.xpath("//div[text()='Your account']");
	private By invalidEmailErrorMessage= By.id("username-note");
	private By invalidPasswordErrorMessage= By.id("password-note");
	

	public void enterUsername(String username)
	{
		WaitUntilVisibilityOfElementLocated(userName).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		WaitUntilVisibilityOfElementLocated(passWord).sendKeys(password);
	}
	
	public void ClickLoginButton()
	{
		WaitUntilElementToBeClickable(loginButton).click();
	}
	
	public void verifyUserIsLoggedIn(String userName)
	{
		String loggedInUserName= WaitUntilVisibilityOfElementLocated(loginuserName).getText();
		Assert.assertEquals(loggedInUserName,userName);
	}
	
	public void verifyInvalidEmailMessage()
	{
		Assert.assertTrue(WaitUntilVisibilityOfElementLocated(invalidEmailErrorMessage).isDisplayed());
	}
	
	public void verifyInvalidPasswordMessage()
	{
		Assert.assertTrue(WaitUntilVisibilityOfElementLocated(invalidPasswordErrorMessage).isDisplayed());
	}
	
}
