package Utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverActions {
	
	private WebDriver driver= DriverFactory.getInstance().getWebDriver();
	private JavascriptExecutor js= (JavascriptExecutor) driver;
	
	//long timeOut= Long.parseLong(AppProperties.getProperty("src/test/resources/test.properties", "timeOut"));
	
	long timeOut= Long.parseLong(System.getProperty("timeOut"));
	
	 //long timeOutInMilis= Long.parseLong(AppProperties.getProperty("src/test/resources/test.properties", "timeOutInMilis"));
	
	long timeOutInMilis=  Long.parseLong(System.getProperty("timeOutInMilis"));
	
	private WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeOut)); 
	
	public void landingPage()
	{
		driver.get(AppProperties.getProperty("src/test/resources/test.properties", "siteUrl"));
	}
	
	public WebElement WaitUntilElementToBeClickable(By locator)
	{
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
		executionOrder(element);
		return element;
	}
	
	public WebElement WaitUntilVisibilityOfElementLocated(By locator)
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		executionOrder(element);
		return element;	}
	
    public void ScrollToElement(WebElement element) 
    {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void HighlightElement(WebElement element) 
	{
		js.executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
	
	public void removeHighlightElement(WebElement element) 
	{
		js.executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:white')", element);
	}
	
	public void pause()
	{
		try {
			TimeUnit.MILLISECONDS.sleep(timeOutInMilis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logs.getLog().getLogger("WebDriverActions").error("Error: failed to wait" +e.getMessage());
		
		}
		
	}
	
	public void executionOrder(WebElement element)
   {
		ScrollToElement(element);
		HighlightElement(element);
		pause();
		removeHighlightElement(element);
		pause();
		
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	

}
