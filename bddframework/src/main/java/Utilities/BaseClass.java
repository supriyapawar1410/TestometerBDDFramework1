package Utilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.bytebuddy.jar.asm.Type;

public class BaseClass {

	AppProperties appproperties= new AppProperties();
	WebDriverFactory webdriverfactory= new WebDriverFactory();
	
	 @Before
      public void launchSession() throws IOException
      {
    	  DriverFactory.getInstance().setWebDriver(webdriverfactory.getWebDriverSession());
    	  DriverFactory.getInstance().getWebDriver().manage().window().maximize();
    	  DriverFactory.getInstance().getWebDriver().get(appproperties.getProperty("siteUrl", "src/test/resources/test.properties"));
    	  
    	  Logs.getLog().getLogger().info("Launch seeion is success");
    	  
      }
      
	 @After
      public void closeSession(Scenario scenario)
      {
    	  WebDriver currentDriver= DriverFactory.getInstance().getWebDriver();
    	  
    	  if(scenario.isFailed())
    	  {
    		  byte[] scrrenshot= ((TakesScreenshot)currentDriver).getScreenshotAs(OutputType.BYTES);
    		  scenario.attach(scrrenshot, "image/png", scenario.getName());
    		  Logs.getLog().getLogger().info("scrrenshot is captured");
    	  }
    	  
    	  DriverFactory.getInstance().closeBrowser();
    	  Logs.getLog().getLogger().info("Clearsession is success");
      }
}
