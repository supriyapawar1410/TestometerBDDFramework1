package Utilities;

public class Test {
	
	public static void main(String[] args) {
		
		AppProperties appproperties= new AppProperties();
		
		appproperties.getProperty("src/test/resources/test.properties", "siteUrl");
	}

}
