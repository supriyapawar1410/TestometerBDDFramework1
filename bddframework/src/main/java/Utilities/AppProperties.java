package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppProperties 
{
	
	
	public static String getProperty(String filePath, String propertyName)
	{
		String property=null;
		
		try
		{
			File file= new File(filePath);
			FileReader fileReader= new FileReader(file); 
			
			Properties properties= new Properties();
			properties.load(fileReader);
			
			property= properties.getProperty(propertyName);
			
			Logs.getLog().getLogger("AppProperties").info("Successful to get property by name :" +propertyName);;
			
		}catch(IOException ex)
		{
			Logs.getLog().getLogger("AppProperties").error("Failed to get property by name :" +ex.getMessage());
			
		}
		
		if(property != null)
		{
			Logs.getLog().getLogger("AppProperties").info("success reading property :" +property);
		}
		else
		{
			Logs.getLog().getLogger("AppProperties").error("Failed to get property by name :" +property);
		}
		return property;
		
	
		
	}
	

}
