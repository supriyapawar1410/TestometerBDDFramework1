package Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//Multithreaded object
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>(); 
	
	//object of singleton class DriverFactory
	private static DriverFactory  instance= new DriverFactory();
	
	//Constructor
	private DriverFactory()
	{
	}

	public WebDriver getWebDriver()
	{
		return driver.get();
	}


	public static DriverFactory getInstance() 
	{
		return instance;
	}

	public void setWebDriver(WebDriver driverParam)
	{
		driver.set(driverParam);
	}
	
	public void closeBrowser()
	{
	   driver.get().quit();
	   driver.remove();
	}

}
