package Utilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public WebDriver getWebDriverSession() throws IOException
	{

        WebDriver driver = null;
        
        AppProperties  appProperties= new AppProperties();
        //String browserName= appProperties.getProperty("src/test/resources/test.properties","browser");
        
       String browserName= System.getProperty("browser");
        
        try {
        	
        	if(browserName!=null)
        	{
        		if(browserName.equalsIgnoreCase("Chrome"))
        		{
        			WebDriverManager.chromedriver().setup();
        			driver= new ChromeDriver();
        			
        		}else if(browserName.equalsIgnoreCase("Firefox"))
        		{
        			WebDriverManager.firefoxdriver().setup();
        			driver= new FirefoxDriver();
        			
        		}else if(browserName.equalsIgnoreCase("Safari"))
        		{
        			WebDriverManager.safaridriver().setup();
        			driver= new SafariDriver();
        			
        		}else
        		{
        			Logs.getLog().getLogger("WebDriverFactory").error("No driver available");
        			
        		}
        	}
        	
        }catch(Exception ex)
        {
        	
        	Logs.getLog().getLogger("WebDriverFactory").error("Exception");
        	
        }
        
        Logs.getLog().getLogger("WebDriverFactory").error("getWebDriverSession is success");
          return driver;
	}

}
